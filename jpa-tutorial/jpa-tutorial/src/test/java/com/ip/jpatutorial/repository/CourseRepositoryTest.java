package com.ip.jpatutorial.repository;

import com.ip.jpatutorial.entity.Course;
import com.ip.jpatutorial.entity.CourseMaterial;
import com.ip.jpatutorial.entity.Student;
import com.ip.jpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach((course -> System.out.println(course.toString())));
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Vishal")
                .lastName("Patil")
                .build();

        Course course = Course.builder()
                .title("Spring Boot")
                .credit(10)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPaginated(){
        // Implements pagination, pageNumber and pageSize are the parameters
        Pageable pageable = PageRequest.of(0,3);

        List<Course> courses = courseRepository.findAll(pageable).getContent(); // get page content
        courses.forEach((course -> System.out.println(course.toString())));

        System.out.println(" TOTAL PAGES >>>>>>>>>>>>>>>>>>>> " + courseRepository.findAll(pageable).getTotalPages());
    }

    @Test
    public void findAllPaginatedSorted(){
        // Pageable also has sorting capabilities
        Pageable sortByTitle = PageRequest.of(0,4, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,4, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,4,Sort.by("credit").descending().and(Sort.by("title")));

        List<Course> titleSorted = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        titleSorted.forEach((course -> System.out.println(course.toString())));

    }

    @Test
    public void printFindByContainingTitle(){
        Pageable pageable = PageRequest.of(0,4, Sort.by("credit").descending());
        List<Course> coursesByContainingTitle = courseRepository.findByTitleContaining("n", pageable).getContent();
        coursesByContainingTitle.forEach((course -> System.out.println(course.toString())));
    }

    @Test
    public void createCourseWithStudent(){

        Teacher teacher = Teacher.builder()
                .firstName("Krishna")
                .lastName("Yadav")
                .build();



        Student student = Student.builder()
                .firstName("Amar")
                .lastName("Singh")
                .emailId("amar2@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(9)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}
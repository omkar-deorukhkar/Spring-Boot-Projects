package com.ip.jpatutorial.repository;

import com.ip.jpatutorial.entity.Course;
import com.ip.jpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("Electronics")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
//                .courses(List.of(course))
                .firstName("Alok")
                .lastName("Sharma")
                .build();

        teacherRepository.save(teacher);
    }

}
package com.ip.jpatutorial.repository;

import com.ip.jpatutorial.entity.Guardian;
import com.ip.jpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("a@gmail.com")
                .firstName("a")
                .lastName("b")
//                .guardianEmail("z@gmail.com")
//                .guardianName("z")
//                .guardianMobile("1234567890")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("1234567890")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Wick")
                .emailId("john@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void deleteStudent() {
        studentRepository.deleteById(1L);
    }

    @Test
    public void printStudentList() {
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach((student) -> System.out.println(student.toString()));

    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentsByFirstname = studentRepository.findByFirstName("John");
        studentsByFirstname.forEach((student) -> System.out.println(student.toString()));
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentByFirstNameContaining = studentRepository.findByFirstNameContaining("X");
        System.out.println("Student List Is : ");
        studentByFirstNameContaining.forEach((student) -> System.out.println(student.toString()));
    }

    @Test
    public void printStudentLastNameNotNull() {
        List<Student> stuentByLastNameNotNull = studentRepository.findByLastNameNotNull();
        stuentByLastNameNotNull.forEach((student) -> System.out.println(student.toString()));
    }

    @Test
    public void findByGuardianName() {
        List<Student> studentByGuardianName = studentRepository.findByGuardianName("Nikhil");
        studentByGuardianName.forEach((student) -> System.out.println(student.toString()));
    }

    @Test
    public void findByFirstNameAndLastName() {
        Student studentByFirstNameAndLastName = studentRepository.findByFirstNameAndLastName("John", "Wick");
        System.out.println(studentByFirstNameAndLastName.toString());
    }

    @Test
    public void findStudentByEmail() {
        Student studentByEmailId = studentRepository.findByEmailId("a@gmail.com");
        System.out.println(studentByEmailId.toString());
    }

    @Test
    public void findFirstNameByEmailId(){
        String firstNameByEmailId = studentRepository.findFirstNameByEmailId("a@gmail.com");
        System.out.println(firstNameByEmailId);

    }
    
    @Test
    public void findStudentByEmailIdNative(){
        Student studentByEmailIdNative = studentRepository.findByEmailIdNative("a@gmail.com");
        System.out.println(studentByEmailIdNative.toString());
        System.out.println(studentByEmailIdNative.getClass().getName());
    }

    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentNameByEmailId("Jack", "john@gmail.com");
    }

}
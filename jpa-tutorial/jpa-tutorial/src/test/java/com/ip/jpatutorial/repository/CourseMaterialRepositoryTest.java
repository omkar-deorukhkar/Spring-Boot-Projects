package com.ip.jpatutorial.repository;

import com.ip.jpatutorial.entity.Course;
import com.ip.jpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        courseMaterials.forEach((courseMaterial -> System.out.println(courseMaterial.toString())));

    }

}
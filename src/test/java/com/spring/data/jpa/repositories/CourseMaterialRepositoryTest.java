package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.Course;
import com.spring.data.jpa.entity.CourseMaterial;
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
        Course course =
                Course
                        .builder()
                        .title("DSA")
                        .credit("9")
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial
                        .builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterial(){
        List<CourseMaterial> materials =
                courseMaterialRepository.findAll();
        System.out.println(materials);
    }

    @Test
    public void saveCourseMaterialWithoutCourse(){
        CourseMaterial courseMaterial =
                CourseMaterial
                        .builder()
                        .url("www.google.com")
                        .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void saveCourseMaterialWithCourse(){

        Course course =
                Course
                        .builder()
                        .title("DSA")
                        .credit("9")
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial
                        .builder()
                        .url("www.google.com")
                        .course(course)
                        .build();
        courseMaterialRepository.save(courseMaterial);
    }
}
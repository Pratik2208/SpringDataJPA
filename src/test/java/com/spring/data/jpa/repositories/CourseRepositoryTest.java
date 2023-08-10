package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveTeacherWithCourse(){

        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Ritesh")
                        .lastName("Patel")
                        .build();

        Course course =
                Course
                        .builder()
                        .credit("9")
                        .title("CN")
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){

        Pageable firstPageWithThreeRecords =
                 PageRequest.of(0,2);
        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();
        System.out.println(courses);
    }
    @Test
    public void findAllPaging(){
        Pageable findBySortingCredit =
                PageRequest.of(0,4, Sort.by("courseId").descending());
        List<Course> courses =
                courseRepository.findAll(findBySortingCredit).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

//        CourseMaterial courseMaterial =
//                CourseMaterial
//                        .builder()
//                        .url("www.daa.com")
//                        .build();

        Guardian guardian =
                Guardian
                        .builder()
                        .mobile("1234567890")
                        .name("Stepehen")
                        .email("Stephen@gmail.com")
                        .build();

        Student student =
                Student
                        .builder()
                        .firstName("Tim")
                        .lastName("Cook")
                        .emailId("tim@gmail.com")
                        .guardian(guardian)
                        .build();

        Teacher teacher =
                Teacher
                        .builder()
                        .firstName("Nikita")
                        .lastName("Bhatt")
                        .build();

        Course course =
                Course
                        .builder()
                        .title("DAA")
                        .credit("10")
                        //.courseMaterial(courseMaterial)
                        .students(List.of(student))
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }
}
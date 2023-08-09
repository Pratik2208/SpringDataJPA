package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entity.Guardian;
import com.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

//    @Test
//    public void saveStudent(){
//        Student student =
//                Student
//                        .builder()
//                        .firstName("john")
//                        .lastName("dao")
//                        .emailId("john@gmail.com")
//                        //.guardianEmail("jonathan@gmail.com")
//                        //.guardianName("jonathan")
//                        //.guardianMobile("8140619674")
//                        .build();
//        repository.save(student);
//    }

    @Test
    public void saveStudentWithGuardianDetails(){

        Guardian guardian =
                Guardian
                        .builder()
                        .email("paul@gmail.com")
                        .name("paul")
                        .mobile("8140619674")
                        .build();

        Student student =
                Student
                        .builder()
                        .firstName("tom")
                        .lastName("cruise")
                        .emailId("tom@gmail.com")
                        .guardian(guardian)
                        .build();

        repository.save(student);
    }

    // JPA custom methods
    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                repository.findByFirstName("john");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                repository.findByFirstNameContaining("to");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContainingAndLastNameContaining(){
        List<Student> students =
                repository.findByFirstNameContainingAndLastNameContaining("to","cruise");
        System.out.println(students);
    }

    // JPQL
    @Test
    public void getStudentByEmailAddressQuery(){
        Student student =
                repository.getStudentByEmailAddress("john@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeQuery(){
        List <Student> students =
                repository.getStudentByEmailAddressNative("john@gmail.com");
        System.out.println(students);
    }

    @Test
    public void updateStudentNameBasedOnEmailId(){
        int value
                = repository.updateStudentNameByEmailId("lilly","john@gmail.com");
        System.out.println(value);
    }
}
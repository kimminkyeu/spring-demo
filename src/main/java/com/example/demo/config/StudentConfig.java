package com.example.demo.config;

import com.example.demo.dto.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
        Student s1 = new Student(
                "Kim",
                "minky@gmail.com",
                LocalDate.of(1990, Month.APRIL, 4));
        Student s2 = new Student(
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2017, Month.JANUARY, 3));
        repository.saveAll(List.of(s1, s2));
        };
    }
}

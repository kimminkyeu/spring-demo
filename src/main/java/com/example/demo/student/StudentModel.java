package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // == @Component랑 같은 표현.
public class StudentModel
{
    public List<Student> getStudents()
    {
        // 1. 아래처럼 하면 입력 실수가 일어나지 않을까.
        Student student = new Student(
                1L,
                "Kim",
                "minky@gmail.com",
                42,
                LocalDate.of(2007, Month.APRIL, 4)
        );
        return List.of(student);
    }

}

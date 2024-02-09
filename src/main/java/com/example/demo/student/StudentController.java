package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 혹시 이 어노테이션을 통해 바인딩이 일어나는걸까?
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{
    // constant variable in java (same as const)
    private final StudentModel studentModel;

    // Model 레퍼런스를 Controller에 넣는 이유 (Dependency Injection)
    @Autowired // auto instanciated
    public StudentController(StudentModel studentModel)
    {
        this.studentModel = studentModel;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents()
    {
        return this.studentModel.getStudents();
    }

}

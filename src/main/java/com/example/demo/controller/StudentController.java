package com.example.demo.controller;

import com.example.demo.dto.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/student") // 근데 경로 관리를 어떻게 하는게 깔끔하고 가독성에 좋을까..
public class StudentController {
  private final StudentService studentService; // constant variable in java (same as const)

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public Student getSampleStudent() {
    Student st = new Student("jack", "j@gmail.com", LocalDate.of(1990, Month.APRIL, 10));
    return st;
  }

  @GetMapping(path = "/all")
  public List<Student> getEveryStudents() {
    return studentService.getStudents();
  }

  // email이 이미 존재할 경우, 해당 email을 가진 학생의 정보를 업데이트합니다.
  // eamil이 없을 경우 학생 정보를 새롭게 추가합니다.
  @PostMapping
  public void registerStudent(@RequestBody Student student) { // Request
    studentService.register(student);
  }

  // TODO: 아래 방식은 API 전달 방식이 이상함. 그리고 애초에 id를 왜 받b아?
  //        또, 테스트를 어떻게 진행할 건지도 고민 해봐야 한다.
  @PutMapping(path = "{studentId}")
  public void updateStudent(
      @PathVariable("studentId") Long id,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    this.studentService.update(id, name, email);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long id) {
    this.studentService.delete(id);
  }
}

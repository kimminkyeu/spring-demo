package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // == @Component랑 같은 표현.
public class StudentService {
  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return this.studentRepository.findAll();
  }

  public void register(Student student) {
    Optional<Student> studentOptional =
        this.studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email already exists");
      // exception 이 자동 500 Response로 보내진다.
    }
    studentRepository.save(student);
  }

  public void delete(Long id) {
    boolean exists = studentRepository.existsById(id);
    if (!exists) {
      throw new IllegalStateException("student id " + id + " does not exist");
    }
    studentRepository.deleteById(id);
  }

  // TODO: 나중에 코드 바꿀 것. Id를 제외하고, 유일한 역할을 하는 친구는 email.
  //       띠라서, 하단 함수는 id를 받지 말고 email -> name 순으로 두개만 받아야 함.
  //       email을 가지고 user를 찾고, 그 뒤 업데이트를 하는게 맞음.
  @Transactional
  public void update(Long studentId, String name, String email) {
    Student student =
        studentRepository
            .findById(studentId)
            .orElseThrow(
                () -> new IllegalStateException("student id " + studentId + " does not exist"));

    if ((name != null) && (!name.isEmpty()) && (!Objects.equals(student.getName(), name))) {
      student.setName(name);
    }
    if ((email != null) && (!email.isEmpty()) && (!Objects.equals(student.getEmail(), email))) {
      student.setEmail(email);
    }
  }
}

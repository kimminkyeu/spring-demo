package com.example.demo.dto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
  // NOTE: 대체 아래 코드가 뭘 해주는건데? 예제에서 알려주는대로 했다만,
  // allocationSize를 10으로 바꿔도 뭐 바뀌는게 없네?
  @Id
  @SequenceGenerator(
      name = "student_sequence",
      sequenceName = "student_sequence",
      //            allocationSize = 10 // 보니까 이게 증가량 (1 - 11 - 21 ...)
      allocationSize = 1 // 보니까 이게 증가량 (1 - 11 - 21 ...)
      )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;

  private String name;
  private String email;
  private LocalDate dateOfBirth;
  @Transient private Integer hiddenValue;

  public Student() {
    System.out.println("Student default constructor");
  }

  public Student(Long _id, String _name, String _email, LocalDate _dateOfBirth) {
    this.id = _id;
    this.name = _name;
    this.email = _email;
    this.dateOfBirth = _dateOfBirth;
    System.out.println("Student id constructor");
  }

  public Student(String _name, String _email, LocalDate _dateOfBirth) {
    this.name = _name;
    this.email = _email;
    this.dateOfBirth = _dateOfBirth;
    System.out.println("Student no id constructor");
  }

  // NOTE: test 결과. getter를 전부 수집해서, Student를 response로 보낼때
  //       Spring에서 알아서 해당 getter들을 전부 집어넣는다.

  public Integer getHiddenValue() {
    this.hiddenValue = 20;
    return this.hiddenValue;
  }

  public Integer getSomeOther() {
    return 10;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long _id) {
    this.id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String _name) {
    this.name = _name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String _email) {
    this.email = _email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate _dateOfBirth) {
    this.dateOfBirth = _dateOfBirth;
  }

  public Integer GetAgeByBirthDate(LocalDate dateOfBirth) {
    return Period.between(dateOfBirth, LocalDate.now()).getYears();
  }
}

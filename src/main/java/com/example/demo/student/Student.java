package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private Long _id;
    private String _name;
    private String _email;
    private Integer _age;
    private LocalDate _dateOfBirth;

    public Student() {
    }

    public Student(Long _id, String _name, String _email, Integer _age, LocalDate _dateOfBirth) {
        this._id = _id;
        this._name = _name;
        this._email = _email;
        this._age = _age;
        this._dateOfBirth = _dateOfBirth;
    }

    public Student(String _name, String _email, Integer _age, LocalDate _dateOfBirth) {
        this._name = _name;
        this._email = _email;
        this._age = _age;
        this._dateOfBirth = _dateOfBirth;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public Integer getAge() {
        return _age;
    }

    public void setAge(Integer _age) {
        this._age = _age;
    }

    public LocalDate getDateOfBirth() {
        return _dateOfBirth;
    }

    public void setDateOfBirth(LocalDate _dateOfBirth) {
        this._dateOfBirth = _dateOfBirth;
    }
}


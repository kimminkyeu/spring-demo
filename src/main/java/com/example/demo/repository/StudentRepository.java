package com.example.demo.repository;

import com.example.demo.dto.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Query("SELECT s From Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);
}

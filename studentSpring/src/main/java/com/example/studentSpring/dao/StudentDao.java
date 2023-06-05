package com.example.studentSpring.dao;

import com.example.studentSpring.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentDao {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findByAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();



}

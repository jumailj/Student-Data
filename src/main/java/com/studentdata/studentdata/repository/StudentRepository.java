package com.studentdata.studentdata.repository;

import com.studentdata.studentdata.entity.Student; //  get student from the entity/Student.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
    
}

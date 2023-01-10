package com.amit.student.repository;

import com.amit.student.model.JpaStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<JpaStudent, Integer>
{
}

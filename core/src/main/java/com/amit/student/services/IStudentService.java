package com.amit.student.services;

import com.amit.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentService {
     List<Student> getAllStudent();

     Student getStudentById(int id);

     void saveOrUpdate(Student student);

    public void delete(int id);
}

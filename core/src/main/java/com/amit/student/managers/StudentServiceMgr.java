package com.amit.student.managers;

import com.amit.student.exception.RecordNotFoundException;
import com.amit.student.model.Student;
import com.amit.student.services.IStudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceMgr {
    @NotNull
    private final IStudentService studentService;

    @Autowired
    public StudentServiceMgr(@NotNull final IStudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    public Student getStudentById(int id) throws RecordNotFoundException {
        return studentService.getStudentById(id);
    }

    public void saveOrUpdate(Student student) throws RecordNotFoundException{
        studentService.saveOrUpdate(student);
    }

    //deleting a specific record
    public void deleteById(int id) throws RecordNotFoundException {
        studentService.delete(id);
    }
}

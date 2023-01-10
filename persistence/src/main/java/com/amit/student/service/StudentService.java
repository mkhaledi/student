package com.amit.student.service;

import com.amit.student.exception.RecordNotFoundException;
import com.amit.student.model.JpaStudent;
import com.amit.student.model.Student;
import com.amit.student.repository.StudentRepository;
import com.amit.student.services.IStudentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;

    public StudentService(final StudentRepository sr) {
        this.studentRepository = sr;
    }

    //getting all student records
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(jpaStudent -> students.add(jpaStudent.toCore()));
        return students;
    }

    //getting a specific record
    public Student getStudentById(int id) {
        JpaStudent jpaStudent = studentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(
                "Student id '" + id + "' does no exist"));

        return jpaStudent.toCore();
    }

    public void saveOrUpdate(Student student) {
        studentRepository.save(JpaStudent.fromCore(student));
    }

    //deleting a specific record
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}

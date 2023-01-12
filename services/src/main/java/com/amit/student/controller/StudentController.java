package com.amit.student.controller;

import com.amit.student.exception.RecordNotFoundException;
import com.amit.student.managers.StudentServiceMgr;
import com.amit.student.model.Student;
import com.amit.student.service.StudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {
    //autowired the StudentService class

    @NotNull
    private final StudentServiceMgr studentServiceMgr;

    @Autowired
    public StudentController(@NotNull final StudentServiceMgr studentServiceMgr) {
        this.studentServiceMgr = studentServiceMgr;
    }

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping(value = "/student")
    public List<Student> getAllStudent() {
        return studentServiceMgr.getAllStudent();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id) throws RecordNotFoundException {
        return studentServiceMgr.getStudentById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentServiceMgr.deleteById(id);
    }

    //creating post mapping that post the jpaStudent detail in the database
    @PostMapping("/student")
    public int saveStudent(@RequestBody Student student) {
        studentServiceMgr.saveOrUpdate(student);
        return student.getId();
    }
}

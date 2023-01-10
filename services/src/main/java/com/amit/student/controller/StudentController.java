package com.amit.student.controller;

import com.amit.student.model.JpaStudent;
import com.amit.student.model.Student;
import com.amit.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class StudentController
{
    //autowired the StudentService class

    private StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }
    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping(value = "/student")
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }
    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id)
    {
        studentService.delete(id);
    }
    //creating post mapping that post the jpaStudent detail in the database
    @PostMapping("/student")
    public int saveStudent(@RequestBody Student student)
    {
        studentService.saveOrUpdate(student);
        return student.getId();
    }
}

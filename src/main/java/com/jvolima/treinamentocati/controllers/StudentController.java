package com.jvolima.treinamentocati.controllers;

import com.jvolima.treinamentocati.entities.Student;
import com.jvolima.treinamentocati.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.ok().body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.findAllStudents();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        try {
            Student student = studentService.getStudentById(id);

            return ResponseEntity.ok().body(student);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Student> updateIraByStudentId(@PathVariable("id") Integer id, @RequestBody Integer ira) {
        try {
            Student student = studentService.updateIraByStudentId(id, ira);

            return ResponseEntity.ok().body(student);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("Not found")) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.unprocessableEntity().build();
            }
        }
    }
}

package com.jvolima.treinamentocati.services;

import com.jvolima.treinamentocati.entities.Student;
import com.jvolima.treinamentocati.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        student.setIra(20000);
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Student updateIraByStudentId(Integer id, Integer ira) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        if (ira < 0 || ira > 20000) {
            throw new RuntimeException("Unprocessable entity");
        }
        student.setIra(ira);

        return studentRepository.save(student);
    }
}

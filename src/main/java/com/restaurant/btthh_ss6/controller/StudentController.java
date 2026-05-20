package com.restaurant.btthh_ss6.controller;

import com.restaurant.btthh_ss6.entity.Student;
import com.restaurant.btthh_ss6.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository repository;
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping(
            produces = {
                    "application/json",
                    "application/xml"
            }
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // GET BY ID
    @GetMapping(
            value = "/{id}",
            produces = {
                    "application/json",
                    "application/xml"
            }
    )
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }

    // POST
    @PostMapping(
            produces = {
                    "application/json",
                    "application/xml"
            }
    )
    public ResponseEntity<?> create(@RequestBody Student student) {
        student.setId(null);
        Student saved = repository.save(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping(
            value = "/{id}",
            produces = {
                    "application/json",
                    "application/xml"
            }
    )
    public ResponseEntity<?> updateFull(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        Optional<Student> existing = repository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        Student updated = repository.save(student);
        return ResponseEntity.ok(updated);
    }

    // PATCH
    @PatchMapping(
            value = "/{id}",
            produces = {
                    "application/json",
                    "application/xml"
            }
    )
    public ResponseEntity<?> updatePartial(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
    ) {

        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Student student = optionalStudent.get();
        if (updates.containsKey("fullName")) {
            student.setFullName(
                    updates.get("fullName").toString()
            );
        }

        if (updates.containsKey("email")) {
            student.setEmail(
                    updates.get("email").toString()
            );
        }

        if (updates.containsKey("gpa")) {
            student.setGpa(
                    Double.parseDouble(
                            updates.get("gpa").toString()
                    )
            );
        }
        Student updated = repository.save(student);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
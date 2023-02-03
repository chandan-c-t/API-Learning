package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer, Student> db = new HashMap<>();

    public Student getStudent(int admNo) {
        return db.get(admNo);
    }

    //adding info

    public String addStudent(Student student) {
        int admNo = student.getAdmNo();
        db.put(admNo, student);

        return "student added successfully";
    }


    public String updateStudent(int id, int age) {
        if (!db.containsKey(id)) {
            return "invalid id";
        }
        db.get(id).setAge(age);

        return "age updated";
    }

    public String deleteStudent(int id) {
        if (!db.containsKey(id)) {
            return "invalid id";
        }
        db.remove(id);
        return "Student removed";
    }
}

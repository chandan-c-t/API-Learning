package com.avengers.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> db = new HashMap<>();

    //get info
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("admNo") int admNo){
        return db.get(admNo);
    }

    //adding info
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        int admNo = student.getAdmNo();
        db.put(admNo,student);

        return "student added successfully";
    }
}

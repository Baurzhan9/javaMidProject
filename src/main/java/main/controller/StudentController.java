package main.controller;

import main.entity.student;
import main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository StudentRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<student> getAllStudents(){
        return StudentRepository.findAll();
    }

    @GetMapping("/{id}")
    public student getStudentById(@PathVariable Long id){
        return StudentRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<student> getByNameContaining(@RequestParam String name){
        return StudentRepository.findAllByNameContaining(name);
    }

    @PostMapping("")
    public  student createStudent(@RequestBody student student){
        return StudentRepository.saveAndFlush(student);
    }

    @PutMapping("/{id}")
    public  student updateStudent(@PathVariable Long id,
                                @RequestBody student student) {
        student.setId(id);
        return StudentRepository.saveAndFlush(student);
    }

}


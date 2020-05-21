package main.controller;

import main.entity.course;
import main.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository CourseRepository;

    @RequestMapping(value="/qweqwe", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<course> getAllCourses(){
        return CourseRepository.findAll();
    }

    @GetMapping(value = {"/course/{id}"})
    public String home(Model model, HttpServletRequest request, @PathVariable Long id) {
        course obj = CourseRepository.findById(id).get();
        model.addAttribute("examName", obj.getName());
        model.addAttribute("examDesc", obj.getDescription());
        model.addAttribute("examId", obj.getId());
        return "page3";
    }

    @GetMapping("/{id}")
    public course getCourseById(@PathVariable Long id){
        return CourseRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<course> getByNameContaining(@RequestParam String name){
        return CourseRepository.findAllByNameContaining(name);
    }

    @PostMapping("")
    public  course createCourse(@RequestBody course course){
        return CourseRepository.saveAndFlush(course);
    }

    @PutMapping("/{id}")
    public  course updateCourse(@PathVariable Long id,
                                @RequestBody course course) {
        course.setId(id);
        return CourseRepository.saveAndFlush(course);
    }


}


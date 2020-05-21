package main.controller;

import main.entity.course;
import main.entity.lesson;
import main.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LessonController {

    @Autowired
    private LessonRepository LessonRepository;

//    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<lesson> getAllLessons(){
//        return LessonRepository.findAll();
//    }

    @RequestMapping(value = {"/lection/{id}"})
    public String home(Model model, HttpServletRequest request, @PathVariable Long id) {
        lesson obj = LessonRepository.findById(id).get();
        model.addAttribute("title", obj.getTitle());
        model.addAttribute("aim", obj.getAim());
        model.addAttribute("context", obj.getContext());
        return "lection";
    }

//    @GetMapping("/{id}")
//    public lesson getLessonById(@PathVariable Long id){
//        return LessonRepository.findById(id).get();
//    }

//    @GetMapping("/find/")
//    public List<lesson> getByNameContaining(@RequestParam String title){
//        return LessonRepository.findAllByTitleContaining(title);
//    }

//    @PostMapping("")
//    public  lesson createLesson(@RequestBody lesson lesson){
//        return LessonRepository.saveAndFlush(lesson);
//    }
//
//    @PutMapping("/{id}")
//    public  lesson updateLesson(@PathVariable Long id,
//                                @RequestBody lesson lesson) {
//        lesson.setId(id);
//        return LessonRepository.saveAndFlush(lesson);
//    }

}


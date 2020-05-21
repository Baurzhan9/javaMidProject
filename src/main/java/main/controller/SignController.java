package main.controller;


import main.entity.course;
import main.entity.student;
import main.repository.CourseRepository;
import main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller

public class SignController {


    @Autowired
    private StudentRepository StudentRepository;

    @GetMapping(value = {"/sign-up"})
    public String sign(Model model, HttpServletRequest request) {

        return "sign";
    }

    @GetMapping(value = {"/sign-in"})
    public String log(Model model, HttpServletRequest request) {

        return "login";
    }

    @GetMapping(value = {"/profile/{id}"})
    public String profile(Model model, HttpServletRequest request, @PathVariable Long id) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {

            student obj = StudentRepository.findById(id).get();
            model.addAttribute("examName", obj);

            return "page4";
        } else {
            return "login";
        }
    }


}

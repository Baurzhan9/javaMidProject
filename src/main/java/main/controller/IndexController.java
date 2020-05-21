package main.controller;

import main.entity.course;
import main.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CourseRepository CourseRepository;

    @RequestMapping(value = {"", "/index"})
    public String home(Model model, HttpServletRequest request) {
        List<course> counts = new ArrayList<>();
        CourseRepository.findAll().forEach(counts::add);
        model.addAttribute("courses", counts);
        return "index";
    }
}

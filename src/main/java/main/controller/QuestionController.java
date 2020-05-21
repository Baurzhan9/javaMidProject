package main.controller;

import main.entity.question;
import main.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository QuestionRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<question> getAllQuestion(){
        return QuestionRepository.findAll();
    }

    @GetMapping("/{id}")
    public question getQuestionById(@PathVariable Long id){
        return QuestionRepository.findById(id).get();
    }

//    @GetMapping("/find/")
//    public List<exam> getByNameContaining(@RequestParam String name){
//        return QuestionRepository.findAllByNameContaining(name);
//    }

    @PostMapping("")
    public  question createQuestion(@RequestBody question question){
        return QuestionRepository.saveAndFlush(question);
    }

    @PutMapping("/{id}")
    public  question updateQuestion(@PathVariable Long id,
                                @RequestBody question question) {
        question.setId(id);
        return QuestionRepository.saveAndFlush(question);
    }


}


//package main.controller;
//
//import main.entity.answer;
//import main.repository.AnswerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/answer")
//public class AnswerController {
//
////    @Autowired
////    private AnswerRepository AnswerRepository;
////
////    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
////    @ResponseBody
////    public List<answer> getAllAnswer(){
////        return AnswerRepository.findAll();
////    }
////
////    @GetMapping("/{id}")
////    public answer getAnswerById(@PathVariable Long id){
////        return AnswerRepository.findById(id).get();
////    }
//
////    @GetMapping("/find/")
////    public List<exam> getByNameContaining(@RequestParam String name){
////        return AnswerRepository.findAllByNameContaining(name);
////    }
//
//    @PostMapping("")
//    public  answer createAnswer(@RequestBody answer answer){
//        return AnswerRepository.saveAndFlush(answer);
//    }
//
//    @PutMapping("/{id}")
//    public  answer updateAnswer(@PathVariable Long id,
//                                @RequestBody answer answer) {
//        answer.setId(id);
//        return AnswerRepository.saveAndFlush(answer);
//    }
//
//
//}
//

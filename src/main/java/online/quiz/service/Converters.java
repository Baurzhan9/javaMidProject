package online.quiz.service;

import online.quiz.dto.EntryDTO;
import online.quiz.dto.QuestionDTO;
import online.quiz.entity.Answer;
import online.quiz.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class Converters {
    public static List<QuestionDTO> questionsToDTO(List<Question> questions) {
        return questions.stream().map(q -> new QuestionDTO(q)).collect(Collectors.toList());
    }
    
    public static List<EntryDTO> answersToDTO(List<Answer> answers) {
        return answers.stream().map(q -> new EntryDTO(q.getId(), q.getName())).collect(Collectors.toList());
    }
}

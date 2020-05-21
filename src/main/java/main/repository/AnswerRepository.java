package main.repository;

import main.entity.answer;
import main.entity.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<answer, Long> {
//    List<course> findById(Long id);
//    List<Author> findAllByNameContaining(String name);
//
//    List<answer> findByQuestion(question question);
//
//    List<answer> findByQuestionId(Integer questionId);
//
//    List<answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect);
}

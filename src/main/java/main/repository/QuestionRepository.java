package main.repository;

import main.entity.exam;
import main.entity.question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<question, Long> {
//    List<course> findById(Long id);
//    List<Author> findAllByNameContaining(String name);
    List<question> findByExam(exam exam);

    List<question> findByExamId(Integer examId);

    // find first not answered question by exam
    question findFirstByExamAndIdNotIn(exam exam, Set<Integer> ids);

    int countByExam(exam exam);
}
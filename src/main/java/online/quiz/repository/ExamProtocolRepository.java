package online.quiz.repository;

import online.quiz.entity.ExamProtocol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProtocolRepository extends JpaRepository<ExamProtocol, Integer> {}

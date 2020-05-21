package main.repository;

import main.entity.exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<exam, Long> {
//    List<course> findById(Long id);
//    List<Author> findAllByNameContaining(String name);
}

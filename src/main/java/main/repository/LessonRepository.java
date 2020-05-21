package main.repository;

import main.entity.lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<lesson, Long> {
//    List<course> findById(Long id);
    List<lesson> findAllByTitleContaining(String title);

}
package main.repository;

import main.entity.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<course, Long> {
//    List<course> findById(Long id);
    List<course> findAllByNameContaining(String name);


}

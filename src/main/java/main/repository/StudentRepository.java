package main.repository;

import main.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<student, Long> {
    List<student> findAllByNameContaining(String name);
}

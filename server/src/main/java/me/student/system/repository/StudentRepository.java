package me.student.system.repository;

import me.student.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

  @Override
  Optional<Student> findById(Integer integer);

  Optional<Student> findByName(String name);

  boolean existsByEmail(String email);
}

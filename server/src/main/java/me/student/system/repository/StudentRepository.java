package me.student.system.repository;

import me.student.system.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

  @Override
  Optional<Student> findById(Integer integer);

  Optional<Student> findByFirstName(String firstName);

  Optional<Student> findByLastName(String lastName);


  boolean existsByEmail(String email);
}

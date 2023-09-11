package me.student.system.repository;

import me.student.system.model.Student;
import me.student.system.model.Teacher;
import me.student.system.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Integer> {
  Optional<Teacher> findById(Integer integer);

  Optional<Teacher> findByFirstName(String firstName);

  Optional<Teacher> findByLastName(String lastName);

  List<Teacher> findByCourses(Course course);
}

package me.student.system.service;

import me.student.system.dto.CourseDTO;
import me.student.system.dto.TeacherDTO;
import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Course;
import me.student.system.model.Teacher;
import me.student.system.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service

public class TeacherService {

  @Autowired
  private TeacherRepository repository;

  @Transactional
  public Teacher save(@Valid Teacher teacher) {
    return repository.save(teacher);
  }

  @Transactional
  public void remove(@Valid Integer id) {
    if (!repository.existsById(id)) {
      throw new NoSuchUserException("Teacher with ID " + id + " not found");
    }

    repository.deleteById(id);
  }

  public Page<TeacherDTO> findAll(Pageable pageable) {
    Page<Teacher> teachers = repository.findAll(pageable);
    return teachers.map(TeacherDTO::new);
  }

}

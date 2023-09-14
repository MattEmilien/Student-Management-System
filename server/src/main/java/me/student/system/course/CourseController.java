package me.student.system.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/courses")
public class CourseController {

  @Autowired
  private CourseService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasAuthority('course:write')")
  public void add(@RequestBody Course course) {
    service.add(course);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasAuthority('course:write')")
  public void remove(@RequestParam(value = "id") Integer id) {
    service.remove(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasAuthority('course:read')")
  public Page<CourseDTO> findAll(
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "10") int size,
    @RequestParam(name = "sort", defaultValue = "id") String sort) {
    PageRequest pageable = PageRequest.of(page, size, Sort.by(sort));
    return service.findAll(pageable);
  }


  @GetMapping("/id")
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasAuthority('course:read')")
  public Course getCourse(@RequestParam("id") int id) {
    return service.findByID(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasAuthority('course:write')")
  public void updateCourse(@PathVariable("id") int id, @RequestBody Course updatedCourse) {
    service.update(id, updatedCourse);
      
  }

}

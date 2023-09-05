package me.student.system.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    @ElementCollection
    private List<LocalDate> testDates;

    @ManyToMany(mappedBy = "courses")
    private List<Student> studentsEnrolled;


}

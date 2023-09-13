package me.student.system.course;

import lombok.Data;
import me.student.system.users.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Subject is required")
    @Size(min = 6, max = 50, message = "Subject must be between 6 and 50 characters")
    private String subject;

    @NotNull(message = "Name is required")
    @Size(min = 6, max = 50, message = "Name must be between 6 and 50 characters")
    private String name;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    private boolean active;

    @ElementCollection
    private List<LocalDate> testDates;

    @ManyToMany(mappedBy = "courses")
    private List<User> studentsEnrolled;

    @ManyToMany
    @JoinTable(
      name = "course_teacher",
      joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> teachers;

}

package me.student.system.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.student.system.course.Course;
import me.student.system.security.role.UserRole;
import me.student.system.validator.grade.ValidGrade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 6, max = 50)
    @Column(nullable = false)
    private String password;

    @Pattern(regexp = "\\d{10}")
    private String phone;

    @Pattern(regexp = "(Male|Female)")
    @Column(nullable = false)
    private String gender;

    @Past
    private LocalDate dateOfBirth;

    @Size(min = 2, max = 100)
    private String major;

    @NotEmpty
    @Size(min = 2, max = 200)
    private String address;

    @ManyToMany
    @JoinTable(
      name = "user_course",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;


    @ValidGrade
    private double[] grades;

    @Enumerated(EnumType.STRING)
    private UserRole role;


}

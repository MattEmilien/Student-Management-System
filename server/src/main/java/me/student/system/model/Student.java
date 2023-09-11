package me.student.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.student.system.utilities.PasswordUtils;
import me.student.system.validator.model.ValidGrade;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class Student {
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

    @NotNull
    @Size(min = 2, max = 100)
    private String school;

    @NotNull
    @Size(min = 2, max = 100)
    private String major;

    @NotEmpty
    @Size(min = 2, max = 200)
    private String address;

    @ManyToMany
    @JoinTable(
      name = "student_course",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @ManyToMany
    @JoinTable(
      name = "course_teacher",
      joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

    @ValidGrade
    private double[] grades;
    public Student(String plainTextPassword) throws NoSuchAlgorithmException {
        password = PasswordUtils.hashPassword(plainTextPassword, PasswordUtils.generateSalt());
    }

}

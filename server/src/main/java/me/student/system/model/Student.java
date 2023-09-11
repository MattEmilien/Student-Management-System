package me.student.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.student.system.utilities.PasswordUtils;
import me.student.system.validator.model.ValidGrade;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
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
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;

    @Pattern(regexp = "\\d{10}")
    private String phone;

    @Pattern(regexp = "(Male|Female)")
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

    @ValidGrade
    private double[] grades;
    public Student(String plainTextPassword) throws NoSuchAlgorithmException {
        password = PasswordUtils.hashPassword(plainTextPassword, PasswordUtils.generateSalt());
    }

}

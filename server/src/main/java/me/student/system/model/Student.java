package me.student.system.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.student.system.utilities.PasswordUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private double[] grades;
    private String phone;
    private String gender;
    private LocalDate dateOfBirth;
    private String school;
    private String major;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;

    public Student(String plainTextPassword) throws NoSuchAlgorithmException {
        password = PasswordUtils.hashPassword(plainTextPassword, PasswordUtils.generateSalt());
    }

}

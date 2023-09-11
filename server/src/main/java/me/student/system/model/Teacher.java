package me.student.system.model;

import lombok.Data;
import me.student.system.model.Course;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @PositiveOrZero(message = "Age must be a positive or zero value")
    private int age;

    @NotBlank(message = "Address is required")
    private String address;

    @ManyToMany(mappedBy = "teachers")
    private List<Course> courses;



}

package me.student.system.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName, lastName, address;
    private int age;
    @ManyToMany(mappedBy = "teachers")
    private List<Course> classes;
}

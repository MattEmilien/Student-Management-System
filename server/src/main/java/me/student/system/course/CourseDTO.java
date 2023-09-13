package me.student.system.course;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {

    private int id;
    private String subject;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public CourseDTO(Course course) {
        this.subject = subject;
        this.name = name;
    }
}

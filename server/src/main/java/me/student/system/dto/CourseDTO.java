package me.student.system.dto;

import lombok.Data;
import me.student.system.model.Course;

import java.time.LocalDate;
import java.util.List;

@Data
public class CourseDTO {

    private String subject;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public CourseDTO(Course course) {
        this.subject = subject;
        this.name = name;
    }
}

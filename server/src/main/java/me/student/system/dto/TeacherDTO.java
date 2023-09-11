package me.student.system.dto;

import lombok.Data;
import me.student.system.model.Course;
import me.student.system.model.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TeacherDTO {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    private List<Course> classes;

    public TeacherDTO(Teacher teacher) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
}

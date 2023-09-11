package me.student.system.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import me.student.system.model.Student;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class StudentDTO {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String gender;
  private LocalDate dateOfBirth;
  private String school;
  private String major;
  private String address;


  public StudentDTO(Student student) {
    this.id = student.getId();
    this.firstName = student.getFirstName();
    this.lastName = student.getLastName();
    this.email = student.getEmail();
    this.phone = student.getPhone();
    this.gender = student.getGender();
    this.dateOfBirth = student.getDateOfBirth();
    this.school = student.getSchool();
    this.major = student.getMajor();
    this.address = student.getAddress();
  }

}

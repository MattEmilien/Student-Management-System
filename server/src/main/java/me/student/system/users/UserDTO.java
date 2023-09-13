package me.student.system.users;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserDTO {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String gender;
  private LocalDate dateOfBirth;
  private String major;
  private String address;


  public UserDTO(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.email = user.getEmail();
    this.phone = user.getPhone();
    this.gender = user.getGender();
    this.dateOfBirth = user.getDateOfBirth();
    this.major = user.getMajor();
    this.address = user.getAddress();
  }

}

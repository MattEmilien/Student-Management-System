package me.student.system.security.role;

import lombok.Data;
import lombok.Getter;


public enum UserPermission {
  STUDENT_READ("student:read"),
  STUDENT_WRITE("student:write"),
  COURSE_READ("course:read"),
  COURSE_WRITE("course:write"),
  TEACHER_READ("teacher:read"),
  TEACHER_WRITE("teacher:write");

  @Getter
  private final String permission;
  UserPermission(String permission) {
    this.permission = permission;
  }

}

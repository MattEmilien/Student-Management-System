package me.student.system.security.role;

import lombok.Data;
import lombok.Getter;


public enum UserPermission {
  USER_READ("user:read"),
  USER_WRITE("user:write"),
  COURSE_READ("course:read"),
  COURSE_WRITE("course:write"),
  ADMIN_READ("admin:read"),
  ADMIN_WRITE("admin:write");

  @Getter
  private final String permission;
  UserPermission(String permission) {
    this.permission = permission;
  }

}

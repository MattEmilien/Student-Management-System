package me.student.system.security.role;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;

import java.util.Set;
@AllArgsConstructor
public enum UserRole {
  STUDENT(Sets.newHashSet()),
  TEACHER(Sets.newHashSet(UserPermission.STUDENT_READ, UserPermission.COURSE_READ, UserPermission.COURSE_WRITE)),
  ADMIN(Sets.newHashSet(UserPermission.values()));


  private final Set<UserPermission> permissions;
}

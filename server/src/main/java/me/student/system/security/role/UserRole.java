package me.student.system.security.role;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum UserRole {
  STUDENT(Sets.newHashSet()),
  TEACHER(Sets.newHashSet(UserPermission.STUDENT_READ, UserPermission.COURSE_READ, UserPermission.COURSE_WRITE)),
  ADMIN(Sets.newHashSet(UserPermission.values()));


  private final Set<UserPermission> permissions;

  public Set<SimpleGrantedAuthority> getGrantedAutorities() {
  Set<SimpleGrantedAuthority> perms = permissions.stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
      .collect(Collectors.toSet());
    perms.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return perms;
  }
}

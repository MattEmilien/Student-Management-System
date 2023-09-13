package me.student.system.security.role;

import lombok.AllArgsConstructor;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@AllArgsConstructor
public enum UserRole {
  STUDENT(Set.of()),
  TEACHER(Set.of(UserPermission.USER_READ, UserPermission.COURSE_READ, UserPermission.COURSE_WRITE)),
  ADMIN(Set.of(UserPermission.values()));

  private final Set<UserPermission> permissions;

  public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
    var perms = permissions.stream()
      .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
      .collect(Collectors.toSet());
    perms.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return perms;
  }
}

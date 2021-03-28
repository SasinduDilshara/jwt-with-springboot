package com.test.jwttest.constants.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.test.jwttest.constants.enums.UserPermissions.*;

public enum UserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<UserPermissions> permissionsSet;

    UserRoles(Set<UserPermissions> permissionsSet)
    {
        this.permissionsSet = permissionsSet;
    }

    public Set<UserPermissions> getPermissionsSet()
    {
        return permissionsSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities()
    {
        Set<SimpleGrantedAuthority> permissions = getPermissionsSet().stream()
                .map(permissionsSet -> new SimpleGrantedAuthority(permissionsSet.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

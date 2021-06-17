package com.weine.mappers;

import com.weine.entities.Role;
import com.weine.entities.User;
import com.weine.models.dtos.RoleDto;
import com.weine.models.dtos.UserDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IUserMapper{
    public IUserMapper() {
    }

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        } else {
            UserDto userDto = new UserDto();
            if (user.getId() != null) {
                userDto.setId(user.getId());
            }

            if (user.getFirstName() != null) {
                userDto.setFirstName(user.getFirstName());
            }

            if (user.getPaternalName() != null) {
                userDto.setPaternalName(user.getPaternalName());
            }

            if (user.getMaternalName() != null) {
                userDto.setMaternalName(user.getMaternalName());
            }

            if (user.getEmail() != null) {
                userDto.setEmail(user.getEmail());
            }

            if (user.getPhoto() != null) {
                userDto.setPhoto(user.getPhoto());
            }

            if (user.getPassword() != null) {
                userDto.setPassword(user.getPassword());
            }

            if (user.getRole() != null) {
                userDto.setRole(this.toRoleDto(user.getRole()));
            }

            return userDto;
        }
    }

    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        } else {
            User user = new User();
            if (userDto.getId() != null) {
                user.setId(userDto.getId());
            }

            if (userDto.getFirstName() != null) {
                user.setFirstName(userDto.getFirstName());
            }

            if (userDto.getMaternalName() != null) {
                user.setMaternalName(userDto.getMaternalName());
            }

            if (userDto.getPaternalName() != null) {
                user.setPaternalName(userDto.getPaternalName());
            }

            if (userDto.getEmail() != null) {
                user.setEmail(userDto.getEmail());
            }

            if (userDto.getPhoto() != null) {
                user.setPhoto(userDto.getPhoto());
            }

            if (userDto.getPassword() != null) {
                user.setPassword(userDto.getPassword());
            }

            if (userDto.getRole() != null) {
                user.setRole(this.roleDtoToRole(userDto.getRole()));
            }

            return user;
        }
    }

    public RoleDto toRoleDto(Role role) {
        if (role == null) {
            return null;
        } else {
            RoleDto roleDto = new RoleDto();
            if (role.getId() != null) {
                roleDto.setId(role.getId());
            }

            if (role.getRole() != null) {
                roleDto.setRole(role.getRole());
            }

            return roleDto;
        }
    }

    public List<RoleDto> toRoleDtoList(List<Role> roles) {
        if (roles == null) {
            return null;
        } else {
            List<RoleDto> list = new ArrayList(roles.size());
            Iterator var3 = roles.iterator();

            while(var3.hasNext()) {
                Role role = (Role)var3.next();
                list.add(this.toRoleDto(role));
            }

            return list;
        }
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        } else {
            List<UserDto> list = new ArrayList(users.size());
            Iterator var3 = users.iterator();

            while(var3.hasNext()) {
                User user = (User)var3.next();
                list.add(this.toUserDto(user));
            }

            return list;
        }
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        } else {
            Role role = new Role();
            if (roleDto.getId() != null) {
                role.setId(roleDto.getId());
            }

            if (roleDto.getRole() != null) {
                role.setRole(roleDto.getRole());
            }

            return role;
        }
    }
}

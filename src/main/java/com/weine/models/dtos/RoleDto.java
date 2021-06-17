package com.weine.models.dtos;

/**
 * Role Dto to show the general info of the <b>roles</b> as the: <br>
 * {@link #id} to keep the id of the role.<br>
 * {@link #role} to keep the role name.<br>
 * @author Luis
 */
public class RoleDto {
    private Integer id;
    private String role;

    public RoleDto(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}

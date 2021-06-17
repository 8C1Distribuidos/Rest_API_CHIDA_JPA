package com.weine.models.dtos;

/**
 * User Dto to show the general info of the <b>users</b> as the:
 * {@link #id} to keep the id of the user.<br>
 * {@link #firstName} to keep the first name of the user.<br>
 * {@link #paternalName} to keep the paternal name of the user.<br>
 * {@link #maternalName} to keep the maternal name of the user.<br>
 * {@link #email} to keep the email of the user.</br>
 * {@link #role} the role of the user.</br>
 * @author Luis
 */
public class UserDto {
    private Integer id;
    private String firstName;
    private String paternalName;
    private String maternalName;
    private String email;
    private String photo;
    private String password;
    private RoleDto role;

    public UserDto(Integer id, String firstName, String paternalName, String maternalName, String email, String photo, String password, RoleDto role) {
        this.id = id;
        this.firstName = firstName;
        this.paternalName = paternalName;
        this.maternalName = maternalName;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.role = role;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPaternalName() {
        return paternalName;
    }

    public void setPaternalName(String paternalName) {
        this.paternalName = paternalName;
    }

    public String getMaternalName() {
        return maternalName;
    }

    public void setMaternalName(String maternalName) {
        this.maternalName = maternalName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", paternalName='" + paternalName + '\'' +
                ", maternalName='" + maternalName + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

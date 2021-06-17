package com.weine.models.dtos;

/**
 * Credentials Dto to wrap the credentials of the user, as the.<br>
 * {@code email} the email of the user.<br>
 * {@code password} the password of the user.<br>
 * @author Luis
 */
public class LoginDto {
    private String email;
    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password=-------'" + '\'' +
                '}';
    }
}

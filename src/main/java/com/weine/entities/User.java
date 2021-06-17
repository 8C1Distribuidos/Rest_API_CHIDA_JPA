package com.weine.entities;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"usuarios"</b> as the:</br>
 * {@link #id} to keep the id of the user.<br>
 * {@link #firstName} to keep the first name of the user.<br>
 * {@link #maternalName} to keep the maternal name of the user.<br>
 * {@link #paternalName} to keep the paternal name of the user.<br>
 * {@link #email} to keep the email address of the user.<br>
 * {@link #photo} to keep photo of the user.<br>
 * {@link #password} to keep the password of the user.<br>
 * {@link #role} to keep the relation of the user role.<br>
 * @author Luis
 */
@Entity
@Table(name = "usuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String firstName;
    @Column(name = "apellido_materno", nullable = false, length = 20)
    private String maternalName;
    @Column(name = "apellido_paterno", nullable = false, length = 20)
    private String paternalName;
    @Column(name = "correo_electronico", nullable = false, length = 30)
    private String email;
    @Column(name = "fotografia", nullable = false, length = 150)
    private String photo;
    @Column(name = "contraseña", nullable = false, length = 50)
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Role role;

    public User(Integer id, String firstName, String maternalName, String paternalName, String email, String photo, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.maternalName = maternalName;
        this.paternalName = paternalName;
        this.email = email;
        this.photo = photo;
        this.password = password;
        this.role = role;
    }

    public User() {
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

    public String getMaternalName() {
        return maternalName;
    }

    public void setMaternalName(String maternalName) {
        this.maternalName = maternalName;
    }

    public String getPaternalName() {
        return paternalName;
    }

    public void setPaternalName(String paternalName) {
        this.paternalName = paternalName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", maternalName='" + maternalName + '\'' +
                ", paternalName='" + paternalName + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
package com.weine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"tipo_usuarios"</b> as the:</br>
 * {@link #id} to keep the id of the role.<br>
 * {@link #role} to keep the name of the role.<br>
 * {@link #users} to keep the relation of the users.<br>
 * @author Luis
 */
@Entity
@Table(name = "tipo_usuarios")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "tipo", unique = true, nullable = false, length = 30)
    private String role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users;

    public Role(Integer id, String role, Set<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public Role() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}

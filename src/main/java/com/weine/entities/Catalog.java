package com.weine.entities;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"catalogo_productos"</b> as the:</br>
 * {@link #id} to keep the id of the catalog.<br>
 * {@link #name} to keep the name of the catalog.<br>
 * {@link #categories} to keep the relation of the categories.<br>
 * @author Luis
 */
@Entity
@Table(name = "catalogo_productos")
public class Catalog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 10)
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "catalog")
    private List<Category> categories;

    public Catalog(Integer id, String name, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Catalog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                "name=" + name +
                '}';
    }
}

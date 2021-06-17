package com.weine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"categoria_productos"</b> as the:</br>
 * {@link #id} to keep the id of the category.<br>
 * {@link #name} to keep the name of the category.<br>
 * {@link #catalog} to keep the relation of the catalog.<br>
 * {@link #products} to keep the relation of the products.<br>
 * @author Luis
 */
@Entity
@Table(name = "categoria_productos")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 20)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_catalogo", nullable = false)
    private Catalog catalog;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;

    public Category(Integer id, String name, Catalog catalog, List<Product> products) {
        this.id = id;
        this.name = name;
        this.catalog = catalog;
        this.products = products;
    }

    public Category() {
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}

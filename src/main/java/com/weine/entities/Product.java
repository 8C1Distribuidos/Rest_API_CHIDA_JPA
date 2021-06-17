package com.weine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"productos"</b> as the:</br>
 * {@link #id} to keep the id of the product.<br>
 * {@link #name} to keep the name of the product.<br>
 * {@link #imageLink} to keep the image of the product as a link.<br>
 * {@link #stock} to keep the stock of the product.<br>
 * {@link #price} to keep the price of the product.<br>
 * {@link #category} to keep the relation of the category.<br>
 * @author Luis
 */
@Entity
@Table(name = "productos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "nombre", unique = true, nullable = false, length = 50)
    private String name;
    @Column(name = "link_imagen", nullable = false, length = 150)
    private String imageLink;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "precio", nullable = false)
    private Integer price;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<PurchaseItem> items;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    public Product(Integer id, String name, String imageLink, Integer stock, boolean deleted, Integer price, Set<PurchaseItem> items, Category category) {
        this.id = id;
        this.name = name;
        this.imageLink = imageLink;
        this.stock = stock;
        this.deleted = deleted;
        this.price = price;
        this.items = items;
        this.category = category;
    }

    public Product() {
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(Set<PurchaseItem> items) {
        this.items = items;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}

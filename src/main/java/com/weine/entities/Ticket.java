package com.weine.entities;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"tickets"</b> as the:</br>
 * {@link #id} to keep the id of the ticket.<br>
 * {@link #idUser} to keep the id of the user related to the ticket.<br>
 * {@link #dateTime} to keep the date and time of the ticket creation.<br>
 * {@link #totalPrice} to keep the amount to pay indicated on the ticket.<br>
 * {@link #purchaseItems} to keep the relation of the purchased products.<br>
 * @author Luis
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "id_usuario", nullable = false)
    private Integer idUser;
    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "monto_total", nullable = false)
    private Integer totalPrice;
    @Column(name = "CP", nullable = false, length = 7)
    private String zipCode;
    @Column(name = "direccion", nullable = false, length = 100)
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = false)
    private City city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket", cascade = CascadeType.ALL)
    private Set<PurchaseItem> purchaseItems;

    public Ticket(Integer id, Integer idUser, LocalDateTime dateTime, Integer totalPrice, String zipCode, String address, City city, Set<PurchaseItem> purchaseItems) {
        this.id = id;
        this.idUser = idUser;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.purchaseItems = purchaseItems;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", dateTime=" + dateTime +
                ", totalPrice=" + totalPrice +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }
}

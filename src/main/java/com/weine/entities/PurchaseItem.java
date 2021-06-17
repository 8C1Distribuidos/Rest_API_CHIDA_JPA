package com.weine.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"producto_por_compra"</b> as the:</br>
 * {@link #id} to keep the id of the purchase item.<br>
 * {@link #amount} to keep the amount paid for the item.<br>
 * {@link #product} to keep the relation of the product.<br>
 * {@link #ticket} to keep the relation of the ticket.<br>
 * @author Luis
 */
@Entity
@Table(name = "producto_por_compra")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "cantidad", nullable = false)
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket", nullable = false, insertable = false, updatable = false)
    private Ticket ticket;

    public PurchaseItem(Integer id, Integer amount, Product product, Ticket ticket) {
        this.id = id;
        this.amount = amount;
        this.product = product;
        this.ticket = ticket;
    }

    public PurchaseItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "PurchaseItem{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }

}

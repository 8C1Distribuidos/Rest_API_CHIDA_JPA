package com.weine.entities;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity to have the field of the table <b>"municipios"</b> as the:</br>
 * {@link #id} the id of the city.<br>
 * {@link #name} the name of the city.<br>
 * {@link #tickets} the tickets that has this city in the address.<br>
 * @author Luis
 */
@Entity
@Table(name = "municipios")
public class City {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "municipio", nullable = false, length = 30)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    public City(Integer id, String name, Set<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
    }

    public City() {
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}

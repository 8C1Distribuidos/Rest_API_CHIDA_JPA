package com.weine.models.dtos;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Ticket Dto to show the general info of the <b>tickets</b> as the:
 * {@link #id} to keep the id of the ticket.<br>
 * {@link #idUser} to keep the id of the user that make this purchase.<br>
 * {@link #dateTime} to keep the date of the purchase.<br>
 * {@link #totalPrice} to keep the total price.<br>
 * {@link #city} the city of the address.<br>
 * {@link #purchaseList} to keep the list of products purchased.<br>
 * @author Luis
 */
public class TicketDto {
    private Integer id;
    private Integer idUser;
    private LocalDateTime dateTime;
    private Integer totalPrice;
    private String zipCode;
    private String address;
    private CityDto city;
    private Set<PurchaseItemDto> purchaseList;

    public TicketDto(Integer id, Integer idUser, LocalDateTime dateTime, Integer totalPrice, String zipCode, String address, CityDto city, Set<PurchaseItemDto> purchaseList) {
        this.id = id;
        this.idUser = idUser;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.purchaseList = purchaseList;
    }

    public TicketDto() {
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

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public Set<PurchaseItemDto> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(Set<PurchaseItemDto> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", dateTime=" + dateTime +
                ", totalPrice=" + totalPrice +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", purchaseList=" + purchaseList +
                '}';
    }
}

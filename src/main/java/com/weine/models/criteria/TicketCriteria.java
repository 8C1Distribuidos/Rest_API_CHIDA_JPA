package com.weine.models.criteria;

/**
 * The ticket search criteria
 */
public class TicketCriteria {
    private Integer idUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public TicketCriteria(Integer idUser) {
        this.idUser = idUser;
    }

    public TicketCriteria() {
    }

    @Override
    public String toString() {
        return "TicketCriteria{" +
                "idUser=" + idUser +
                '}';
    }
}

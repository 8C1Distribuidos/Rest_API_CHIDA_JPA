package com.weine.repositories;

import com.weine.entities.Ticket;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepository extends GenericRepository<Ticket, Integer>{
    public TicketRepository() {
        super(Ticket.class);
    }

    public List<Ticket> findAllByIdUser(Integer idUser) {
        if (idUser != null) {
            CriteriaQuery<Ticket> criteriaQuery = this.criteriaBuilder.createQuery(entity);
            Root<Ticket> entityRoot = criteriaQuery.from(entity);
            criteriaQuery.select(entityRoot).where(criteriaBuilder.equal(entityRoot.get("idUser"), idUser));
            return this.entityManager.createQuery(criteriaQuery).getResultList();
        } else {
            return null;
        }
    }
}

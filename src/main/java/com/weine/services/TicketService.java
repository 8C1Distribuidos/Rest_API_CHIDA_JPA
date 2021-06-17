package com.weine.services;

import com.weine.entities.PurchaseItem;
import com.weine.entities.Ticket;
import com.weine.mappers.TicketMapper;
import com.weine.models.criteria.TicketCriteria;
import com.weine.models.dtos.PurchaseItemDto;
import com.weine.models.dtos.TicketDto;
import com.weine.repositories.GenericRepository;
import com.weine.repositories.TicketRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
public class TicketService implements IServiceApi<TicketDto, TicketCriteria>{
    private final TicketRepository ticketRep;
    private final TicketMapper ticketMapper;
    private final GenericRepository<PurchaseItem, Integer> purchaseItemRep;

    public TicketService() {
        this.ticketRep = new TicketRepository();
        this.ticketMapper = new TicketMapper();
        this.purchaseItemRep = new GenericRepository<>(PurchaseItem.class);
    }

    @Override
    public List<TicketDto> getObjects(TicketCriteria criteria) {
        if(criteria != null && criteria.getIdUser() != null){
            return ticketMapper.ticketsToTicketsDto(ticketRep.findAllByIdUser(criteria.getIdUser()));
        }
        return null;
    }

    @Override
    public List<TicketDto> getObjects() {
        return ticketMapper.ticketsToTicketsDto(ticketRep.findAll());
    }

    @Override
    public TicketDto find(Integer id) {
        if(id != null) {
            return ticketMapper.toTicketDto(ticketRep.findById(id));
        }
        return null;
    }

    @Override
    public TicketDto save(TicketDto request) {
        if(request != null)
        {
            request.setId(null);
            Ticket ticket = ticketMapper.toTicket(request);
            ticketMapper.setRelation(ticket);
            ticketRep.create(ticket);
            return ticketMapper.toTicketDto(ticket);
        }
        return null;
    }

    @Override
    public TicketDto update(TicketDto request) {
        if(request != null) {
            if(ticketRep.findById(request.getId()) != null) {
                if(request.getPurchaseList() != null) {
                    Set<PurchaseItemDto> itemsToDelete = new HashSet<>();
                    for (PurchaseItemDto item : request.getPurchaseList()) {
                        if(item.isToDelete()){//Delete the items of the list that must to be deleted
                            if (item.getId() != null) {
                                purchaseItemRep.deleteById(item.getId());
                                itemsToDelete.add(item);
                            }
                        }
                    }
                    //And remove the request list
                    request.getPurchaseList().removeAll(itemsToDelete);
                }
                Ticket ticket = ticketMapper.toTicket(request);
                ticketMapper.setRelation(ticket);
                ticketRep.edit(ticket);
                return ticketMapper.toTicketDto(ticket);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if(id != null)
        {
            ticketRep.deleteById(id);
            return true;
        }
        return false;
    }

}

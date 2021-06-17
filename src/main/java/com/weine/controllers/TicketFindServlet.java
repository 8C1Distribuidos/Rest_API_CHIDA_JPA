package com.weine.controllers;

import com.weine.models.criteria.TicketCriteria;
import com.weine.models.dtos.TicketDto;
import com.weine.services.TicketService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/tickets/find")
public class TicketFindServlet extends FindControllerApi<TicketDto, TicketCriteria, TicketService> {
    @Override
    protected String getEntityName() {
        return "Ticket";
    }
}

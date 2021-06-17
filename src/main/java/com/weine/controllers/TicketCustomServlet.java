package com.weine.controllers;

import com.weine.models.criteria.TicketCriteria;
import com.weine.models.dtos.TicketDto;
import com.weine.services.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tickets/client-history")
public class TicketCustomServlet extends HttpServlet {
    TicketService ticketService;
    @Override
    public void init() throws ServletException {
       ticketService = new TicketService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = ControllerApi.getBody(req);
        System.out.println("Obtaining All tickets, with this " + string + "...");
        List<TicketDto> response = ticketService.getObjects(new TicketCriteria(3));
        System.out.println("Tickets obtained...");
        resp.setStatus(200);
        for (TicketDto ticket : response)
        resp.getWriter().write(ticket.toString());
    }
}

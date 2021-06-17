package com.weine.controllers;

import com.weine.services.IServiceApi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FindControllerApi <D,C, S extends IServiceApi<D,C>> extends HttpServlet {
    protected IServiceApi<D,C> service;
    /**
     * To get a individual item
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println("Find " + getEntityName() + " "+ id +"...");
        D response = this.service.find(id);
        if(response == null)
        {
            System.out.println(getEntityName() + " " + id + " not found...");
            resp.sendError(404, "No " + getEntityName() + " " + id + " exist");
            return;
        }
        System.out.println(getEntityName() + " found...");
        resp.getWriter().write(response.toString());
    }

    /**
     * Function to get the name of the entity
     * @return The Entity name
     */
    protected abstract String getEntityName();
}

package com.weine.controllers;

import com.weine.models.dtos.CityDto;
import com.weine.services.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cities/find")
public class CityFindServlet extends FindControllerApi<CityDto, Object, CityService>{
    @Override
    public void init() throws ServletException {
        service = new CityService();
        objectClass = CityDto.class;
    }

    @Override
    protected String getEntityName() {
        return "City";
    }
}

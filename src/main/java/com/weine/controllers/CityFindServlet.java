package com.weine.controllers;

import com.weine.models.dtos.CityDto;
import com.weine.services.CityService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/cities/find")
public class CityFindServlet extends FindControllerApi<CityDto, Object, CityService>{
    @Override
    protected String getEntityName() {
        return "City";
    }
}

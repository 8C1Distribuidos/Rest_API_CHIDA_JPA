package com.weine.controllers;

import com.weine.models.dtos.CatalogDto;
import com.weine.services.CatalogService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/catalogs")
public class CatalogServlet extends ControllerApi<CatalogDto, Object, CatalogService>{
    @Override
    protected String getEntityName() {
        return "Catalog";
    }

    @Override
    protected String getEntityPluralName() {
        return "Catalogs";
    }
}

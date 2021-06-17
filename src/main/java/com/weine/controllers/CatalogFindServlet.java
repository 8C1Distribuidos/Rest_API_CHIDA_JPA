package com.weine.controllers;

import com.weine.models.dtos.CatalogDto;
import com.weine.services.CatalogService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/catalogs/find")
public class CatalogFindServlet extends FindControllerApi<CatalogDto, Object, CatalogService>{
    @Override
    protected String getEntityName() {
        return "Catalog";
    }
}

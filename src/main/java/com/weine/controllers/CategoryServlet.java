package com.weine.controllers;

import com.weine.models.dtos.CatalogDto;
import com.weine.services.CatalogService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/categories")
public class CategoryServlet extends ControllerApi<CatalogDto, Object, CatalogService>{
    @Override
    protected String getEntityName() {
        return "Category";
    }

    @Override
    protected String getEntityPluralName() {
        return "Categories";
    }
}

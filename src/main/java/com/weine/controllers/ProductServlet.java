package com.weine.controllers;

import com.weine.models.criteria.ProductCriteria;
import com.weine.models.dtos.ProductFullInfoDto;
import com.weine.services.ProductService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/products")
public class ProductServlet extends ControllerApi<ProductFullInfoDto, ProductCriteria, ProductService>{
    @Override
    protected String getEntityName() {
        return "Product";
    }

    @Override
    protected String getEntityPluralName() {
        return "Products";
    }
}

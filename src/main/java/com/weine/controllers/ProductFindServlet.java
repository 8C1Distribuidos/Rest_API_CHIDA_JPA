package com.weine.controllers;

import com.weine.models.criteria.ProductCriteria;
import com.weine.models.dtos.ProductFullInfoDto;
import com.weine.services.ProductService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/products/find")
public class ProductFindServlet extends FindControllerApi<ProductFullInfoDto, ProductCriteria, ProductService>{
    @Override
    protected String getEntityName() {
        return "Product";
    }
}

package com.weine.controllers;

import com.weine.models.dtos.RoleDto;
import com.weine.services.RoleService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/roles")
public class RoleServlet extends ControllerApi<RoleDto, Object, RoleService>{
    @Override
    protected String getEntityName() {
        return "Role";
    }

    @Override
    protected String getEntityPluralName() {
        return "Roles";
    }
}

package com.weine.controllers;

import com.weine.models.dtos.RoleDto;
import com.weine.services.RoleService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/roles/find")
public class RoleFindServlet extends FindControllerApi<RoleDto, Object, RoleService>{
    @Override
    protected String getEntityName() {
        return "Role";
    }
}

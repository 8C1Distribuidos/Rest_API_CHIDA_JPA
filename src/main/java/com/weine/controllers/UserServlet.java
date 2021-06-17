package com.weine.controllers;

import com.weine.models.dtos.UserDto;
import com.weine.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/users")
public class UserServlet extends ControllerApi<UserDto, Object, UserService>{
    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected String getEntityName() {
        return "User";
    }

    @Override
    protected String getEntityPluralName() {
        return "Users";
    }
}

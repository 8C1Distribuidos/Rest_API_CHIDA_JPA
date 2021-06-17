package com.weine.controllers;

import com.weine.models.dtos.UserDto;
import com.weine.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/users/verify")
public class UserCustomController extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = ControllerApi.getBody(req);
        System.out.println("Verifying users " + string + "...");
        UserDto response = userService.verifyUser(string, string);
        if(response == null)
        {
            System.out.println("User " + string + " has not been verified...");
            resp.sendError(404, "Wrong credentials");
        }
        resp.setStatus(200);
        System.out.println("User verified...");
    }
}

package com.example.Asm.controller;

import com.example.Asm.request.EmployeeRequest;
import com.example.Asm.request.PositionRequest;
import com.example.Asm.response.PositionResponse;
import com.example.Asm.service.PositionService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PositionServlet", value = {
        "/position/list",
        "/position/add",
        "/position/view-update",
        "/position/delete",
        "/position/update"
})
public class PositionServlet extends HttpServlet {
    private final PositionService positionService = new PositionService();
    private List<PositionResponse> positionList = new ArrayList<>();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/list")) {
            this.getAll(request, response);
        }  else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else {
            this.getAll(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        positionService.delete(id);
        response.sendRedirect("/position/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PositionResponse positionResponse = positionService.getOne(id);
        request.setAttribute("po", positionResponse);
        request.getRequestDispatcher("/views/position/crud.jsp").forward(request,response);
    }



    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        positionList = positionService.getAll();
        request.setAttribute("positionList", positionList);
        request.getRequestDispatcher("/views/position/list.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PositionRequest positionRequest = new PositionRequest();
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            BeanUtils.copyProperties(positionRequest, request.getParameterMap());
            positionService.create(positionRequest);
            response.sendRedirect("/position/list");
        } else {
            BeanUtils.copyProperties(positionRequest, request.getParameterMap());
            positionService.update(positionRequest);
            response.sendRedirect("/position/list");
        }
    }
}

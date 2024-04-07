package com.example.Asm.controller;

import com.example.Asm.request.ColorRequest;
import com.example.Asm.request.ProducerRequest;
import com.example.Asm.response.ProducerResponse;
import com.example.Asm.service.ProducerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProducerServlet", value = {
        "/producer/list",
        "/producer/add",
        "/producer/view-update",
        "/producer/update",
        "/producer/detail",
        "/producer/delete"

})
public class ProducerServlet extends HttpServlet {
    private List<ProducerResponse> producerList = new ArrayList<>();
    private final ProducerService producerService = new
            ProducerService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("list")) {
            this.getAll(request, response);
        } else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProducerResponse producerResponse = producerService.getOne(id);
        request.setAttribute("pd", producerResponse);
        request.setAttribute("btn", 0);
        request.getRequestDispatcher("/views/producer/crud.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        producerService.delete(id);
        response.sendRedirect("/producer/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProducerResponse producerResponse = producerService.getOne(id);
        request.setAttribute("pd", producerResponse);
        request.getRequestDispatcher("/views/producer/crud.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        producerList = producerService.getAll();
        request.setAttribute("producerList", producerList);
        request.getRequestDispatcher("/views/producer/list.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProducerRequest colorRequest = new ProducerRequest();
        BeanUtils.populate(colorRequest, request.getParameterMap());
        producerService.update(colorRequest);
        producerList = producerService.getAll();
        request.setAttribute("producerList", producerList);
        response.sendRedirect("/producer/list");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProducerRequest producerRequest = new ProducerRequest();
        BeanUtils.populate(producerRequest, request.getParameterMap());
        producerService.create(producerRequest);
        producerList = producerService.getAll();
        request.setAttribute("producerList", producerList);
        response.sendRedirect("/producer/list");
    }
}

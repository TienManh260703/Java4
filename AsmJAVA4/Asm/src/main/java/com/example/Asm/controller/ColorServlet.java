package com.example.Asm.controller;

import com.example.Asm.request.ColorRequest;
import com.example.Asm.request.ProductRequet;
import com.example.Asm.response.ColorResponse;
import com.example.Asm.response.ProductResponse;
import com.example.Asm.service.ColorService;
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

@WebServlet(name = "ColorServlet", value = {
        "/color/list",
        "/color/add",
        "/color/view-update",
        "/color/update",
        "/color/detail",
        "/color/delete"

})
public class ColorServlet extends HttpServlet {
    private List<ColorResponse> colorList = new ArrayList<>();
    private final ColorService colorService = new
            ColorService();

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
        ColorResponse colorResponse = colorService.getOne(id);
        request.setAttribute("c", colorResponse);
        request.setAttribute("btn", 0);
        request.getRequestDispatcher("/views/color/crud-product.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        colorService.delete(id);
        response.sendRedirect("/color/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ColorResponse colorResponse = colorService.getOne(id);
        request.setAttribute("c", colorResponse);
        request.getRequestDispatcher("/views/color/crud-product.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        colorList = colorService.getAll();
        request.setAttribute("colorList", colorList);
        request.getRequestDispatcher("/views/color/list-product.jsp").forward(request, response);
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
        ColorRequest colorRequest = new ColorRequest();
        BeanUtils.populate(colorRequest, request.getParameterMap());
        colorService.update(colorRequest);
        colorList = colorService.getAll();
        request.setAttribute("colorList", colorList);
        response.sendRedirect("/color/list");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ColorRequest colorRequest = new ColorRequest();
        BeanUtils.populate(colorRequest, request.getParameterMap());
        colorService.create(colorRequest);
        colorList = colorService.getAll();
        request.setAttribute("colorList", colorList);
        response.sendRedirect("/color/list");
    }
}

package com.example.Asm.controller;

import com.example.Asm.request.ShopRequest;
import com.example.Asm.response.ShopResponse;
import com.example.Asm.service.ShopService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = {
        "/shop/list",
        "/shop/add",
        "/shop/view-update",
        "/shop/update",
        "/shop/delete",
})
public class ShopServlet extends HttpServlet {
    private final ShopService shopService = new ShopService();
    private List<ShopResponse> shopList = new ArrayList<>();

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

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        shopService.delete(id);
        response.sendRedirect("/shop/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShopResponse shopResponse = shopService.getOne(id);

        request.setAttribute("s", shopResponse);
        request.getRequestDispatcher("/views/shop/crud.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        shopList = shopService.getAll();
        request.setAttribute("shopList", shopList);
        request.getRequestDispatcher("/views/shop/list.jsp").forward(request, response);
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

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        ShopRequest shopRequest = new ShopRequest();
        BeanUtils.populate(shopRequest, request.getParameterMap());
        shopService.update(shopRequest);
        response.sendRedirect("/shop/list");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        ShopRequest shopRequest = new ShopRequest();
        BeanUtils.populate(shopRequest, request.getParameterMap());
        shopService.create(shopRequest);
        response.sendRedirect("/shop/list");
    }
}

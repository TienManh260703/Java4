package com.example.Asm.controller;

import com.example.Asm.request.ProductLineRequest;
import com.example.Asm.response.ProductLineResponse;
import com.example.Asm.service.ProductLineService;
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

@WebServlet(name = "ProductLineServlet", value = {
        "/product-line/list",
        "/product-line/add",
        "/product-line/view-update",
        "/product-line/update",
        "/product-line/detail",
        "/product-line/delete"

})
public class ProductLineServlet extends HttpServlet {
    private List<ProductLineResponse> productLineList = new ArrayList<>();
    private final ProductLineService productLineService = new
            ProductLineService();

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
        ProductLineResponse productLineResponse = productLineService.getOne(id);
        request.setAttribute("pl", productLineResponse);
        request.setAttribute("btn", 0);
        request.getRequestDispatcher("/views/product-line/crud.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productLineService.delete(id);
        response.sendRedirect("/product-line/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductLineResponse productLineResponse = productLineService.getOne(id);
        request.setAttribute("pl", productLineResponse);
        request.getRequestDispatcher("/views/product-line/crud.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        productLineList = productLineService.getAll();
        request.setAttribute("productLineList", productLineList);
        request.getRequestDispatcher("/views/product-line/list.jsp").forward(request, response);
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
        ProductLineRequest productLineRequest = new ProductLineRequest();
        BeanUtils.populate(productLineRequest, request.getParameterMap());
        productLineService.update(productLineRequest);
        productLineList = productLineService.getAll();
        request.setAttribute("productLineList", productLineList);
        response.sendRedirect("/product-line/list");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProductLineRequest productLineRequest = new ProductLineRequest();
        BeanUtils.populate(productLineRequest, request.getParameterMap());
        productLineService.create(productLineRequest);
        productLineList = productLineService.getAll();
        request.setAttribute("productLineList", productLineList);
        response.sendRedirect("/product-line/list");
    }
}

package com.example.Asm.controller;

import com.example.Asm.entity.Product;
import com.example.Asm.request.ProductRequet;
import com.example.Asm.response.ProductResponse;
import com.example.Asm.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/product/list",
        "/product/add",
        "/product/view-update",
        "/product/update",
        "/product/detail",
        "/product/delete"

})
public class ProductServlet extends HttpServlet {
    private List<ProductResponse> listProduct = new ArrayList<>();
    private final ProductService productService = new
            ProductService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/product/list")) {
            this.getAll(request, response);
        } else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        }
        else if (uri.contains("/detail")) {
            this.detail(request, response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductResponse productResponse = productService.getOne(id);
        request.setAttribute("p", productResponse);
        request.setAttribute("btn",0);
        request.getRequestDispatcher("/views/product/crud-product.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/product/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductResponse productResponse = productService.getOne(id);
        request.setAttribute("p", productResponse);
        request.getRequestDispatcher("/views/product/crud-product.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        listProduct = productService.getAll();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/views/product/list-product.jsp").forward(request, response);
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
        ProductRequet productRequet = new ProductRequet();
        BeanUtils.populate(productRequet, request.getParameterMap());
        productService.update(productRequet);
        listProduct = productService.getAll();
        request.setAttribute("listProduct", listProduct);
        response.sendRedirect("/product/list");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProductRequet productRequet = new ProductRequet();
        BeanUtils.populate(productRequet, request.getParameterMap());
        productService.create(productRequet);
        listProduct = productService.getAll();
        request.setAttribute("listProduct", listProduct);
        response.sendRedirect("/product/list");
    }
}

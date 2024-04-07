package com.example.Asm.controller;

import com.example.Asm.request.CustomerRequest;
import com.example.Asm.request.EmployeeRequest;
import com.example.Asm.response.CustomerResponse;
import com.example.Asm.response.EmployeeResponse;
import com.example.Asm.service.CustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = {
        "/customer/list",
        "/customer/add",
        "/customer/view-update",
        "/customer/update",
        "/customer/delete",
        "/customer/detail",
})
public class CustomerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerService();
    private List<CustomerResponse> customerList = new ArrayList<>();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/list")) {
            this.getAll(request, response);
        } else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else {
            getAll(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        response.sendRedirect("/customer/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerResponse customerResponse = customerService.getOne(id);
        request.setAttribute("c", customerResponse);
        request.getRequestDispatcher("/views/customer/crud.jsp").forward(request, response);
    }



    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerList = customerService.getAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/views/customer/list.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            CustomerRequest customerRequest = new CustomerRequest();
            BeanUtils.copyProperties(customerRequest, request.getParameterMap());
            customerService.create(customerRequest);
            response.sendRedirect("/customer/list");
        } else {
            CustomerRequest customerRequest = new CustomerRequest();
            BeanUtils.copyProperties(customerRequest, request.getParameterMap());
            customerService.update(customerRequest);
            response.sendRedirect("/customer/list");
        }
    }
}

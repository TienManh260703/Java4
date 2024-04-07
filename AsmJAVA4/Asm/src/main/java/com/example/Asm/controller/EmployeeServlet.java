package com.example.Asm.controller;

import com.example.Asm.entity.Employee;
import com.example.Asm.request.EmployeeRequest;
import com.example.Asm.response.EmployeeResponse;
import com.example.Asm.response.PositionResponse;
import com.example.Asm.response.ShopResponse;
import com.example.Asm.service.EmployeeService;
import com.example.Asm.service.PositionService;
import com.example.Asm.service.ShopService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = {
        "/employee/list",
        "/employee/view-add",
        "/employee/view-update",
        "/employee/add",
        "/employee/update",
        "/employee/delete",
        "/employee/detail"
})
public class EmployeeServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();
    private List<EmployeeResponse> employeeList = new ArrayList<>();

    private List<PositionResponse> positionList = new ArrayList<>();
    private List<ShopResponse> shopList = new ArrayList<>();
    private final PositionService positionService = new PositionService();
    private final ShopService shopService = new ShopService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/list")) {
            this.getAll(request, response);
        } else if (uri.contains("/view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/detail")) {

        } else {
            this.getAll(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        response.sendRedirect("/employee/list");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeResponse employeeResponse = employeeService.getOne(id);
        request.setAttribute("e", employeeResponse);
        init(request, response);
        request.setAttribute("action", "/employee/update?id=" + id);
        request.getRequestDispatcher("/views/employee/crud.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        init(request, response);
        request.setAttribute("action", "/employee/add");
        request.getRequestDispatcher("/views/employee/crud.jsp").forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employeeList = employeeService.getAll();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("/views/employee/list.jsp").forward(request, response);
    }

    private void init(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        positionList = positionService.getAll();
        shopList = shopService.getAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("shopList", shopList);

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            EmployeeRequest employeeRequest = new EmployeeRequest();
            BeanUtils.copyProperties(employeeRequest, request.getParameterMap());
            employeeService.create(employeeRequest);
            response.sendRedirect("/employee/list");
        } else {
            EmployeeRequest employeeRequest = new EmployeeRequest();
            BeanUtils.copyProperties(employeeRequest, request.getParameterMap());
            employeeService.update(employeeRequest);
            response.sendRedirect("/employee/list");
        }
    }
}

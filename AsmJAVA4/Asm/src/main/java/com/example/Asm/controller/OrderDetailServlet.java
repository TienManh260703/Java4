package com.example.Asm.controller;

import com.example.Asm.entity.OrderDetail;
import com.example.Asm.repository.OrderDetailRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderDetailServlet", value = {
        "/order-detail/list"
})
public class OrderDetailServlet extends HttpServlet {
    private List<OrderDetail> orderDetails = new ArrayList<>();
    private final OrderDetailRepository orderDetailRepository = new OrderDetailRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/list")) {
            this.getAll(request, response);
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderDetails = orderDetailRepository.getAll();
        request.setAttribute("orderDetails", orderDetails);
       request.getRequestDispatcher("/views/order-detail/admin-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

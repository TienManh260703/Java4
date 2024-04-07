package com.example.Asm.controller;

import com.example.Asm.entity.Order;
import com.example.Asm.entity.OrderDetail;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.repository.OrderDetailRepository;
import com.example.Asm.repository.OrderRepository;
import com.example.Asm.response.ProducerResponse;
import com.example.Asm.response.ProductDetailResponse;
import com.example.Asm.service.ProductDetailService;
import com.example.Asm.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", value = {
        "/order/list",
        "/order/add",
        "/order/delete",
        "/order/update",

})
public class OrderServlet extends HttpServlet {
    private List<ProductDetailResponse> producerDetailList = new ArrayList<>();
    private final ProductDetailService productDetailService = new ProductDetailService();
    private final OrderRepository orderRepository = new OrderRepository();
    private final OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
    private static int idHD;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/list")) {
            this.getAll(request, response);
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        producerDetailList = productDetailService.getAll();
        request.setAttribute("producerDetailList", producerDetailList);
        request.getRequestDispatcher("/views/order/sell.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productDetailId = Integer.parseInt(request.getParameter("idPd"));
        int quantityPurchased = Integer.parseInt(request.getParameter("quantityPurchased"));
        ProductDetailResponse productDetailResponse = productDetailService.getOne(productDetailId);
        ProductDetail productDetail1 = ProductDetail
                .builder()
                .id(productDetailResponse.getProductId())
                .build();
        Order getOrder = new Order();
        orderRepository.create(Order.builder()
                .code("HD-0" + orderRepository.getAll().size())
                .createdDate(new Date())
                .build());
        getOrder = orderRepository.getLastOrder();
        idHD = getOrder.getId();
        OrderDetail orderDetail = OrderDetail
                .builder()
                .order(getOrder)
                .productDetail(productDetail1)
                .quantity(quantityPurchased)
                .unitPrice(productDetailResponse.getPrice())
                .build();
        orderDetailRepository.create(orderDetail);
        response.sendRedirect("/order/list");
    }


}

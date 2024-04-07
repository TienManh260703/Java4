package com.example.Asm.controller;

import com.example.Asm.entity.Color;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.entity.ProductLine;
import com.example.Asm.request.ProductDetailRequest;
import com.example.Asm.request.ProductLineRequest;
import com.example.Asm.response.ColorResponse;
import com.example.Asm.response.ProducerResponse;
import com.example.Asm.response.ProductDetailResponse;
import com.example.Asm.response.ProductLineResponse;
import com.example.Asm.response.ProductResponse;
import com.example.Asm.service.ColorService;
import com.example.Asm.service.ProducerService;
import com.example.Asm.service.ProductDetailService;
import com.example.Asm.service.ProductLineService;
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

@WebServlet(name = "ProductDetailServlet", value = {
        "/product-detail/list",
        "/product-detail/add",
        "/product-detail/detail",
        "/product-detail/update",
        "/product-detail/delete",
        "/product-detail/view-update"
})
public class ProductDetailServlet extends HttpServlet {
    private final ProductDetailService productDetailService = new ProductDetailService();
    private List<ProductDetailResponse> listProductDetail = new ArrayList<>();
    //    Color
    private final ColorService colorService = new ColorService();
    private List<ColorResponse> colorList = new ArrayList<>();
    //    Product
    private final ProductService productService = new ProductService();
    private List<ProductResponse> productList = new ArrayList<>();
    //    Producer
    private final ProducerService producerService = new ProducerService();
    private List<ProducerResponse> producerList = new ArrayList<>();
    //    ProducerLine
    private final ProductLineService productLineService = new ProductLineService();
    private List<ProductLineResponse> productLineList = new ArrayList<>();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("UTI : "+ uri);
        if (uri.contains("/list")) {
            this.getAll(request, response);
        } else if (uri.contains("/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.getAll(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDetailResponse productDetailResponse = productDetailService.getOne(id);
        init(request,response);
        request.setAttribute("btn", 0);
        request.setAttribute("pd",productDetailResponse);
        request.getRequestDispatcher("/views/product_detail/crud-product-detail.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        productDetailService.delete(id);
        response.sendRedirect("/product-detail/list");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDetailResponse productDetailResponse = productDetailService.getOne(id);
        init(request,response);
        request.setAttribute("btn", 1);
        request.setAttribute("pd",productDetailResponse);
        request.getRequestDispatcher("/views/product_detail/crud-product-detail.jsp").forward(request,response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        init(request, response);
        request.getRequestDispatcher("/views/product_detail/list-product-detail.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.create(request, response);
        } else if(uri.contains("/update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        ProductDetailRequest productDetailRequest = new ProductDetailRequest();
        BeanUtils.populate(productDetailRequest , request.getParameterMap());
        productDetailRequest.setStatus(0);

        productDetailService.update(productDetailRequest);
        response.sendRedirect("/product-detail/list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProductDetailRequest productDetailRequest = new ProductDetailRequest();
        BeanUtils.copyProperties(productDetailRequest, request.getParameterMap());
        productDetailRequest.setStatus(0);
        productDetailService.create(productDetailRequest);
//        init(request, response);
        response.sendRedirect("/product-detail/list");
    }

    private void init(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        listProductDetail = productDetailService.getAll();
        colorList = colorService.getAll();
        productList = productService.getAll();
        producerList = producerService.getAll();
        productLineList = productLineService.getAll();
        request.setAttribute("listProductDetail", listProductDetail);
        request.setAttribute("colorList", colorList);
        request.setAttribute("productList", productList);
        request.setAttribute("producerList", producerList);
        request.setAttribute("productLineList", productLineList);
    }
}

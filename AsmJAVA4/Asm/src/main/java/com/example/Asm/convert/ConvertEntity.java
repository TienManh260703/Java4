package com.example.Asm.convert;

import com.example.Asm.entity.Color;
import com.example.Asm.entity.Customer;
import com.example.Asm.entity.Employee;
import com.example.Asm.entity.Order;
import com.example.Asm.entity.Position;
import com.example.Asm.entity.Producer;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.entity.ProductLine;
import com.example.Asm.entity.Shop;
import com.example.Asm.request.CustomerRequest;
import com.example.Asm.request.EmployeeRequest;
import com.example.Asm.request.OrderRequest;
import com.example.Asm.request.ProducerRequest;
import com.example.Asm.request.ProductDetailRequest;
import com.example.Asm.request.ProductLineRequest;
import com.example.Asm.request.ProductRequet;
import com.example.Asm.response.CustomerResponse;
import com.example.Asm.response.EmployeeResponse;
import com.example.Asm.response.OrderResponse;
import com.example.Asm.response.ProducerResponse;
import com.example.Asm.response.ProductDetailResponse;
import com.example.Asm.response.ProductLineResponse;
import com.example.Asm.response.ProductResponse;
import com.example.Asm.request.ShopRequest;
import com.example.Asm.response.ShopResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertEntity {


    public OrderResponse convertOrderToOrderResponse(Order order) {
        OrderResponse orderResponse = OrderResponse
                .builder()
                .id(order.getId())
                .code(order.getCode())
                .createdDate(order.getCreatedDate())
//                .createDateStr()
                .paymentDate(order.getPaymentDate())
//                .paymentDateStr()
                .status(order.getStatus())
                .recipientName(order.getRecipientName())
                .address(order.getAddress())
                .phoneNumber(order.getPhoneNumber())
//                .customerId(order.getCustomer().getId())
//                .customerCode(order.getCustomer().getCode())
                .build();

        return orderResponse;
    }

    public Order convertOrderRequestToOrder(OrderRequest request) {
        Customer customer = Customer.builder().id(request.getCustomerId()).build();
        Order order = Order
                .builder()
                .id(request.getId())
                .code(request.getCode())
                .createdDate(request.getCreatedDate())
                .paymentDate(request.getPaymentDate())
                .status(request.getStatus())
                .recipientName(request.getRecipientName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .customer(customer)
                .build();
        return order;
    }

    public ShopResponse convertShopToShopResponse(Shop shop) {
        ShopResponse response = ShopResponse
                .builder()
                .id(shop.getId())
                .code(shop.getCode())
                .name(shop.getName())
                .address(shop.getAddress())
                .city(shop.getCity())
                .country(shop.getCountry())
                .build();
        return response;
    }

    public Shop convertShopRequestToShop(ShopRequest request) throws InvocationTargetException, IllegalAccessException {
        Shop shop = new Shop();
        BeanUtils.copyProperties(shop, request);
        return shop;
    }

    public CustomerResponse convertCustomerToCustomerResponse(Customer customer) {
        // Lấy ngày sinh từ đối tượng employee
        Date dateOfBirth = customer.getDateOfBirth();
        // Tạo định dạng cho ngày
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        // Chuyển đổi Date thành chuỗi với định dạng đã xác định
        String formattedDate = formatter.format(dateOfBirth);
        CustomerResponse response = CustomerResponse.builder()
                .id(customer.getId())
                .code(customer.getCode())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .dateStr(formattedDate)
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .city(customer.getCity())
                .country(customer.getCountry())
                .password(customer.getPassword())
                .build();
        return response;
    }

    public Customer convertCustomerRequestToCustomer(CustomerRequest request) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        // Chuyển đổi chuỗi thành đối tượng Date
        Date date = dateFormat.parse(request.getDateStr());
        Customer customer = Customer.builder()
                .id(request.getId())
                .code(request.getCode())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .dateOfBirth(date)
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .city(request.getCity())
                .country(request.getCountry())
                .password(request.getPassword())
                .build();
        return customer;
    }

    public EmployeeResponse convertEmployeeToEmployeeResponse(Employee employee) {
// Lấy ngày sinh từ đối tượng employee
        Date dateOfBirth = employee.getDateOfBirth();
        // Tạo định dạng cho ngày
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        // Chuyển đổi Date thành chuỗi với định dạng đã xác định
        String formattedDate = formatter.format(dateOfBirth);

        EmployeeResponse response = EmployeeResponse
                .builder()
                .id(employee.getId())
                .code(employee.getCode())
                .firstName(employee.getFirstName())
                .middleName(employee.getMiddleName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .dateStr(formattedDate)
                .address(employee.getAddress())
                .phoneNumber(employee.getPhoneNumber())
                .password(employee.getPassword())
                .status(employee.getStatus())
                // shop
                .shopId(employee.getShop().getId())
                .shopCode(employee.getShop().getCode())
                .shopName(employee.getShop().getName())
                .shopAddress(employee.getShop().getAddress())
                .shopCity(employee.getShop().getCity())
                .shopCountry(employee.getShop().getCountry())
                // Position
                .positionId(employee.getPosition().getId())
                .positionCode(employee.getPosition().getCode())
                .positionName(employee.getPosition().getName())
                .build();
        return response;
    }

    public Employee convertEmployeeRequestToEmployee(EmployeeRequest request) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        // Chuyển đổi chuỗi thành đối tượng Date
        Date date = dateFormat.parse(request.getDateStr());

        Position position = Position.builder().id(request.getPositionId()).build();
        Shop shop = Shop.builder().id(request.getShopId()).build();
        Employee employee = Employee
                .builder()
                .id(request.getId())
                .code(request.getCode())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .dateOfBirth(date)
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .position(position)
                .shop(shop)
                .build();
        return employee;
    }

//    public ClientResponse convertClientToClientResponse(Customer customer) {
//        ClientResponse response = ClientResponse
//                .builder()
//                .id(customer.getId())
//                .address(customer.getAddress())
//                .city(customer.getCity())
//                .code(customer.getCode())
//                .country(customer.getCountry())
//                .dateOfBirth(customer.getDateOfBirth())
//                .firstName(customer.getFirstName())
//                .middleName(customer.getMiddleName())
//                .lastName(customer.getLastName())
//                .status(customer.getStatus())
//                .password(customer.getPassword())
//                .phoneNumber(customer.getPhoneNumber())
//                .build();
//        return response;
//    }
//
//    public static Customer convertClientRequestToClient(ClientRequest request) throws InvocationTargetException, IllegalAccessException {
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customer, request);
//        return customer;
//    }

    public ProducerResponse convertProductToProductResponse(Producer producer) {
        ProducerResponse response = ProducerResponse
                .builder()
                .id(producer.getId())
                .code(producer.getCode())
                .name(producer.getName())
                .status(producer.getStatus())
                .build();
        return response;
    }

    public Producer convertProductRequestToProduct(ProducerRequest request) throws InvocationTargetException, IllegalAccessException {
        Producer producer = new Producer();
        BeanUtils.copyProperties(producer, request);
        return producer;
    }

    //
    public ProductLineResponse convertProductLineToProductLineResponse(ProductLine productLine) {
        ProductLineResponse response = ProductLineResponse
                .builder()
                .id(productLine.getId())
                .code(productLine.getCode())
                .name(productLine.getName())
                .status(productLine.getStatus())
                .build();
        return response;
    }

    public ProductLine convertProductLineRequestToProductLine(ProductLineRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductLine productLine = new ProductLine();
        BeanUtils.copyProperties(productLine, request);
        return productLine;
    }

    public ProductResponse convertProductToProductResponse(Product product) {
        ProductResponse response = ProductResponse
                .builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .status(product.getStatus())
                .build();
        return response;
    }

    public Product convertProductRequestToProduct(ProductRequet request) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        BeanUtils.copyProperties(product, request);
        return product;
    }

    public ProductDetailResponse convertProductDetailToProductResponse(ProductDetail productDetail) {
        ProductDetailResponse response = ProductDetailResponse
                .builder()
                .id(productDetail.getId())
                .warrantyYear(productDetail.getWarrantyYear())
                .describe(productDetail.getDescribe().trim())
                .quantity(productDetail.getQuantity())
                .importPrice(productDetail.getImportPrice())
                .price(productDetail.getPrice())
                .status(productDetail.getStatus())
                // color
                .colorId(productDetail.getColor().getId())
                .colorCode(productDetail.getColor().getCode())
                .colorName(productDetail.getColor().getName())
                // product
                .productId(productDetail.getProduct().getId())
                .productCode(productDetail.getProduct().getCode())
                .productName(productDetail.getProduct().getName())
                // producer
                .producerId(productDetail.getProducer().getId())
                .producerCode(productDetail.getProducer().getCode())
                .producerName(productDetail.getProducer().getName())
                // product line
                .productLineId(productDetail.getProductLine().getId())
                .productLineCode(productDetail.getProductLine().getCode())
                .productLineName(productDetail.getProductLine().getName())
                .build();
        return response;
    }

    public ProductDetail convertProductDetailRequestToProductDetail(ProductDetailRequest request) throws InvocationTargetException, IllegalAccessException {
        ProductDetail productDetail = new ProductDetail();
        BeanUtils.copyProperties(productDetail, request);
        productDetail.setDescribe(productDetail.getDescribe().trim());
        // Đổi thành các lớp Resquet
        Product product = Product.builder().id(request.getProductId()).build();
        Producer producer = Producer.builder().id(request.getProducerId()).build();
        Color color = Color.builder().id(request.getColorId()).build();
        ProductLine productLine = ProductLine.builder().id(request.getProductLineId()).build();
        productDetail.setProduct(product);
        productDetail.setProducer(producer);
        productDetail.setColor(color);
        productDetail.setProductLine(productLine);
        return productDetail;
    }
}

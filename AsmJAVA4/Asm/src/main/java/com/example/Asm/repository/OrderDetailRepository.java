package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Order;
import com.example.Asm.entity.OrderDetail;
import com.example.Asm.entity.ProductDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDetailRepository {

    public List<OrderDetail> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<OrderDetail> result = session.createQuery("from OrderDetail ").getResultList();
        session.close();
        return result;
    }

    public void create(OrderDetail orderDetail) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(orderDetail);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
//        for (OrderDetail orderDetail : orderDetailRepository.getAll()){
//            System.out.println(orderDetail.getOrder() + " \n -- "+ orderDetail.getProductDetail().getProduct()
//            +"\n -- : SOm luong "+ orderDetail.getQuantity() + "\n : Don Gia : " + orderDetail.getUnitPrice());
//        }

        ProductDetail productDetail = ProductDetail.builder().id(18).build();
        Order order = Order.builder().id(18).build();
        OrderDetail orderDetail = OrderDetail.builder()
                .quantity(2)
                .unitPrice(200F)
                .order(order)
                .productDetail(productDetail)
                .build();
        orderDetailRepository.create(orderDetail);
    }
}

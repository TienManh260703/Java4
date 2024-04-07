package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class OrderRepository {

    public List<Order> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Order> result = session.createQuery("from  Order ").getResultList();
        session.close();
        return result;
    }

    public boolean create(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order getLastOrder() {
        Session session = HibernateConfig.getFACTORY().openSession();
        Order order = (Order) session.createQuery("from Order order by id desc ").setMaxResults(1).getSingleResult();
        session.close();
        return order;
    }


    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.create(Order.builder().build());
    }
}

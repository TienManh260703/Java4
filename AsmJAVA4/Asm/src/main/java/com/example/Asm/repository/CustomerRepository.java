package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {

    public List<Customer> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Customer> result = session.createQuery("from  Customer ").getResultList();
        session.close();
        return result;
    }

    public Customer getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Customer customer = (Customer) session.createQuery("from  Customer  where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        return customer;
    }

    public boolean create(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepository();
        for (Customer customer : repository.getAll()){
            System.out.println(customer);
        }
    }
}

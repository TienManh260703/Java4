package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Color;
import com.example.Asm.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository {
    public List<Product> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Product> result = session.createQuery("from Product ").getResultList();
        session.close();
        ;
        return result;
    }

    public Product getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Product product = (Product) session.createQuery("from Product where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        ;
        return product;
    }

    public boolean create(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void updateColorStatusById(int id, int status) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setStatus(status);
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

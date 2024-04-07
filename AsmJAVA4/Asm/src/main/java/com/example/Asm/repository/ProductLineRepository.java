package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Color;
import com.example.Asm.entity.ProductLine;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductLineRepository {

    public List<ProductLine> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<ProductLine> result = session.createQuery("from ProductLine ").getResultList();
        session.close();
        ;
        return result;
    }

    public ProductLine getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        ProductLine productLine = (ProductLine) session.createQuery("from ProductLine where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        ;
        return productLine;
    }

    public boolean create(ProductLine productLine) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(productLine);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ProductLine productLine) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(productLine);
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
            ProductLine productLine = session.get(ProductLine.class, id);
            productLine.setStatus(status);
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(ProductLine productLine) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(productLine);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

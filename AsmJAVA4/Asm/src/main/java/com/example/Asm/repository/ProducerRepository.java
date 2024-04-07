package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Color;
import com.example.Asm.entity.Producer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProducerRepository {
    public List<Producer> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Producer> result = session.createQuery("from Producer ").getResultList();
        session.close();
        return result;
    }

    public Producer getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Producer producer = (Producer) session.createQuery("from Producer where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        ;
        return producer;
    }

    public boolean create(Producer producer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(producer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Producer producer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(producer);
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
            Producer producer = session.get(Producer.class, id);
            producer.setStatus(status);
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Producer producer) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(producer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

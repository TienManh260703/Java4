package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Color;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ColorRepository {

    public List<Color> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Color> result = session.createQuery("from Color ").getResultList();
        session.close();
        return result;
    }

    public Color getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Color color = (Color) session.createQuery("from Color where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        return color;
    }

    public boolean create(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(color);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(color);
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
            Color color = session.get(Color.class, id);
            color.setStatus(status);
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(color);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

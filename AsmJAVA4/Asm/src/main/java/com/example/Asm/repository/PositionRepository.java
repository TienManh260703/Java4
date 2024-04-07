package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Position;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PositionRepository {
    public List<Position> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Position> result = session.createQuery("from Position ").getResultList();
        session.close();
        ;
        return result;
    }

    public Position getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Position position = (Position) session.createQuery("from Position where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        ;
        return position;
    }

    public boolean create(Position position) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(position);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Position position) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(position);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void updatePositionStatusById(int id, int status) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Position position = session.get(Position.class, id);
            position.setStatus(status);
            session.merge(status);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean delete(Position position) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(position);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

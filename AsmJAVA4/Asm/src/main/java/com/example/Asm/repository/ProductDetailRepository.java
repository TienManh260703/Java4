package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.request.ProductDetailRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDetailRepository {

    public List<ProductDetail> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<ProductDetail> result = session.createQuery("FROM ProductDetail").getResultList();
        return result;
    }

    public ProductDetail getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        ProductDetail productDetail = (ProductDetail) session.createQuery("FROM ProductDetail where id=:id ").setParameter("id", id).getSingleResult();
        return productDetail;
    }

    public boolean create(ProductDetail productDetail) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(productDetail);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ProductDetail productDetail) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(productDetail);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void updateQuantityById(int id , int status){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            ProductDetail productDetail = session.get(ProductDetail.class, id);
            productDetail.setStatus(status);
            session.merge(productDetail);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean delete(ProductDetail productDetail) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(productDetail);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}

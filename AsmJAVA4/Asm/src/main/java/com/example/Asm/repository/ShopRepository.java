package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Shop;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ShopRepository {

    public List<Shop> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Shop> result = session.createQuery("from  Shop ").getResultList();
        session.close();
        return result;
    }

    public Shop getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Shop result = (Shop) session.createQuery("from Shop  where id=:id").setParameter("id", id).getSingleResult();
        session.close();
        return result;
    }

    public void create(Shop shop) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(shop);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void update(Shop shop) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(shop);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void delete(Shop shop) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(shop);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        ShopRepository shopRepository = new ShopRepository();
//        Shop shop = Shop.builder()
//                .address("So 2/23/111")
//                .city("Da Nang 333")
//                .code("ShopDN")
//                .country("VN")
//                .name("Shop Heineken").build();
//        shopRepository.create(shop);
        for (Shop shop : shopRepository.getAll()) {
            System.out.println(shop.getCity() + " , " + shop.getAddress() + " , " + shop.getCode());
        }
    }
}

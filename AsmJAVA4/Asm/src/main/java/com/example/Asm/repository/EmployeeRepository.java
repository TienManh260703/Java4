package com.example.Asm.repository;

import com.example.Asm.config.HibernateConfig;
import com.example.Asm.entity.Position;
import com.example.Asm.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Employee> result = session.createQuery("from  Employee ").getResultList();
        session.close();
        return result;
    }

    public Employee getOne(int id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Employee result = (Employee) session.createQuery("from Employee where  id=:id").setParameter("id", id).getSingleResult();
        session.close();
        return result;
    }

    public void create(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployeeRoleById(int id, int newRole) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setPosition(Position.builder().id(newRole).build());
            session.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
//        for (Employee employee : employeeRepository.getAll()) {
//            System.out.println(employee + " -- : " + employee.getPosition().getName());
//        }
      System.out.println(  employeeRepository.getOne(1));
    }
}

package com.example.Asm.config;


import com.example.Asm.entity.Customer;
import com.example.Asm.entity.Color;
import com.example.Asm.entity.Order;
import com.example.Asm.entity.OrderDetail;
import com.example.Asm.entity.Position;
import com.example.Asm.entity.Producer;
import com.example.Asm.entity.Product;
import com.example.Asm.entity.ProductDetail;
import com.example.Asm.entity.ProductLine;
import com.example.Asm.entity.Shop;
import com.example.Asm.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(Customer.class);
//        Product
        conf.addAnnotatedClass(Color.class);
        conf.addAnnotatedClass(ProductDetail.class);
        conf.addAnnotatedClass(ProductLine.class);
        conf.addAnnotatedClass(Producer.class);
        conf.addAnnotatedClass(Product.class);
//        Staff
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Shop.class);
        conf.addAnnotatedClass(Position.class);
        conf.addAnnotatedClass(Order.class);
        conf.addAnnotatedClass(OrderDetail.class);



        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}

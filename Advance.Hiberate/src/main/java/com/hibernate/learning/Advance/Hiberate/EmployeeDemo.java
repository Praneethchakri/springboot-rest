package com.hibernate.learning.Advance.Hiberate;

import com.hibernate.learning.Advance.Hiberate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class EmployeeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();
try {
    Employee employeeDemo = new Employee("Praneeth", "Diguvapalem", "Praneeth.itdev@gmail.com");
    Set<String> socialNetwork = employeeDemo.getSocialNetwork();
    socialNetwork.add("Gmail");
    socialNetwork.add("LinkedIn");
    socialNetwork.add("Facebook");
    socialNetwork.add("Instagram");
    socialNetwork.add("snapshot");

    session.beginTransaction();

    session.persist(employeeDemo);
    session.getTransaction().commit();
}finally {
    session.close();
    sessionFactory.close();
}
    }
}

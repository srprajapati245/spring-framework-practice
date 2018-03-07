package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // start transaction
            System.out.println("Begining a new transaction");
            session.beginTransaction();

            // retrive student based on the id: primary key
            Student student = session.get(Student.class, studentId);
            System.out.println("Get complete "+ student);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }
}

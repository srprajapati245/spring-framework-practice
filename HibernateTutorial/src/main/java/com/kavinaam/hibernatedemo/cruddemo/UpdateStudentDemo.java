package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
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

            // Retrieve student based on the id: primary key
            System.out.println("Getting student with id: "+studentId);
            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student....");
            student.setEmail("sanjay@rudraautomation.com");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

            // New Code

            // Get new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }
}

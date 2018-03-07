package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create a student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Sanjay", "Prajapati", "srprajapati245@gmail.com");

            // start transaction
            System.out.println("Begining a new transaction");
            session.beginTransaction();

            // save the student
            System.out.println("Save the studetnt...");
            session.save(student);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }
}

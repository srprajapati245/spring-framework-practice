package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMultipleStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create a student object
            System.out.println("Creating 3 student object...");
            Student student = new Student("Sanjay", "Prajapati", "srprajapati245@gmail.com");
            Student student1 = new Student("Parth", "Darji", "parth15darji@gmail.com");
            Student student2 = new Student("Debanshu", "Gauguly", "debanshu@zenfotech.co.in");
            Student student3 = new Student("Sandip", "Pandya", "sandip.com.com@gmail.com");

            // start transaction
            System.out.println("Begining a new transaction");
            session.beginTransaction();

            // save the student
            System.out.println("Save the studetnt...");
            session.save(student);
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }
}

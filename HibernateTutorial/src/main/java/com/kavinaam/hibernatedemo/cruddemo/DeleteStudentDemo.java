package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studetnId = 4;

            // start transaction
            System.out.println("Begining a new transaction");
            session.beginTransaction();

            // Retrieve student based on the id: primary key
            System.out.println("Getting student with id: "+studetnId);
            Student student = session.get(Student.class, studetnId);

            // delete student
            System.out.println("Delete student: "+student);
            session.delete(student);

            // delete student id=3
            session.createQuery("delete from Student where id=3").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }
}

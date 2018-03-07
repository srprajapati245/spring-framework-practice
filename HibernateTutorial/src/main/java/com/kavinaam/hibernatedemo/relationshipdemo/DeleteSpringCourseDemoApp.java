package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSpringCourseDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get course from database
            int courseId = 6;
            Course course = session.get(Course.class, courseId);

            // delete course
            System.out.println("\nDeleting Course: "+course);
            session.delete(course);

            // commit
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

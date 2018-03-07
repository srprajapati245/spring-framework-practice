package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseForKalpeshDemoApp {
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

            // get Kalpesh student from database
            int studentId = 4;
            Student student = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: "+student);
            System.out.println("\nCourses: "+student.getCourses());

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

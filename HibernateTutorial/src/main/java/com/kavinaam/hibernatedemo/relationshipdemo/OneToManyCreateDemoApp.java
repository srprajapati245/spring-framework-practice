package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreateDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // Create instructor object
            Instructor instructor = new Instructor("Pravin", "Jain", "pravin@zensoftech.co.in");

            // create instructor detail object
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/user/classofjava", "coding");
            instructor.setInstructorDetail(instructorDetail);

            // begin transaction
            session.beginTransaction();

            // add instructor object
            session.save(instructor);

            // commit
            session.getTransaction().commit();

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneCreateDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor instructor = new Instructor("Pravin", "Jain", "pravin@zensoftech.co.in");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/user/classofjava", "Coding");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // begin transaction
            session.beginTransaction();

            // save instructor
            // Note: this will also save the details object because of CasecadeType.ALL
            System.out.println("Saving Instructor: "+instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            factory.close();
        }

    }
}

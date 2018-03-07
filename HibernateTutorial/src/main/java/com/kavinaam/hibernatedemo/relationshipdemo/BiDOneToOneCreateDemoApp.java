package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDOneToOneCreateDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get instructor detail object
            int theId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("\ninstructorDetail: "+instructorDetail);

            // print the associated instructor
            System.out.println("\nAssociated Instructor: "+instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }

    }
}

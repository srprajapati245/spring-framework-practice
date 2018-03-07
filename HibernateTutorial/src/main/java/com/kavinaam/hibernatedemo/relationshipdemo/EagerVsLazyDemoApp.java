package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazyDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get the instructor from db
            int instructorId = 3;
            Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println("Zen Softech: "+instructor);
            System.out.println("Zen Softech: "+instructor.getCourses());

            // commit
            session.getTransaction().commit();

            // close session
            session.close();
            System.out.println("Zen Softech: The session is now close");

            // Option 1: call getter method while session is open

            System.out.println("Zen Softech: "+instructor.getCourses());
            //instructor.getCourses().stream().forEach(e);


            System.out.println("Zen Softech: Done!");
        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

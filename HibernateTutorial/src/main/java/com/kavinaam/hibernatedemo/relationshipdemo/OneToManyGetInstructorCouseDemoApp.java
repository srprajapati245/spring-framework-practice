package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyGetInstructorCouseDemoApp {
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

            System.out.println(instructor);
            System.out.println(instructor.getCourses());
            //instructor.getCourses().stream().forEach(e);

            // commit
            session.getTransaction().commit();

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

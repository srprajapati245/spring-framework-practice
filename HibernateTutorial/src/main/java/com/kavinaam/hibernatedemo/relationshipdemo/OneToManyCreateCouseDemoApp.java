package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreateCouseDemoApp {
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

            // create some courses
            Course coreJavaCourse = new Course("Core Java 8");
            Course java8EnhancementCourse = new Course("Java 8 Enhancement");

            // add courses to instructor
            instructor.add(coreJavaCourse);
            instructor.add(java8EnhancementCourse);

            // save the courses
            session.save(coreJavaCourse);
            session.save(java8EnhancementCourse);

            // commit
            session.getTransaction().commit();

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

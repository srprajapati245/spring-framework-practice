package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDeleteDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get instructor by primary key / id
            int theId = 2;
            Instructor instructor = session.get(Instructor.class, theId);
            System.out.println("Fount instructor: "+instructor);


            if(instructor != null) {
                //instructor.getInstructorDetail().setInstructor(null);
                //instructor.getCourses().stream().forEach(e -> e.setInstructor(null));

                // delete instructors
                System.out.println("Deleting: "+instructor);

                // Note: Also delete associated "details" object
                // because of CasecadeType.ALL
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }

    }
}

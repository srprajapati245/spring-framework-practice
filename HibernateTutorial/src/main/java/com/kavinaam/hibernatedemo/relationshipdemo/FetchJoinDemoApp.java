package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemoApp {
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


            // option 2: Hibernate query with HQL
            // get the instructor from db
            int instructorId = 3;
            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                                                                "JOIN FETCH i.courses " +
                                                                "where i.id=:instructorId",
                                                            Instructor.class);

            // set parameter on query
            query.setParameter("instructorId", instructorId);

            // execute  query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("Zen Softech: "+instructor);

            // commit
            session.getTransaction().commit();

            // close session
            session.close();
            System.out.println("\nZen Softech: The session is now close\n");

            System.out.println("Zen Softech: "+instructor.getCourses());

            System.out.println("Zen Softech: Done!");
        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

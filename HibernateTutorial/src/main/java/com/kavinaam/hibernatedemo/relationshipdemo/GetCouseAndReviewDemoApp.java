package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import com.kavinaam.hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCouseAndReviewDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get course
            int courseId = 3;
            Course course = session.get(Course.class, courseId);

            // print course
            System.out.println("\n"+course+"\n");

            // print course review
            System.out.println("\n"+course.getReviews()+"\n");

            // commit
            session.getTransaction().commit();

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

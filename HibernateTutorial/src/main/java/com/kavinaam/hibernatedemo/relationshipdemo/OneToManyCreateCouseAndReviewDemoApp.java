package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.Course;
import com.kavinaam.hibernatedemo.entity.Instructor;
import com.kavinaam.hibernatedemo.entity.InstructorDetail;
import com.kavinaam.hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreateCouseAndReviewDemoApp {
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

            // get the instructor from db
            int instructorId = 3;

            Instructor instructor = session.get(Instructor.class, instructorId);

            // create a course
            Course course = new Course("Advanced Java");

            // add some reviews
            course.addReview(new Review("This is best course...."));
            course.addReview(new Review("Great course"));
            course.addReview(new Review("Best course to learn java"));
            course.addReview(new Review("Good but very boring"));

            // set instructor
            course.setInstructor(instructor);

            // save the course ... and leverage the cascade all :-)
            System.out.println("Save course: "+course);
            session.save(course);

            // commit
            session.getTransaction().commit();

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

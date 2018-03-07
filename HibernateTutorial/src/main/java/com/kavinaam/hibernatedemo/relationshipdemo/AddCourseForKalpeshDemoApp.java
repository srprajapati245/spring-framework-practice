package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForKalpeshDemoApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // begin transaction
            session.beginTransaction();

            // get the instructor from db
            int instructorId = 3;

            Instructor instructor = session.get(Instructor.class, instructorId);

            // get Sanjay student from database
            int studentId = 4;
            Student student = session.get(Student.class, studentId);
            System.out.println("\nLoaded student: "+student);
            System.out.println("\nCourses: "+student.getCourses());


            // create more courses
            Course course1 = new Course("Java 8 Enhancements");
            Course course2 = new Course("Spring Framework");
            course1.setInstructor(instructor);
            course2.setInstructor(instructor);

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            // save course
            System.out.println("\nSaving courses: ");
            session.save(course1);
            session.save(course2);

            // commit
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            // close session to prevent database lick
            session.close();
            factory.close();
        }


    }
}

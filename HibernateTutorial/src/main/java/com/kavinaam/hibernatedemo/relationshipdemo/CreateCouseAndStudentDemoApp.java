package com.kavinaam.hibernatedemo.relationshipdemo;

import com.kavinaam.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCouseAndStudentDemoApp {
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

            // create a course
            Course course = new Course("Advanced Java");

            // set instructor
            course.setInstructor(instructor);

            // save the course ... and leverage the cascade all :-)
            System.out.println("Save course: "+course);
            session.save(course);

            // create the students
            Student student1 = new Student("Debanshu", "Gauguly", "debanshu@zensoftech.co.in");
            Student student2 = new Student("Kaplesh", "Joshi", "kalpeshjoshi@gmail.com");

            // add students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("\nSaving students");
            System.out.println(student1);
            System.out.println(student2);
            session.save(student1);
            session.save(student2);

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

package com.kavinaam.hibernatedemo.cruddemo;

import com.kavinaam.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start transaction
            System.out.println("Begining a new transaction");
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").getResultList();

            // display students
            displayStudents(students);

            // query students: lastName='Prajapati'
            List<Student> students2 = session.createQuery("from Student s where s.lastName = 'Prajapati'").getResultList();

            // display students
            System.out.println("\nStudents who have lastName: Prajapati");
            displayStudents(students2);

            // query students: email like '@gmail.com'
            List<Student> students3 = session.createQuery("from Student s where s.email like '%@gmail.com'").getResultList();

            // display students
            System.out.println("\nStudents who have email on gmail");
            displayStudents(students3);

            // query students: lastName=Prajapati and email like '@gmail.com'
            List<Student> students4 = session.createQuery("from Student s where s.lastName='Prajapati' AND s.email like '%@gmail.com'").getResultList();

            // display students
            System.out.println("\nStudents who have lastName=Prajapati and email on gmail");
            displayStudents(students4);

            // query students: lastName=Prajapati or email like '@gmail.com'
            List<Student> students5 = session.createQuery("from Student s where s.lastName='Prajapati' OR s.email like '%@gmail.com'").getResultList();

            // display students
            System.out.println("\nStudents who have lastName=Prajapati or email on gmail");
            displayStudents(students5);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Commit and done!");

        } finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> students) {
        for(Student student: students)
            System.out.println(student);
    }
}

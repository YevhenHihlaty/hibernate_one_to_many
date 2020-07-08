package com.hibernate.demo;

import com.entities.Course;
import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseDemoBi {
    public static void main(String[] args) {

        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor instructor=
                    session.get(Instructor.class, 1);
            Course course1 =
                    new Course("Air Guitar - The Ultimate Guide");

            Course course2 =
                    new Course("The Pinball Masterclass");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}

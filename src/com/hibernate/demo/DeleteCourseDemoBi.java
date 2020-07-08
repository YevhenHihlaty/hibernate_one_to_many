package com.hibernate.demo;

import com.entities.Course;
import com.entities.Instructor;
import com.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemoBi {
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

            /*Instructor instructor=
            session.get(Instructor.class, 1);
            instructor.getCourses().forEach(it -> it.setInstructor(null));
            instructor.getInstructorDetail().setInstructor(null);
                */
            Course course=
                    session.get(Course.class, 10);
            session.delete(course);
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

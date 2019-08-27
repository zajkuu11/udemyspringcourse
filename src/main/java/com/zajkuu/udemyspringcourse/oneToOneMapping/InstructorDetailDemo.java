package com.zajkuu.udemyspringcourse.oneToOneMapping;

import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateOneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            InstructorDetail instructorDetail;
            Instructor instructor;
            session.beginTransaction();
            int id = 3;
            instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("temp: " + instructorDetail.toString());
            System.out.println("instructor: " + instructorDetail.getInstructor().toString());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}

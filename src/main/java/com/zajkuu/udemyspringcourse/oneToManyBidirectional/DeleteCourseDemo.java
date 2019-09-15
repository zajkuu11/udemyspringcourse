package com.zajkuu.udemyspringcourse.oneToManyBidirectional;


import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Course;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateOneToManyBidirectional.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = session.get(Course.class, 17);

            System.out.println("Deleting course: " + course);

            session.delete(course);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

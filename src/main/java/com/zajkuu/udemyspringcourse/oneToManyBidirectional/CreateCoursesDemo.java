package com.zajkuu.udemyspringcourse.oneToManyBidirectional;


import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Course;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;

public class CreateCoursesDemo {
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
            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("course1");
            Course course2 = new Course("course2");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();

            factory.close();
        }
    }
}

package com.zajkuu.udemyspringcourse.oneToManyBidirectional;


import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Course;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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
            System.out.println("Instructor: " + instructor);

            System.out.println("Course: " + instructor.getCourses());

            session.getTransaction().commit();
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }
}

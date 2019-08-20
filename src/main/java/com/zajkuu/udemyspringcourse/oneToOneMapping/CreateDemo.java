package com.zajkuu.udemyspringcourse.oneToOneMapping;

import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateOneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Guitar");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("New instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }
}

package com.zajkuu.udemyspringcourse.oneToManyBidirectional;


import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Course;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToManyBidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateOneToManyBidirectional.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            int id = 5;

            Instructor instructor = new Instructor("Jan", "Kowalski", "kowal@he.com");
            InstructorDetail instructorDetail = new InstructorDetail("yt.com", "test");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

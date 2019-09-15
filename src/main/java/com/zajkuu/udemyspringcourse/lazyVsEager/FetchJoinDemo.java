package com.zajkuu.udemyspringcourse.lazyVsEager;


import com.zajkuu.udemyspringcourse.lazyVsEager.entity.Course;
import com.zajkuu.udemyspringcourse.lazyVsEager.entity.Instructor;
import com.zajkuu.udemyspringcourse.lazyVsEager.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernateOneToManyBidirectional.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            int theId = 1;
            session.beginTransaction();
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + "JOIN fetch i.courses "
                            + "where i.id=:theInstructorId",
                    Instructor.class);


            query.setParameter("theInstructorId", theId);


            session.getTransaction().commit();
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }
}
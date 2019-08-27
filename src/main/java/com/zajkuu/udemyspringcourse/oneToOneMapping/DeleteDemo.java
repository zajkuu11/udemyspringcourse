package com.zajkuu.udemyspringcourse.oneToOneMapping;

import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToOneMapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateOneToOne.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 2;
            Instructor instructor = session.get(Instructor.class, id);


            if (instructor != null){
                System.out.println("deleting: " + instructor);

                session.delete(instructor);
            }



            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }
}

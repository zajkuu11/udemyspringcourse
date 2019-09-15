package com.zajkuu.udemyspringcourse.oneToManyUni;


import com.zajkuu.udemyspringcourse.oneToManyUni.entity.Course;
import com.zajkuu.udemyspringcourse.oneToManyUni.entity.Instructor;
import com.zajkuu.udemyspringcourse.oneToManyUni.entity.InstructorDetail;
import com.zajkuu.udemyspringcourse.oneToManyUni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateOneToManyUni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Test Course");

            course.addReview(new Review("Test Comment 0"));
            course.addReview(new Review("Test Comment 1"));
            course.addReview(new Review("Test Comment 2"));

            System.out.println("Saving course \n\n");
            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);

            session.getTransaction().commit();
        } finally {
            session.close();

            factory.close();
        }
    }
}

package com.zajkuu.udemyspringcourse.manyToMany;


import com.zajkuu.udemyspringcourse.manyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernateManyToMany.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Course 1");

            System.out.println("\nSaving course: ");
            session.save(course);
            System.out.println();

            Student student = new Student("First0", "Last", "Mail");
            Student student1 = new Student("First1", "Last", "Mail");
            Student student2 = new Student("First2", "Last", "Mail");


            course.addStudent(student);
            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student);
            session.save(student1);
            session.save(student2);


            session.getTransaction().commit();
        } finally {
            session.close();

            factory.close();
        }
    }
}

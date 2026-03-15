import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter name: ");
//        s1.setName(in.next());
//        System.out.println("Enter email: ");
//        s1.setEmail(in.next());
//        System.out.println("Enter marks: ");
//        s1.setMarks(in.nextInt());

//        Student s1 = new Student();
        Scanner in = new Scanner(System.in);
//        System.out.print("Enter name: ");
//        s1.setName(in.next());
//        System.out.print("Enter email: ");
//        s1.setEmail(in.next());
//        System.out.print("Enter marks: ");
//        s1.setMarks(in.nextInt());

        Student s3 = new Student();


        Student s2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

//        session.persist(s1);

//        System.out.print("Enter id to see records: ");
//        s2 = session.find(Student.class,in.nextInt());

//        System.out.print("Enter id to delete records: ");
//        s2 = session.find(Student.class,in.nextInt());
//        session.remove(s2);

        System.out.print("Enter id to update records: ");
        int id = in.nextInt();
        s3.setId(id);
        s3 = session.find(Student.class,id);
        System.out.print("Enter marks to update: ");
        s3.setMarks(in.nextInt());
        session.merge(s3);

        transaction.commit();
//        System.out.println(s2);

        session.close();
        sf.close();
        in.close();
    }
}

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;

    public static SessionFactory getSf() {
        if(sf == null){
            sf = new Configuration()
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Laptop.class)
                    .addAnnotatedClass(Certificates.class)
                    .configure()
                    .buildSessionFactory();
        }
        return sf;
    }
}

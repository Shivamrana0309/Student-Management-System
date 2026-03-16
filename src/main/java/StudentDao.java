import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
    public void saveStudent(Student student){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSf().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("Student saved Successfully!");
        } catch (Exception e) {
            if(transaction!=null && transaction.isActive()) transaction.rollback();
        }
    }
    public Student readStudent(int id){
        try (Session session = HibernateUtil.getSf().openSession()) {
            return session.find(Student.class,id);
        } catch (Exception e) {
            return null;
        }
    }
    public void updateStudent(Student student){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSf().openSession()) {
            transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
            System.out.println("Student Updated Successfully!");
        } catch (Exception e) {
            if(transaction!=null && transaction.isActive()) transaction.rollback();
        }
    }
    public void deleteStudent(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSf().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.find(Student.class,id);
            if(student!=null){
                session.remove(student);
                System.out.println("Student Deleted Successfully!");
            }
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null && transaction.isActive()) transaction.rollback();
        }
    }
}

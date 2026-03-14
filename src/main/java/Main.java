import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/Students";
        String usr = "root";
        String pass = "Shiv@0912";

        Connection con = DriverManager.getConnection(url, usr, pass);

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("""
                    Enter Choice:
                    1. Add Student
                    2. Update email
                    3. Update marks
                    4. Delete Student
                    5. Show Student
                    6. Exit
                    """);
            int choice = in.nextInt();
            if(choice==1){
                System.out.println("""
                        Enter details:
                        1. Name 
                        2. Email
                        3. Marks
                        """);
                String name = in.next();
                String email = in.next();
                int marks = in.nextInt();

                String sql = "insert into students(name,email,marks) values (?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1,name);
                st.setString(2,email);
                st.setInt(3,marks);
                st.execute();
                System.out.println("Record saved Successfully");
            }
            else if(choice==2){
                System.out.println("Enter id to update email: ");
                int id = in.nextInt();
                System.out.println("Enter new email: ");
                String email = in.next();
                String sql = "update students set email = ? where id = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1,email);
                st.setInt(2,id);
                st.execute();
                System.out.println("Email updated successfully");
            }
            else if(choice==3){
                System.out.println("Enter id to update the marks");
                int id = in.nextInt();
                System.out.println("Enter new marks");
                int marks = in.nextInt();
                String sql ="update students set marks =? where id = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1,marks);
                st.setInt(2,id);
                st.execute();
                System.out.println("Marks updated successfully");
            }
            else if(choice==4){
                System.out.println("Enter id to delete a student");
                int id = in.nextInt();
                String sql = "delete from students where id = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1,id);
                st.execute();
                System.out.println("Record deleted successfully");
            }
            else if(choice==5){
                System.out.println("Enter id to See a record ");
                int id = in.nextInt();
                String sql = "select * from students";
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    System.out.println("id: " + rs.getInt(1));
                    System.out.println("name: " + rs.getString(2));
                    System.out.println("email: "+ rs.getString(3));
                    System.out.println("marks: "+rs.getInt(4));
                }
            }
            else{
                System.out.println("Exiting....");
                break;
            }
        }

    }
}

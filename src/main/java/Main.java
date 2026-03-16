import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Student s1 = new Student();
        System.out.print("Enter name: ");
        s1.setName(in.nextLine());
        System.out.print("Enter email: ");
        s1.setEmail(in.nextLine());
        System.out.print("Enter marks: ");
        s1.setMarks(Integer.parseInt(in.nextLine()));

        Address address = new Address();
        System.out.print("Enter Address Line 1: ");
        address.setAdd(in.nextLine());
        System.out.print("Enter City: ");
        address.setCity(in.nextLine());
        System.out.print("Enter State: ");
        address.setState(in.nextLine());
        System.out.print("Enter Pin code: ");
        address.setPincode(Integer.parseInt(in.nextLine()));

        Laptop laptop = new Laptop();
        System.out.print("Enter brand: ");
        laptop.setBrand(in.nextLine());
        System.out.print("Enter model: ");
        laptop.setModel(in.nextLine());
        System.out.print("Enter ram: ");
        laptop.setRam(in.nextLine());
        System.out.print("Enter price: ");
        laptop.setPrice(Integer.parseInt(in.nextLine()));

        Certificates c1 = new Certificates();
        c1.setName("Java");
        Certificates c2 = new Certificates();
        c2.setName("C++");

        s1.getCertificatesList().add(c1);
        s1.getCertificatesList().add(c2);

        s1.setAddress(address);
        s1.setLaptop(laptop);

        c1.setStudent(s1);
        c2.setStudent(s1);

        StudentDao sd = new StudentDao();
        sd.saveStudent(s1);
    }
}
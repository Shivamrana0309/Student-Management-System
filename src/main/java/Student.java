import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students") // TABLE NAME
public class Student {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT for PRIMARY KEY
    private int id;
    private String name;
    private String email;
    private int marks;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="l_id")
    private Laptop laptop;
//    @OneToMany(mappedBy = "Student")
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) // BI-DIRECTIONAL MAPPING
//    @JoinColumn(name = "Student_id")
    private List<Certificates> certificatesList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_project",
            joinColumns = {@JoinColumn(name = "s_id")},
            inverseJoinColumns = {@JoinColumn(name = "p_id")}
    )
    private List<Project> projects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Certificates> getCertificatesList() {
        return certificatesList;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getMarks() {
        return marks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setCertificatesList(List<Certificates> certificatesList) {
        this.certificatesList = certificatesList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", marks=" + marks +
                '}';
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}

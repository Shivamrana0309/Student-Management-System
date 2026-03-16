import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String projectname;
    @ManyToMany(mappedBy = "projects")
    private List<Student> students = new ArrayList<>();

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getPid() {
        return pid;
    }

    public String getProjectname() {
        return projectname;
    }

    public List<Student> getStudents() {
        return students;
    }
}

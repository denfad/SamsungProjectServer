package ru.denfad.dbunivesity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "faculty")
    private String faculty;

    @JsonIgnore
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private Set<Student> students;

    public Group(int groupId, String faculty) {
        this.groupId = groupId;
        this.faculty = faculty;
    }

    public Group() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        student.setGroup(this);
        this.students.add(student);

    }
}

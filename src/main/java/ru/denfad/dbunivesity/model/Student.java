package ru.denfad.dbunivesity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private String birthDate;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id",  foreignKey = @ForeignKey(name = "fk_student_group_id"))
    private Group group;


    public Student(int student_id, String name, String secondName, String middleName, String birthDate, Group group) {
        this.student_id=student_id;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Student(String name, String secondName, String middleName, String birthDate, Group group) {
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Student() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

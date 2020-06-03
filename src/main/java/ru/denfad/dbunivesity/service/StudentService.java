package ru.denfad.dbunivesity.service;

import ru.denfad.dbunivesity.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    public Student getStudentByID(int id);
    public List<Student> getAllStudents();
    public void deleteStudent(int id);
    public void updateStudent(Student student);
    public void addStudent(Student student, int group_id);
    public List<Student> findStudentsByGroup(int group_id);
    public List<Student> sortStudentsBySecondName();
    public List<Student> sortStudentsByGroupId();
    public List<Student> searchStudent(String words);
}

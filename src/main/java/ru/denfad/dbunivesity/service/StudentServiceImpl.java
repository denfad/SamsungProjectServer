package ru.denfad.dbunivesity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.dbunivesity.model.Group;
import ru.denfad.dbunivesity.model.Student;
import ru.denfad.dbunivesity.repository.GroupRepository;
import ru.denfad.dbunivesity.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository=studentRepository;
    }

    @Override
    public Student getStudentByID(int id) {

        return studentRepository.getOne(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void addStudent(Student student,int group_id) {
        Group group = groupRepository.getOne(group_id);
        group.addStudent(student);
        groupRepository.save(group);
    }

    @Override
    public List<Student> findStudentsByGroup(int group_id) {
        return studentRepository.findStudentsByGroupId(group_id);
    }

    @Override
    public List<Student> sortStudentsBySecondName() {
        return studentRepository.sortStudentsBySecondName();
    }

    @Override
    public List<Student> sortStudentsByGroupId() {
        return studentRepository.sortStudentsByGroupId();
    }

    @Override
    public List<Student> searchStudent(String searchRequest) {
        String[] words = searchRequest.replace('"',' ').split(" ");
        for(String s:words) System.out.println(s);
        return studentRepository.searchStudents(words);
    }
}

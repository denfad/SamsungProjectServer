package ru.denfad.dbunivesity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denfad.dbunivesity.model.Group;
import ru.denfad.dbunivesity.model.Student;
import ru.denfad.dbunivesity.repository.GroupRepository;
import ru.denfad.dbunivesity.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository=studentRepository;
    }


    @Override
    public Group getGroupByID(int id) {
        return groupRepository.getOne(id);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public boolean isEmptyGroup(int id) {
        if(studentRepository.findStudentsByGroupId(id).isEmpty()) return true;
        else return false;
    }

    @Override
    public void deleteGroupAnyway(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

}

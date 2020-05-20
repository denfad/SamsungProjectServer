package ru.denfad.dbunivesity.service;

import ru.denfad.dbunivesity.model.Group;


import java.util.List;

public interface GroupService {
    public Group getGroupByID(int id);
    public List<Group> getAllGroups();
    public boolean isEmptyGroup(int id);
    public void deleteGroupAnyway(int id);
    public void updateGroup(Group group);
    public void addGroup(Group group);
}

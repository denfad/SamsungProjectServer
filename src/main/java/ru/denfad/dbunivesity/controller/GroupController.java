package ru.denfad.dbunivesity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.denfad.dbunivesity.model.Group;
import ru.denfad.dbunivesity.service.GroupService;

import java.util.List;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService=groupService;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Group>  getAllGroups(){
        return groupService.getAllGroups();
    }

    @PutMapping(path = "/", consumes = "application/json")
    public void  addGroup(@RequestBody Group group){
       groupService.addGroup(group);
    }

    @GetMapping(path = "/isempty/{id}",  produces = "application/json")
    public boolean checkIsEmptyGroup(@PathVariable(name = "id") int id){
        return groupService.isEmptyGroup(id);
    }

    @DeleteMapping(path = "/delete/{id}", consumes = "application/json")
    public void deleteGroupAnyway(@PathVariable(name = "id") int id){
        groupService.deleteGroupAnyway(id);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Group getGroup(@PathVariable(name = "id") int id){
        return  groupService.getGroupByID(id);
    }
}

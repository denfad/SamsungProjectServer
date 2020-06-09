package ru.denfad.dbunivesity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.denfad.dbunivesity.model.Student;
import ru.denfad.dbunivesity.service.GroupService;
import ru.denfad.dbunivesity.service.StudentService;
import ru.denfad.dbunivesity.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public void addStudent(@PathVariable(name="id") int id, @RequestBody Student student){
        studentService.addStudent(student,id);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Student getStudent(@PathVariable(name="id") int id){
        return studentService.getStudentByID(id);
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Student> getAllStudents(@RequestParam(required = false) String sortType){
        if(sortType==null) sortType="";
        switch (sortType) {
            case "name":
                return studentService.sortStudentsBySecondName();
            case "groupid":
                return studentService.sortStudentsByGroupId();
            default:
                return studentService.getAllStudents();
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") int id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update", consumes = "application/json")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @GetMapping(path = "/group/{id}", produces = "application/json")
    public List<Student> getStudentsByGroupId(@PathVariable(name="id") int id){
        return studentService.findStudentsByGroup(id);
    }

    @PostMapping(path="/search",consumes = "application/json",produces = "application/json")
    public List<Student> searchStudent(@RequestBody String searchRequest){
       return studentService.searchStudent(searchRequest);
    }
}

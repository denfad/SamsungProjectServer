package ru.denfad.dbunivesity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denfad.dbunivesity.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select s from Student s where s.group.groupId = :id")
    List<Student> findStudentsByGroupId(@Param("id") int id);

    @Query("select s from Student s order by s.secondName,s.name,s.middleName asc")
    List<Student> sortStudentsBySecondName();

    @Query("select s from Student s order by s.group.groupId, s.student_id asc")
    List<Student> sortStudentsByGroupId();

    @Query("select s from Student s " +
            "where s.name in :words " +
            "or s.secondName in :words")
    List<Student> searchStudents(@Param("words") String[] words);
}

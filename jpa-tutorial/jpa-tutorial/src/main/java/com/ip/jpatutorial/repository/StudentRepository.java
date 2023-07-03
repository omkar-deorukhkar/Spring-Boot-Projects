package com.ip.jpatutorial.repository;

import com.ip.jpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL - deals with Entity class and not the relation, ?1 means first argument
    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailId(String EmailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String findFirstNameByEmailId(String EmailId);

    // Native Query with named parameter
    @Query(nativeQuery = true, value = "select * from student where emailaddress = :emailId")
    public Student findByEmailIdNative(@Param("emailId") String EmailId);

    @Modifying // necessary when modifying a DB record
    @Transactional // shows a transaction operation, can be added at service layer too, if more than 1 repo methods perform transactions
    @Query(nativeQuery = true, value = "update student set first_name = :firstName where emailaddress= :emailId")
    public void updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);
}

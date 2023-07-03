package com.ip.jpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    // We need to create bi-directional mapping by adding @OneToOne annotation here
    // mappedBy property tells that the relation is mapped by course's primary key in the other table
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    // A many to many relationship requires a separate mapping table
    // here we use @JoinTable annnotation to create that table
    // joinColumns property defines the column this relation will contribute to the map
    // inverseJoinColumns property defines the column the other relation will contribute to the map

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    )
    private List<Student> students;

    // This is a good practice to have methods to add objects, when we hae list properties
    public void addStudents(Student student){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }

}

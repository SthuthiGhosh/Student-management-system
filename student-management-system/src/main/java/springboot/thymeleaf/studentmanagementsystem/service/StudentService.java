package springboot.thymeleaf.studentmanagementsystem.service;

import java.util.List;

import springboot.thymeleaf.studentmanagementsystem.entity.Student;

/**
 * Service class
 */
public interface StudentService {

    //Method to get all students
    List<Student> getAllStudents();

    //Method to save student
    Student saveStudent(Student student);

    //Method to get student by Id
    Student getStudentById(Long id);

    //Method to update student
    Student updateStudent(Student student);

    //Method to delete student by Id
    void deleteStudentById(Long id);

}

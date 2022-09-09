package springboot.thymeleaf.studentmanagementsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.thymeleaf.studentmanagementsystem.entity.Student;
import springboot.thymeleaf.studentmanagementsystem.repository.StudentRepository;
import springboot.thymeleaf.studentmanagementsystem.service.StudentService;

/**
 * Service implementation class
 */
@Service
public class StudentServiceImpl implements StudentService {

    // Bean injection for repository class
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    /**
     * Method to get all students
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     *Method to save students
     */
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     *Method to get student by id
     */
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    /**
     *Method to update student
     */
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     *Method to delete student by id
     */
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

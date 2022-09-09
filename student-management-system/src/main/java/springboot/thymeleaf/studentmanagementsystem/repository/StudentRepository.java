package springboot.thymeleaf.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.thymeleaf.studentmanagementsystem.entity.Student;

/**
 * Repository interface extending Jpa repository
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}

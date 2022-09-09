package springboot.thymeleaf.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springboot.thymeleaf.studentmanagementsystem.entity.Student;
import springboot.thymeleaf.studentmanagementsystem.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("sthuthi", "Ghosh", "sthuhtighoshm@gmail.com");
//        studentRepository.save(student1);
//        Student student2 = new Student("arun", "kumar", "arun@gmail.com");
//        studentRepository.save(student2);
//        Student student3 = new Student("amal", "ram", "amal@gmail.com");
//        studentRepository.save(student3);
    }
}

package springboot.thymeleaf.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import springboot.thymeleaf.studentmanagementsystem.entity.Student;
import springboot.thymeleaf.studentmanagementsystem.service.StudentService;

/**
 * Controller class
 */
@Controller
public class StudentController {

    // Bean injection for service class
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    /**
     * Handler method to handle list of students and return model and view
     *
     * @param model
     *            model
     * @return students list view
     */
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    /**
     * Handler method to handle create students and return form
     *
     * @param model
     *            model
     * @return create student form
     */
    @GetMapping("/students/new")
    public String crerateStudentForm(Model model) {
        // Create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    /**
     * Handler method to handle saving students
     *
     * @param student
     *            student object
     * @return student list with saved student
     */
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    /**
     * Handler method to handle update students and return form to update
     *
     * @param id
     *            id
     * @param model
     *            model
     * @return edit student form
     */
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    /**
     * Handler method to handle save updated students
     *
     * @param id
     *            id
     * @param student
     *            student object
     * @param model
     *            model
     * @return student list with updated student info
     */
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        // Get student from database by id and update it
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // Save updated student object into DB
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    /**
     * Handler method to handle delete students
     *
     * @param id
     *            id
     * @return student list
     */
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}

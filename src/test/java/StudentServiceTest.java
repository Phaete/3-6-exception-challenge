import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentServiceTest {

    @Test
    void findStudentById_shouldThrowStudentNotFoundException_whenNoStudentExists() {
        StudentService studentService = new StudentService();
        assertThrows(StudentNotFoundException.class, () -> studentService.findStudentById("123"));
    }

    @Test
    void findStudentById_shouldReturnStudent_whenStudentExists() {
        StudentService studentService = new StudentService();
        Student student = Student.builder()
                .id("1")
                .name("Florian")
                .subject("Geschichte")
                .build();
        studentService.addNewStudent(student);

        assertDoesNotThrow(() -> studentService.findStudentById(studentService.getAllStudents().getFirst().id()));
    }
}
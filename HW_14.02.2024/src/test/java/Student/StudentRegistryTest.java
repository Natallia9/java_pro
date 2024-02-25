package Student;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static Student.Major.MATHEMATICS;
import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {
    private StudentRegistry registry;

    @Test
    void addStudentTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        assertTrue(StudentRegistry.registry.containsKey(2));
        assertEquals(3, StudentRegistry.registry.size());
//        Student student = new Student(1, "John", "Doe",
//                "john.doe@example.com", 6.7, Major.MATHEMATICS,
//                3, true);
//        StudentRegistry.addStudent(student);
//        assertEquals(student, StudentRegistry.registry.get(1));
    }

    @Test
    void removeStudentTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        registry.removeStudent(1);
        assertFalse(StudentRegistry.registry.containsKey(1));
    }

    @Test
    void findStudentsByMajorTest() {

        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        Map<Integer, Student> mathematicsStudents = StudentRegistry.findStudentsByMajor(String.valueOf(MATHEMATICS));
        assertEquals(mathematicsStudents.size(), 1);

    }

    @Test
    void calculateAverageGradeTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        double averageGrade = StudentRegistry.calculateAverageGrade(StudentRegistry.registry);
        assertEquals(7.47, averageGrade, 0.01);

    }

    @Test
    void listStudentsByYearTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        int year = 3;

        Map<Integer, Student> result = StudentRegistry.listStudentsByYear(year);

        assertFalse(result.isEmpty());

    }

    @Test
    void getStudentTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        int id = 2;
        Map<Integer, Student> result = StudentRegistry.getStudent(id);
        assertTrue(result.containsKey(id));

    }

    @Test
    void getTotalNumberOfStudentsTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        int result = StudentRegistry.getTotalNumberOfStudents();
        assertEquals(result, StudentRegistry.registry.size());
    }

    @Test
    void getStudentsWithGradeAboveTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        double grade = 7.0;
        Map<Integer, Student> result = StudentRegistry.getStudentsWithGradeAbove(grade);
        assertEquals(result.size(), 2);
    }

    @Test
    void getAverageGradeByMajorTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        double averageGrade = StudentRegistry.getAverageGradeByMajor("MATHEMATICS");
        assertEquals(6.70, averageGrade);
    }

    @Test
    void isStudentPresentTest() {
        registry = new StudentRegistry();
        StudentRegistry.addStudent(new Student(1, "John", "Doe", "john.doe@example.com", 6.7, MATHEMATICS, 3, true));
        StudentRegistry.addStudent(new Student(2, "Alice", "Smith", "alice.smith@example.com", 7.5, Major.PHYSICS, 4, false));
        StudentRegistry.addStudent(new Student(3, "Bob", "Johnson", "bob.johnson@example.com", 8.2, Major.COMPUTER_SCIENCE, 2, true));

        String  email = "john.doe@example.com";
        boolean result = StudentRegistry.isStudentPresent(email);
        assertTrue(result);

    }
}
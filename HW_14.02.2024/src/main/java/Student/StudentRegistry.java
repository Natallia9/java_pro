package Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRegistry {
    static Map<Integer, Student> registry = new HashMap<>();

    public static Map<Integer,Student> addStudent(Student student) {
        registry.put(student.getId(), student);
        return registry;
    }

    public void removeStudent(int id) {
        registry.remove(id);
    }

    public static Map<Integer,Student> findStudentsByMajor(String major) {
        return registry.values().stream()
                .filter(student -> student.getMajor().toString().equals(major))
                .collect(Collectors.toMap(Student::getId, student -> student));
    }
    public static double calculateAverageGrade(Map<Integer, Student> students){
        double average = students.values().stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0);

        return Math.round(average * 100.0) / 100.0;
    }
    public static Map<Integer,Student> listStudentsByYear(int year){
        return registry.values().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }
    public static Map<Integer,Student> getStudent(int id){
        return registry.values().stream()
                .filter(student -> student.getId() == id)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }
    public static int getTotalNumberOfStudents(){

        return registry.size();
    }
    public static Map<Integer,Student> getStudentsWithGradeAbove(double grade) {
        return registry.values().stream()
                .filter(student -> student.getGrade() >= grade)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }
    public static double getAverageGradeByMajor(String major){
        Map<Integer,Student> studentsByMajor = findStudentsByMajor(major);
        return calculateAverageGrade(studentsByMajor);
    }
    public static boolean isStudentPresent(String email) {
        return registry.values().stream()
                .anyMatch(student -> student.getEmail().equals(email));

    }
}

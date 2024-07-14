package org.example;

import java.util.*;

public class StudentUtils {

    public static List<Student> validateStudents(List<Student> students, boolean shouldFilterByDocumentStatus) {
        List<Student> result = filterDuplicatesFromStudents(students);
        if(shouldFilterByDocumentStatus) {
            result = filterStudentsByDocumentStatus(result);
        }
        result = sortStudentsByExamScores(result);
        return result;
    }

    private static List<Student> filterDuplicatesFromStudents(List<Student> students) {
        return new ArrayList<>(new HashSet<>(students));
    }

    private static List<Student> filterStudentsByDocumentStatus(List<Student> students) {
        return students.stream().filter(student -> !"Копия".equals(student.getDocumentStatus())).toList();
    }

    private static List<Student> sortStudentsByExamScores(List<Student> students) {
        return students.stream().sorted(Comparator.reverseOrder()).toList();
    }


}

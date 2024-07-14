package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String csvFilePathToStudentsDataset = "C:\\Users\\ILIA\\IdeaProjects\\project\\src\\main\\resources\\full_sstu_dataset.csv";
    static String csvFilePathToFacultiesDataset = "C:\\Users\\ILIA\\IdeaProjects\\project\\src\\main\\resources\\FacultyDataset.csv";

    static boolean shouldFilterByDocumentStatus = true;

    public static void main(String[] args) {
        List<Student> students = DatasetParser.getStudentsFromCSV(csvFilePathToStudentsDataset);
        students = StudentUtils.validateStudents(students, shouldFilterByDocumentStatus);

        List<Faculty> faculties = DatasetParser.getFacultiesFromCSV(csvFilePathToFacultiesDataset);
        Map<String, Faculty> facultiesMap = new HashMap<>();

        for (Faculty faculty : faculties) {
            facultiesMap.put(faculty.getName(), faculty);
        }

        for (Student student : students) {
            for (String facultyName : student.getFacultyPriorities()) {
                Faculty faculty = facultiesMap.get(facultyName);
                if (faculty != null) {
                    boolean isAddingFinishedSuccessfully = faculty.addStudent(student);
                    if (isAddingFinishedSuccessfully) {
                        break;
                    }
                }
            }
        }

        for (Faculty faculty : faculties) {
            System.out.println(faculty.getName());
            List<Student> facultiesStudents = faculty.getStudents();
            for (int i = 0; i < facultiesStudents.size(); i++) {
                System.out.println((i + 1) + ") " + facultiesStudents.get(i));
            }
        }
    }
}
package org.example;


import java.util.*;

public class Student {
    private String id;
    private int sumOfExamScores;
    private String documentStatus;
    private List<String> facultyPriorities;

    public Student(String id, String documentStatus, int sumOfExamScores, List<String> facultyPriorities) {
        this.id = id;
        this.documentStatus = documentStatus;
        this.sumOfExamScores = sumOfExamScores;
        this.facultyPriorities = facultyPriorities;
    }

    public Student(String[] values) {
        String[] splitValues = values[3].split(", ");
        Set<String> uniqueValues = new LinkedHashSet<>(Arrays.asList(splitValues));
        this.id = values[0];
        this.sumOfExamScores = Integer.parseInt(values[1]);
        this.documentStatus = values[2];
        this.facultyPriorities = new ArrayList<>(uniqueValues);
    }



    public String getId() {
        return id;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public int getSumOfExamScores() {
        return sumOfExamScores;
    }

    public List<String> getFacultyPriorities() {
        return facultyPriorities;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", sumOfExamScores=" + sumOfExamScores +
                ", documentStatus='" + documentStatus + '\'' +
                ", facultyPriorities=" + facultyPriorities +
                '}';
    }
}

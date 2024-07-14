package org.example;


import java.util.*;

public class Student implements Comparable<Student>{
    private String id;
    private int sumOfExamScores;
    private String documentStatus;
    private List<String> facultyPriorities;

    public Student(String[] values) {
        String[] splitValues = values[3].split(", ");
        Set<String> uniqueValues = new LinkedHashSet<>(Arrays.asList(splitValues));
        this.id = values[0].trim();
        this.sumOfExamScores = Integer.parseInt(values[1].trim());
        this.documentStatus = values[2].trim();
        this.facultyPriorities = new ArrayList<>(uniqueValues.stream().map(String::trim).map(String::toUpperCase).toList());
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

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.sumOfExamScores, other.sumOfExamScores);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(this.id, student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}

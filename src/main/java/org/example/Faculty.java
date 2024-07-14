package org.example;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private int capacity;
    private List<Student> students;

    public Faculty(String[] values) {
        this.name = values[0].trim().toUpperCase();
        this.capacity = Integer.parseInt(values[1].trim());
        students = new ArrayList<Student>();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", students=" + students +
                '}';
    }

    public String getName() {
        return name;
    }


    public boolean addStudent(Student student) {
        if(students.size() < this.capacity) {
            students.add(student);
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return students;
    }
}

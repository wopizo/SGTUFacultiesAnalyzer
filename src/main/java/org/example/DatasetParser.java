package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatasetParser {
    static String line = "";
    static String csvSplitBy = ";"; // символ разделителя, в данном случае зап

    public static List<Student> getStudentsFromCSV(String csvFilePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "Windows-1251"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                Student student = new Student(values);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Faculty> getFacultiesFromCSV(String csvFilePath) {
        List<Faculty> faculties = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), "Windows-1251"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                Faculty faculty = new Faculty(values);
                faculties.add(faculty);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faculties;
    }
}

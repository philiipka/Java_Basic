package org.example.controller;

import org.example.model.Faculty;
import org.example.model.Human;
import org.example.model.Department;

import java.util.Arrays;
import java.util.List;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments);
    }

    // Метод для створення факультету з кафедрами
    public static Faculty createFacultyWithDepartments(String name, Human head) {
        List<Department> departments = Arrays.asList(
                DepartmentCreator.createDepartmentWithGroups("Кафедра програмування", head)
        );
        return new Faculty(name, head, departments);
    }
}
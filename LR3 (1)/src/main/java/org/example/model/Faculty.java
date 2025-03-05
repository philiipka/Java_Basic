package org.example.model;

import java.util.List;
import java.util.stream.Collectors;

public class Faculty extends DepartmentBase {
    private List<Department> departments;

    public Faculty(String name, Human head, List<Department> departments) {
        super(name, head);
        this.departments = departments;
    }

    public List<Department> getDepartments() { return departments; }

    @Override
    public String toString() {
        String departmentList = departments.isEmpty() ? "No departments" : departments.stream()
                .map(Department::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Faculty{name='%s', Head=%s, Departments=[\n  %s\n]}", name, head, departmentList);
    }
}
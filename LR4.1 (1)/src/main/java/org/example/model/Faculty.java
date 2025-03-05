package org.example.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Faculty extends DepartmentBase {
    private List<Department> departments;

    public Faculty(String name, Human head, List<Department> departments) {
        super(name, head);
        this.departments = departments;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Faculty() {}

    public List<Department> getDepartments() {
        return departments;
    }

    // Сетер для JSON-десеріалізації
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(head, faculty.head) &&
                Objects.equals(departments, faculty.departments);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }

    @Override
    public String toString() {
        String departmentList = departments.isEmpty() ? "No departments" : departments.stream()
                .map(Department::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Faculty{name='%s', Head=%s, Departments=[\n  %s\n]}", name, head, departmentList);
    }
}
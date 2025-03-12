package org.example.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Department extends DepartmentBase {
    private List<Group> groups;

    public Department(String name, Human head, List<Group> groups) {
        super(name, head);
        this.groups = groups;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Department() {}

    public List<Group> getGroups() {
        return groups;
    }

    // Сетер для JSON-десеріалізації
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(groups, that.groups);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }

    @Override
    public String toString() {
        String groupList = groups.isEmpty() ? "No groups" : groups.stream()
                .map(Group::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Department{name='%s', Head=%s, Groups=[\n  %s\n]}", name, head, groupList);
    }
}
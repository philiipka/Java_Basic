package org.example.model;

import java.util.Objects;

public abstract class DepartmentBase {
    protected String name;
    protected Human head;

    public DepartmentBase(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public DepartmentBase() {}

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    // Сетери для JSON-десеріалізації
    public void setName(String name) {
        this.name = name;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentBase that = (DepartmentBase) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }

    @Override
    public String toString() {
        return name + " (Head: " + head + ")";
    }
}
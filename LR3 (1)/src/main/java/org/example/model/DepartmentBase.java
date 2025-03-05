package org.example.model;

public abstract class DepartmentBase {
    protected String name;
    protected Human head;

    public DepartmentBase(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    @Override
    public String toString() {
        return name + " (Head: " + head + ")";
    }
}
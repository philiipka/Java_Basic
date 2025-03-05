package org.example.model;

import java.util.List;
import java.util.stream.Collectors;

public class Department extends DepartmentBase {
    private List<Group> groups;

    public Department(String name, Human head, List<Group> groups) {
        super(name, head);
        this.groups = groups;
    }

    public List<Group> getGroups() { return groups; }

    @Override
    public String toString() {
        String groupList = groups.isEmpty() ? "No groups" : groups.stream()
                .map(Group::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Department{name='%s', Head=%s, Groups=[\n  %s\n]}", name, head, groupList);
    }
}
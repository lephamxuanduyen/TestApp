package models;

import enums.Priority;

public class Task {
    public String name;
    public String date;
    public String priority;
    public String description;
    public String projectName;

    public Task(String name, String date, Priority priority, String description, String projectName) {
        this.name = name;
        this.date = date;
        this.priority = priority.getPriorityValue();
        this.description = description;
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectName() {
        return projectName;
    }
}

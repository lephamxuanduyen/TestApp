package enums;

public enum Priority {
    PRIORITY_1("1"),
    PRIORITY_2("2"),
    PRIORITY_3("3"),
    PRIORITY_4("4");

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getPriorityValue() {
        return value;
    }
}
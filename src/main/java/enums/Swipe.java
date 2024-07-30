package enums;

public enum Swipe {
    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right");

    private String value;

    Swipe(String value) {
        this.value = value;
    }

    public String getSwipeValue() {
        return value;
    }
}

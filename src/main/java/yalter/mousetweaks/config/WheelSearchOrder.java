package yalter.mousetweaks.config;

public enum WheelSearchOrder {

    FIRST_TO_LAST("Last to first"),
    LAST_TO_FIRST("First to last");

    private final String id;

    WheelSearchOrder(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }

    public static WheelSearchOrder fromId(int ordinal) {
        return ordinal == 0 ? FIRST_TO_LAST : LAST_TO_FIRST;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

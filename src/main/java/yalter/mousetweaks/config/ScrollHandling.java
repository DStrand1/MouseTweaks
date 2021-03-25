package yalter.mousetweaks.config;

public enum ScrollHandling {

    SIMPLE("Smooth scrolling, minor issues"),
    EVENT_BASED("Non-smooth scrolling, no issues");

    private final String id;


    ScrollHandling(String id) {
        this.id = id;
    }

    public String getValue() {
        return this.id;
    }

    public static ScrollHandling fromId(int ordinal) {
        return ordinal == 0 ? SIMPLE : EVENT_BASED;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

package yalter.mousetweaks.config;

public enum ScrollItemScaling {

    PROPORTIONAL("Relative to scroll amount"),
    ALWAYS_ONE("Always exactly one item");

    public static final int scrollStep = 120;

    private final String id;

    ScrollItemScaling(String id) {
        this.id = id;
    }

    public String getValue() {
        return this.id;
    }

    public static ScrollItemScaling fromId(int ordinal) {
        return ordinal == 0 ? PROPORTIONAL : ALWAYS_ONE;
    }

    /**
     * scales the given scroll distance, resulting in the number of items to move, the sign representing the direction
     */
    public int scale(int scrollDelta) {
        switch (this) {
            case PROPORTIONAL:
                return scrollDelta;
            case ALWAYS_ONE:
                return Integer.signum(scrollDelta) * scrollStep;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

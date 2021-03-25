package yalter.mousetweaks.config;

public enum WheelScrollDirection {

    NORMAL("Down to push, up to pull"),
    INVERTED("Up to push, down to pull"),
    INVENTORY_POSITION_AWARE("Inventory position aware"),
    INVENTORY_POSITION_AWARE_INVERTED("Inventory position aware, inverted");

    private final String id;
    private static final WheelScrollDirection[] values = WheelScrollDirection.values();

    WheelScrollDirection(String id) {
        this.id = id;
    }

    public String getValue() {
        return this.id;
    }

    public static WheelScrollDirection fromId(int ordinal) {
        switch (ordinal) {
            case 0: return NORMAL;
            case 1: return INVERTED;
            case 2: return INVENTORY_POSITION_AWARE;
            default: return  INVENTORY_POSITION_AWARE_INVERTED;
        }
    }

    public boolean isInverted() {
        return this.ordinal() % 2 == 1;
    }

    public boolean isPositionAware() {
        return this.ordinal() > 1;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

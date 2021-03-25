package yalter.mousetweaks.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Property;
import yalter.mousetweaks.impl.*;
import yalter.mousetweaks.util.Constants;

@Config(modid = Constants.MOD_ID)
public class MTConfig {

    @Config.Comment("Like vanilla right click dragging, but dragging over a slot multiple times puts the item there multiple times.")
    @Config.Name("RMB tweak")
    public static boolean rmbTweak = true;

    @Config.Comment("Left click and drag with an item to \"left click\" items of the same type.")
    @Config.Name("LMB tweak with item")
    public static boolean lmbTweakWithItem = true;

    @Config.Comment("Hold shift, left click and drag without an item to \"shift left click\" items.")
    @Config.Name("LMB tweak without item")
    public static boolean lmbTweakWithoutItem = true;

    @Config.Comment("Scroll over items to move them between inventories.")
    @Config.Name("Wheel tweak")
    public static boolean wheelTweak = true;

    @Config.Comment("How to pick the source slot when pulling items via scrolling.")
    private static final Property wheelSearchOrder = choiceProperty("Wheel tweak search order", "Last to first", "First to last");

    @Config.Comment("Inventory position aware means scroll up to push items from the bottom inventory and pull into the top inventory, and vice versa.")
    private static final Property wheelScrollDirection = choiceProperty(
            "Wheel tweak scroll direction",
            "Down to push, up to pull",
            "Up to push, down to pull",
            "Inventory position aware",
            "Inventory position aware, inverted"
    );

    @Config.Comment("When set to smooth scrolling, minor issues may be experienced such as scrolling \"through\" JEI or other mods. Non-smooth scrolling works only with the Forge OnTick method.")
    private static final Property scrollHandling = choiceProperty(
            "Scroll handling",
            "Smooth scrolling, minor issues",
            "Non-smooth scrolling, no issues"
    );

    @Config.Comment("This determines how many items are moved when you scroll. On some setups (notably macOS), scrolling the wheel with different speeds results in different distances scrolled per wheel \"bump\". To make those setups play nicely with Mouse Tweaks, set this option to \"Always exactly one item\".")
    private static final Property scrollItemScaling = choiceProperty(
            "Scroll item scaling",
            "Relative to scroll amount",
            "Always exactly one item"
    );

    @Config.Comment("Enables debug logging output.")
    @Config.Name("Debug")
    public static boolean debug = false;

    /**
     * creates a new string property with the given valid values, taking the first valid value as default
     */
    private static Property choiceProperty(String name, String... values) {
        return new Property(name, values[0], Property.Type.STRING, values);
    }

    // TODO Fix these getters
    public static WheelSearchOrder wheelSearchOrder() {
        return WheelSearchOrder.valueOf(wheelSearchOrder.getString());
    }

    public static WheelScrollDirection wheelScrollDirection() {
        return WheelScrollDirection.valueOf(wheelScrollDirection.getString());
    }

    public static ScrollHandling scrollHandling() {
        return ScrollHandling.valueOf(scrollHandling.getString());
    }

    public static ScrollItemScaling scrollItemScaling() {
        return ScrollItemScaling.valueOf(scrollItemScaling.getString());
    }
}

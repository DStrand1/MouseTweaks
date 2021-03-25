package yalter.mousetweaks.config;

import net.minecraftforge.common.config.Config;
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
    @Config.Name("Wheel tweak search order")
    public static WheelSearchOrder wheelSearchOrder = WheelSearchOrder.LAST_TO_FIRST;

    @Config.Comment("Inventory position aware means scroll up to push items from the bottom inventory and pull into the top inventory, and vice versa.")
    @Config.Name("Wheel tweak scroll direction")
    public static WheelScrollDirection wheelScrollDirection = WheelScrollDirection.NORMAL;

    @Config.Comment("When set to smooth scrolling, minor issues may be experienced such as scrolling \"through\" JEI or other mods. Non-smooth scrolling works only with the Forge OnTick method.")
    @Config.Name("Scroll handling")
    public static ScrollHandling scrollHandling = ScrollHandling.SIMPLE;

    @Config.Comment("This determines how many items are moved when you scroll. On some setups (notably macOS), scrolling the wheel with different speeds results in different distances scrolled per wheel \"bump\". To make those setups play nicely with Mouse Tweaks, set this option to \"Always exactly one item\".")
    @Config.Name("Scroll item scaling")
    public static ScrollItemScaling scrollItemScaling = ScrollItemScaling.PROPORTIONAL;

    @Config.Comment("Enables debug logging output.")
    @Config.Name("Debug")
    public static boolean debug = false;
}

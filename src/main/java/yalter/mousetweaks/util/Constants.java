package yalter.mousetweaks.util;

public class Constants {
    public static final String MOD_NAME = "Mouse Tweaks";
    public static final String MOD_ID = "mousetweaks";
    public static final String VERSION = "@VERSION@";
    public static final String UPDATE_URL = "http://play.sourceruns.org/yalter/MouseTweaks/update.json";

    public static final String CONFIG_RMB_TWEAK = "RMBTweak";
    public static final String CONFIG_LMB_TWEAK_WITH_ITEM = "LMBTweakWithItem";
    public static final String CONFIG_LMB_TWEAK_WITHOUT_ITEM = "LMBTweakWithoutItem";
    public static final String CONFIG_WHEEL_TWEAK = "WheelTweak";
    public static final String CONFIG_WHEEL_SEARCH_ORDER = "WheelSearchOrder";
    public static final String CONFIG_WHEEL_SCROLL_DIRECTION = "WheelScrollDirection";
    public static final String CONFIG_SCROLL_HANDLING = "ScrollHandling";
    public static final String CONFIG_DEBUG = "Debug";
    public static final String CONFIG_SCROLL_ITEM_SCALING = "ScrollItemScaling";

    // Names for reflection.
    public static final ObfuscatedName IGNOREMOUSEUP_NAME = new ObfuscatedName("ignoreMouseUp", "field_146995_H", "I");
    public static final ObfuscatedName DRAGSPLITTING_NAME = new ObfuscatedName("dragSplitting", "field_147007_t", "u");
    public static final ObfuscatedName DRAGSPLITTINGBUTTON_NAME = new ObfuscatedName("dragSplittingButton",
            "field_146988_G",
            "H");
    public static final ObfuscatedName GETSLOTATPOSITION_NAME = new ObfuscatedName("getSlotAtPosition",
            "func_146975_c",
            "d");
    public static final ObfuscatedName HANDLEMOUSECLICK_NAME = new ObfuscatedName("handleMouseClick",
            "func_184098_a",
            "a");
}

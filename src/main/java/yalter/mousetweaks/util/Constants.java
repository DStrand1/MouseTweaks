package yalter.mousetweaks.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {
    public static final String MOD_NAME = "Mouse Tweaks";
    public static final String MOD_ID = "mousetweaks";
    public static final String VERSION = "@VERSION@";
    public static final String UPDATE_URL = "http://play.sourceruns.org/yalter/MouseTweaks/update.json";

    // Names for reflection
    public static final ObfuscatedName IGNOREMOUSEUP_NAME = new ObfuscatedName("ignoreMouseUp", "field_146995_H", "I");
    public static final ObfuscatedName DRAGSPLITTING_NAME = new ObfuscatedName("dragSplitting", "field_147007_t", "u");
    public static final ObfuscatedName DRAGSPLITTINGBUTTON_NAME = new ObfuscatedName("dragSplittingButton", "field_146988_G", "H");
    public static final List<ObfuscatedName> FIELDS = Stream.of(
            IGNOREMOUSEUP_NAME,
            DRAGSPLITTING_NAME,
            DRAGSPLITTINGBUTTON_NAME
    ).collect(Collectors.toList());


    public static final ObfuscatedName GETSLOTATPOSITION_NAME = new ObfuscatedName("getSlotAtPosition",
            "func_146975_c",
            "d");
    public static final ObfuscatedName HANDLEMOUSECLICK_NAME = new ObfuscatedName("handleMouseClick",
            "func_184098_a",
            "a");
}

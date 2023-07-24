package yalter.mousetweaks.util;

import yalter.mousetweaks.Tags;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {
    public static final String MOD_NAME = Tags.MODNAME;
    public static final String MOD_ID = Tags.MODID;
    public static final String VERSION = Tags.VERSION;

    // Names for reflected fields
    public static final ObfuscatedName IGNOREMOUSEUP_NAME = new ObfuscatedName("ignoreMouseUp", "field_146995_H", "I");
    public static final ObfuscatedName DRAGSPLITTING_NAME = new ObfuscatedName("dragSplitting", "field_147007_t", "u");
    public static final ObfuscatedName DRAGSPLITTINGBUTTON_NAME = new ObfuscatedName("dragSplittingButton", "field_146988_G", "H");
    public static final List<ObfuscatedName> FIELDS = Stream.of(
            IGNOREMOUSEUP_NAME,
            DRAGSPLITTING_NAME,
            DRAGSPLITTINGBUTTON_NAME
    ).collect(Collectors.toList());

    // Names for reflected methods
    public static final ObfuscatedName GETSLOTATPOSITION_NAME = new ObfuscatedName("getSlotAtPosition",
            "func_146975_c",
            "d");
    public static final ObfuscatedName HANDLEMOUSECLICK_NAME = new ObfuscatedName("handleMouseClick",
            "func_184098_a",
            "a");
}

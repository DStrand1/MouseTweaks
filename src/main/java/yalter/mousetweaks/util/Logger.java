package yalter.mousetweaks.util;

import yalter.mousetweaks.config.Config;

public class Logger {

    public static void Log(String text) {
        System.out.println("[Mouse Tweaks] " + text);
    }

    public static void DebugLog(String text) {
        if (Config.debug)
            System.out.println("[Mouse Tweaks] " + text);
    }

}

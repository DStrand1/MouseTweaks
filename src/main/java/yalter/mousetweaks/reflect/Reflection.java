package yalter.mousetweaks.reflect;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.crash.CrashReport;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ReportedException;
import yalter.mousetweaks.util.Constants;
import yalter.mousetweaks.util.MTLog;
import yalter.mousetweaks.util.ObfuscatedName;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Reflection {

    private static final HashMap<Class<?>, Method> HMCCache = new HashMap<>();

    public static ReflectionCache guiContainerClass;

    public static void reflectGuiContainer() {
        MTLog.logger.info("Reflecting GuiContainer...");

        guiContainerClass = new ReflectionCache();

        for (ObfuscatedName field : Constants.FIELDS) {
            try {
                Field f = getField(GuiContainer.class, field.mcpName);
                guiContainerClass.storeField(field.forgeName, f);
            } catch (NoSuchFieldException e) {
                MTLog.logger.info("Could not resolve GuiContainer." + field.mcpName);
                guiContainerClass = null;
                return;
            }
        }

        try {
            Method m = getMethod(GuiContainer.class,
                    Constants.GETSLOTATPOSITION_NAME.mcpName,
                    int.class,
                    int.class);
            guiContainerClass.storeMethod(Constants.GETSLOTATPOSITION_NAME.forgeName, m);
        } catch (NoSuchMethodException e) {
            MTLog.logger.info("Could not retrieve GuiContainer.getSlotAtPosition().");
            guiContainerClass = null;
            return;
        }

        MTLog.logger.info("Success.");
    }

    public static Method getHMCMethod(GuiContainer object) {
        if (HMCCache.containsKey(object.getClass())) {
            return HMCCache.get(object.getClass());
        }

        try {
            Method method = searchMethod(object.getClass(),
                    Constants.HANDLEMOUSECLICK_NAME.mcpName,
                    Slot.class,
                    int.class,
                    int.class,
                    ClickType.class);

            MTLog.logger.debug("Found handleMouseClick() for " + object.getClass().getSimpleName() + ", caching.");

            HMCCache.put(object.getClass(), method);
            return method;
        } catch (NoSuchMethodException e) {
            CrashReport crashreport = CrashReport.makeCrashReport(e,
                    "MouseTweaks could not find handleMouseClick() in a "
                            + "GuiContainer.");
            throw new ReportedException(crashreport);
        }
    }

    public static Method getHMCMethod(Object object) {
        if (HMCCache.containsKey(object.getClass())) {
            return HMCCache.get(object.getClass());
        }

        try {
            Method method = searchMethod(object.getClass(),
                    Constants.HANDLEMOUSECLICK_NAME.mcpName,
                    Slot.class,
                    int.class,
                    int.class,
                    ClickType.class);

            MTLog.logger.debug("Found handleMouseClick() for " + object.getClass().getSimpleName() + ", caching.");

            HMCCache.put(object.getClass(), method);
            return method;
        } catch (NoSuchMethodException e) {
            MTLog.logger.debug("Could not find handleMouseClick() for "
                    + object.getClass().getSimpleName()
                    + ", using windowClick().");
            return null;
        }
    }

    private static Field getField(Class<?> clazz, String name) throws NoSuchFieldException {
        Field field;

        try {
            field = clazz.getField(name);
        } catch (NoSuchFieldException e) {
            field = clazz.getDeclaredField(name);
        }

        field.setAccessible(true);
        return field;
    }

    private static Method getMethod(Class<?> clazz, String name, Class<?>... args) throws NoSuchMethodException {
        Method method;

        try {
            method = clazz.getMethod(name, args);
        } catch (NoSuchMethodException e) {
            method = clazz.getDeclaredMethod(name, args);
        }

        method.setAccessible(true);
        return method;
    }

    private static Method searchMethod(Class<?> clazz, String name, Class<?>... args) throws NoSuchMethodException {
        Method method;

        do {
            try {
                method = clazz.getDeclaredMethod(name, args);

                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        } while (clazz != null);

        throw new NoSuchMethodException();
    }
}

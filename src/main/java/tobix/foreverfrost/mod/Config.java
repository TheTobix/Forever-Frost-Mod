package tobix.foreverfrost.mod;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // Wir definieren die Temperatur in Celsius.
    // In Minecraft entsprechen 0.15 intern etwa 0°C.
    // Ein guter Standardwert für Schnee ist -5°C.
    public static final ModConfigSpec.DoubleValue TEMPERATURE_CELSIUS = BUILDER
            .comment("Die gewünschte Temperatur in Celsius. Alles unter 0°C sorgt für Schnee und Eis.")
            .defineInRange("temperature_celsius", -5.0, -50.0, 50.0);

    public static final ModConfigSpec.BooleanValue ENABLE_SNOW_EVERYWHERE = BUILDER
            .comment("Wenn wahr, wird in jedem Biom Niederschlag (Schnee) aktiviert.")
            .define("enable_snow_everywhere", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    /**
     * Rechnet Celsius in den internen Minecraft-Temperaturwert um.
     * Formel: (Celsius / 30.0) + 0.15
     */
    public static float getMinecraftTemperature() {
        double celsius = TEMPERATURE_CELSIUS.get();
        return (float) ((celsius / 30.0) + 0.15);
    }
}

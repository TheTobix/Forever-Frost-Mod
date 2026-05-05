package tobix.foreverfrost.mod;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public record WinterModifier() implements BiomeModifier {

    // Registrierungscode für NeoForge
    public static final MapCodec<WinterModifier> CODEC = MapCodec.unit(WinterModifier::new);

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.MODIFY) {
            // Korrekter Weg, um Temperatur und Niederschlag in 1.21.1 zu setzen[cite: 5]
            builder.getClimateSettings().setTemperature(-2.F);
            builder.getClimateSettings().setHasPrecipitation(true);
            builder.getClimateSettings().setDownfall(0.8F); // Ein hoher Wert begünstigt Niederschlag
            builder.getClimateSettings().setTemperatureModifier(Biome.TemperatureModifier.NONE);


            ForeverFrost.LOGGER.info("Biom {} wurde eingefroren!", biome.getRegisteredName());
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}
package chronosacaria.mobsummoning;

import chronosacaria.mobsummoning.commands.SummonMobCommand;
import chronosacaria.mobsummoning.configs.MobSummoningBaseConfig;
import chronosacaria.mobsummoning.configs.MobSummoningItemConfig;
import chronosacaria.mobsummoning.configs.MobSummoningStatsConfig;
import chronosacaria.mobsummoning.init.ItemsInit;
import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import chronosacaria.mobsummoning.loottables.MobSummoningLootTables;
import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

import java.io.File;

public class MobSummoning implements ModInitializer {

    public static final String MOD_ID = "mobsummoning";

    public static Identifier ID (String path){
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {

        // Config Begin
        MobSummoningStatsConfig.initAll();
        MobSummoningItemConfig.initAll();

        String defaultConfig =
                        "{\n" +
                        "  \"regenerate_stats_configs\": false,\n" +
                        "  \"regenerate_item_configs\": false\n" +
                        "}";
        File configFile = MobSummoningBaseConfig.createFile("config/mob_summoning/config.json", defaultConfig, false);
        JsonObject json = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(configFile));

        MobSummoningStatsConfig.generateConfigs(json == null || !json.has("regenerate_stats_configs") || json.get(
                "regenerate_stats_configs").getAsBoolean());
        MobSummoningStatsConfig.loadConfig();
        MobSummoningItemConfig.generateConfigs(json == null || !json.has("regenerate_item_configs") || json.get(
                "regenerate_stats_configs").getAsBoolean());
        MobSummoningItemConfig.loadConfig();
        // Config End

        CommandRegistrationCallback.EVENT.register(new SummonMobCommand());

        ItemsInit.init();
        MobSummoningLootTables.init();

        SummonedEntityRegistry.register();
    }
}

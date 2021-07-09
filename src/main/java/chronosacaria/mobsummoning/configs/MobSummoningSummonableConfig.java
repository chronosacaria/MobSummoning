package chronosacaria.mobsummoning.configs;

import chronosacaria.mobsummoning.init.ItemsInit;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MobSummoningSummonableConfig {

    private static final HashMap<String, Boolean> SUMMONABLE = new HashMap<>();
    private static final HashMap<String, Integer> SUMMON_XP_COST = new HashMap<>();
    private static final HashMap<String, Integer> SUMMON_ITEM_AMOUNT_COST = new HashMap<>();


    public static boolean isSummonable(String entityName){
        return SUMMONABLE.getOrDefault(entityName, true);
    }

    public static int summonXPCost(String entityName){
        return SUMMON_XP_COST.getOrDefault(entityName, 0);
    }

    public static int summonItemAmountCost(String entityName){
        return SUMMON_ITEM_AMOUNT_COST.getOrDefault(entityName, 0);
    }

    public static void initAll(){
        initSummonable();
        initSummonXPCost();
        initSummonItemAmountCost();
    }

    public static void initSummonable(){
        SUMMONABLE.put("summoned_bat", true);
        SUMMONABLE.put("summoned_blaze", true);
        SUMMONABLE.put("summoned_cat", true);
        SUMMONABLE.put("summoned_chicken", true);
        SUMMONABLE.put("summoned_cow", true);
        SUMMONABLE.put("summoned_enderman", true);
        SUMMONABLE.put("summoned_fox", true);
        SUMMONABLE.put("summoned_ghast", true);
        SUMMONABLE.put("summoned_husk", true);
        SUMMONABLE.put("summoned_iron_golem", true);
        SUMMONABLE.put("summoned_llama", true);
        SUMMONABLE.put("summoned_pig", true);
        SUMMONABLE.put("summoned_rabbit", true);
        SUMMONABLE.put("summoned_ravager", true);
        SUMMONABLE.put("summoned_sheep", true);
        SUMMONABLE.put("summoned_skeleton", true);
        SUMMONABLE.put("summoned_spider", true);
        SUMMONABLE.put("summoned_wither_skeleton", true);
        SUMMONABLE.put("summoned_wolf", true);
        SUMMONABLE.put("summoned_zombie", true);
    }

    public static void initSummonXPCost(){
        SUMMON_XP_COST.put("summoned_bat", 5);
        SUMMON_XP_COST.put("summoned_blaze", 10);
        SUMMON_XP_COST.put("summoned_cat", 5);
        SUMMON_XP_COST.put("summoned_chicken", 5);
        SUMMON_XP_COST.put("summoned_cow", 5);
        SUMMON_XP_COST.put("summoned_enderman", 20);
        SUMMON_XP_COST.put("summoned_fox", 5);
        SUMMON_XP_COST.put("summoned_ghast", 20);
        SUMMON_XP_COST.put("summoned_husk", 10);
        SUMMON_XP_COST.put("summoned_iron_golem", 20);
        SUMMON_XP_COST.put("summoned_llama", 7);
        SUMMON_XP_COST.put("summoned_pig", 5);
        SUMMON_XP_COST.put("summoned_rabbit", 5);
        SUMMON_XP_COST.put("summoned_ravager", 20);
        SUMMON_XP_COST.put("summoned_sheep", 5);
        SUMMON_XP_COST.put("summoned_skeleton", 10);
        SUMMON_XP_COST.put("summoned_spider", 7);
        SUMMON_XP_COST.put("summoned_wither_skeleton", 10);
        SUMMON_XP_COST.put("summoned_wolf", 7);
        SUMMON_XP_COST.put("summoned_zombie", 10);
    }

    public static void initSummonItemAmountCost(){
        SUMMON_ITEM_AMOUNT_COST.put("summoned_bat", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_blaze", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_cat", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_chicken", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_cow", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_enderman", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_fox", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_ghast", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_husk", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_iron_golem", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_llama", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_pig", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_rabbit", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_ravager", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_sheep", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_skeleton", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_spider", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_wither_skeleton", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_wolf", 1);
        SUMMON_ITEM_AMOUNT_COST.put("summoned_zombie", 1);
    }

    public static void generateConfigs(boolean overwrite) {
        StringBuilder config = new StringBuilder("{\n");
        int i = 0;
        for (String entity : SUMMONABLE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(SUMMONABLE.get(entity));
            ++i;
            if (i < SUMMONABLE.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summonable_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : SUMMON_XP_COST.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(SUMMON_XP_COST.get(entity));
            ++i;
            if (i < SUMMON_XP_COST.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summons_xp_cost_config.json5",
                config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : SUMMON_ITEM_AMOUNT_COST.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(SUMMON_ITEM_AMOUNT_COST.get(entity));
            ++i;
            if (i < SUMMON_ITEM_AMOUNT_COST.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summons_item_amount_cost_config.json5",
                config.toString(),
                overwrite);
    }

    public static void loadConfig(){
        JsonObject jsonObject;
        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summonable_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            SUMMONABLE.put(entry.getKey(), entry.getValue().getAsBoolean());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summons_xp_cost_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            SUMMON_XP_COST.put(entry.getKey(), entry.getValue().getAsInt());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summons_item_amount_cost_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            SUMMON_XP_COST.put(entry.getKey(), entry.getValue().getAsInt());
        }
    }
}

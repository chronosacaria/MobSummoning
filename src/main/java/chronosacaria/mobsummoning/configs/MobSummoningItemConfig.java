package chronosacaria.mobsummoning.configs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MobSummoningItemConfig {
    private static final HashMap<String, Integer> ITEM_COOLDOWN = new HashMap<>();
    private static final HashMap<String, Float> ITEM_DROP = new HashMap<>();

    public static int getItemCooldown(String itemName){
        return ITEM_COOLDOWN.getOrDefault(itemName, 0);
    }

    public static float getItemDrop(String itemName){
        return ITEM_DROP.getOrDefault(itemName, 0.0F);
    }

    public static void initAll(){
        initItemCooldowns();
        initItemLoottableDrops();
    }

    public static void initItemCooldowns(){
        ITEM_COOLDOWN.put("summoning_staff", 1200);
    }

    public static void initItemLoottableDrops(){
        ITEM_DROP.put("bat_wing", 0.5F);
    }

    public static void generateConfigs(boolean overwrite) {
        StringBuilder config = new StringBuilder("{\n");
        int i = 0;
        for (String entity : ITEM_COOLDOWN.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(ITEM_COOLDOWN.get(entity));
            ++i;
            if (i < ITEM_COOLDOWN.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/items/item_cooldowns_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : ITEM_DROP.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(ITEM_DROP.get(entity));
            ++i;
            if (i < ITEM_DROP.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/items/item_drops_config.json5",
                config.toString(),
                overwrite);
    }

    public static void loadConfig() {
        JsonObject jsonObject;
        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/items/item_cooldowns_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ITEM_COOLDOWN.put(entry.getKey(), entry.getValue().getAsInt());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/items/item_drops_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ITEM_DROP.put(entry.getKey(), entry.getValue().getAsFloat());
        }
    }
}

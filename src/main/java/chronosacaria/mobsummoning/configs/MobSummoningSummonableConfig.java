package chronosacaria.mobsummoning.configs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MobSummoningSummonableConfig {

    private static final HashMap<String, Boolean> SUMMONABLE = new HashMap<>();

    public static boolean isSummonable(String entityName){
        return SUMMONABLE.getOrDefault(entityName, true);
    }

    public static void initSummonablesConfig(){
        initSummonable();
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

    public static void generateConfigs(boolean overwrite){
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

    }

    public static void loadConfig(){
        JsonObject jsonObject;
        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summonable_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            SUMMONABLE.put(entry.getKey(), entry.getValue().getAsBoolean());
        }
    }
}

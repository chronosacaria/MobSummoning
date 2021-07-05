package chronosacaria.mobsummoning.configs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MobSummoningStatsConfig {

    private static final HashMap<String, Double> MAX_HEALTH = new HashMap<>();
    private static final HashMap<String, Double> MOVEMENT_SPEED = new HashMap<>();
    private static final HashMap<String, Double> ATTACK_DAMAGE = new HashMap<>();
    private static final HashMap<String, Double> FOLLOW_RANGE = new HashMap<>();
    private static final HashMap<String, Double> KNOCKBACK_RESISTANCE = new HashMap<>();

    public static double getSummonMaxHealth(String entityName){
        return MAX_HEALTH.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonMovementSpeed(String entityName){
        return MOVEMENT_SPEED.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonAttackDamage(String entityName){
        return ATTACK_DAMAGE.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonFollowRange(String entityName){
        return FOLLOW_RANGE.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonKnockbackResistance(String entityName){
        return KNOCKBACK_RESISTANCE.getOrDefault(entityName, 0.0D);
    }

    public static void initAll(){
        initSummonMaxHealth();
        initSummonMovementSpeed();
        initSummonAttackDamage();
        initSummonFollowRange();
        initSummonKnockbackResistance();
    }

    public static void initSummonMaxHealth(){
        MAX_HEALTH.put("summoned_bat", 6.0D);
    }

    public static void initSummonMovementSpeed(){
        MOVEMENT_SPEED.put("summoned_bat", 1.0D);
    }

    public static void initSummonAttackDamage(){
        ATTACK_DAMAGE.put("summoned_bat", 1.0D);
    }

    public static void initSummonFollowRange(){
        FOLLOW_RANGE.put("summoned_bat", 64.0D);
    }

    public static void initSummonKnockbackResistance(){
        KNOCKBACK_RESISTANCE.put("summoned_bat", 0.0D);
    }

    public static void generateConfigs(boolean overwrite){
        StringBuilder config = new StringBuilder("{\n");
        int i = 0;
        for (String entity : MAX_HEALTH.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(MAX_HEALTH.get(entity));
            ++i;
            if (i < MAX_HEALTH.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summon_health_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : MOVEMENT_SPEED.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(MOVEMENT_SPEED.get(entity));
            ++i;
            if (i < MAX_HEALTH.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summon_movement_speed_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : ATTACK_DAMAGE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(ATTACK_DAMAGE.get(entity));
            ++i;
            if (i < MAX_HEALTH.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summon_attack_damage_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : FOLLOW_RANGE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(FOLLOW_RANGE.get(entity));
            ++i;
            if (i < MAX_HEALTH.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summon_follow_range_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : KNOCKBACK_RESISTANCE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(KNOCKBACK_RESISTANCE.get(entity));
            ++i;
            if (i < MAX_HEALTH.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summon_knockback_resistance_config.json5",
                config.toString(), overwrite);
    }

    public static void loadConfig(){
        JsonObject jsonObject;
        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summon_health_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            MAX_HEALTH.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summon_movement_speed_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            MOVEMENT_SPEED.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summon_attack_damage_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ATTACK_DAMAGE.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summon_follow_range_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            FOLLOW_RANGE.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summon_knockback_resistance_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            KNOCKBACK_RESISTANCE.put(entry.getKey(), entry.getValue().getAsDouble());
        }
    }

}

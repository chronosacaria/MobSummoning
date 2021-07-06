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
    private static final HashMap<String, Double> GENERIC_ARMOR = new HashMap<>();
    private static final HashMap<String, Double> FOLLOW_RANGE = new HashMap<>();
    private static final HashMap<String, Double> ATTACK_KNOCKBACK = new HashMap<>();
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

    public static double getSummonArmor(String entityName){
        return GENERIC_ARMOR.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonFollowRange(String entityName){
        return FOLLOW_RANGE.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonAttackKnockback(String entityName){
        return ATTACK_KNOCKBACK.getOrDefault(entityName, 0.0D);
    }

    public static double getSummonKnockbackResistance(String entityName){
        return KNOCKBACK_RESISTANCE.getOrDefault(entityName, 0.0D);
    }

    public static void initAll(){
        initSummonMaxHealth();
        initSummonMovementSpeed();
        initSummonAttackDamage();
        initSummonArmor();
        initSummonFollowRange();
        initSummonAttackKnockback();
        initSummonKnockbackResistance();
    }

    public static void initSummonMaxHealth(){
        MAX_HEALTH.put("summoned_bat", 6.0D);
        MAX_HEALTH.put("summoned_blaze", 20.0D);
        MAX_HEALTH.put("summoned_cat", 10.0D);
        MAX_HEALTH.put("summoned_chicken", 4.0D);
        MAX_HEALTH.put("summoned_cow", 10.0D);
        MAX_HEALTH.put("summoned_enderman", 40.0D);
        MAX_HEALTH.put("summoned_fox", 10.0D);
        MAX_HEALTH.put("summoned_ghast", 10.0D);
        MAX_HEALTH.put("summoned_husk", 20.0D);
        MAX_HEALTH.put("summoned_iron_golem", 100.0D);
        MAX_HEALTH.put("summoned_llama", 10.0D);
        MAX_HEALTH.put("summoned_pig", 10.0D);
        MAX_HEALTH.put("summoned_rabbit", 3.0D);
        MAX_HEALTH.put("summoned_ravager", 100.0D);
        MAX_HEALTH.put("summoned_sheep", 8.0D);
        MAX_HEALTH.put("summoned_skeleton", 20.0D);
        MAX_HEALTH.put("summoned_spider", 16.0D);
        MAX_HEALTH.put("summoned_wither_skeleton", 20.0D);
        MAX_HEALTH.put("summoned_wolf", 8.0D);
        MAX_HEALTH.put("summoned_zombie", 20.0D);
    }

    public static void initSummonMovementSpeed(){
        MOVEMENT_SPEED.put("summoned_bat", 1.0D);
        MOVEMENT_SPEED.put("summoned_blaze", 0.23D);
        MOVEMENT_SPEED.put("summoned_cat", 0.30D);
        MOVEMENT_SPEED.put("summoned_chicken", 0.25D);
        MOVEMENT_SPEED.put("summoned_cow", 0.25D);
        MOVEMENT_SPEED.put("summoned_enderman", 0.30D);
        MOVEMENT_SPEED.put("summoned_fox", 0.30D);
        MOVEMENT_SPEED.put("summoned_ghast", 0.30D);
        MOVEMENT_SPEED.put("summoned_husk", 0.23D);
        MOVEMENT_SPEED.put("summoned_iron_golem", 0.25D);
        MOVEMENT_SPEED.put("summoned_llama", 0.20D);
        MOVEMENT_SPEED.put("summoned_pig", 0.25D);
        MOVEMENT_SPEED.put("summoned_rabbit", 0.30D);
        MOVEMENT_SPEED.put("summoned_ravager", 0.30D);
        MOVEMENT_SPEED.put("summoned_sheep", 0.23D);
        MOVEMENT_SPEED.put("summoned_skeleton", 0.25D);
        MOVEMENT_SPEED.put("summoned_spider", 0.30D);
        MOVEMENT_SPEED.put("summoned_wither_skeleton", 0.25D);
        MOVEMENT_SPEED.put("summoned_wolf", 0.30D);
        MOVEMENT_SPEED.put("summoned_zombie", 0.23D);
    }

    public static void initSummonAttackDamage(){
        ATTACK_DAMAGE.put("summoned_bat", 1.0D);
        ATTACK_DAMAGE.put("summoned_blaze", 6.0D);
        ATTACK_DAMAGE.put("summoned_cat", 3.0D);
        ATTACK_DAMAGE.put("summoned_chicken", 3.0D);
        ATTACK_DAMAGE.put("summoned_cow", 4.0D);
        ATTACK_DAMAGE.put("summoned_enderman", 7.0D);
        ATTACK_DAMAGE.put("summoned_fox", 2.0D);
        ATTACK_DAMAGE.put("summoned_ghast", 6.0D);
        ATTACK_DAMAGE.put("summoned_husk", 3.0D);
        ATTACK_DAMAGE.put("summoned_iron_golem", 15.0D);
        ATTACK_DAMAGE.put("summoned_llama", 5.0D);
        ATTACK_DAMAGE.put("summoned_pig", 4.0D);
        ATTACK_DAMAGE.put("summoned_rabbit", 3.0D);
        ATTACK_DAMAGE.put("summoned_ravager", 12.0D);
        ATTACK_DAMAGE.put("summoned_sheep", 4.0D);
        ATTACK_DAMAGE.put("summoned_skeleton", 5.0D);
        ATTACK_DAMAGE.put("summoned_spider", 3.0D);
        ATTACK_DAMAGE.put("summoned_wither_skeleton", 8.0D);
        ATTACK_DAMAGE.put("summoned_wolf", 6.0D);
        ATTACK_DAMAGE.put("summoned_zombie", 3.0D);
    }

    public static void initSummonArmor(){
        GENERIC_ARMOR.put("summoned_bat", 0.0D);
        GENERIC_ARMOR.put("summoned_blaze", 0.0D);
        GENERIC_ARMOR.put("summoned_cat", 0.0D);
        GENERIC_ARMOR.put("summoned_chicken", 0.0D);
        GENERIC_ARMOR.put("summoned_cow", 0.0D);
        GENERIC_ARMOR.put("summoned_enderman", 0.0D);
        GENERIC_ARMOR.put("summoned_fox", 0.0D);
        GENERIC_ARMOR.put("summoned_ghast", 0.0D);
        GENERIC_ARMOR.put("summoned_husk", 2.0D);
        GENERIC_ARMOR.put("summoned_iron_golem", 0.0D);
        GENERIC_ARMOR.put("summoned_llama", 0.0D);
        GENERIC_ARMOR.put("summoned_pig", 0.0D);
        GENERIC_ARMOR.put("summoned_rabbit", 0.0D);
        GENERIC_ARMOR.put("summoned_ravager", 0.0D);
        GENERIC_ARMOR.put("summoned_sheep", 0.0D);
        GENERIC_ARMOR.put("summoned_skeleton", 0.0D);
        GENERIC_ARMOR.put("summoned_spider", 0.0D);
        GENERIC_ARMOR.put("summoned_wither_skeleton", 0.0D);
        GENERIC_ARMOR.put("summoned_wolf", 0.0D);
        GENERIC_ARMOR.put("summoned_zombie", 2.0D);
    }

    public static void initSummonFollowRange(){
        FOLLOW_RANGE.put("summoned_bat", 64.0D);
        FOLLOW_RANGE.put("summoned_blaze", 64.0D);
        FOLLOW_RANGE.put("summoned_cat", 64.0D);
        FOLLOW_RANGE.put("summoned_chicken", 64.0D);
        FOLLOW_RANGE.put("summoned_cow", 64.0D);
        FOLLOW_RANGE.put("summoned_enderman", 64.0D);
        FOLLOW_RANGE.put("summoned_fox", 64.0D);
        FOLLOW_RANGE.put("summoned_ghast", 64.0D);
        FOLLOW_RANGE.put("summoned_husk", 64.0D);
        FOLLOW_RANGE.put("summoned_iron_golem", 64.0D);
        FOLLOW_RANGE.put("summoned_llama", 64.0D);
        FOLLOW_RANGE.put("summoned_pig", 64.0D);
        FOLLOW_RANGE.put("summoned_rabbit", 64.0D);
        FOLLOW_RANGE.put("summoned_ravager", 64.0D);
        FOLLOW_RANGE.put("summoned_sheep", 64.0D);
        FOLLOW_RANGE.put("summoned_skeleton", 64.0D);
        FOLLOW_RANGE.put("summoned_spider", 64.0D);
        FOLLOW_RANGE.put("summoned_wither_skeleton", 64.0D);
        FOLLOW_RANGE.put("summoned_wolf", 64.0D);
        FOLLOW_RANGE.put("summoned_zombie", 64.0D);
    }

    public static void initSummonAttackKnockback() {
        ATTACK_KNOCKBACK.put("summoned_bat", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_blaze", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_cat", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_chicken", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_cow", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_enderman", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_fox", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_ghast", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_husk", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_iron_golem", 1.0D);
        ATTACK_KNOCKBACK.put("summoned_llama", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_pig", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_rabbit", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_ravager", 1.5D);
        ATTACK_KNOCKBACK.put("summoned_sheep", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_skeleton", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_spider", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_wither_skeleton", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_wolf", 0.0D);
        ATTACK_KNOCKBACK.put("summoned_zombie", 0.0D);
    }

    public static void initSummonKnockbackResistance(){
        KNOCKBACK_RESISTANCE.put("summoned_bat", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_blaze", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_cat", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_chicken", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_cow", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_enderman", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_fox", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_ghast", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_husk", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_iron_golem", 1.0D);
        KNOCKBACK_RESISTANCE.put("summoned_llama", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_pig", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_rabbit", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_ravager", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_sheep", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_skeleton", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_spider", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_wither_skeleton", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_wolf", 0.0D);
        KNOCKBACK_RESISTANCE.put("summoned_zombie", 0.0D);
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
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_health_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : MOVEMENT_SPEED.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(MOVEMENT_SPEED.get(entity));
            ++i;
            if (i < MOVEMENT_SPEED.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_movement_speed_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : ATTACK_DAMAGE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(ATTACK_DAMAGE.get(entity));
            ++i;
            if (i < ATTACK_DAMAGE.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_attack_damage_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : GENERIC_ARMOR.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(GENERIC_ARMOR.get(entity));
            ++i;
            if (i < GENERIC_ARMOR.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_generic_armor_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : FOLLOW_RANGE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(FOLLOW_RANGE.get(entity));
            ++i;
            if (i < FOLLOW_RANGE.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_follow_range_config.json5", config.toString(),
                overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : ATTACK_KNOCKBACK.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(ATTACK_KNOCKBACK.get(entity));
            ++i;
            if (i < ATTACK_KNOCKBACK.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_attack_knockback_config.json5",
                config.toString(), overwrite);

        config = new StringBuilder("{\n");
        i = 0;
        for (String entity : KNOCKBACK_RESISTANCE.keySet()) {
            config.append(" \"").append(entity).append("\": ").append(KNOCKBACK_RESISTANCE.get(entity));
            ++i;
            if (i < KNOCKBACK_RESISTANCE.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        MobSummoningBaseConfig.createFile("config/mob_summoning/summons/summon_knockback_resistance_config.json5",
                config.toString(), overwrite);
    }

    public static void loadConfig(){
        JsonObject jsonObject;
        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_health_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            MAX_HEALTH.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_movement_speed_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            MOVEMENT_SPEED.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_attack_damage_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ATTACK_DAMAGE.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_generic_armor_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            GENERIC_ARMOR.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_follow_range_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            FOLLOW_RANGE.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_attack_knockback_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ATTACK_KNOCKBACK.put(entry.getKey(), entry.getValue().getAsDouble());
        }

        jsonObject = MobSummoningBaseConfig.getJsonObject(MobSummoningBaseConfig.readFile(new File("config/mob_summoning/summons/summon_knockback_resistance_config.json5")));
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            KNOCKBACK_RESISTANCE.put(entry.getKey(), entry.getValue().getAsDouble());
        }
    }
}

package chronosacaria.mobsummoning.init;

import chronosacaria.mobsummoning.MobSummoning;
import chronosacaria.mobsummoning.entities.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.Map;

public class SummonedEntityRegistry {
    public static final Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer> ATTRIBUTES = Maps.newHashMap();
    private static final List<EntityType<?>> SUMMONED_ENTITIES = Lists.newArrayList();

    public static final EntityType<SummonedBatEntity> SUMMONED_BAT_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedBatEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedCatEntity> SUMMONED_CAT_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedCatEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedChickenEntity> SUMMONED_CHICKEN_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedChickenEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedCowEntity> SUMMONED_COW_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedCowEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedFoxEntity> SUMMONED_FOX_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedFoxEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedPigEntity> SUMMONED_PIG_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedPigEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedRabbitEntity> SUMMONED_RABBIT_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedRabbitEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedSheepEntity> SUMMONED_SHEEP_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedSheepEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();

    public static final EntityType<SummonedEndermanEntity> SUMMONED_ENDERMAN_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedEndermanEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedIronGolemEntity> SUMMONED_IRON_GOLEM_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedIronGolemEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedLlamaEntity> SUMMONED_LLAMA_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedLlamaEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedSpiderEntity> SUMMONED_SPIDER_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedSpiderEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedWolfEntity> SUMMONED_WOLF_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedWolfEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();

    public static final EntityType<SummonedBlazeEntity> SUMMONED_BLAZE_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedBlazeEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedSkeletonEntity> SUMMONED_SKELETON_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedSkeletonEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedZombieEntity> SUMMONED_ZOMBIE_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedZombieEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();



    public static void register(){
        registerEntity("summoned_bat", SummonedBatEntity.createSummonedAttributes(), SUMMONED_BAT_ENTITY);
        registerEntity("summoned_cat", SummonedCatEntity.createSummonedAttributes(), SUMMONED_CAT_ENTITY);
        registerEntity("summoned_chicken", SummonedChickenEntity.createSummonedAttributes(), SUMMONED_CHICKEN_ENTITY);
        registerEntity("summoned_cow", SummonedCowEntity.createSummonedAttributes(), SUMMONED_COW_ENTITY);
        registerEntity("summoned_fox", SummonedFoxEntity.createSummonedAttributes(), SUMMONED_FOX_ENTITY);
        registerEntity("summoned_pig", SummonedPigEntity.createSummonedAttributes(), SUMMONED_PIG_ENTITY);
        registerEntity("summoned_rabbit", SummonedRabbitEntity.createSummonedAttributes(), SUMMONED_RABBIT_ENTITY);
        registerEntity("summoned_sheep", SummonedSheepEntity.createSummonedAttributes(), SUMMONED_SHEEP_ENTITY);

        registerEntity("summoned_enderman", SummonedEndermanEntity.createSummonedAttributes(), SUMMONED_ENDERMAN_ENTITY);
        registerEntity("summoned_iron_golem", SummonedIronGolemEntity.createSummonedAttributes(), SUMMONED_IRON_GOLEM_ENTITY);
        registerEntity("summoned_llama", SummonedLlamaEntity.createSummonedAttributes(), SUMMONED_LLAMA_ENTITY);
        registerEntity("summoned_spider", SummonedSpiderEntity.createSummonedAttributes(), SUMMONED_SPIDER_ENTITY);
        registerEntity("summoned_wolf", SummonedWolfEntity.createSummonedAttributes(), SUMMONED_WOLF_ENTITY);

        registerEntity("summoned_blaze", SummonedBlazeEntity.createSummonedAttributes(), SUMMONED_BLAZE_ENTITY);
        registerEntity("summoned_skeleton", SummonedBlazeEntity.createSummonedAttributes(), SUMMONED_SKELETON_ENTITY);
        registerEntity("summoned_zombie", SummonedZombieEntity.createSummonedAttributes(), SUMMONED_ZOMBIE_ENTITY);

    }

    public static void registerEntity(String name, DefaultAttributeContainer.Builder attributes,
                                      EntityType<? extends LivingEntity> entityType){
        FabricDefaultAttributeRegistry.register(entityType, attributes);
        Registry.register(Registry.ENTITY_TYPE, MobSummoning.ID(name), entityType);
    }
}

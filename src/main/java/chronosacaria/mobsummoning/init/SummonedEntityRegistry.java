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
    public static final EntityType<SummonedGhastEntity> SUMMONED_GHAST_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedGhastEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedHuskEntity> SUMMONED_HUSK_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedHuskEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedRavagerEntity> SUMMONED_RAVAGER_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedRavagerEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedSkeletonEntity> SUMMONED_SKELETON_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedSkeletonEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedWitherSkeletonEntity> SUMMONED_WITHER_SKELETON_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedWitherSkeletonEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
    public static final EntityType<SummonedZombieEntity> SUMMONED_ZOMBIE_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SummonedZombieEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();



    public static void register(){
        registerEntity("summoned_bat", SummonedBatEntity.createBatAttributes(), SUMMONED_BAT_ENTITY);
        registerEntity("summoned_cat", SummonedCatEntity.createCatAttributes(), SUMMONED_CAT_ENTITY);
        registerEntity("summoned_chicken", SummonedChickenEntity.createChickenAttributes(), SUMMONED_CHICKEN_ENTITY);
        registerEntity("summoned_cow", SummonedCowEntity.createCowAttributes(), SUMMONED_COW_ENTITY);
        registerEntity("summoned_fox", SummonedFoxEntity.createFoxAttributes(), SUMMONED_FOX_ENTITY);
        registerEntity("summoned_pig", SummonedPigEntity.createPigAttributes(), SUMMONED_PIG_ENTITY);
        registerEntity("summoned_rabbit", SummonedRabbitEntity.createRabbitAttributes(), SUMMONED_RABBIT_ENTITY);
        registerEntity("summoned_sheep", SummonedSheepEntity.createSheepAttributes(), SUMMONED_SHEEP_ENTITY);

        registerEntity("summoned_enderman", SummonedEndermanEntity.createEndermanAttributes(), SUMMONED_ENDERMAN_ENTITY);
        registerEntity("summoned_iron_golem", SummonedIronGolemEntity.createIronGolemAttributes(), SUMMONED_IRON_GOLEM_ENTITY);
        registerEntity("summoned_llama", SummonedLlamaEntity.createLlamaAttributes(), SUMMONED_LLAMA_ENTITY);
        registerEntity("summoned_spider", SummonedSpiderEntity.createSpiderAttributes(), SUMMONED_SPIDER_ENTITY);
        registerEntity("summoned_wolf", SummonedWolfEntity.createWolfAttributes(), SUMMONED_WOLF_ENTITY);

        registerEntity("summoned_blaze", SummonedBlazeEntity.createBlazeAttributes(), SUMMONED_BLAZE_ENTITY);
        registerEntity("summoned_ghast", SummonedGhastEntity.createGhastAttributes(), SUMMONED_GHAST_ENTITY);
        registerEntity("summoned_husk", SummonedHuskEntity.createZombieAttributes(), SUMMONED_HUSK_ENTITY);
        registerEntity("summoned_ravager", SummonedRavagerEntity.createRavagerAttributes(), SUMMONED_RAVAGER_ENTITY);
        registerEntity("summoned_skeleton", SummonedSkeletonEntity.createAbstractSkeletonAttributes(), SUMMONED_SKELETON_ENTITY);
        registerEntity("summoned_wither_skeleton", SummonedWitherSkeletonEntity.createWitherSkeletonAttributes(), SUMMONED_WITHER_SKELETON_ENTITY);
        registerEntity("summoned_zombie", SummonedZombieEntity.createZombieAttributes(), SUMMONED_ZOMBIE_ENTITY);

    }

    public static void registerEntity(String name, DefaultAttributeContainer.Builder attributes,
                                      EntityType<? extends LivingEntity> entityType){
        FabricDefaultAttributeRegistry.register(entityType, attributes);
        Registry.register(Registry.ENTITY_TYPE, MobSummoning.ID(name), entityType);
    }
}

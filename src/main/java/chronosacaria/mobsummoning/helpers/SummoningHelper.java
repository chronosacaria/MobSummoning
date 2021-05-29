package chronosacaria.mobsummoning.helpers;

import chronosacaria.mobsummoning.entities.*;
import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SummoningHelper {

    // Passive Mobs
    public static void summonBat (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedBatEntity summonedEntity = SummonedEntityRegistry.SUMMONED_BAT_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonCat (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedCatEntity summonedEntity = SummonedEntityRegistry.SUMMONED_CAT_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonChicken (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedChickenEntity summonedEntity = SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonCow (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedCowEntity summonedEntity = SummonedEntityRegistry.SUMMONED_COW_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonFox (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedFoxEntity summonedEntity = SummonedEntityRegistry.SUMMONED_FOX_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonPig (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedPigEntity summonedEntity = SummonedEntityRegistry.SUMMONED_PIG_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonRabbit (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedRabbitEntity summonedEntity = SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonSheep (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedSheepEntity summonedEntity = SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }

    // Neutral Mobs
    public static void summonEnderman (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedEndermanEntity summonedEntity = SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonIronGolem (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedIronGolemEntity summonedEntity = SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonLlama (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedLlamaEntity summonedEntity = SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonSpider (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedSpiderEntity summonedEntity = SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonWolf (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedWolfEntity summonedEntity = SummonedEntityRegistry.SUMMONED_WOLF_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }

    // Hostile Mobs
    public static void summonBlaze (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedBlazeEntity summonedEntity = SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
    public static void summonSkeleton (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedSkeletonEntity summonedEntity = SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        summonedEntity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        summonedEntity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
        world.spawnEntity(summonedEntity);
    }
    public static void summonZombie (LivingEntity entity, BlockPos blockPos, int cost){
        World world = entity.getEntityWorld();

        SummonedZombieEntity summonedEntity = SummonedEntityRegistry.SUMMONED_ZOMBIE_ENTITY.create(world);
        assert summonedEntity != null;
        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        summonedEntity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
        summonedEntity.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
        world.spawnEntity(summonedEntity);
    }






}

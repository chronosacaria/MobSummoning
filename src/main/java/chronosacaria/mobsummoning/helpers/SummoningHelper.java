package chronosacaria.mobsummoning.helpers;

import chronosacaria.mobsummoning.entities.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SummoningHelper {

    public static void summonMob (SummonedEntity summonedEntity, LivingEntity entity, BlockPos blockPos, int cost){
        World world = summonedEntity.getEntityWorld();

        summonedEntity.setSummoner(entity);
        summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        ((PlayerEntity)entity).addExperienceLevels(-cost);
        world.spawnEntity(summonedEntity);
    }
}

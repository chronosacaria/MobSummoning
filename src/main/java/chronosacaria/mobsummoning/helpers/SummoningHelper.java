package chronosacaria.mobsummoning.helpers;

import chronosacaria.mobsummoning.entities.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SummoningHelper {

    public static void summonMob (SummonedEntity summonedEntity, LivingEntity entity, BlockPos blockPos,
                                  Item summoningItem,
                                  int xpCost, int itemCost){
        World world = summonedEntity.getEntityWorld();

        if (entity.getOffHandStack().getItem() == summoningItem) {
            summonedEntity.setSummoner(entity);
            summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
            ((PlayerEntity) entity).addExperienceLevels(-xpCost);
            entity.getOffHandStack().decrement(itemCost);

            world.spawnEntity(summonedEntity);
        }
    }
}

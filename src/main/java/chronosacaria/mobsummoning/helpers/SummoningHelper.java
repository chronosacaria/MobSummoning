package chronosacaria.mobsummoning.helpers;

import chronosacaria.mobsummoning.configs.MobSummoningItemConfig;
import chronosacaria.mobsummoning.entities.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SummoningHelper {

    public static void summonMob (SummonedEntity summonedEntity, LivingEntity livingEntity, BlockPos blockPos,
                                  Item summoningItem,
                                  int xpCost, int itemCost){
        World world = summonedEntity.getEntityWorld();

        if (livingEntity.getOffHandStack().getItem() == summoningItem) {
            summonedEntity.setSummoner(livingEntity);
            summonedEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
            ((PlayerEntity) livingEntity).addExperienceLevels(-xpCost);
            livingEntity.getOffHandStack().decrement(itemCost);

            livingEntity.getMainHandStack().damage(1, livingEntity,
                    (entity) -> entity.sendToolBreakStatus(entity.getActiveHand()));
            ((PlayerEntity) livingEntity).getItemCooldownManager().set(livingEntity.getMainHandStack().getItem(),
                    MobSummoningItemConfig.getItemCooldown("summoning_staff"));

            world.spawnEntity(summonedEntity);
        }
    }
}

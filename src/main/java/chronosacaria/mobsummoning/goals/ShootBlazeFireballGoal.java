package chronosacaria.mobsummoning.goals;

import chronosacaria.mobsummoning.entities.SummonedBlazeEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.math.MathHelper;

import java.util.EnumSet;

public class ShootBlazeFireballGoal extends Goal {
    private final SummonedBlazeEntity blaze;
    private int fireballsFired;
    private int fireballCooldown;
    private int targetNotVisibleTicks;

    public ShootBlazeFireballGoal(SummonedBlazeEntity blaze) {
        this.blaze = blaze;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.blaze.getTarget();
        return livingEntity != null && livingEntity.isAlive() && this.blaze.canTarget(livingEntity);
    }

    public void start() {
        this.fireballsFired = 0;
    }

    public void stop() {
        this.targetNotVisibleTicks = 0;
    }

    public void tick() {
        --this.fireballCooldown;
        LivingEntity livingEntity = this.blaze.getTarget();
        if (livingEntity != null) {
            boolean bl = this.blaze.getVisibilityCache().canSee(livingEntity);
            if (bl) {
                this.targetNotVisibleTicks = 0;
            } else {
                ++this.targetNotVisibleTicks;
            }

            double d = this.blaze.squaredDistanceTo(livingEntity);
            if (d < 4.0D) {
                if (!bl) {
                    return;
                }

                if (this.fireballCooldown <= 0) {
                    this.fireballCooldown = 20;
                    this.blaze.tryAttack(livingEntity);
                }

                this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0D);
            } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                double e = livingEntity.getX() - this.blaze.getX();
                double f = livingEntity.getBodyY(0.5D) - this.blaze.getBodyY(0.5D);
                double g = livingEntity.getZ() - this.blaze.getZ();
                if (this.fireballCooldown <= 0) {
                    ++this.fireballsFired;
                    if (this.fireballsFired == 1) {
                        this.fireballCooldown = 60;
                        //this.blaze.setFireActive(true);
                    } else if (this.fireballsFired <= 4) {
                        this.fireballCooldown = 6;
                    } else {
                        this.fireballCooldown = 100;
                        this.fireballsFired = 0;
                        //this.blaze.setFireActive(false);
                    }

                    if (this.fireballsFired > 1) {
                        float h = MathHelper.sqrt(MathHelper.sqrt(d)) * 0.5F;
                        if (!this.blaze.isSilent()) {
                            this.blaze.world.syncWorldEvent((PlayerEntity) null, 1018, this.blaze.getBlockPos(), 0);
                        }

                        for (int i = 0; i < 1; ++i) {
                            SmallFireballEntity smallFireballEntity = new SmallFireballEntity(this.blaze.world, this.blaze, e + this.blaze.getRandom().nextGaussian() * (double) h, f, g + this.blaze.getRandom().nextGaussian() * (double) h);
                            smallFireballEntity.updatePosition(smallFireballEntity.getX(), this.blaze.getBodyY(0.5D) + 0.5D, smallFireballEntity.getZ());
                            this.blaze.world.spawnEntity(smallFireballEntity);
                        }
                    }
                }

                this.blaze.getLookControl().lookAt(livingEntity, 10.0F, 10.0F);
            } else if (this.targetNotVisibleTicks < 5) {
                this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0D);
            }

            super.tick();
        }
    }
    private double getFollowRange() {
        return this.blaze.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
    }
}
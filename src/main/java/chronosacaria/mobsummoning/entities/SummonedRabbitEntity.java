package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SummonedRabbitEntity extends SummonedEntity implements ISummonable {

    private int jumpTicks;
    private int jumpDuration;

    public SummonedRabbitEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    protected float getJumpVelocity() {
        if (!this.horizontalCollision && (!this.moveControl.isMoving() || !(this.moveControl.getTargetY() > this.getY() + 0.5D))) {
            Path path = this.navigation.getCurrentPath();
            if (path != null && !path.isFinished()) {
                Vec3d vec3d = path.getNodePosition(this);
                if (vec3d.y > this.getY() + 0.5D) {
                    return 0.5F;
                }
            }

            return this.moveControl.getSpeed() <= 0.6D ? 0.2F : 0.3F;
        } else {
            return 0.5F;
        }
    }

    protected void jump() {
        super.jump();
        double d = this.moveControl.getSpeed();
        if (d > 0.0D) {
            double e = squaredHorizontalLength(this.getVelocity());
            if (e < 0.01D) {
                this.updateVelocity(0.1F, new Vec3d(0.0D, 0.0D, 1.0D));
            }
        }

        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)1);
        }

    }

    @Environment(EnvType.CLIENT)
    public float getJumpProgress(float delta) {
        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + delta) / (float)this.jumpDuration;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this),
                8.0F);
        if (bl) {
            this.dealDamage(this, target);
            this.playSound(SoundEvents.ENTITY_RABBIT_ATTACK, 1f,
                    (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
        }

        return bl;
    }

    @Override
    public void setAttacker(LivingEntity attacker){
        if (attacker == getSummoner()) {

        } else {
            super.setAttacker(attacker);
        }
    }

    @Override
    public void tickMovement(){
        if (this.isAlive()){
            if (getSummoner() != null){
                if (getSummoner().getAttacker() != null){
                    this.setTarget(getSummoner().getAttacker());
                } else if (getSummoner().getAttacking() != null && getSummoner().getAttacking() != this) {
                    this.setTarget(getSummoner().getAttacking());
                }
            }
        }
        super.tickMovement();
    }
}

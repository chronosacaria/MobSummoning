package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SummonedSkeletonEntity extends SummonedEntity implements ISummonable, RangedAttackMob {

    public SummonedSkeletonEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(0, new SwimGoal(this));
        //this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25D, 40, 20.0F));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
        this.goalSelector.add(7, new LookAtEntityGoal(this, MobEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAbstractSkeletonAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this),
                8.0F);
        if (bl) {
            this.dealDamage(this, target);
            this.playSound(SoundEvents.ENTITY_SKELETON_AMBIENT, 1f,
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

    @Override
    protected void mobTick(){

    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        ItemStack itemStack = this.getArrowType(this.getStackInHand(ProjectileUtil.getHandPossiblyHolding(this, Items.BOW)));
        PersistentProjectileEntity persistentProjectileEntity = this.createArrowProjectile(itemStack, pullProgress);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.3333333333333333D) - persistentProjectileEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = (double) MathHelper.sqrt(d * d + f * f);
        persistentProjectileEntity.setVelocity(d, e + g * 0.20000000298023224D, f, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(persistentProjectileEntity);
    }

    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier) {
        return ProjectileUtil.createArrowProjectile(this, arrow, damageModifier);
    }

}
package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.configs.MobSummoningStatsConfig;
import chronosacaria.mobsummoning.goals.ShootBlazeFireballGoal;
import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

import static chronosacaria.mobsummoning.configs.MobSummoningStatsConfig.*;

public class SummonedBlazeEntity extends SummonedEntity implements ISummonable {

    public SummonedBlazeEntity(EntityType type, World world){
        super(EntityType.BLAZE, world);
    }


    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new ShootBlazeFireballGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
        this.goalSelector.add(7, new LookAtEntityGoal(this, MobEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createBlazeAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, getSummonMaxHealth("summoned_blaze"))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, getSummonAttackDamage("summoned_blaze"))
                .add(EntityAttributes.GENERIC_ARMOR, getSummonArmor("summoned_blaze"))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, getSummonMovementSpeed("summoned_blaze"))
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, getSummonFollowRange("summoned_blaze"))
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, getSummonAttackKnockback("summoned_blaze"))
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, getSummonKnockbackResistance("summoned_blaze"));
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
}

package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

import static chronosacaria.mobsummoning.configs.MobSummoningStatsConfig.*;

public class SummonedEndermanEntity extends SummonedEntity implements ISummonable {

    public SummonedEndermanEntity(EntityType type, World world){
        super(EntityType.ENDERMAN, world);
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
    }

    public static DefaultAttributeContainer.Builder createEndermanAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, getSummonMaxHealth("summoned_enderman"))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, getSummonAttackDamage("summoned_enderman"))
                .add(EntityAttributes.GENERIC_ARMOR, getSummonArmor("summoned_enderman"))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, getSummonMovementSpeed("summoned_enderman"))
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, getSummonFollowRange("summoned_enderman"))
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, getSummonAttackKnockback("summoned_enderman"))
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, getSummonKnockbackResistance("summoned_enderman"));
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

}

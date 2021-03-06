package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

import static chronosacaria.mobsummoning.configs.MobSummoningStatsConfig.*;
import static chronosacaria.mobsummoning.configs.MobSummoningStatsConfig.getSummonKnockbackResistance;

public class SummonedRavagerEntity extends SummonedEntity implements ISummonable {

    private int attackTick;
    private int stunTick;
    private int roarTick;

    public SummonedRavagerEntity(EntityType type, World world){
        super(EntityType.RAVAGER, world);
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
    }

    public static DefaultAttributeContainer.Builder createRavagerAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, getSummonMaxHealth("summoned_ravager"))
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, getSummonAttackDamage("summoned_ravager"))
                .add(EntityAttributes.GENERIC_ARMOR, getSummonArmor("summoned_ravager"))
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, getSummonMovementSpeed("summoned_ravager"))
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, getSummonFollowRange("summoned_ravager"))
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, getSummonAttackKnockback("summoned_ravager"))
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, getSummonKnockbackResistance("summoned_ravager"));
    }

    @Environment(EnvType.CLIENT)
    public int getAttackTick() {
        return this.attackTick;
    }

    @Environment(EnvType.CLIENT)
    public int getStunTick() {
        return this.stunTick;
    }

    @Environment(EnvType.CLIENT)
    public int getRoarTick() {
        return this.roarTick;
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

package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.SummonedEntityFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SummonedLlamaEntity extends SummonedEntity implements ISummonable {

    private boolean spit;

    public SummonedLlamaEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals(){

        //this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25D, 40, 20.0F));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.add(3, new RevengeGoal(this));
        this.goalSelector.add(6, new SummonedEntityFollowSummonerGoal(this, this.getSummoner(), this.world, 0.75,
                this.getNavigation(), 90.0F, 10.0F, true));
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this),
                8.0F);
        if (bl) {
            this.dealDamage(this, target);
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1f,
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

}

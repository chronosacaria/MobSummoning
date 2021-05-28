package chronosacaria.mobsummoning.entities;

import chronosacaria.mobsummoning.goals.ChickenFollowSummonerGoal;
import chronosacaria.mobsummoning.interfaces.ISummonable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.UUID;

public class SummonedChickenEntity extends ChickenEntity implements ISummonable {

    protected static final TrackedData<Optional<UUID>> SUMMONER_UUID;

    public SummonedChickenEntity(EntityType type, World world){
        super(EntityType.CHICKEN, world);
    }

    public void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(SUMMONER_UUID, Optional.empty());
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.1D, Ingredient.ofItems(Items.WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(6, new ChickenFollowSummonerGoal(this, this.getSummoner(), this.world, 1.0,
                this.getNavigation(), 90.0F, 10.0F, true));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    private void setSummonerUuid (UUID uuid){
        this.dataTracker.set(SUMMONER_UUID, Optional.ofNullable(uuid));
    }

    public Optional<UUID> getSummonerUuid(){
        return this.dataTracker.get(SUMMONER_UUID);
    }

    public void setSummoner(Entity player) {
        this.setSummonerUuid(player.getUuid());
    }

    public void writeCustomDataToTag(CompoundTag tag){
        super.writeCustomDataToTag(tag);
        tag.putUuid("SummonerUUID",getSummonerUuid().get());
    }

    public void readCustomDataFromTag(CompoundTag tag){
        super.readCustomDataFromTag(tag);
        UUID id;
        if (tag.contains("SummonerUUID")){
            id = tag.getUuid("SummonerUUID");
        } else {
            id = tag.getUuid("SummonerUUID");
        }
        if (id != null){
            this.setSummonerUuid(tag.getUuid("SummonerUUID"));
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this),
                8.0F);
        if (bl) {
            this.dealDamage(this, target);
            this.playSound(SoundEvents.ENTITY_CHICKEN_AMBIENT, 1f,
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

    public LivingEntity getSummoner(){
        try {
            Optional<UUID> uUID = this.getSummonerUuid();
            return uUID.map(value -> this.world.getPlayerByUuid(value)).orElse(null);
        } catch (IllegalArgumentException var2){
            return null;
        }
    }

    static {
        SUMMONER_UUID = DataTracker.registerData(SummonedChickenEntity.class,
                TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }

}

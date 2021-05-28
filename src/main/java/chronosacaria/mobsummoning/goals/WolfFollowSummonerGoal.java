package chronosacaria.mobsummoning.goals;

import chronosacaria.mobsummoning.entities.SummonedLlamaEntity;
import chronosacaria.mobsummoning.entities.SummonedWolfEntity;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class WolfFollowSummonerGoal extends Goal {

    private final SummonedWolfEntity summonedEntity;

    private LivingEntity summoner;
    private final WorldView worldView;
    private final double speed;
    private final EntityNavigation navigation;
    private int countdownTicks;
    private final float maxDistance;
    private final float minDistance;
    private final boolean leavesAllowed;

    public WolfFollowSummonerGoal(SummonedWolfEntity summonedEntity, LivingEntity summoner, WorldView worldView,
                                  double speed, EntityNavigation navigation, float maxDistance, float minDistance, boolean leavesAllowed){
        this.summonedEntity = summonedEntity;
        this.summoner = summoner;
        this.worldView = worldView;
        this.speed = speed;
        this.navigation = navigation;
        this.maxDistance = maxDistance;
        this.minDistance = minDistance;
        this.leavesAllowed = leavesAllowed;
    }

    @Override
    public boolean canStart() {
        LivingEntity livingEntity = this.summonedEntity.getSummoner();

        if (livingEntity == null || livingEntity.isSpectator() || this.summonedEntity.squaredDistanceTo(livingEntity) < (double) (this.minDistance * this.minDistance))
            return false;
        this.summoner = livingEntity;
        return true;
    }

    @Override
    public boolean shouldContinue(){
        if (this.navigation.isIdle()){
            return false;
        } else {
            return this.summonedEntity.squaredDistanceTo(this.summoner) > (double) (this.maxDistance * this.maxDistance);
        }
    }

    public void tick(){
        this.summonedEntity.getLookControl().lookAt(this.summoner,10.0F, (float) this.summonedEntity.getLookPitchSpeed());
        if (--this.countdownTicks <= 0){
            this.countdownTicks = 10;
            if (!this.summonedEntity.hasVehicle()){
                if (this.summonedEntity.squaredDistanceTo(this.summoner) >= 144.0D) {
                    this.tryTeleport();
                } else {
                    this.navigation.startMovingTo(this.summoner,this.speed);
                }
            }
        }
    }

    private void tryTeleport(){
        BlockPos blockPos = new BlockPos(this.summoner.getBlockPos());

        for (int i = 0; i < 10; ++i){
            int j = this.getRandomInt(-3, 3);
            int k = this.getRandomInt(-1, 1);
            int l = this.getRandomInt(-3, 3);
            boolean bl = this.tryTeleportTo(blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l); //23343
            if (bl) {
                return;
            }
        }
    }

    private boolean tryTeleportTo(int i, int j, int k){
        if (Math.abs((double) i - this.summoner.getX()) < 2.0D && Math.abs((double) k - this.summoner.getZ()) < 2.0D) {
            return false;
        } else if (!this.canTeleportTo(new BlockPos(i, j, k))){ //23344
            return false;
        } else {
            this.navigation.stop();
            return true;
        }
    }

    private boolean canTeleportTo(BlockPos blockPos) {
        if (LandPathNodeMaker.getLandNodeType(summonedEntity.getEntityWorld(), new BlockPos.Mutable()) != PathNodeType.WALKABLE)
            return false;
        if (!this.leavesAllowed && this.worldView.getBlockState(blockPos.down()).getBlock() instanceof LeavesBlock)
            return false;
        return this.worldView.isSpaceEmpty(this.summonedEntity, this.summonedEntity.getBoundingBox().offset(blockPos.subtract(new BlockPos(this.summonedEntity.getBlockPos()))));
    }

    private int getRandomInt(int i, int j){
        return this.summonedEntity.getRandom().nextInt(j - i + 1) + i;
    }
}
package chronosacaria.mobsummoning.goals;

import chronosacaria.mobsummoning.entities.SummonedCreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SummonedCreeperIgniteGoal extends Goal {
    private final SummonedCreeperEntity creeper;
    private LivingEntity target;

    public SummonedCreeperIgniteGoal(SummonedCreeperEntity creeper) {
        this.creeper = creeper;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.creeper.getTarget();
        return this.creeper.getFuseSpeed() > 0 || livingEntity != null && this.creeper.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public void tick() {
        if (this.target == null) {
            this.creeper.setFuseSpeed(-1);
        } else if (this.creeper.squaredDistanceTo(this.target) > 49.0D) {
            this.creeper.setFuseSpeed(-1);
        } else if (!this.creeper.getVisibilityCache().canSee(this.target)) {
            this.creeper.setFuseSpeed(-1);
        } else {
            this.creeper.setFuseSpeed(1);
        }
    }
}

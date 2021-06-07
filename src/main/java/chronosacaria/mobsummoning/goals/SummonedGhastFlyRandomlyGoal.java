package chronosacaria.mobsummoning.goals;

import chronosacaria.mobsummoning.entities.SummonedGhastEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;
import java.util.Random;

public class SummonedGhastFlyRandomlyGoal extends Goal {
    private final SummonedGhastEntity ghast;

    public SummonedGhastFlyRandomlyGoal(SummonedGhastEntity ghast) {
        this.ghast = ghast;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        MoveControl moveControl = this.ghast.getMoveControl();
        if (!moveControl.isMoving()) {
            return true;
        } else {
            double d = moveControl.getTargetX() - this.ghast.getX();
            double e = moveControl.getTargetY() - this.ghast.getY();
            double f = moveControl.getTargetZ() - this.ghast.getZ();
            double g = d * d + e * e + f * f;
            return g < 1.0D || g > 3600.0D;
        }
    }

    public boolean shouldContinue() {
        return false;
    }

    public void start() {
        Random random = this.ghast.getRandom();
        double d = this.ghast.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        double e = this.ghast.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        double f = this.ghast.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        this.ghast.getMoveControl().moveTo(d, e, f, 1.0D);
    }
}
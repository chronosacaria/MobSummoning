package chronosacaria.mobsummoning.entities.models;

import chronosacaria.mobsummoning.entities.SummonedHuskEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.AbstractZombieModel;

@Environment(EnvType.CLIENT)
public class SummonedHuskModel<T extends SummonedHuskEntity> extends AbstractZombieModel<T> {
    public SummonedHuskModel(float scale, boolean bl) {
        this(scale, 0.0F, 64, bl ? 32 : 64);
    }

    protected SummonedHuskModel(float f, float g, int i, int j) {
        super(f, g, i, j);
    }

    public boolean isAttacking(T zombieEntity) {
        return zombieEntity.isAttacking();
    }
}
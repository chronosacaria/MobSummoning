package chronosacaria.mobsummoning.entities.models;

import chronosacaria.mobsummoning.entities.SummonedZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.AbstractZombieModel;

@Environment(EnvType.CLIENT)
public class SummonedZombieEntityModel<T extends SummonedZombieEntity> extends AbstractZombieModel<T> {
    public SummonedZombieEntityModel(float scale, boolean bl) {
        this(scale, 0.0F, 64, bl ? 32 : 64);
    }

    protected SummonedZombieEntityModel(float f, float g, int i, int j) {
        super(f, g, i, j);
    }

    public boolean isAttacking(T zombieEntity) {
        return zombieEntity.isAttacking();
    }
}
package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedWolfEntity;
import chronosacaria.mobsummoning.entities.models.SummonedWolfEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedWolfRenderer extends MobEntityRenderer<SummonedWolfEntity, SummonedWolfEntityModel<SummonedWolfEntity>> {

    public SummonedWolfRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedWolfEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedWolfEntity entity) {
        return new Identifier("textures/entity/wolf/wolf.png");
    }

    protected float getAnimationProgress(SummonedWolfEntity wolfEntity, float f) {
        return wolfEntity.getTailAngle();
    }
}

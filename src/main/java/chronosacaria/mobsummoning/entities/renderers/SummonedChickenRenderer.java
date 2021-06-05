package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedChickenEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SummonedChickenRenderer extends MobEntityRenderer<SummonedChickenEntity, ChickenEntityModel<SummonedChickenEntity>> {

    public SummonedChickenRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new ChickenEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedChickenEntity entity) {
        return new Identifier("textures/entity/chicken.png");
    }

    protected float getAnimationProgress(SummonedChickenEntity chickenEntity, float f) {
        float g = MathHelper.lerp(f, chickenEntity.prevFlapProgress, chickenEntity.flapProgress);
        float h = MathHelper.lerp(f, chickenEntity.prevMaxWingDeviation, chickenEntity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0F) * h;
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedWitherSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedWitherSkeletonRenderer extends MobEntityRenderer<SummonedWitherSkeletonEntity,
        SkeletonEntityModel<SummonedWitherSkeletonEntity>> {

    public SummonedWitherSkeletonRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SkeletonEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedWitherSkeletonEntity entity) {
        return new Identifier("textures/entity/skeleton/wither_skeleton.png");
    }
}

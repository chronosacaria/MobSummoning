package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedSkeletonRenderer extends MobEntityRenderer<SummonedSkeletonEntity, SkeletonEntityModel<SummonedSkeletonEntity>> {

    public SummonedSkeletonRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SkeletonEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedSkeletonEntity entity) {
        return new Identifier("textures/entity/skeleton/skeleton.png");
    }
}

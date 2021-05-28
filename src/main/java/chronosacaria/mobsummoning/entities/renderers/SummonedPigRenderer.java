package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedPigEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;

public class SummonedPigRenderer extends MobEntityRenderer<SummonedPigEntity, PigEntityModel<SummonedPigEntity>> {

    public SummonedPigRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new PigEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedPigEntity entity) {
        return new Identifier("textures/entity/pig/pig.png");
    }
}

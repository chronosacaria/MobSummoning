package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedRabbitEntity;
import chronosacaria.mobsummoning.entities.models.SummonedRabbitModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SummonedRabbitRenderer extends MobEntityRenderer<SummonedRabbitEntity, SummonedRabbitModel<SummonedRabbitEntity>> {

    public SummonedRabbitRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedRabbitModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedRabbitEntity entity) {
        return new Identifier("textures/entity/rabbit/black.png");
    }
}

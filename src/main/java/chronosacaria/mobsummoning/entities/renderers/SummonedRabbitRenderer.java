package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedChickenEntity;
import chronosacaria.mobsummoning.entities.SummonedRabbitEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.RabbitEntityModel;
import net.minecraft.util.Identifier;

public class SummonedRabbitRenderer extends MobEntityRenderer<SummonedRabbitEntity, RabbitEntityModel<SummonedRabbitEntity>> {

    public SummonedRabbitRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new RabbitEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedRabbitEntity entity) {
        return new Identifier("textures/entity/rabbit/rabbit.png");
    }
}

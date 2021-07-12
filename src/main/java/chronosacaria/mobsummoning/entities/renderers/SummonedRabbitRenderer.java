package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedRabbitEntity;
import chronosacaria.mobsummoning.entities.models.SummonedRabbitEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedRabbitRenderer extends MobEntityRenderer<SummonedRabbitEntity, SummonedRabbitEntityModel<SummonedRabbitEntity>> {

    public SummonedRabbitRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedRabbitEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedRabbitEntity entity) {
        return new Identifier("textures/entity/rabbit/black.png");
    }
}

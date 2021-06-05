package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedLlamaEntity;
import chronosacaria.mobsummoning.entities.models.SummonedLlamaModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SummonedLlamaRenderer extends MobEntityRenderer<SummonedLlamaEntity, SummonedLlamaModel<SummonedLlamaEntity>> {

    public SummonedLlamaRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedLlamaModel<>(1), 1);
    }

    @Override
    public Identifier getTexture(SummonedLlamaEntity entity) {
        return new Identifier("textures/entity/llama/white.png");
    }
}

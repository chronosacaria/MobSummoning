package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedIronGolemEntity;
import chronosacaria.mobsummoning.entities.SummonedLlamaEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.client.render.entity.model.LlamaEntityModel;
import net.minecraft.util.Identifier;

public class SummonedLlamaRenderer extends MobEntityRenderer<SummonedLlamaEntity, LlamaEntityModel<SummonedLlamaEntity>> {

    public SummonedLlamaRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new LlamaEntityModel<>(1), 1);
    }

    @Override
    public Identifier getTexture(SummonedLlamaEntity entity) {
        return new Identifier("textures/entity/llama/llama.png");
    }
}

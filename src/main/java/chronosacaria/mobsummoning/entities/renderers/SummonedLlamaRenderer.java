package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedLlamaEntity;
import chronosacaria.mobsummoning.entities.models.SummonedLlamaEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedLlamaRenderer extends MobEntityRenderer<SummonedLlamaEntity, SummonedLlamaEntityModel<SummonedLlamaEntity>> {

    public SummonedLlamaRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedLlamaEntityModel<>(0.75f), 1);
    }

    @Override
    public Identifier getTexture(SummonedLlamaEntity entity) {
        return new Identifier("textures/entity/llama/white.png");
    }
}

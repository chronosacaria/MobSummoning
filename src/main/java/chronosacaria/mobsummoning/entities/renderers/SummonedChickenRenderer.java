package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedChickenEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.util.Identifier;

public class SummonedChickenRenderer extends MobEntityRenderer<SummonedChickenEntity, ChickenEntityModel<SummonedChickenEntity>> {

    public SummonedChickenRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new ChickenEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedChickenEntity entity) {
        return new Identifier("textures/entity/chicken/chicken.png");
    }
}

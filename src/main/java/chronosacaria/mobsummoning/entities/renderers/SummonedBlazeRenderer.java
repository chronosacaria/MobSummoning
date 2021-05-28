package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedBlazeEntity;
import chronosacaria.mobsummoning.entities.SummonedSpiderEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BlazeEntityModel;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.util.Identifier;

public class SummonedBlazeRenderer extends MobEntityRenderer<SummonedBlazeEntity, BlazeEntityModel<SummonedBlazeEntity>> {

    public SummonedBlazeRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new BlazeEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedBlazeEntity entity) {
        return new Identifier("textures/entity/blaze/blaze.png");
    }
}

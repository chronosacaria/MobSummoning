package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedIronGolemEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.util.Identifier;

public class SummonedIronGolemRenderer extends MobEntityRenderer<SummonedIronGolemEntity, IronGolemEntityModel<SummonedIronGolemEntity>> {

    public SummonedIronGolemRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new IronGolemEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedIronGolemEntity entity) {
        return new Identifier("textures/entity/iron_golem/iron_golem.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedIronGolemEntity;
import chronosacaria.mobsummoning.entities.SummonedWolfEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.util.Identifier;

public class SummonedWolfRenderer extends MobEntityRenderer<SummonedWolfEntity, WolfEntityModel<SummonedWolfEntity>> {

    public SummonedWolfRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new WolfEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedWolfEntity entity) {
        return new Identifier("textures/entity/wolf/wolf.png");
    }
}

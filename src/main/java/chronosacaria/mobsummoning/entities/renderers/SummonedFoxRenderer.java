package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedChickenEntity;
import chronosacaria.mobsummoning.entities.SummonedFoxEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.FoxEntityModel;
import net.minecraft.util.Identifier;

public class SummonedFoxRenderer extends MobEntityRenderer<SummonedFoxEntity, FoxEntityModel<SummonedFoxEntity>> {

    public SummonedFoxRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new FoxEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedFoxEntity entity) {
        return new Identifier("textures/entity/fox/fox.png");
    }
}

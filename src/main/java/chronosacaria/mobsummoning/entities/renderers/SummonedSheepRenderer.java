package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedSheepEntity;
import chronosacaria.mobsummoning.entities.models.SummonedSheepModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.util.Identifier;

public class SummonedSheepRenderer extends MobEntityRenderer<SummonedSheepEntity, SummonedSheepModel<SummonedSheepEntity>> {

    public SummonedSheepRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedSheepModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedSheepEntity entity) {
        return new Identifier("textures/entity/sheep/sheep_fur.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCatEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CatEntityModel;
import net.minecraft.util.Identifier;

public class SummonedCatRenderer extends MobEntityRenderer<SummonedCatEntity, CatEntityModel<SummonedCatEntity>> {

    public SummonedCatRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new CatEntityModel<>(1), 1);
    }

    @Override
    public Identifier getTexture(SummonedCatEntity entity) {
        return new Identifier("textures/entity/cat/cat.png");
    }
}

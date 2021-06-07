package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCatEntity;
import chronosacaria.mobsummoning.entities.models.SummonedCatModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CatEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedCatRenderer extends MobEntityRenderer<SummonedCatEntity, SummonedCatModel<SummonedCatEntity>> {

    public SummonedCatRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedCatModel<>(0.25f), 1);
    }

    @Override
    public Identifier getTexture(SummonedCatEntity entity) {
        return new Identifier("textures/entity/cat/black.png");
    }
}

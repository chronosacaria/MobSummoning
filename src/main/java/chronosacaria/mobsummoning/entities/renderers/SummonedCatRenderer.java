package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCatEntity;
import chronosacaria.mobsummoning.entities.models.SummonedCatEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedCatRenderer extends MobEntityRenderer<SummonedCatEntity, SummonedCatEntityModel<SummonedCatEntity>> {

    public SummonedCatRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedCatEntityModel<>(0.25f), 1);
    }

    @Override
    public Identifier getTexture(SummonedCatEntity entity) {
        return new Identifier("textures/entity/cat/black.png");
    }
}

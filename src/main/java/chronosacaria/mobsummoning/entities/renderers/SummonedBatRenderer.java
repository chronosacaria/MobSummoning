package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedBatEntity;
import chronosacaria.mobsummoning.entities.models.SummonedBatEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedBatRenderer extends MobEntityRenderer<SummonedBatEntity, SummonedBatEntityModel> {

    public SummonedBatRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedBatEntityModel(), 0.25f);
    }

    @Override
    public Identifier getTexture(SummonedBatEntity entity) {
        return new Identifier("textures/entity/bat.png");
    }
}

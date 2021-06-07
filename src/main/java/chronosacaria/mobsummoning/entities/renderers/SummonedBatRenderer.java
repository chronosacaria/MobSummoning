package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedBatEntity;
import chronosacaria.mobsummoning.entities.models.SummonedBatModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedBatRenderer extends MobEntityRenderer<SummonedBatEntity, SummonedBatModel> {

    public SummonedBatRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedBatModel(), 0.25f);
    }

    @Override
    public Identifier getTexture(SummonedBatEntity entity) {
        return new Identifier("textures/entity/bat.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedHuskEntity;
import chronosacaria.mobsummoning.entities.models.SummonedHuskEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedHuskRenderer extends MobEntityRenderer<SummonedHuskEntity, SummonedHuskEntityModel<SummonedHuskEntity>> {

    public SummonedHuskRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedHuskEntityModel<>(0.75f, false), 1);
    }

    @Override
    public Identifier getTexture(SummonedHuskEntity entity) {
        return new Identifier("textures/entity/zombie/husk.png");
    }
}

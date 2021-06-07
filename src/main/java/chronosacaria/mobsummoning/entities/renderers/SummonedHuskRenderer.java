package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedHuskEntity;
import chronosacaria.mobsummoning.entities.SummonedZombieEntity;
import chronosacaria.mobsummoning.entities.models.SummonedHuskModel;
import chronosacaria.mobsummoning.entities.models.SummonedZombieModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedHuskRenderer extends MobEntityRenderer<SummonedHuskEntity, SummonedHuskModel<SummonedHuskEntity>> {

    public SummonedHuskRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedHuskModel<>(0.75f, false), 1);
    }

    @Override
    public Identifier getTexture(SummonedHuskEntity entity) {
        return new Identifier("textures/entity/zombie/husk.png");
    }
}

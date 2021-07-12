package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedRavagerEntity;
import chronosacaria.mobsummoning.entities.models.SummonedRavagerEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedRavagerRenderer extends MobEntityRenderer<SummonedRavagerEntity,
        SummonedRavagerEntityModel> {

    public SummonedRavagerRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedRavagerEntityModel(), 1);
    }

    @Override
    public Identifier getTexture(SummonedRavagerEntity entity) {
        return new Identifier("textures/entity/illager/ravager.png");
    }
}

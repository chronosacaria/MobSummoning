package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedEndermanEntity;
import chronosacaria.mobsummoning.entities.SummonedRavagerEntity;
import chronosacaria.mobsummoning.entities.models.SummonedRavagerModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.model.RavagerEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedRavagerRenderer extends MobEntityRenderer<SummonedRavagerEntity,
        SummonedRavagerModel> {

    public SummonedRavagerRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedRavagerModel(), 1);
    }

    @Override
    public Identifier getTexture(SummonedRavagerEntity entity) {
        return new Identifier("textures/entity/illager/ravager.png");
    }
}

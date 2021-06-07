package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedFoxEntity;
import chronosacaria.mobsummoning.entities.models.SummonedFoxModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedFoxRenderer extends MobEntityRenderer<SummonedFoxEntity, SummonedFoxModel<SummonedFoxEntity>> {

    public SummonedFoxRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedFoxModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedFoxEntity entity) {
        return new Identifier("textures/entity/fox/fox.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedCowRenderer extends MobEntityRenderer<SummonedCowEntity, CowEntityModel<SummonedCowEntity>> {

    public SummonedCowRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new CowEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedCowEntity entity) {
        return new Identifier("textures/entity/cow/cow.png");
    }
}

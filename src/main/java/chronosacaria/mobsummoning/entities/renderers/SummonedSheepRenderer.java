package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedSheepEntity;
import chronosacaria.mobsummoning.entities.models.SummonedSheepEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedSheepRenderer extends MobEntityRenderer<SummonedSheepEntity, SummonedSheepEntityModel<SummonedSheepEntity>> {

    public SummonedSheepRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedSheepEntityModel<>(), 1);
        this.addFeature(new SummonedSheepWoolFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(SummonedSheepEntity entity) {
        return new Identifier("textures/entity/sheep/sheep.png");
    }
}

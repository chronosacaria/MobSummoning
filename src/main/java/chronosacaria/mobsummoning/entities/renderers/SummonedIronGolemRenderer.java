package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedIronGolemEntity;
import chronosacaria.mobsummoning.entities.models.SummonedIronGolemEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedIronGolemRenderer extends MobEntityRenderer<SummonedIronGolemEntity,
        SummonedIronGolemEntityModel<SummonedIronGolemEntity>> {

    public SummonedIronGolemRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedIronGolemEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedIronGolemEntity entity) {
        return new Identifier("textures/entity/iron_golem/iron_golem.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedEndermanEntity;
import chronosacaria.mobsummoning.entities.SummonedIronGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedEndermanRenderer extends MobEntityRenderer<SummonedEndermanEntity, EndermanEntityModel<SummonedEndermanEntity>> {

    public SummonedEndermanRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new EndermanEntityModel<>(1), 1);
    }

    @Override
    public Identifier getTexture(SummonedEndermanEntity entity) {
        return new Identifier("textures/entity/enderman/enderman.png");
    }
}

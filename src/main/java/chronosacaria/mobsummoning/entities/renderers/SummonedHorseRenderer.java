package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCowEntity;
import chronosacaria.mobsummoning.entities.SummonedHorseEntity;
import chronosacaria.mobsummoning.entities.models.SummonedHorseEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.HorseBaseEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HorseArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.HorseEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedHorseRenderer extends
        MobEntityRenderer<SummonedHorseEntity, SummonedHorseEntityModel<SummonedHorseEntity>> {

    public SummonedHorseRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedHorseEntityModel(0.0F), 1.1F);
    }

    @Override
    public Identifier getTexture(SummonedHorseEntity entity) {
        return new Identifier("textures/entity/horse/horse_chestnut.png");
    }
}

package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedZombieEntity;
import chronosacaria.mobsummoning.entities.models.SummonedZombieModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedZombieRenderer extends MobEntityRenderer<SummonedZombieEntity, SummonedZombieModel<SummonedZombieEntity>> {

    public SummonedZombieRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SummonedZombieModel<>(0.75f, false), 1);
    }

    @Override
    public Identifier getTexture(SummonedZombieEntity entity) {
        return new Identifier("textures/entity/zombie/zombie.png");
    }
}

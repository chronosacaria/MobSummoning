package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedSpiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedSpiderRenderer extends MobEntityRenderer<SummonedSpiderEntity, SpiderEntityModel<SummonedSpiderEntity>> {

    public SummonedSpiderRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new SpiderEntityModel<>(), 1);
    }

    @Override
    public Identifier getTexture(SummonedSpiderEntity entity) {
        return new Identifier("textures/entity/spider/spider.png");
    }
}

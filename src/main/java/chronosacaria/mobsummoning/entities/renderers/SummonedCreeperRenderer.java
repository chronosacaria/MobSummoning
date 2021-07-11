package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedCreeperEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SummonedCreeperRenderer extends MobEntityRenderer<SummonedCreeperEntity, CreeperEntityModel<SummonedCreeperEntity>> {

    public SummonedCreeperRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(SummonedCreeperEntity entity) {
        return new Identifier("textures/entity/creeper/creeper.png");
    }

    protected void scale(SummonedCreeperEntity creeperEntity, MatrixStack matrixStack, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        float h = 1.0F + MathHelper.sin(g * 100.0F) * g * 0.01F;
        g = MathHelper.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float i = (1.0F + g * 0.4F) * h;
        float j = (1.0F + g * 0.1F) / h;
        matrixStack.scale(i, j, i);
    }

    protected float getAnimationCounter(SummonedCreeperEntity creeperEntity, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(g, 0.5F, 1.0F);
    }
}

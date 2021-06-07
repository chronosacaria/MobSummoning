package chronosacaria.mobsummoning.entities.renderers;

import chronosacaria.mobsummoning.entities.SummonedGhastEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.GhastEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SummonedGhastRenderer extends MobEntityRenderer<SummonedGhastEntity, GhastEntityModel<SummonedGhastEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/ghast/ghast.png");
    private static final Identifier ANGRY_TEXTURE = new Identifier("textures/entity/ghast/ghast_shooting.png");

    public SummonedGhastRenderer(EntityRenderDispatcher renderDispatcher){
        super(renderDispatcher, new GhastEntityModel<>(), 1);
    }

    public Identifier getTexture(SummonedGhastEntity ghastEntity) {
        return ghastEntity.isShooting() ? ANGRY_TEXTURE : TEXTURE;
    }

    protected void scale(SummonedGhastEntity ghastEntity, MatrixStack matrixStack, float f) {
        float g = 1.0F;
        float h = 4.5F;
        float i = 4.5F;
        matrixStack.scale(4.5F, 4.5F, 4.5F);
    }

}

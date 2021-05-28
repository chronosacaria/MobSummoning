package chronosacaria.mobsummoning.client;

import chronosacaria.mobsummoning.entities.SummonedSkeletonEntity;
import chronosacaria.mobsummoning.entities.renderers.*;
import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.EntityType;

@Environment(EnvType.CLIENT)
public class SummonedEntityRenderRegistry {
    public static void register(){
        registerRenderMob(SummonedEntityRegistry.SUMMONED_BAT_ENTITY, SummonedBatRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_CAT_ENTITY, SummonedCatRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY, SummonedChickenRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_COW_ENTITY, SummonedCowRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_FOX_ENTITY, SummonedFoxRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_PIG_ENTITY, SummonedPigRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY, SummonedRabbitRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY, SummonedSheepRenderer.class);

        registerRenderMob(SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY, SummonedEndermanRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY, SummonedIronGolemRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY, SummonedLlamaRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY, SummonedSpiderRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_WOLF_ENTITY, SummonedWolfRenderer.class);

        registerRenderMob(SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY, SummonedBlazeRenderer.class);
        registerRenderMob(SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY, SummonedSkeletonRenderer.class);
    }

    private static void registerRenderMob(EntityType<?> entity, Class<? extends MobEntityRenderer<?, ?>> renderer) {
        EntityRendererRegistry.INSTANCE.register(entity, ((entityRenderDispatcher, context) -> {
            MobEntityRenderer<?, ?> render = null;
            try {
                render = renderer.getConstructor(entityRenderDispatcher.getClass()).newInstance(entityRenderDispatcher);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return render;
        }));
    }
}

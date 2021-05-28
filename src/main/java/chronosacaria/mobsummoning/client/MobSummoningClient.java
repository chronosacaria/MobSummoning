package chronosacaria.mobsummoning.client;

import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MobSummoningClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SummonedEntityRegistry.register();
        SummonedEntityRenderRegistry.register();
    }
}

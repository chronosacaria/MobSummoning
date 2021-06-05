package chronosacaria.mobsummoning;

import chronosacaria.mobsummoning.commands.SummonMobCommand;
import chronosacaria.mobsummoning.init.ItemsInit;
import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

public class MobSummoning implements ModInitializer {

    public static final String MOD_ID = "mobsummoning";

    public static Identifier ID (String path){
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ItemsInit.init();
        SummonedEntityRegistry.register();
        CommandRegistrationCallback.EVENT.register(new SummonMobCommand());
    }
}

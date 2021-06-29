package chronosacaria.mobsummoning.loottables;

import chronosacaria.mobsummoning.init.ItemsInit;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;

public class MobSummoningLootTables {
    public static void init(){
        LootTableLoadingCallback.EVENT.register((((resourceManager, manager, id, supplier, setter) -> {
            if ("minecraft:entities/bat".equals(id.toString())) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.5F))
                        .with(ItemEntry.builder(ItemsInit.BAT_WING));
                supplier.pool(poolBuilder);
            }
        })));
    }
}

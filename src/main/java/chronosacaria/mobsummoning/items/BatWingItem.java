package chronosacaria.mobsummoning.items;

import chronosacaria.mobsummoning.MobSummoning;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BatWingItem extends Item {

    public BatWingItem(Settings settings, String id) {
        super(settings);
        Registry.register(Registry.ITEM, new Identifier(MobSummoning.MOD_ID, id), this);
    }
}

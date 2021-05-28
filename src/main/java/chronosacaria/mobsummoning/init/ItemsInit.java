package chronosacaria.mobsummoning.init;

import chronosacaria.mobsummoning.items.SummoningStaffItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemsInit {

    public static Item SUMMONING_STAFF;

    public static void init(){
        SUMMONING_STAFF = new SummoningStaffItem(new Item.Settings().group(ItemGroup.COMBAT), "summoning_staff");
    }
}

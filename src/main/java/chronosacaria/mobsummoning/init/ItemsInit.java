package chronosacaria.mobsummoning.init;

import chronosacaria.mobsummoning.items.BatWingItem;
import chronosacaria.mobsummoning.items.SummoningStaffItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemsInit {

    public static Item SUMMONING_STAFF;
    public static Item BAT_WING;

    public static void init(){
        SUMMONING_STAFF = new SummoningStaffItem(new Item.Settings().group(ItemGroup.COMBAT), "summoning_staff");
        BAT_WING = new BatWingItem(new Item.Settings().group(ItemGroup.MISC), "bat_wing");
    }
}

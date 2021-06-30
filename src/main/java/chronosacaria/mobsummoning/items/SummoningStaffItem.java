package chronosacaria.mobsummoning.items;

import chronosacaria.mobsummoning.MobSummoning;
import chronosacaria.mobsummoning.helpers.SummoningHelper;
import chronosacaria.mobsummoning.init.ItemsInit;
import chronosacaria.mobsummoning.init.SummonedEntityRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;


public class SummoningStaffItem extends Item {


    public SummoningStaffItem(Settings settings, String id) {
        super(settings.maxCount(1).maxDamage(64));
        Registry.register(Registry.ITEM, new Identifier(MobSummoning.MOD_ID, id), this);
    }

    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        World world = itemUsageContext.getWorld();
        ItemStack offhandStack = itemUsageContext.getPlayer().getOffHandStack();

        if (world.isClient){
            return ActionResult.SUCCESS;
        } else {
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();

            if (itemUsageContextPlayer != null && itemUsageContextPlayer.experienceLevel >= 5 && !offhandStack.isEmpty() && offhandStack.getItem() != ItemsInit.SUMMONING_STAFF){

                // Passive Mob Summons
                if (offhandStack.getItem() == ItemsInit.BAT_WING) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.STRING){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.CHICKEN){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.BEEF){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_COW_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.SWEET_BERRIES){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_FOX_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.PORKCHOP){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_PIG_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.RABBIT_FOOT){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.MUTTON) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                }

                // Neutral Mob Summons
                else if (offhandStack.getItem() == Items.LEAD) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                }
                else if (offhandStack.getItem() == Items.COBWEB) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                }
                else if (offhandStack.getItem() == Items.BONE) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WOLF_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                }

                // Hostile Mob Summons
                else if (offhandStack.getItem() == Items.BLAZE_ROD) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                }
                else if (offhandStack.getItem() == Items.SKELETON_SKULL) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                }
                else if (offhandStack.getItem() == Items.WITHER_SKELETON_SKULL) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WITHER_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                }
                else if (offhandStack.getItem() == Items.ROTTEN_FLESH) {
                    if (itemUsageContextPlayer.getEntityWorld().getBiome(itemUsageContext.getBlockPos()).getCategory() == Biome.Category.DESERT) {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_HUSK_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(), 15);
                    } else {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ZOMBIE_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(), 15);
                    }
                }

                // Uniquely Powerful Mob Summons
                else if (offhandStack.getItem() == Items.ENDER_EYE) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                }
                else if (offhandStack.getItem() == Items.IRON_BLOCK) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                }
                else if (offhandStack.getItem() == Items.GHAST_TEAR) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_GHAST_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                }
                else if (offhandStack.getItem() == Items.MOJANG_BANNER_PATTERN) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RAVAGER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                }

                if (!itemUsageContextPlayer.isCreative()){
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer,
                            (entity) -> entity.sendToolBreakStatus(itemUsageContext.getHand()));
                    offhandStack.decrement(1);

                }
                //itemUsageContextPlayer.getItemCooldownManager().set(this, 1200); // One minute cooldown
            }
        }
        return ActionResult.CONSUME;
    }

}

package chronosacaria.mobsummoning.items;

import chronosacaria.mobsummoning.MobSummoning;
import chronosacaria.mobsummoning.configs.MobSummoningItemConfig;
import chronosacaria.mobsummoning.configs.MobSummoningSummonableConfig;
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
                if (offhandStack.getItem() == ItemsInit.BAT_WING && MobSummoningSummonableConfig.isSummonable(
                        "summoned_bat")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.STRING && MobSummoningSummonableConfig.isSummonable(
                        "summoned_cat")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.CHICKEN && MobSummoningSummonableConfig.isSummonable(
                        "summoned_chicken")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.BEEF && MobSummoningSummonableConfig.isSummonable(
                        "summoned_cow")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_COW_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.SWEET_BERRIES && MobSummoningSummonableConfig.isSummonable(
                        "summoned_fox")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_FOX_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.PORKCHOP && MobSummoningSummonableConfig.isSummonable(
                        "summoned_pig")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_PIG_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.RABBIT_FOOT && MobSummoningSummonableConfig.isSummonable(
                        "summoned_rabbit")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.MUTTON && MobSummoningSummonableConfig.isSummonable(
                        "summoned_sheep")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 5);
                    offhandStack.decrement(1);
                }

                // Neutral Mob Summons
                else if (offhandStack.getItem() == Items.LEAD && MobSummoningSummonableConfig.isSummonable(
                        "summoned_llama")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.COBWEB && MobSummoningSummonableConfig.isSummonable(
                        "summoned_spider")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.BONE && MobSummoningSummonableConfig.isSummonable(
                        "summoned_wolf")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WOLF_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 10);
                    offhandStack.decrement(1);
                }

                // Hostile Mob Summons
                else if (offhandStack.getItem() == Items.BLAZE_ROD && MobSummoningSummonableConfig.isSummonable(
                        "summoned_blaze")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.SKELETON_SKULL && MobSummoningSummonableConfig.isSummonable(
                        "summoned_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.WITHER_SKELETON_SKULL && MobSummoningSummonableConfig.isSummonable(
                        "summoned_wither_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WITHER_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 15);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.ROTTEN_FLESH && MobSummoningSummonableConfig.isSummonable(
                        "summoned_husk") && MobSummoningSummonableConfig.isSummonable(
                        "summoned_zombie")) {
                    if (itemUsageContextPlayer.getEntityWorld().getBiome(itemUsageContext.getBlockPos()).getCategory() == Biome.Category.DESERT) {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_HUSK_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(), 15);
                        offhandStack.decrement(1);
                    } else {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ZOMBIE_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(), 15);
                        offhandStack.decrement(1);
                    }
                }

                // Uniquely Powerful Mob Summons
                else if (offhandStack.getItem() == Items.ENDER_EYE && MobSummoningSummonableConfig.isSummonable(
                        "summoned_enderman")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.IRON_BLOCK && MobSummoningSummonableConfig.isSummonable(
                        "summoned_iron_golem")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == Items.GHAST_TEAR && MobSummoningSummonableConfig.isSummonable(
                        "summoned_ghast")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_GHAST_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                    offhandStack.decrement(1);
                }
                else if (offhandStack.getItem() == ItemsInit.RAVAGER_HORN && MobSummoningSummonableConfig.isSummonable(
                        "summoned_ravager")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RAVAGER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(), 20);
                    offhandStack.decrement(1);
                }

                if (!itemUsageContextPlayer.isCreative()){
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer,
                            (entity) -> entity.sendToolBreakStatus(itemUsageContext.getHand()));
                }

                itemUsageContextPlayer.getItemCooldownManager().set(this,
                        MobSummoningItemConfig.getItemCooldown("summoning_staff"));
                // cooldown
            }
        }
        return ActionResult.CONSUME;
    }

}

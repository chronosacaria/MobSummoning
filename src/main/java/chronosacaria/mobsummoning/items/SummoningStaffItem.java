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
        super(settings.maxCount(1).maxDamage(MobSummoningItemConfig.getItemDurability("summoning_staff")));
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

            if (itemUsageContextPlayer != null
                    && itemUsageContextPlayer.experienceLevel >= 5
                    && !offhandStack.isEmpty()
                    && offhandStack.getItem()
                    != ItemsInit.SUMMONING_STAFF){

                // Passive Mob Summons
                if (MobSummoningSummonableConfig.isSummonable("summoned_bat")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            ItemsInit.BAT_WING,
                            MobSummoningSummonableConfig.summonXPCost("summoned_bat"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_bat"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_cat")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.STRING,
                            MobSummoningSummonableConfig.summonXPCost("summoned_cat"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_cat"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_chicken")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.CHICKEN,
                            MobSummoningSummonableConfig.summonXPCost("summoned_chicken"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_chicken"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_cow")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_COW_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BEEF,
                            MobSummoningSummonableConfig.summonXPCost("summoned_cow"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_cow"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_fox")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_FOX_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.SWEET_BERRIES,
                            MobSummoningSummonableConfig.summonXPCost("summoned_fox"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_fox"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_pig")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_PIG_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.PORKCHOP,
                            MobSummoningSummonableConfig.summonXPCost("summoned_pig"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_pig"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_rabbit")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.RABBIT_FOOT,
                            MobSummoningSummonableConfig.summonXPCost("summoned_rabbit"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_rabbit"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_sheep")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.MUTTON,
                            MobSummoningSummonableConfig.summonXPCost("summoned_sheep"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_sheep"));
                }

                // Neutral Mob Summons
                if (MobSummoningSummonableConfig.isSummonable("summoned_llama")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.LEAD,
                            MobSummoningSummonableConfig.summonXPCost("summoned_llama"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_llama"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_spider")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.COBWEB,
                            MobSummoningSummonableConfig.summonXPCost("summoned_spider"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_spider"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_wolf")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WOLF_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BONE,
                            MobSummoningSummonableConfig.summonXPCost("summoned_wolf"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_wolf"));
                }

                // Hostile Mob Summons
                if (MobSummoningSummonableConfig.isSummonable("summoned_blaze")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BLAZE_ROD,
                            MobSummoningSummonableConfig.summonXPCost("summoned_blaze"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_blaze"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_creeper")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CREEPER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.GUNPOWDER,
                            MobSummoningSummonableConfig.summonXPCost("summoned_creeper"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_creeper"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.SKELETON_SKULL,
                            MobSummoningSummonableConfig.summonXPCost("summoned_skeleton"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_skeleton"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_wither_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WITHER_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.WITHER_SKELETON_SKULL,
                            MobSummoningSummonableConfig.summonXPCost("summoned_wither_skeleton"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_wither_skeleton"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_husk")
                        && MobSummoningSummonableConfig.isSummonable("summoned_zombie")) {
                    if (itemUsageContextPlayer.getEntityWorld().getBiome(itemUsageContext.getBlockPos()).getCategory() == Biome.Category.DESERT) {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_HUSK_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(),
                                Items.ROTTEN_FLESH,
                                MobSummoningSummonableConfig.summonXPCost("summoned_husk"),
                                MobSummoningSummonableConfig.summonItemAmountCost("summoned_husk"));
                    } else {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ZOMBIE_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(),
                                Items.ROTTEN_FLESH,
                                MobSummoningSummonableConfig.summonXPCost("summoned_zombie"),
                                MobSummoningSummonableConfig.summonItemAmountCost("summoned_zombie"));
                    }
                }

                // Uniquely Powerful Mob Summons
                if (MobSummoningSummonableConfig.isSummonable("summoned_enderman")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.ENDER_PEARL,
                            MobSummoningSummonableConfig.summonXPCost("summoned_enderman"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_enderman"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_iron_golem")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.IRON_BLOCK,
                            MobSummoningSummonableConfig.summonXPCost("summoned_iron_golem"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_iron_golem"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_ghast")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_GHAST_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.GHAST_TEAR,
                            MobSummoningSummonableConfig.summonXPCost("summoned_ghast"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_ghast"));
                }
                if (MobSummoningSummonableConfig.isSummonable("summoned_ravager")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RAVAGER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            ItemsInit.RAVAGER_HORN,
                            MobSummoningSummonableConfig.summonXPCost("summoned_ravager"),
                            MobSummoningSummonableConfig.summonItemAmountCost("summoned_ravager"));
                }

                if (!itemUsageContextPlayer.isCreative()){
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer,
                            (entity) -> entity.sendToolBreakStatus(itemUsageContext.getHand()));
                }

                //itemUsageContextPlayer.getItemCooldownManager().set(this,
                //        MobSummoningItemConfig.getItemCooldown("summoning_staff"));
                // cooldown
            }
        }
        return ActionResult.CONSUME;
    }

}

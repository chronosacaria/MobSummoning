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

import static chronosacaria.mobsummoning.configs.MobSummoningSummonableConfig.*;


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
                if (isSummonable("summoned_bat")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            ItemsInit.BAT_WING,
                            summonXPCost("summoned_bat"),
                            summonItemAmountCost("summoned_bat"));
                }
                if (isSummonable("summoned_cat")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CAT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.STRING,
                            summonXPCost("summoned_cat"),
                            summonItemAmountCost("summoned_cat"));
                }
                if (isSummonable("summoned_chicken")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CHICKEN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.CHICKEN,
                            summonXPCost("summoned_chicken"),
                            summonItemAmountCost("summoned_chicken"));
                }
                if (isSummonable("summoned_cow")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_COW_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BEEF,
                            summonXPCost("summoned_cow"),
                            summonItemAmountCost("summoned_cow"));
                }
                if (isSummonable("summoned_fox")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_FOX_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.SWEET_BERRIES,
                            summonXPCost("summoned_fox"),
                            summonItemAmountCost("summoned_fox"));
                }
                if (isSummonable("summoned_pig")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_PIG_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.PORKCHOP,
                            summonXPCost("summoned_pig"),
                            summonItemAmountCost("summoned_pig"));
                }
                if (isSummonable("summoned_rabbit")){
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RABBIT_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.RABBIT_FOOT,
                            summonXPCost("summoned_rabbit"),
                            summonItemAmountCost("summoned_rabbit"));
                }
                if (isSummonable("summoned_sheep")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SHEEP_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.MUTTON,
                            summonXPCost("summoned_sheep"),
                            summonItemAmountCost("summoned_sheep"));
                }

                // Neutral Mob Summons
                if (isSummonable("summoned_llama")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_LLAMA_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.LEAD,
                            summonXPCost("summoned_llama"),
                            summonItemAmountCost("summoned_llama"));
                }
                if (isSummonable("summoned_spider")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SPIDER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.COBWEB,
                            summonXPCost("summoned_spider"),
                            summonItemAmountCost("summoned_spider"));
                }
                if (isSummonable("summoned_wolf")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WOLF_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BONE,
                            summonXPCost("summoned_wolf"),
                            summonItemAmountCost("summoned_wolf"));
                }

                // Hostile Mob Summons
                if (isSummonable("summoned_blaze")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_BLAZE_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.BLAZE_ROD,
                            summonXPCost("summoned_blaze"),
                            summonItemAmountCost("summoned_blaze"));
                }
                if (isSummonable("summoned_creeper")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_CREEPER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.GUNPOWDER,
                            summonXPCost("summoned_creeper"),
                            summonItemAmountCost("summoned_creeper"));
                }
                if (isSummonable("summoned_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.SKELETON_SKULL,
                            summonXPCost("summoned_skeleton"),
                            summonItemAmountCost("summoned_skeleton"));
                }
                if (isSummonable("summoned_wither_skeleton")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_WITHER_SKELETON_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.WITHER_SKELETON_SKULL,
                            summonXPCost("summoned_wither_skeleton"),
                            summonItemAmountCost("summoned_wither_skeleton"));
                }
                if (isSummonable("summoned_husk")
                        && isSummonable("summoned_zombie")) {
                    if (itemUsageContextPlayer.getEntityWorld().getBiome(itemUsageContext.getBlockPos()).getCategory() == Biome.Category.DESERT) {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_HUSK_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(),
                                Items.ROTTEN_FLESH,
                                summonXPCost("summoned_husk"),
                                summonItemAmountCost("summoned_husk"));
                    } else {
                        SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ZOMBIE_ENTITY.create(world),
                                itemUsageContextPlayer,
                                itemUsageContext.getBlockPos(),
                                Items.ROTTEN_FLESH,
                                summonXPCost("summoned_zombie"),
                                summonItemAmountCost("summoned_zombie"));
                    }
                }

                // Uniquely Powerful Mob Summons
                if (isSummonable("summoned_enderman")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_ENDERMAN_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.ENDER_PEARL,
                            summonXPCost("summoned_enderman"),
                            summonItemAmountCost("summoned_enderman"));
                }
                if (isSummonable("summoned_iron_golem")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_IRON_GOLEM_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.IRON_BLOCK,
                            summonXPCost("summoned_iron_golem"),
                            summonItemAmountCost("summoned_iron_golem"));
                }
                if (isSummonable("summoned_ghast")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_GHAST_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            Items.GHAST_TEAR,
                            summonXPCost("summoned_ghast"),
                            summonItemAmountCost("summoned_ghast"));
                }
                if (isSummonable("summoned_ravager")) {
                    SummoningHelper.summonMob(SummonedEntityRegistry.SUMMONED_RAVAGER_ENTITY.create(world),
                            itemUsageContextPlayer,
                            itemUsageContext.getBlockPos(),
                            ItemsInit.RAVAGER_HORN,
                            summonXPCost("summoned_ravager"),
                            summonItemAmountCost("summoned_ravager"));
                }
            }
        }
        return ActionResult.CONSUME;
    }

}

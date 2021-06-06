package chronosacaria.mobsummoning.items;

import chronosacaria.mobsummoning.MobSummoning;
import chronosacaria.mobsummoning.helpers.SummoningHelper;
import chronosacaria.mobsummoning.init.ItemsInit;
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
                /*if (offhandStack.getItem() == Items.ARROW) {
                   SummoningHelper.summonBat(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else*/if (offhandStack.getItem() == Items.STRING){
                    SummoningHelper.summonCat(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.CHICKEN){
                    SummoningHelper.summonChicken(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.BEEF){
                    SummoningHelper.summonCow(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.SWEET_BERRIES){
                    SummoningHelper.summonFox(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.PORKCHOP){
                    SummoningHelper.summonPig(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.RABBIT_FOOT){
                    SummoningHelper.summonRabbit(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }
                else if (offhandStack.getItem() == Items.MUTTON) {
                    SummoningHelper.summonSheep(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 5);
                }

                // Neutral Mob Summons
                else if (offhandStack.getItem() == Items.LEAD) {
                    SummoningHelper.summonLlama(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 10);
                }
                else if (offhandStack.getItem() == Items.COBWEB) {
                    SummoningHelper.summonSpider(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 10);
                }
                else if (offhandStack.getItem() == Items.BONE) {
                    SummoningHelper.summonWolf(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 10);
                }

                // Hostile Mob Summons
                else if (offhandStack.getItem() == Items.BLAZE_ROD) {
                    SummoningHelper.summonBlaze(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 15);
                }
                else if (offhandStack.getItem() == Items.BOW) {
                    SummoningHelper.summonSkeleton(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 15);
                }
                else if (offhandStack.getItem() == Items.ROTTEN_FLESH) {
                    SummoningHelper.summonZombie(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 15);
                }

                // Uniquely Powerful Mob Summons
                else if (offhandStack.getItem() == Items.ENDER_PEARL) {
                    SummoningHelper.summonEnderman(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 20);
                }
                else if (offhandStack.getItem() == Items.IRON_BLOCK) {
                    SummoningHelper.summonIronGolem(itemUsageContextPlayer, itemUsageContext.getBlockPos(), 20);
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

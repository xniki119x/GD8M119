package f1cont.niki119.gd8m119.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static f1cont.niki119.gd8m119.common.utils.ModItemGroup.ITEM_GROUP;

public class HeartItem extends BaseItem {
    public HeartItem() {
        this("heart");
    }
    public HeartItem(String id) {
        super(id, new Properties().group(ITEM_GROUP).rarity(Rarity.EPIC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(worldIn.isRemote) {
            if (stack.getItem() instanceof HeartItem) {
                CompoundNBT nbt = stack.getOrCreateTag();
                if (nbt.getString("owner").equals("")) {
                    nbt.putString("owner", playerIn.getDisplayName().getString());
                    stack.setTag(nbt);
                    playerIn.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1,1);
                    return ActionResult.resultConsume(stack);
                }
            }
        }
        return ActionResult.resultPass(stack);
    }

    public String getOwner(ItemStack stack){
        CompoundNBT nbt = stack.getTag();
        if(nbt != null) return nbt.getString("owner");
        return "";
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        String o = getOwner(stack);
        if(!o.equals("")) tooltip.add(new TranslationTextComponent("from %s",o).mergeStyle(TextFormatting.DARK_PURPLE));
    }
}

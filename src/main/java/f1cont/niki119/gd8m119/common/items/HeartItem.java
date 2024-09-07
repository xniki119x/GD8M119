package f1cont.niki119.gd8m119.common.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static f1cont.niki119.gd8m119.common.utils.ModItemGroup.ITEM_GROUP;
import static net.minecraft.ChatFormatting.DARK_PURPLE;

public class HeartItem extends BaseItem {
    public HeartItem() {
        this("heart");
    }
    public HeartItem(String id) {
        super(id, new Properties().tab(ITEM_GROUP).rarity(Rarity.EPIC));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!level.isClientSide) {
            if (stack.getItem() instanceof HeartItem) {
                CompoundTag nbt = stack.getOrCreateTag();
                if (nbt.getString("owner").equals("")) {
                    nbt.putString("owner", player.getDisplayName().getString());
                    stack.setTag(nbt);
                    player.playSound(SoundEvents.CHICKEN_EGG, 1,1);
                    return InteractionResultHolder.consume(stack);
                }
            }
        }
        return InteractionResultHolder.pass(stack);
    }
    public String getOwner(ItemStack stack){
        CompoundTag nbt = stack.getTag();
        if(nbt != null) return nbt.getString("owner");
        return "";
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        String o = getOwner(stack);
        if(!o.equals("")) tooltip.add(new TranslatableComponent("from %s",o).withStyle(DARK_PURPLE));
    }
}

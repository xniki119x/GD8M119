package f1cont.niki119.gd8m119.common.utils;

import f1cont.niki119.gd8m119.common.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup extends CreativeModeTab {
    public static ModItemGroup ITEM_GROUP = new ModItemGroup();
    public ModItemGroup() {
        super("gd8m119");
    }
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.HEART_ITEM);
    }
}

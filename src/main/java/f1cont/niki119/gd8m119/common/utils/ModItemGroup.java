package f1cont.niki119.gd8m119.common.utils;

import f1cont.niki119.gd8m119.common.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup {
    public static ModItemGroup ITEM_GROUP = new ModItemGroup();
    public ModItemGroup() {
        super("gd8m119");
    }
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.HEART_ITEM);
    }
}

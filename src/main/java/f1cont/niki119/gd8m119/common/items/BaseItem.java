package f1cont.niki119.gd8m119.common.items;

import f1cont.niki119.gd8m119.GD8M119;
import net.minecraft.item.Item;

public class BaseItem extends Item {
    public BaseItem(String id, Properties properties) {
        super(properties);
        setRegistryName(GD8M119.prefix(id));
    }
}

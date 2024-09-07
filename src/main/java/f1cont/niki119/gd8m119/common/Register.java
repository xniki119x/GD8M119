package f1cont.niki119.gd8m119.common;

import f1cont.niki119.gd8m119.GD8M119;
import f1cont.niki119.gd8m119.common.items.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GD8M119.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Register {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(ModItems.HEART_ITEM);
        event.getRegistry().register(ModItems.HEART_SMALL_ITEM);
    }
}

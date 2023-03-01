package f1cont.niki119.gd8m119;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import static f1cont.niki119.gd8m119.GD8M119.MODID;
@Mod(MODID)
public class GD8M119 {
    public static final String MODID = "gd8m119";
    public static ResourceLocation prefix(String name){
        return new ResourceLocation(MODID, name);
    }
}
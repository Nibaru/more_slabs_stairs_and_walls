package games.twinhead;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreBuildingBlocks.mod_id)
public class MoreBuildingBlocks {
    public static final String mod_id="more_slabs_stairs_and_walls";


    public MoreBuildingBlocks() {
        // Register ourselves for server and other game events we are interested in
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registry.RegisterAllBlocks();

        Registry.BLOCKS.register(eventBus);
        Registry.registerItems(eventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }


}

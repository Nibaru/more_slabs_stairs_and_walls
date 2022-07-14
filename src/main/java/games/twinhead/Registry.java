package games.twinhead;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registry {
    public static final String[] colorNames = new String[]{"white", "yellow", "black", "red", "purple", "pink", "orange", "magenta", "lime", "light_gray", "light_blue", "green", "gray", "cyan", "brown", "blue"};

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreBuildingBlocks.mod_id);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBuildingBlocks.mod_id);

    public static final RegistryObject<Block> OBSIDIAN_STAIRS = BLOCKS.register( "obsidian_stairs", () -> new StairBlock(Blocks.OBSIDIAN::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final RegistryObject<Block> OBSIDIAN_WALL = BLOCKS.register( "obsidian_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final RegistryObject<Block> OBSIDIAN_SLAB = BLOCKS.register( "obsidian_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));


    public static void RegisterAllBlocks(){
        addRegisterColor("concrete");
        addRegisterColor("terracotta");
        addRegisterColor("wool");
        registerAll("moss", Blocks.MOSS_BLOCK);
        registerAll("calcite", Blocks.CALCITE);
        registerAll("terracotta", Blocks.TERRACOTTA);
        registerAll("glowstone", Blocks.GLOWSTONE, BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(l -> 15));
        registerAll("cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS);
        BLOCKS.register( "basalt_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)));
        BLOCKS.register( "basalt_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)));
        registerAll("tuff", Blocks.TUFF);
        registerAll("dripstone_block", Blocks.DRIPSTONE_BLOCK);
        registerAll("sea_lantern", Blocks.SEA_LANTERN, BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN).lightLevel(l -> 15));
        registerAll("shroomlight", Blocks.SHROOMLIGHT, BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT).lightLevel(l -> 15));
        registerAll("end_stone", Blocks.END_STONE);

        registerAll("oak_wood", Blocks.OAK_WOOD);
        registerAll("birch_wood", Blocks.BIRCH_WOOD);
        registerAll("spruce_wood", Blocks.SPRUCE_WOOD);
        registerAll("jungle_wood", Blocks.JUNGLE_WOOD);
        registerAll("dark_oak_wood", Blocks.DARK_OAK_WOOD);
        registerAll("acacia_wood", Blocks.ACACIA_WOOD);
        registerAll("crimson_hyphae", Blocks.CRIMSON_HYPHAE);
        registerAll("warped_hyphae", Blocks.WARPED_HYPHAE);

        registerAll("stripped_oak_wood", Blocks.OAK_WOOD);
        registerAll("stripped_birch_wood", Blocks.BIRCH_WOOD);
        registerAll("stripped_spruce_wood", Blocks.SPRUCE_WOOD);
        registerAll("stripped_jungle_wood", Blocks.JUNGLE_WOOD);
        registerAll("stripped_dark_oak_wood", Blocks.DARK_OAK_WOOD);
        registerAll("stripped_acacia_wood", Blocks.ACACIA_WOOD);
        registerAll("stripped_crimson_hyphae", Blocks.CRIMSON_HYPHAE);
        registerAll("stripped_warped_hyphae", Blocks.WARPED_HYPHAE);

        BLOCKS.register("cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.CUT_COPPER)));
        BLOCKS.register("exposed_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_CUT_COPPER)));
        BLOCKS.register("weathered_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)));
        BLOCKS.register("oxidized_cut_copper_wall", () -> new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_CUT_COPPER)));

        BLOCKS.register("smooth_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)));
        BLOCKS.register("smooth_red_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_RED_SANDSTONE)));
        BLOCKS.register( "dark_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DARK_PRISMARINE)));
        BLOCKS.register( "prismarine_bricks_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)));
        BLOCKS.register( "stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
        BLOCKS.register( "smooth_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
        BLOCKS.register( "smooth_stone_stairs", () -> new StairBlock(Blocks.SMOOTH_STONE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));

    }


    public static void addRegisterColor(String blockName){
        for (String color: colorNames) {
            Block copyBlock = switch (blockName){
                case "concrete" -> Blocks.BLACK_CONCRETE;
                case "wool" -> Blocks.BLACK_WOOL;
                case "terracotta" -> Blocks.TERRACOTTA;
                default -> Blocks.DIRT;
            };
            registerAll(color + "_" + blockName, copyBlock);
        }
    }

    public static void registerAll(String name, Block block){
        BLOCKS.register(name + "_stairs", () -> new StairBlock(block::defaultBlockState, BlockBehaviour.Properties.copy(block)));
        BLOCKS.register(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(block)));
        BLOCKS.register(name + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(block)));
    }

    public static void registerAll(String name, Block block, BlockBehaviour.Properties properties){
        BLOCKS.register(name+ "_stairs", () -> new StairBlock(block::defaultBlockState, properties));
        BLOCKS.register(name+ "_wall", () -> new WallBlock(properties));
        BLOCKS.register(name+ "_slab", () -> new SlabBlock(properties));
    }

    public static void registerItems(IEventBus eventBus){
        for (RegistryObject<Block> block: BLOCKS.getEntries()) {
            ITEMS.register(block.getId().getPath(), ()-> new BlockItem(block.get(), new Item.Properties().tab((CreativeModeTab.TAB_BUILDING_BLOCKS))));
        }
        ITEMS.register(eventBus);
    }
}

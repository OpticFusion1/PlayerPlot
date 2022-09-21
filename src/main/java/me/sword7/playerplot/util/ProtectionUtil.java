package me.sword7.playerplot.util;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class ProtectionUtil {

    public static boolean isProtectedInteraction(Material handMaterial, Material blockMaterial) {
        return INTERACTABLE_MATERIALS.contains(blockMaterial)
                || isStripLogAttempt(handMaterial, blockMaterial)
                || isPlaceableItem(handMaterial)
                || isUsableItem(handMaterial);
    }

    public static boolean isInteractableAtEntity(EntityType entityType) {
        return INTERACTABLE_AT_ENTITIES.contains(entityType);
    }

    private static ImmutableSet<EntityType> INTERACTABLE_AT_ENTITIES = ImmutableSet.<EntityType>builder()
            .add(EntityType.ARMOR_STAND)
            .build();

    public static boolean isInteractableEntity(EntityType entityType) {
        return INTERACTABLE_ENTITIES.contains(entityType);
    }

    private static final ImmutableSet<EntityType> INTERACTABLE_ENTITIES = ImmutableSet.<EntityType>builder()
            .add(EntityType.ITEM_FRAME)
            .add(EntityType.VILLAGER)
            .add(EntityType.LEASH_HITCH)
            .add(EntityType.MINECART_HOPPER)
            .add(EntityType.MINECART_COMMAND)
            .add(EntityType.MINECART_CHEST)
            .add(EntityType.MINECART_FURNACE)
            .add(EntityType.MINECART_MOB_SPAWNER)
            .build();

    private static boolean isPlaceableItem(Material handItem) {
        return PLACEABLE_ITEMS.contains(handItem);
    }

    private static final ImmutableSet<Material> PLACEABLE_ITEMS = ImmutableSet.<Material>builder()
            .add(Material.ITEM_FRAME)
            .add(Material.PAINTING)
            .build();

    private static boolean isUsableItem(Material handItem) {
        return USABLE_ITEMS.contains(handItem);
    }

    private static ImmutableSet<Material> USABLE_ITEMS = ImmutableSet.<Material>builder()
            .add(Material.WATER_BUCKET)
            .add(Material.LAVA_BUCKET)
            .add(Material.FLINT_AND_STEEL)
            .add(Material.BONE_MEAL)
            .build();

    private static final Set<Material> INTERACTABLE_MATERIALS = buildInteractableMaterials();

    private static Set<Material> buildInteractableMaterials() {
        Set<Material> xMaterials = new HashSet<>();

        xMaterials.add(Material.DAYLIGHT_DETECTOR);
        xMaterials.add(Material.CAULDRON);
        xMaterials.add(Material.TRAPPED_CHEST);
        xMaterials.add(Material.SPAWNER);
        xMaterials.add(Material.ITEM_FRAME);
        xMaterials.add(Material.LEVER);
        xMaterials.add(Material.HOPPER);
        xMaterials.add(Material.CHEST);
        xMaterials.add(Material.BREWING_STAND);
        xMaterials.add(Material.FURNACE);
        xMaterials.add(Material.COMPARATOR);
        xMaterials.add(Material.NOTE_BLOCK);
        xMaterials.add(Material.ANVIL);
        xMaterials.add(Material.CHIPPED_ANVIL);
        xMaterials.add(Material.DAMAGED_ANVIL);
        xMaterials.add(Material.COMMAND_BLOCK);
        xMaterials.add(Material.BEACON);
        xMaterials.add(Material.DISPENSER);
        xMaterials.add(Material.DROPPER);

        xMaterials.add(Material.OAK_FENCE_GATE);
        xMaterials.add(Material.SPRUCE_FENCE_GATE);
        xMaterials.add(Material.BIRCH_FENCE_GATE);
        xMaterials.add(Material.JUNGLE_FENCE_GATE);
        xMaterials.add(Material.ACACIA_FENCE_GATE);
        xMaterials.add(Material.DARK_OAK_FENCE_GATE);
        xMaterials.add(Material.WARPED_FENCE_GATE);
        xMaterials.add(Material.CRIMSON_FENCE_GATE);

        xMaterials.add(Material.OAK_TRAPDOOR);
        xMaterials.add(Material.SPRUCE_TRAPDOOR);
        xMaterials.add(Material.BIRCH_TRAPDOOR);
        xMaterials.add(Material.JUNGLE_TRAPDOOR);
        xMaterials.add(Material.ACACIA_TRAPDOOR);
        xMaterials.add(Material.DARK_OAK_TRAPDOOR);
        xMaterials.add(Material.WARPED_TRAPDOOR);
        xMaterials.add(Material.CRIMSON_TRAPDOOR);

        xMaterials.add(Material.OAK_DOOR);
        xMaterials.add(Material.SPRUCE_DOOR);
        xMaterials.add(Material.BIRCH_DOOR);
        xMaterials.add(Material.JUNGLE_DOOR);
        xMaterials.add(Material.ACACIA_DOOR);
        xMaterials.add(Material.DARK_OAK_DOOR);
        xMaterials.add(Material.WARPED_DOOR);
        xMaterials.add(Material.CRIMSON_DOOR);

        xMaterials.add(Material.SHULKER_BOX);
        xMaterials.add(Material.WHITE_SHULKER_BOX);
        xMaterials.add(Material.ORANGE_SHULKER_BOX);
        xMaterials.add(Material.MAGENTA_SHULKER_BOX);
        xMaterials.add(Material.LIGHT_BLUE_SHULKER_BOX);
        xMaterials.add(Material.YELLOW_SHULKER_BOX);
        xMaterials.add(Material.LIME_SHULKER_BOX);
        xMaterials.add(Material.PINK_SHULKER_BOX);
        xMaterials.add(Material.GRAY_SHULKER_BOX);
        xMaterials.add(Material.LIGHT_GRAY_SHULKER_BOX);
        xMaterials.add(Material.CYAN_SHULKER_BOX);
        xMaterials.add(Material.PURPLE_SHULKER_BOX);
        xMaterials.add(Material.BLUE_SHULKER_BOX);
        xMaterials.add(Material.BROWN_SHULKER_BOX);
        xMaterials.add(Material.GREEN_SHULKER_BOX);
        xMaterials.add(Material.RED_SHULKER_BOX);
        xMaterials.add(Material.BLACK_SHULKER_BOX);

        xMaterials.add(Material.BLAST_FURNACE);
        xMaterials.add(Material.SMOKER);
        xMaterials.add(Material.LOOM);
        xMaterials.add(Material.BARREL);
        xMaterials.add(Material.BLAST_FURNACE);
        xMaterials.add(Material.BEE_NEST);

        xMaterials.add(Material.WHITE_BED);
        xMaterials.add(Material.ORANGE_BED);
        xMaterials.add(Material.MAGENTA_BED);
        xMaterials.add(Material.LIGHT_BLUE_BED);
        xMaterials.add(Material.YELLOW_BED);
        xMaterials.add(Material.LIME_BED);
        xMaterials.add(Material.PINK_BED);
        xMaterials.add(Material.GRAY_BED);
        xMaterials.add(Material.LIGHT_GRAY_BED);
        xMaterials.add(Material.CYAN_BED);
        xMaterials.add(Material.PURPLE_BED);
        xMaterials.add(Material.BLUE_BED);
        xMaterials.add(Material.BROWN_BED);
        xMaterials.add(Material.GREEN_BED);
        xMaterials.add(Material.RED_BED);
        xMaterials.add(Material.BLACK_BED);

        xMaterials.add(Material.OAK_BUTTON);
        xMaterials.add(Material.SPRUCE_BUTTON);
        xMaterials.add(Material.BIRCH_BUTTON);
        xMaterials.add(Material.JUNGLE_BUTTON);
        xMaterials.add(Material.ACACIA_BUTTON);
        xMaterials.add(Material.DARK_OAK_BUTTON);
        xMaterials.add(Material.WARPED_BUTTON);
        xMaterials.add(Material.CRIMSON_BUTTON);

        Set<Material> interactableMaterials = new HashSet<>();
        for (Material xMaterial : xMaterials) {
            interactableMaterials.add(xMaterial);
        }
        return interactableMaterials;
    }

    private static boolean isStripLogAttempt(Material handMaterial, Material blockMaterial) {
        return AXE_ITEMS.contains(handMaterial) && LOG_MATERIALS.contains(blockMaterial);
    }

    private static final Set<Material> LOG_MATERIALS = buildLogMaterials();

    private static Set<Material> buildLogMaterials() {
        Set<Material> xMaterials = new HashSet<>();

        xMaterials.add(Material.OAK_WOOD);
        xMaterials.add(Material.SPRUCE_WOOD);
        xMaterials.add(Material.BIRCH_WOOD);
        xMaterials.add(Material.JUNGLE_WOOD);
        xMaterials.add(Material.ACACIA_WOOD);
        xMaterials.add(Material.DARK_OAK_WOOD);
        xMaterials.add(Material.WARPED_HYPHAE);
        xMaterials.add(Material.CRIMSON_HYPHAE);

        xMaterials.add(Material.OAK_LOG);
        xMaterials.add(Material.SPRUCE_LOG);
        xMaterials.add(Material.BIRCH_LOG);
        xMaterials.add(Material.JUNGLE_LOG);
        xMaterials.add(Material.ACACIA_LOG);
        xMaterials.add(Material.DARK_OAK_LOG);
        xMaterials.add(Material.WARPED_STEM);
        xMaterials.add(Material.CRIMSON_STEM);

        Set<Material> logMaterials = new HashSet<>();
        for (Material xMaterial : xMaterials) {
            logMaterials.add(xMaterial);
        }
        return logMaterials;
    }

    private static final Set<Material> AXE_ITEMS = buildAxeItems();

    private static Set<Material> buildAxeItems() {
        Set<Material> xMaterials = new HashSet<>();

        xMaterials.add(Material.WOODEN_AXE);
        xMaterials.add(Material.STONE_AXE);
        xMaterials.add(Material.IRON_AXE);
        xMaterials.add(Material.GOLDEN_AXE);
        xMaterials.add(Material.DIAMOND_AXE);
        xMaterials.add(Material.NETHERITE_AXE);

        Set<Material> axeItems = new HashSet<>();
        for (Material xMaterial : xMaterials) {
            axeItems.add(xMaterial);
        }
        return axeItems;
    }

    public static boolean isMonster(Entity entity) {
        return MONSTER_MOBS.contains(entity.getType());
    }

    private static final Set<EntityType> MONSTER_MOBS = buildMonstersMobs();

    private static Set<EntityType> buildMonstersMobs() {
        Set<EntityType> xEntityTypes = new HashSet<>();
        xEntityTypes.add(EntityType.BLAZE);
        xEntityTypes.add(EntityType.CAVE_SPIDER);
        xEntityTypes.add(EntityType.CREEPER);
        xEntityTypes.add(EntityType.DRAGON_FIREBALL);
        xEntityTypes.add(EntityType.DROWNED);
        xEntityTypes.add(EntityType.EGG);
        xEntityTypes.add(EntityType.ELDER_GUARDIAN);
        xEntityTypes.add(EntityType.ENDER_DRAGON);
        xEntityTypes.add(EntityType.ENDERMAN);
        xEntityTypes.add(EntityType.ENDERMITE);
        xEntityTypes.add(EntityType.EVOKER);
        xEntityTypes.add(EntityType.EVOKER_FANGS);
        xEntityTypes.add(EntityType.FIREBALL);
        xEntityTypes.add(EntityType.GHAST);
        xEntityTypes.add(EntityType.GIANT);
        xEntityTypes.add(EntityType.GUARDIAN);
        xEntityTypes.add(EntityType.HOGLIN);
        xEntityTypes.add(EntityType.HUSK);
        xEntityTypes.add(EntityType.ILLUSIONER);
        xEntityTypes.add(EntityType.LLAMA_SPIT);
        xEntityTypes.add(EntityType.MAGMA_CUBE);
        xEntityTypes.add(EntityType.PHANTOM);
        xEntityTypes.add(EntityType.PIGLIN);
        xEntityTypes.add(EntityType.PIGLIN_BRUTE);
        xEntityTypes.add(EntityType.PILLAGER);
        xEntityTypes.add(EntityType.RAVAGER);
        xEntityTypes.add(EntityType.SHULKER);
        xEntityTypes.add(EntityType.SHULKER_BULLET);
        xEntityTypes.add(EntityType.SILVERFISH);
        xEntityTypes.add(EntityType.SKELETON);
        xEntityTypes.add(EntityType.SLIME);
        xEntityTypes.add(EntityType.SMALL_FIREBALL);
        xEntityTypes.add(EntityType.SNOWBALL);
        xEntityTypes.add(EntityType.SLIME);
        xEntityTypes.add(EntityType.SPIDER);
        xEntityTypes.add(EntityType.STRAY);
        xEntityTypes.add(EntityType.UNKNOWN);
        xEntityTypes.add(EntityType.VEX);
        xEntityTypes.add(EntityType.VINDICATOR);
        xEntityTypes.add(EntityType.WITCH);
        xEntityTypes.add(EntityType.WITHER);
        xEntityTypes.add(EntityType.WITHER_SKELETON);
        xEntityTypes.add(EntityType.WITHER_SKULL);
        xEntityTypes.add(EntityType.ZOGLIN);
        xEntityTypes.add(EntityType.ZOMBIE);
        xEntityTypes.add(EntityType.ZOMBIE_VILLAGER);
        xEntityTypes.add(EntityType.ZOMBIFIED_PIGLIN);

        Set<EntityType> monsters = new HashSet<>();
        for (EntityType entityType : xEntityTypes) {
            monsters.add(entityType);
        }

        return monsters;
    }

    public static boolean isFighting(Entity entity) {
        return entity instanceof Creature
                && AGGROABLE_MOBS.contains(entity.getType())
                && ((Creature) entity).getTarget() instanceof Player;
    }

    private static final Set<EntityType> AGGROABLE_MOBS = buildAggroableMobs();

    private static Set<EntityType> buildAggroableMobs() {
        Set<EntityType> xEntityTypes = new HashSet<>();
        xEntityTypes.add(EntityType.BEE);
        xEntityTypes.add(EntityType.CAT);
        xEntityTypes.add(EntityType.DOLPHIN);
        xEntityTypes.add(EntityType.FOX);
        xEntityTypes.add(EntityType.IRON_GOLEM);
        xEntityTypes.add(EntityType.LLAMA);
        xEntityTypes.add(EntityType.OCELOT);
        xEntityTypes.add(EntityType.PANDA);
        xEntityTypes.add(EntityType.POLAR_BEAR);
        xEntityTypes.add(EntityType.PUFFERFISH);
        xEntityTypes.add(EntityType.SNOWMAN);
        xEntityTypes.add(EntityType.WOLF);

        Set<EntityType> monsters = new HashSet<>();
        for (EntityType entityType : xEntityTypes) {
            monsters.add(entityType);
        }

        return monsters;
    }

    public static boolean isSmallBlock(Material material) {
        return SMALL_MATERIALS.contains(material);
    }

    private static final Set<Material> SMALL_MATERIALS = buildSmallMaterials();

    private static Set<Material> buildSmallMaterials() {
        Set<Material> xMaterials = new HashSet<>();
        xMaterials.add(Material.RAIL);
        xMaterials.add(Material.ACTIVATOR_RAIL);
        xMaterials.add(Material.DETECTOR_RAIL);
        xMaterials.add(Material.POWERED_RAIL);
        xMaterials.add(Material.STONE_PRESSURE_PLATE);
        xMaterials.add(Material.OAK_PRESSURE_PLATE);
        xMaterials.add(Material.SPRUCE_PRESSURE_PLATE);
        xMaterials.add(Material.BIRCH_PRESSURE_PLATE);
        xMaterials.add(Material.JUNGLE_PRESSURE_PLATE);
        xMaterials.add(Material.ACACIA_PRESSURE_PLATE);
        xMaterials.add(Material.DARK_OAK_PRESSURE_PLATE);
        xMaterials.add(Material.CRIMSON_PRESSURE_PLATE);
        xMaterials.add(Material.WARPED_PRESSURE_PLATE);
        xMaterials.add(Material.POLISHED_BLACKSTONE_PRESSURE_PLATE);
        xMaterials.add(Material.SNOW);
        xMaterials.add(Material.OAK_TRAPDOOR);
        xMaterials.add(Material.SPRUCE_TRAPDOOR);
        xMaterials.add(Material.BIRCH_TRAPDOOR);
        xMaterials.add(Material.JUNGLE_TRAPDOOR);
        xMaterials.add(Material.ACACIA_TRAPDOOR);
        xMaterials.add(Material.DARK_OAK_TRAPDOOR);
        xMaterials.add(Material.CRIMSON_TRAPDOOR);
        xMaterials.add(Material.WARPED_TRAPDOOR);
        xMaterials.add(Material.LILY_PAD);
        xMaterials.add(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
        xMaterials.add(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        xMaterials.add(Material.IRON_TRAPDOOR);
        xMaterials.add(Material.WHITE_CARPET);
        xMaterials.add(Material.ORANGE_CARPET);
        xMaterials.add(Material.MAGENTA_CARPET);
        xMaterials.add(Material.LIGHT_BLUE_CARPET);
        xMaterials.add(Material.YELLOW_CARPET);
        xMaterials.add(Material.LIME_CARPET);
        xMaterials.add(Material.PINK_CARPET);
        xMaterials.add(Material.GRAY_CARPET);
        xMaterials.add(Material.LIGHT_GRAY_CARPET);
        xMaterials.add(Material.CYAN_CARPET);
        xMaterials.add(Material.PURPLE_CARPET);
        xMaterials.add(Material.BLUE_CARPET);
        xMaterials.add(Material.BROWN_CARPET);
        xMaterials.add(Material.GREEN_CARPET);
        xMaterials.add(Material.RED_CARPET);
        xMaterials.add(Material.BLACK_CARPET);
        xMaterials.add(Material.NETHER_SPROUTS);
        xMaterials.add(Material.STRING);

        Set<Material> smallMaterials = new HashSet<>();
        for (Material xMaterial : xMaterials) {
            smallMaterials.add(xMaterial);
        }

        return smallMaterials;
    }

    public static boolean isMediumBlock(Material material) {
        return MEDIUM_MATERIALS.contains(material);
    }

    private static final Set<Material> MEDIUM_MATERIALS = buildMediumMaterials();

    private static Set<Material> buildMediumMaterials() {
        Set<Material> xMaterials = new HashSet<>();
        xMaterials.add(Material.OAK_SLAB);
        xMaterials.add(Material.SPRUCE_SLAB);
        xMaterials.add(Material.BIRCH_SLAB);
        xMaterials.add(Material.JUNGLE_SLAB);
        xMaterials.add(Material.ACACIA_SLAB);
        xMaterials.add(Material.DARK_OAK_SLAB);
        xMaterials.add(Material.CRIMSON_SLAB);
        xMaterials.add(Material.WARPED_SLAB);
        xMaterials.add(Material.STONE_SLAB);
        xMaterials.add(Material.SMOOTH_STONE_SLAB);
        xMaterials.add(Material.SANDSTONE_SLAB);
        xMaterials.add(Material.CUT_SANDSTONE_SLAB);
        xMaterials.add(Material.PETRIFIED_OAK_SLAB);
        xMaterials.add(Material.COBBLESTONE_SLAB);
        xMaterials.add(Material.BRICK_SLAB);
        xMaterials.add(Material.STONE_BRICK_SLAB);
        xMaterials.add(Material.NETHER_BRICK_SLAB);
        xMaterials.add(Material.QUARTZ_SLAB);
        xMaterials.add(Material.RED_SANDSTONE_SLAB);
        xMaterials.add(Material.CUT_RED_SANDSTONE_SLAB);
        xMaterials.add(Material.PURPUR_SLAB);
        xMaterials.add(Material.PRISMARINE_SLAB);
        xMaterials.add(Material.PRISMARINE_BRICK_SLAB);
        xMaterials.add(Material.DARK_PRISMARINE_SLAB);
        xMaterials.add(Material.POLISHED_GRANITE_SLAB);
        xMaterials.add(Material.SMOOTH_RED_SANDSTONE_SLAB);
        xMaterials.add(Material.MOSSY_STONE_BRICK_SLAB);
        xMaterials.add(Material.POLISHED_DIORITE_SLAB);
        xMaterials.add(Material.MOSSY_COBBLESTONE_SLAB);
        xMaterials.add(Material.END_STONE_BRICK_SLAB);
        xMaterials.add(Material.SMOOTH_SANDSTONE_SLAB);
        xMaterials.add(Material.SMOOTH_QUARTZ_SLAB);
        xMaterials.add(Material.GRANITE_SLAB);
        xMaterials.add(Material.ANDESITE_SLAB);
        xMaterials.add(Material.RED_NETHER_BRICK_SLAB);
        xMaterials.add(Material.POLISHED_ANDESITE_SLAB);
        xMaterials.add(Material.DIORITE_SLAB);
        xMaterials.add(Material.POLISHED_BLACKSTONE_BRICK_SLAB);
        xMaterials.add(Material.POLISHED_BLACKSTONE_SLAB);

        xMaterials.add(Material.SEA_PICKLE);
        xMaterials.add(Material.DANDELION);
        xMaterials.add(Material.POPPY);
        xMaterials.add(Material.BLUE_ORCHID);
        xMaterials.add(Material.ALLIUM);
        xMaterials.add(Material.AZURE_BLUET);
        xMaterials.add(Material.RED_TULIP);
        xMaterials.add(Material.ORANGE_TULIP);
        xMaterials.add(Material.WHITE_TULIP);
        xMaterials.add(Material.PINK_TULIP);
        xMaterials.add(Material.OXEYE_DAISY);
        xMaterials.add(Material.CORNFLOWER);
        xMaterials.add(Material.LILY_OF_THE_VALLEY);
        xMaterials.add(Material.WITHER_ROSE);
        xMaterials.add(Material.BROWN_MUSHROOM);
        xMaterials.add(Material.RED_MUSHROOM);
        xMaterials.add(Material.CRIMSON_FUNGUS);
        xMaterials.add(Material.WARPED_FUNGUS);

        xMaterials.add(Material.LEVER);
        xMaterials.add(Material.CAMPFIRE);
        xMaterials.add(Material.SOUL_CAMPFIRE);

        xMaterials.add(Material.STONE_BUTTON);
        xMaterials.add(Material.OAK_BUTTON);
        xMaterials.add(Material.SPRUCE_BUTTON);
        xMaterials.add(Material.BIRCH_BUTTON);
        xMaterials.add(Material.JUNGLE_BUTTON);
        xMaterials.add(Material.ACACIA_BUTTON);
        xMaterials.add(Material.DARK_OAK_BUTTON);
        xMaterials.add(Material.CRIMSON_BUTTON);
        xMaterials.add(Material.WARPED_BUTTON);
        xMaterials.add(Material.POLISHED_BLACKSTONE_BUTTON);
        xMaterials.add(Material.DAYLIGHT_DETECTOR);
        xMaterials.add(Material.CONDUIT);
        xMaterials.add(Material.PLAYER_HEAD);
        xMaterials.add(Material.PLAYER_WALL_HEAD);
        xMaterials.add(Material.CREEPER_HEAD);
        xMaterials.add(Material.CREEPER_WALL_HEAD);
        xMaterials.add(Material.ZOMBIE_HEAD);
        xMaterials.add(Material.ZOMBIE_WALL_HEAD);
        xMaterials.add(Material.SKELETON_SKULL);
        xMaterials.add(Material.SKELETON_WALL_SKULL);
        xMaterials.add(Material.WITHER_SKELETON_SKULL);
        xMaterials.add(Material.WITHER_SKELETON_WALL_SKULL);

        xMaterials.add(Material.WHITE_BED);
        xMaterials.add(Material.ORANGE_BED);
        xMaterials.add(Material.MAGENTA_BED);
        xMaterials.add(Material.LIGHT_BLUE_BED);
        xMaterials.add(Material.YELLOW_BED);
        xMaterials.add(Material.LIME_BED);
        xMaterials.add(Material.PINK_BED);
        xMaterials.add(Material.GRAY_BED);
        xMaterials.add(Material.LIGHT_GRAY_BED);
        xMaterials.add(Material.CYAN_BED);
        xMaterials.add(Material.PURPLE_BED);
        xMaterials.add(Material.BLUE_BED);
        xMaterials.add(Material.BROWN_BED);
        xMaterials.add(Material.GREEN_BED);
        xMaterials.add(Material.RED_BED);
        xMaterials.add(Material.BLACK_BED);
        xMaterials.add(Material.FLOWER_POT);

        xMaterials.add(Material.CARROTS);
        xMaterials.add(Material.POTATOES);
        xMaterials.add(Material.WHEAT);
        xMaterials.add(Material.WHEAT_SEEDS);
        xMaterials.add(Material.BEETROOTS);
        xMaterials.add(Material.MELON_STEM);
        xMaterials.add(Material.ATTACHED_MELON_STEM);
        xMaterials.add(Material.PUMPKIN_STEM);
        xMaterials.add(Material.ATTACHED_PUMPKIN_STEM);

        xMaterials.add(Material.CAKE);

        Set<Material> smallMaterials = new HashSet<>();
        for (Material xMaterial : xMaterials) {
            smallMaterials.add(xMaterial);
        }

        return smallMaterials;
    }

}

package minestrapp.blocks;

import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.IStringSerializable;

public enum StoneType implements IStringSerializable
{
    RED_ROCK(0, "red_rock", "red_rock", MaterialColor.ADOBE, false),
    DEEP_RED_ROCK(1, "deep_red_rock", "deep_red_rock", MaterialColor.BROWN_TERRACOTTA, true),
    DEEPSTONE(2, "deepstone", "deepstone", MaterialColor.GRAY, true),
    COLDSTONE(3, "coldstone", "coldstone", MaterialColor.LIGHT_BLUE_TERRACOTTA, false),
    DEEP_COLDSTONE(4, "deep_coldstone", "deep_coldstone", MaterialColor.BLUE_TERRACOTTA, true),
    ICESTONE(5, "icestone", "icestone", MaterialColor.CYAN, false),
    GLACIERROCK(6, "glacierrock", "glacierrock", MaterialColor.BLUE, true),
    OCEANSTONE(7, "oceanstone", "oceanstone", MaterialColor.WOOD, false),
    DEEP_OCEANSTONE(8, "deep_oceanstone", "deep_oceanstone", MaterialColor.BROWN_TERRACOTTA, true),
    STONE(9, "stone", "stone", MaterialColor.STONE, false);

    //TODO: Cleanup unused props

    private static final StoneType[] META_LOOKUP = new StoneType[values().length];
    private final int meta;
    private final String name;
    private final MaterialColor mapColor;
    private final String unlocalizedName;
    private final boolean deep;

    private StoneType(int meta, String name, String unlocalized, MaterialColor mapColor, boolean deep)
    {
        this.meta = meta;
        this.name = name;
        this.mapColor = mapColor;
        this.unlocalizedName = unlocalized;
        this.deep = deep;
    }

    public boolean isDeep()
    {
        return this.deep;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public String toString()
    {
        return this.name;
    }

    public MaterialColor getMapColor()
    {
        return this.mapColor;
    }

    public static StoneType byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String getName()
    {
        return this.name;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    public String getRegisryName()
    {
        return this.unlocalizedName;
    }

    static
    {
        for (StoneType stone$enumtype : values())
        {
            META_LOOKUP[stone$enumtype.getMetadata()] = stone$enumtype;
        }
    }
}
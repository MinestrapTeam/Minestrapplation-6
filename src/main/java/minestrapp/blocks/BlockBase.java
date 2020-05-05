package minestrapp.blocks;


import minestrapp.Reference;
import net.minecraft.block.Block;

public class BlockBase extends Block {

    public BlockBase(Block.Properties properties, String name){
        super(properties);
        setRegistryName(Reference.id, name);
    }
}

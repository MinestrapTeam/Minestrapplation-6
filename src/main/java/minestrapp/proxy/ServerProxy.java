package minestrapp.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy{

	public void setup() {

	}

	public PlayerEntity getClientPlayer() {
		throw new IllegalStateException("Can't be called from the server!");
	}

	public World getClientWorld() {
		throw new IllegalStateException("Can't be called from the server!");
	}

}

package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class CardOnPlayerStoppedusingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure CardOnPlayerStoppedusing!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MoneyMod.LOGGER.warn("Failed to load dependency itemstack for procedure CardOnPlayerStoppedusing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putBoolean("user", (false));
		entity.getPersistentData().putBoolean("user", (false));
		entity.getPersistentData().putDouble("money", 0);
	}
}

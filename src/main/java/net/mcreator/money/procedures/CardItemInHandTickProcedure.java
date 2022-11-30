package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class CardItemInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure CardItemInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MoneyMod.LOGGER.warn("Failed to load dependency itemstack for procedure CardItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.getPersistentData().putDouble("money", (itemstack.getOrCreateTag().getDouble("money")));
		entity.getPersistentData().putBoolean("user", (itemstack.getOrCreateTag().getBoolean("user")));
	}
}

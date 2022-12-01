package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class InventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure InventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MoneyMod.LOGGER.warn("Failed to load dependency itemstack for procedure InventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		String usuario = "";
		boolean setado = false;
		itemstack.getOrCreateTag().putString("line1", "User:");
		if ((entity.getDisplayName().getString()).equals("usuario") && itemstack.getOrCreateTag().getBoolean("setado") == true) {
			itemstack.getOrCreateTag().putDouble("money", (entity.getPersistentData().getDouble("money")));
		} else {
			itemstack.getOrCreateTag().putDouble("money", 0);
		}
		itemstack.getOrCreateTag().putString("line2", (itemstack.getOrCreateTag().getString("usuario")));
		if ((entity.getDisplayName().getString()).equals("usuario") && itemstack.getOrCreateTag().getBoolean("setado") == true) {
			entity.getPersistentData().putDouble("money", (itemstack.getOrCreateTag().getDouble("money")));
		}
	}
}

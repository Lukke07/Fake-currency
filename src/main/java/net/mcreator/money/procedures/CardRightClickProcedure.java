package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class CardRightClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MoneyMod.LOGGER.warn("Failed to load dependency itemstack for procedure CardRightClick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("user") == false) {
			itemstack.getOrCreateTag().putBoolean("user", (true));
		} else {
			itemstack.getOrCreateTag().putBoolean("user", (false));
		}
	}
}

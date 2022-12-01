package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class RightClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure RightClick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MoneyMod.LOGGER.warn("Failed to load dependency itemstack for procedure RightClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putString("usuario", (entity.getDisplayName().getString()));
		(itemstack).addEnchantment(Enchantments.UNBREAKING, (int) 1);
		itemstack.getOrCreateTag().putBoolean("setado", (true));
	}
}

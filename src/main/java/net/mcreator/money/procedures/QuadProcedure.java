package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.money.MoneyMod;

import java.util.Map;

public class QuadProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure Quad!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean Valor = false;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("s4") == true) {
			Valor = (true);
		} else {
			Valor = (false);
		}
		return Valor;
	}
}

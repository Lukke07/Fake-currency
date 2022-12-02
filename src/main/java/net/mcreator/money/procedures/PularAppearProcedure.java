package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.money.item.TXredcardItem;
import net.mcreator.money.item.TXpinkcardItem;
import net.mcreator.money.item.TXblackcardItem;
import net.mcreator.money.item.BFcardItem;
import net.mcreator.money.MoneyMod;

import java.util.Map;

public class PularAppearProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure PularAppear!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean Valor = false;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("setado") != true
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == TXredcardItem.block
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == TXpinkcardItem.block
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == TXblackcardItem.block
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == BFcardItem.block)) {
			Valor = (true);
		} else {
			Valor = (false);
		}
		return Valor;
	}
}

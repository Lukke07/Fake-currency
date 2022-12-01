package net.mcreator.money.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.money.item.TXredcardItem;
import net.mcreator.money.item.TXpinkcardItem;
import net.mcreator.money.item.TXblackcardItem;
import net.mcreator.money.item.BlankCardItem;
import net.mcreator.money.item.BFcardItem;
import net.mcreator.money.MoneyMod;

import java.util.Map;

public class SetadorWhileThisGUIIsOpenTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MoneyMod.LOGGER.warn("Failed to load dependency entity for procedure SetadorWhileThisGUIIsOpenTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == BlankCardItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == TXredcardItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == TXpinkcardItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == TXblackcardItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == BFcardItem.block)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
	}
}

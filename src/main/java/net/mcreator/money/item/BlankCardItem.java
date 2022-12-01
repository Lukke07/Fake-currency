
package net.mcreator.money.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.money.itemgroup.FakeItemGroup;
import net.mcreator.money.MoneyModElements;

import java.util.List;

@MoneyModElements.ModElement.Tag
public class BlankCardItem extends MoneyModElements.ModElement {
	@ObjectHolder("money:blank_card")
	public static final Item block = null;

	public BlankCardItem(MoneyModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(FakeItemGroup.tab).maxDamage(100).rarity(Rarity.COMMON));
			setRegistryName("blank_card");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 20;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Um cart\u00E3o em branco"));
		}
	}
}

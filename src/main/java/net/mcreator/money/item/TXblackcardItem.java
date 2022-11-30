
package net.mcreator.money.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.money.itemgroup.FakeItemGroup;
import net.mcreator.money.MoneyModElements;

@MoneyModElements.ModElement.Tag
public class TXblackcardItem extends MoneyModElements.ModElement {
	@ObjectHolder("money:t_xblackcard")
	public static final Item block = null;

	public TXblackcardItem(MoneyModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(FakeItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("t_xblackcard");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

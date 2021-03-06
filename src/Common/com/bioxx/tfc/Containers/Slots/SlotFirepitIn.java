package com.bioxx.tfc.Containers.Slots;

import com.bioxx.tfc.TFCBlocks;
import com.bioxx.tfc.TFCItems;
import com.bioxx.tfc.Items.ItemOre;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotFirepitIn extends Slot
{
	public SlotFirepitIn(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
	{
		super(iinventory, i, j, k);
	}

	@Override
	public int getSlotStackLimit()
	{
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack is)
	{
		if(is.getItem() == TFCItems.Logs || is.getItem() == Item.getItemFromBlock(TFCBlocks.Peat) || is.getItem() == TFCItems.CeramicMold || is.getItem() instanceof ItemOre)
			return false;
		return true;
	}

	@Override
	public void putStack(ItemStack par1ItemStack)
	{
		if (par1ItemStack != null) par1ItemStack.stackSize = 1;
		super.putStack(par1ItemStack);
	}
}

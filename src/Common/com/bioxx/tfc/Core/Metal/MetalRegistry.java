package com.bioxx.tfc.Core.Metal;

import java.util.HashMap;
import java.util.Iterator;

import com.bioxx.tfc.api.Metal;

import net.minecraft.item.Item;

public class MetalRegistry 
{
	public static MetalRegistry instance = new MetalRegistry();
	
	private HashMap hash;
	
	public MetalRegistry()
	{
		hash = new HashMap();
	}
	
	//Returns true if the metal was added or false if a metal with a similar name already exists;
	public boolean addMetal(Metal m, Alloy.EnumTier soloTier)
	{
		if(hash.containsKey(m.Name))
			return false;

		hash.put(m.Name, m);
		
		Alloy alloy = new Alloy(m, soloTier);
		alloy.addIngred(m, 99, 100);
		AlloyManager.instance.addAlloy(alloy);
		
		return true;
	}
	
	public Metal getMetalFromItem(Item i)
	{
		Iterator<Metal> iter = hash.values().iterator();
		while(iter.hasNext())
		{
			Metal m = iter.next();
			if(m.Ingot == i || m.MeltedItem == i)
				return m;
		}
		
		return null;
	}
	
	public Metal getMetalFromString(String s)
	{
		if(hash.containsKey(s))
			return (Metal) hash.get(s);
		else return null;
	}
}

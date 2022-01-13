package com.rexpax.ui.components;

import com.rexpax.R;

import java.util.Arrays;
import java.util.List;

public enum ScreenItem {
	
	HOME(R.drawable. ic_launcher, R.string.menu_item_home),
	ABOUT(R.drawable.ic_launcher, R.string.menu_item_about);
	
	private int iconResId;
	private int itemTitleResId;
	
	private ScreenItem(int iconResId, int itemTitleResId) {
		this.iconResId = iconResId;
		this.itemTitleResId = itemTitleResId;		
	}
	
	public int getIconResId() {
		return iconResId;
	}
	
	public int getItemTitleResId() {
		return itemTitleResId;
	}
	
	public static List<ScreenItem> getItems() {
		ScreenItem[] itemsArray = values();
		if (itemsArray != null) {
			return Arrays.asList(itemsArray);
		}
		return null;
	}
}
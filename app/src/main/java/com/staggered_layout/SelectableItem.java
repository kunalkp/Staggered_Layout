package com.staggered_layout;

/**
 * Created by KunalPardeshi on 30-Oct-17.
 */

public class SelectableItem extends Item {
    private boolean isSelected = false;


    public SelectableItem(Item item, boolean isSelected) {
        super(item.getName());
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

package com.staggered_layout;

/**
 * Created by KunalPardeshi on 30-Oct-17.
 */

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        Item itemCompare = (Item) obj;
        if(itemCompare.getName().equals(this.getName()))
            return true;

        return false;
    }
}

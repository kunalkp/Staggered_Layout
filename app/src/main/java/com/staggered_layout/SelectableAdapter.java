package com.staggered_layout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KunalPardeshi on 30-Oct-17.
 */

public class SelectableAdapter extends RecyclerView.Adapter implements SelectableViewHolder.OnItemSelectedListener {

    private final List<SelectableItem> mValues;
    SelectableViewHolder.OnItemSelectedListener listener;

    SelectableAdapter(SelectableViewHolder.OnItemSelectedListener listener,
                      List<Item> items) {
        this.listener = listener;

        mValues = new ArrayList<>();
        for (Item item : items) {
            mValues.add(new SelectableItem(item, false));
        }
    }

    @Override
    public SelectableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_text, parent, false);

        return new SelectableViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        SelectableViewHolder holder = (SelectableViewHolder) viewHolder;
        SelectableItem selectableItem = mValues.get(position);
        String name = selectableItem.getName();
        holder.textView.setText(name);
        holder.mItem = selectableItem;
        holder.setmItem(holder.mItem.isSelected());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    List<Item> getSelectedItems() {

        List<Item> selectedItems = new ArrayList<>();
        for (SelectableItem item : mValues) {
            if (item.isSelected()) {
                selectedItems.add(item);
            }
        }
        return selectedItems;
    }

    @Override
    public void onItemSelected(SelectableItem item) {
        listener.onItemSelected(item);
    }
}

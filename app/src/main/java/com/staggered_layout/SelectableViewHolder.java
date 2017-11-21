package com.staggered_layout;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by KunalPardeshi on 30-Oct-17.
 */

public class SelectableViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    SelectableItem mItem;
    private OnItemSelectedListener itemSelectedListener;

    SelectableViewHolder(View view, OnItemSelectedListener listener) {
        super(view);
        itemSelectedListener = listener;
        textView = (TextView) view.findViewById(R.id.textView_demo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mItem.isSelected()) {
                    setChecked(false, view);
                } else {
                    setChecked(true, view);
                }
                itemSelectedListener.onItemSelected(mItem);
            }
        });
    }

    void setChecked(boolean value, View view) {
        if (value) {
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setBackground(view.getResources().getDrawable(R.drawable.bg_gradient_text_selected));
        } else {
            textView.setTextColor(Color.parseColor("#808080"));
            textView.setBackground(view.getResources().getDrawable(R.drawable.bg_gradient_text_unselected));
        }
        mItem.setSelected(value);
    }

    void setmItem(boolean value){
        mItem.setSelected(value);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(SelectableItem item);
    }
}

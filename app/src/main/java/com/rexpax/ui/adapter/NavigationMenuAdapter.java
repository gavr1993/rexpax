package com.rexpax.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rexpax.R;
import com.rexpax.ui.components.ScreenItem;
import com.rexpax.utils.ViewHolder;

@SuppressWarnings("rawtypes")
public class NavigationMenuAdapter extends BaseListAdapter {

    private int selectedPosition;

    public NavigationMenuAdapter(Context context, List list) {
		super(context, list);
	}

    public void setSelectedPosition(int position) {
        this.selectedPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup group) {
        View view = convertView;
        if (view == null) {
            view = inflateView(R.layout.navigation_menu_item, convertView, group);
        }
    	ScreenItem item = (ScreenItem) getItem(position);
        ImageView image = ViewHolder.get(view, R.id.menu_row_icon);
        TextView text = ViewHolder.get(view, R.id.menu_row_text); 
        image.setImageResource(item.getIconResId());
        text.setText(item.getItemTitleResId());
        setBackground(view, position == selectedPosition);
        return view;
    }

    private void setBackground(View view, boolean selected) {
        if (selected) {
            view.setBackgroundResource(R.drawable.selected_background);
        } else {
            view.setBackgroundResource(android.R.color.transparent);
        }
    }
}

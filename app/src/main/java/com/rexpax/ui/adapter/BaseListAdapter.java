package com.rexpax.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@SuppressWarnings("rawtypes")
public abstract class BaseListAdapter extends BaseAdapter {

    private Object source;
    protected LayoutInflater layoutInflater;
    private Context context;

    public BaseListAdapter(final Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
	public BaseListAdapter(final Context context, final List list) {
        this(context);
        setSource(list);
    }

    public View inflateView(int res, View convertView, ViewGroup parent) {
        if (convertView == null) {
            return layoutInflater.inflate(res, parent, false);
        }
        return convertView;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public List getList() {
        return (List) getSource();
    }

    @Override
    public int getCount() {
        if (getList() != null) {
            return getList().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (getList() != null && position < getList().size()) {
        	return getList().get(position);
        }
    	return null;
    }

    public void clearList() {
    	if (getList() != null) {
    		getList().clear();
    	}
    }

    public Context getContext() {
        return context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}

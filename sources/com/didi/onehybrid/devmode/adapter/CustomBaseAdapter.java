package com.didi.onehybrid.devmode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    protected Context context;
    protected ArrayList<?> list;

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public CustomBaseAdapter(Context context2) {
        this.context = context2;
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return this.list.get(i);
    }
}

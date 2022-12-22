package com.didi.onehybrid.devmode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;
import java.util.ArrayList;

public class MyAdapter extends CustomBaseAdapter {
    public MyAdapter(Context context, ArrayList<String> arrayList) {
        super(context);
        this.list = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.context).inflate(R.layout.offline_bundle_item_layout, (ViewGroup) null);
            view2.setTag(viewHolder);
            viewHolder.view = (TextView) view2.findViewById(R.id.tv_bundle_name);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.view.setText(this.list.get(i).toString());
        return view2;
    }

    class ViewHolder {
        TextView view;

        ViewHolder() {
        }
    }
}

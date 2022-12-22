package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.departure.wheel.internal.BaseWheelAdapter;
import com.taxis99.R;

public class TerminalWheelAdapter extends BaseWheelAdapter<C9454a> {

    /* renamed from: a */
    private Context f25378a;

    public TerminalWheelAdapter(Context context) {
        this.f25378a = context;
    }

    /* access modifiers changed from: protected */
    public View bindView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.f25378a).inflate(R.layout.layout_map_departure_terminal_wheel_item, (ViewGroup) null);
            viewHolder.vTitle = (TextView) view2.findViewById(R.id.title);
            viewHolder.vNearest = (TextView) view2.findViewById(R.id.nearest);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        C9454a aVar = (C9454a) this.mList.get(i);
        viewHolder.vTitle.setText(aVar.f25379a);
        viewHolder.vTitle.setMaxLines(2);
        viewHolder.vNearest.setVisibility(aVar.f25380b ? 0 : 8);
        return view2;
    }

    static class ViewHolder {
        TextView vNearest;
        TextView vTitle;

        ViewHolder() {
        }
    }
}

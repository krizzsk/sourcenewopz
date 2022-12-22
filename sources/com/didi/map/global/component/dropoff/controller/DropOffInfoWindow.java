package com.didi.map.global.component.dropoff.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class DropOffInfoWindow {

    /* renamed from: a */
    private View f25463a;

    /* renamed from: b */
    private TextView f25464b;

    public View getView(Context context, String str) {
        if (this.f25463a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dropoff_rec_marker_bubble_view, (ViewGroup) null, false);
            this.f25463a = inflate;
            this.f25464b = (TextView) inflate.findViewById(R.id.dropoff_bubble_name);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f25464b.setText(str);
        }
        return this.f25463a;
    }
}

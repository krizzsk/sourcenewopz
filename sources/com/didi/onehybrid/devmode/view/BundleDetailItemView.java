package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class BundleDetailItemView {

    /* renamed from: a */
    private TextView f29575a;

    /* renamed from: b */
    private TextView f29576b;

    /* renamed from: c */
    private View f29577c;

    public BundleDetailItemView(Context context) {
        m20803a(context);
    }

    /* renamed from: a */
    private void m20803a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.all_offline_bundle_item_detail_layout, (ViewGroup) null);
        this.f29577c = inflate;
        this.f29575a = (TextView) inflate.findViewById(R.id.tv_all_offline_item_bundle_name);
        this.f29576b = (TextView) this.f29577c.findViewById(R.id.tv_all_offline_item_bundle_size);
    }

    public View getRoot() {
        return this.f29577c;
    }

    public void setBundleName(String str) {
        this.f29575a.setText(str);
    }

    public void setBundleSize(String str) {
        this.f29576b.setText(str);
    }
}

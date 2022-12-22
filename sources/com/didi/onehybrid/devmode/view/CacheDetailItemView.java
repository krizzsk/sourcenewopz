package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class CacheDetailItemView {

    /* renamed from: a */
    private TextView f29578a;

    /* renamed from: b */
    private TextView f29579b;

    /* renamed from: c */
    private View f29580c;

    public CacheDetailItemView(Context context) {
        m20804a(context);
    }

    /* renamed from: a */
    private void m20804a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.cache_item_detail_layout, (ViewGroup) null);
        this.f29580c = inflate;
        this.f29578a = (TextView) inflate.findViewById(R.id.tv_cache_size);
        this.f29579b = (TextView) this.f29580c.findViewById(R.id.tv_cache_md5);
    }

    public View getRoot() {
        return this.f29580c;
    }

    public void setCacheSize(String str) {
        this.f29578a.setText(str);
    }

    public void setCacheMd5(String str) {
        this.f29579b.setText(str);
    }
}

package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class OfflineCacheItemView {

    /* renamed from: a */
    private TextView f29581a;

    /* renamed from: b */
    private TextView f29582b;

    /* renamed from: c */
    private TextView f29583c;

    /* renamed from: d */
    private TextView f29584d;

    /* renamed from: e */
    private TextView f29585e;

    /* renamed from: f */
    private View f29586f;

    public OfflineCacheItemView(Context context) {
        m20805a(context);
    }

    /* renamed from: a */
    private void m20805a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.offline_cache_item_view, (ViewGroup) null);
        this.f29586f = inflate;
        this.f29581a = (TextView) inflate.findViewById(R.id.tv_file_name);
        this.f29582b = (TextView) this.f29586f.findViewById(R.id.tv_file_modify_time);
        this.f29583c = (TextView) this.f29586f.findViewById(R.id.tv_file_size);
        this.f29584d = (TextView) this.f29586f.findViewById(R.id.tv_file_url);
        this.f29585e = (TextView) this.f29586f.findViewById(R.id.tv_file_path);
    }

    public View getRoot() {
        return this.f29586f;
    }

    public void setFileName(String str) {
        this.f29581a.setText(str);
    }

    public void setModifyTime(String str) {
        this.f29582b.setText(str);
    }

    public void setFileSize(String str) {
        this.f29583c.setText(str);
    }

    public void setFileUrl(String str) {
        this.f29584d.setText(str);
    }

    public void setFilePath(String str) {
        this.f29585e.setText(str);
    }
}

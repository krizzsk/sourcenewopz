package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class StartDestAbnormalDrawerView extends LinearLayout {

    /* renamed from: a */
    private TextView f14534a;

    /* renamed from: b */
    private TextView f14535b;

    /* renamed from: c */
    private LinearLayout f14536c;

    /* renamed from: d */
    private LinearLayout f14537d;

    /* renamed from: e */
    private LinearLayout f14538e;

    public StartDestAbnormalDrawerView(Context context) {
        super(context);
        m10333a(context);
    }

    /* renamed from: a */
    private void m10333a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.global_map_start_end_dot, this, true);
        this.f14536c = (LinearLayout) findViewById(R.id.star_layout);
        this.f14534a = (TextView) findViewById(R.id.tv_start_text);
        this.f14537d = (LinearLayout) findViewById(R.id.destination_layout);
        this.f14535b = (TextView) findViewById(R.id.tv_end_text);
        this.f14538e = (LinearLayout) findViewById(R.id.start_or_dest_layout);
    }

    public void setOnlyStart(String str) {
        int i = 0;
        this.f14538e.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        LinearLayout linearLayout = this.f14536c;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.f14534a.setText(str);
        this.f14537d.setVisibility(8);
    }

    public void setOnlyDest(String str) {
        int i = 0;
        this.f14538e.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        LinearLayout linearLayout = this.f14537d;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.f14535b.setText(str);
        this.f14536c.setVisibility(8);
    }

    public void setStartDest(String str, String str2) {
        int i = 8;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.f14538e.setVisibility(0);
        } else {
            this.f14538e.setVisibility(8);
        }
        this.f14536c.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        this.f14534a.setText(str);
        LinearLayout linearLayout = this.f14537d;
        if (!TextUtils.isEmpty(str2)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        this.f14535b.setText(str2);
    }
}

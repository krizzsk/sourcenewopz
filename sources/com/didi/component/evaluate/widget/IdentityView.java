package com.didi.component.evaluate.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.common.widget.CircleImageView;
import com.taxis99.R;

public class IdentityView extends LinearLayout {

    /* renamed from: a */
    private CircleImageView f13454a;

    /* renamed from: b */
    private ImageView f13455b;

    /* renamed from: c */
    private TextView f13456c;

    /* renamed from: d */
    private TextView f13457d;

    /* renamed from: e */
    private TextView f13458e;

    /* renamed from: f */
    private int f13459f = 5;

    public IdentityView(Context context) {
        super(context);
        m9214a();
    }

    public IdentityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9214a();
    }

    public IdentityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9214a();
    }

    /* renamed from: a */
    private void m9214a() {
        setOrientation(1);
        setGravity(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_identity_view, this, true);
        this.f13454a = (CircleImageView) inflate.findViewById(R.id.iv_head);
        this.f13455b = (ImageView) inflate.findViewById(R.id.iv_status);
        this.f13456c = (TextView) inflate.findViewById(R.id.tv_name);
        this.f13457d = (TextView) inflate.findViewById(R.id.tv_status);
        this.f13458e = (TextView) inflate.findViewById(R.id.tv_tips);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m9215a(this.f13459f);
    }

    public void setFocus() {
        this.f13457d.setFocusable(true);
        this.f13457d.sendAccessibilityEvent(128);
    }

    public void setHead(int i) {
        this.f13454a.setImageResource(i);
    }

    public void setHead(String str) {
        Glide.with(getContext()).load(str).into((ImageView) this.f13454a);
    }

    public void setLevel(int i) {
        if (this.f13459f != i) {
            this.f13459f = i;
            m9215a(i);
        }
    }

    public void setName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13456c.setText(str);
        }
    }

    public void setTips(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13458e.setText(str);
        }
    }

    public void hideTipsView() {
        this.f13458e.setVisibility(8);
    }

    /* renamed from: a */
    private void m9215a(int i) {
        if (i == 5) {
            this.f13455b.setImageResource(R.drawable.global_evaluate_btn_satisfaction);
            this.f13457d.setText(R.string.oc_evaluate_satisfied);
            return;
        }
        this.f13455b.setImageResource(R.drawable.global_evaluate_btn_unsatisfaction);
        this.f13457d.setText(R.string.oc_evaluate_unsatisfied);
    }
}

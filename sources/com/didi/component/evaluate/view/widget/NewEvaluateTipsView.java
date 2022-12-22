package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewEvaluateTipsView extends RelativeLayout {

    /* renamed from: a */
    private ViewGroup f13422a;

    /* renamed from: b */
    private TextView f13423b;

    /* renamed from: c */
    private TextView f13424c;

    /* renamed from: d */
    private View f13425d;

    /* renamed from: e */
    private double f13426e;

    /* renamed from: f */
    private String f13427f;

    /* renamed from: g */
    private boolean f13428g = false;

    /* renamed from: h */
    private int f13429h;

    /* renamed from: b */
    private void m9200b() {
    }

    public NewEvaluateTipsView(Context context) {
        super(context);
        m9199a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9199a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9199a();
    }

    /* renamed from: a */
    private void m9199a() {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tips_item_layout, this, true)).findViewById(R.id.layout);
        this.f13422a = viewGroup;
        this.f13423b = (TextView) viewGroup.findViewById(R.id.currency);
        this.f13424c = (TextView) this.f13422a.findViewById(R.id.tips);
        this.f13425d = this.f13422a.findViewById(R.id.line);
        m9200b();
    }

    public void setCurrency(String str) {
        this.f13423b.setText(str);
    }

    public void setTips(String str, double d) {
        this.f13424c.setText(str);
        this.f13426e = d;
        this.f13427f = str;
    }

    public double getTips() {
        return this.f13426e;
    }

    public String getTipText() {
        return this.f13427f;
    }

    public void setSelected(boolean z) {
        this.f13428g = z;
        this.f13424c.setSelected(z);
        this.f13423b.setSelected(z);
    }

    public boolean isSelected() {
        return this.f13428g;
    }

    public void setWidth(int i) {
        ((RelativeLayout.LayoutParams) this.f13422a.getLayoutParams()).width = i;
    }

    public View getView() {
        return this.f13422a;
    }

    public void setLineVisibility(int i) {
        this.f13425d.setVisibility(i);
    }

    public int getIndex() {
        return this.f13429h;
    }

    public void setIndex(int i) {
        this.f13429h = i;
    }
}

package com.didi.component.evaluateentrance.impl.newView;

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
    private ViewGroup f13562a;

    /* renamed from: b */
    private TextView f13563b;

    /* renamed from: c */
    private TextView f13564c;

    /* renamed from: d */
    private View f13565d;

    /* renamed from: e */
    private double f13566e;

    /* renamed from: f */
    private String f13567f;

    /* renamed from: g */
    private boolean f13568g = false;

    /* renamed from: h */
    private int f13569h;

    /* renamed from: b */
    private void m9316b() {
    }

    public NewEvaluateTipsView(Context context) {
        super(context);
        m9315a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9315a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9315a();
    }

    /* renamed from: a */
    private void m9315a() {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tips_item_layout, this, true)).findViewById(R.id.layout);
        this.f13562a = viewGroup;
        this.f13563b = (TextView) viewGroup.findViewById(R.id.currency);
        this.f13564c = (TextView) this.f13562a.findViewById(R.id.tips);
        this.f13565d = this.f13562a.findViewById(R.id.line);
        m9316b();
    }

    public void setCurrency(String str) {
        this.f13563b.setText(str);
    }

    public void setTips(String str, double d) {
        this.f13564c.setText(str);
        this.f13566e = d;
        this.f13567f = str;
    }

    public double getTips() {
        return this.f13566e;
    }

    public String getTipText() {
        return this.f13567f;
    }

    public void setSelected(boolean z) {
        this.f13568g = z;
        this.f13564c.setSelected(z);
        this.f13563b.setSelected(z);
    }

    public boolean isSelected() {
        return this.f13568g;
    }

    public void setWidth(int i) {
        ((RelativeLayout.LayoutParams) this.f13562a.getLayoutParams()).width = i;
    }

    public View getView() {
        return this.f13562a;
    }

    public void setLineVisibility(int i) {
        this.f13565d.setVisibility(i);
    }

    public int getIndex() {
        return this.f13569h;
    }

    public void setIndex(int i) {
        this.f13569h = i;
    }
}

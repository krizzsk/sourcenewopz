package com.didi.map.global.component.departure.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class TwoSidesDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f24897a;

    /* renamed from: b */
    private CharSequence f24898b;

    /* renamed from: c */
    private CharSequence f24899c;

    /* renamed from: d */
    private ViewGroup f24900d;

    public TwoSidesDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_departure_two_sides_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_left_first)).setText(this.f24897a);
        ((TextView) inflate.findViewById(R.id.tv_left_second)).setText(this.f24898b);
        ((TextView) inflate.findViewById(R.id.tv_right)).setText(this.f24899c);
        this.f24900d = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    public TwoSidesDepartureBubble setLeftFirstLineText(CharSequence charSequence) {
        this.f24897a = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setLeftSecondLineText(CharSequence charSequence) {
        this.f24898b = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setRightText(CharSequence charSequence) {
        this.f24899c = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f24900d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f24900d.setVisibility(4);
    }
}

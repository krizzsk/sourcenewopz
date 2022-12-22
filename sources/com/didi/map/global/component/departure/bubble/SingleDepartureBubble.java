package com.didi.map.global.component.departure.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class SingleDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private ViewGroup f24893a;

    /* renamed from: b */
    private TextView f24894b;

    /* renamed from: c */
    private CharSequence f24895c;

    /* renamed from: d */
    private int f24896d = 0;

    public SingleDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SingleDepartureBubble setText(CharSequence charSequence) {
        this.f24895c = charSequence;
        return this;
    }

    public SingleDepartureBubble setMaxEms(int i) {
        this.f24896d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_departure_single_view, viewGroup, false);
        this.f24893a = (ViewGroup) inflate.findViewById(R.id.layout_content);
        this.f24894b = (TextView) inflate.findViewById(R.id.tv_text);
        if (this.f24896d <= 0 || this.f24895c.length() <= this.f24896d) {
            this.f24894b.setText(this.f24895c);
        } else {
            this.f24894b.setText(this.f24895c.subSequence(0, this.f24896d) + "...");
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f24893a.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f24893a.setVisibility(4);
    }
}

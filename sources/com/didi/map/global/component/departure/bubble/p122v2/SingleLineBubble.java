package com.didi.map.global.component.departure.bubble.p122v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.taxis99.R;

/* renamed from: com.didi.map.global.component.departure.bubble.v2.SingleLineBubble */
public class SingleLineBubble extends DepartureBubble {

    /* renamed from: a */
    private ViewGroup f24901a;

    /* renamed from: b */
    private TextView f24902b;

    /* renamed from: c */
    private CharSequence f24903c;

    /* renamed from: d */
    private int f24904d = 0;

    public SingleLineBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SingleLineBubble setText(CharSequence charSequence) {
        this.f24903c = charSequence;
        return this;
    }

    public SingleLineBubble setMaxEms(int i) {
        this.f24904d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_v2_single_text_layout, viewGroup, false);
        this.f24901a = (ViewGroup) inflate.findViewById(R.id.layout_content);
        this.f24902b = (TextView) inflate.findViewById(R.id.tv_text);
        if (this.f24904d <= 0 || this.f24903c.length() <= this.f24904d) {
            this.f24902b.setText(this.f24903c);
        } else {
            this.f24902b.setText(this.f24903c.subSequence(0, this.f24904d) + "...");
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f24901a.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f24901a.setVisibility(4);
    }
}

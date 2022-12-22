package com.didi.map.global.component.departure.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class LoadingDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f24891a;

    /* renamed from: b */
    private ViewGroup f24892b;

    public LoadingDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_departure_loading_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_right)).setText(this.f24891a);
        this.f24892b = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    public LoadingDepartureBubble setRightText(CharSequence charSequence) {
        this.f24891a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f24892b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f24892b.setVisibility(4);
    }
}

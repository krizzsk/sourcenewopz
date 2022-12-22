package com.didi.map.sdk.departure.internal.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class LoadingDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f28141a;

    /* renamed from: b */
    private ViewGroup f28142b;

    public LoadingDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_map_departure_loading_bubble_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_right)).setText(this.f28141a);
        this.f28142b = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    public LoadingDepartureBubble setRightText(CharSequence charSequence) {
        this.f28141a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f28142b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f28142b.setVisibility(4);
    }
}

package com.didi.map.global.flow.scene.vamos.components.departure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.taxis99.R;

public class VamosPicSingleLineDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f27068a;

    /* renamed from: b */
    private ViewGroup f27069b;

    public VamosPicSingleLineDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public VamosPicSingleLineDepartureBubble setText(CharSequence charSequence) {
        this.f27068a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        CharSequence charSequence = this.f27068a;
        if (charSequence == null) {
            charSequence = "";
        }
        this.f27068a = charSequence;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.depature_pic_single_ling_bubble_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tvBubbleText)).setText(this.f27068a);
        this.f27069b = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        ViewGroup viewGroup = this.f27069b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        ViewGroup viewGroup = this.f27069b;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
    }
}

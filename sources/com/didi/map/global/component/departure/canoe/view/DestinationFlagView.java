package com.didi.map.global.component.departure.canoe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.didi.common.map.util.DisplayUtils;
import com.taxis99.R;

public class DestinationFlagView extends CardView {

    /* renamed from: a */
    private int f25005a;

    public DestinationFlagView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DestinationFlagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DestinationFlagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.canoe_destination_pin_view_layout, this);
        setRadius((float) DisplayUtils.dp2px(context, 20.0f));
        this.f25005a = DisplayUtils.dp2px(context, 20.0f);
    }

    public int[] getWidthHeight() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{getMeasuredWidth(), getMeasuredHeight()};
    }

    public int getAngle() {
        return this.f25005a;
    }
}

package com.didi.sdk.view.popup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PopupSelectRecyclerView extends RecyclerView {

    /* renamed from: a */
    private int f38157a = -1;

    public PopupSelectRecyclerView(Context context) {
        super(context);
    }

    public PopupSelectRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PopupSelectRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxHeight(int i) {
        this.f38157a = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.f38157a;
        if (i3 <= size && i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}

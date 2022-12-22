package com.didi.component.evaluate.widget;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.GLog;

public class HeightCustomizableGridLayoutManager extends GridLayoutManager {

    /* renamed from: a */
    private static final String f13451a = "MaxHeightLM";

    /* renamed from: b */
    private OnHeightMeasureListener f13452b;

    /* renamed from: c */
    private RecyclerView f13453c;

    public interface OnHeightMeasureListener {
        int onHeightMeasured(int i);
    }

    public HeightCustomizableGridLayoutManager(RecyclerView recyclerView, Context context, int i) {
        super(context, i);
        this.f13453c = recyclerView;
    }

    public void setMeasuredDimension(int i, int i2) {
        GLog.m7965d(f13451a, "height : " + i2);
        OnHeightMeasureListener onHeightMeasureListener = this.f13452b;
        if (onHeightMeasureListener != null) {
            i2 = onHeightMeasureListener.onHeightMeasured(i2);
        }
        GLog.m7965d(f13451a, "final height : " + i2);
        super.setMeasuredDimension(i, i2);
    }

    public void setOnHeightMeasureListener(OnHeightMeasureListener onHeightMeasureListener) {
        this.f13452b = onHeightMeasureListener;
    }
}

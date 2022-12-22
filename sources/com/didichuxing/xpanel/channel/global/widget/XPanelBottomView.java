package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class XPanelBottomView extends FrameLayout {

    /* renamed from: ID */
    public static final String f49399ID = "xpanel_bottom";

    /* renamed from: a */
    private BottomCaculate f49400a;

    public interface BottomCaculate {
        int measureBottomHeight();
    }

    public XPanelBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void bindInterface(BottomCaculate bottomCaculate) {
        this.f49400a = bottomCaculate;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        BottomCaculate bottomCaculate = this.f49400a;
        setMeasuredDimension(i, View.MeasureSpec.makeMeasureSpec(bottomCaculate == null ? 0 : bottomCaculate.measureBottomHeight(), 1073741824));
    }
}

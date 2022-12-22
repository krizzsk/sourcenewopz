package com.didiglobal.xpanelnew.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didiglobal.xpanelnew.util.XpLog;

public class XpBottomView extends FrameLayout {

    /* renamed from: ID */
    public static final String f51689ID = "xpanel_bottom";

    /* renamed from: a */
    private IBottomViewHeightCaculate f51690a;

    public interface IBottomViewHeightCaculate {
        int measureBottomHeight();
    }

    public XpBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XpBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void bindInterface(IBottomViewHeightCaculate iBottomViewHeightCaculate) {
        this.f51690a = iBottomViewHeightCaculate;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IBottomViewHeightCaculate iBottomViewHeightCaculate = this.f51690a;
        int measureBottomHeight = iBottomViewHeightCaculate == null ? 0 : iBottomViewHeightCaculate.measureBottomHeight();
        XpLog.m36924d("xpanel_bottomview", "height = " + measureBottomHeight);
        setMeasuredDimension(i, View.MeasureSpec.makeMeasureSpec(measureBottomHeight, 1073741824));
    }
}

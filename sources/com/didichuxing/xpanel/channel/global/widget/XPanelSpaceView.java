package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didichuxing.xpanel.channel.global.impl.IXPanelMeasureHelper;

public class XPanelSpaceView extends FrameLayout {

    /* renamed from: a */
    private int f49477a = 0;

    /* renamed from: b */
    private Rect f49478b = new Rect();

    /* renamed from: c */
    private IXPanelMeasureHelper f49479c;

    public XPanelSpaceView(Context context) {
        super(context);
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measureHeight = this.f49479c.measureHeight(i);
        this.f49477a = measureHeight;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measureHeight, 1073741824));
    }

    public boolean contain(int i, int i2) {
        IXPanelMeasureHelper iXPanelMeasureHelper = this.f49479c;
        if (iXPanelMeasureHelper == null) {
            return false;
        }
        iXPanelMeasureHelper.getMessageRect(this.f49478b);
        Rect rect = this.f49478b;
        rect.top = this.f49477a - rect.top;
        Rect rect2 = this.f49478b;
        rect2.bottom = this.f49477a - rect2.bottom;
        return this.f49478b.contains(i, i2);
    }

    public void setXPanelMeasureHelper(IXPanelMeasureHelper iXPanelMeasureHelper) {
        this.f49479c = iXPanelMeasureHelper;
    }
}

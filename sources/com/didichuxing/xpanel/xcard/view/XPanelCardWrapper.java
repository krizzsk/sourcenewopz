package com.didichuxing.xpanel.xcard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.Map;

public class XPanelCardWrapper extends FrameLayout {

    /* renamed from: a */
    XPanelCardData f49648a;

    public XPanelCardWrapper(Context context) {
        super(context);
    }

    public XPanelCardWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XPanelCardWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.NAVIGATION_BAR_UNHIDE, Integer.MIN_VALUE));
    }

    public void setTag(Object obj) {
        super.setTag(obj);
        if (obj instanceof XPanelCardData) {
            this.f49648a = (XPanelCardData) obj;
        }
    }

    public Map<String, Object> getOmega() {
        XPanelCardData xPanelCardData = this.f49648a;
        if (xPanelCardData != null) {
            return xPanelCardData.getOmegaParams((Map<String, Object>) null);
        }
        return null;
    }
}

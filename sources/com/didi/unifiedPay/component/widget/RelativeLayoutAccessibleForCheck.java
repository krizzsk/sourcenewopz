package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;

public class RelativeLayoutAccessibleForCheck extends RelativeLayout {

    /* renamed from: a */
    private boolean f44465a = false;

    /* renamed from: b */
    private boolean f44466b = false;

    public RelativeLayoutAccessibleForCheck(Context context) {
        super(context);
    }

    public RelativeLayoutAccessibleForCheck(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativeLayoutAccessibleForCheck(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCheckEnable(boolean z) {
        this.f44466b = z;
    }

    public void setCheck(boolean z) {
        this.f44465a = z;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f44465a);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setChecked(this.f44465a);
        accessibilityNodeInfo.setCheckable(this.f44466b);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f44465a);
    }
}

package com.didi.component.evaluate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.component.common.util.GLog;

public class TextViewAccessibleForCheck extends AppCompatTextView {
    public TextViewAccessibleForCheck(Context context) {
        super(context);
    }

    public TextViewAccessibleForCheck(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TextViewAccessibleForCheck(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        GLog.m7964d("bzh onPopulateAccessibilityEvent");
        accessibilityEvent.setChecked(isSelected());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        GLog.m7964d("bzh onInitializeAccessibilityNodeInfo");
        accessibilityNodeInfo.setChecked(isSelected());
        accessibilityNodeInfo.setCheckable(true);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        GLog.m7964d("bzh onInitializeAccessibilityEvent");
        accessibilityEvent.setChecked(isSelected());
    }
}

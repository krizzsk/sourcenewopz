package com.didi.map.outer.map;

import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;

public interface MapAccessManager {
    int getVirtualViewAt(float f, float f2);

    void getVisibleVirtualViews(List<Integer> list);

    void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent);

    void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);
}

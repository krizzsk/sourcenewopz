package com.didi.hawaii.mapsdkv2;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.didi.map.common.accessibility.MapAccessibilityEventSource;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.MapAccessManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAccessibilityDelegate implements MapAccessibilityEventSource, MapAccessManager {

    /* renamed from: a */
    private Map<String, DMarker> f23675a = new HashMap();

    public int getVirtualViewAt(float f, float f2) {
        for (Map.Entry next : this.f23675a.entrySet()) {
            Rect screenRect = ((DMarker) next.getValue()).getScreenRect();
            if (screenRect != null && screenRect.contains((int) f, (int) f2)) {
                return Integer.parseInt((String) next.getKey());
            }
        }
        return Integer.MIN_VALUE;
    }

    public void getVisibleVirtualViews(List<Integer> list) {
        for (Map.Entry<String, DMarker> value : this.f23675a.entrySet()) {
            DMarker dMarker = (DMarker) value.getValue();
            if (dMarker != null) {
                list.add(Integer.valueOf(Integer.parseInt(dMarker.getId())));
            }
        }
    }

    public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        DMarker dMarker = this.f23675a.get(String.valueOf(i));
        if (dMarker != null) {
            accessibilityNodeInfoCompat.setContentDescription(dMarker.getTouchableContent());
            Rect screenRect = dMarker.getScreenRect();
            if (screenRect == null || screenRect.isEmpty()) {
                screenRect = new Rect(0, 0, 1, 1);
            }
            accessibilityNodeInfoCompat.setBoundsInParent(screenRect);
        }
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        DMarker dMarker;
        if (accessibilityEvent.getEventType() == 128 && (dMarker = this.f23675a.get(String.valueOf(i))) != null) {
            if (!dMarker.isInfoWindowShown() || TextUtils.isEmpty(dMarker.getTouchableContent())) {
                accessibilityEvent.setContentDescription("");
            } else {
                accessibilityEvent.setContentDescription(dMarker.getTouchableContent());
            }
        }
    }

    public void sendMarkerEvent(DMarker dMarker) {
        if (dMarker != null && !this.f23675a.containsValue(dMarker)) {
            this.f23675a.put(dMarker.getId(), dMarker);
        }
    }

    public void removeMarkerEvent(DMarker dMarker) {
        if (dMarker != null) {
            this.f23675a.remove(dMarker);
        }
    }
}

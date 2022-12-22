package p242io.flutter.plugin.platform;

import android.view.View;
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate */
public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge);

    void detachAccessibilityBridge();

    View getPlatformViewById(Integer num);

    boolean usesVirtualDisplay(Integer num);
}

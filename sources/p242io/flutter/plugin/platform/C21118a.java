package p242io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.plugin.platform.a */
/* compiled from: AccessibilityEventsDelegate */
class C21118a {

    /* renamed from: a */
    private AccessibilityBridge f57887a;

    C21118a() {
    }

    /* renamed from: a */
    public boolean mo172888a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityBridge accessibilityBridge = this.f57887a;
        if (accessibilityBridge == null) {
            return false;
        }
        return accessibilityBridge.externalViewRequestSendAccessibilityEvent(view, view2, accessibilityEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172887a(AccessibilityBridge accessibilityBridge) {
        this.f57887a = accessibilityBridge;
    }
}

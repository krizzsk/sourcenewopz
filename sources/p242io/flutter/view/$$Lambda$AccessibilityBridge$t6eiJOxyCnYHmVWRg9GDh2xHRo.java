package p242io.flutter.view;

import p242io.flutter.util.Predicate;
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.view.-$$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg-9GDh2xHRo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg9GDh2xHRo implements Predicate {
    public static final /* synthetic */ $$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg9GDh2xHRo INSTANCE = new $$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg9GDh2xHRo();

    private /* synthetic */ $$Lambda$AccessibilityBridge$t6eiJOxyCnYHmVWRg9GDh2xHRo() {
    }

    public final boolean test(Object obj) {
        return ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
    }
}

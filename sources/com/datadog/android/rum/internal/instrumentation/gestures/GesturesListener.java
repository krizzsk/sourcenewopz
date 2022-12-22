package com.datadog.android.rum.internal.instrumentation.gestures;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u001a\u0010 \u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\u001bH\u0002J6\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160&2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010!\u001a\u00020\u001bH\u0016J(\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011H\u0016J\u0010\u00103\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001bH\u0016J(\u00104\u001a\u00020(2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0016J\u0010\u00108\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u00109\u001a\u00020(2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u000e\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u001bJ\b\u0010<\u001a\u00020\u0018H\u0002J.\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010?0>2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u001bH\u0002J\f\u0010D\u001a\u00020\u000f*\u00020\u0016H\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;", "Landroid/view/GestureDetector$OnGestureListener;", "windowReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/Window;", "attributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "(Ljava/lang/ref/WeakReference;[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)V", "[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "coordinatesContainer", "", "gestureDirection", "", "onTouchDownXPos", "", "onTouchDownYPos", "scrollEventType", "Lcom/datadog/android/rum/RumActionType;", "scrollTargetReference", "Landroid/view/View;", "closeScrollOrSwipeEventIfAny", "", "decorView", "onUpEvent", "Landroid/view/MotionEvent;", "findTargetForScroll", "x", "y", "findTargetForTap", "handleTapUp", "e", "handleViewGroup", "view", "Landroid/view/ViewGroup;", "stack", "Ljava/util/LinkedList;", "hitTest", "", "container", "isScrollableView", "isValidScrollableTarget", "isValidTapTarget", "onDown", "onFling", "startDownEvent", "endUpEvent", "velocityX", "velocityY", "onLongPress", "onScroll", "currentMoveEvent", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onUp", "event", "resetScrollEventParameters", "resolveAttributes", "", "", "scrollTarget", "targetId", "resolveGestureDirection", "endEvent", "targetClassName", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GesturesListener.kt */
public final class GesturesListener implements GestureDetector.OnGestureListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SCROLL_DIRECTION_DOWN = "down";
    public static final String SCROLL_DIRECTION_LEFT = "left";
    public static final String SCROLL_DIRECTION_RIGHT = "right";
    public static final String SCROLL_DIRECTION_UP = "up";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final String f3843j = ("We could not find a valid target for the " + RumActionType.TAP.name() + " event.The DecorView was empty and either transparent or not clickable for this Activity.");
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final String f3844k = ("We could not find a valid target for the " + RumActionType.SCROLL.name() + " or " + RumActionType.SWIPE.name() + " event. The DecorView was empty and either transparent or not clickable for this Activity.");

    /* renamed from: a */
    private final WeakReference<Window> f3845a;

    /* renamed from: b */
    private final ViewAttributesProvider[] f3846b;

    /* renamed from: c */
    private final InteractionPredicate f3847c;

    /* renamed from: d */
    private final int[] f3848d;

    /* renamed from: e */
    private RumActionType f3849e;

    /* renamed from: f */
    private String f3850f;

    /* renamed from: g */
    private WeakReference<View> f3851g;

    /* renamed from: h */
    private float f3852h;

    /* renamed from: i */
    private float f3853i;

    public void onLongPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }

    public void onShowPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }

    public GesturesListener(WeakReference<Window> weakReference, ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate) {
        Intrinsics.checkNotNullParameter(weakReference, "windowReference");
        Intrinsics.checkNotNullParameter(viewAttributesProviderArr, "attributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        this.f3845a = weakReference;
        this.f3846b = viewAttributesProviderArr;
        this.f3847c = interactionPredicate;
        this.f3848d = new int[2];
        this.f3850f = "";
        this.f3851g = new WeakReference<>((Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GesturesListener(WeakReference weakReference, ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, (i & 2) != 0 ? new ViewAttributesProvider[0] : viewAttributesProviderArr, (i & 4) != 0 ? new NoOpInteractionPredicate() : interactionPredicate);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        Window window = (Window) this.f3845a.get();
        m2491b(window == null ? null : window.getDecorView(), motionEvent);
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        m2485a();
        this.f3852h = motionEvent.getX();
        this.f3853i = motionEvent.getY();
        return false;
    }

    public final void onUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Window window = (Window) this.f3845a.get();
        m2486a(window == null ? null : window.getDecorView(), motionEvent);
        m2485a();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "startDownEvent");
        Intrinsics.checkNotNullParameter(motionEvent2, "endUpEvent");
        this.f3849e = RumActionType.SWIPE;
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View b;
        Intrinsics.checkNotNullParameter(motionEvent, "startDownEvent");
        Intrinsics.checkNotNullParameter(motionEvent2, "currentMoveEvent");
        RumMonitor rumMonitor = GlobalRum.get();
        Window window = (Window) this.f3845a.get();
        View decorView = window == null ? null : window.getDecorView();
        if (!(decorView == null || this.f3849e != null || (b = m2490b(decorView, motionEvent.getX(), motionEvent.getY())) == null)) {
            this.f3851g = new WeakReference<>(b);
            rumMonitor.startUserAction(RumActionType.CUSTOM, "", MapsKt.emptyMap());
            this.f3849e = RumActionType.SCROLL;
        }
        return false;
    }

    /* renamed from: a */
    private final void m2486a(View view, MotionEvent motionEvent) {
        RumActionType rumActionType = this.f3849e;
        if (rumActionType != null) {
            RumMonitor rumMonitor = GlobalRum.get();
            View view2 = (View) this.f3851g.get();
            if (view != null && view2 != null) {
                rumMonitor.stopUserAction(rumActionType, GesturesUtilsKt.resolveTargetName(this.f3847c, view2), m2484a(view2, GesturesUtilsKt.resourceIdName(view2.getId()), motionEvent));
            }
        }
    }

    /* renamed from: a */
    private final Map<String, Object> m2484a(View view, String str, MotionEvent motionEvent) {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m42317to(RumAttributes.ACTION_TARGET_CLASS_NAME, m2494d(view)), TuplesKt.m42317to(RumAttributes.ACTION_TARGET_RESOURCE_ID, str));
        String a = m2483a(motionEvent);
        this.f3850f = a;
        mutableMapOf.put(RumAttributes.ACTION_GESTURE_DIRECTION, a);
        for (ViewAttributesProvider extractAttributes : this.f3846b) {
            extractAttributes.extractAttributes(view, mutableMapOf);
        }
        return mutableMapOf;
    }

    /* renamed from: a */
    private final void m2485a() {
        this.f3851g.clear();
        this.f3849e = null;
        this.f3850f = "";
        this.f3853i = 0.0f;
        this.f3852h = 0.0f;
    }

    /* renamed from: b */
    private final void m2491b(View view, MotionEvent motionEvent) {
        View a;
        if (view != null && (a = m2482a(view, motionEvent.getX(), motionEvent.getY())) != null) {
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m42317to(RumAttributes.ACTION_TARGET_CLASS_NAME, m2494d(a)), TuplesKt.m42317to(RumAttributes.ACTION_TARGET_RESOURCE_ID, GesturesUtilsKt.resourceIdName(a.getId())));
            for (ViewAttributesProvider extractAttributes : this.f3846b) {
                extractAttributes.extractAttributes(a, mutableMapOf);
            }
            GlobalRum.get().addUserAction(RumActionType.TAP, GesturesUtilsKt.resolveTargetName(this.f3847c, a), mutableMapOf);
        }
    }

    /* renamed from: a */
    private final View m2482a(View view, float f, float f2) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(view);
        View view2 = null;
        while (!linkedList.isEmpty()) {
            View view3 = (View) linkedList.removeFirst();
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            View view4 = m2488a(view3) ? view3 : view2;
            if (view3 instanceof ViewGroup) {
                m2487a((ViewGroup) view3, f, f2, linkedList, this.f3848d);
            }
            view2 = view4;
        }
        if (view2 == null) {
            Logger.i$default(RuntimeUtilsKt.getDevLogger(), f3843j, (Throwable) null, (Map) null, 6, (Object) null);
        }
        return view2;
    }

    /* renamed from: b */
    private final View m2490b(View view, float f, float f2) {
        LinkedList linkedList = new LinkedList();
        View view2 = view;
        linkedList.add(view);
        while (!linkedList.isEmpty()) {
            View view3 = (View) linkedList.removeFirst();
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            if (m2492b(view3)) {
                return view3;
            }
            if (view3 instanceof ViewGroup) {
                m2487a((ViewGroup) view3, f, f2, linkedList, this.f3848d);
            }
        }
        Logger.i$default(RuntimeUtilsKt.getDevLogger(), f3844k, (Throwable) null, (Map) null, 6, (Object) null);
        return null;
    }

    /* renamed from: a */
    private final void m2487a(ViewGroup viewGroup, float f, float f2, LinkedList<View> linkedList, int[] iArr) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "child");
                if (m2489a(childAt, f, f2, iArr)) {
                    linkedList.add(childAt);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m2488a(View view) {
        return view.isClickable() && view.getVisibility() == 0;
    }

    /* renamed from: b */
    private final boolean m2492b(View view) {
        return view.getVisibility() == 0 && m2493c(view);
    }

    /* renamed from: c */
    private final boolean m2493c(View view) {
        return ScrollingView.class.isAssignableFrom(view.getClass()) || AbsListView.class.isAssignableFrom(view.getClass());
    }

    /* renamed from: a */
    private final boolean m2489a(View view, float f, float f2, int[] iArr) {
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < ((float) i) || f > ((float) (i + width)) || f2 < ((float) i2) || f2 > ((float) (i2 + height))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final String m2483a(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.f3852h;
        float y = motionEvent.getY() - this.f3853i;
        return Math.abs(x) > Math.abs(y) ? x > 0.0f ? "left" : "right" : y > 0.0f ? "down" : "up";
    }

    /* renamed from: d */
    private final String m2494d(View view) {
        String canonicalName = view.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        String simpleName = view.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener$Companion;", "", "()V", "MSG_NO_TARGET_SCROLL_SWIPE", "", "getMSG_NO_TARGET_SCROLL_SWIPE$dd_sdk_android_release", "()Ljava/lang/String;", "MSG_NO_TARGET_TAP", "getMSG_NO_TARGET_TAP$dd_sdk_android_release", "SCROLL_DIRECTION_DOWN", "SCROLL_DIRECTION_LEFT", "SCROLL_DIRECTION_RIGHT", "SCROLL_DIRECTION_UP", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GesturesListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMSG_NO_TARGET_TAP$dd_sdk_android_release() {
            return GesturesListener.f3843j;
        }

        public final String getMSG_NO_TARGET_SCROLL_SWIPE$dd_sdk_android_release() {
            return GesturesListener.f3844k;
        }
    }
}

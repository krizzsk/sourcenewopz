package com.datadog.android.rum.internal.instrumentation.gestures;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpInteractionPredicate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B5\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\t0\tH\u0001J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0019\u0010\u001a\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u00190\u0019H\u0001J\u0019\u0010\u001b\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u001c0\u001cH\u0001J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\u0019\u0010\u001e\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\t0\tH\u0001J\u0019\u0010\u001f\u001a\u00020 2\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010!0!H\u0001J\u0019\u0010\"\u001a\u00020 2\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010!0!H\u0001J\t\u0010#\u001a\u00020 H\u0001J\t\u0010$\u001a\u00020 H\u0001J\u001b\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020(H\u0001J\u0013\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0015\u001a\u00020&H\u0001J\t\u0010+\u001a\u00020 H\u0001J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020(H\u0001J\u001b\u00101\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020(H\u0001J'\u00102\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020&2\n\b\u0001\u0010'\u001a\u0004\u0018\u00010*2\b\b\u0001\u00103\u001a\u00020(H\u0001J\t\u00104\u001a\u00020\u0014H\u0001J\u0019\u00104\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010505H\u0001J\u0019\u00106\u001a\u00020 2\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010707H\u0001J\u0011\u00108\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0001J\u001b\u00109\u001a\u0004\u0018\u00010!2\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010:0:H\u0001J#\u00109\u001a\u0004\u0018\u00010!2\u000e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010:0:2\u0006\u0010'\u001a\u00020&H\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006<"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/WindowCallbackWrapper;", "Landroid/view/Window$Callback;", "wrappedCallback", "gesturesDetector", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "copyEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "(Landroid/view/Window$Callback;Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;Lcom/datadog/android/rum/tracking/InteractionPredicate;Lkotlin/jvm/functions/Function1;)V", "getCopyEvent", "()Lkotlin/jvm/functions/Function1;", "getGesturesDetector", "()Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "getInteractionPredicate", "()Lcom/datadog/android/rum/tracking/InteractionPredicate;", "getWrappedCallback", "()Landroid/view/Window$Callback;", "dispatchGenericMotionEvent", "", "p0", "kotlin.jvm.PlatformType", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "dispatchTouchEvent", "dispatchTrackballEvent", "onActionModeFinished", "", "Landroid/view/ActionMode;", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "featureId", "item", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "onWindowFocusChanged", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WindowCallbackWrapper.kt */
public final class WindowCallbackWrapper implements Window.Callback {
    public static final String BACK_DEFAULT_TARGET_NAME = "back";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final boolean EVENT_CONSUMED = true;

    /* renamed from: a */
    private final Window.Callback f3854a;

    /* renamed from: b */
    private final GesturesDetectorWrapper f3855b;

    /* renamed from: c */
    private final InteractionPredicate f3856c;

    /* renamed from: d */
    private final Function1<MotionEvent, MotionEvent> f3857d;

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f3854a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f3854a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f3854a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f3854a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f3854a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f3854a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f3854a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f3854a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        return this.f3854a.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.f3854a.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.f3854a.onDetachedFromWindow();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        return this.f3854a.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        this.f3854a.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p2");
        return this.f3854a.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested() {
        return this.f3854a.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f3854a.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f3854a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f3854a.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f3854a.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f3854a.onWindowStartingActionMode(callback, i);
    }

    public WindowCallbackWrapper(Window.Callback callback, GesturesDetectorWrapper gesturesDetectorWrapper, InteractionPredicate interactionPredicate, Function1<? super MotionEvent, MotionEvent> function1) {
        Intrinsics.checkNotNullParameter(callback, "wrappedCallback");
        Intrinsics.checkNotNullParameter(gesturesDetectorWrapper, "gesturesDetector");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(function1, "copyEvent");
        this.f3854a = callback;
        this.f3855b = gesturesDetectorWrapper;
        this.f3856c = interactionPredicate;
        this.f3857d = function1;
    }

    public final Window.Callback getWrappedCallback() {
        return this.f3854a;
    }

    public final GesturesDetectorWrapper getGesturesDetector() {
        return this.f3855b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WindowCallbackWrapper(Window.Callback callback, GesturesDetectorWrapper gesturesDetectorWrapper, InteractionPredicate interactionPredicate, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(callback, gesturesDetectorWrapper, (i & 4) != 0 ? new NoOpInteractionPredicate() : interactionPredicate, (i & 8) != 0 ? C22001.INSTANCE : function1);
    }

    public final InteractionPredicate getInteractionPredicate() {
        return this.f3856c;
    }

    public final Function1<MotionEvent, MotionEvent> getCopyEvent() {
        return this.f3857d;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            MotionEvent invoke = this.f3857d.invoke(motionEvent);
            try {
                this.f3855b.onTouchEvent(invoke);
            } catch (Exception e) {
                Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Error processing MotionEvent", e, (Map) null, 4, (Object) null);
            } catch (Throwable th) {
                invoke.recycle();
                throw th;
            }
            invoke.recycle();
        } else {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Received MotionEvent=null", (Throwable) null, (Map) null, 6, (Object) null);
        }
        try {
            return this.f3854a.dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Wrapped callback failed processing MotionEvent", e2, (Map) null, 4, (Object) null);
            return true;
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        GlobalRum.get().addUserAction(RumActionType.TAP, GesturesUtilsKt.resolveTargetName(this.f3856c, menuItem), MapsKt.mutableMapOf(TuplesKt.m42317to(RumAttributes.ACTION_TARGET_CLASS_NAME, menuItem.getClass().getCanonicalName()), TuplesKt.m42317to(RumAttributes.ACTION_TARGET_RESOURCE_ID, GesturesUtilsKt.resourceIdName(menuItem.getItemId())), TuplesKt.m42317to(RumAttributes.ACTION_TARGET_TITLE, menuItem.getTitle())));
        try {
            return this.f3854a.onMenuItemSelected(i, menuItem);
        } catch (Exception e) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Wrapped callback failed processing MenuItem selection", e, (Map) null, 4, (Object) null);
            return true;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Received KeyEvent=null", (Throwable) null, (Map) null, 6, (Object) null);
        } else if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            String targetName = this.f3856c.getTargetName(keyEvent);
            CharSequence charSequence = targetName;
            if (charSequence == null || charSequence.length() == 0) {
                targetName = BACK_DEFAULT_TARGET_NAME;
            }
            GlobalRum.get().addUserAction(RumActionType.CUSTOM, targetName, MapsKt.emptyMap());
        }
        try {
            return this.f3854a.dispatchKeyEvent(keyEvent);
        } catch (Exception e) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Wrapped callback failed processing KeyEvent", e, (Map) null, 4, (Object) null);
            return true;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/WindowCallbackWrapper$Companion;", "", "()V", "BACK_DEFAULT_TARGET_NAME", "", "EVENT_CONSUMED", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WindowCallbackWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package p242io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.FlutterView;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

/* renamed from: io.flutter.embedding.android.FlutterSplashView */
final class FlutterSplashView extends FrameLayout {

    /* renamed from: a */
    private static String f57436a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f57437b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterView f57438c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f57439d;

    /* renamed from: e */
    private Bundle f57440e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f57441f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f57442g;

    /* renamed from: h */
    private final FlutterView.FlutterEngineAttachmentListener f57443h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f57444i;

    /* renamed from: j */
    private final Runnable f57445j;

    public FlutterSplashView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f57443h = new FlutterView.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashView.this.f57438c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.mo172152a(flutterSplashView.f57438c, FlutterSplashView.this.f57437b);
            }
        };
        this.f57444i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.f57437b != null) {
                    FlutterSplashView.this.m41326e();
                }
            }
        };
        this.f57445j = new Runnable() {
            public void run() {
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.removeView(flutterSplashView.f57439d);
                FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
                String unused = flutterSplashView2.f57442g = flutterSplashView2.f57441f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f57442g;
        SplashScreen splashScreen = this.f57437b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f57442g = savedState.previousCompletedSplashIsolate;
        this.f57440e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo172152a(FlutterView flutterView, SplashScreen splashScreen) {
        FlutterView flutterView2 = this.f57438c;
        if (flutterView2 != null) {
            flutterView2.removeOnFirstFrameRenderedListener(this.f57444i);
            removeView(this.f57438c);
        }
        View view = this.f57439d;
        if (view != null) {
            removeView(view);
        }
        this.f57438c = flutterView;
        addView(flutterView);
        this.f57437b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m41318a()) {
            Log.m41140v(f57436a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f57440e);
            this.f57439d = createSplashView;
            addView(createSplashView);
            flutterView.addOnFirstFrameRenderedListener(this.f57444i);
        } else if (m41320b()) {
            Log.m41140v(f57436a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f57440e);
            this.f57439d = createSplashView2;
            addView(createSplashView2);
            m41326e();
        } else if (!flutterView.isAttachedToFlutterEngine()) {
            Log.m41140v(f57436a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterView.addFlutterEngineAttachmentListener(this.f57443h);
        }
    }

    /* renamed from: a */
    private boolean m41318a() {
        FlutterView flutterView = this.f57438c;
        return flutterView != null && flutterView.isAttachedToFlutterEngine() && !this.f57438c.hasRenderedFirstFrame() && !m41324d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f57437b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m41320b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterView r0 = r1.f57438c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f57437b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m41322c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterSplashView.m41320b():boolean");
    }

    /* renamed from: c */
    private boolean m41322c() {
        FlutterView flutterView = this.f57438c;
        if (flutterView == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterView.isAttachedToFlutterEngine()) {
            return this.f57438c.hasRenderedFirstFrame() && !m41324d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m41324d() {
        FlutterView flutterView = this.f57438c;
        if (flutterView == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterView.isAttachedToFlutterEngine()) {
            return this.f57438c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f57438c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f57442g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m41326e() {
        this.f57441f = this.f57438c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f57436a;
        Log.m41140v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f57441f);
        this.f57437b.transitionToFlutter(this.f57445j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashView$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public String previousCompletedSplashIsolate;
        /* access modifiers changed from: private */
        public Bundle splashScreenState;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }
}

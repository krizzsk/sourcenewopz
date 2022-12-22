package p242io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.FlutterViewV1;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

/* renamed from: io.flutter.embedding.android.FlutterSplashViewV1 */
final class FlutterSplashViewV1 extends FrameLayout {

    /* renamed from: a */
    private static String f57456a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f57457b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterViewV1 f57458c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f57459d;

    /* renamed from: e */
    private Bundle f57460e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f57461f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f57462g;

    /* renamed from: h */
    private final FlutterViewV1.FlutterEngineAttachmentListener f57463h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f57464i;

    /* renamed from: j */
    private final Runnable f57465j;

    public FlutterSplashViewV1(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashViewV1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashViewV1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f57463h = new FlutterViewV1.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashViewV1.this.f57458c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashViewV1 flutterSplashViewV1 = FlutterSplashViewV1.this;
                flutterSplashViewV1.mo172168a(flutterSplashViewV1.f57458c, FlutterSplashViewV1.this.f57457b);
            }
        };
        this.f57464i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashViewV1.this.f57457b != null) {
                    FlutterSplashViewV1.this.m41350e();
                }
            }
        };
        this.f57465j = new Runnable() {
            public void run() {
                FlutterSplashViewV1 flutterSplashViewV1 = FlutterSplashViewV1.this;
                flutterSplashViewV1.removeView(flutterSplashViewV1.f57459d);
                FlutterSplashViewV1 flutterSplashViewV12 = FlutterSplashViewV1.this;
                String unused = flutterSplashViewV12.f57462g = flutterSplashViewV12.f57461f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f57462g;
        SplashScreen splashScreen = this.f57457b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f57462g = savedState.previousCompletedSplashIsolate;
        this.f57460e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo172168a(FlutterViewV1 flutterViewV1, SplashScreen splashScreen) {
        FlutterViewV1 flutterViewV12 = this.f57458c;
        if (flutterViewV12 != null) {
            flutterViewV12.removeOnFirstFrameRenderedListener(this.f57464i);
            removeView(this.f57458c);
        }
        View view = this.f57459d;
        if (view != null) {
            removeView(view);
        }
        this.f57458c = flutterViewV1;
        addView(flutterViewV1);
        this.f57457b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m41342a()) {
            Log.m41140v(f57456a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f57460e);
            this.f57459d = createSplashView;
            addView(createSplashView);
            flutterViewV1.addOnFirstFrameRenderedListener(this.f57464i);
        } else if (m41344b()) {
            Log.m41140v(f57456a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f57460e);
            this.f57459d = createSplashView2;
            addView(createSplashView2);
            m41350e();
        } else if (!flutterViewV1.isAttachedToFlutterEngine()) {
            Log.m41140v(f57456a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterViewV1.addFlutterEngineAttachmentListener(this.f57463h);
        }
    }

    /* renamed from: a */
    private boolean m41342a() {
        FlutterViewV1 flutterViewV1 = this.f57458c;
        return flutterViewV1 != null && flutterViewV1.isAttachedToFlutterEngine() && !this.f57458c.hasRenderedFirstFrame() && !m41348d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f57457b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m41344b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterViewV1 r0 = r1.f57458c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f57457b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m41346c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterSplashViewV1.m41344b():boolean");
    }

    /* renamed from: c */
    private boolean m41346c() {
        FlutterViewV1 flutterViewV1 = this.f57458c;
        if (flutterViewV1 == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterViewV1.isAttachedToFlutterEngine()) {
            return this.f57458c.hasRenderedFirstFrame() && !m41348d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m41348d() {
        FlutterViewV1 flutterViewV1 = this.f57458c;
        if (flutterViewV1 == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterViewV1.isAttachedToFlutterEngine()) {
            return this.f57458c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f57458c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f57462g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m41350e() {
        this.f57461f = this.f57458c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f57456a;
        Log.m41140v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f57461f);
        this.f57457b.transitionToFlutter(this.f57465j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashViewV1$SavedState */
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

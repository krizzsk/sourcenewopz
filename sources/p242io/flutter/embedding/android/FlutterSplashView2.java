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

/* renamed from: io.flutter.embedding.android.FlutterSplashView2 */
final class FlutterSplashView2 extends FrameLayout {

    /* renamed from: a */
    private static String f57446a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f57447b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterView3 f57448c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f57449d;

    /* renamed from: e */
    private Bundle f57450e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f57451f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f57452g;

    /* renamed from: h */
    private final FlutterView.FlutterEngineAttachmentListener f57453h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f57454i;

    /* renamed from: j */
    private final Runnable f57455j;

    public FlutterSplashView2(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f57453h = new FlutterView.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashView2.this.f57448c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView2 flutterSplashView2 = FlutterSplashView2.this;
                flutterSplashView2.mo172161a(flutterSplashView2.f57448c, FlutterSplashView2.this.f57447b);
            }
        };
        this.f57454i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashView2.this.f57447b != null) {
                    FlutterSplashView2.this.m41338e();
                }
            }
        };
        this.f57455j = new Runnable() {
            public void run() {
                FlutterSplashView2 flutterSplashView2 = FlutterSplashView2.this;
                flutterSplashView2.removeView(flutterSplashView2.f57449d);
                FlutterSplashView2 flutterSplashView22 = FlutterSplashView2.this;
                String unused = flutterSplashView22.f57452g = flutterSplashView22.f57451f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f57452g;
        SplashScreen splashScreen = this.f57447b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f57452g = savedState.previousCompletedSplashIsolate;
        this.f57450e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo172161a(FlutterView3 flutterView3, SplashScreen splashScreen) {
        FlutterView3 flutterView32 = this.f57448c;
        if (flutterView32 != null) {
            flutterView32.removeOnFirstFrameRenderedListener(this.f57454i);
            removeView(this.f57448c);
        }
        View view = this.f57449d;
        if (view != null) {
            removeView(view);
        }
        this.f57448c = flutterView3;
        addView(flutterView3);
        this.f57447b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m41330a()) {
            Log.m41140v(f57446a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f57450e);
            this.f57449d = createSplashView;
            addView(createSplashView);
            flutterView3.addOnFirstFrameRenderedListener(this.f57454i);
        } else if (m41332b()) {
            Log.m41140v(f57446a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f57450e);
            this.f57449d = createSplashView2;
            addView(createSplashView2);
            m41338e();
        } else if (!flutterView3.isAttachedToFlutterEngine()) {
            Log.m41140v(f57446a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterView3.addFlutterEngineAttachmentListener(this.f57453h);
        }
    }

    /* renamed from: a */
    private boolean m41330a() {
        FlutterView3 flutterView3 = this.f57448c;
        return flutterView3 != null && flutterView3.isAttachedToFlutterEngine() && !this.f57448c.hasRenderedFirstFrame() && !m41336d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f57447b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m41332b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterView3 r0 = r1.f57448c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f57447b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m41334c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterSplashView2.m41332b():boolean");
    }

    /* renamed from: c */
    private boolean m41334c() {
        FlutterView3 flutterView3 = this.f57448c;
        if (flutterView3 == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterView3.isAttachedToFlutterEngine()) {
            return this.f57448c.hasRenderedFirstFrame() && !m41336d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m41336d() {
        FlutterView3 flutterView3 = this.f57448c;
        if (flutterView3 == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterView3.isAttachedToFlutterEngine()) {
            return this.f57448c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f57448c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f57452g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m41338e() {
        this.f57451f = this.f57448c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f57446a;
        Log.m41140v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f57451f);
        this.f57447b.transitionToFlutter(this.f57455j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashView2$SavedState */
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

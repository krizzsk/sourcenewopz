package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public class RotationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f45312a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WindowManager f45313b;

    /* renamed from: c */
    private OrientationEventListener f45314c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RotationCallback f45315d;

    public void listen(Context context, RotationCallback rotationCallback) {
        stop();
        Context applicationContext = context.getApplicationContext();
        this.f45315d = rotationCallback;
        this.f45313b = (WindowManager) applicationContext.getSystemService("window");
        C149201 r3 = new OrientationEventListener(applicationContext, 3) {
            public void onOrientationChanged(int i) {
                int rotation;
                WindowManager a = RotationListener.this.f45313b;
                RotationCallback b = RotationListener.this.f45315d;
                if (RotationListener.this.f45313b != null && b != null && (rotation = a.getDefaultDisplay().getRotation()) != RotationListener.this.f45312a) {
                    int unused = RotationListener.this.f45312a = rotation;
                    b.onRotationChanged(rotation);
                }
            }
        };
        this.f45314c = r3;
        r3.enable();
        this.f45312a = this.f45313b.getDefaultDisplay().getRotation();
    }

    public void stop() {
        OrientationEventListener orientationEventListener = this.f45314c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f45314c = null;
        this.f45313b = null;
        this.f45315d = null;
    }
}

package com.microblink.blinkbarcode.hardware.camera;

import android.content.Context;
import android.graphics.Rect;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;

/* compiled from: line */
public interface IllIIIllII {

    /* compiled from: line */
    public interface llIIlIlIIl {
        void IlIllIlIIl();

        void llIIlIlIIl();

        void llIIlIlIIl(int i, int i2);

        void llIIlIlIIl(Throwable th);
    }

    boolean IIlIIIllIl();

    Boolean IlIllIlIIl();

    CameraType IlIllIlllI();

    void IllIIIIllI();

    void IllIIIllII();

    void dispose();

    boolean lIIIIIllll();

    boolean lIlIIIIlIl();

    void llIIIlllll();

    int llIIlIIlll();

    void llIIlIlIIl(float f);

    void llIIlIlIIl(Context context, IlIllIlIIl ilIllIlIIl, llIIlIlIIl lliililiil);

    void llIIlIlIIl(ShakeCallback shakeCallback);

    void llIIlIlIIl(boolean z, SuccessCallback successCallback);

    void llIIlIlIIl(Rect[] rectArr);

    boolean llIIlIlIIl();

    lIlIIIIlIl lllIIIlIlI();
}

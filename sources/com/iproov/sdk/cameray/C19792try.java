package com.iproov.sdk.cameray;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import p232do.C20821for;
import p232do.C20824new;
import p232do.C20825this;

/* renamed from: com.iproov.sdk.cameray.try */
/* compiled from: CameraAPI */
public interface C19792try {

    /* renamed from: com.iproov.sdk.cameray.try$do */
    /* compiled from: CameraAPI */
    public interface C19793do {
        /* renamed from: do */
        void mo161942do();

        /* renamed from: do */
        void mo161943do(C19794if ifVar, Exception exc);

        /* renamed from: do */
        void mo161944do(C20821for forR);

        /* renamed from: do */
        void mo161945do(C20824new newR);

        /* renamed from: do */
        void mo161946do(C20825this thisR);

        /* renamed from: do */
        void mo161947do(Exception exc);

        /* renamed from: do */
        void mo161948do(boolean z);
    }

    /* renamed from: com.iproov.sdk.cameray.try$if */
    /* compiled from: CameraAPI */
    public enum C19794if {
        FAILED_TO_LOCK_EXPOSURE,
        FAILED_TO_STOP_GRACEFULLY,
        FAILED_TO_READ_EXIF_DATA,
        FAILED_TO_TAKE_PICTURE
    }

    /* renamed from: do */
    void mo161898do();

    /* renamed from: do */
    void mo161899do(RectF rectF);

    /* renamed from: do */
    void mo161900do(SurfaceTexture surfaceTexture);

    /* renamed from: do */
    void mo161902do(Runnable runnable);

    /* renamed from: do */
    void mo161903do(boolean z);

    /* renamed from: for  reason: not valid java name */
    void m47473for();

    /* renamed from: if */
    C19775const mo161905if();

    /* renamed from: new  reason: not valid java name */
    C20824new m47474new();
}

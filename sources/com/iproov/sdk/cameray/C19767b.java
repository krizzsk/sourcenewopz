package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import java.util.List;
import p232do.C20820else;
import p232do.C20822goto;

/* renamed from: com.iproov.sdk.cameray.b */
/* compiled from: Camera2Request */
class C19767b {

    /* renamed from: a */
    private static final String f54003a = ("🎥2 " + C19767b.class.getSimpleName());

    /* renamed from: b */
    private CaptureRequest.Builder f54004b;

    C19767b(CameraDevice cameraDevice, C19780for forR, List<Surface> list, C20822goto gotoR, RectF rectF) throws CameraAccessException {
        this.f54004b = cameraDevice.createCaptureRequest(1);
        for (Surface addTarget : list) {
            this.f54004b.addTarget(addTarget);
        }
        this.f54004b.set(CaptureRequest.CONTROL_AF_MODE, 4);
        this.f54004b.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, forR.mo161921b());
        double d = gotoR.mo162091do(C19775const.CAMERA2, forR.m47462for());
        if (d > 1.0d) {
            this.f54004b.set(CaptureRequest.SCALER_CROP_REGION, C20820else.m41010do(forR.m47464try(), Double.valueOf(d)));
        }
        mo161894a(false);
        mo161892a(m38666a(rectF, forR.m47464try(), 1000));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161894a(boolean z) {
        this.f54004b.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z));
        this.f54004b.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(z));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161892a(MeteringRectangle meteringRectangle) {
        this.f54004b.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        StringBuilder sb = new StringBuilder();
        sb.append("Set metering area (");
        sb.append(meteringRectangle);
        sb.append(") OK");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161893a(Surface surface) {
        this.f54004b.removeTarget(surface);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CaptureRequest mo161891a() {
        return this.f54004b.build();
    }

    /* renamed from: a */
    public static MeteringRectangle m38666a(RectF rectF, Rect rect, int i) {
        return new MeteringRectangle(Math.max(0, (int) (rectF.left * ((float) rect.width()))), Math.max(0, (int) (rectF.top * ((float) rect.height()))), Math.min(rect.width(), (int) (rectF.width() * ((float) rect.width()))), Math.min(rect.height(), (int) (rectF.height() * ((float) rect.height()))), i);
    }
}

package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.catch */
/* compiled from: CameraLevel */
public enum C19773catch {
    CAMERA1(C19775const.CAMERA1),
    CAMERA2_LEGACY(r2),
    CAMERA2_EXTERNAL(r2),
    CAMERA2_LIMITED(r2),
    CAMERA2_FULL(r2),
    CAMERA2_LEVEL3(r2);

    private C19773catch(C19775const constR) {
    }

    /* renamed from: do */
    public boolean mo161896do(C19773catch catchR) {
        return compareTo(catchR) >= 0;
    }
}

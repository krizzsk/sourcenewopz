package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.case */
/* compiled from: CameraException */
public class C19771case extends Exception {

    /* renamed from: com.iproov.sdk.cameray.case$do */
    /* compiled from: CameraException */
    public enum C19772do {
        CAMERA_PERMISSION_DENIED,
        CAMERA_ERROR
    }

    public C19771case(C19772do doVar, String str) {
        super(str);
    }

    public C19771case(C19772do doVar, String str, Throwable th) {
        super(str, th);
    }

    public C19771case(C19772do doVar, Throwable th) {
        super(th);
    }
}

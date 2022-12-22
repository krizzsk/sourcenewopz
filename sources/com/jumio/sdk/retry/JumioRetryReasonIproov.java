package com.jumio.sdk.retry;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, mo175978d2 = {"Lcom/jumio/sdk/retry/JumioRetryReasonIproov;", "", "", "AMBIGUOUS_OUTCOME", "I", "MOTION_TOO_MUCH", "LIGHTING_FLASH", "LIGHTING_BACKLIT", "LIGHTING_TOO_DARK", "LIGHTING_TOO_BRIGHT", "MOTION_MOUTH", "GENERIC_FAILURE", "CAMERA", "CAMERA_PERMISSION", "CAPTURE_ALREADY_ACTIVE", "UNEXPECTED_ERROR", "SERVER", "NETWORK", "UNSUPPORTED_DEVICE", "FACE_DETECTOR", "MULTI_WINDOW", "GENERIC_ERROR", "<init>", "()V", "jumio-iproov_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioRetryReasonIproov.kt */
public final class JumioRetryReasonIproov {
    public static final int AMBIGUOUS_OUTCOME = 100;
    public static final int CAMERA = 200;
    public static final int CAMERA_PERMISSION = 201;
    public static final int CAPTURE_ALREADY_ACTIVE = 202;
    public static final int FACE_DETECTOR = 207;
    public static final int GENERIC_ERROR = 209;
    public static final int GENERIC_FAILURE = 107;
    public static final JumioRetryReasonIproov INSTANCE = new JumioRetryReasonIproov();
    public static final int LIGHTING_BACKLIT = 103;
    public static final int LIGHTING_FLASH = 102;
    public static final int LIGHTING_TOO_BRIGHT = 105;
    public static final int LIGHTING_TOO_DARK = 104;
    public static final int MOTION_MOUTH = 106;
    public static final int MOTION_TOO_MUCH = 101;
    public static final int MULTI_WINDOW = 208;
    public static final int NETWORK = 205;
    public static final int SERVER = 204;
    public static final int UNEXPECTED_ERROR = 203;
    public static final int UNSUPPORTED_DEVICE = 206;

    private JumioRetryReasonIproov() {
    }
}

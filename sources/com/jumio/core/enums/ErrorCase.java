package com.jumio.core.enums;

import androidx.exifinterface.media.ExifInterface;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, mo175978d2 = {"Lcom/jumio/core/enums/ErrorCase;", "", "", "a", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "", "b", "I", "getMessage", "()I", "message", "", "c", "Z", "getRetry", "()Z", "retry", "<init>", "(Ljava/lang/String;ILjava/lang/String;IZ)V", "GENERAL_NETWORK_ERROR", "CERTIFICATE_ERROR", "AUTH_FAILED", "DEVICE_IS_OFFLINE", "OCR_LOADING_FAILED", "CANCEL_TYPE_USER", "NO_CAMERA_CONNECTION", "ALE_KEY_NOT_VALID", "TRANSACTION_FINISHED", "PROCESS_CANT_BE_COMPLETED", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ErrorCase.kt */
public enum ErrorCase {
    GENERAL_NETWORK_ERROR(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, R.string.jumio_error_case_network_problems, true),
    CERTIFICATE_ERROR("B", R.string.jumio_error_case_auth_failed, false),
    AUTH_FAILED("C", R.string.jumio_error_case_auth_failed, false),
    DEVICE_IS_OFFLINE(ExifInterface.LONGITUDE_EAST, R.string.jumio_error_case_device_is_offline, true),
    OCR_LOADING_FAILED("F", R.string.jumio_error_case_ocr_failed, false),
    CANCEL_TYPE_USER("G", R.string.jumio_error_case_cancelled_by_user, false),
    NO_CAMERA_CONNECTION("H", R.string.jumio_error_case_no_camera_connection, false),
    ALE_KEY_NOT_VALID("I", R.string.jumio_error_case_certificate_not_valid_anymore, false),
    TRANSACTION_FINISHED("J", R.string.jumio_error_case_session_expired, false),
    PROCESS_CANT_BE_COMPLETED("N", R.string.jumio_error_case_ocr_failed, false);
    

    /* renamed from: a */
    public final String f54690a;

    /* renamed from: b */
    public final int f54691b;

    /* renamed from: c */
    public final boolean f54692c;

    /* access modifiers changed from: public */
    ErrorCase(String str, int i, boolean z) {
        this.f54690a = str;
        this.f54691b = i;
        this.f54692c = z;
    }

    public final String getDomain() {
        return this.f54690a;
    }

    public final int getMessage() {
        return this.f54691b;
    }

    public final boolean getRetry() {
        return this.f54692c;
    }
}

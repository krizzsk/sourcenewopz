package jumio.iproov;

import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.core.exception.CaptureAlreadyActiveException;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.MultiWindowUnsupportedException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.core.exception.UnsupportedDeviceException;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.iproov.a */
/* compiled from: IproovScanPart.kt */
public enum C21398a {
    CAMERA_PERMISSION(C21490Reflection.getOrCreateKotlinClass(CameraPermissionException.class).getSimpleName(), 201),
    CAPTURE_ALREADY_ACTIVE(C21490Reflection.getOrCreateKotlinClass(CaptureAlreadyActiveException.class).getSimpleName(), 202),
    UNEXPECTED_ERROR(C21490Reflection.getOrCreateKotlinClass(UnexpectedErrorException.class).getSimpleName(), 203),
    SERVER(C21490Reflection.getOrCreateKotlinClass(ServerException.class).getSimpleName(), 204),
    NETWORK(C21490Reflection.getOrCreateKotlinClass(NetworkException.class).getSimpleName(), 205),
    CAMERA(C21490Reflection.getOrCreateKotlinClass(CameraException.class).getSimpleName(), 200),
    UNSUPPORTED_DEVICE(C21490Reflection.getOrCreateKotlinClass(UnsupportedDeviceException.class).getSimpleName(), 206),
    FACE_DETECTOR(C21490Reflection.getOrCreateKotlinClass(FaceDetectorException.class).getSimpleName(), 207),
    MULTI_WINDOW(C21490Reflection.getOrCreateKotlinClass(MultiWindowUnsupportedException.class).getSimpleName(), 208),
    GENERIC(C21490Reflection.getOrCreateKotlinClass(IProovException.class).getSimpleName(), 209);
    

    /* renamed from: c */
    public static final C21399a f59691c = null;

    /* renamed from: a */
    public final String f59703a;

    /* renamed from: b */
    public final int f59704b;

    /* renamed from: jumio.iproov.a$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C21399a {
        public C21399a() {
        }

        public /* synthetic */ C21399a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final C21398a mo175910a(IProovException iProovException) {
            C21398a aVar;
            if (iProovException == null || iProovException.getReason() == null) {
                return C21398a.GENERIC;
            }
            C21398a[] values = C21398a.values();
            int i = 0;
            int length = values.length;
            while (true) {
                if (i >= length) {
                    aVar = null;
                    break;
                }
                aVar = values[i];
                i++;
                if (Intrinsics.areEqual((Object) aVar.mo175908b(), (Object) iProovException.getClass().getSimpleName())) {
                    break;
                }
            }
            if (aVar == null) {
                return C21398a.GENERIC;
            }
            return aVar;
        }
    }

    /* access modifiers changed from: public */
    static {
        f59691c = new C21399a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    C21398a(String str, int i) {
        this.f59703a = str;
        this.f59704b = i;
    }

    /* renamed from: b */
    public final String mo175908b() {
        return this.f59703a;
    }

    /* renamed from: c */
    public final int mo175909c() {
        return this.f59704b;
    }
}

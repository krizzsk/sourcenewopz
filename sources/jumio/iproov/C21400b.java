package jumio.iproov;

import com.taxis99.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* renamed from: jumio.iproov.b */
/* compiled from: IproovScanPart.kt */
public enum C21400b {
    AMBIGUOUS_OUTCOME("ambiguous_outcome", 100, R.string.iproov__failure_ambiguous_outcome),
    MOTION_TOO_MUCH("motion_too_much_movement", 101, R.string.iproov__failure_motion_too_much_movement),
    LIGHTING_FLASH("lighting_flash_reflection_too_low", 102, R.string.iproov__failure_lighting_flash_reflection_too_low),
    LIGHTING_BACKLIT("lighting_backlit", 103, R.string.iproov__failure_lighting_backlit),
    LIGHTING_TOO_DARK("lighting_too_dark", 104, R.string.iproov__failure_lighting_too_dark),
    LIGHTING_TOO_BRIGHT("lighting_face_too_bright", 105, R.string.iproov__failure_lighting_face_too_bright),
    MOTION_MOUTH("motion_too_much_mouth_movement", 106, R.string.iproov__failure_motion_too_much_mouth_movement),
    GENERIC("generic", 107, R.string.iproov__error_unexpected_error);
    

    /* renamed from: d */
    public static final C21401a f59705d = null;

    /* renamed from: a */
    public final String f59715a;

    /* renamed from: b */
    public final int f59716b;

    /* renamed from: c */
    public final int f59717c;

    /* renamed from: jumio.iproov.b$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C21401a {
        public C21401a() {
        }

        public /* synthetic */ C21401a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final C21400b mo175914a(String str) {
            C21400b bVar;
            int i = 0;
            if (str == null || str.length() == 0) {
                return C21400b.GENERIC;
            }
            C21400b[] values = C21400b.values();
            int length = values.length;
            while (true) {
                if (i >= length) {
                    bVar = null;
                    break;
                }
                bVar = values[i];
                i++;
                if (StringsKt.equals(bVar.mo175911b(), str, true)) {
                    break;
                }
            }
            if (bVar == null) {
                return C21400b.GENERIC;
            }
            return bVar;
        }
    }

    /* access modifiers changed from: public */
    static {
        f59705d = new C21401a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    C21400b(String str, int i, int i2) {
        this.f59715a = str;
        this.f59716b = i;
        this.f59717c = i2;
    }

    /* renamed from: b */
    public final String mo175911b() {
        return this.f59715a;
    }

    /* renamed from: c */
    public final int mo175912c() {
        return this.f59716b;
    }

    /* renamed from: d */
    public final int mo175913d() {
        return this.f59717c;
    }
}

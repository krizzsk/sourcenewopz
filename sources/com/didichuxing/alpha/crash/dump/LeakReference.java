package com.didichuxing.alpha.crash.dump;

import com.didichuxing.alpha.crash.dump.LeakTraceElement;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

public final class LeakReference implements Serializable {
    public final String name;
    public final LeakTraceElement.Type type;
    public final String value;

    public LeakReference(LeakTraceElement.Type type2, String str, String str2) {
        this.type = type2;
        this.name = str;
        this.value = str2;
    }

    /* renamed from: com.didichuxing.alpha.crash.dump.LeakReference$1 */
    static /* synthetic */ class C150291 {

        /* renamed from: $SwitchMap$com$didichuxing$alpha$crash$dump$LeakTraceElement$Type */
        static final /* synthetic */ int[] f45571x5da7bb8e;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didichuxing.alpha.crash.dump.LeakTraceElement$Type[] r0 = com.didichuxing.alpha.crash.dump.LeakTraceElement.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45571x5da7bb8e = r0
                com.didichuxing.alpha.crash.dump.LeakTraceElement$Type r1 = com.didichuxing.alpha.crash.dump.LeakTraceElement.Type.ARRAY_ENTRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f45571x5da7bb8e     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.alpha.crash.dump.LeakTraceElement$Type r1 = com.didichuxing.alpha.crash.dump.LeakTraceElement.Type.STATIC_FIELD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f45571x5da7bb8e     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.alpha.crash.dump.LeakTraceElement$Type r1 = com.didichuxing.alpha.crash.dump.LeakTraceElement.Type.INSTANCE_FIELD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f45571x5da7bb8e     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didichuxing.alpha.crash.dump.LeakTraceElement$Type r1 = com.didichuxing.alpha.crash.dump.LeakTraceElement.Type.LOCAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.alpha.crash.dump.LeakReference.C150291.<clinit>():void");
        }
    }

    public String getDisplayName() {
        int i = C150291.f45571x5da7bb8e[this.type.ordinal()];
        if (i == 1) {
            return Const.jaLeft + this.name + Const.jaRight;
        } else if (i == 2 || i == 3) {
            return this.name;
        } else {
            if (i == 4) {
                return "<Java Local>";
            }
            throw new IllegalStateException("Unexpected type " + this.type + " name = " + this.name + " value = " + this.value);
        }
    }

    public String toString() {
        int i = C150291.f45571x5da7bb8e[this.type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "static " + getDisplayName() + " = " + this.value;
            } else if (i != 3) {
                if (i == 4) {
                    return getDisplayName();
                }
                throw new IllegalStateException("Unexpected type " + this.type + " name = " + this.name + " value = " + this.value);
            }
        }
        return getDisplayName() + " = " + this.value;
    }
}

package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, mo175979k = 4, mo175980mv = {1, 5, 1}, mo175982xi = 48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return C21978c.m45996a();
    }

    public static final int systemProp(String str, int i, int i2, int i3) {
        return C21979d.m45998a(str, i, i2, i3);
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        return C21979d.m46000a(str, j, j2, j3);
    }

    public static final String systemProp(String str) {
        return C21978c.m45997a(str);
    }

    public static final boolean systemProp(String str, boolean z) {
        return C21979d.m46002a(str, z);
    }
}

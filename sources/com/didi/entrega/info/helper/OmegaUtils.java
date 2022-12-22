package com.didi.entrega.info.helper;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/entrega/info/helper/OmegaUtils;", "", "()V", "DEFAULT_DURATION", "", "sLastTrackTime", "isFastSwTrack", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OmegaUtils.kt */
public final class OmegaUtils {
    public static final OmegaUtils INSTANCE = new OmegaUtils();

    /* renamed from: a */
    private static final long f20790a = 500;

    /* renamed from: b */
    private static long f20791b;

    private OmegaUtils() {
    }

    public final boolean isFastSwTrack() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f20791b < 500;
        if (!z) {
            f20791b = currentTimeMillis;
        }
        return z;
    }
}

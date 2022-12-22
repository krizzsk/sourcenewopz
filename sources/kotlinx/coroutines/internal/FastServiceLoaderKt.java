package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, mo175978d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastServiceLoader.kt */
public final class FastServiceLoaderKt {

    /* renamed from: a */
    private static final boolean f61524a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m47688constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m47688constructorimpl(ResultKt.createFailure(th));
        }
        f61524a = Result.m47695isSuccessimpl(obj);
    }

    public static final boolean getANDROID_DETECTED() {
        return f61524a;
    }
}

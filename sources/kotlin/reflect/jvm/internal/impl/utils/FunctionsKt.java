package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: functions.kt */
public final class FunctionsKt {

    /* renamed from: a */
    private static final Function1<Object, Object> f61194a = FunctionsKt$IDENTITY$1.INSTANCE;

    /* renamed from: b */
    private static final Function1<Object, Boolean> f61195b = FunctionsKt$ALWAYS_TRUE$1.INSTANCE;

    /* renamed from: c */
    private static final Function1<Object, Object> f61196c = FunctionsKt$ALWAYS_NULL$1.INSTANCE;

    /* renamed from: d */
    private static final Function1<Object, Unit> f61197d = FunctionsKt$DO_NOTHING$1.INSTANCE;

    /* renamed from: e */
    private static final Function2<Object, Object, Unit> f61198e = FunctionsKt$DO_NOTHING_2$1.INSTANCE;

    /* renamed from: f */
    private static final Function3<Object, Object, Object, Unit> f61199f = FunctionsKt$DO_NOTHING_3$1.INSTANCE;

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return f61195b;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return f61199f;
    }
}

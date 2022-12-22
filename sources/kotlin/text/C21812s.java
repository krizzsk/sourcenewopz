package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.text.s */
/* compiled from: StringBuilderJVM.kt */
final class C21812s {

    /* renamed from: a */
    public static final String f61280a;

    /* renamed from: b */
    public static final C21812s f61281b = new C21812s();

    static {
        String property = System.getProperty("line.separator");
        Intrinsics.checkNotNull(property);
        f61280a = property;
    }

    private C21812s() {
    }
}

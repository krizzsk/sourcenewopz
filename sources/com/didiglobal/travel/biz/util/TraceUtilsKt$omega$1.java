package com.didiglobal.travel.biz.util;

import com.didi.component.business.util.GlobalOmegaUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "eventId", "", "label", "params", "", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TraceUtils.kt */
final class TraceUtilsKt$omega$1 extends Lambda implements Function3<String, String, Map<String, ? extends Object>, Unit> {
    public static final TraceUtilsKt$omega$1 INSTANCE = new TraceUtilsKt$omega$1();

    TraceUtilsKt$omega$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (Map<String, ? extends Object>) (Map) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "label");
        Intrinsics.checkNotNullParameter(map, "params");
        boolean z = false;
        if (!(str.length() == 0)) {
            CharSequence charSequence = str2;
            if (charSequence.length() > 0) {
                z = true;
            }
            if (!z) {
                charSequence = null;
            }
            String str3 = (String) charSequence;
            if (!(!map.isEmpty())) {
                map = null;
            }
            GlobalOmegaUtils.trackEvent(str, str3, (Map<String, Object>) map);
        }
    }
}

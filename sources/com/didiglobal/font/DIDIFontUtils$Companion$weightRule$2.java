package com.didiglobal.font;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.IFontConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DIDIFontUtils.kt */
final class DIDIFontUtils$Companion$weightRule$2 extends Lambda implements Function0<String> {
    public static final DIDIFontUtils$Companion$weightRule$2 INSTANCE = new DIDIFontUtils$Companion$weightRule$2();

    DIDIFontUtils$Companion$weightRule$2() {
        super(0);
    }

    public final String invoke() {
        ServiceLoader<S> load = ServiceLoader.load(IFontConfig.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "support");
        for (S s : load) {
            Intrinsics.checkExpressionValueIsNotNull(s, "it");
            String weightRule = s.getWeightRule();
            String access$getTAG$cp = DIDIFontUtils.f50214a;
            SystemUtils.log(3, access$getTAG$cp, "@@@@@ is weightRule " + weightRule, (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion$weightRule$2", 79);
            if (!TextUtils.isEmpty(weightRule)) {
                return weightRule;
            }
        }
        return "{\"list\":[{\"type\":1,\"range\":{\"min\":0,\"max\":399}},{\"type\":2,\"range\":{\"min\":400,\"max\":599}},{\"type\":3,\"range\":{\"min\":600,\"max\":699}},{\"type\":4,\"range\":{\"min\":700}}]}";
    }
}

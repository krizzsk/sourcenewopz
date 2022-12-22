package com.didiglobal.font;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.IFontConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo175978d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/lang/Boolean;"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DIDIFontUtils.kt */
final class DIDIFontUtils$Companion$isFlutterSupport$2 extends Lambda implements Function0<Boolean> {
    public static final DIDIFontUtils$Companion$isFlutterSupport$2 INSTANCE = new DIDIFontUtils$Companion$isFlutterSupport$2();

    DIDIFontUtils$Companion$isFlutterSupport$2() {
        super(0);
    }

    public final Boolean invoke() {
        ServiceLoader<S> load = ServiceLoader.load(IFontConfig.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "support");
        Iterator it = load.iterator();
        if (!it.hasNext()) {
            return false;
        }
        IFontConfig iFontConfig = (IFontConfig) it.next();
        String access$getTAG$cp = DIDIFontUtils.f50214a;
        StringBuilder sb = new StringBuilder();
        sb.append("@@@@@ is flutter support ");
        Intrinsics.checkExpressionValueIsNotNull(iFontConfig, "it");
        sb.append(iFontConfig.isFlutterSupport());
        SystemUtils.log(3, access$getTAG$cp, sb.toString(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion$isFlutterSupport$2", 56);
        return iFontConfig.isSupport();
    }
}

package com.didiglobal.font;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.IFontConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Landroid/content/Context;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DIDIFontUtils.kt */
final class DIDIFontUtils$Companion$mContext$2 extends Lambda implements Function0<Context> {
    public static final DIDIFontUtils$Companion$mContext$2 INSTANCE = new DIDIFontUtils$Companion$mContext$2();

    DIDIFontUtils$Companion$mContext$2() {
        super(0);
    }

    public final Context invoke() {
        ServiceLoader<S> load = ServiceLoader.load(IFontConfig.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "context");
        Iterator it = load.iterator();
        if (!it.hasNext()) {
            return null;
        }
        IFontConfig iFontConfig = (IFontConfig) it.next();
        String access$getTAG$cp = DIDIFontUtils.f50214a;
        StringBuilder sb = new StringBuilder();
        sb.append("@@@@@ is flutter context ");
        Intrinsics.checkExpressionValueIsNotNull(iFontConfig, "it");
        sb.append(iFontConfig.getContext());
        SystemUtils.log(3, access$getTAG$cp, sb.toString(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion$mContext$2", 90);
        return iFontConfig.getContext();
    }
}

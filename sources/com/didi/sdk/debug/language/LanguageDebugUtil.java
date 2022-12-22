package com.didi.sdk.debug.language;

import android.content.Context;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/LanguageDebugUtil;", "", "()V", "KEY_AREA", "", "KEY_LANGUAGE", "getSettingForDebug", "Ljava/util/Locale;", "context", "Landroid/content/Context;", "putArea", "", "value", "putLanguage", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageDebugUtil.kt */
public final class LanguageDebugUtil {
    public static final LanguageDebugUtil INSTANCE = new LanguageDebugUtil();

    /* renamed from: a */
    private static final String f35804a = "key_language_debug";

    /* renamed from: b */
    private static final String f35805b = "key_area_debug";

    private LanguageDebugUtil() {
    }

    public final void putLanguage(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "value");
        SPUtils.put(context, f35804a, str);
    }

    public final void putArea(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "value");
        SPUtils.put(context, f35805b, str);
    }

    public final Locale getSettingForDebug(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = (String) SPUtils.get(context, f35804a, "");
        String str2 = (String) SPUtils.get(context, f35805b, "");
        if (TextUtil.isEmpty(str) || TextUtil.isEmpty(str2)) {
            return null;
        }
        return new Locale(str, str2);
    }
}

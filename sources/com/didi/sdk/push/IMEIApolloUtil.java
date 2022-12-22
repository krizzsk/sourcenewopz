package com.didi.sdk.push;

import com.didichuxing.apollo.sdk.Apollo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/sdk/push/IMEIApolloUtil;", "", "()V", "isLoad", "", "needClearIMEI", "needClear", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMEIApolloUtil.kt */
public final class IMEIApolloUtil {
    public static final IMEIApolloUtil INSTANCE = new IMEIApolloUtil();
    private static boolean isLoad;
    private static boolean needClearIMEI;

    private IMEIApolloUtil() {
    }

    public final boolean needClear() {
        if (!isLoad) {
            needClearIMEI = Apollo.getToggle("APP_clear_imei").allow();
            isLoad = true;
        }
        return needClearIMEI;
    }
}

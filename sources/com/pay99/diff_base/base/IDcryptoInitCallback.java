package com.pay99.diff_base.base;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, mo175978d2 = {"Lcom/pay99/diff_base/base/IDcryptoInitCallback;", "", "doLogin", "", "context", "Landroid/content/Context;", "getParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTerminalId", "isLogin", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IDcrypto.kt */
public interface IDcryptoInitCallback {
    void doLogin(Context context);

    HashMap<String, Object> getParams(Context context);

    Object getTerminalId(Context context);

    boolean isLogin(Context context);
}

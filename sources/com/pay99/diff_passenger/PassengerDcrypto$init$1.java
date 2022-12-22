package com.pay99.diff_passenger;

import android.content.Context;
import com.didi.dcrypto.util.network.CommonProxyHolder;
import com.pay99.diff_base.base.IDcryptoInitCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"com/pay99/diff_passenger/PassengerDcrypto$init$1", "Lcom/didi/dcrypto/util/network/CommonProxyHolder$ICommonProxy;", "doLogin", "", "context", "Landroid/content/Context;", "getBaseParams", "Ljava/util/HashMap;", "", "", "getTerminalId", "isLogin", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerDcrypto.kt */
public final class PassengerDcrypto$init$1 implements CommonProxyHolder.ICommonProxy {
    final /* synthetic */ IDcryptoInitCallback $callback;

    PassengerDcrypto$init$1(IDcryptoInitCallback iDcryptoInitCallback) {
        this.$callback = iDcryptoInitCallback;
    }

    public HashMap<String, Object> getBaseParams(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$callback.getParams(context);
    }

    public boolean isLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$callback.isLogin(context);
    }

    public void doLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.$callback.doLogin(context);
    }

    public Object getTerminalId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.$callback.getTerminalId(context);
    }
}

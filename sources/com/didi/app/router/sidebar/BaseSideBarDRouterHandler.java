package com.didi.app.router.sidebar;

import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.DebugUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "TAG", "", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "debugLog", "text", "handle", "isLogin", "", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseSideBarDRouterHandler.kt */
public abstract class BaseSideBarDRouterHandler implements IRouterHandler {

    /* renamed from: a */
    private final String f8677a = "SideBarDRouterHandler";

    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = request.getUri();
        String uri2 = uri == null ? null : uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "request?.uri?.toString()");
        m5809a(uri2);
        if (!m5810a()) {
            m5809a("not login");
        } else {
            callRealHandle(request, result);
        }
    }

    /* renamed from: a */
    private final boolean m5810a() {
        NationComponentData.LoginInfo loginInfo;
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        if (nationComponentData == null || (loginInfo = nationComponentData.getLoginInfo()) == null) {
            return false;
        }
        return loginInfo.isLoginNow();
    }

    /* renamed from: a */
    private final void m5809a(String str) {
        if (DebugUtils.isDebug()) {
            SystemUtils.log(3, this.f8677a, str, (Throwable) null, "com.didi.app.router.sidebar.BaseSideBarDRouterHandler", 40);
        }
    }
}

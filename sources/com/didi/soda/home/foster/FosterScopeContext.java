package com.didi.soda.home.foster;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/home/foster/FosterScopeContext;", "Lcom/didi/app/nova/skeleton/ScopeContext;", "()V", "mAttached", "Landroidx/collection/ArrayMap;", "", "", "addObserver", "", "observer", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "alias", "attach", "key", "obj", "detach", "detachAll", "", "getBundle", "Landroid/os/Bundle;", "getLiveHandler", "Lcom/didi/app/nova/skeleton/LiveHandler;", "getNavigator", "Lcom/didi/app/nova/skeleton/INavigator;", "getObject", "getParent", "log", "msg", "removeObserver", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FosterScopeContext.kt */
public final class FosterScopeContext implements ScopeContext {

    /* renamed from: a */
    private final ArrayMap<String, Object> f42648a = new ArrayMap<>();

    /* renamed from: a */
    private final void m30127a(String str) {
        LogUtil.m29104i("FosterScopeContext", Intrinsics.stringPlus("调用了 FosterScopeContext msg = ", str));
    }

    public String alias() {
        m30127a("alias");
        return "";
    }

    public Bundle getBundle() {
        m30127a("getBundle");
        return new Bundle();
    }

    public INavigator getNavigator() {
        m30127a("getNavigator");
        return new C13979b();
    }

    public LiveHandler getLiveHandler() {
        m30127a("getLiveHandler");
        return new C13978a();
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        Intrinsics.checkNotNullParameter(iScopeLifecycle, "observer");
        m30127a("addObserver");
        return false;
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        Intrinsics.checkNotNullParameter(iScopeLifecycle, "observer");
        m30127a("removeObserver");
        return false;
    }

    public ScopeContext getParent() {
        m30127a("getParent");
        return null;
    }

    public Object attach(String str, Object obj) {
        m30127a("attach");
        return this.f42648a.put(str, obj);
    }

    public Object detach(String str) {
        m30127a(SDKConsts.ACTION_VALUE_DETACH);
        return this.f42648a.remove(str);
    }

    public Object getObject(String str) {
        m30127a("getObject");
        return this.f42648a.get(str);
    }

    public void detachAll() {
        m30127a("detachAll");
        this.f42648a.clear();
    }
}

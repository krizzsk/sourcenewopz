package com.didi.soda.blocks.scope;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/blocks/scope/SampleScopeContext;", "Lcom/didi/app/nova/skeleton/ScopeContext;", "()V", "mAttached", "Landroidx/collection/ArrayMap;", "", "", "addObserver", "", "observer", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "alias", "attach", "key", "obj", "detach", "detachAll", "", "getBundle", "Landroid/os/Bundle;", "getLiveHandler", "Lcom/didi/app/nova/skeleton/LiveHandler;", "getNavigator", "Lcom/didi/app/nova/skeleton/INavigator;", "getObject", "getParent", "log", "msg", "removeObserver", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SampleScopeContext.kt */
public final class SampleScopeContext implements ScopeContext {
    private final ArrayMap<String, Object> mAttached = new ArrayMap<>();

    private final void log(String str) {
        IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
        if (logger != null) {
            logger.debug("SampleScopeContext", "调用了" + str + " 方法");
        }
    }

    public String alias() {
        log("alias");
        return "";
    }

    public Bundle getBundle() {
        log("getBundle");
        return new Bundle();
    }

    public INavigator getNavigator() {
        log("getNavigator");
        return new FosterNavigator();
    }

    public LiveHandler getLiveHandler() {
        log("getLiveHandler");
        return new FosterLiveHandle();
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        Intrinsics.checkParameterIsNotNull(iScopeLifecycle, "observer");
        log("addObserver");
        return false;
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        Intrinsics.checkParameterIsNotNull(iScopeLifecycle, "observer");
        log("removeObserver");
        return false;
    }

    public ScopeContext getParent() {
        log("getParent");
        return null;
    }

    public Object attach(String str, Object obj) {
        log("attach");
        return this.mAttached.put(str, obj);
    }

    public Object detach(String str) {
        log(SDKConsts.ACTION_VALUE_DETACH);
        return this.mAttached.remove(str);
    }

    public Object getObject(String str) {
        log("getObject");
        return this.mAttached.get(str);
    }

    public void detachAll() {
        log("detachAll");
        this.mAttached.clear();
    }
}

package com.didi.soda.blocks;

import com.didi.app.nova.skeleton.ScopeContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00062\u001e\u0010\u001c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\tJ.\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00062\u001e\u0010\u001c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\u0002`\tJ\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002R?\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t0\u00058FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR?\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\u0002`\t0\u00058FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/blocks/BinderRootConfig;", "T", "", "()V", "commonCallBacks", "", "", "Lkotlin/Function1;", "", "Lcom/didi/soda/blocks/BinderCallBack;", "getCommonCallBacks", "()Ljava/util/Map;", "commonCallBacks$delegate", "Lkotlin/Lazy;", "configs", "getConfigs", "configs$delegate", "otherCallBacks", "getOtherCallBacks", "otherCallBacks$delegate", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "addCommonCallBack", "callBackName", "callback", "addOtherCallBack", "setConfig", "configName", "configValue", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BinderRootConfig.kt */
public final class BinderRootConfig<T> {
    private final Lazy commonCallBacks$delegate = LazyKt.lazy(BinderRootConfig$commonCallBacks$2.INSTANCE);
    private final Lazy configs$delegate = LazyKt.lazy(BinderRootConfig$configs$2.INSTANCE);
    private final Lazy otherCallBacks$delegate = LazyKt.lazy(BinderRootConfig$otherCallBacks$2.INSTANCE);
    private ScopeContext scopeContext;

    public final Map<String, Function1<T, Unit>> getCommonCallBacks() {
        return (Map) this.commonCallBacks$delegate.getValue();
    }

    public final Map<String, Object> getConfigs() {
        return (Map) this.configs$delegate.getValue();
    }

    public final Map<String, Function1<Object, Unit>> getOtherCallBacks() {
        return (Map) this.otherCallBacks$delegate.getValue();
    }

    public final ScopeContext getScopeContext() {
        return this.scopeContext;
    }

    public final void setScopeContext(ScopeContext scopeContext2) {
        this.scopeContext = scopeContext2;
    }

    public final void setConfig(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "configName");
        Intrinsics.checkParameterIsNotNull(obj, "configValue");
        getConfigs().put(str, obj);
    }

    public final void addCommonCallBack(String str, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "callBackName");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        getCommonCallBacks().put(str, function1);
    }

    public final void addOtherCallBack(String str, Function1<Object, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "callBackName");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        getOtherCallBacks().put(str, function1);
    }
}

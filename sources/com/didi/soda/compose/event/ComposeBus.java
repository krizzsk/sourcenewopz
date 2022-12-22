package com.didi.soda.compose.event;

import com.didi.app.nova.skeleton.ScopeContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/compose/event/ComposeBus;", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "mComposeStore", "Lcom/didi/soda/compose/event/ComposeStore;", "mScopeContext", "subscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/didi/soda/compose/event/IComposeHandler;", "onDestroy", "", "post", "action", "Lcom/didi/soda/compose/event/ComposeAction;", "register", "type", "handler", "unRegister", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComposeBus.kt */
public class ComposeBus {

    /* renamed from: a */
    private ScopeContext f40123a;

    /* renamed from: b */
    private ComposeStore f40124b = new ComposeStore();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ConcurrentHashMap<String, IComposeHandler> f40125c = new ConcurrentHashMap<>();

    public ComposeBus(ScopeContext scopeContext) {
        Intrinsics.checkParameterIsNotNull(scopeContext, "scopeContext");
        this.f40123a = scopeContext;
    }

    public final void post(ComposeAction composeAction) {
        Intrinsics.checkParameterIsNotNull(composeAction, "action");
        ComposeStore composeStore = this.f40124b;
        if (composeStore != null) {
            composeStore.setValue(composeAction);
        }
    }

    public final void register(String str, IComposeHandler iComposeHandler) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(iComposeHandler, "handler");
        ComposeStore composeStore = this.f40124b;
        if (composeStore != null) {
            composeStore.subscribe(this.f40123a, new ComposeBus$register$1(this, str));
        }
        this.f40125c.put(str, iComposeHandler);
    }

    public final void unRegister(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        this.f40125c.remove(str);
    }

    public final void onDestroy() {
        this.f40125c.clear();
        this.f40124b = null;
        this.f40123a = null;
    }
}

package com.didi.drouter.remote;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterExecutor;
import com.didi.drouter.utils.RouterLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.drouter.remote.a */
/* compiled from: RemoteDispatcher */
class C7935a {

    /* renamed from: a */
    private static final AtomicInteger f19170a = new AtomicInteger(0);

    /* renamed from: b */
    private final RemoteResult f19171b = new RemoteResult("executing");

    C7935a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RemoteResult mo58811a(RemoteCommand remoteCommand) {
        f19170a.incrementAndGet();
        RouterLogger.getCoreLogger().mo59000d("[Service] command \"%s\" start, thread count %s", remoteCommand, Integer.valueOf(f19170a.get()));
        if (f19170a.get() >= 16) {
            RouterLogger.getCoreLogger().mo59001e("[Service] binder thread pool is exploding", remoteCommand, Integer.valueOf(f19170a.get()));
        }
        if (remoteCommand.f19145h != null) {
            if (f19170a.get() >= 16) {
                RouterExecutor.submit(new RemoteDispatcher$1(this, remoteCommand));
            } else {
                m14348b(remoteCommand);
            }
        } else if (remoteCommand.f19151n != null) {
            m14349c(remoteCommand);
        }
        f19170a.decrementAndGet();
        return this.f19171b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14348b(RemoteCommand remoteCommand) {
        Request build = DRouter.build(remoteCommand.f19145h);
        if (remoteCommand.f19149l != null) {
            build.extra = remoteCommand.f19149l;
        }
        if (remoteCommand.f19150m != null) {
            build.addition = remoteCommand.f19150m;
        }
        build.start(DRouter.getContext(), new RemoteDispatcher$2(this, remoteCommand));
        this.f19171b.f19168d = "success";
    }

    /* renamed from: c */
    private void m14349c(RemoteCommand remoteCommand) {
        Object service = DRouter.build(remoteCommand.f19151n).setAlias(remoteCommand.f19152o).setFeature(remoteCommand.f19153p).getService(remoteCommand.f19155r);
        RouterLogger coreLogger = RouterLogger.getCoreLogger();
        Object[] objArr = new Object[2];
        objArr[0] = service != null ? service.getClass().getSimpleName() : null;
        objArr[1] = remoteCommand.f19154q;
        coreLogger.mo59000d("[Service] use drouter to build new service \"%s\", and start invoke method \"%s\"", objArr);
        if (service != null) {
            try {
                this.f19171b.f19169e = ReflectUtil.invokeMethod(service, remoteCommand.f19154q, remoteCommand.f19156s);
                this.f19171b.f19168d = "success";
                return;
            } catch (Exception e) {
                RouterLogger.getCoreLogger().mo59001e("[Service] invoke Exception %s", e);
            }
        }
        this.f19171b.f19168d = "fail";
    }
}

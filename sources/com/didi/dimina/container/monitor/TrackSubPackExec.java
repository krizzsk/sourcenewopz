package com.didi.dimina.container.monitor;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;

public class TrackSubPackExec implements IDMCommonAction<Void> {

    /* renamed from: a */
    IDMCommonAction<Void> f16962a;

    /* renamed from: b */
    String f16963b;

    /* renamed from: c */
    String f16964c;

    /* renamed from: d */
    DMMina f16965d;

    /* renamed from: e */
    long f16966e = TimeUtil.currentNanoMillis();

    public TrackSubPackExec(DMMina dMMina, String str, IDMCommonAction<Void> iDMCommonAction) {
        this.f16962a = iDMCommonAction;
        this.f16963b = str;
        this.f16964c = dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().getTag();
        this.f16965d = dMMina;
        trackTechSagaSubPkgExecStart();
    }

    public void callback(Void voidR) {
        trackTechSagaSubPkgExecSuccess();
        this.f16962a.callback(voidR);
    }

    public void trackTechSagaSubPkgExecStart() {
        TraceUtil.trackTechSagaSubPkgExecStart(this.f16965d.getMinaIndex(), this.f16964c, this.f16963b, !this.f16965d.getPerformance().isFirstDomReady());
    }

    public void trackTechSagaSubPkgExecSuccess() {
        long currentNanoMillis = TimeUtil.currentNanoMillis() - this.f16966e;
        this.f16965d.getPerformance().appendStartSubPackageLoadExec(currentNanoMillis);
        TraceUtil.trackTechSagaSubPkgExecSuccess(this.f16965d.getMinaIndex(), this.f16964c, this.f16963b, currentNanoMillis, !this.f16965d.getPerformance().isFirstDomReady());
    }
}

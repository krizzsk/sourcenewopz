package com.didichuxing.apollo.sdk.log;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import java.util.Random;

public class LogDelegateWrapper implements ILogDelegate {

    /* renamed from: a */
    private ILogDelegate f45625a;

    /* renamed from: b */
    private final Random f45626b = new Random();

    public LogDelegateWrapper(ILogDelegate iLogDelegate) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "rate logger init");
        this.f45625a = iLogDelegate;
    }

    public void saveLog(ApolloLog apolloLog) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "use rate logger");
        Integer logRate = apolloLog.getLogRate();
        if (logRate != null && logRate.intValue() > 0 && logRate.intValue() <= 1000 && this.f45625a != null && this.f45626b.nextInt(1000) < logRate.intValue()) {
            this.f45625a.saveLog(apolloLog);
        }
    }

    public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
        ILogDelegate iLogDelegate;
        if (this.f45626b.nextInt(100) == 0 && (iLogDelegate = this.f45625a) != null) {
            iLogDelegate.saveErrorLog(apolloErrorLog);
        }
    }
}

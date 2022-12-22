package com.adyen.checkout.core.api;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ConnectionTask<T> extends FutureTask<T> {

    /* renamed from: a */
    private static final String f926a = LogUtil.getTag();

    /* renamed from: b */
    private final long f927b;

    protected ConnectionTask(Connection<T> connection) {
        this(connection, 0);
    }

    protected ConnectionTask(Connection<T> connection, long j) {
        super(connection);
        this.f927b = j;
    }

    public boolean cancel(boolean z) {
        String str = f926a;
        Logger.m1076d(str, "cancel - " + z);
        return super.cancel(z);
    }

    public void run() {
        if (this.f927b > 0) {
            String str = f926a;
            Logger.m1076d(str, "run with timeout - " + this.f927b);
        }
        super.run();
        long j = this.f927b;
        if (j > 0) {
            try {
                get(j, TimeUnit.MILLISECONDS);
            } catch (ExecutionException e) {
                Logger.m1077d(f926a, "ExecutionException", e);
            } catch (InterruptedException e2) {
                Logger.m1077d(f926a, "InterruptedException", e2);
            } catch (TimeoutException unused) {
                String str2 = f926a;
                Logger.m1078e(str2, "Task timed out after " + this.f927b + " milliseconds.");
                cancel(true);
            }
        }
    }
}

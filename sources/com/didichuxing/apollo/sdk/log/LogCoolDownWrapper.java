package com.didichuxing.apollo.sdk.log;

import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.dataprovider.DCache;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LogCoolDownWrapper implements ILogDelegate {
    public static final String CACHE_KEY_LOG_COOL_DOWN = "cache_key_log_cool_down";
    public static int COOL_DOWN_INTERVAL = 3600000;
    public static int FLUSH_INTERVAL = 60000;

    /* renamed from: a */
    private ILogDelegate f45619a;

    /* renamed from: b */
    private final Random f45620b = new Random();

    /* renamed from: c */
    private ScheduledFuture<?> f45621c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, String> f45622d;

    /* renamed from: e */
    private final ScheduledExecutorService f45623e = Executors.newScheduledThreadPool(1);

    /* renamed from: f */
    private volatile boolean f45624f = false;

    public LogCoolDownWrapper(ILogDelegate iLogDelegate) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "cool down logger init");
        this.f45619a = iLogDelegate;
    }

    public void saveLog(ApolloLog apolloLog) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "use cool down logger");
        HashMap<String, String> hashMap = this.f45622d;
        if (hashMap == null) {
            try {
                this.f45622d = (HashMap) DCache.getObject(CACHE_KEY_LOG_COOL_DOWN, hashMap.getClass());
            } catch (Exception unused) {
            }
            if (this.f45622d == null) {
                this.f45622d = new HashMap<>();
            }
        }
        if (!this.f45624f) {
            m32688a();
        }
        Long l = null;
        try {
            l = Long.valueOf(Long.parseLong(this.f45622d.get(apolloLog.getToggleName())));
        } catch (Exception unused2) {
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l == null || valueOf.longValue() - l.longValue() > ((long) COOL_DOWN_INTERVAL)) {
            this.f45622d.put(apolloLog.getToggleName(), valueOf.toString());
            this.f45619a.saveLog(apolloLog);
        }
    }

    public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
        ILogDelegate iLogDelegate;
        if (this.f45620b.nextInt(100) == 0 && (iLogDelegate = this.f45619a) != null) {
            iLogDelegate.saveErrorLog(apolloErrorLog);
        }
    }

    public void reset() {
        this.f45622d = new HashMap<>();
    }

    /* renamed from: a */
    private void m32688a() {
        if (!this.f45624f) {
            this.f45624f = true;
            C150531 r2 = new Runnable() {
                public void run() {
                    DCache.putObject(LogCoolDownWrapper.CACHE_KEY_LOG_COOL_DOWN, LogCoolDownWrapper.this.f45622d);
                }
            };
            ScheduledExecutorService scheduledExecutorService = this.f45623e;
            int i = FLUSH_INTERVAL;
            this.f45621c = scheduledExecutorService.scheduleAtFixedRate(r2, (long) i, (long) i, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    private void m32689b() {
        this.f45621c.cancel(true);
    }
}

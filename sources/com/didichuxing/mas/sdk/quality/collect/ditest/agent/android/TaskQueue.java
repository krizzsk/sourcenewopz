package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.NamedThreadFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskQueue {

    /* renamed from: a */
    private static final AgentLog f47897a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final long f47898b = 1000;

    /* renamed from: c */
    private static final ScheduledExecutorService f47899c = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));

    /* renamed from: d */
    private static final ConcurrentLinkedQueue<Object> f47900d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private static final Runnable f47901e = new Runnable() {
        public void run() {
            TaskQueue.m34218b();
        }
    };

    /* renamed from: f */
    private static Future f47902f;

    /* renamed from: g */
    private static boolean f47903g;

    public static void queue(Object obj) {
        if (f47903g) {
            f47900d.add(obj);
        } else {
            f47897a.debug("drop data!");
        }
    }

    public static void backgroundDequeue() {
        f47899c.execute(f47901e);
    }

    public static void synchronousDequeue() {
        try {
            f47899c.submit(f47901e).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public static void start() {
        if (f47902f == null) {
            f47902f = f47899c.scheduleAtFixedRate(f47901e, 0, 1000, TimeUnit.MILLISECONDS);
        }
        f47903g = true;
    }

    public static void stop() {
        Future future = f47902f;
        if (future != null) {
            future.cancel(true);
            f47902f = null;
        }
        f47903g = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m34218b() {
        if (f47900d.size() != 0) {
            while (!f47900d.isEmpty()) {
                try {
                    Object remove = f47900d.remove();
                    if (remove instanceof HttpTransactionMeasurement) {
                        Measurements.addHttpTransaction((HttpTransactionMeasurement) remove);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int size() {
        return f47900d.size();
    }

    public static void clear() {
        f47900d.clear();
    }
}

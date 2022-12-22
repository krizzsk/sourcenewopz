package com.didichuxing.ditest.agent.android;

import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.ditest.agent.android.util.NamedThreadFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskQueue {
    private static final long DEQUEUE_PERIOD_MS = 1000;
    private static Future dequeueFuture;
    private static final Runnable dequeueTask = new Runnable() {
        public void run() {
            TaskQueue.dequeue();
        }
    };
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
    private static final ScheduledExecutorService queueExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));
    private static boolean queueStarted;

    public static void queue(Object obj) {
        if (queueStarted) {
            queue.add(obj);
        } else {
            log.debug("drop data!");
        }
    }

    public static void backgroundDequeue() {
        queueExecutor.execute(dequeueTask);
    }

    public static void synchronousDequeue() {
        try {
            queueExecutor.submit(dequeueTask).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public static void start() {
        if (dequeueFuture == null) {
            dequeueFuture = queueExecutor.scheduleAtFixedRate(dequeueTask, 0, 1000, TimeUnit.MILLISECONDS);
        }
        queueStarted = true;
    }

    public static void stop() {
        Future future = dequeueFuture;
        if (future != null) {
            future.cancel(true);
            dequeueFuture = null;
        }
        queueStarted = false;
    }

    /* access modifiers changed from: private */
    public static void dequeue() {
        if (queue.size() != 0) {
            while (!queue.isEmpty()) {
                try {
                    Object remove = queue.remove();
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
        return queue.size();
    }

    public static void clear() {
        queue.clear();
    }
}

package com.didi.sdk.common;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayDeque;

public class TaskSchedulerImpl extends TaskScheduler {

    /* renamed from: a */
    private Logger f35630a = LoggerFactory.getLogger("TaskScheduler");

    /* renamed from: b */
    private final SparseArray<ArrayDeque<TaskInfo>> f35631b = new SparseArray<>();

    /* renamed from: c */
    private final Handler f35632c = new Handler(Looper.getMainLooper());

    TaskSchedulerImpl() {
    }

    public void scheduleUiTask(Runnable runnable, int i) {
        Logger logger = this.f35630a;
        logger.debug("scheduleUiTask when " + i, new Object[0]);
        m25235a(new TaskInfo(runnable, i, true));
    }

    public void scheduleBkgTask(Runnable runnable, int i) {
        Logger logger = this.f35630a;
        logger.debug("scheduleBkgTask when " + i, new Object[0]);
        m25235a(new TaskInfo(runnable, i, false));
    }

    /* renamed from: a */
    private synchronized void m25235a(TaskInfo taskInfo) {
        if ((this.mWhenFlag & taskInfo.f35627b) == 0) {
            this.f35630a.debug("add task to pending queue", new Object[0]);
            m25234a(taskInfo.f35627b).offerLast(taskInfo);
        } else {
            m25237b(taskInfo);
        }
    }

    public synchronized void notify(int i) {
        Logger logger = this.f35630a;
        logger.debug("notify when " + i, new Object[0]);
        if ((this.mWhenFlag & i) != 0) {
            Logger logger2 = this.f35630a;
            logger2.error(i + " has been notified before!", new Object[0]);
        }
        ArrayDeque<TaskInfo> b = m25236b(i);
        if (b != null) {
            while (!b.isEmpty()) {
                m25237b(b.pollFirst());
            }
        }
        this.mWhenFlag = i | this.mWhenFlag;
    }

    public synchronized void clear() {
        this.f35630a.debug("clear", new Object[0]);
        this.f35631b.clear();
        this.f35632c.removeCallbacks((Runnable) null);
        resetWhenFlag();
    }

    /* renamed from: b */
    private void m25237b(TaskInfo taskInfo) {
        if (taskInfo.f35628c) {
            this.f35630a.debug("post ui task", new Object[0]);
            this.f35632c.post(taskInfo.f35626a);
            return;
        }
        this.f35630a.debug("addBkgTask", new Object[0]);
        DDThreadPool.getInstance().addBkgTask(taskInfo.f35626a);
    }

    /* renamed from: a */
    private ArrayDeque<TaskInfo> m25234a(int i) {
        ArrayDeque<TaskInfo> arrayDeque = this.f35631b.get(i);
        if (arrayDeque != null) {
            return arrayDeque;
        }
        ArrayDeque<TaskInfo> arrayDeque2 = new ArrayDeque<>();
        this.f35631b.put(i, arrayDeque2);
        return arrayDeque2;
    }

    /* renamed from: b */
    private ArrayDeque<TaskInfo> m25236b(int i) {
        try {
            return this.f35631b.get(i);
        } finally {
            this.f35631b.remove(i);
        }
    }
}

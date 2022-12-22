package com.didichuxing.publicservice.network;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
    private static ThreadManager instance;
    private ThreadPoolProxy mBigPool;
    private ThreadPoolProxy mSmallPool;

    private ThreadManager() {
    }

    public static ThreadManager getInstance() {
        if (instance == null) {
            instance = new ThreadManager();
        }
        return instance;
    }

    public synchronized ThreadPoolProxy getInternetPool() {
        if (this.mBigPool == null) {
            this.mBigPool = new ThreadPoolProxy(5, 5, 5000);
        }
        return this.mBigPool;
    }

    public synchronized ThreadPoolProxy getLocalPool() {
        if (this.mSmallPool == null) {
            this.mSmallPool = new ThreadPoolProxy(2, 3, 5000);
        }
        return this.mSmallPool;
    }

    public class ThreadPoolProxy {
        private int corePoolSize;
        private ThreadPoolExecutor executor;
        private long existTime;
        private int maxPoolSize;
        private ArrayList<Runnable> tasks;

        public ThreadPoolProxy(int i, int i2, long j) {
            this.corePoolSize = i;
            this.maxPoolSize = i2;
            this.existTime = j;
        }

        public void execute(Runnable runnable) {
            if (runnable != null) {
                ThreadPoolExecutor threadPoolExecutor = this.executor;
                if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                    this.executor = new ThreadPoolExecutor(this.corePoolSize, this.maxPoolSize, this.existTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5));
                }
                if (this.tasks == null) {
                    this.tasks = new ArrayList<>();
                }
                try {
                    this.executor.submit(runnable);
                    this.tasks.add(runnable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopRunningTask(String str) {
            if (this.tasks != null) {
                int i = 0;
                while (i < this.tasks.size()) {
                    ThreadTask threadTask = (ThreadTask) this.tasks.get(i);
                    if (threadTask.getTag() == null || !threadTask.getTag().equals(str)) {
                        i++;
                    } else {
                        threadTask.stopTask();
                        return;
                    }
                }
            }
        }

        public void stopAllRunningTasks() {
            ArrayList<Runnable> arrayList = this.tasks;
            this.tasks = null;
            if (arrayList != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ((ThreadTask) arrayList.get(i)).stopTask();
                }
            }
        }

        public synchronized void shutdown() {
            if (this.executor != null && !this.executor.isShutdown() && !this.executor.isTerminating()) {
                this.executor.shutdownNow();
            }
        }
    }
}

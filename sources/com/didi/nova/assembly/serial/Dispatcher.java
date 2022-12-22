package com.didi.nova.assembly.serial;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

public class Dispatcher {

    public interface DispatchRunnable {
        void onMainThread();

        void onWorkThread();
    }

    public static Executor singleGroup() {
        return AsyncTask.SERIAL_EXECUTOR;
    }

    public static Executor poolGroup() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public static void async(Runnable runnable) {
        async(poolGroup(), runnable);
    }

    public static void async(Executor executor, Runnable runnable) {
        new InnerAsyncTask0().executeOnExecutor(executor, new Runnable[]{runnable});
    }

    public static void async(DispatchRunnable dispatchRunnable) {
        async(poolGroup(), dispatchRunnable);
    }

    public static void async(Executor executor, DispatchRunnable dispatchRunnable) {
        new InnerAsyncTask1().executeOnExecutor(executor, new DispatchRunnable[]{dispatchRunnable});
    }

    private static class InnerAsyncTask0 extends AsyncTask<Runnable, Void, Void> {
        private InnerAsyncTask0() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Runnable... runnableArr) {
            runnableArr[0].run();
            return null;
        }
    }

    private static class InnerAsyncTask1 extends AsyncTask<DispatchRunnable, Void, DispatchRunnable> {
        private InnerAsyncTask1() {
        }

        /* access modifiers changed from: protected */
        public DispatchRunnable doInBackground(DispatchRunnable... dispatchRunnableArr) {
            dispatchRunnableArr[0].onWorkThread();
            return dispatchRunnableArr[0];
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(DispatchRunnable dispatchRunnable) {
            dispatchRunnable.onMainThread();
        }
    }
}

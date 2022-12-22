package com.didi.hawaii.task;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.hawaii.basic.ApolloHawaii;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MapTask<Params, Progress, Result> {
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final InternalHandler sHandler = new InternalHandler(Looper.getMainLooper());
    public static final Executor sHighThreadExecutor = new HighPriorityExecutor();
    public static final Executor sLowThreadExecutor = new LowPriorityExecutor();
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                MapTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException("An error occured while executing doInBackground()", e.getCause());
            } catch (CancellationException unused2) {
                MapTask.this.postResultIfNotInvoked(null);
            }
        }
    };
    private boolean mIsLowPriority = true;
    /* access modifiers changed from: private */
    public volatile Status mStatus = Status.PENDING;
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        public Result call() throws Exception {
            MapTask.this.mTaskInvoked.set(true);
            return MapTask.this.postResult(MapTask.this.doInBackground(this.mParams));
        }
    };

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    public static void init() {
        sHandler.getLooper();
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        Message obtainMessage = sHandler.obtainMessage(1, new AsyncTaskResult(this, result));
        if (this.mIsLowPriority) {
            obtainMessage.sendToTarget();
        } else {
            sHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
        return result;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final MapTask<Params, Progress, Result> execute(Params... paramsArr) {
        return execute(true, paramsArr);
    }

    public final MapTask<Params, Progress, Result> execute(boolean z, Params... paramsArr) {
        this.mIsLowPriority = z;
        if (z) {
            return executeOnExecutor(sLowThreadExecutor, paramsArr);
        }
        return executeOnExecutor(sHighThreadExecutor, paramsArr);
    }

    public final void execute(long j, final Params... paramsArr) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (MapTask.this.mStatus == Status.PENDING) {
                    MapTask.this.execute((Params[]) paramsArr);
                }
            }
        }, j);
    }

    public final MapTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (!ApolloHawaii.getThreadPoolExecutorDisable()) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        if (this.mStatus != Status.PENDING) {
            int i = C92604.$SwitchMap$com$didi$hawaii$task$MapTask$Status[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    /* renamed from: com.didi.hawaii.task.MapTask$4 */
    static /* synthetic */ class C92604 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$hawaii$task$MapTask$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.hawaii.task.MapTask$Status[] r0 = com.didi.hawaii.task.MapTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$hawaii$task$MapTask$Status = r0
                com.didi.hawaii.task.MapTask$Status r1 = com.didi.hawaii.task.MapTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$hawaii$task$MapTask$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.hawaii.task.MapTask$Status r1 = com.didi.hawaii.task.MapTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.task.MapTask.C92604.<clinit>():void");
        }
    }

    public static void execute(Runnable runnable) {
        sLowThreadExecutor.execute(runnable);
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    private static class InternalHandler extends Handler {
        public InternalHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else if (i == 2) {
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }
    }

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final MapTask<?, ?, ?> mTask;

        AsyncTaskResult(MapTask<?, ?, ?> mapTask, Data... dataArr) {
            this.mTask = mapTask;
            this.mData = dataArr;
        }
    }

    private static class SerialExecutor implements Executor {
        Runnable mActive;
        final LinkedList<Runnable> mTasks = new LinkedList<>();

        private SerialExecutor() {
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                MapTask.sHighThreadExecutor.execute(this.mActive);
            }
        }
    }
}

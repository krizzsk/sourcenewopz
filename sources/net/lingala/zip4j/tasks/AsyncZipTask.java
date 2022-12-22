package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public abstract class AsyncZipTask<T> {

    /* renamed from: a */
    private ProgressMonitor f5033a;

    /* renamed from: b */
    private boolean f5034b;

    /* renamed from: c */
    private ExecutorService f5035c;

    /* access modifiers changed from: protected */
    public abstract long calculateTotalWork(T t) throws ZipException;

    /* access modifiers changed from: protected */
    public abstract void executeTask(T t, ProgressMonitor progressMonitor) throws IOException;

    /* access modifiers changed from: protected */
    public abstract ProgressMonitor.Task getTask();

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.f5033a = asyncTaskParameters.progressMonitor;
        this.f5034b = asyncTaskParameters.runInThread;
        this.f5035c = asyncTaskParameters.executorService;
    }

    public void execute(T t) throws ZipException {
        this.f5033a.fullReset();
        this.f5033a.setState(ProgressMonitor.State.BUSY);
        this.f5033a.setCurrentTask(getTask());
        if (this.f5034b) {
            this.f5033a.setTotalWork(calculateTotalWork(t));
            this.f5035c.execute(new Runnable(t) {
                public final /* synthetic */ Object f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AsyncZipTask.this.m3219a(this.f$1);
                }
            });
            return;
        }
        m3220a(t, this.f5033a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m3219a(Object obj) {
        try {
            m3220a(obj, this.f5033a);
        } catch (ZipException unused) {
        } catch (Throwable th) {
            this.f5035c.shutdown();
            throw th;
        }
        this.f5035c.shutdown();
    }

    /* renamed from: a */
    private void m3220a(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            executeTask(t, progressMonitor);
            progressMonitor.endProgressMonitor();
        } catch (ZipException e) {
            progressMonitor.endProgressMonitor(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor.endProgressMonitor(e2);
            throw new ZipException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void verifyIfTaskIsCancelled() throws ZipException {
        if (this.f5033a.isCancelAllTasks()) {
            this.f5033a.setResult(ProgressMonitor.Result.CANCELLED);
            this.f5033a.setState(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    public static class AsyncTaskParameters {
        /* access modifiers changed from: private */
        public ExecutorService executorService;
        /* access modifiers changed from: private */
        public ProgressMonitor progressMonitor;
        /* access modifiers changed from: private */
        public boolean runInThread;

        public AsyncTaskParameters(ExecutorService executorService2, boolean z, ProgressMonitor progressMonitor2) {
            this.executorService = executorService2;
            this.runInThread = z;
            this.progressMonitor = progressMonitor2;
        }
    }
}

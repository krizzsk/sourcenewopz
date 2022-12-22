package com.didi.beatles.p099im.task;

import android.os.AsyncTask;
import com.didi.beatles.p099im.module.IMErrorCallback;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.beatles.im.task.IMTaskJob */
public abstract class IMTaskJob<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int DEFAULT_ERROR = 100;
    private static final int KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE;
    private static final int MAX_QUNEN_NUM = 100;
    private static final String TAG = "IMTaskJob";
    private static final ThreadPoolExecutor sThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    private IMErrorCallback mErrorCallback;
    protected int mErrorCode;
    protected String mNetErrorMessage;
    private AsyncTask<Params, Progress, Result> mTask;
    protected Throwable mThrowable;

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 2;
        MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 2;
    }

    public void setError(Throwable th) {
        this.mErrorCode = 100;
    }

    public IMTaskJob() {
        init();
    }

    private void init() {
        try {
            this.mTask = new AsyncTask<Params, Progress, Result>() {
                /* access modifiers changed from: protected */
                public Result doInBackground(Params... paramsArr) {
                    return IMTaskJob.this._doJob(paramsArr);
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Result result) {
                    IMTaskJob.this._doOnPostExecute(result);
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setError(int i, Throwable th) {
        this.mErrorCode = i;
        this.mThrowable = th;
    }

    public void setError(int i) {
        this.mErrorCode = i;
    }

    public void setNetErrorMessage(String str) {
        this.mNetErrorMessage = str;
    }

    public boolean isSucceed() {
        return this.mErrorCode == 0;
    }

    /* access modifiers changed from: private */
    public Result _doJob(Params... paramsArr) {
        try {
            return doInBackground(paramsArr);
        } catch (Exception e) {
            IMLog.m6632e(TAG, "_doJob() exception called with: params = [" + paramsArr + Const.jaRight + e.getMessage());
            e.printStackTrace();
            setError(100, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void _doOnPostExecute(Result result) {
        onPostExecute(result);
    }

    public IMTaskJob<Params, Progress, Result> setErrorCallback(IMErrorCallback iMErrorCallback) {
        this.mErrorCallback = iMErrorCallback;
        return this;
    }

    public void execute(Params... paramsArr) {
        try {
            if (((ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR).getQueue().size() > 100) {
                this.mTask.executeOnExecutor(Executors.newCachedThreadPool(), paramsArr);
                IMLog.m6632e(TAG, "execute: use temporary thread pool since the task is too much!");
                return;
            }
            this.mTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
    }

    public void executeWithDatabase(Params... paramsArr) {
        try {
            if (sThreadPool.getQueue().size() > 100) {
                this.mTask.executeOnExecutor(Executors.newCachedThreadPool(), paramsArr);
                IMLog.m6632e(TAG, "execute: use temporary thread pool since the task is too much!");
                return;
            }
            this.mTask.executeOnExecutor(sThreadPool, paramsArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

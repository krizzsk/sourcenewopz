package com.didi.sdk.async;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.util.Pools;
import androidx.core.view.LayoutInflaterCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public class AsyncLayoutInflaterPlus {

    /* renamed from: a */
    private static final String f35265a = "AsyncLayoutInflaterPlus";

    /* renamed from: e */
    private static Pools.SynchronizedPool<InflateRequest> f35266e = new Pools.SynchronizedPool<>(20);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f35267b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LayoutInflater f35268c;

    /* renamed from: d */
    private InflateRunnable f35269d;

    /* renamed from: f */
    private Future<?> f35270f;

    /* renamed from: g */
    private Handler.Callback f35271g = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                try {
                    inflateRequest.view = AsyncLayoutInflaterPlus.this.f35268c.inflate(inflateRequest.resid, inflateRequest.parent, false);
                } catch (Throwable th) {
                    OmegaSDK.trackError("AsyncLayoutInflater", th);
                }
            }
            if (inflateRequest.callback != null) {
                inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent, inflateRequest.time);
            }
            if (inflateRequest.countDownLatch != null) {
                inflateRequest.countDownLatch.countDown();
            }
            AsyncLayoutInflaterPlus.this.releaseRequest(inflateRequest);
            return true;
        }
    };

    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i, ViewGroup viewGroup, long j);
    }

    public AsyncLayoutInflaterPlus(Context context) {
        this.f35268c = new BasicInflater(context);
        this.f35267b = new Handler(Looper.getMainLooper(), this.f35271g);
    }

    public AsyncLayoutTask inflate(int i, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener, CountDownLatch countDownLatch) {
        if (onInflateFinishedListener != null) {
            InflateRequest obtainRequest = obtainRequest();
            obtainRequest.inflater = this;
            obtainRequest.resid = i;
            obtainRequest.parent = viewGroup;
            obtainRequest.callback = onInflateFinishedListener;
            obtainRequest.countDownLatch = countDownLatch;
            this.f35269d = new InflateRunnable(obtainRequest);
            Future<?> submit = ApmThreadPool.getExecutorService().submit(this.f35269d);
            this.f35270f = submit;
            return new AsyncLayoutTask(submit, this.f35269d);
        }
        throw new NullPointerException("callback argument may not be null!");
    }

    private static class InflateRequest {
        OnInflateFinishedListener callback;
        CountDownLatch countDownLatch;
        AsyncLayoutInflaterPlus inflater;
        ViewGroup parent;
        int resid;
        long time;
        View view;

        InflateRequest() {
        }
    }

    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
            if (context instanceof AppCompatActivity) {
                AppCompatDelegate delegate = ((AppCompatActivity) context).getDelegate();
                if (delegate instanceof LayoutInflater.Factory2) {
                    LayoutInflaterCompat.setFactory2(this, (LayoutInflater.Factory2) delegate);
                }
            }
        }

        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        /* access modifiers changed from: protected */
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            String[] strArr = sClassPrefixList;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    View createView = createView(str, strArr[i], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public class InflateRunnable implements Runnable {
        private volatile boolean isRunning;
        private InflateRequest request;

        public InflateRunnable(InflateRequest inflateRequest) {
            this.request = inflateRequest;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            this.isRunning = true;
            try {
                this.request.view = this.request.inflater.f35268c.inflate(this.request.resid, this.request.parent, false);
            } catch (Throwable th) {
                SystemUtils.log(5, AsyncLayoutInflaterPlus.f35265a, "Failed to inflate resource in the background! Retrying on the UI thread", th, "com.didi.sdk.async.AsyncLayoutInflaterPlus$InflateRunnable", 163);
                OmegaSDK.trackError("AsyncLayoutInflater", th);
            }
            this.request.time = System.currentTimeMillis() - currentTimeMillis;
            Message.obtain(this.request.inflater.f35267b, 0, this.request).sendToTarget();
        }

        public boolean isRunning() {
            return this.isRunning;
        }
    }

    public InflateRequest obtainRequest() {
        InflateRequest acquire = f35266e.acquire();
        return acquire == null ? new InflateRequest() : acquire;
    }

    public void releaseRequest(InflateRequest inflateRequest) {
        inflateRequest.callback = null;
        inflateRequest.inflater = null;
        inflateRequest.parent = null;
        inflateRequest.resid = 0;
        inflateRequest.view = null;
        f35266e.release(inflateRequest);
    }
}

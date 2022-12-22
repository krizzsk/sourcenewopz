package com.didi.sdk.async;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.async.AsyncLayoutInflaterPlus;
import java.util.concurrent.CountDownLatch;

public class AsyncLayoutFactory {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f35261a = "AsyncLayoutFactory";

    /* renamed from: b */
    private AsyncLayoutInflaterPlus f35262b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SparseArray<View> f35263c = new SparseArray<>();

    /* renamed from: d */
    private SparseArray<AsyncLayoutTask> f35264d = new SparseArray<>();

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final AsyncLayoutFactory INSTANCE = new AsyncLayoutFactory();

        private SingletonHolder() {
        }
    }

    public static AsyncLayoutFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    AsyncLayoutFactory() {
    }

    public void init(Context context) {
        if (this.f35262b == null) {
            this.f35262b = new AsyncLayoutInflaterPlus(context);
        }
    }

    public void inflateAsync(int i, ViewGroup viewGroup) {
        String str = f35261a;
        SystemUtils.log(3, str, "inflateAsync:" + i, (Throwable) null, "com.didi.sdk.async.AsyncLayoutFactory", 41);
        this.f35264d.put(i, this.f35262b.inflate(i, viewGroup, new AsyncLayoutInflaterPlus.OnInflateFinishedListener() {
            public void onInflateFinished(View view, int i, ViewGroup viewGroup, long j) {
                View view2 = view;
                int i2 = i;
                if (view2 != null) {
                    AsyncLayoutFactory.this.f35263c.put(i2, view2);
                } else {
                    SystemUtils.log(3, AsyncLayoutFactory.f35261a, "inflate fail", (Throwable) null, "com.didi.sdk.async.AsyncLayoutFactory$1", 50);
                }
                String a = AsyncLayoutFactory.f35261a;
                SystemUtils.log(3, a, "onInflateFinished:" + i2, (Throwable) null, "com.didi.sdk.async.AsyncLayoutFactory$1", 52);
            }
        }, (CountDownLatch) null));
    }

    public View getViewByResId(int i) {
        View view = this.f35263c.get(i);
        if (view == null) {
            AsyncLayoutTask asyncLayoutTask = this.f35264d.get(i);
            if (asyncLayoutTask != null && !asyncLayoutTask.isRunning()) {
                SystemUtils.log(3, f35261a, "task.cancel", (Throwable) null, "com.didi.sdk.async.AsyncLayoutFactory", 64);
                asyncLayoutTask.cancel();
            }
        } else {
            this.f35263c.remove(i);
        }
        this.f35264d.remove(i);
        String str = f35261a;
        SystemUtils.log(3, str, "getViewByResId:" + i + " view:" + view, (Throwable) null, "com.didi.sdk.async.AsyncLayoutFactory", 73);
        return view;
    }
}

package com.didi.sdk.common.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.SystemClock;
import android.util.SparseArray;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.common.DDThreadPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LazyTaskLoader {
    public static final int TASK_BITMAP = 2;
    public static final int TASK_SOUND = 1;

    /* renamed from: a */
    private static final String f35639a = "LazyTaskLoader";

    /* renamed from: b */
    private static final long f35640b = 10000;

    /* renamed from: e */
    private static volatile LazyTaskLoader f35641e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AtomicBoolean f35642c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Object f35643d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f35644f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SoundPool f35645g = new SoundPool(2, 3, 0);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseArray<Integer> f35646h = new SparseArray<>();

    /* renamed from: i */
    private int f35647i = 0;

    /* renamed from: j */
    private List<AssetManager.AssetInputStream> f35648j = new ArrayList();

    public interface OnTaskLoadedListener {
        void onTaskLoaded(int i, Object obj);
    }

    private LazyTaskLoader(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f35644f = applicationContext;
        if (applicationContext == null) {
            this.f35644f = context;
        }
    }

    public static LazyTaskLoader getInstance(Context context) {
        if (f35641e == null) {
            synchronized (LazyTaskLoader.class) {
                if (f35641e == null) {
                    f35641e = new LazyTaskLoader(context);
                }
            }
        }
        return f35641e;
    }

    public void requestLoad(int i, List<Integer> list) {
        requestLoad(i, list, (OnTaskLoadedListener) null);
    }

    public void requestLoad(int i, List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
        if (i == 1) {
            m25245a(list, onTaskLoadedListener);
        }
    }

    public void scheduleTask(final Runnable runnable) {
        m25244a((Runnable) new Runnable() {
            public void run() {
                if (!LazyTaskLoader.this.f35642c.get()) {
                    SystemUtils.log(4, LazyTaskLoader.f35639a, "wait schedule task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$1", 112);
                    synchronized (LazyTaskLoader.this.f35643d) {
                        if (!LazyTaskLoader.this.f35642c.get()) {
                            try {
                                LazyTaskLoader.this.f35643d.wait(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                SystemUtils.log(4, LazyTaskLoader.f35639a, "start execute task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$1", 123);
                runnable.run();
            }
        });
    }

    /* renamed from: a */
    private synchronized void m25245a(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
        if (this.f35645g == null) {
            this.f35645g = new SoundPool(2, 3, 0);
        }
        m25244a((Runnable) new TaskWorker(list, onTaskLoadedListener));
    }

    public SoundPool getSoundPool() {
        return this.f35645g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r9 = r0.get(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int peekSound(int r9) {
        /*
            r8 = this;
            android.util.SparseArray<java.lang.Integer> r0 = r8.f35646h
            if (r0 == 0) goto L_0x0011
            java.lang.Object r9 = r0.get(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 == 0) goto L_0x0011
            int r9 = r9.intValue()
            goto L_0x0012
        L_0x0011:
            r9 = 0
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "peek sound, return: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            r2 = 4
            r5 = 0
            r7 = 150(0x96, float:2.1E-43)
            java.lang.String r3 = "LazyTaskLoader"
            java.lang.String r6 = "com.didi.sdk.common.utility.LazyTaskLoader"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.common.utility.LazyTaskLoader.peekSound(int):int");
    }

    public void setHasMainActivityLaunched(boolean z) {
        this.f35642c.set(z);
        if (this.f35642c.get()) {
            synchronized (this.f35643d) {
                this.f35643d.notifyAll();
                SystemUtils.log(4, f35639a, "notify Task Worker", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader", 159);
            }
        }
    }

    /* renamed from: a */
    private void m25244a(Runnable runnable) {
        DDThreadPool.getInstance().addBkgTask(runnable);
    }

    public void acquireAssetManager() {
        this.f35647i++;
    }

    public void releaseAssetManager(AssetManager.AssetInputStream assetInputStream) {
        this.f35647i--;
        this.f35648j.add(assetInputStream);
        if (this.f35647i <= 0) {
            this.f35648j.clear();
            System.gc();
        }
    }

    /* renamed from: a */
    private void m25243a() {
        SparseArray<Integer> sparseArray = this.f35646h;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.f35645g.release();
        this.f35645g = null;
    }

    private class TaskWorker implements Runnable {
        private OnTaskLoadedListener mTaskListener;
        private List<Integer> mTaskResourceIds;

        public TaskWorker(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
            this.mTaskResourceIds = list;
            this.mTaskListener = onTaskLoadedListener;
        }

        public void run() {
            if (!LazyTaskLoader.this.f35642c.get()) {
                SystemUtils.log(4, LazyTaskLoader.f35639a, "wait schedule task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 209);
                synchronized (LazyTaskLoader.this.f35643d) {
                    if (!LazyTaskLoader.this.f35642c.get()) {
                        try {
                            LazyTaskLoader.this.f35643d.wait(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            SystemUtils.log(4, LazyTaskLoader.f35639a, "start execute task with size " + this.mTaskResourceIds.size(), (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 220);
            loadSound(this.mTaskResourceIds, this.mTaskListener);
        }

        private SparseArray<Integer> loadSound(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
            if (list == null) {
                return null;
            }
            SparseArray<Integer> sparseArray = new SparseArray<>();
            for (int i = 0; i < list.size(); i++) {
                int intValue = list.get(i).intValue();
                int peekSound = LazyTaskLoader.this.peekSound(intValue);
                if (peekSound == 0) {
                    try {
                        peekSound = LazyTaskLoader.this.f35645g.load(LazyTaskLoader.this.f35644f, intValue, 1);
                    } catch (Exception unused) {
                    }
                    SystemUtils.log(4, "loadSound", "load sound " + intValue, (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 238);
                }
                sparseArray.put(intValue, Integer.valueOf(peekSound));
                SystemClock.sleep(10);
            }
            refreshSoundPool(sparseArray);
            if (onTaskLoadedListener != null) {
                onTaskLoadedListener.onTaskLoaded(1, sparseArray);
            }
            return sparseArray;
        }

        private void refreshSoundPool(SparseArray<Integer> sparseArray) {
            synchronized (LazyTaskLoader.this) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    int keyAt = sparseArray.keyAt(i);
                    if (((Integer) LazyTaskLoader.this.f35646h.get(keyAt)) == null) {
                        LazyTaskLoader.this.f35646h.put(keyAt, sparseArray.valueAt(i));
                    }
                }
            }
        }
    }

    @Deprecated
    public float getVolume() {
        AudioManager audioManager = (AudioManager) this.f35644f.getSystemService("audio");
        if (audioManager.getRingerMode() != 2) {
            return 0.0f;
        }
        return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
    }
}

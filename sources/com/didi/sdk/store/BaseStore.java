package com.didi.sdk.store;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import com.didi.sdk.cache.Cache;
import com.didi.sdk.dependency.ConstantHolder;
import com.didi.sdk.dependency.ConstantListener;
import com.didi.sdk.event.Event;
import com.didi.sdk.event.EventDispatcher;
import com.didi.sdk.store.DiskCache;
import com.didi.sdk.store.util.ByteUtils;
import com.didi.sdk.store.util.ParcelableUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public abstract class BaseStore extends EventDispatcher {

    /* renamed from: a */
    private StoreCache f37533a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DiskCache f37534b;

    /* renamed from: c */
    private String f37535c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<String, CountDownLatch> f37536d = new ConcurrentHashMap();

    public BaseStore(String str) {
        m26659a(str);
        this.f37535c = str;
        this.f37533a = new StoreCache();
    }

    /* renamed from: a */
    private static void m26659a(String str) {
        ConstantListener constantListener;
        if (!"com.didi.sdk.login.c.j".equals(str) && (constantListener = ConstantHolder.getInstance().getConstantListener()) != null) {
            String[] businessIds = constantListener.getBusinessIds();
            int length = businessIds.length;
            int i = 0;
            while (i < length && !str.startsWith(businessIds[i])) {
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void save(Context context, String str, byte[] bArr) {
        DiskCache.DEntry dEntry = new DiskCache.DEntry();
        dEntry.data = bArr;
        save(context, str, dEntry);
    }

    /* renamed from: a */
    private void m26658a(Context context) {
        if (this.f37534b == null) {
            synchronized (BaseStore.class) {
                if (this.f37534b == null) {
                    DiskCache diskCache = new DiskCache(context, this.f37535c);
                    this.f37534b = diskCache;
                    diskCache.initialize();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void save(Context context, final String str, final DiskCache.DEntry dEntry) {
        m26658a(context);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f37536d.put(str, countDownLatch);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    BaseStore.this.f37534b.put(str, dEntry);
                } finally {
                    BaseStore.this.f37536d.remove(str);
                    countDownLatch.countDown();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public DiskCache.DEntry load(Context context, String str) {
        m26658a(context);
        if (this.f37534b == null) {
            return new DiskCache.DEntry();
        }
        CountDownLatch countDownLatch = this.f37536d.get(str);
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        DiskCache.DEntry dEntry = new DiskCache.DEntry();
        Cache.Entry entry = this.f37534b.get(str);
        if (entry != null) {
            dEntry.data = entry.data;
        }
        return dEntry;
    }

    /* access modifiers changed from: protected */
    public void put(String str, Object obj, long j) {
        this.f37533a.mo96566a(str, obj, j);
    }

    /* access modifiers changed from: protected */
    public void put(String str, Object obj) {
        put(str, obj, -2);
    }

    /* access modifiers changed from: protected */
    public void remove(String str) {
        this.f37533a.mo96565a(str);
    }

    /* access modifiers changed from: protected */
    public void wipe(String str) {
        DiskCache diskCache = this.f37534b;
        if (diskCache != null) {
            diskCache.remove(str);
        }
    }

    /* access modifiers changed from: protected */
    public Object get(String str) {
        return this.f37533a.mo96567b(str);
    }

    public Object getInner(Context context, String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        if (!this.f37533a.mo96569d(str)) {
            DiskCache.DEntry load = load(context, str);
            if (!(load == null || load.data == null)) {
                obj = load.data;
            }
            this.f37533a.mo96566a(str, obj, -2);
        }
        return obj;
    }

    public void putAndSave(Context context, String str, long j) {
        if (str != null) {
            put(str, Long.valueOf(j));
            DiskCache.DEntry dEntry = new DiskCache.DEntry();
            dEntry.data = ByteUtils.longToBytes(j);
            save(context, str, dEntry);
        }
    }

    public void putAndSave(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            put(str, str2);
            DiskCache.DEntry dEntry = new DiskCache.DEntry();
            dEntry.data = str2.getBytes();
            save(context, str, dEntry);
        }
    }

    public void putAndSave(Context context, String str, Parcelable parcelable) {
        if (str != null && parcelable != null) {
            put(str, parcelable);
            DiskCache.DEntry dEntry = new DiskCache.DEntry();
            dEntry.data = ParcelableUtil.marshall(parcelable);
            save(context, str, dEntry);
        }
    }

    public void clearAll(String str) {
        remove(str);
        wipe(str);
    }

    /* access modifiers changed from: protected */
    public boolean isExpired(String str) {
        return this.f37533a.mo96568c(str);
    }

    public void registerReceiver(Object obj) {
        register(obj);
    }

    public void removeReceiver(Object obj) {
        unregister(obj);
    }

    /* access modifiers changed from: protected */
    public void dispatchEvent(Event event) {
        post(event);
    }
}

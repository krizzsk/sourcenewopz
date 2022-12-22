package com.didi.foundation.sdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.storage.IStorage;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.p188io.Streams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.foundation.sdk.storage.a */
/* compiled from: SharedPreferencesStorage */
class C8386a<T extends Parcelable> implements IStorage<T> {

    /* renamed from: a */
    private static final ThreadPoolExecutor f21321a = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new SharedPreferencesStorage$1(), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b */
    private static final String f21322b = "Storage.Key";

    /* renamed from: c */
    private Logger f21323c = LogService.getLogger(getClass().getName());

    /* renamed from: d */
    private final SharedPreferences f21324d;

    /* renamed from: e */
    private final Object f21325e = new Object();

    /* renamed from: f */
    private SharedPreferences.Editor f21326f;

    C8386a(String str) {
        this.f21324d = SystemUtils.getSharedPreferences(FoundationApplicationListener.getApplication(), str, 0);
    }

    C8386a(String str, Context context) {
        this.f21324d = SystemUtils.getSharedPreferences(context, str, 0);
    }

    public void clear() {
        m15668a(this.f21324d.edit().clear());
    }

    /* renamed from: a */
    public T getData() {
        return mo63387b(f21322b);
    }

    /* renamed from: a */
    public T getData(String str) {
        return mo63387b(str);
    }

    /* renamed from: a */
    public void setData(T t) {
        mo63388b(f21322b, t);
    }

    /* renamed from: a */
    public void setData(String str, T t) {
        mo63388b(str, t);
    }

    public boolean has(String str) {
        return this.f21324d.contains(str);
    }

    public void remove(String str) {
        m15668a(this.f21324d.edit().remove(str));
    }

    public boolean getBoolean(String str) {
        return this.f21324d.getBoolean(str, false);
    }

    public void putBoolean(String str, boolean z) {
        m15668a(this.f21324d.edit().putBoolean(str, z));
    }

    public IStorage setBoolean(String str, boolean z) {
        m15670b().putBoolean(str, z);
        return this;
    }

    public int getInt(String str) {
        return this.f21324d.getInt(str, 0);
    }

    public void putInt(String str, int i) {
        m15668a(this.f21324d.edit().putInt(str, i));
    }

    public IStorage setInt(String str, int i) {
        m15670b().putInt(str, i);
        return this;
    }

    public float getFloat(String str) {
        return this.f21324d.getFloat(str, 0.0f);
    }

    public void putFloat(String str, float f) {
        m15668a(this.f21324d.edit().putFloat(str, f));
    }

    public IStorage setFloat(String str, float f) {
        m15670b().putFloat(str, f);
        return this;
    }

    public long getLong(String str) {
        return this.f21324d.getLong(str, 0);
    }

    public void putLong(String str, long j) {
        m15668a(this.f21324d.edit().putLong(str, j));
    }

    public IStorage setLong(String str, long j) {
        m15670b().putLong(str, j);
        return this;
    }

    public String getString(String str) {
        return this.f21324d.getString(str, (String) null);
    }

    public void putString(String str, String str2) {
        m15668a(this.f21324d.edit().putString(str, str2));
    }

    public IStorage setString(String str, String str2) {
        m15670b().putString(str, str2);
        return this;
    }

    /* renamed from: b */
    public <T extends Parcelable> T mo63387b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String string = this.f21324d.getString(str, (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        byte[] decode = Base64.decode(string.getBytes(), 0);
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            return (Parcelable) obtain.readValue(getClass().getClassLoader());
        } finally {
            obtain.recycle();
            long currentTimeMillis2 = System.currentTimeMillis();
            Logger logger = this.f21323c;
            logger.debug("getParcelable:  finish time is " + (currentTimeMillis2 - currentTimeMillis), new Object[0]);
        }
    }

    /* renamed from: b */
    public <T extends Parcelable> void mo63388b(String str, T t) {
        if (t == null) {
            remove(str);
            return;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeValue(t);
            m15668a(this.f21324d.edit().putString(str, Base64.encodeToString(obtain.marshall(), 0)));
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: c */
    public <T extends Parcelable> IStorage mo63389c(String str, T t) {
        if (t == null) {
            m15670b().remove(str);
        } else {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeValue(t);
                m15670b().putString(str, new String(obtain.marshall()));
            } finally {
                obtain.recycle();
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void commit(com.didi.foundation.sdk.storage.IStorage.Callback r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f21325e
            monitor-enter(r0)
            android.content.SharedPreferences$Editor r1 = r3.f21326f     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x000f
            if (r4 == 0) goto L_0x000d
            r1 = 0
            r4.done(r1)     // Catch:{ all -> 0x001b }
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x000f:
            r2 = 0
            m15669a((android.content.SharedPreferences.Editor) r1, (com.didi.foundation.sdk.storage.IStorage.Callback) r4)     // Catch:{ all -> 0x0017 }
            r3.f21326f = r2     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0017:
            r4 = move-exception
            r3.f21326f = r2     // Catch:{ all -> 0x001b }
            throw r4     // Catch:{ all -> 0x001b }
        L_0x001b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.storage.C8386a.commit(com.didi.foundation.sdk.storage.IStorage$Callback):void");
    }

    public void putSerializable(String str, Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        if (serializable != null && !TextUtils.isEmpty(str)) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream2);
                } catch (IOException e) {
                    e = e;
                    objectOutputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        e.printStackTrace();
                        Streams.closeQuietly(byteArrayOutputStream);
                        Streams.closeQuietly(objectOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        Streams.closeQuietly(byteArrayOutputStream);
                        Streams.closeQuietly(objectOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    Streams.closeQuietly(byteArrayOutputStream);
                    Streams.closeQuietly(objectOutputStream);
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.flush();
                    putString(str, Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0));
                    Streams.closeQuietly(byteArrayOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    e.printStackTrace();
                    Streams.closeQuietly(byteArrayOutputStream);
                    Streams.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    Streams.closeQuietly(byteArrayOutputStream);
                    Streams.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                objectOutputStream = null;
                e.printStackTrace();
                Streams.closeQuietly(byteArrayOutputStream);
                Streams.closeQuietly(objectOutputStream);
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
                Streams.closeQuietly(byteArrayOutputStream);
                Streams.closeQuietly(objectOutputStream);
                throw th;
            }
            Streams.closeQuietly(objectOutputStream);
        }
    }

    public Serializable getSerializable(String str) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(getString(str))) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] decode = Base64.decode(getString(str), 0);
        if (decode == null) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
            try {
                Serializable serializable = (Serializable) objectInputStream.readObject();
                Streams.closeQuietly(objectInputStream);
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f21323c.debug("getSerializable finish time is " + (currentTimeMillis2 - currentTimeMillis), new Object[0]);
                return serializable;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    Streams.closeQuietly(objectInputStream);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    this.f21323c.debug("getSerializable finish time is " + (currentTimeMillis3 - currentTimeMillis), new Object[0]);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    objectInputStream2 = objectInputStream;
                    Streams.closeQuietly(objectInputStream2);
                    long currentTimeMillis4 = System.currentTimeMillis();
                    this.f21323c.debug("getSerializable finish time is " + (currentTimeMillis4 - currentTimeMillis), new Object[0]);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            objectInputStream = null;
            e.printStackTrace();
            Streams.closeQuietly(objectInputStream);
            long currentTimeMillis32 = System.currentTimeMillis();
            this.f21323c.debug("getSerializable finish time is " + (currentTimeMillis32 - currentTimeMillis), new Object[0]);
            return null;
        } catch (Throwable th2) {
            th = th2;
            Streams.closeQuietly(objectInputStream2);
            long currentTimeMillis42 = System.currentTimeMillis();
            this.f21323c.debug("getSerializable finish time is " + (currentTimeMillis42 - currentTimeMillis), new Object[0]);
            throw th;
        }
    }

    /* renamed from: b */
    private SharedPreferences.Editor m15670b() {
        SharedPreferences.Editor editor;
        synchronized (this.f21325e) {
            if (this.f21326f == null) {
                this.f21326f = this.f21324d.edit();
            }
            editor = this.f21326f;
        }
        return editor;
    }

    /* renamed from: a */
    private static void m15668a(SharedPreferences.Editor editor) {
        m15669a(editor, (IStorage.Callback) null);
    }

    /* renamed from: a */
    private static void m15669a(SharedPreferences.Editor editor, IStorage.Callback callback) {
        f21321a.execute(new SharedPreferencesStorage$2(editor, callback));
    }
}

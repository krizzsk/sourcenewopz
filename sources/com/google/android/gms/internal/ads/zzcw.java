package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzcw<K, V> {
    private static final String TAG = zzcw.class.getSimpleName();

    /* access modifiers changed from: protected */
    public abstract void zzam(String str);

    /* access modifiers changed from: protected */
    public abstract HashMap<K, V> zzbo();

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(zzbo());
            objectOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (IOException unused) {
            return null;
        }
    }

    protected static <K, V> HashMap<K, V> zzan(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return (HashMap) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0))).readObject();
            }
            return null;
        } catch (IOException | ClassNotFoundException unused) {
            SystemUtils.log(3, TAG, "decode object failure", (Throwable) null, "com.google.android.gms.internal.ads.zzcw", 18);
            return null;
        }
    }
}

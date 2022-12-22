package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzv {
    private final String mName;
    private final String mValue;

    public zzv(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzv zzv = (zzv) obj;
            return TextUtils.equals(this.mName, zzv.mName) && TextUtils.equals(this.mValue, zzv.mValue);
        }
    }

    public final int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public final String toString() {
        String str = this.mName;
        String str2 = this.mValue;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append(Const.jaRight);
        return sb.toString();
    }
}

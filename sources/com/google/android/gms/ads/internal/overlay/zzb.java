package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final zzv zzdjj;
    private final String zzdsu;
    public final String zzdsv;
    public final String zzdsw;
    private final String zzdsx;
    public final boolean zzdsy;

    public zzb(String str, String str2, String str3, String str4, String str5, String str6, String str7, zzv zzv) {
        this(str, str2, str3, str4, str5, str6, str7, (Intent) null, ObjectWrapper.wrap(zzv).asBinder(), false);
    }

    public zzb(Intent intent2, zzv zzv) {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intent2, ObjectWrapper.wrap(zzv).asBinder(), false);
    }

    public zzb(String str, zzv zzv, boolean z) {
        this((String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(zzv).asBinder(), true);
    }

    public zzb(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent2, IBinder iBinder, boolean z) {
        this.zzdsu = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdsv = str5;
        this.zzdsw = str6;
        this.zzdsx = str7;
        this.intent = intent2;
        this.zzdjj = (zzv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdsy = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdsu, false);
        SafeParcelWriter.writeString(parcel, 3, this.url, false);
        SafeParcelWriter.writeString(parcel, 4, this.mimeType, false);
        SafeParcelWriter.writeString(parcel, 5, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdsv, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdsw, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdsx, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.intent, i, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdjj).asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzdsy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

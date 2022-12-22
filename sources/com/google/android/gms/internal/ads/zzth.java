package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzth extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzth> CREATOR = new zztg();
    private ParcelFileDescriptor zzbvs;
    private final boolean zzbvt;
    private final boolean zzbvu;
    private final long zzbvv;
    private final boolean zzbvw;

    public zzth() {
        this((ParcelFileDescriptor) null, false, false, 0, false);
    }

    public zzth(ParcelFileDescriptor parcelFileDescriptor, boolean z, boolean z2, long j, boolean z3) {
        this.zzbvs = parcelFileDescriptor;
        this.zzbvt = z;
        this.zzbvu = z2;
        this.zzbvv = j;
        this.zzbvw = z3;
    }

    public final synchronized boolean zznc() {
        return this.zzbvs != null;
    }

    public final synchronized InputStream zznd() {
        if (this.zzbvs == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbvs);
        this.zzbvs = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor zzne() {
        return this.zzbvs;
    }

    public final synchronized boolean zznf() {
        return this.zzbvt;
    }

    public final synchronized boolean zzng() {
        return this.zzbvu;
    }

    public final synchronized long zznh() {
        return this.zzbvv;
    }

    public final synchronized boolean zzni() {
        return this.zzbvw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzne(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, zznf());
        SafeParcelWriter.writeBoolean(parcel, 4, zzng());
        SafeParcelWriter.writeLong(parcel, 5, zznh());
        SafeParcelWriter.writeBoolean(parcel, 6, zzni());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzatu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatu> CREATOR = new zzatx();
    public final boolean zzdyl;
    public final List<String> zzdym;

    public zzatu() {
        this(false, Collections.emptyList());
    }

    public zzatu(boolean z, List<String> list) {
        this.zzdyl = z;
        this.zzdym = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdyl);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdym, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

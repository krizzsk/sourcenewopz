package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvv> CREATOR = new zzvy();
    public final int type;
    public final int zzadj;
    public final String zzadk;
    public final long zzadl;

    public zzvv(int i, int i2, String str, long j) {
        this.type = i;
        this.zzadj = i2;
        this.zzadk = str;
        this.zzadl = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadj);
        SafeParcelWriter.writeString(parcel, 3, this.zzadk, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzadl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzvv zza(JSONObject jSONObject) throws JSONException {
        return new zzvv(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }
}

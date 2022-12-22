package com.jumio.core.data.country;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"com/jumio/core/data/country/Country$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/jumio/core/data/country/Country;", "Landroid/os/Parcel;", "source", "createFromParcel", "", "size", "", "newArray", "(I)[Lcom/jumio/core/data/country/Country;", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Country.kt */
public final class Country$Companion$CREATOR$1 implements Parcelable.Creator<Country> {
    public Country createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return new Country(parcel);
    }

    public Country[] newArray(int i) {
        return new Country[i];
    }
}

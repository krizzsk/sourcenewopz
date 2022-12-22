package com.didi.soda.home.policy.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/policy/model/LocationSettingEntity;", "Landroid/os/Parcelable;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "lastTimeStampShownDialog", "", "getLastTimeStampShownDialog", "()J", "setLastTimeStampShownDialog", "(J)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LocationSettingEntity.kt */
public final class LocationSettingEntity implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7065512758970680965L;
    @SerializedName("lastTimeStampShownDialog")
    private long lastTimeStampShownDialog;

    public int describeContents() {
        return 0;
    }

    public LocationSettingEntity() {
    }

    public final long getLastTimeStampShownDialog() {
        return this.lastTimeStampShownDialog;
    }

    public final void setLastTimeStampShownDialog(long j) {
        this.lastTimeStampShownDialog = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocationSettingEntity(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.lastTimeStampShownDialog = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.lastTimeStampShownDialog);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/policy/model/LocationSettingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/home/policy/model/LocationSettingEntity;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/home/policy/model/LocationSettingEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LocationSettingEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<LocationSettingEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public LocationSettingEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationSettingEntity(parcel);
        }

        public LocationSettingEntity[] newArray(int i) {
            return new LocationSettingEntity[i];
        }
    }
}

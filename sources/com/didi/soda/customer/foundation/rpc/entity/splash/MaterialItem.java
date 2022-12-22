package com.didi.soda.customer.foundation.rpc.entity.splash;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialItem;", "Landroid/os/Parcelable;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "materialType", "", "getMaterialType", "()Ljava/lang/String;", "setMaterialType", "(Ljava/lang/String;)V", "materialValue", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;", "getMaterialValue", "()Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;", "setMaterialValue", "(Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MaterialItem.kt */
public final class MaterialItem implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 9137082461269944553L;
    private String materialType;
    private MaterialValue materialValue;

    public int describeContents() {
        return 0;
    }

    public MaterialItem() {
    }

    public final String getMaterialType() {
        return this.materialType;
    }

    public final void setMaterialType(String str) {
        this.materialType = str;
    }

    public final MaterialValue getMaterialValue() {
        return this.materialValue;
    }

    public final void setMaterialValue(MaterialValue materialValue2) {
        this.materialValue = materialValue2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaterialItem(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.materialType = parcel.readString();
        this.materialValue = (MaterialValue) parcel.readParcelable(MaterialValue.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.materialType);
        parcel.writeParcelable(this.materialValue, i);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialItem;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialItem;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MaterialItem.kt */
    public static final class CREATOR implements Parcelable.Creator<MaterialItem> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public MaterialItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MaterialItem(parcel);
        }

        public MaterialItem[] newArray(int i) {
            return new MaterialItem[i];
        }
    }
}

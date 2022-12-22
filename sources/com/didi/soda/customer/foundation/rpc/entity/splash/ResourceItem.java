package com.didi.soda.customer.foundation.rpc.entity.splash;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/ResourceItem;", "Landroid/os/Parcelable;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "activityEndTime", "", "getActivityEndTime", "()I", "setActivityEndTime", "(I)V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "activityStartTime", "getActivityStartTime", "setActivityStartTime", "materialList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialItem;", "getMaterialList", "()Ljava/util/List;", "setMaterialList", "(Ljava/util/List;)V", "resourceId", "getResourceId", "setResourceId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ResourceItem.kt */
public final class ResourceItem implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5182114877862383605L;
    private int activityEndTime;
    private String activityId;
    private int activityStartTime;
    private List<MaterialItem> materialList;
    private String resourceId;

    public int describeContents() {
        return 0;
    }

    public ResourceItem() {
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final int getActivityStartTime() {
        return this.activityStartTime;
    }

    public final void setActivityStartTime(int i) {
        this.activityStartTime = i;
    }

    public final int getActivityEndTime() {
        return this.activityEndTime;
    }

    public final void setActivityEndTime(int i) {
        this.activityEndTime = i;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final List<MaterialItem> getMaterialList() {
        return this.materialList;
    }

    public final void setMaterialList(List<MaterialItem> list) {
        this.materialList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ResourceItem(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.activityId = parcel.readString();
        this.activityStartTime = parcel.readInt();
        this.activityEndTime = parcel.readInt();
        this.resourceId = parcel.readString();
        this.materialList = parcel.createTypedArrayList(MaterialItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.activityId);
        parcel.writeInt(this.activityStartTime);
        parcel.writeInt(this.activityEndTime);
        parcel.writeString(this.resourceId);
        parcel.writeTypedList(this.materialList);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/ResourceItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/ResourceItem;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/rpc/entity/splash/ResourceItem;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ResourceItem.kt */
    public static final class CREATOR implements Parcelable.Creator<ResourceItem> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public ResourceItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ResourceItem(parcel);
        }

        public ResourceItem[] newArray(int i) {
            return new ResourceItem[i];
        }
    }
}

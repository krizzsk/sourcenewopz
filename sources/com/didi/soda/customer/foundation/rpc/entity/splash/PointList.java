package com.didi.soda.customer.foundation.rpc.entity.splash;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/PointList;", "Landroid/os/Parcelable;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "pointId", "", "getPointId", "()Ljava/lang/String;", "setPointId", "(Ljava/lang/String;)V", "resourceList", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/ResourceItem;", "getResourceList", "()Ljava/util/ArrayList;", "setResourceList", "(Ljava/util/ArrayList;)V", "templateType", "getTemplateType", "setTemplateType", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PointList.kt */
public final class PointList implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2108065834306685994L;
    private String pointId;
    private ArrayList<ResourceItem> resourceList;
    private String templateType;

    public int describeContents() {
        return 0;
    }

    public PointList() {
        this.resourceList = new ArrayList<>();
    }

    public final String getPointId() {
        return this.pointId;
    }

    public final void setPointId(String str) {
        this.pointId = str;
    }

    public final String getTemplateType() {
        return this.templateType;
    }

    public final void setTemplateType(String str) {
        this.templateType = str;
    }

    public final ArrayList<ResourceItem> getResourceList() {
        return this.resourceList;
    }

    public final void setResourceList(ArrayList<ResourceItem> arrayList) {
        this.resourceList = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PointList(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.pointId = parcel.readString();
        this.templateType = parcel.readString();
        this.resourceList = parcel.createTypedArrayList(ResourceItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.pointId);
        parcel.writeString(this.templateType);
        parcel.writeTypedList(this.resourceList);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/PointList$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/PointList;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/rpc/entity/splash/PointList;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PointList.kt */
    public static final class CREATOR implements Parcelable.Creator<PointList> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public PointList createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PointList(parcel);
        }

        public PointList[] newArray(int i) {
            return new PointList[i];
        }
    }
}

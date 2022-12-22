package com.didi.soda.customer.foundation.rpc.entity.splash;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;", "Landroid/os/Parcelable;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "redirectType", "getRedirectType", "setRedirectType", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "redirectUrlCorrect", "getRedirectUrlCorrect", "setRedirectUrlCorrect", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MaterialValue.kt */
public final class MaterialValue implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 4527539709277705382L;
    private String content;
    private String imageUrl;
    private String redirectType;
    private String redirectUrl;
    private String redirectUrlCorrect;

    public int describeContents() {
        return 0;
    }

    public MaterialValue() {
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getRedirectType() {
        return this.redirectType;
    }

    public final void setRedirectType(String str) {
        this.redirectType = str;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public final String getRedirectUrlCorrect() {
        return this.redirectUrlCorrect;
    }

    public final void setRedirectUrlCorrect(String str) {
        this.redirectUrlCorrect = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaterialValue(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.imageUrl = parcel.readString();
        this.content = parcel.readString();
        this.redirectType = parcel.readString();
        this.redirectUrl = parcel.readString();
        this.redirectUrlCorrect = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.content);
        parcel.writeString(this.redirectType);
        parcel.writeString(this.redirectUrl);
        parcel.writeString(this.redirectUrlCorrect);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/rpc/entity/splash/MaterialValue;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MaterialValue.kt */
    public static final class CREATOR implements Parcelable.Creator<MaterialValue> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public MaterialValue createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MaterialValue(parcel);
        }

        public MaterialValue[] newArray(int i) {
            return new MaterialValue[i];
        }
    }
}

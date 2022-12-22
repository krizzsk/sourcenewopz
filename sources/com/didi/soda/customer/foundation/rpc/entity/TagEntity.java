package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0017H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "backColor", "", "getBackColor", "()Ljava/lang/String;", "setBackColor", "(Ljava/lang/String;)V", "cacheKey", "getCacheKey", "setCacheKey", "content", "getContent", "setContent", "imgUrl", "getImgUrl", "setImgUrl", "waitTime", "", "getWaitTime", "()I", "setWaitTime", "(I)V", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TagEntity.kt */
public final class TagEntity implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private String backColor;
    private String cacheKey;
    private String content;
    private String imgUrl;
    private int waitTime;

    public int describeContents() {
        return 0;
    }

    public TagEntity() {
    }

    public final String getBackColor() {
        return this.backColor;
    }

    public final void setBackColor(String str) {
        this.backColor = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final int getWaitTime() {
        return this.waitTime;
    }

    public final void setWaitTime(int i) {
        this.waitTime = i;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            TagEntity tagEntity = (TagEntity) obj;
            return Intrinsics.areEqual((Object) this.backColor, (Object) tagEntity.backColor) && Intrinsics.areEqual((Object) this.content, (Object) tagEntity.content) && this.waitTime == tagEntity.waitTime && Intrinsics.areEqual((Object) this.cacheKey, (Object) tagEntity.cacheKey);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.TagEntity");
    }

    public int hashCode() {
        String str = this.backColor;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.waitTime) * 31;
        String str3 = this.cacheKey;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TagEntity(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.backColor = parcel.readString();
        this.content = parcel.readString();
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        if (readValue != null) {
            this.waitTime = ((Integer) readValue).intValue();
            this.cacheKey = parcel.readString();
            this.imgUrl = parcel.readString();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.backColor);
        parcel.writeString(this.content);
        parcel.writeValue(Integer.valueOf(this.waitTime));
        parcel.writeString(this.cacheKey);
        parcel.writeString(this.imgUrl);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TagEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<TagEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public TagEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TagEntity(parcel);
        }

        public TagEntity[] newArray(int i) {
            return new TagEntity[i];
        }
    }
}

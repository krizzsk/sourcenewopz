package com.didi.soda.home.policy.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0000J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020'H\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR \u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR \u0010#\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\f¨\u0006."}, mo175978d2 = {"Lcom/didi/soda/home/policy/model/PrivacyContentEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "acceptedVersion", "", "getAcceptedVersion", "()Ljava/lang/String;", "setAcceptedVersion", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "excerpt", "getExcerpt", "setExcerpt", "lang", "getLang", "setLang", "reviseInfo", "getReviseInfo", "setReviseInfo", "updatePrivacyTime", "", "getUpdatePrivacyTime", "()Ljava/lang/Long;", "setUpdatePrivacyTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "url", "getUrl", "setUrl", "version", "getVersion", "setVersion", "describeContents", "", "refreshCacheData", "remoteNewData", "writeToParcel", "", "flags", "CREATOR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrivacyContentEntity.kt */
public final class PrivacyContentEntity implements Parcelable, IEntity {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 931314208807352729L;
    @SerializedName("acceptedVersion")
    private String acceptedVersion;
    @SerializedName("countryCode")
    private String countryCode;
    @SerializedName("excerpt")
    private String excerpt;
    @SerializedName("lang")
    private String lang;
    @SerializedName("reviseInfo")
    private String reviseInfo;
    @SerializedName("updatePrivacyTime")
    private Long updatePrivacyTime;
    @SerializedName("url")
    private String url;
    @SerializedName("version")
    private String version;

    public int describeContents() {
        return 0;
    }

    public PrivacyContentEntity() {
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final Long getUpdatePrivacyTime() {
        return this.updatePrivacyTime;
    }

    public final void setUpdatePrivacyTime(Long l) {
        this.updatePrivacyTime = l;
    }

    public final String getReviseInfo() {
        return this.reviseInfo;
    }

    public final void setReviseInfo(String str) {
        this.reviseInfo = str;
    }

    public final String getExcerpt() {
        return this.excerpt;
    }

    public final void setExcerpt(String str) {
        this.excerpt = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        this.lang = str;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }

    public final String getAcceptedVersion() {
        return this.acceptedVersion;
    }

    public final void setAcceptedVersion(String str) {
        this.acceptedVersion = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PrivacyContentEntity(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.version = parcel.readString();
        Object readValue = parcel.readValue(Long.TYPE.getClassLoader());
        this.updatePrivacyTime = readValue instanceof Long ? (Long) readValue : null;
        this.reviseInfo = parcel.readString();
        this.excerpt = parcel.readString();
        this.url = parcel.readString();
        this.lang = parcel.readString();
        this.acceptedVersion = parcel.readString();
        this.countryCode = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.version);
        parcel.writeValue(this.updatePrivacyTime);
        parcel.writeString(this.reviseInfo);
        parcel.writeString(this.excerpt);
        parcel.writeString(this.url);
        parcel.writeString(this.lang);
        parcel.writeString(this.acceptedVersion);
        parcel.writeString(this.countryCode);
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/policy/model/PrivacyContentEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/didi/soda/home/policy/model/PrivacyContentEntity;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/didi/soda/home/policy/model/PrivacyContentEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrivacyContentEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<PrivacyContentEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public PrivacyContentEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PrivacyContentEntity(parcel);
        }

        public PrivacyContentEntity[] newArray(int i) {
            return new PrivacyContentEntity[i];
        }
    }

    public final PrivacyContentEntity refreshCacheData(PrivacyContentEntity privacyContentEntity) {
        Intrinsics.checkNotNullParameter(privacyContentEntity, "remoteNewData");
        this.version = privacyContentEntity.version;
        this.lang = privacyContentEntity.lang;
        this.url = privacyContentEntity.url;
        this.reviseInfo = privacyContentEntity.reviseInfo;
        this.excerpt = privacyContentEntity.excerpt;
        this.updatePrivacyTime = privacyContentEntity.updatePrivacyTime;
        this.countryCode = privacyContentEntity.countryCode;
        return this;
    }
}

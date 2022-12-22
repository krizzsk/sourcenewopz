package com.didichuxing.gbankcard.ocr;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.didi.safetoolkit.api.SfConstant;

public class ScanCardParam implements Parcelable {
    public static final Parcelable.Creator<ScanCardParam> CREATOR = new Parcelable.Creator<ScanCardParam>() {
        public ScanCardParam createFromParcel(Parcel parcel) {
            return new ScanCardParam(parcel);
        }

        public ScanCardParam[] newArray(int i) {
            return new ScanCardParam[i];
        }
    };
    public static final int TYPE_FORCE = 1;
    public static final int TYPE_NORMAL = 0;
    private String cardBin;
    private String countryCode;
    private int type;
    private String uid;

    public int describeContents() {
        return 0;
    }

    private ScanCardParam(Builder builder) {
        this.type = builder.type;
        this.uid = builder.uid;
        this.countryCode = builder.countryCode;
        this.cardBin = builder.cardBin;
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        int i = this.type;
        return (i == 0 || i == 1) && !TextUtils.isEmpty(this.uid);
    }

    public int getType() {
        return this.type;
    }

    public boolean isForceType() {
        return this.type == 1;
    }

    public String getUid() {
        return this.uid;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCardBin() {
        return this.cardBin;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type=");
        sb.append(isForceType() ? "Force" : SfConstant.SfDangerLevel.LEVEL_NORMAL);
        sb.append(", uid=");
        sb.append(this.uid);
        sb.append(", countryCode=");
        sb.append(this.countryCode);
        sb.append(", cardBin=");
        sb.append(this.cardBin);
        sb.append("}");
        return sb.toString();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String cardBin;
        /* access modifiers changed from: private */
        public String countryCode;
        /* access modifiers changed from: private */
        public int type;
        /* access modifiers changed from: private */
        public String uid;

        public Builder(int i, String str) {
            this.type = i;
            this.uid = str;
        }

        public Builder cardBin(String str) {
            this.cardBin = str;
            return this;
        }

        public Builder countryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public ScanCardParam build() {
            return new ScanCardParam(this);
        }
    }

    protected ScanCardParam(Parcel parcel) {
        this.type = parcel.readInt();
        this.uid = parcel.readString();
        this.countryCode = parcel.readString();
        this.cardBin = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.uid);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.cardBin);
    }
}

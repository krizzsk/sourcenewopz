package com.didi.usercenter.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class GradeInfoV2 implements Parcelable, Serializable {
    public static final Parcelable.Creator<GradeInfoV2> CREATOR = new Parcelable.Creator<GradeInfoV2>() {
        public GradeInfoV2 createFromParcel(Parcel parcel) {
            return new GradeInfoV2(parcel);
        }

        public GradeInfoV2[] newArray(int i) {
            return new GradeInfoV2[i];
        }
    };
    public String bgEndColor;
    public String bgStartColor;
    public String cardArrowIcon;
    public String cardBgEndColor;
    public String cardBgStartColor;
    public String cardText;
    public String fontColor;
    public String jumpLink;
    public String levelIcon;
    public int levelId;
    public String levelName;

    public int describeContents() {
        return 0;
    }

    protected GradeInfoV2(Parcel parcel) {
        this.fontColor = parcel.readString();
        this.levelIcon = parcel.readString();
        this.levelId = parcel.readInt();
        this.levelName = parcel.readString();
        this.jumpLink = parcel.readString();
        this.bgStartColor = parcel.readString();
        this.bgEndColor = parcel.readString();
        this.cardBgStartColor = parcel.readString();
        this.cardBgEndColor = parcel.readString();
        this.cardText = parcel.readString();
        this.cardArrowIcon = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fontColor);
        parcel.writeString(this.levelIcon);
        parcel.writeInt(this.levelId);
        parcel.writeString(this.levelName);
        parcel.writeString(this.jumpLink);
        parcel.writeString(this.bgStartColor);
        parcel.writeString(this.bgEndColor);
        parcel.writeString(this.cardBgStartColor);
        parcel.writeString(this.cardBgEndColor);
        parcel.writeString(this.cardText);
        parcel.writeString(this.cardArrowIcon);
    }
}

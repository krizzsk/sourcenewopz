package com.didi.usercenter.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GradeInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<GradeInfo> CREATOR = new Parcelable.Creator<GradeInfo>() {
        public GradeInfo createFromParcel(Parcel parcel) {
            return new GradeInfo(parcel);
        }

        public GradeInfo[] newArray(int i) {
            return new GradeInfo[i];
        }
    };
    protected String color;
    protected String fontColor;
    @SerializedName("v2")
    public GradeInfoV2 gradeInfoV2;
    protected String jumpLink;
    protected String levelBgImg;
    protected String levelIcon;
    protected int levelId;
    protected String levelName;

    public int describeContents() {
        return 0;
    }

    public GradeInfo() {
    }

    protected GradeInfo(Parcel parcel) {
        this.levelIcon = parcel.readString();
        this.color = parcel.readString();
        this.levelBgImg = parcel.readString();
        this.levelId = parcel.readInt();
        this.jumpLink = parcel.readString();
        this.levelName = parcel.readString();
        this.fontColor = parcel.readString();
        this.gradeInfoV2 = (GradeInfoV2) parcel.readParcelable(GradeInfoV2.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.levelIcon);
        parcel.writeString(this.color);
        parcel.writeString(this.levelBgImg);
        parcel.writeInt(this.levelId);
        parcel.writeString(this.jumpLink);
        parcel.writeString(this.levelName);
        parcel.writeString(this.fontColor);
        parcel.writeParcelable(this.gradeInfoV2, i);
    }

    public String getLevelIcon() {
        return this.levelIcon;
    }

    public void setLevelIcon(String str) {
        this.levelIcon = str;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public String getLevelBgImg() {
        return this.levelBgImg;
    }

    public void setLevelBgImg(String str) {
        this.levelBgImg = str;
    }

    public int getLevelId() {
        return this.levelId;
    }

    public void setLevelId(int i) {
        this.levelId = i;
    }

    public String getJumpLink() {
        return this.jumpLink;
    }

    public void setJumpLink(String str) {
        this.jumpLink = str;
    }

    public String getLevelName() {
        return this.levelName;
    }

    public void setLevelName(String str) {
        this.levelName = str;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public String toString() {
        return "GradeInfo{levelIcon='" + this.levelIcon + '\'' + ", color='" + this.color + '\'' + ", levelBgImg='" + this.levelBgImg + '\'' + ", levelId=" + this.levelId + ", jumpLink='" + this.jumpLink + '\'' + ", levelName='" + this.levelName + '\'' + ", fontColor='" + this.fontColor + '\'' + '}';
    }
}

package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class BannerEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<BannerEntity> CREATOR = new Parcelable.Creator<BannerEntity>() {
        public BannerEntity createFromParcel(Parcel parcel) {
            return new BannerEntity(parcel);
        }

        public BannerEntity[] newArray(int i) {
            return new BannerEntity[i];
        }
    };
    private static final long serialVersionUID = -6787912176671096066L;
    public String actType;
    public int bannerType;
    public String bgImg;

    /* renamed from: id */
    public String f41037id;
    public String img;
    public String resourceId;
    public List<ShareCouponInfoEntity> shareInfo;
    public String subTitle;
    public String title;
    public String url;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BannerEntity: { img = " + this.img + ", url = " + this.url + ",title:" + this.title + " }";
    }

    public BannerEntity() {
    }

    protected BannerEntity(Parcel parcel) {
        this.f41037id = parcel.readString();
        this.img = parcel.readString();
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.resourceId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f41037id);
        parcel.writeString(this.img);
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.resourceId);
    }
}

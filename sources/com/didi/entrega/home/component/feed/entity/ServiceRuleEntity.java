package com.didi.entrega.home.component.feed.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;

public class ServiceRuleEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<ServiceRuleEntity> CREATOR = new Parcelable.Creator<ServiceRuleEntity>() {
        public ServiceRuleEntity createFromParcel(Parcel parcel) {
            return new ServiceRuleEntity(parcel);
        }

        public ServiceRuleEntity[] newArray(int i) {
            return new ServiceRuleEntity[i];
        }
    };
    private static final long serialVersionUID = 8685948216892510226L;
    public String content;
    public String imgUrl;
    public String linkContent;
    public String title;
    public String url;

    public int describeContents() {
        return 0;
    }

    public ServiceRuleEntity() {
    }

    protected ServiceRuleEntity(Parcel parcel) {
        this.url = parcel.readString();
        this.imgUrl = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.linkContent = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.linkContent);
    }
}

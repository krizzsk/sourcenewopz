package com.didi.soda.customer.foundation.rpc.entity.bill;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class RuleDescEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<RuleDescEntity> CREATOR = new Parcelable.Creator<RuleDescEntity>() {
        public RuleDescEntity createFromParcel(Parcel parcel) {
            return new RuleDescEntity(parcel);
        }

        public RuleDescEntity[] newArray(int i) {
            return new RuleDescEntity[i];
        }
    };
    private static final long serialVersionUID = -3085468252171737993L;
    public String btnDesc;
    public String content;
    public String title;
    public int type;

    public int describeContents() {
        return 0;
    }

    public RuleDescEntity() {
    }

    protected RuleDescEntity(Parcel parcel) {
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.btnDesc = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.btnDesc);
    }

    public RuleDescEntity copy() {
        RuleDescEntity ruleDescEntity = new RuleDescEntity();
        ruleDescEntity.type = this.type;
        ruleDescEntity.btnDesc = this.btnDesc;
        ruleDescEntity.title = this.title;
        ruleDescEntity.content = this.content;
        return ruleDescEntity;
    }

    public RuleDescEntity copyByType(int i) {
        RuleDescEntity ruleDescEntity = new RuleDescEntity();
        ruleDescEntity.type = i;
        ruleDescEntity.btnDesc = this.btnDesc;
        ruleDescEntity.title = this.title;
        ruleDescEntity.content = this.content;
        return ruleDescEntity;
    }
}

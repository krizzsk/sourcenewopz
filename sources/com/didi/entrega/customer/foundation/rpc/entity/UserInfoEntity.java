package com.didi.entrega.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public class UserInfoEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<UserInfoEntity> CREATOR = new Parcelable.Creator<UserInfoEntity>() {
        public UserInfoEntity createFromParcel(Parcel parcel) {
            return new UserInfoEntity(parcel);
        }

        public UserInfoEntity[] newArray(int i) {
            return new UserInfoEntity[i];
        }
    };
    private static final long serialVersionUID = 775972911008355085L;
    public String firstName;
    public boolean hasNewMsg;
    public String headUrl;
    public String lastName;
    public String unEvaluatedOrderId;
    public String unEvaluatedOrderTime;

    public int describeContents() {
        return 0;
    }

    public UserInfoEntity() {
    }

    protected UserInfoEntity(Parcel parcel) {
        this.headUrl = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.hasNewMsg = parcel.readInt() != 1 ? false : true;
        this.unEvaluatedOrderId = parcel.readString();
        this.unEvaluatedOrderTime = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.headUrl);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeInt(this.hasNewMsg ? 1 : 0);
        parcel.writeString(this.unEvaluatedOrderId);
        parcel.writeString(this.unEvaluatedOrderTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoEntity)) {
            return false;
        }
        UserInfoEntity userInfoEntity = (UserInfoEntity) obj;
        if (Objects.equals(this.headUrl, userInfoEntity.headUrl) && Objects.equals(this.firstName, userInfoEntity.firstName) && Objects.equals(this.lastName, userInfoEntity.lastName) && this.hasNewMsg == userInfoEntity.hasNewMsg && Objects.equals(this.unEvaluatedOrderId, userInfoEntity.unEvaluatedOrderId)) {
            return Objects.equals(this.unEvaluatedOrderTime, userInfoEntity.unEvaluatedOrderTime);
        }
        return false;
    }

    public int hashCode() {
        String str = this.headUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastName;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.hasNewMsg ? 1 : 0)) * 31;
        String str4 = this.unEvaluatedOrderId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.unEvaluatedOrderTime;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }
}

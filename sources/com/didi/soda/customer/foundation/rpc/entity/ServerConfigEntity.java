package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.HashMap;
import java.util.Map;

public class ServerConfigEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<ServerConfigEntity> CREATOR = new Parcelable.Creator<ServerConfigEntity>() {
        public ServerConfigEntity createFromParcel(Parcel parcel) {
            return new ServerConfigEntity(parcel);
        }

        public ServerConfigEntity[] newArray(int i) {
            return new ServerConfigEntity[i];
        }
    };
    private static final long serialVersionUID = -3151043849858372300L;
    public String countryCode;
    public long countyGroupId;
    public long countyId;
    public String currency;
    public String orderCancelUri;
    public int payTimeout;
    public long policyVersion;
    public int searchRecTagsRow;
    public String servicePhone;
    public int showStyle;
    public HashMap<String, ABConfigEntity> testConfig;

    public int describeContents() {
        return 0;
    }

    public ServerConfigEntity() {
    }

    protected ServerConfigEntity(Parcel parcel) {
        this.orderCancelUri = parcel.readString();
        this.showStyle = parcel.readInt();
        this.currency = parcel.readString();
        this.countryCode = parcel.readString();
        this.servicePhone = parcel.readString();
        this.searchRecTagsRow = parcel.readInt();
        this.policyVersion = parcel.readLong();
        this.countyId = parcel.readLong();
        this.countyGroupId = parcel.readLong();
        this.testConfig = new HashMap<>();
        try {
            HashMap hashMap = (HashMap) GsonUtil.fromJson(parcel.readString(), HashMap.class);
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    this.testConfig.put((String) entry.getKey(), (ABConfigEntity) GsonUtil.fromJson(GsonUtil.toJson(entry.getValue()), ABConfigEntity.class));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        parcel.writeString(this.orderCancelUri);
        parcel.writeInt(this.showStyle);
        parcel.writeString(this.currency);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.servicePhone);
        parcel.writeInt(this.searchRecTagsRow);
        parcel.writeLong(this.policyVersion);
        parcel.writeLong(this.countyId);
        parcel.writeLong(this.countyGroupId);
        try {
            str = GsonUtil.toJson(this.testConfig);
        } catch (Throwable unused) {
            str = "";
        }
        parcel.writeString(str);
    }
}

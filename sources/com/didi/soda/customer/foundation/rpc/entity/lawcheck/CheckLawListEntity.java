package com.didi.soda.customer.foundation.rpc.entity.lawcheck;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.HashMap;
import java.util.Map;

public class CheckLawListEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<CheckLawListEntity> CREATOR = new Parcelable.Creator<CheckLawListEntity>() {
        public CheckLawListEntity createFromParcel(Parcel parcel) {
            return new CheckLawListEntity(parcel);
        }

        public CheckLawListEntity[] newArray(int i) {
            return new CheckLawListEntity[i];
        }
    };
    private static final long serialVersionUID = 5404577220929662604L;
    public Map<CheckLawKeyEntity, CheckLawValueEntity> map;

    public int describeContents() {
        return 0;
    }

    public CheckLawListEntity() {
        this.map = new HashMap();
    }

    protected CheckLawListEntity(Parcel parcel) {
        int readInt = parcel.readInt();
        this.map = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.map.put((CheckLawKeyEntity) parcel.readParcelable(CheckLawKeyEntity.class.getClassLoader()), (CheckLawValueEntity) parcel.readParcelable(CheckLawValueEntity.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.map.size());
        for (Map.Entry next : this.map.entrySet()) {
            parcel.writeParcelable((Parcelable) next.getKey(), i);
            parcel.writeParcelable((Parcelable) next.getValue(), i);
        }
    }
}

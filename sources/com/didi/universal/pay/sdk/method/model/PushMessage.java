package com.didi.universal.pay.sdk.method.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PushMessage implements Parcelable {
    public static final int CODE_BILL_CHANGED = 1;
    public static final int CODE_HAS_PAYED = 2;
    public static final int CODE_NOPWD_PAY_FAILED = 3;
    public static final int CODE_PAYED_OFFLINE = 4;
    public static final Parcelable.Creator<PushMessage> CREATOR = new Parcelable.Creator<PushMessage>() {
        public PushMessage createFromParcel(Parcel parcel) {
            return new PushMessage(parcel);
        }

        public PushMessage[] newArray(int i) {
            return new PushMessage[i];
        }
    };
    public int code;
    public String data;
    public String msg;
    public String oid;
    public String productId;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "code:" + this.code + "," + "msg:" + this.msg + "," + "oid:" + this.oid + "," + "productId:" + this.productId + "," + "data:" + this.data;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.oid);
        parcel.writeString(this.productId);
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeString(this.data);
    }

    public PushMessage() {
    }

    protected PushMessage(Parcel parcel) {
        this.oid = parcel.readString();
        this.productId = parcel.readString();
        this.code = parcel.readInt();
        this.msg = parcel.readString();
        this.data = parcel.readString();
    }
}

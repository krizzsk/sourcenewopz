package com.didi.aoe.library.core.pojos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class Message implements Parcelable {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        public Message[] newArray(int i) {
            return new Message[i];
        }
    };

    /* renamed from: a */
    private int f8206a;

    /* renamed from: b */
    private int f8207b;

    /* renamed from: c */
    private byte[] f8208c;

    public int describeContents() {
        return 0;
    }

    public Message() {
    }

    public Message(byte[] bArr) {
        this(1, 0, bArr);
    }

    public Message(int i, int i2, byte[] bArr) {
        this.f8206a = i;
        this.f8207b = i2;
        this.f8208c = bArr;
    }

    private Message(Parcel parcel) {
        this.f8206a = parcel.readInt();
        this.f8207b = parcel.readInt();
        this.f8208c = parcel.createByteArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8206a);
        parcel.writeInt(this.f8207b);
        parcel.writeByteArray(this.f8208c);
    }

    public int getPartNum() {
        return this.f8206a;
    }

    public void setPartNum(int i) {
        this.f8206a = i;
    }

    public int getPartIndex() {
        return this.f8207b;
    }

    public void setPartIndex(int i) {
        this.f8207b = i;
    }

    public byte[] getData() {
        return this.f8208c;
    }

    public void setData(byte[] bArr) {
        this.f8208c = bArr;
    }

    public String toString() {
        return "Message{partNum=" + this.f8206a + ", partIndex=" + this.f8207b + ", data=" + Arrays.toString(this.f8208c) + '}';
    }
}

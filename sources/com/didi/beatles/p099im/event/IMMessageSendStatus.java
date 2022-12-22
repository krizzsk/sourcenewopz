package com.didi.beatles.p099im.event;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.didi.beatles.im.event.IMMessageSendStatus */
public class IMMessageSendStatus implements Parcelable {
    public static final Parcelable.Creator<IMMessageSendStatus> CREATOR = new Parcelable.Creator<IMMessageSendStatus>() {
        public IMMessageSendStatus createFromParcel(Parcel parcel) {
            return new IMMessageSendStatus(parcel);
        }

        public IMMessageSendStatus[] newArray(int i) {
            return new IMMessageSendStatus[i];
        }
    };
    public static final String action = "im_message_send_status_change";
    public long messageId;
    public long peerUid;
    public int productId;
    public int sendStatus;
    public long sessionId;

    public int describeContents() {
        return 0;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(long j) {
        this.messageId = j;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(long j) {
        this.sessionId = j;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }

    public long getPeerUid() {
        return this.peerUid;
    }

    public void setPeerUid(long j) {
        this.peerUid = j;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.messageId);
        parcel.writeLong(this.sessionId);
        parcel.writeInt(this.sendStatus);
        parcel.writeLong(this.peerUid);
        parcel.writeInt(this.productId);
    }

    public IMMessageSendStatus() {
    }

    protected IMMessageSendStatus(Parcel parcel) {
        this.messageId = parcel.readLong();
        this.sessionId = parcel.readLong();
        this.sendStatus = parcel.readInt();
        this.peerUid = parcel.readLong();
        this.productId = parcel.readInt();
    }
}

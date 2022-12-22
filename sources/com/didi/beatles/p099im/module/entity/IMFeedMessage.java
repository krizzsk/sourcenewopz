package com.didi.beatles.p099im.module.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.beatles.p099im.api.entity.IMMessageDownExtend;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.module.entity.IMFeedMessage */
public class IMFeedMessage implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<IMFeedMessage> CREATOR = new Parcelable.Creator<IMFeedMessage>() {
        public IMFeedMessage createFromParcel(Parcel parcel) {
            return new IMFeedMessage(parcel);
        }

        public IMFeedMessage[] newArray(int i) {
            return new IMFeedMessage[i];
        }
    };
    public long activityId;
    public String content;
    public long createTime;
    public long mid;
    public String noticeId;
    public String uniqueCloudMsgId;

    public int describeContents() {
        return 0;
    }

    public IMFeedMessage(IMMessage iMMessage) {
        this.mid = iMMessage.getMid();
        this.content = iMMessage.getContent();
        this.createTime = iMMessage.getCreateTime();
        this.uniqueCloudMsgId = iMMessage.getCloudUniqueMsgId();
        IMMessageDownExtend messageExtendInfo = iMMessage.getMessageExtendInfo();
        this.activityId = messageExtendInfo.activity_id;
        this.noticeId = messageExtendInfo.msg_unique_id;
    }

    protected IMFeedMessage(Parcel parcel) {
        this.mid = parcel.readLong();
        this.content = parcel.readString();
        this.createTime = parcel.readLong();
        this.uniqueCloudMsgId = parcel.readString();
        this.activityId = parcel.readLong();
        this.noticeId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mid);
        parcel.writeString(this.content);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.uniqueCloudMsgId);
        parcel.writeLong(this.activityId);
        parcel.writeString(this.noticeId);
    }

    public long getMid() {
        return this.mid;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCloudUniqueMsgId() {
        return this.uniqueCloudMsgId;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public String getMsgUniqueId() {
        return this.noticeId;
    }

    public String toString() {
        return "IMFeedMessage{mid=" + this.mid + ", content='" + this.content + '\'' + ", createTime=" + this.createTime + ", uniqueCloudMsgId=" + this.uniqueCloudMsgId + ", activityId=" + this.activityId + ", noticeId='" + this.noticeId + '\'' + '}';
    }
}

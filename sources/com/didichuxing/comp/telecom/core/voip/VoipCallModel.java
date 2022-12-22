package com.didichuxing.comp.telecom.core.voip;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006#"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "Ljava/io/Serializable;", "()V", "event", "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "eventTime", "", "getEventTime", "()Ljava/lang/Long;", "setEventTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expireTime", "getExpireTime", "setExpireTime", "roomInfo", "Lcom/didichuxing/comp/telecom/core/voip/RoomInfo;", "getRoomInfo", "()Lcom/didichuxing/comp/telecom/core/voip/RoomInfo;", "setRoomInfo", "(Lcom/didichuxing/comp/telecom/core/voip/RoomInfo;)V", "voipSessionId", "getVoipSessionId", "setVoipSessionId", "equals", "", "other", "", "hashCode", "", "toString", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipCallModel.kt */
public class VoipCallModel implements Serializable {
    @SerializedName("event")
    private String event;
    @SerializedName("event_time")
    private Long eventTime;
    @SerializedName("expire_time")
    private Long expireTime;
    @SerializedName("room_info")
    private RoomInfo roomInfo;
    @SerializedName("voip_session_id")
    private String voipSessionId;

    public final String getVoipSessionId() {
        return this.voipSessionId;
    }

    public final void setVoipSessionId(String str) {
        this.voipSessionId = str;
    }

    public final RoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public final void setRoomInfo(RoomInfo roomInfo2) {
        this.roomInfo = roomInfo2;
    }

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final Long getEventTime() {
        return this.eventTime;
    }

    public final void setEventTime(Long l) {
        this.eventTime = l;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final void setExpireTime(Long l) {
        this.expireTime = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoipCallModel)) {
            return false;
        }
        VoipCallModel voipCallModel = (VoipCallModel) obj;
        if (!(!Intrinsics.areEqual((Object) this.voipSessionId, (Object) voipCallModel.voipSessionId))) {
            RoomInfo roomInfo2 = this.roomInfo;
            String str = null;
            String roomId = roomInfo2 != null ? roomInfo2.getRoomId() : null;
            RoomInfo roomInfo3 = voipCallModel.roomInfo;
            if (roomInfo3 != null) {
                str = roomInfo3.getRoomId();
            }
            if (!Intrinsics.areEqual((Object) roomId, (Object) str)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String roomId;
        String str = this.voipSessionId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        RoomInfo roomInfo2 = this.roomInfo;
        if (!(roomInfo2 == null || (roomId = roomInfo2.getRoomId()) == null)) {
            i = roomId.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VoipCallModel(voipSessionId=");
        sb.append(this.voipSessionId);
        sb.append(", roomInfo=");
        RoomInfo roomInfo2 = this.roomInfo;
        sb.append(roomInfo2 != null ? roomInfo2.getRoomId() : null);
        sb.append(", event=");
        sb.append(this.event);
        sb.append(", eventTime=");
        sb.append(this.eventTime);
        sb.append(", expireTime=");
        sb.append(this.expireTime);
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }
}

package com.didichuxing.comp.telecom.core.voip;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR \u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR \u0010+\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR \u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000f¨\u00061"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/RoomInfo;", "Ljava/io/Serializable;", "()V", "callingExitNum", "", "getCallingExitNum", "()Ljava/lang/Integer;", "setCallingExitNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "notAnswerExit", "getNotAnswerExit", "setNotAnswerExit", "noticeText", "Lcom/didichuxing/comp/telecom/core/voip/NoticeText;", "getNoticeText", "()Lcom/didichuxing/comp/telecom/core/voip/NoticeText;", "setNoticeText", "(Lcom/didichuxing/comp/telecom/core/voip/NoticeText;)V", "onMicNum", "getOnMicNum", "setOnMicNum", "oppositeAvatar", "getOppositeAvatar", "setOppositeAvatar", "oppositeNickname", "getOppositeNickname", "setOppositeNickname", "poor_network_level", "getPoor_network_level", "setPoor_network_level", "roomId", "getRoomId", "setRoomId", "roomPin", "getRoomPin", "setRoomPin", "roomType", "getRoomType", "setRoomType", "roomUrl", "getRoomUrl", "setRoomUrl", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipCallModel.kt */
public final class RoomInfo implements Serializable {
    @SerializedName("calling_exit_num")
    private Integer callingExitNum;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("not_answer_exit")
    private Integer notAnswerExit;
    @SerializedName("notice_text")
    private NoticeText noticeText;
    @SerializedName("on_mic_num")
    private Integer onMicNum;
    @SerializedName("opposite_avatar")
    private String oppositeAvatar;
    @SerializedName("opposite_nickname")
    private String oppositeNickname;
    @SerializedName("poor_network_level")
    private Integer poor_network_level;
    @SerializedName("room_id")
    private String roomId;
    @SerializedName("room_pin")
    private String roomPin;
    @SerializedName("room_type")
    private String roomType;
    @SerializedName("room_url")
    private String roomUrl;

    public final Integer getCallingExitNum() {
        return this.callingExitNum;
    }

    public final void setCallingExitNum(Integer num) {
        this.callingExitNum = num;
    }

    public final Integer getNotAnswerExit() {
        return this.notAnswerExit;
    }

    public final void setNotAnswerExit(Integer num) {
        this.notAnswerExit = num;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final String getRoomUrl() {
        return this.roomUrl;
    }

    public final void setRoomUrl(String str) {
        this.roomUrl = str;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final String getRoomPin() {
        return this.roomPin;
    }

    public final void setRoomPin(String str) {
        this.roomPin = str;
    }

    public final String getRoomType() {
        return this.roomType;
    }

    public final void setRoomType(String str) {
        this.roomType = str;
    }

    public final String getOppositeAvatar() {
        return this.oppositeAvatar;
    }

    public final void setOppositeAvatar(String str) {
        this.oppositeAvatar = str;
    }

    public final String getOppositeNickname() {
        return this.oppositeNickname;
    }

    public final void setOppositeNickname(String str) {
        this.oppositeNickname = str;
    }

    public final Integer getOnMicNum() {
        return this.onMicNum;
    }

    public final void setOnMicNum(Integer num) {
        this.onMicNum = num;
    }

    public final Integer getPoor_network_level() {
        return this.poor_network_level;
    }

    public final void setPoor_network_level(Integer num) {
        this.poor_network_level = num;
    }

    public final NoticeText getNoticeText() {
        return this.noticeText;
    }

    public final void setNoticeText(NoticeText noticeText2) {
        this.noticeText = noticeText2;
    }
}

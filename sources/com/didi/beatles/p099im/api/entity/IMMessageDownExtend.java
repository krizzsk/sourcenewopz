package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMMessageDownExtend */
public class IMMessageDownExtend implements Serializable {
    public long activity_id;
    @SerializedName("down_ext")
    public String downExt;
    public int eggsDisplayCount;
    public int eid;
    private String emoji_desc;
    private String emoji_id;
    private Object ext;
    public int is_qk = 0;
    public String light_link;
    public String light_str;
    public String list_text;
    @SerializedName("msg_source")
    public int msg_source = 0;
    public String msg_unique_id;
    public int picIsExpired;
    public int pluginId;
    public IMTransBody trans;

    /* renamed from: com.didi.beatles.im.api.entity.IMMessageDownExtend$MessagePicExpiredEntity */
    public static class MessagePicExpiredEntity {
        public static final int hadExpiredPic = 1;
        public static final int hadNotExpiredPic = 0;
    }

    public int getPicIsExpired() {
        return this.picIsExpired;
    }

    public void setPicIsExpired(int i) {
        this.picIsExpired = i;
    }

    public Object getExt() {
        return this.ext;
    }

    public void setExt(Object obj) {
        this.ext = obj;
    }

    public String getEmoji_desc() {
        return this.emoji_desc;
    }

    public void setEmoji_desc(String str) {
        this.emoji_desc = str;
    }

    public String getEmoji_id() {
        return this.emoji_id;
    }

    public void setEmoji_id(String str) {
        this.emoji_id = str;
    }

    public IMMessageDownExtend(long j, String str, int i) {
        this.activity_id = j;
        this.list_text = str;
        this.is_qk = i;
    }

    public IMMessageDownExtend(long j, String str) {
        this.list_text = str;
        this.activity_id = j;
    }

    public IMMessageDownExtend() {
    }

    public void setTrans(IMTransBody iMTransBody) {
        this.trans = iMTransBody;
    }

    public int getIs_qk() {
        return this.is_qk;
    }

    public void setIs_qk(int i) {
        this.is_qk = i;
    }

    public int getMsgSource() {
        return this.msg_source;
    }

    public void setMsgSource(int i) {
        this.msg_source = i;
    }

    public void setSystemHiglitTetx(String str, String str2) {
        this.light_str = str;
        this.light_link = str2;
    }

    public void setMsgUniqueId(String str) {
        this.msg_unique_id = str;
    }

    public String getMsgUniqueId() {
        return this.msg_unique_id;
    }

    public int getEid() {
        return this.eid;
    }

    public void setEid(int i) {
        this.eid = i;
    }

    public int getPluginId() {
        return this.pluginId;
    }

    public void setPluginId(int i) {
        this.pluginId = i;
    }

    public int getEggsDisplayCount() {
        return this.eggsDisplayCount;
    }

    public void setEggsDisplayCount(int i) {
        this.eggsDisplayCount = i;
    }
}

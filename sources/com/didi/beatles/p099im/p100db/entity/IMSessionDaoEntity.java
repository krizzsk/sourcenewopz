package com.didi.beatles.p099im.p100db.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.db.entity.IMSessionDaoEntity */
public class IMSessionDaoEntity implements Serializable {
    private int business_id;
    private String clientExtends;
    private String draft;
    private Boolean is_info_loaded;
    private String last_message;
    private String last_modify_id;
    private long last_modify_time;
    private long last_recv_ack_mid;
    private long last_send_ack_mid;
    private String recentMessages;
    private int reserveInt1;
    private int reserveInt2;
    private String reserveStr3;
    private String serviceExtends;
    private long session_id;
    private String session_img;
    private String session_name;
    private int type;
    private String uid_list;
    private int unread_count;
    private long update_time;

    public IMSessionDaoEntity() {
    }

    public IMSessionDaoEntity(long j) {
        this.session_id = j;
    }

    public IMSessionDaoEntity(long j, long j2, String str, String str2, String str3, int i, int i2, long j3, long j4, String str4, long j5, Boolean bool, String str5, int i3, int i4, int i5, String str6, String str7, String str8, String str9, String str10) {
        this.session_id = j;
        this.update_time = j2;
        this.session_name = str;
        this.uid_list = str2;
        this.draft = str3;
        this.type = i;
        this.unread_count = i2;
        this.last_recv_ack_mid = j3;
        this.last_send_ack_mid = j4;
        this.last_modify_id = str4;
        this.last_modify_time = j5;
        this.is_info_loaded = bool;
        this.last_message = str5;
        this.business_id = i3;
        this.reserveInt1 = i4;
        this.reserveInt2 = i5;
        this.reserveStr3 = str6;
        this.session_img = str7;
        this.recentMessages = str8;
        this.clientExtends = str9;
        this.serviceExtends = str10;
    }

    public long getSession_id() {
        return this.session_id;
    }

    public void setSession_id(long j) {
        this.session_id = j;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public String getSession_name() {
        return this.session_name;
    }

    public void setSession_name(String str) {
        this.session_name = str;
    }

    public String getUid_list() {
        return this.uid_list;
    }

    public void setUid_list(String str) {
        this.uid_list = str;
    }

    public String getDraft() {
        return this.draft;
    }

    public void setDraft(String str) {
        this.draft = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getUnread_count() {
        return this.unread_count;
    }

    public void setUnread_count(int i) {
        this.unread_count = i;
    }

    public long getLast_recv_ack_mid() {
        return this.last_recv_ack_mid;
    }

    public void setLast_recv_ack_mid(long j) {
        this.last_recv_ack_mid = j;
    }

    public long getLast_send_ack_mid() {
        return this.last_send_ack_mid;
    }

    public void setLast_send_ack_mid(long j) {
        this.last_send_ack_mid = j;
    }

    public String getLast_modify_id() {
        return this.last_modify_id;
    }

    public void setLast_modify_id(String str) {
        this.last_modify_id = str;
    }

    public long getLast_modify_time() {
        return this.last_modify_time;
    }

    public void setLast_modify_time(long j) {
        this.last_modify_time = j;
    }

    public Boolean getIs_info_loaded() {
        Boolean bool = this.is_info_loaded;
        if (bool == null) {
            return true;
        }
        return bool;
    }

    public void setIs_info_loaded(Boolean bool) {
        this.is_info_loaded = bool;
    }

    public String getLast_message() {
        return this.last_message;
    }

    public void setLast_message(String str) {
        this.last_message = str;
    }

    public int getBusiness_id() {
        return this.business_id;
    }

    public void setBusiness_id(int i) {
        this.business_id = i;
    }

    public int getReserveInt1() {
        return this.reserveInt1;
    }

    public void setReserveInt1(int i) {
        this.reserveInt1 = i;
    }

    public int getReserveInt2() {
        return this.reserveInt2;
    }

    public void setReserveInt2(int i) {
        this.reserveInt2 = i;
    }

    public String getReserveStr3() {
        return this.reserveStr3;
    }

    public void setReserveStr3(String str) {
        this.reserveStr3 = str;
    }

    public String getSession_img() {
        return this.session_img;
    }

    public void setSession_img(String str) {
        this.session_img = str;
    }

    public String getRecentMessages() {
        return this.recentMessages;
    }

    public void setRecentMessages(String str) {
        this.recentMessages = str;
    }

    public String getClientExtends() {
        return this.clientExtends;
    }

    public void setClientExtends(String str) {
        this.clientExtends = str;
    }

    public String getServiceExtends() {
        return this.serviceExtends;
    }

    public void setServiceExtends(String str) {
        this.serviceExtends = str;
    }
}

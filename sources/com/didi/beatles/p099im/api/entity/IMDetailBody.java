package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMDetailBody */
public class IMDetailBody implements Serializable {
    public long activity_id;
    public String batcheid;
    public List<IMPushBtnBody> btns = new ArrayList();
    public String cont;
    public String desc;
    public int eid;
    public String emojiId;
    public String event_id;
    public Object ext;
    public String fid;
    public String ftoken;
    public int height;
    public String light_link;
    public String light_str;
    public String list_text;
    public String msg_unique_id;

    /* renamed from: ns */
    public String f9126ns;
    public int pluginId;
    public int sec;
    public int size;
    public String top_content;
    public String top_text;
    public IMTransBody trans;
    public String voice;
    public int width;

    public IMDetailBody() {
    }

    public IMDetailBody(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, String str6, String str7, String str8, long j, JsonObject jsonObject, JsonArray jsonArray, String str9, JsonObject jsonObject2, String str10, int i5, int i6, String str11, String str12) {
        JsonObject jsonObject3 = jsonObject;
        JsonArray jsonArray2 = jsonArray;
        JsonObject jsonObject4 = jsonObject2;
        this.event_id = str;
        this.f9126ns = str3;
        this.ftoken = str4;
        this.fid = str5;
        this.size = i;
        this.sec = i2;
        this.width = i3;
        this.height = i4;
        this.list_text = str6;
        this.top_text = str7;
        this.top_content = str8;
        this.activity_id = j;
        this.cont = str2;
        this.batcheid = str9;
        this.msg_unique_id = str10;
        this.eid = i5;
        this.pluginId = i6;
        this.voice = str11;
        if (jsonObject3 != null && jsonObject3.has("light_str")) {
            this.light_str = jsonObject3.get("light_str").getAsString();
        }
        if (jsonObject3 != null && jsonObject3.has("light_link")) {
            this.light_link = jsonObject3.get("light_link").getAsString();
        }
        if (jsonObject3 != null && jsonObject3.has("desc")) {
            this.desc = jsonObject3.get("desc").getAsString();
        }
        if (jsonObject3 != null && jsonObject3.has("emojiId")) {
            this.emojiId = jsonObject3.get("emojiId").getAsString();
        }
        if (jsonObject4 != null) {
            this.trans = (IMTransBody) IMJsonUtil.objectFromJson(jsonObject4, IMTransBody.class);
        }
        this.ext = str12;
        if (jsonArray2 != null) {
            int size2 = jsonArray.size();
            for (int i7 = 0; i7 < size2; i7++) {
                this.btns.add((IMPushBtnBody) IMJsonUtil.objectFromJson(jsonArray2.get(i7), IMPushBtnBody.class));
            }
        }
    }
}

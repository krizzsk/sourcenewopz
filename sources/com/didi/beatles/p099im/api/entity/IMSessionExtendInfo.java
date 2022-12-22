package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.module.IMExtendBtnModule;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMSessionExtendInfo */
public class IMSessionExtendInfo implements Serializable {
    public int ack;
    @SerializedName("more_action_list")
    public List<Integer> actionIds;
    @SerializedName("bottom_tab_list")
    public List<BottomTabInfo> bottomTabInfoList;
    public int can_forbid;
    @SerializedName("emoji_key")
    public String emojiKey;
    public long flush_time;
    public int forbid;
    public int groupNum;
    public int input = 1;
    public int istop;
    @SerializedName("label")
    public String label;
    public String lag_ty;
    public List<IMExtendBtnModule> more;
    @SerializedName("na_txt_invalid")
    public String naTxtInvalid;
    public String na_txt;
    @SerializedName("open_action_list")
    public List<Integer> openActionIds;
    @SerializedName("orderid")
    public String orderId;
    public String qk_key = "";
    @SerializedName("robot_theme")
    public int robotTheme;
    @SerializedName("routeid")
    public String routeId;
    @SerializedName("side_menu")
    public List<SideMenu> sideMenu;
    public String slink;
    public String stag;
    @SerializedName("top_extend_info")
    public String titleExtendInfo;
    @SerializedName("watermark")
    public String watermark;

    /* renamed from: com.didi.beatles.im.api.entity.IMSessionExtendInfo$SideMenu */
    public static class SideMenu implements Serializable {
        public static final String ICON_PHONE = "phone";
        public static final String TYPE_COMPLAINT = "complaint";
        public static final String TYPE_PHONE = "phone";
        @SerializedName("icon")
        public String icon;
        @SerializedName("text")
        public String text;
        @SerializedName("type")
        public String type;
    }

    public IMSessionExtendInfo(String str, String str2, int i, String str3, String str4, int i2, String str5) {
        this.slink = str;
        this.stag = str2;
        this.input = i;
        this.na_txt = str3;
        this.qk_key = str4;
        this.ack = i2;
        this.lag_ty = str5;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMSessionExtendInfo$SysTipItem */
    public class SysTipItem {
        public String action;
        public int count;

        public SysTipItem() {
        }
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMSessionExtendInfo$BottomTabInfo */
    public static class BottomTabInfo implements Serializable {
        @SerializedName("enable")
        public int enable;
        @SerializedName("id")

        /* renamed from: id */
        public int f9129id;
        public boolean ignore;
        public String name;

        public boolean isEnable() {
            return this.enable == 1;
        }

        public String toString() {
            return "BottomTabInfo{id=" + this.f9129id + "name=" + this.name + ", enable=" + this.enable + '}';
        }
    }
}

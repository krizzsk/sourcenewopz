package com.didiglobal.p205sa.biz.component.businesscard.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.misconfig.p153v2.model.PriConfModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel */
public class BusinessCardModel implements Serializable {
    public List<BusinessMenuModel> businessMenu;
    public Config config;
    public MoreBusiness moreBusiness;
    @SerializedName("primary_menu")
    public PriConfModel primaryMenu;

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$ActivityTag */
    public static class ActivityTag implements Serializable {
        public String color_end;
        public String color_start;
        public LEGORichInfo info;
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$Config */
    public static class Config implements Serializable {
        public int cardStyle;
        public LEGORichInfo title;
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$HotInfo */
    public static class HotInfo implements Serializable {
        public String hotIcon;
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$MoreBusiness */
    public static class MoreBusiness implements Serializable {
        public String backGroundColor;
        public String moreIcon;
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$StyleWeight */
    public enum StyleWeight {
        BIG(6),
        MID(4),
        SMALL(3);
        
        private int value;

        private StyleWeight(int i) {
            this.value = i;
        }

        public int getWeight() {
            return this.value;
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$Style */
    public enum Style {
        BIG(1),
        MID(2),
        SMALL(3);
        
        private int value;

        private Style(int i) {
            this.value = i;
        }

        public int getType() {
            return this.value;
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.model.BusinessCardModel$BusinessMenuModel */
    public static class BusinessMenuModel implements Serializable {
        public String backGroundColor;
        public String businessIcon;
        public String businessIconGif;
        @SerializedName("entrance_id")
        public String entranceId;
        public String groupType;
        public HotInfo hotInfo;
        public JsonObject log_data;
        public LEGORichInfo name;
        public String schema;
        public int style;
        @SerializedName("activity_tags")
        public List<ActivityTag> tags;

        public String toString() {
            return "BusinessMenuModel{name=" + this.name + ", groupType='" + this.groupType + '\'' + ", businessIcon='" + this.businessIcon + '\'' + ", businessIconGif='" + this.businessIconGif + '\'' + ", backGroundColor='" + this.backGroundColor + '\'' + ", style=" + this.style + ", schema='" + this.schema + '\'' + ", hotInfo=" + this.hotInfo + ", tags=" + this.tags + '}';
        }
    }
}

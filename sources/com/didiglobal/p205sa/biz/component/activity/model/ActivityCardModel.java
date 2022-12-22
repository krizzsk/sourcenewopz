package com.didiglobal.p205sa.biz.component.activity.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityCardModel */
public class ActivityCardModel implements Serializable {
    private String bg_color;
    private String business_image;
    private String business_label;
    private List<ButtonsBean> buttons;
    private String card_url;
    private String identifier;
    private LinkedTreeMap<String, Object> log_data;
    private LEGORichInfo order_flag;
    private LEGORichInfo order_flag_tips;
    private LEGORichInfo order_status;
    private LEGORichInfo order_status_detail;
    private LEGORichInfo title;
    private String type_id;

    public String getCard_url() {
        return this.card_url;
    }

    public void setCard_url(String str) {
        this.card_url = str;
    }

    public String getType_id() {
        return this.type_id;
    }

    public void setType_id(String str) {
        this.type_id = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getBusiness_label() {
        return this.business_label;
    }

    public void setBusiness_label(String str) {
        this.business_label = str;
    }

    public LinkedTreeMap<String, Object> getLog_data() {
        return this.log_data;
    }

    public void setLog_data(LinkedTreeMap<String, Object> linkedTreeMap) {
        this.log_data = linkedTreeMap;
    }

    public LEGORichInfo getTitle() {
        return this.title;
    }

    public void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public LEGORichInfo getOrder_status() {
        return this.order_status;
    }

    public void setOrder_status(LEGORichInfo lEGORichInfo) {
        this.order_status = lEGORichInfo;
    }

    public LEGORichInfo getOrder_status_detail() {
        return this.order_status_detail;
    }

    public void setOrder_status_detail(LEGORichInfo lEGORichInfo) {
        this.order_status_detail = lEGORichInfo;
    }

    public LEGORichInfo getOrder_flag() {
        return this.order_flag;
    }

    public void setOrder_flag(LEGORichInfo lEGORichInfo) {
        this.order_flag = lEGORichInfo;
    }

    public LEGORichInfo getOrder_flag_tips() {
        return this.order_flag_tips;
    }

    public void setOrder_flag_tips(LEGORichInfo lEGORichInfo) {
        this.order_flag_tips = lEGORichInfo;
    }

    public String getBusiness_image() {
        return this.business_image;
    }

    public void setBusiness_image(String str) {
        this.business_image = str;
    }

    public String getBg_color() {
        return this.bg_color;
    }

    public void setBg_color(String str) {
        this.bg_color = str;
    }

    public List<ButtonsBean> getButtons() {
        return this.buttons;
    }

    public void setButtons(List<ButtonsBean> list) {
        this.buttons = list;
    }

    /* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityCardModel$LogDataBean */
    public static class LogDataBean implements Serializable {
        private LinkedTreeMap<String, Object> map;

        public LinkedTreeMap<String, Object> getMap() {
            return this.map;
        }

        public void setMap(LinkedTreeMap<String, Object> linkedTreeMap) {
            this.map = linkedTreeMap;
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityCardModel$ButtonsBean */
    public static class ButtonsBean implements Serializable {
        private String action;
        private String end_color;
        private LEGORichInfo info;
        private LinkedTreeMap<String, Object> log_data;
        private String start_color;

        public LinkedTreeMap<String, Object> getLog_data() {
            return this.log_data;
        }

        public void setLog_data(LinkedTreeMap<String, Object> linkedTreeMap) {
            this.log_data = linkedTreeMap;
        }

        public String getAction() {
            return this.action;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public String getStart_color() {
            return this.start_color;
        }

        public void setStart_color(String str) {
            this.start_color = str;
        }

        public String getEnd_color() {
            return this.end_color;
        }

        public void setEnd_color(String str) {
            this.end_color = str;
        }

        public LEGORichInfo getInfo() {
            return this.info;
        }

        public void setInfo(LEGORichInfo lEGORichInfo) {
            this.info = lEGORichInfo;
        }
    }
}

package com.didiglobal.p205sa.biz.component.drainageguide;

import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageModel */
public class SADrainageModel implements Serializable {
    private String business_type;
    private String image = "";
    private LinkedTreeMap<String, Object> log_data;
    private String point_action;
    private int show;
    private String tips = "";
    private String tips_action;

    public int getShow() {
        return this.show;
    }

    public void setShow(int i) {
        this.show = i;
    }

    public LinkedTreeMap<String, Object> getLog_data() {
        return this.log_data;
    }

    public void setLog_data(LinkedTreeMap<String, Object> linkedTreeMap) {
        this.log_data = linkedTreeMap;
    }

    public String getBusiness_type() {
        return this.business_type;
    }

    public void setBusiness_type(String str) {
        this.business_type = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String getTips_action() {
        return this.tips_action;
    }

    public void setTips_action(String str) {
        this.tips_action = str;
    }

    public String getPoint_action() {
        return this.point_action;
    }

    public void setPoint_action(String str) {
        this.point_action = str;
    }
}

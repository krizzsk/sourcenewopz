package com.didiglobal.p205sa.biz.component.guide;

import java.io.Serializable;

/* renamed from: com.didiglobal.sa.biz.component.guide.GuideTipModel */
public class GuideTipModel implements Serializable {
    private String action_button;
    private String kingkong_card_tips;
    private String kingkong_item_tips;
    private String main_card_tips;
    private String recommend_card_tips;
    private int user_type;

    public int getUser_type() {
        return this.user_type;
    }

    public void setUser_type(int i) {
        this.user_type = i;
    }

    public String getMain_card_tips() {
        return this.main_card_tips;
    }

    public void setMain_card_tips(String str) {
        this.main_card_tips = str;
    }

    public String getKingkong_card_tips() {
        return this.kingkong_card_tips;
    }

    public void setKingkong_card_tips(String str) {
        this.kingkong_card_tips = str;
    }

    public String getKingkong_item_tips() {
        return this.kingkong_item_tips;
    }

    public void setKingkong_item_tips(String str) {
        this.kingkong_item_tips = str;
    }

    public String getRecommend_card_tips() {
        return this.recommend_card_tips;
    }

    public void setRecommend_card_tips(String str) {
        this.recommend_card_tips = str;
    }

    public String getAction_button() {
        return this.action_button;
    }

    public void setAction_button(String str) {
        this.action_button = str;
    }
}

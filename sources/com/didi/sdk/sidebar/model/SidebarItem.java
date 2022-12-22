package com.didi.sdk.sidebar.model;

import com.google.gson.JsonObject;
import java.io.Serializable;

public class SidebarItem implements Serializable {
    private String color;
    private String componentType;
    private String des;
    private JsonObject dialog;
    private String discountMsg;
    private RedPoints fireTorch;
    private String fontColor;
    private String iconUrl;

    /* renamed from: id */
    private int f37424id;
    private String memberIcon;
    private String name;
    private RedPoints redPoints;
    private String redTag;
    private String rightDes;
    private String subPage;
    private boolean toggle;
    private String traceEvent;
    private String url;

    public String getSubPage() {
        return this.subPage;
    }

    public void setSubPage(String str) {
        this.subPage = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDes() {
        return this.des;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getRedTag() {
        return this.redTag;
    }

    public void setRedTag(String str) {
        this.redTag = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setRightDes(String str) {
        this.rightDes = str;
    }

    public String getComponentType() {
        return this.componentType;
    }

    public void setComponentType(String str) {
        this.componentType = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getRightDes() {
        return this.rightDes;
    }

    public int getId() {
        return this.f37424id;
    }

    public void setId(int i) {
        this.f37424id = i;
    }

    public RedPoints getRedPoints() {
        return this.redPoints;
    }

    public void setRedPoints(RedPoints redPoints2) {
        this.redPoints = redPoints2;
    }

    public RedPoints getFireTorch() {
        return this.fireTorch;
    }

    public void setFireTorch(RedPoints redPoints2) {
        this.fireTorch = redPoints2;
    }

    public String getTraceEvent() {
        return this.traceEvent;
    }

    public void setTraceEvent(String str) {
        this.traceEvent = str;
    }

    public String getMemberIcon() {
        return this.memberIcon;
    }

    public void setMemberIcon(String str) {
        this.memberIcon = str;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public boolean isToggle() {
        return this.toggle;
    }

    public void setToggle(boolean z) {
        this.toggle = z;
    }

    public JsonObject getDialog() {
        return this.dialog;
    }

    public void setDialog(JsonObject jsonObject) {
        this.dialog = jsonObject;
    }

    public void setDiscountMsg(String str) {
        this.discountMsg = str;
    }

    public String getDiscountMsg() {
        return this.discountMsg;
    }

    public String toString() {
        return "SidebarItem{name='" + this.name + '\'' + "  id='" + this.f37424id + '\'' + '}';
    }
}

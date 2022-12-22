package com.didi.component.operationpanel;

import com.didi.travel.psnger.model.response.GlobalRichInfo;

public class OperationPanelItemModel {
    public String componentType;
    public String corner_icon;
    public boolean enable = true;
    public boolean hasArrow = true;
    public String icon;

    /* renamed from: id */
    public int f14774id;
    public int index = 10000;
    public int labelIcon;
    public CharSequence labelName;
    public int labelNameId;
    public CharSequence operationName;
    public int operationNameId;
    public GlobalRichInfo richInfo;
    public String subTitle;
    public GlobalRichInfo title;
    public String toastTip;
    public int topIcon;
    public String url;

    public OperationPanelItemModel(int i, int i2, String str) {
        this.f14774id = i;
        this.componentType = str;
        this.index = i2;
    }

    public OperationPanelItemModel(int i, CharSequence charSequence) {
        this.f14774id = i;
        this.operationName = charSequence;
    }

    public OperationPanelItemModel(int i, int i2, int i3) {
        this.f14774id = i;
        this.operationNameId = i2;
        this.topIcon = i3;
    }

    public OperationPanelItemModel(int i, int i2, int i3, int i4) {
        this.f14774id = i;
        this.operationNameId = i2;
        this.topIcon = i3;
        this.index = i4;
    }

    public OperationPanelItemModel(int i, String str, int i2) {
        this.f14774id = i;
        this.operationName = str;
        this.topIcon = i2;
    }

    public OperationPanelItemModel(int i, CharSequence charSequence, int i2, CharSequence charSequence2) {
        this.f14774id = i;
        this.operationName = charSequence;
        this.labelIcon = i2;
        this.labelName = charSequence2;
    }

    public OperationPanelItemModel(int i, CharSequence charSequence, int i2, CharSequence charSequence2, boolean z, boolean z2) {
        this.f14774id = i;
        this.operationName = charSequence;
        this.labelIcon = i2;
        this.labelName = charSequence2;
        this.hasArrow = z;
        this.enable = z2;
    }

    public OperationPanelItemModel setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public OperationPanelItemModel setSubtitle(String str) {
        this.subTitle = str;
        return this;
    }

    public OperationPanelItemModel setTopIcon(int i) {
        this.topIcon = i;
        return this;
    }

    public OperationPanelItemModel setRichInfo(GlobalRichInfo globalRichInfo) {
        this.richInfo = globalRichInfo;
        return this;
    }

    public OperationPanelItemModel setToastTip(String str) {
        this.toastTip = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f14774id == ((OperationPanelItemModel) obj).f14774id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14774id;
    }

    public String toString() {
        return "OperationPanelItemModel{id=" + this.f14774id + ", operationName=" + this.operationName + ", labelIcon=" + this.labelIcon + ", labelName=" + this.labelName + ", hasArrow=" + this.hasArrow + ", enable=" + this.enable + '}';
    }

    public OperationPanelItemModel(int i, GlobalRichInfo globalRichInfo, String str, String str2, String str3) {
        this.f14774id = i;
        this.title = globalRichInfo;
        this.icon = str;
        this.corner_icon = str2;
        this.url = str3;
    }
}

package com.didi.component.comp_selectseat.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public class ScheduleItemModel {
    public static int ITEM_TYPE_SHIFT = 1;
    public static int ITEM_TYPE_TITLE;

    /* renamed from: a */
    private LEGORichInfo f12401a;

    /* renamed from: b */
    private ShiftBean f12402b;

    /* renamed from: c */
    private int f12403c;

    public int getViewType() {
        return this.f12403c;
    }

    public void setViewType(int i) {
        this.f12403c = i;
    }

    public LEGORichInfo getTitleBean() {
        return this.f12401a;
    }

    public void setTitleBean(LEGORichInfo lEGORichInfo) {
        this.f12401a = lEGORichInfo;
    }

    public ShiftBean getShiftsBean() {
        return this.f12402b;
    }

    public void setShiftsBean(ShiftBean shiftBean) {
        this.f12402b = shiftBean;
    }
}

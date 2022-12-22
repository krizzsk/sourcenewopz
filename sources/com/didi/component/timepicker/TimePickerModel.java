package com.didi.component.timepicker;

import java.util.List;

public class TimePickerModel {
    public static final int MODEL_NORMAL = 0;
    public static final int MODEL_SIMPLE = 1;
    public int appointmentDay;
    public int earliestDelta;
    public int from = 0;
    public String hint;
    public boolean isSupportnow;
    public int model = 0;
    public String simpleWheelLeftLabel;
    public List<String> simpleWheelList;
    public String simpleWheelRightLabel;
    public String subTitle;
    public String textContent;
    public CharSequence title;

    /* renamed from: to */
    public int f16115to = 24;

    public Object clone() {
        try {
            return (TimePickerModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "{hint = " + this.hint + " textContent = " + this.textContent + " title= " + this.title + " subTitle=" + this.subTitle + "}";
    }
}

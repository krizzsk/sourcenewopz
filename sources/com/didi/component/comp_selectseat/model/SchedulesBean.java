package com.didi.component.comp_selectseat.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SchedulesBean {
    @SerializedName("shifts")
    public List<ShiftBean> shifts;
    @SerializedName("title")
    public LEGORichInfo title;
}

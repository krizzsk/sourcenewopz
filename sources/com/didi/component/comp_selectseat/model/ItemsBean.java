package com.didi.component.comp_selectseat.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ItemsBean {
    @SerializedName("content")
    public String content;
    @SerializedName("schedules")
    public List<SchedulesBean> schedules;
    @SerializedName("title")
    public String title;
}

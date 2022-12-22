package com.didi.travel.psnger.model.response.newbubbleParams;

import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class BubbleItemModel {
    public static final int ACTION_EVENT_TYPE_FOUR = 4;
    public static final int ACTION_EVENT_TYPE_ONE = 1;
    public static final int ACTION_EVENT_TYPE_THREE = 3;
    public static final int ACTION_EVENT_TYPE_TWO = 2;
    public static final int BUBBLE_LOCATION_ON_CAR_MODEL = 3;
    public static final int BUBBLE_LOCATION_ON_ESTIMATE = 2;
    public static final int BUBBLE_LOCATION_ON_PAY = 1;
    public static final int VIEW_TYPE_ONLY_TEXT = 1;
    public static final int VIEW_TYPE_ONLY_TEXT_AND_BACKGROUND = 3;
    public static final int VIEW_TYPE_ONLY_TEXT_AND_TEXT_ICON = 4;
    public static final int VIEW_TYPE_TEXT_AND_ICON = 2;
    @SerializedName("action_event")
    public ActionEvent actionEvent;
    @SerializedName("bubble_id")
    public String bubbleId;
    @SerializedName("bubble_text")
    public GlobalRichInfo bubbleText;
    @SerializedName("extra_bubble_icon")
    public String extraBubbleIcon;
    @SerializedName("extra_color_end")
    public String extraColorEnd;
    @SerializedName("extra_color_start")
    public String extraColorStart;
    @SerializedName("extra_text")
    public GlobalRichInfo extraText;
    @SerializedName("log_data")
    public LogDate logDate;
    @SerializedName("red_mark_count")
    public int redMarkCount;
    @SerializedName("show_count")
    public int showCount;
    @SerializedName("view_type")
    public int viewType;
}

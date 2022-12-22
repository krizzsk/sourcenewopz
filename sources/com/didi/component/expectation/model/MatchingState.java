package com.didi.component.expectation.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class MatchingState {
    @SerializedName("animation_image_type")
    private int animationImageType;
    @SerializedName("caption")
    private String caption;
    @SerializedName("right_icon")
    private String rightIcon;
    @SerializedName("right_icon_click")
    private String rightIconClick;
    private String subtitle;
    @SerializedName("subtitle_rich")
    private GlobalRichInfo subtitleRich;
    @SerializedName("time_des")
    private String timeDes;
    @SerializedName("time_interval")
    private int timeInterval;
    @SerializedName("tips_text")
    private LEGORichInfo tipsText;
    private String title;
    @SerializedName("title_rich")
    private LEGORichInfo titleInfo;

    public GlobalRichInfo getSubtitleRich() {
        return this.subtitleRich;
    }

    public void setSubtitleRich(GlobalRichInfo globalRichInfo) {
        this.subtitleRich = globalRichInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public LEGORichInfo getTitleInfo() {
        return this.titleInfo;
    }

    public void setTitleInfo(LEGORichInfo lEGORichInfo) {
        this.titleInfo = lEGORichInfo;
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(int i) {
        this.timeInterval = i;
    }

    public String getTimeDes() {
        return this.timeDes;
    }

    public void setTimeDes(String str) {
        this.timeDes = str;
    }

    public LEGORichInfo getTipsText() {
        return this.tipsText;
    }

    public void setTipsText(LEGORichInfo lEGORichInfo) {
        this.tipsText = lEGORichInfo;
    }

    public String getRightIconClick() {
        return this.rightIconClick;
    }

    public void setRightIconClick(String str) {
        this.rightIconClick = str;
    }

    public int getAnimationImageType() {
        return this.animationImageType;
    }

    public void setAnimationImageType(int i) {
        this.animationImageType = i;
    }

    public String getRightIcon() {
        return this.rightIcon;
    }

    public void setRightIcon(String str) {
        this.rightIcon = str;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String str) {
        this.caption = str;
    }

    public String toString() {
        return "MatchingState{title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", timeInterval=" + this.timeInterval + ", tipsText=" + this.tipsText + ", rightIconClick='" + this.rightIconClick + '\'' + ", rightIcon='" + this.rightIcon + '\'' + ", animationImageType=" + this.animationImageType + ", caption='" + this.caption + '\'' + ", subtitleRich='" + this.subtitleRich + '\'' + '}';
    }
}

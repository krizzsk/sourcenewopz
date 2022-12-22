package com.didi.sdk.sidebar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.io.Serializable;
import java.util.List;

public class SidebarResponse implements Serializable {
    private OriginData[] data;
    private int errno;
    public PassengerSidebar passenger_Sidebar;
    private long version;

    public static class CustomerData {
        public String number;
        public String text;
    }

    public static class EmotionalData {
        public String text;
    }

    public static class PassengerSidebar implements Serializable {
        public CustomerData customerData;
        public DidiPassData didiPassData;
        public EmotionalData emotionalData;
        public List<String> priorityData;
    }

    public int getErrno() {
        return this.errno;
    }

    public void setErrno(int i) {
        this.errno = i;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public OriginData[] getData() {
        return this.data;
    }

    public void setData(OriginData[] originDataArr) {
        this.data = originDataArr;
    }

    public static class DidiPassData {
        public String backColor;
        public String leftIcon;
        public String text;
        public int type;
        public String url;

        public String toString() {
            return "DidiPassData{type=" + this.type + ", leftIcon='" + this.leftIcon + '\'' + ", text='" + this.text + '\'' + ", url='" + this.url + '\'' + ", backColor='" + this.backColor + '\'' + '}';
        }
    }

    public static class GetProfile {
        public String bgEndColor;
        public String bgStartColor;
        public String cardArrowIcon;
        public String cardBgEndColor;
        public String cardBgImage;
        public String cardBgStartColor;
        public String cardText;
        public String cardTextBorderColor;
        public String cardTextColor;
        public String fontColor;
        public String jumpLink;
        public String levelIcon;
        public int levelId;
        public String levelName;
        public LEGORichInfo subTitle;
        public LEGORichInfo title;

        public String toString() {
            return "GetProfile{levelId=" + this.levelId + ", levelName='" + this.levelName + '\'' + ", bgStartColor='" + this.bgStartColor + '\'' + ", bgEndColor='" + this.bgEndColor + '\'' + ", cardBgStartColor='" + this.cardBgStartColor + '\'' + ", cardBgEndColor='" + this.cardBgEndColor + '\'' + ", cardText='" + this.cardText + '\'' + ", cardTextColor='" + this.cardTextColor + '\'' + ", cardTextBorderColor='" + this.cardTextBorderColor + '\'' + ", fontColor='" + this.fontColor + '\'' + ", cardArrowIcon='" + this.cardArrowIcon + '\'' + ", levelIcon='" + this.levelIcon + '\'' + ", jumpLink='" + this.jumpLink + '\'' + ", cardBgImage='" + this.cardBgImage + '\'' + ", subTitle=" + this.subTitle + ", title=" + this.title + '}';
        }

        public String getCardTextColor() {
            return this.cardTextColor;
        }

        public void setCardTextColor(String str) {
            this.cardTextColor = str;
        }

        public String getCardTextBorderColor() {
            return this.cardTextBorderColor;
        }

        public void setCardTextBorderColor(String str) {
            this.cardTextBorderColor = str;
        }

        public String getCardBgImage() {
            return this.cardBgImage;
        }

        public void setCardBgImage(String str) {
            this.cardBgImage = str;
        }

        public int getLevelId() {
            return this.levelId;
        }

        public void setLevelId(int i) {
            this.levelId = i;
        }

        public String getLevelName() {
            return this.levelName;
        }

        public void setLevelName(String str) {
            this.levelName = str;
        }

        public String getBgStartColor() {
            return this.bgStartColor;
        }

        public void setBgStartColor(String str) {
            this.bgStartColor = str;
        }

        public String getBgEndColor() {
            return this.bgEndColor;
        }

        public void setBgEndColor(String str) {
            this.bgEndColor = str;
        }

        public String getCardBgStartColor() {
            return this.cardBgStartColor;
        }

        public void setCardBgStartColor(String str) {
            this.cardBgStartColor = str;
        }

        public String getCardBgEndColor() {
            return this.cardBgEndColor;
        }

        public void setCardBgEndColor(String str) {
            this.cardBgEndColor = str;
        }

        public String getCardText() {
            return this.cardText;
        }

        public void setCardText(String str) {
            this.cardText = str;
        }

        public String getFontColor() {
            return this.fontColor;
        }

        public void setFontColor(String str) {
            this.fontColor = str;
        }

        public String getCardArrowIcon() {
            return this.cardArrowIcon;
        }

        public void setCardArrowIcon(String str) {
            this.cardArrowIcon = str;
        }

        public String getLevelIcon() {
            return this.levelIcon;
        }

        public void setLevelIcon(String str) {
            this.levelIcon = str;
        }

        public String getJumpLink() {
            return this.jumpLink;
        }

        public void setJumpLink(String str) {
            this.jumpLink = str;
        }

        public LEGORichInfo getSubTitle() {
            return this.subTitle;
        }

        public void setSubTitle(LEGORichInfo lEGORichInfo) {
            this.subTitle = lEGORichInfo;
        }

        public LEGORichInfo getTitle() {
            return this.title;
        }

        public void setTitle(LEGORichInfo lEGORichInfo) {
            this.title = lEGORichInfo;
        }
    }
}

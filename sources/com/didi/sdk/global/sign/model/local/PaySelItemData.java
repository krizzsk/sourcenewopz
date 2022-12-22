package com.didi.sdk.global.sign.model.local;

import android.text.TextUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaySelItemData {
    public Set<Integer> allowedCombineTags = new HashSet();
    public String balance;
    public List<String> cardDiscountTags = new ArrayList();
    public String cardIndex;
    public int channelId;
    public String channelTip;
    public int combineTag;
    public String discount;
    public int discountStyle = 0;
    public int expired;
    public String expiredDesc;
    public String expiryDate;
    public PaySelGroupData groupData;
    public String guideH5Url;
    public boolean hasRedPoint = false;
    public String iconUrl;
    public String iconUrlFromPage;
    public String info;
    public boolean isEnabled = true;
    public boolean isFrozen = false;
    public boolean isHit99payCombination;
    public boolean isPriorityUse;
    public boolean isSelected = false;
    public boolean isSufficient;
    public boolean isTitleBold = true;
    public String logData;
    public String mostFavorableTxt;
    public String nextPageUrl;
    public int status = 0;
    public int style = 2;
    public String subTitle;
    public int subTitleStyle = 0;
    public String tips;
    public String title;
    public String titleInFromPage;
    public int titleStyle = 0;
    public String toAddCardDiscount;

    public static class Button {
        public static final int ARROW = 2;
        public static final int NONE = 0;
        public static final int SELECT = 1;
        public static final int SWITCH = 3;
    }

    public static class DiscountStyle {
        public static final int DISCOUNT_DEFAULT = 0;
        public static final int DISCOUNT_ICON = 1;
    }

    public static class Flag {
        public static final int EXPIRED = 1;
    }

    public static class Status {
        public static final int SIGNED = 1;
        public static final int UNSIGNED = 0;
        public static final int WAIT_VERIFY = 2;
    }

    public static class TextStyle {
        public static final int TEXT_DEFAULT = 0;
        public static final int TEXT_GRAY = 2;
        public static final int TEXT_RED = 1;
        public static final int TEXT_YELLOW = 3;
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextStyleEnum {
    }

    public boolean isAddCreditCard() {
        return this.channelId == 150 && TextUtils.isEmpty(this.cardIndex);
    }

    public String toString() {
        return "PayMethodItemInfo{channelId=" + this.channelId + ", style=" + this.style + ", iconUrl='" + this.iconUrl + '\'' + ", title='" + this.title + '\'' + ", subTitle='" + this.subTitle + '\'' + ", info='" + this.info + '\'' + ", discount='" + this.discount + '\'' + ", nextPageUrl='" + this.nextPageUrl + '\'' + ", allowedCombineTags=" + this.allowedCombineTags + ", combineTag=" + this.combineTag + ", isSufficient=" + this.isSufficient + ", titleStyle=" + this.titleStyle + ", subTitleStyle=" + this.subTitleStyle + ", discountStyle=" + this.discountStyle + ", status=" + this.status + ", expiryDate='" + this.expiryDate + '\'' + ", cardIndex='" + this.cardIndex + '\'' + ", hasRedPoint=" + this.hasRedPoint + ", isSelected=" + this.isSelected + ", isEnabled=" + this.isEnabled + '}';
    }
}

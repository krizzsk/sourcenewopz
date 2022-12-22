package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayWayModel extends BaseObject {
    public String businessMsg;
    public int defaultTag;
    public List<PayWayItem> payWayList;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.defaultTag = jSONObject.optInt("default_tag");
            this.businessMsg = jSONObject.optString("business_msg");
            if (jSONObject.has("busi_payments") && (optJSONArray = jSONObject.optJSONArray("busi_payments")) != null) {
                this.payWayList = new JsonUtil().parseJSONArray(optJSONArray, new PayWayItem());
            }
        }
    }

    public static class PayWayItem extends BaseObject {
        public String balance;
        public String balanceMsg;
        public int businessConstSet;
        public String businessUrl;
        public List<Integer> can_combination_pay_type;
        public String card;
        public List<String> cardDiscountTags;
        public String cardIndex;
        public String cardPrefix;
        public String card_org;
        public int channelID;
        public String channelTip;
        public boolean companyCarpoolOpen;
        public String companyPayMsg;
        public int disabled;
        public String discountMsg;
        public int expired;
        public String expiredDesc;
        public List<ExtroInfoItem> extroInfoItemList;
        public String guidePageH5;
        public boolean hasCoupon;
        public String iconUrl;
        public int isHit99payCombination;
        public int isOffline;
        public String isPriorityUse;
        public int isPromotion;
        public int isSelected;
        public int isSigned;
        public int is_sufficient;
        public String mLogData;
        public String mostFavorableTxt;
        public int priorityShow;
        public int recommendSignPayType;
        public int tag;
        public String text;
        public String tips;
        public String title;
        public String titleInSelectPage;
        public String toAddCardInfo;
        public String totalDiscount;
        public int viewType;

        public static class ViewType {
            public static int PAY_IN_APP = 1;
            public static int PAY_IN_CAR = 2;
            public static int TITLE;
        }

        public boolean isEnable() {
            return false;
        }

        public void setPayType(int i) {
        }

        public PayWayItem() {
        }

        public PayWayItem(int i, String str, String str2) {
            this.tag = i;
            this.title = str;
            this.text = str2;
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            JSONArray optJSONArray;
            JSONArray optJSONArray2;
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.toAddCardInfo = jSONObject.optString("to_add_card_info");
                this.tag = jSONObject.optInt("tag");
                this.text = jSONObject.optString("show_msg");
                this.title = jSONObject.optString("msg");
                this.titleInSelectPage = jSONObject.optString("payment_select_name");
                this.tips = jSONObject.optString("tips");
                this.businessUrl = jSONObject.optString("business_url");
                this.businessConstSet = jSONObject.optInt("business_const_set");
                this.companyPayMsg = jSONObject.optString("company_pay_msg");
                this.isSigned = jSONObject.optInt("isSigned", 0);
                this.channelID = jSONObject.optInt("channelID");
                this.isSelected = jSONObject.optInt("isSelected");
                this.isOffline = jSONObject.optInt("isOffline");
                this.card = jSONObject.optString("card");
                this.card_org = jSONObject.optString("card_org");
                this.iconUrl = jSONObject.optString("icon_url");
                this.disabled = jSONObject.optInt("disabled");
                this.recommendSignPayType = jSONObject.optInt("recommendSignPayType");
                this.priorityShow = jSONObject.optInt("priority_show");
                boolean z = true;
                if (jSONObject.optInt("isOffline", 0) == 1) {
                    this.viewType = ViewType.PAY_IN_CAR;
                } else {
                    this.viewType = ViewType.PAY_IN_APP;
                }
                this.companyCarpoolOpen = jSONObject.optInt("company_carpool_open", 0) == 1;
                this.cardIndex = jSONObject.optString("card_index");
                this.extroInfoItemList = null;
                if (jSONObject.has("extraInfoList") && (optJSONArray2 = jSONObject.optJSONArray("extraInfoList")) != null) {
                    this.extroInfoItemList = new JsonUtil().parseJSONArray(optJSONArray2, new ExtroInfoItem());
                }
                this.totalDiscount = jSONObject.optString("total_discount");
                this.discountMsg = jSONObject.optString("discount_msg");
                if (jSONObject.optInt("has_coupon") != 1) {
                    z = false;
                }
                this.hasCoupon = z;
                this.balanceMsg = jSONObject.optString("balanceMsg");
                if (jSONObject.has("can_combination_pay_type") && (optJSONArray = jSONObject.optJSONArray("can_combination_pay_type")) != null) {
                    this.can_combination_pay_type = JsonUtil.parseJSONArrayInteger(optJSONArray);
                }
                this.is_sufficient = jSONObject.optInt("is_sufficient");
                this.isPromotion = jSONObject.optInt("is_promotion");
                this.expired = jSONObject.optInt("expired");
                this.expiredDesc = jSONObject.optString("expired_desc");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("discount_tags");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    this.cardDiscountTags = new ArrayList();
                    for (int i = 0; i < optJSONArray3.length(); i++) {
                        this.cardDiscountTags.add(optJSONArray3.optString(i));
                    }
                }
                this.mostFavorableTxt = jSONObject.optString("discount_subtitle");
                JSONObject optJSONObject = jSONObject.optJSONObject("log_data");
                if (optJSONObject != null) {
                    this.mLogData = optJSONObject.toString();
                }
            }
        }

        public String toString() {
            return "tag = " + this.tag + " text = " + this.text + " title = " + this.title;
        }

        public String getSubLabel() {
            return this.text;
        }

        public String getLabel() {
            return this.title;
        }

        public void setSubLabel(String str) {
            this.text = str;
        }

        public int getPayType() {
            return this.tag;
        }

        public int getViewType() {
            return this.viewType;
        }

        public int isSigned() {
            return this.isSigned;
        }

        public int getTag() {
            return this.tag;
        }

        public int getChannelID() {
            return this.channelID;
        }

        public int isSelected() {
            return this.isSelected;
        }

        public int isOffline() {
            return this.isOffline;
        }

        public String getCard() {
            return this.card;
        }

        public String getCardOrg() {
            return this.card_org;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public int getDisabled() {
            return this.disabled;
        }

        public int getRecommendSignPayType() {
            return this.recommendSignPayType;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof PayWayItem) || getLabel() == null) {
                return false;
            }
            return getLabel().equals(((PayWayItem) obj).getLabel());
        }

        public int hashCode() {
            int viewType2 = 629 + getViewType();
            if (((viewType2 * 37) + getLabel()) == null) {
                return 0;
            }
            return getLabel().hashCode();
        }
    }

    public static class ExtroInfoItem extends BaseObject {
        public String cardDesc;
        public List<String> cardDiscountTags;
        public String cardIndex;
        public String cardOrg;
        public int cardStatus;
        public String cardSuffix;
        public String cardSuffixInSelectPage;
        public String discountMsg;
        public int expired;
        public String expiredDesc;
        public String mLogData;
        public String mostFavorableTxt;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.cardSuffix = jSONObject.optString("card_suffix");
                this.cardSuffixInSelectPage = jSONObject.optString("card_select_suffix");
                this.cardIndex = jSONObject.optString("card_index");
                this.cardOrg = jSONObject.optString("card_org");
                this.cardStatus = jSONObject.optInt("card_status");
                this.cardDesc = jSONObject.optString("status_desc");
                this.expired = jSONObject.optInt("expired");
                this.expiredDesc = jSONObject.optString("expired_desc");
                this.discountMsg = jSONObject.optString("discount_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("discount_tags");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.cardDiscountTags = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.cardDiscountTags.add(optJSONArray.optString(i));
                    }
                }
                this.mostFavorableTxt = jSONObject.optString("discount_subtitle");
                JSONObject optJSONObject = jSONObject.optJSONObject("log_data");
                if (optJSONObject != null) {
                    this.mLogData = optJSONObject.toString();
                }
            }
        }
    }
}

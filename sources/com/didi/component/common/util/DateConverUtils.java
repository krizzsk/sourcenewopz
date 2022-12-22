package com.didi.component.common.util;

import android.text.TextUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarPayConfigInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DateConverUtils {
    public static List<DidiGlobalPayMethodListData.PayMethodInfo> converPayMethodInfoList(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PayWayModel.PayWayItem converPayMethodInfo : list) {
            DidiGlobalPayMethodListData.PayMethodInfo converPayMethodInfo2 = converPayMethodInfo(converPayMethodInfo);
            if (converPayMethodInfo2 != null) {
                arrayList.add(converPayMethodInfo2);
            }
        }
        return arrayList;
    }

    public static DidiGlobalPayMethodListData.PayMethodInfo converPayMethodInfo(PayWayModel.PayWayItem payWayItem) {
        if (payWayItem == null) {
            return null;
        }
        DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo = new DidiGlobalPayMethodListData.PayMethodInfo();
        payMethodInfo.channelId = payWayItem.channelID;
        payMethodInfo.title = payWayItem.title;
        payMethodInfo.titleInSelectPage = payWayItem.titleInSelectPage;
        payMethodInfo.subTitle = payWayItem.text;
        payMethodInfo.tips = payWayItem.tips;
        boolean z = false;
        payMethodInfo.isSelected = payWayItem.isSelected == 1;
        payMethodInfo.isSigned = payWayItem.isSigned == 1;
        payMethodInfo.isEnabled = payWayItem.disabled == 0;
        payMethodInfo.iconUrl = payWayItem.iconUrl;
        payMethodInfo.channelTip = payWayItem.channelTip;
        payMethodInfo.guideH5Url = payWayItem.guidePageH5;
        payMethodInfo.balance = payWayItem.balance;
        payMethodInfo.isPriorityUse = "1".equals(payWayItem.isPriorityUse);
        payMethodInfo.isHit99payCombination = payWayItem.isHit99payCombination == 1;
        payMethodInfo.combineTag = payWayItem.tag;
        if (payWayItem.can_combination_pay_type != null && !payWayItem.can_combination_pay_type.isEmpty()) {
            payMethodInfo.allowedCombineTags = new HashSet(payWayItem.can_combination_pay_type);
        }
        payMethodInfo.isSufficient = payWayItem.is_sufficient == 1;
        payMethodInfo.info = payWayItem.balanceMsg;
        payMethodInfo.toAddCardInfo = payWayItem.toAddCardInfo;
        payMethodInfo.cardDiscountTags = payWayItem.cardDiscountTags;
        payMethodInfo.mostFavorableTxt = payWayItem.mostFavorableTxt;
        payMethodInfo.logData = payWayItem.mLogData;
        if (payWayItem.extroInfoItemList != null) {
            payMethodInfo.cardList = new ArrayList(payWayItem.extroInfoItemList.size());
            for (PayWayModel.ExtroInfoItem next : payWayItem.extroInfoItemList) {
                DidiGlobalPayMethodListData.CardInfo cardInfo = new DidiGlobalPayMethodListData.CardInfo();
                cardInfo.cardIndex = next.cardIndex;
                cardInfo.cardNo = next.cardSuffix;
                cardInfo.cardNoInSelectPage = next.cardSuffixInSelectPage;
                cardInfo.iconUrl = next.cardOrg;
                cardInfo.isSelected = TextUtils.equals(next.cardIndex, payWayItem.cardIndex) && payWayItem.isSelected == 1;
                cardInfo.cardStatus = next.cardStatus;
                cardInfo.cardDesc = next.cardDesc;
                cardInfo.expired = next.expired;
                cardInfo.expiredDesc = next.expiredDesc;
                cardInfo.totalDiscount = next.discountMsg;
                cardInfo.cardDiscountTags = next.cardDiscountTags;
                cardInfo.mostFavorableTxt = next.mostFavorableTxt;
                cardInfo.logData = next.mLogData;
                payMethodInfo.cardList.add(cardInfo);
            }
        }
        if (payWayItem.isPromotion == 1) {
            z = true;
        }
        payMethodInfo.isPromotion = z;
        if (payMethodInfo.isPromotion) {
            payMethodInfo.discount = parseDiscountText(payWayItem.totalDiscount, true);
        } else {
            payMethodInfo.discount = parseDiscountText(payWayItem);
        }
        return payMethodInfo;
    }

    public static String parseDiscountText(String str, boolean z) {
        if (!TextUtil.isEmpty(str) && !TextUtils.equals(str, "0")) {
            try {
                int floatValue = (int) (Float.valueOf(str).floatValue() * 100.0f);
                if (z) {
                    floatValue = Math.abs(floatValue);
                }
                return String.valueOf(floatValue);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String parseDiscountText(PayWayModel.PayWayItem payWayItem) {
        if (!TextUtils.isEmpty(payWayItem.discountMsg)) {
            return payWayItem.discountMsg;
        }
        if (!TextUtil.isEmpty(payWayItem.totalDiscount) && !TextUtils.equals(payWayItem.totalDiscount, "0")) {
            try {
                return ((int) (Float.valueOf(payWayItem.totalDiscount).floatValue() * 100.0f)) + "%";
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static List<DidiGlobalPayMethodListData.PayMethodGroupInfo> convertPayGroupInfoList(List<CarPayGroupInfoModel> list) {
        DidiGlobalPayMethodListData.PayMethodGroupInfo a;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CarPayGroupInfoModel next : list) {
            if (!(next == null || (a = m7955a(next)) == null)) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static DidiGlobalPayMethodListData.PayMethodGroupInfo m7955a(CarPayGroupInfoModel carPayGroupInfoModel) {
        if (carPayGroupInfoModel == null) {
            return null;
        }
        DidiGlobalPayMethodListData.PayMethodGroupInfo payMethodGroupInfo = new DidiGlobalPayMethodListData.PayMethodGroupInfo();
        carPayGroupInfoModel.buildFrozenData();
        payMethodGroupInfo.name = carPayGroupInfoModel.name;
        payMethodGroupInfo.iconUrl = carPayGroupInfoModel.iconUrl;
        payMethodGroupInfo.channelIds = carPayGroupInfoModel.channelIds;
        payMethodGroupInfo.accountFreezeData = carPayGroupInfoModel.freezeData;
        return payMethodGroupInfo;
    }

    public static List<DidiGlobalPayMethodListData.PayMethodInfo> convertCarPayInfoToPayMethodList(String str) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = null;
        if (str2 == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() > 0) {
                int i = 0;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo = new DidiGlobalPayMethodListData.PayMethodInfo();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    payMethodInfo.channelId = optJSONObject.optInt("channelID");
                    payMethodInfo.title = optJSONObject.optString("msg");
                    payMethodInfo.titleInSelectPage = optJSONObject.optString("payment_select_name");
                    payMethodInfo.subTitle = optJSONObject.optString("show_msg");
                    payMethodInfo.tips = optJSONObject.optString("tips");
                    payMethodInfo.isSelected = optJSONObject.optInt("isSelected") == 1;
                    payMethodInfo.isSigned = optJSONObject.optInt("isSigned", i) == 1;
                    payMethodInfo.isEnabled = optJSONObject.optInt("disabled") == 0;
                    payMethodInfo.iconUrl = optJSONObject.optString("icon_url");
                    payMethodInfo.isPriorityUse = "1".equals(optJSONObject.optString("is_priority_use"));
                    payMethodInfo.isHit99payCombination = optJSONObject.optInt("is_hit_99pay_combination_experiment") == 1;
                    String optString = optJSONObject.optString("extraInfo");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            JSONObject jSONObject = new JSONObject(optString);
                            payMethodInfo.channelTip = jSONObject.optString("channel_tip");
                            payMethodInfo.guideH5Url = jSONObject.optString("guide_page_h5");
                            payMethodInfo.balance = jSONObject.optString("balance");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            payMethodInfo.channelTip = "";
                            payMethodInfo.guideH5Url = "";
                            payMethodInfo.balance = "";
                        }
                    }
                    payMethodInfo.combineTag = optJSONObject.optInt("tag");
                    ArrayList<Integer> parseJSONArrayInteger = (!optJSONObject.has("can_combination_pay_type") || (optJSONArray2 = optJSONObject.optJSONArray("can_combination_pay_type")) == null) ? arrayList2 : JsonUtil.parseJSONArrayInteger(optJSONArray2);
                    if (parseJSONArrayInteger != null && !parseJSONArrayInteger.isEmpty()) {
                        payMethodInfo.allowedCombineTags = new HashSet(parseJSONArrayInteger);
                    }
                    payMethodInfo.isSufficient = optJSONObject.optInt("is_sufficient") == 1;
                    payMethodInfo.info = optJSONObject.optString("balanceMsg");
                    payMethodInfo.toAddCardInfo = optJSONObject.optString("to_add_card_info");
                    if (optJSONObject.has("extraInfoList") && (optJSONArray = optJSONObject.optJSONArray("extraInfoList")) != null) {
                        payMethodInfo.cardList = new ArrayList(optJSONArray.length());
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            DidiGlobalPayMethodListData.CardInfo cardInfo = new DidiGlobalPayMethodListData.CardInfo();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            cardInfo.cardIndex = optJSONObject2.optString("card_index");
                            cardInfo.cardNo = optJSONObject2.optString("card_suffix");
                            cardInfo.cardNoInSelectPage = optJSONObject2.optString("card_select_suffix");
                            cardInfo.iconUrl = optJSONObject2.optString("card_org");
                            cardInfo.isSelected = TextUtils.equals(cardInfo.cardIndex, optJSONObject.optString("card_index")) && optJSONObject.optInt("isSelected") == 1;
                            cardInfo.cardStatus = optJSONObject2.optInt("card_status");
                            cardInfo.cardDesc = optJSONObject2.optString("status_desc");
                            cardInfo.expired = optJSONObject2.optInt("expired");
                            cardInfo.expiredDesc = optJSONObject2.optString("expired_desc");
                            cardInfo.totalDiscount = optJSONObject2.optString("discount_msg");
                            payMethodInfo.cardList.add(cardInfo);
                        }
                    }
                    payMethodInfo.isPromotion = optJSONObject.optInt("is_promotion") == 1;
                    if (payMethodInfo.isPromotion) {
                        payMethodInfo.discount = parseDiscountText(optJSONObject.optString("total_discount"), true);
                    } else {
                        payMethodInfo.discount = parseDiscountText(optJSONObject);
                    }
                    arrayList.add(payMethodInfo);
                    i2++;
                    arrayList2 = null;
                    i = 0;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String parseDiscountText(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("discount_msg"))) {
            return jSONObject.optString("discount_msg");
        }
        if (!TextUtil.isEmpty(jSONObject.optString("total_discount")) && !TextUtils.equals(jSONObject.optString("total_discount"), "0")) {
            try {
                return ((int) (Float.valueOf(jSONObject.optString("total_discount")).floatValue() * 100.0f)) + "%";
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static DidiGlobalPayMethodListData.PayMethodConfigInfo convertPayPopupInfo(CarPayConfigInfoModel carPayConfigInfoModel) {
        if (carPayConfigInfoModel == null) {
            return null;
        }
        DidiGlobalPayMethodListData.PayMethodConfigInfo payMethodConfigInfo = new DidiGlobalPayMethodListData.PayMethodConfigInfo();
        if (carPayConfigInfoModel.switchOut99PayPopup != null) {
            payMethodConfigInfo.switchOut99PayPopup = new DidiGlobalPayMethodListData.PayMethodConfigInfo.PopupItem();
            payMethodConfigInfo.switchOut99PayPopup.title = carPayConfigInfoModel.switchOut99PayPopup.title;
            payMethodConfigInfo.switchOut99PayPopup.subTitle = carPayConfigInfoModel.switchOut99PayPopup.subTitle;
            payMethodConfigInfo.switchOut99PayPopup.confirmBtn = carPayConfigInfoModel.switchOut99PayPopup.confirmBtn;
            payMethodConfigInfo.switchOut99PayPopup.cancelBtn = carPayConfigInfoModel.switchOut99PayPopup.cancelBtn;
        }
        if (carPayConfigInfoModel.switchOutCombinationPayPopup != null) {
            payMethodConfigInfo.switchOutCombinationPayPopup = new DidiGlobalPayMethodListData.PayMethodConfigInfo.PopupItem();
            payMethodConfigInfo.switchOutCombinationPayPopup.title = carPayConfigInfoModel.switchOutCombinationPayPopup.title;
            payMethodConfigInfo.switchOutCombinationPayPopup.subTitle = carPayConfigInfoModel.switchOutCombinationPayPopup.subTitle;
            payMethodConfigInfo.switchOutCombinationPayPopup.confirmBtn = carPayConfigInfoModel.switchOutCombinationPayPopup.confirmBtn;
            payMethodConfigInfo.switchOutCombinationPayPopup.cancelBtn = carPayConfigInfoModel.switchOutCombinationPayPopup.cancelBtn;
        }
        if (carPayConfigInfoModel.ext != null) {
            try {
                payMethodConfigInfo.extOmegaAttrs = new JSONObject(carPayConfigInfoModel.ext).toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return payMethodConfigInfo;
    }
}

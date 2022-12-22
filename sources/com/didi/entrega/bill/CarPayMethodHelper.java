package com.didi.entrega.bill;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.entrega.bill.model.CarPayExtraItemInfo;
import com.didi.entrega.bill.model.CarPayGroupInfoModel;
import com.didi.entrega.bill.model.CarPayInfoModel;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CarPayMethodHelper {
    public static final int REQUEST_CODE_SHOW_SELECT_VIEW = 3;

    public static void gotoCarPayListPage(List<CarPayInfoModel> list, List<CarPayGroupInfoModel> list2) {
        try {
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = converCarPayInfoToPayMethodList(list);
            payMethodListParam.groupList = convertPayGroupInfoList(list2);
            payMethodListParam.resourceId = "1";
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity((Fragment) GlobalContext.getFragment(), 3, payMethodListParam);
        } catch (Exception unused) {
        }
    }

    public static List<DidiGlobalPayMethodListData.PayMethodInfo> converCarPayInfoToPayMethodList(List<CarPayInfoModel> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CarPayInfoModel converPayMethodInfo : list) {
            DidiGlobalPayMethodListData.PayMethodInfo converPayMethodInfo2 = converPayMethodInfo(converPayMethodInfo);
            if (converPayMethodInfo2 != null) {
                arrayList.add(converPayMethodInfo2);
            }
        }
        return arrayList;
    }

    public static DidiGlobalPayMethodListData.PayMethodInfo converPayMethodInfo(CarPayInfoModel carPayInfoModel) {
        if (carPayInfoModel == null) {
            return null;
        }
        DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo = new DidiGlobalPayMethodListData.PayMethodInfo();
        payMethodInfo.channelId = carPayInfoModel.payChannelId;
        payMethodInfo.title = carPayInfoModel.payMessage;
        payMethodInfo.titleInSelectPage = carPayInfoModel.payMessageInSelectPage;
        payMethodInfo.subTitle = carPayInfoModel.payShowMessage;
        payMethodInfo.tips = carPayInfoModel.payTips;
        boolean z = false;
        payMethodInfo.isSelected = carPayInfoModel.payIsSelected == 1;
        payMethodInfo.isSigned = carPayInfoModel.payIsSigned == 1;
        payMethodInfo.isEnabled = carPayInfoModel.payDisable == 0;
        payMethodInfo.iconUrl = carPayInfoModel.payIconUrl;
        payMethodInfo.isPriorityUse = "1".equals(carPayInfoModel.isPriorityUse);
        payMethodInfo.isHit99payCombination = carPayInfoModel.isHit99payCombination == 1;
        if (!TextUtils.isEmpty(carPayInfoModel.payExtraInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(carPayInfoModel.payExtraInfo);
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
        payMethodInfo.combineTag = carPayInfoModel.payTag;
        if (carPayInfoModel.payCombineType != null && !carPayInfoModel.payCombineType.isEmpty()) {
            payMethodInfo.allowedCombineTags = new HashSet(carPayInfoModel.payCombineType);
        }
        payMethodInfo.isSufficient = carPayInfoModel.payIsSufficient == 1;
        payMethodInfo.info = carPayInfoModel.payBalanceMsg;
        payMethodInfo.toAddCardInfo = carPayInfoModel.toAddCardInfo;
        if (carPayInfoModel.payExtraItemInfos != null) {
            payMethodInfo.cardList = new ArrayList(carPayInfoModel.payExtraItemInfos.size());
            for (CarPayExtraItemInfo next : carPayInfoModel.payExtraItemInfos) {
                DidiGlobalPayMethodListData.CardInfo cardInfo = new DidiGlobalPayMethodListData.CardInfo();
                cardInfo.cardIndex = next.cardIndex;
                cardInfo.cardNo = next.cardSuffix;
                cardInfo.cardNoInSelectPage = next.cardSuffixInSelectPage;
                cardInfo.iconUrl = next.carOrg;
                cardInfo.isSelected = TextUtils.equals(next.cardIndex, carPayInfoModel.payCarIndex) && carPayInfoModel.payIsSelected == 1;
                cardInfo.cardStatus = next.cardStatus;
                cardInfo.cardDesc = next.cardStatusDesc;
                cardInfo.expired = next.cardExpried;
                cardInfo.expiredDesc = next.expiredDesc;
                cardInfo.totalDiscount = next.discountMsg;
                payMethodInfo.cardList.add(cardInfo);
            }
        }
        if (carPayInfoModel.payIsPromotion == 1) {
            z = true;
        }
        payMethodInfo.isPromotion = z;
        if (payMethodInfo.isPromotion) {
            payMethodInfo.discount = parseDiscountText(carPayInfoModel.payTotalDiscount, true);
        } else {
            payMethodInfo.discount = parseDiscountText(carPayInfoModel);
        }
        return payMethodInfo;
    }

    public static List<DidiGlobalPayMethodListData.PayMethodGroupInfo> convertPayGroupInfoList(List<CarPayGroupInfoModel> list) {
        DidiGlobalPayMethodListData.PayMethodGroupInfo a;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CarPayGroupInfoModel next : list) {
            if (!(next == null || (a = m14571a(next)) == null)) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static DidiGlobalPayMethodListData.PayMethodGroupInfo m14571a(CarPayGroupInfoModel carPayGroupInfoModel) {
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

    public static String parseDiscountText(CarPayInfoModel carPayInfoModel) {
        if (!TextUtils.isEmpty(carPayInfoModel.payDiscountMessage)) {
            return carPayInfoModel.payDiscountMessage;
        }
        if (!TextUtils.isEmpty(carPayInfoModel.payTotalDiscount) && !TextUtils.equals(carPayInfoModel.payTotalDiscount, "0")) {
            try {
                return ((int) (Float.valueOf(carPayInfoModel.payTotalDiscount).floatValue() * 100.0f)) + "%";
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String parseDiscountText(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
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
}

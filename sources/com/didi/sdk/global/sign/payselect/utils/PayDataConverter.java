package com.didi.sdk.global.sign.payselect.utils;

import android.text.TextUtils;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.BaseDataConverter;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.payselect.utils.handler.HandlerChain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PayDataConverter extends BaseDataConverter {
    public static PaySelPageData convert(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        PaySelItemData paySelItemData = null;
        if (payMethodListParam == null || payMethodListParam.list == null || payMethodListParam.list.size() <= 0) {
            return null;
        }
        PaySelPageData paySelPageData = new PaySelPageData();
        paySelPageData.payMethodList = new ArrayList();
        List<DidiGlobalPayMethodListData.PayMethodInfo> list = payMethodListParam.list;
        for (int i = 0; i < list.size(); i++) {
            int i2 = list.get(i).channelId;
            if (i2 == 120) {
                paySelItemData = m25661a(list.get(i), payMethodListParam.from, true);
                paySelPageData.payMethodList.add(paySelItemData);
            } else if (i2 != 150) {
                paySelPageData.payMethodList.add(m25661a(list.get(i), payMethodListParam.from, true));
            } else {
                paySelPageData.payMethodList.addAll(m25665b(list.get(i), payMethodListParam.from, true));
            }
        }
        if (paySelItemData != null && paySelItemData.isSelected) {
            for (PaySelItemData next : paySelPageData.payMethodList) {
                if (!(paySelItemData.channelId == next.channelId || paySelItemData.allowedCombineTags == null || paySelItemData.allowedCombineTags.contains(Integer.valueOf(next.combineTag)))) {
                    next.titleStyle = 2;
                }
            }
        }
        if (!CollectionUtil.isEmpty((Collection) payMethodListParam.groupList)) {
            paySelPageData.groupList = m25662a(paySelPageData, payMethodListParam);
        }
        paySelPageData.configInfo = payMethodListParam.configInfo;
        m25663a(paySelPageData);
        HandlerChain.INSTANCE.process(paySelPageData);
        return paySelPageData;
    }

    /* renamed from: a */
    private static void m25663a(PaySelPageData paySelPageData) {
        AccountFreezeData accountFreezeData;
        PaySelGroupData paySelGroupData;
        if (paySelPageData != null && !CollectionUtil.isEmpty((Collection) paySelPageData.groupList)) {
            Iterator<PaySelGroupData> it = paySelPageData.groupList.iterator();
            while (true) {
                accountFreezeData = null;
                if (!it.hasNext()) {
                    paySelGroupData = null;
                    break;
                }
                PaySelGroupData next = it.next();
                AccountFreezeData accountFreezeData2 = next.accountFreezeData;
                if (accountFreezeData2 != null && accountFreezeData2.isBannerValid()) {
                    accountFreezeData2.textTrim();
                    paySelPageData.accountFreezeData = accountFreezeData2;
                    paySelGroupData = next;
                    accountFreezeData = accountFreezeData2;
                    break;
                }
            }
            if (accountFreezeData != null && accountFreezeData.isBannerValid()) {
                int[] iArr = paySelGroupData.channelIds;
                if (!com.didi.sdk.util.collection.CollectionUtil.isEmpty(iArr)) {
                    HashSet hashSet = new HashSet();
                    for (int valueOf : iArr) {
                        hashSet.add(Integer.valueOf(valueOf));
                    }
                    if (!com.didi.sdk.util.collection.CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
                        for (PaySelItemData next2 : paySelPageData.payMethodList) {
                            if (hashSet.contains(Integer.valueOf(next2.channelId))) {
                                next2.isFrozen = accountFreezeData.isFrozen();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static List<PaySelGroupData> m25662a(PaySelPageData paySelPageData, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        List<DidiGlobalPayMethodListData.PayMethodGroupInfo> list = payMethodListParam.groupList;
        ArrayList<PaySelGroupData> arrayList = new ArrayList<>();
        for (DidiGlobalPayMethodListData.PayMethodGroupInfo next : list) {
            if (next != null) {
                PaySelGroupData paySelGroupData = new PaySelGroupData();
                paySelGroupData.iconUrl = next.iconUrl;
                paySelGroupData.name = next.name;
                paySelGroupData.channelIds = next.channelIds;
                paySelGroupData.accountFreezeData = next.accountFreezeData;
                arrayList.add(paySelGroupData);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        m25664a(paySelPageData.payMethodList, (List<PaySelItemData>) arrayList3, (List<PaySelItemData>) arrayList2);
        for (PaySelGroupData itemList : arrayList) {
            itemList.setItemList(arrayList3, arrayList2);
        }
        if (arrayList2.size() > 0) {
            arrayList.add(PaySelGroupData.createOtherGroup(arrayList2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m25664a(List<PaySelItemData> list, List<PaySelItemData> list2, List<PaySelItemData> list3) {
        for (PaySelItemData next : list) {
            if (next != null) {
                if (next.channelId != 150 || TextUtils.isEmpty(next.cardIndex)) {
                    list3.add(next);
                } else {
                    list2.add(next);
                }
            }
        }
    }

    /* renamed from: a */
    private static PaySelItemData m25661a(DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo, DidiGlobalPayMethodListData.Entrance entrance, boolean z) {
        PaySelItemData paySelItemData = new PaySelItemData();
        paySelItemData.channelId = payMethodInfo.channelId;
        paySelItemData.iconUrl = payMethodInfo.iconUrl;
        paySelItemData.title = payMethodInfo.title;
        paySelItemData.subTitle = payMethodInfo.subTitle;
        paySelItemData.info = payMethodInfo.info;
        paySelItemData.discount = payMethodInfo.discount;
        paySelItemData.status = getStatus(paySelItemData.channelId, payMethodInfo.isSigned, entrance);
        paySelItemData.isSelected = payMethodInfo.isSelected;
        paySelItemData.isEnabled = payMethodInfo.isEnabled;
        paySelItemData.allowedCombineTags.addAll(payMethodInfo.allowedCombineTags);
        paySelItemData.combineTag = payMethodInfo.combineTag;
        paySelItemData.isSufficient = getIsSufficient(payMethodInfo, entrance);
        paySelItemData.isHit99payCombination = payMethodInfo.isHit99payCombination;
        paySelItemData.channelTip = payMethodInfo.channelTip;
        paySelItemData.guideH5Url = payMethodInfo.guideH5Url;
        paySelItemData.balance = payMethodInfo.balance;
        paySelItemData.isPriorityUse = payMethodInfo.isPriorityUse;
        paySelItemData.style = getButtonStyle(paySelItemData, entrance);
        if (payMethodInfo.cardDiscountTags != null && payMethodInfo.cardDiscountTags.size() > 0) {
            paySelItemData.cardDiscountTags.addAll(payMethodInfo.cardDiscountTags);
        }
        paySelItemData.mostFavorableTxt = payMethodInfo.mostFavorableTxt;
        paySelItemData.logData = payMethodInfo.logData;
        int i = 1;
        if (paySelItemData.channelId == 190 || paySelItemData.channelId == 120) {
            paySelItemData.isEnabled = true;
        }
        if (paySelItemData.channelId == 182) {
            paySelItemData.tips = payMethodInfo.tips;
            paySelItemData.titleStyle = payMethodInfo.isEnabled ? 0 : 2;
            paySelItemData.subTitleStyle = payMethodInfo.isEnabled ^ true ? 1 : 0;
            if (payMethodInfo.isPromotion) {
                paySelItemData.discountStyle = 1;
                if (payMethodInfo.isEnabled) {
                    i = 3;
                }
                paySelItemData.subTitleStyle = i;
            }
        }
        if (z && !TextUtils.isEmpty(payMethodInfo.titleInSelectPage)) {
            paySelItemData.title = payMethodInfo.titleInSelectPage;
            paySelItemData.titleInFromPage = payMethodInfo.title;
        }
        if (z && !TextUtils.isEmpty(payMethodInfo.iconUrl)) {
            paySelItemData.iconUrlFromPage = payMethodInfo.iconUrl;
        }
        return paySelItemData;
    }

    /* renamed from: b */
    private static List<PaySelItemData> m25665b(DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo, DidiGlobalPayMethodListData.Entrance entrance, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (payMethodInfo == null) {
            return arrayList;
        }
        PaySelItemData paySelItemData = new PaySelItemData();
        paySelItemData.channelId = 150;
        paySelItemData.style = 2;
        paySelItemData.iconUrl = payMethodInfo.iconUrl;
        paySelItemData.title = payMethodInfo.title;
        paySelItemData.subTitle = payMethodInfo.subTitle;
        paySelItemData.status = 0;
        paySelItemData.allowedCombineTags.addAll(payMethodInfo.allowedCombineTags);
        paySelItemData.combineTag = payMethodInfo.combineTag;
        paySelItemData.isSufficient = getIsSufficient(payMethodInfo, entrance);
        paySelItemData.channelTip = payMethodInfo.channelTip;
        paySelItemData.guideH5Url = payMethodInfo.guideH5Url;
        paySelItemData.toAddCardDiscount = payMethodInfo.toAddCardInfo;
        if (payMethodInfo.cardDiscountTags != null && payMethodInfo.cardDiscountTags.size() > 0) {
            paySelItemData.cardDiscountTags.addAll(payMethodInfo.cardDiscountTags);
        }
        paySelItemData.mostFavorableTxt = payMethodInfo.mostFavorableTxt;
        paySelItemData.logData = payMethodInfo.logData;
        arrayList.add(paySelItemData);
        if (payMethodInfo.cardList == null || payMethodInfo.cardList.size() <= 0) {
            paySelItemData.discount = payMethodInfo.discount;
            paySelItemData.tips = payMethodInfo.tips;
            return arrayList;
        }
        if (z && !TextUtils.isEmpty(payMethodInfo.titleInSelectPage)) {
            paySelItemData.title = payMethodInfo.titleInSelectPage;
            paySelItemData.titleInFromPage = payMethodInfo.title;
        }
        if (z && TextUtils.isEmpty(payMethodInfo.iconUrl)) {
            paySelItemData.iconUrlFromPage = payMethodInfo.iconUrl;
        }
        for (DidiGlobalPayMethodListData.CardInfo next : payMethodInfo.cardList) {
            PaySelItemData paySelItemData2 = new PaySelItemData();
            paySelItemData2.channelId = 150;
            paySelItemData2.iconUrl = next.iconUrl;
            paySelItemData2.title = next.cardNo;
            paySelItemData2.subTitle = next.cardDesc;
            paySelItemData2.tips = payMethodInfo.tips;
            paySelItemData2.cardIndex = next.cardIndex;
            paySelItemData2.expired = next.expired;
            paySelItemData2.expiredDesc = next.expiredDesc;
            if (next.cardDiscountTags != null && next.cardDiscountTags.size() > 0) {
                paySelItemData2.cardDiscountTags.addAll(next.cardDiscountTags);
            }
            paySelItemData2.mostFavorableTxt = next.mostFavorableTxt;
            paySelItemData.logData = payMethodInfo.logData;
            if (next.cardStatus == 1) {
                paySelItemData2.status = 2;
            } else {
                paySelItemData2.status = 1;
            }
            if (paySelItemData2.expired == 1) {
                paySelItemData2.style = 2;
            } else if (paySelItemData2.status == 2) {
                paySelItemData2.style = 2;
            } else {
                paySelItemData2.style = 1;
            }
            if (TextUtils.isEmpty(next.totalDiscount)) {
                paySelItemData2.discount = payMethodInfo.discount;
            } else {
                paySelItemData2.discount = next.totalDiscount;
            }
            paySelItemData2.isSelected = next.isSelected;
            paySelItemData2.isEnabled = payMethodInfo.isEnabled;
            paySelItemData2.allowedCombineTags.addAll(payMethodInfo.allowedCombineTags);
            paySelItemData2.combineTag = payMethodInfo.combineTag;
            paySelItemData2.isSufficient = getIsSufficient(payMethodInfo, entrance);
            if (paySelItemData2.status != 1) {
                paySelItemData2.subTitleStyle = 1;
            }
            if (z && !TextUtils.isEmpty(next.cardNoInSelectPage)) {
                paySelItemData2.title = next.cardNoInSelectPage;
                paySelItemData2.titleInFromPage = next.cardNo;
            }
            if (z && !TextUtils.isEmpty(next.iconUrl)) {
                paySelItemData2.iconUrlFromPage = next.iconUrl;
            }
            arrayList.add(paySelItemData2);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getButtonStyle(com.didi.sdk.global.sign.model.local.PaySelItemData r5, com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance r6) {
        /*
            int r0 = r5.channelId
            r1 = 3
            r2 = 1
            r3 = 2
            r4 = 120(0x78, float:1.68E-43)
            if (r0 != r4) goto L_0x001c
            com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION
            if (r6 == r0) goto L_0x0011
            com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE
            if (r6 != r0) goto L_0x0042
        L_0x0011:
            com.didi.sdk.global.sign.payselect.utils.PaySelUtils r6 = com.didi.sdk.global.sign.payselect.utils.PaySelUtils.INSTANCE
            java.lang.String r5 = r5.balance
            boolean r5 = r6.isZeroBalance(r5)
            if (r5 == 0) goto L_0x0045
            goto L_0x0044
        L_0x001c:
            int r0 = r5.channelId
            r4 = 190(0xbe, float:2.66E-43)
            if (r0 != r4) goto L_0x003e
            com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION
            if (r6 != r0) goto L_0x0044
            int r6 = r5.status
            if (r6 != r2) goto L_0x0044
            boolean r6 = r5.isHit99payCombination
            if (r6 == 0) goto L_0x0039
            com.didi.sdk.global.sign.payselect.utils.PaySelUtils r6 = com.didi.sdk.global.sign.payselect.utils.PaySelUtils.INSTANCE
            java.lang.String r5 = r5.balance
            boolean r5 = r6.isZeroBalance(r5)
            if (r5 == 0) goto L_0x0045
            goto L_0x0044
        L_0x0039:
            boolean r5 = r5.isSufficient
            if (r5 == 0) goto L_0x0044
            goto L_0x0042
        L_0x003e:
            int r5 = r5.status
            if (r5 != r2) goto L_0x0044
        L_0x0042:
            r1 = 1
            goto L_0x0045
        L_0x0044:
            r1 = 2
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.payselect.utils.PayDataConverter.getButtonStyle(com.didi.sdk.global.sign.model.local.PaySelItemData, com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance):int");
    }
}

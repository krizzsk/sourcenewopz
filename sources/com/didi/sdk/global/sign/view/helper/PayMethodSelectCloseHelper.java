package com.didi.sdk.global.sign.view.helper;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.taxis99.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PayMethodSelectCloseHelper {

    public enum SelectionValidationResult {
        SUCCESS,
        ERROR_NONE_SELECTED,
        ERROR_BALANCE_INSUFFICIENT
    }

    public static SelectionValidationResult validateSelection(List<PaySelItemData> list, boolean z) {
        if ((list == null || list.isEmpty()) && z) {
            return SelectionValidationResult.ERROR_NONE_SELECTED;
        }
        PaySelItemData paySelItemData = list.get(0);
        if (list.size() == 1 && !paySelItemData.isSufficient && paySelItemData.channelId == 120) {
            return SelectionValidationResult.ERROR_BALANCE_INSUFFICIENT;
        }
        return SelectionValidationResult.SUCCESS;
    }

    public static SelectionValidationResult validateSelectionV2(List<PaySelItemData> list, boolean z) {
        if ((list == null || list.isEmpty()) && z) {
            return SelectionValidationResult.ERROR_NONE_SELECTED;
        }
        if (list == null || list.isEmpty()) {
            return SelectionValidationResult.SUCCESS;
        }
        PaySelItemData paySelItemData = list.get(0);
        if (list.size() == 1 && !paySelItemData.isSufficient && paySelItemData.channelId == 120) {
            return SelectionValidationResult.ERROR_BALANCE_INSUFFICIENT;
        }
        return SelectionValidationResult.SUCCESS;
    }

    /* renamed from: com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper$1 */
    static /* synthetic */ class C123131 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$sign$view$helper$PayMethodSelectCloseHelper$SelectionValidationResult */
        static final /* synthetic */ int[] f36351xb376ecbd;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper$SelectionValidationResult[] r0 = com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper.SelectionValidationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36351xb376ecbd = r0
                com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper$SelectionValidationResult r1 = com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper.SelectionValidationResult.ERROR_NONE_SELECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36351xb376ecbd     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper$SelectionValidationResult r1 = com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper.SelectionValidationResult.ERROR_BALANCE_INSUFFICIENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper.C123131.<clinit>():void");
        }
    }

    public static String getValidationErrorMessage(Context context, SelectionValidationResult selectionValidationResult) {
        int i = C123131.f36351xb376ecbd[selectionValidationResult.ordinal()];
        if (i == 1) {
            return context.getString(R.string.one_payment_global_paylist_select_at_least_one);
        }
        if (i != 2) {
            return "";
        }
        return context.getString(R.string.one_payment_global_paylist_balance_insufficient);
    }

    public static DidiGlobalPayMethodListData.PayMethodListResult prepareSelectedPayMethodResult(List<PaySelItemData> list, int i) {
        DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult = new DidiGlobalPayMethodListData.PayMethodListResult();
        for (PaySelItemData next : list) {
            SystemUtils.log(3, "wallet", "back, selected method name: " + next.title, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper", 81);
            if ((190 == next.channelId || 120 == next.channelId) && !TextUtils.isEmpty(next.balance)) {
                try {
                    if (Integer.valueOf(next.balance).intValue() <= 0) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            DidiGlobalPayMethodListData.SelectedPayMethod selectedPayMethod = new DidiGlobalPayMethodListData.SelectedPayMethod();
            selectedPayMethod.cardNo = TextUtils.isEmpty(next.titleInFromPage) ? next.title : next.titleInFromPage;
            selectedPayMethod.cardIndex = next.cardIndex;
            selectedPayMethod.iconUrl = TextUtils.isEmpty(next.iconUrlFromPage) ? next.iconUrl : next.iconUrlFromPage;
            selectedPayMethod.channelId = next.channelId;
            selectedPayMethod.combineTag = next.combineTag;
            if (!TextUtils.isEmpty(next.discount)) {
                selectedPayMethod.hasCoupon = true;
            }
            payMethodListResult.selectedPayMethods.add(selectedPayMethod);
            payMethodListResult.combinedTags |= selectedPayMethod.combineTag;
        }
        payMethodListResult.enterpriseFlag = i;
        return payMethodListResult;
    }

    public static boolean isChannelRefreshed(Context context, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        boolean z;
        if (payMethodListParam == null || payMethodListParam.list == null || payMethodListParam.list.size() == 0 || payMethodListResult == null || payMethodListResult.selectedPayMethods == null || payMethodListResult.selectedPayMethods.isEmpty()) {
            return true;
        }
        Set<String> a = m25726a(payMethodListParam);
        Iterator<DidiGlobalPayMethodListData.SelectedPayMethod> it = payMethodListResult.selectedPayMethods.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            DidiGlobalPayMethodListData.SelectedPayMethod next = it.next();
            if (!a.contains(m25725a(next.channelId, next.cardIndex))) {
                z = true;
                break;
            }
        }
        if (!(z || payMethodListParam.enterpriseInfo == null || payMethodListParam.enterpriseInfo.flag == payMethodListResult.enterpriseFlag)) {
            z = true;
        }
        if (z || a.size() != payMethodListResult.selectedPayMethods.size()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static Set<String> m25726a(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        HashSet hashSet = new HashSet();
        for (DidiGlobalPayMethodListData.PayMethodInfo next : payMethodListParam.list) {
            if (next != null && next.isSelected) {
                int i = next.channelId;
                if (next.cardList == null || next.cardList.isEmpty()) {
                    hashSet.add(m25725a(i, (String) null));
                } else {
                    for (DidiGlobalPayMethodListData.CardInfo next2 : next.cardList) {
                        if (next2 != null && next2.isSelected) {
                            hashSet.add(m25725a(i, next2.cardIndex));
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private static String m25725a(int i, String str) {
        String valueOf = String.valueOf(i);
        if (str == null) {
            return valueOf;
        }
        return valueOf + str.toLowerCase();
    }
}

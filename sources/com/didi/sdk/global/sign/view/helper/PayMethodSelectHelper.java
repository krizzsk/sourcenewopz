package com.didi.sdk.global.sign.view.helper;

import android.content.Context;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.PayMethodCardView;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.List;

public class PayMethodSelectHelper {

    /* renamed from: a */
    static final /* synthetic */ boolean f36352a = (!PayMethodSelectHelper.class.desiredAssertionStatus());

    public enum SwitchResult {
        SUCCESS,
        ERROR_TURN_OFF_THE_ONLY_AVAILABLE_PAY_METHOD,
        ERROR_INSUFFICIENT
    }

    public static void doSelectEvent(View view, PaySelItemData paySelItemData, List<PayMethodCardView> list) {
        int i = paySelItemData.channelId;
        String str = paySelItemData.cardIndex;
        SystemUtils.log(3, "wallet", "View clicked, name: " + paySelItemData.title, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper", 35);
        for (PayMethodCardView next : list) {
            if (next.getChannelId() == i && isCardIndexEqual(str, next.getCardIndex())) {
                next.setIsSelected(true);
            } else if (!canCombine(next.getPayMethodItemInfo(), paySelItemData)) {
                next.setIsSelected(false);
            } else if (190 == next.getChannelId() && !next.getPayMethodItemInfo().isHit99payCombination) {
                next.setIsSelected(false);
            }
        }
    }

    public static SwitchResult doSwitchEvent(View view, PaySelItemData paySelItemData, List<PayMethodCardView> list) {
        PaySelItemData paySelItemData2 = paySelItemData;
        int i = paySelItemData2.channelId;
        SystemUtils.log(3, "wallet", "Switch button clicked, name: " + paySelItemData2.title + ", wasSelected:" + paySelItemData2.isSelected, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper", 60);
        if (f36352a || paySelItemData2.channelId == 120) {
            PayMethodCardView payMethodCardView = null;
            PayMethodCardView payMethodCardView2 = null;
            int i2 = 0;
            boolean z = false;
            for (PayMethodCardView next : list) {
                if (next.getChannelId() != i) {
                    if (next.getPayMethodItemInfo().isEnabled && next.getPayMethodItemInfo().style == 1) {
                        i2++;
                        if (next.getPayMethodItemInfo().channelId == 153) {
                            payMethodCardView2 = next;
                        }
                    }
                    if (canCombine(paySelItemData2, next.getPayMethodItemInfo()) && next.getPayMethodItemInfo().isEnabled) {
                        if (next.getPayMethodItemInfo().style == 1 || next.getPayMethodItemInfo().style == 3) {
                            z = true;
                        }
                    }
                }
            }
            if (i2 == 0 && paySelItemData2.isEnabled && paySelItemData2.isSelected) {
                return SwitchResult.ERROR_TURN_OFF_THE_ONLY_AVAILABLE_PAY_METHOD;
            }
            if (!paySelItemData2.isSelected && !paySelItemData2.isSufficient && !z) {
                return SwitchResult.ERROR_INSUFFICIENT;
            }
            boolean z2 = !paySelItemData2.isSelected;
            boolean z3 = false;
            for (PayMethodCardView next2 : list) {
                if (next2.getChannelId() == i) {
                    next2.setIsSelected(z2);
                } else {
                    if (!canCombine(paySelItemData2, next2.getPayMethodItemInfo())) {
                        SystemUtils.log(3, "wallet", "Not combinational method: " + next2.getPayMethodItemInfo().title + ", tag=" + next2.getPayMethodItemInfo().combineTag, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper", 106);
                        next2.setIsSelected(false);
                        next2.setTitleStyle(z2 ? 2 : 0);
                        next2.setMaskingVisibility(z2);
                        if (!z2 && i2 == 1 && payMethodCardView2 != null) {
                            payMethodCardView2.setIsSelected(true);
                        }
                    } else if (payMethodCardView == null) {
                        payMethodCardView = next2;
                    }
                    if (!z3 && next2.getPayMethodItemInfo().isSelected) {
                        z3 = true;
                    }
                }
            }
            if (!z3 && payMethodCardView != null) {
                payMethodCardView.setIsSelected(true);
            }
            return SwitchResult.SUCCESS;
        }
        throw new AssertionError();
    }

    /* renamed from: com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper$1 */
    static /* synthetic */ class C123141 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$sign$view$helper$PayMethodSelectHelper$SwitchResult */
        static final /* synthetic */ int[] f36353x5fddfea0;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper$SwitchResult[] r0 = com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper.SwitchResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36353x5fddfea0 = r0
                com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper$SwitchResult r1 = com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper.SwitchResult.ERROR_INSUFFICIENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36353x5fddfea0     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper$SwitchResult r1 = com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper.SwitchResult.ERROR_TURN_OFF_THE_ONLY_AVAILABLE_PAY_METHOD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper.C123141.<clinit>():void");
        }
    }

    public static String getSwitchErrorMessage(Context context, SwitchResult switchResult) {
        int i = C123141.f36353x5fddfea0[switchResult.ordinal()];
        if (i == 1) {
            return context.getString(R.string.one_payment_global_paylist_balance_insufficient);
        }
        if (i != 2) {
            return "";
        }
        return context.getString(R.string.one_payment_global_paylist_balance_turn_off_only_paymethod);
    }

    public static void checkCombine(List<PayMethodCardView> list) {
        if (list != null && list.size() != 0) {
            PayMethodCardView payMethodCardView = null;
            PayMethodCardView payMethodCardView2 = null;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            while (i < list.size()) {
                PayMethodCardView payMethodCardView3 = list.get(i);
                if (payMethodCardView3 != null) {
                    if (!z) {
                        if ((120 == payMethodCardView3.getChannelId() || (190 == payMethodCardView3.getChannelId() && payMethodCardView3.getPayMethodItemInfo().isHit99payCombination)) && payMethodCardView3.getPayMethodItemInfo().isPriorityUse) {
                            payMethodCardView2 = payMethodCardView3;
                            i = 0;
                            z = true;
                        }
                    } else if (!(payMethodCardView2 == null || payMethodCardView2 == payMethodCardView3)) {
                        if (!canCombine(payMethodCardView2.getPayMethodItemInfo(), payMethodCardView3.getPayMethodItemInfo())) {
                            payMethodCardView3.setIsSelected(false);
                            payMethodCardView3.setTitleStyle(2);
                            payMethodCardView3.setMaskingVisibility(true);
                        } else {
                            if (payMethodCardView == null) {
                                payMethodCardView = payMethodCardView3;
                            }
                            if (!z2) {
                                z2 = payMethodCardView3.getPayMethodItemInfo().isSelected;
                            }
                        }
                    }
                    i++;
                }
            }
            if (z && !z2 && payMethodCardView != null) {
                payMethodCardView.setIsSelected(true);
            }
        }
    }

    public static boolean canCombine(PaySelItemData paySelItemData, PaySelItemData paySelItemData2) {
        if (paySelItemData == null || paySelItemData.allowedCombineTags == null || !paySelItemData.allowedCombineTags.contains(Integer.valueOf(paySelItemData2.combineTag)) || paySelItemData2.status != 1 || paySelItemData2.expired == 1) {
            return false;
        }
        return true;
    }

    public static boolean isCardIndexEqual(String str, String str2) {
        if (TextUtil.isEmpty(str)) {
            return TextUtil.isEmpty(str2);
        }
        if (TextUtil.isEmpty(str2)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static SwitchResult doSwitchEventV2(PaySelItemData paySelItemData, List<PaySelItemData> list) {
        PaySelItemData paySelItemData2 = paySelItemData;
        int i = paySelItemData2.channelId;
        SystemUtils.log(3, "wallet", "Switch button clicked, name: " + paySelItemData2.title + ", wasSelected:" + paySelItemData2.isSelected, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper", 226);
        PaySelItemData paySelItemData3 = null;
        PaySelItemData paySelItemData4 = null;
        int i2 = 0;
        boolean z = false;
        for (PaySelItemData next : list) {
            if (next.channelId != i) {
                if (next.isEnabled && next.style == 1) {
                    i2++;
                    if (next.channelId == 153) {
                        paySelItemData4 = next;
                    }
                }
                if (canCombine(paySelItemData2, next) && next.isEnabled) {
                    if (next.style == 1 || next.style == 3) {
                        z = true;
                    }
                }
            }
        }
        if (i2 == 0 && paySelItemData2.isEnabled && paySelItemData2.isSelected) {
            return SwitchResult.ERROR_TURN_OFF_THE_ONLY_AVAILABLE_PAY_METHOD;
        }
        if (!paySelItemData2.isSelected && !paySelItemData2.isSufficient && !z) {
            return SwitchResult.ERROR_INSUFFICIENT;
        }
        boolean z2 = !paySelItemData2.isSelected;
        boolean z3 = false;
        for (PaySelItemData next2 : list) {
            if (next2.channelId == i) {
                next2.isSelected = z2;
            } else {
                if (!canCombine(paySelItemData2, next2)) {
                    SystemUtils.log(3, "wallet", "Not combinational method: " + next2.title + ", tag=" + next2.combineTag, (Throwable) null, "com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper", 269);
                    next2.isSelected = false;
                    if (!z2 && i2 == 1 && paySelItemData4 != null) {
                        paySelItemData4.isSelected = true;
                    }
                } else if (paySelItemData3 == null) {
                    paySelItemData3 = next2;
                }
                if (!z3 && next2.isSelected) {
                    z3 = true;
                }
            }
        }
        if (!z3 && paySelItemData3 != null) {
            paySelItemData3.isSelected = true;
        }
        return SwitchResult.SUCCESS;
    }
}

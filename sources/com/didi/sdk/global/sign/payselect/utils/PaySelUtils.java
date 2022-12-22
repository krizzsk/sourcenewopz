package com.didi.sdk.global.sign.payselect.utils;

import android.text.TextUtils;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007J\u001c\u0010\u0014\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0007J\u001c\u0010\u0016\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/PaySelUtils;", "", "()V", "hasBalanceAndNotZero", "", "curSelectedChannels", "", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "isBalanceChannel", "channelId", "", "isBalanceCombinedMode", "itemData", "isCombinedChannelSelected", "isFrozenMode", "frozenData", "Lcom/didi/payment/commonsdk/basemodel/account/AccountFreezeData;", "isSameChannel", "payItem1", "payItem2", "isSwitchOutCombinedChannel", "intentChannel", "isSwitchOutMainGroup", "isZeroBalance", "balance", "", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelUtils.kt */
public final class PaySelUtils {
    public static final PaySelUtils INSTANCE = new PaySelUtils();

    public final boolean isBalanceChannel(int i) {
        return i == 190 || i == 120;
    }

    private PaySelUtils() {
    }

    public final boolean isSameChannel(PaySelItemData paySelItemData, PaySelItemData paySelItemData2) {
        Intrinsics.checkNotNullParameter(paySelItemData, "payItem1");
        Intrinsics.checkNotNullParameter(paySelItemData2, "payItem2");
        return paySelItemData.channelId == paySelItemData2.channelId && PayMethodSelectHelper.isCardIndexEqual(paySelItemData.cardIndex, paySelItemData2.cardIndex);
    }

    /* renamed from: a */
    private final boolean m25669a(List<? extends PaySelItemData> list) {
        Set<Integer> set;
        PaySelItemData paySelItemData;
        if (list.size() != 2) {
            return false;
        }
        Iterator<? extends PaySelItemData> it = list.iterator();
        while (true) {
            set = null;
            if (!it.hasNext()) {
                paySelItemData = null;
                break;
            }
            paySelItemData = (PaySelItemData) it.next();
            if (isBalanceChannel(paySelItemData.channelId)) {
                break;
            }
        }
        if (paySelItemData != null) {
            set = paySelItemData.allowedCombineTags;
        }
        if (set == null) {
            return false;
        }
        boolean z = true;
        for (PaySelItemData paySelItemData2 : list) {
            if (!INSTANCE.isBalanceChannel(paySelItemData2.channelId) && !paySelItemData.allowedCombineTags.contains(Integer.valueOf(paySelItemData2.combineTag))) {
                z = false;
            }
        }
        return z;
    }

    public final boolean isSwitchOutCombinedChannel(List<? extends PaySelItemData> list, PaySelItemData paySelItemData) {
        Set<Integer> set;
        PaySelItemData paySelItemData2;
        Intrinsics.checkNotNullParameter(list, "curSelectedChannels");
        Intrinsics.checkNotNullParameter(paySelItemData, "intentChannel");
        Iterator<? extends PaySelItemData> it = list.iterator();
        while (true) {
            set = null;
            if (!it.hasNext()) {
                paySelItemData2 = null;
                break;
            }
            paySelItemData2 = (PaySelItemData) it.next();
            if (isBalanceChannel(paySelItemData2.channelId)) {
                break;
            }
        }
        if (paySelItemData2 != null) {
            set = paySelItemData2.allowedCombineTags;
        }
        if (set != null && m25669a(list) && !list.contains(paySelItemData) && !paySelItemData2.allowedCombineTags.contains(Integer.valueOf(paySelItemData.combineTag))) {
            return true;
        }
        return false;
    }

    public final boolean hasBalanceAndNotZero(List<? extends PaySelItemData> list) {
        Intrinsics.checkNotNullParameter(list, "curSelectedChannels");
        for (PaySelItemData paySelItemData : list) {
            if (INSTANCE.isBalanceChannel(paySelItemData.channelId) && !INSTANCE.isZeroBalance(paySelItemData.balance)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSwitchOutMainGroup(List<? extends PaySelItemData> list, PaySelItemData paySelItemData) {
        PaySelGroupData paySelGroupData;
        Intrinsics.checkNotNullParameter(list, "curSelectedChannels");
        Intrinsics.checkNotNullParameter(paySelItemData, "intentChannel");
        PaySelGroupData paySelGroupData2 = paySelItemData.groupData;
        if (paySelGroupData2 == null || !paySelGroupData2.isOtherGroup()) {
            return false;
        }
        if (isSwitchOutCombinedChannel(list, paySelItemData)) {
            return true;
        }
        if (!(!list.isEmpty()) || (paySelGroupData = ((PaySelItemData) list.get(0)).groupData) == null || paySelGroupData.isOtherGroup()) {
            return false;
        }
        return true;
    }

    public final boolean isZeroBalance(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Integer valueOf = Integer.valueOf(str);
            if (valueOf != null) {
                if (valueOf.intValue() == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final boolean isBalanceCombinedMode(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "itemData");
        return 120 == paySelItemData.channelId || (190 == paySelItemData.channelId && paySelItemData.isHit99payCombination);
    }

    public final boolean isFrozenMode(AccountFreezeData accountFreezeData) {
        return accountFreezeData != null && accountFreezeData.isBannerValid();
    }
}

package com.didi.sdk.global.sign.payselect.utils;

import android.text.TextUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.push.ServerParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, mo175978d2 = {"findDiscountStr", "", "param", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "key", "isSamePayChannel", "", "first", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "second", "payment_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelUtils.kt */
public final class PaySelUtilsKt {
    public static final String findDiscountStr(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, String str) {
        if ((payMethodListParam == null ? null : payMethodListParam.list) == null) {
            return "";
        }
        for (DidiGlobalPayMethodListData.PayMethodInfo next : payMethodListParam.list) {
            if (next.channelId == 150) {
                String str2 = next.toAddCardInfo;
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    try {
                        String optString = new JSONObject(str2).optString(str);
                        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
                        return optString;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "";
    }

    public static final boolean isSamePayChannel(PaySelItemData paySelItemData, PaySelItemData paySelItemData2) {
        Intrinsics.checkNotNullParameter(paySelItemData, ServerParam.PARAM_FIRST);
        Intrinsics.checkNotNullParameter(paySelItemData2, "second");
        if (paySelItemData.channelId != paySelItemData2.channelId || !StringsKt.equals(paySelItemData.cardIndex, paySelItemData2.cardIndex, true)) {
            return false;
        }
        return true;
    }
}

package com.didi.foundation.sdk.utils;

import com.didichuxing.apollo.sdk.Apollo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/foundation/sdk/utils/FoundationApolloUtil;", "", "()V", "CUSTOMER_IM_SHORT_MESSAGE_LIST", "", "EXPERIMENT", "LOCALE_LANG", "LOCALE_LANG_TEST", "MESSAGE", "OPEN_VERIFY", "PARAMS", "getApolloMessages", "apolloName", "paraName", "getIMQuickMessages", "getLocaleLangkMessages", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: FoundationApolloUtil.kt */
public final class FoundationApolloUtil {
    public static final FoundationApolloUtil INSTANCE = new FoundationApolloUtil();

    /* renamed from: a */
    private static final String f21387a = "global_customer_im_short_message_list_v3";

    /* renamed from: b */
    private static final String f21388b = "experiment";

    /* renamed from: c */
    private static final String f21389c = "open_verify";

    /* renamed from: d */
    private static final String f21390d = "params";

    /* renamed from: e */
    private static final String f21391e = "im_message";

    /* renamed from: f */
    private static final String f21392f = "locale_lang";

    /* renamed from: g */
    private static final String f21393g = "locale_lang_test";

    private FoundationApolloUtil() {
    }

    @JvmStatic
    public static final String getIMQuickMessages(String str) {
        JSONObject jsonToggle;
        String str2;
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || (jsonToggle = Apollo.getJsonToggle(str)) == null) {
            return "";
        }
        try {
            JSONObject jSONObject = jsonToggle.getJSONObject(f21388b);
            JSONObject jSONObject2 = null;
            if (jSONObject != null) {
                jSONObject2 = jSONObject.getJSONObject("params");
            }
            if (jSONObject2 != null) {
                str2 = jSONObject2.optString(f21391e);
                Intrinsics.checkExpressionValueIsNotNull(str2, "params.optString(MESSAGE)");
            } else {
                str2 = "";
            }
            LogUtils.INSTANCE.mo63518d("IM Common words from ab: " + str2);
            return str2;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @JvmStatic
    public static final String getLocaleLangkMessages(String str) {
        JSONObject jsonToggle;
        String str2;
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || (jsonToggle = Apollo.getJsonToggle(str)) == null) {
            return "";
        }
        try {
            JSONObject jSONObject = jsonToggle.getJSONObject(f21388b);
            JSONObject jSONObject2 = null;
            if (jSONObject != null) {
                jSONObject2 = jSONObject.getJSONObject("params");
            }
            if (jSONObject2 != null) {
                str2 = jSONObject2.optString(f21392f);
                Intrinsics.checkExpressionValueIsNotNull(str2, "params.optString(LOCALE_LANG)");
                if (LocaleUtils.isDubug) {
                    str2 = jSONObject2.optString(f21393g);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "params.optString(LOCALE_LANG_TEST)");
                }
            } else {
                str2 = "";
            }
            LogUtils.INSTANCE.mo63518d("Locale lang Common words from ab: " + str2);
            return str2;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @JvmStatic
    public static final String getApolloMessages(String str, String str2) {
        JSONObject jsonToggle;
        String str3;
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        CharSequence charSequence2 = str2;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z || (jsonToggle = Apollo.getJsonToggle(str)) == null) {
            return "";
        }
        try {
            JSONObject jSONObject = jsonToggle.getJSONObject(f21388b);
            JSONObject jSONObject2 = null;
            if (jSONObject != null) {
                jSONObject2 = jSONObject.getJSONObject("params");
            }
            if (jSONObject2 != null) {
                str3 = jSONObject2.optString(str2);
                Intrinsics.checkExpressionValueIsNotNull(str3, "params.optString(paraName)");
            } else {
                str3 = "";
            }
            LogUtils.INSTANCE.mo63518d("messages: " + str3);
            return str3;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}

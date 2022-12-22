package com.adyen.checkout.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\n\u0010\u000e\u001a\u00020\u0005*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"FLAG_NON_NULL", "", "FLAG_NULL", "INDENTATION_SPACES", "PARSING_ERROR", "", "getBooleanOrNull", "", "Lorg/json/JSONObject;", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getStringOrNull", "optStringList", "", "toStringPretty", "checkout-core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JsonUtils.kt */
public final class JsonUtilsKt {

    /* renamed from: a */
    private static final int f942a = 4;

    /* renamed from: b */
    private static final String f943b = "PARSING_ERROR";

    /* renamed from: c */
    private static final int f944c = 0;

    /* renamed from: d */
    private static final int f945d = 1;

    public static final String getStringOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static final Boolean getBooleanOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static final String toStringPretty(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        try {
            String jSONObject2 = jSONObject.toString(4);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n        toString(INDENTATION_SPACES)\n    }");
            return jSONObject2;
        } catch (JSONException unused) {
            return f943b;
        }
    }

    public static final List<String> optStringList(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return JsonUtils.parseOptStringList(jSONObject.optJSONArray(str));
    }
}

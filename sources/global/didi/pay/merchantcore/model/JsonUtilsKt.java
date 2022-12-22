package global.didi.pay.merchantcore.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\n\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r*\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\n\u0010\u000e\u001a\u00020\u0005*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"FLAG_NON_NULL", "", "FLAG_NULL", "INDENTATION_SPACES", "PARSING_ERROR", "", "getBooleanOrNull", "", "Lorg/json/JSONObject;", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getStringOrNull", "optStringList", "", "toStringPretty", "merchantCore_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: JsonUtils.kt */
public final class JsonUtilsKt {
    private static final int FLAG_NON_NULL = 1;
    private static final int FLAG_NULL = 0;
    private static final int INDENTATION_SPACES = 4;
    private static final String PARSING_ERROR = "PARSING_ERROR";

    public static final String getStringOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$getStringOrNull");
        Intrinsics.checkParameterIsNotNull(str, "key");
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static final Boolean getBooleanOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$getBooleanOrNull");
        Intrinsics.checkParameterIsNotNull(str, "key");
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static final String toStringPretty(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$toStringPretty");
        try {
            String jSONObject2 = jSONObject.toString(4);
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "toString(INDENTATION_SPACES)");
            return jSONObject2;
        } catch (JSONException unused) {
            return PARSING_ERROR;
        }
    }

    public static final List<String> optStringList(JSONObject jSONObject, String str) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "$this$optStringList");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return JsonUtils.parseOptStringList(jSONObject.optJSONArray(str));
    }
}

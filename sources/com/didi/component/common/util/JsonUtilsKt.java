package com.didi.component.common.util;

import com.didi.travel.psnger.common.net.base.BaseObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0006H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"convertTo", "T", "Lcom/didi/travel/psnger/common/net/base/BaseObject;", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/didi/travel/psnger/common/net/base/BaseObject;", "jsonTo", "", "(Ljava/lang/String;)Lcom/didi/travel/psnger/common/net/base/BaseObject;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JsonUtils.kt */
public final class JsonUtilsKt {
    public static final /* synthetic */ <T extends BaseObject> T jsonTo(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        T newInstance = BaseObject.class.newInstance();
        T t = (BaseObject) newInstance;
        t.parse(str);
        Intrinsics.checkNotNullExpressionValue(newInstance, "T::class.java.newInstanc…ly { parse(this@jsonTo) }");
        return t;
    }

    public static final /* synthetic */ <T extends BaseObject> T convertTo(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        T newInstance = BaseObject.class.newInstance();
        T t = (BaseObject) newInstance;
        t.parse(jSONObject.toString());
        Intrinsics.checkNotNullExpressionValue(newInstance, "T::class.java.newInstanc…s@convertTo.toString()) }");
        return t;
    }
}

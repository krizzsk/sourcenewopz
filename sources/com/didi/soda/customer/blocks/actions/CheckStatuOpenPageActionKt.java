package com.didi.soda.customer.blocks.actions;

import android.os.Bundle;
import android.os.Parcelable;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bH\u0002¨\u0006\t"}, mo175978d2 = {"copyFormMap", "", "Landroid/os/Bundle;", "key", "", "value", "", "toBundle", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CheckStatuOpenPageAction.kt */
public final class CheckStatuOpenPageActionKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final Bundle m28789a(Map<?, ?> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (!(key instanceof String) || value == null) {
                LogUtil.m29102e("toBundle", Intrinsics.stringPlus("key 非字符串key = ", key));
            } else {
                String str = "";
                if (Intrinsics.areEqual(key, (Object) Const.PageParams.ANCHOR_INFO)) {
                    try {
                        str = GsonUtil.toJson(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bundle.putString((String) key, str);
                } else if (Intrinsics.areEqual(key, (Object) Const.PageParams.ACTION_INFO_DICT)) {
                    try {
                        str = GsonUtil.toJson(value);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    bundle.putString((String) key, str);
                } else {
                    String lowerCase = ((String) key).toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    m28790a(bundle, lowerCase, value);
                }
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private static final void m28790a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            bundle.putByte(str, ((Number) obj).byteValue());
        } else if (obj instanceof JsonObject) {
            bundle.putString(str, GsonUtil.toJson(obj));
        } else {
            LogUtil.m29102e("toBundle", "不受支持的类型");
        }
    }
}

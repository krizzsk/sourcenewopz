package com.didi.global.fintech.cashier.core.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/GlobalCashierWebParamUtils;", "", "()V", "appendUrlQueryParams", "", "url", "params", "", "needAppend", "Landroid/net/Uri$Builder;", "uri", "Landroid/net/Uri;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierWebParamUtils.kt */
public final class GlobalCashierWebParamUtils {
    public static final GlobalCashierWebParamUtils INSTANCE = new GlobalCashierWebParamUtils();

    private GlobalCashierWebParamUtils() {
    }

    public final String appendUrlQueryParams(String str, Map<String, ? extends Object> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
        String builder = m15748a(parse, map).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
        return builder;
    }

    /* renamed from: a */
    private final Uri.Builder m15748a(Uri uri, Map<String, ? extends Object> map) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (map == null || map.isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            return buildUpon;
        } else if (uri.isOpaque()) {
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            return buildUpon;
        } else {
            for (Map.Entry entry : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && uri.getQueryParameter((String) entry.getKey()) == null) {
                    buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            return buildUpon;
        }
    }
}

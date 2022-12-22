package com.global.didi.elvish.currency;

import android.content.Context;
import com.global.didi.elvish.util.FileUtils;
import com.global.didi.elvish.util.JsonUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/global/didi/elvish/currency/CurrencyStore;", "", "()V", "loadLocalCurrencyCountryConf", "", "", "context", "Landroid/content/Context;", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: CurrencyDataLoader.kt */
public final class CurrencyStore {
    public final Map<String, String> loadLocalCurrencyCountryConf(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String formAssets = FileUtils.INSTANCE.getFormAssets(context, "currency_country.json");
        CharSequence charSequence = formAssets;
        if (charSequence == null || charSequence.length() == 0) {
            return new LinkedHashMap<>();
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        return (Map) new Gson().fromJson(formAssets, Map.class);
    }
}

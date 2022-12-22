package com.global.didi.elvish.datetime;

import android.content.Context;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.global.didi.elvish.datetime.model.TimezoneOffsetModel;
import com.global.didi.elvish.util.FileUtils;
import com.global.didi.elvish.util.JsonUtils;
import com.global.didi.elvish.util.LogUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/DateTimeLoader;", "", "()V", "loadCityConf", "", "", "context", "Landroid/content/Context;", "loadRemoteCityConf", "loadRemoteTimezoneOffset", "Lcom/global/didi/elvish/datetime/model/TimezoneOffsetModel;", "loadTimezoneOffset", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DateTimeLoader.kt */
public final class DateTimeLoader {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.util.Map<java.lang.String, java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> loadCityConf(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.util.Map r0 = r5.m37309a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0016
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = 1
        L_0x0017:
            if (r3 == 0) goto L_0x0067
            com.global.didi.elvish.util.FileUtils r3 = com.global.didi.elvish.util.FileUtils.INSTANCE
            java.lang.String r4 = "local_cityid_timezone.json"
            java.lang.String r6 = r3.getFormAssets(r6, r4)
            if (r6 == 0) goto L_0x0067
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            if (r3 == 0) goto L_0x0033
            r3 = r6
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            if (r3 == 0) goto L_0x0067
            com.global.didi.elvish.util.JsonUtils r0 = com.global.didi.elvish.util.JsonUtils.INSTANCE
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            java.lang.Object r6 = r0.fromJson((java.lang.String) r6, r3)
            r0 = r6
            java.util.Map r0 = (java.util.Map) r0
            com.global.didi.elvish.util.LogUtils r6 = com.global.didi.elvish.util.LogUtils.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Load local_cityid_timezone.json conf : "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r6.print(r3)
            if (r0 == 0) goto L_0x0064
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x0065
        L_0x0064:
            r1 = 1
        L_0x0065:
            if (r1 != 0) goto L_0x0067
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.datetime.DateTimeLoader.loadCityConf(android.content.Context):java.util.Map");
    }

    /* renamed from: a */
    private final Map<String, String> m37309a() {
        IToggle toggle = Apollo.getToggle("elvish_city_timezone");
        IToggle iToggle = null;
        if (!toggle.allow()) {
            toggle = null;
        }
        if (toggle == null) {
            IToggle toggle2 = Apollo.getToggle("elvish_city_timezone_base");
            if (toggle2.allow()) {
                iToggle = toggle2;
            }
            toggle = iToggle;
        }
        if (toggle != null) {
            String str = (String) toggle.getExperiment().getParam("md5", "");
            String str2 = (String) toggle.getExperiment().getParam(GPageIdConstant.G_PAGE_ID_CONF, "");
            Intrinsics.checkExpressionValueIsNotNull(str2, "jsonString");
            if ((str2.length() > 0) && Intrinsics.areEqual((Object) str, (Object) FileUtils.INSTANCE.encodeMd5(str2))) {
                JsonUtils jsonUtils = JsonUtils.INSTANCE;
                Map<String, String> map = (Map) new Gson().fromJson(str2, Map.class);
                String.valueOf(map.get("version"));
                LogUtils.INSTANCE.print("Load remote elvish_city conf : " + map);
                return map;
            }
        }
        return new LinkedHashMap<>();
    }

    public final TimezoneOffsetModel loadTimezoneOffset(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TimezoneOffsetModel b = m37310b();
        if (b != null) {
            return b;
        }
        String formAssets = FileUtils.INSTANCE.getFormAssets(context, "local_timezone.json");
        if (formAssets == null) {
            formAssets = "";
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        TimezoneOffsetModel timezoneOffsetModel = (TimezoneOffsetModel) new Gson().fromJson(formAssets, TimezoneOffsetModel.class);
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.print("Load local_timezone.json conf : " + timezoneOffsetModel);
        return timezoneOffsetModel;
    }

    /* renamed from: b */
    private final TimezoneOffsetModel m37310b() {
        IToggle toggle = Apollo.getToggle("elvish_zoneinfo");
        if (!toggle.allow()) {
            toggle = null;
        }
        if (toggle != null) {
            String str = (String) toggle.getExperiment().getParam("md5", "");
            String str2 = (String) toggle.getExperiment().getParam(GPageIdConstant.G_PAGE_ID_CONF, "");
            Intrinsics.checkExpressionValueIsNotNull(str2, "jsonString");
            if ((str2.length() > 0) && Intrinsics.areEqual((Object) str, (Object) FileUtils.INSTANCE.encodeMd5(str2))) {
                JsonUtils jsonUtils = JsonUtils.INSTANCE;
                TimezoneOffsetModel timezoneOffsetModel = (TimezoneOffsetModel) new Gson().fromJson(str2, TimezoneOffsetModel.class);
                LogUtils.INSTANCE.print("Load remote elvish_zoneinfo conf : " + timezoneOffsetModel);
                return timezoneOffsetModel;
            }
        }
        return null;
    }
}

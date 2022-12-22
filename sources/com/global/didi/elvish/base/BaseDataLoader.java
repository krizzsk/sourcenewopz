package com.global.didi.elvish.base;

import android.content.Context;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.global.didi.elvish.language.LanguageModel;
import com.global.didi.elvish.util.FileUtils;
import com.global.didi.elvish.util.JsonUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J|\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132-\u0010\u0014\u001a)\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00180\u00152-\u0010\u0019\u001a)\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00180\u0015J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/global/didi/elvish/base/BaseDataLoader;", "", "()V", "KEY_DEFAULT", "", "KEY_LANGUAGECONFIG", "KEY_SUPPORTLIST", "KEY_SUPPORTLIST_99", "KEY_SUPPORTLIST_GLOBAL", "buildLocale", "Ljava/util/Locale;", "language", "country", "loadLanguageConfig", "Lcom/global/didi/elvish/language/LanguageModel;", "context", "Landroid/content/Context;", "locale", "isGlobal", "", "loadRemoteLanguageConfData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "loadLocalAssetsLanguageConfData", "config", "loadLocalAssetsRuleConfData", "loadRemoteRuleConfData", "localCustomRuleConfData", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: BaseDataLoader.kt */
public final class BaseDataLoader {

    /* renamed from: a */
    private final String f52551a = "supportList";

    /* renamed from: b */
    private final String f52552b = "languageConfig";

    /* renamed from: c */
    private final String f52553c = "99";

    /* renamed from: d */
    private final String f52554d = "global";

    /* renamed from: e */
    private final String f52555e = "default";

    public final Map<String, Object> localCustomRuleConfData(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Map<String, Object> a = m37294a(context);
        return a == null || a.isEmpty() ? m37295b(context) : a;
    }

    /* renamed from: a */
    private final Map<String, Object> m37294a(Context context) {
        IToggle toggle = Apollo.getToggle("elvish_conf_server");
        IToggle iToggle = null;
        if (!toggle.allow()) {
            toggle = null;
        }
        if (toggle == null) {
            IToggle toggle2 = Apollo.getToggle("elvish_conf_server_base");
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
                Map<String, Object> map = (Map) new Gson().fromJson(str2, Map.class);
                String.valueOf(map.get("version"));
                return map;
            }
        }
        return new LinkedHashMap<>();
    }

    /* renamed from: b */
    private final Map<String, Object> m37295b(Context context) {
        String formAssets = FileUtils.INSTANCE.getFormAssets(context, "local_elvish.json");
        if (formAssets == null) {
            formAssets = "";
        }
        if (!(formAssets.length() > 0)) {
            return new LinkedHashMap<>();
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        return (Map) new Gson().fromJson(formAssets, Map.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final Map<String, Object> m37296c(Context context) {
        IToggle toggle = Apollo.getToggle("ibt_passenger_language_config_toggle");
        if (!toggle.allow()) {
            toggle = null;
        }
        if (toggle != null) {
            String str = (String) toggle.getExperiment().getParam("config", "");
            Intrinsics.checkExpressionValueIsNotNull(str, "jsonString");
            if (str.length() > 0) {
                JsonUtils jsonUtils = JsonUtils.INSTANCE;
                Map<String, Object> map = (Map) new Gson().fromJson(str, Map.class);
                String.valueOf(map.get("version"));
                return map;
            }
        }
        return new LinkedHashMap<>();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final Map<String, Object> m37297d(Context context) {
        String formAssets = FileUtils.INSTANCE.getFormAssets(context, "local_elvish_language_config.json");
        if (formAssets == null) {
            formAssets = "";
        }
        if (!(formAssets.length() > 0)) {
            return new LinkedHashMap<>();
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        return (Map) new Gson().fromJson(formAssets, Map.class);
    }

    public final LanguageModel loadLanguageConfig(Context context, Locale locale, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        BaseDataLoader baseDataLoader = this;
        return loadLanguageConfig(context, locale, z, (Function1<? super Context, ? extends Map<String, Object>>) new BaseDataLoader$loadLanguageConfig$1(baseDataLoader), (Function1<? super Context, ? extends Map<String, Object>>) new BaseDataLoader$loadLanguageConfig$2(baseDataLoader));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c2 A[Catch:{ Exception -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4 A[Catch:{ Exception -> 0x01d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.global.didi.elvish.language.LanguageModel loadLanguageConfig(android.content.Context r11, java.util.Locale r12, boolean r13, kotlin.jvm.functions.Function1<? super android.content.Context, ? extends java.util.Map<java.lang.String, java.lang.Object>> r14, kotlin.jvm.functions.Function1<? super android.content.Context, ? extends java.util.Map<java.lang.String, java.lang.Object>> r15) {
        /*
            r10 = this;
            java.lang.String r0 = "en_US"
            java.lang.String r1 = "en-US"
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r2)
            java.lang.String r2 = "locale"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r2)
            java.lang.String r2 = "loadRemoteLanguageConfData"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r2)
            java.lang.String r2 = "loadLocalAssetsLanguageConfData"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r2)
            java.lang.String r2 = "loadLanguageConfig"
            com.global.didi.elvish.base.BaseDataLoader r9 = new com.global.didi.elvish.base.BaseDataLoader     // Catch:{ Exception -> 0x01d9 }
            r9.<init>()     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r14 = r14.invoke(r11)     // Catch:{ Exception -> 0x01d9 }
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r3 = r9.f52551a     // Catch:{ Exception -> 0x01d9 }
            boolean r3 = r14.containsKey(r3)     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x0035
            java.lang.String r3 = r9.f52552b     // Catch:{ Exception -> 0x01d9 }
            boolean r3 = r14.containsKey(r3)     // Catch:{ Exception -> 0x01d9 }
            if (r3 != 0) goto L_0x0048
        L_0x0035:
            java.lang.Object r11 = r15.invoke(r11)     // Catch:{ Exception -> 0x01d9 }
            r14 = r11
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = "远程没数据，重新加载本地数据"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r8 = 148(0x94, float:2.07E-43)
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01d9 }
        L_0x0048:
            java.lang.String r11 = r12.getLanguage()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r12 = r12.getCountry()     // Catch:{ Exception -> 0x01d9 }
            r15 = r11
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x01d9 }
            r3 = 0
            r4 = 1
            if (r15 == 0) goto L_0x0060
            int r15 = r15.length()     // Catch:{ Exception -> 0x01d9 }
            if (r15 != 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r15 = 0
            goto L_0x0061
        L_0x0060:
            r15 = 1
        L_0x0061:
            if (r15 == 0) goto L_0x0075
            java.lang.String r5 = "systemLanguage.isNullOrEmpty()"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r8 = 153(0x99, float:2.14E-43)
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageModel r11 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x01d9 }
            return r11
        L_0x0075:
            com.google.gson.Gson r15 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01d9 }
            r15.<init>()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r9.f52551a     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r5 = r14.get(r5)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r15.toJson((java.lang.Object) r5)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r6 = r9.f52552b     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r14 = r14.get(r6)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r14 = r15.toJson((java.lang.Object) r14)     // Catch:{ Exception -> 0x01d9 }
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x01d9 }
            if (r6 == 0) goto L_0x009c
            int r6 = r6.length()     // Catch:{ Exception -> 0x01d9 }
            if (r6 != 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            r6 = 0
            goto L_0x009d
        L_0x009c:
            r6 = 1
        L_0x009d:
            if (r6 == 0) goto L_0x00b1
            java.lang.String r5 = "supportListStr.isNullOrEmpty()"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r8 = 161(0xa1, float:2.26E-43)
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageModel r11 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x01d9 }
            return r11
        L_0x00b1:
            r6 = r14
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x01d9 }
            if (r6 == 0) goto L_0x00bf
            int r6 = r6.length()     // Catch:{ Exception -> 0x01d9 }
            if (r6 != 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r6 = 0
            goto L_0x00c0
        L_0x00bf:
            r6 = 1
        L_0x00c0:
            if (r6 == 0) goto L_0x00d4
            java.lang.String r5 = "languageConfigStr.isNullOrEmpty()"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r8 = 165(0xa5, float:2.31E-43)
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageModel r11 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x01d9 }
            return r11
        L_0x00d4:
            r6 = 0
            r7 = r6
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ Exception -> 0x01d9 }
            r7 = r6
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.base.BaseDataLoader$loadLanguageConfig$3$1 r8 = new com.global.didi.elvish.base.BaseDataLoader$loadLanguageConfig$3$1     // Catch:{ Exception -> 0x01d9 }
            r8.<init>()     // Catch:{ Exception -> 0x01d9 }
            java.lang.reflect.Type r8 = r8.getType()     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r5 = r15.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r8)     // Catch:{ Exception -> 0x01d9 }
            java.util.HashMap r5 = (java.util.HashMap) r5     // Catch:{ Exception -> 0x01d9 }
            if (r5 == 0) goto L_0x0100
            if (r13 == 0) goto L_0x00f7
            java.lang.String r13 = r9.f52554d     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r13 = r5.get(r13)     // Catch:{ Exception -> 0x01d9 }
            java.util.ArrayList r13 = (java.util.ArrayList) r13     // Catch:{ Exception -> 0x01d9 }
            goto L_0x00ff
        L_0x00f7:
            java.lang.String r13 = r9.f52553c     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r13 = r5.get(r13)     // Catch:{ Exception -> 0x01d9 }
            java.util.ArrayList r13 = (java.util.ArrayList) r13     // Catch:{ Exception -> 0x01d9 }
        L_0x00ff:
            r7 = r13
        L_0x0100:
            r13 = r7
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ Exception -> 0x01d9 }
            if (r13 == 0) goto L_0x010b
            boolean r13 = r13.isEmpty()     // Catch:{ Exception -> 0x01d9 }
            if (r13 == 0) goto L_0x010c
        L_0x010b:
            r3 = 1
        L_0x010c:
            if (r3 == 0) goto L_0x0120
            java.lang.String r5 = "supportList.isNullOrEmpty()"
            r3 = 3
            r6 = 0
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r8 = 183(0xb7, float:2.56E-43)
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageModel r11 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x01d9 }
            return r11
        L_0x0120:
            r13 = r6
            java.util.HashMap r13 = (java.util.HashMap) r13     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.base.BaseDataLoader$loadLanguageConfig$3$3 r13 = new com.global.didi.elvish.base.BaseDataLoader$loadLanguageConfig$3$3     // Catch:{ Exception -> 0x01d9 }
            r13.<init>()     // Catch:{ Exception -> 0x01d9 }
            java.lang.reflect.Type r13 = r13.getType()     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r13 = r15.fromJson((java.lang.String) r14, (java.lang.reflect.Type) r13)     // Catch:{ Exception -> 0x01d9 }
            java.util.HashMap r13 = (java.util.HashMap) r13     // Catch:{ Exception -> 0x01d9 }
            r14 = r6
            com.global.didi.elvish.language.LanguageModel r14 = (com.global.didi.elvish.language.LanguageModel) r14     // Catch:{ Exception -> 0x01d9 }
            if (r13 == 0) goto L_0x0154
            java.lang.Object r15 = r13.get(r11)     // Catch:{ Exception -> 0x01d9 }
            java.util.HashMap r15 = (java.util.HashMap) r15     // Catch:{ Exception -> 0x01d9 }
            if (r15 == 0) goto L_0x0154
            java.lang.Object r12 = r15.get(r12)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageConfigItemModel r12 = (com.global.didi.elvish.language.LanguageConfigItemModel) r12     // Catch:{ Exception -> 0x01d9 }
            if (r12 == 0) goto L_0x0154
            com.global.didi.elvish.language.LanguageModel r14 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r15 = r12.getLang()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r12 = r12.getLocale()     // Catch:{ Exception -> 0x01d9 }
            r14.<init>(r15, r12)     // Catch:{ Exception -> 0x01d9 }
        L_0x0154:
            if (r14 != 0) goto L_0x0177
            if (r13 == 0) goto L_0x0177
            java.lang.Object r11 = r13.get(r11)     // Catch:{ Exception -> 0x01d9 }
            java.util.HashMap r11 = (java.util.HashMap) r11     // Catch:{ Exception -> 0x01d9 }
            if (r11 == 0) goto L_0x0177
            java.lang.String r12 = r9.f52555e     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageConfigItemModel r11 = (com.global.didi.elvish.language.LanguageConfigItemModel) r11     // Catch:{ Exception -> 0x01d9 }
            if (r11 == 0) goto L_0x0177
            com.global.didi.elvish.language.LanguageModel r14 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r12 = r11.getLang()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r11 = r11.getLocale()     // Catch:{ Exception -> 0x01d9 }
            r14.<init>(r12, r11)     // Catch:{ Exception -> 0x01d9 }
        L_0x0177:
            if (r14 != 0) goto L_0x019c
            if (r13 == 0) goto L_0x019c
            java.lang.String r11 = r9.f52555e     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r11 = r13.get(r11)     // Catch:{ Exception -> 0x01d9 }
            java.util.HashMap r11 = (java.util.HashMap) r11     // Catch:{ Exception -> 0x01d9 }
            if (r11 == 0) goto L_0x019c
            java.lang.String r12 = r9.f52555e     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r11 = r11.get(r12)     // Catch:{ Exception -> 0x01d9 }
            com.global.didi.elvish.language.LanguageConfigItemModel r11 = (com.global.didi.elvish.language.LanguageConfigItemModel) r11     // Catch:{ Exception -> 0x01d9 }
            if (r11 == 0) goto L_0x019c
            com.global.didi.elvish.language.LanguageModel r14 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r12 = r11.getLang()     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r11 = r11.getLocale()     // Catch:{ Exception -> 0x01d9 }
            r14.<init>(r12, r11)     // Catch:{ Exception -> 0x01d9 }
        L_0x019c:
            if (r7 == 0) goto L_0x01c6
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ Exception -> 0x01d9 }
            java.util.Iterator r11 = r7.iterator()     // Catch:{ Exception -> 0x01d9 }
        L_0x01a4:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x01d9 }
            if (r12 == 0) goto L_0x01c4
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x01d9 }
            r13 = r12
            com.global.didi.elvish.language.SupportLanguageItemModel r13 = (com.global.didi.elvish.language.SupportLanguageItemModel) r13     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r13 = r13.getLang()     // Catch:{ Exception -> 0x01d9 }
            if (r14 == 0) goto L_0x01bc
            java.lang.String r15 = r14.getLang()     // Catch:{ Exception -> 0x01d9 }
            goto L_0x01bd
        L_0x01bc:
            r15 = r6
        L_0x01bd:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r15)     // Catch:{ Exception -> 0x01d9 }
            if (r13 == 0) goto L_0x01a4
            r6 = r12
        L_0x01c4:
            com.global.didi.elvish.language.SupportLanguageItemModel r6 = (com.global.didi.elvish.language.SupportLanguageItemModel) r6     // Catch:{ Exception -> 0x01d9 }
        L_0x01c6:
            if (r6 == 0) goto L_0x01d3
            if (r14 == 0) goto L_0x01cb
            goto L_0x01d8
        L_0x01cb:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r12 = "null cannot be cast to non-null type com.global.didi.elvish.language.LanguageModel"
            r11.<init>(r12)     // Catch:{ Exception -> 0x01d9 }
            throw r11     // Catch:{ Exception -> 0x01d9 }
        L_0x01d3:
            com.global.didi.elvish.language.LanguageModel r14 = new com.global.didi.elvish.language.LanguageModel     // Catch:{ Exception -> 0x01d9 }
            r14.<init>(r1, r0)     // Catch:{ Exception -> 0x01d9 }
        L_0x01d8:
            return r14
        L_0x01d9:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = ""
            r12.append(r13)
            java.lang.String r11 = r11.getLocalizedMessage()
            r12.append(r11)
            java.lang.String r5 = r12.toString()
            r3 = 3
            r6 = 0
            r8 = 226(0xe2, float:3.17E-43)
            java.lang.String r7 = "com.global.didi.elvish.base.BaseDataLoader"
            r4 = r2
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            com.global.didi.elvish.language.LanguageModel r11 = new com.global.didi.elvish.language.LanguageModel
            r11.<init>(r1, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.base.BaseDataLoader.loadLanguageConfig(android.content.Context, java.util.Locale, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):com.global.didi.elvish.language.LanguageModel");
    }

    public final LanguageModel loadLanguageConfig(Context context, Locale locale, boolean z, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        Intrinsics.checkParameterIsNotNull(str, "config");
        return loadLanguageConfig(context, locale, z, (Function1<? super Context, ? extends Map<String, Object>>) new BaseDataLoader$loadLanguageConfig$4(str), (Function1<? super Context, ? extends Map<String, Object>>) BaseDataLoader$loadLanguageConfig$5.INSTANCE);
    }

    /* renamed from: a */
    private final Locale m37293a(String str, String str2) {
        CharSequence charSequence = str;
        if (StringsKt.indexOf$default(charSequence, "-", 0, false, 6, (Object) null) != -1) {
            int indexOf$default = StringsKt.indexOf$default(charSequence, "-", 0, false, 6, (Object) null);
            if (str != null) {
                str = str.substring(0, indexOf$default);
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        } else if (StringsKt.indexOf$default(charSequence, "_", 0, false, 6, (Object) null) != -1) {
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, "_", 0, false, 6, (Object) null);
            if (str != null) {
                str = str.substring(0, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return new Locale(str, str2);
    }

    public final LanguageModel loadLanguageConfig(Context context, String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "language");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        Locale a = m37293a(str, str2);
        BaseDataLoader baseDataLoader = this;
        return loadLanguageConfig(context, a, z, (Function1<? super Context, ? extends Map<String, Object>>) new BaseDataLoader$loadLanguageConfig$6(baseDataLoader), (Function1<? super Context, ? extends Map<String, Object>>) new BaseDataLoader$loadLanguageConfig$7(baseDataLoader));
    }

    public final LanguageModel loadLanguageConfig(Context context, String str, String str2, boolean z, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "language");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        Intrinsics.checkParameterIsNotNull(str3, "config");
        return loadLanguageConfig(context, m37293a(str, str2), z, str3);
    }
}

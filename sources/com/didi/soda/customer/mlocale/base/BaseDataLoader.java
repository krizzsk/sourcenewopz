package com.didi.soda.customer.mlocale.base;

import android.content.Context;
import com.didi.foundation.sdk.utils.FileUtils;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didi.foundation.sdk.utils.JsonUtils;
import com.didi.foundation.sdk.utils.LogUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/customer/mlocale/base/BaseDataLoader;", "", "()V", "KEY_DEFAULT", "", "getKEY_DEFAULT", "()Ljava/lang/String;", "KEY_LANGUAGECONFIG", "getKEY_LANGUAGECONFIG", "KEY_SUPPORTLIST", "getKEY_SUPPORTLIST", "KEY_SUPPORTLIST_99", "getKEY_SUPPORTLIST_99", "KEY_SUPPORTLIST_GLOBAL", "getKEY_SUPPORTLIST_GLOBAL", "tag", "getTag", "loadLanguageConfig", "Lcom/didi/soda/customer/mlocale/LanguageModel;", "context", "Landroid/content/Context;", "locale", "Ljava/util/Locale;", "isGlobal", "", "loadLocalAssetsLanguageConfData", "", "loadRemoteLanguageConfData", "localCustomRuleConfData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseDataLoader.kt */
public final class BaseDataLoader {

    /* renamed from: a */
    private final String f41391a = "supportList";

    /* renamed from: b */
    private final String f41392b = "languageConfig";

    /* renamed from: c */
    private final String f41393c = "99";

    /* renamed from: d */
    private final String f41394d = "global";

    /* renamed from: e */
    private final String f41395e = "default";

    /* renamed from: f */
    private final String f41396f = "loadLanguageConfig";

    public final String getKEY_SUPPORTLIST() {
        return this.f41391a;
    }

    public final String getKEY_LANGUAGECONFIG() {
        return this.f41392b;
    }

    public final String getKEY_SUPPORTLIST_99() {
        return this.f41393c;
    }

    public final String getKEY_SUPPORTLIST_GLOBAL() {
        return this.f41394d;
    }

    public final String getKEY_DEFAULT() {
        return this.f41395e;
    }

    public final String getTag() {
        return this.f41396f;
    }

    public final Map<String, Object> localCustomRuleConfData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogUtils.INSTANCE.print("result 开始从网络获取");
        Map<String, Object> a = m29316a(context);
        if (a == null || a.isEmpty()) {
            LogUtils.INSTANCE.print("取本地");
            a = m29317b(context);
        }
        LogUtils.INSTANCE.print(Intrinsics.stringPlus("result 为", a));
        return a;
    }

    /* renamed from: a */
    private final Map<String, Object> m29316a(Context context) {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_founding_configuration");
        try {
            JsonUtils jsonUtils = JsonUtils.INSTANCE;
            return (Map) new Gson().fromJson(localeLangkMessages, Map.class);
        } catch (Exception unused) {
            return new LinkedHashMap<>();
        }
    }

    /* renamed from: b */
    private final Map<String, Object> m29317b(Context context) {
        String formAssets = FileUtils.INSTANCE.getFormAssets(context, "local_rlab_language_config.json");
        if (formAssets == null) {
            formAssets = "";
        }
        if (!(formAssets.length() > 0)) {
            return new LinkedHashMap<>();
        }
        JsonUtils jsonUtils = JsonUtils.INSTANCE;
        return (Map) new Gson().fromJson(formAssets, Map.class);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.global.didi.elvish.language.SupportLanguageItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01cc A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f6 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0201 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ef A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0177 A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x019f A[Catch:{ Exception -> 0x0207 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A[Catch:{ Exception -> 0x0207 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.customer.mlocale.LanguageModel loadLanguageConfig(android.content.Context r10, java.util.Locale r11, boolean r12) {
        /*
            r9 = this;
            java.lang.String r0 = "en_US"
            java.lang.String r1 = "en-US"
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "locale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            com.didi.soda.customer.mlocale.base.BaseDataLoader r2 = new com.didi.soda.customer.mlocale.base.BaseDataLoader     // Catch:{ Exception -> 0x0207 }
            r2.<init>()     // Catch:{ Exception -> 0x0207 }
            java.util.Map r3 = r2.m29316a(r10)     // Catch:{ Exception -> 0x0207 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0024
            boolean r6 = r3.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r6 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r6 = 0
            goto L_0x0025
        L_0x0024:
            r6 = 1
        L_0x0025:
            if (r6 == 0) goto L_0x002d
            com.didi.soda.customer.mlocale.CustomerElvish$Companion r3 = com.didi.soda.customer.mlocale.CustomerElvish.Companion     // Catch:{ Exception -> 0x0207 }
            java.util.Map r3 = r3.getLocalCustomRuleConf()     // Catch:{ Exception -> 0x0207 }
        L_0x002d:
            java.lang.String r6 = r2.getKEY_SUPPORTLIST()     // Catch:{ Exception -> 0x0207 }
            boolean r6 = r3.containsKey(r6)     // Catch:{ Exception -> 0x0207 }
            if (r6 == 0) goto L_0x0041
            java.lang.String r6 = r2.getKEY_LANGUAGECONFIG()     // Catch:{ Exception -> 0x0207 }
            boolean r6 = r3.containsKey(r6)     // Catch:{ Exception -> 0x0207 }
            if (r6 != 0) goto L_0x004d
        L_0x0041:
            java.util.Map r3 = r2.m29317b(r10)     // Catch:{ Exception -> 0x0207 }
            com.didi.foundation.sdk.utils.LogUtils r10 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0207 }
            java.lang.String r6 = "远程没数据，重新加载本地数据"
            r10.print(r6)     // Catch:{ Exception -> 0x0207 }
        L_0x004d:
            java.lang.String r10 = r11.getLanguage()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = r11.getCountry()     // Catch:{ Exception -> 0x0207 }
            r6 = r10
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0207 }
            if (r6 == 0) goto L_0x0063
            int r6 = r6.length()     // Catch:{ Exception -> 0x0207 }
            if (r6 != 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r6 = 0
            goto L_0x0064
        L_0x0063:
            r6 = 1
        L_0x0064:
            if (r6 == 0) goto L_0x0074
            com.didi.foundation.sdk.utils.LogUtils r10 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = "systemLanguage.isNullOrEmpty()"
            r10.print(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageModel r10 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            r10.<init>(r1, r0)     // Catch:{ Exception -> 0x0207 }
            return r10
        L_0x0074:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0207 }
            r6.<init>()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r7 = r2.getKEY_SUPPORTLIST()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ Exception -> 0x0207 }
            boolean r7 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x0207 }
            if (r7 == 0) goto L_0x0090
            java.lang.String r7 = r2.getKEY_SUPPORTLIST()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0207 }
            goto L_0x009c
        L_0x0090:
            java.lang.String r7 = r2.getKEY_SUPPORTLIST()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r7 = r6.toJson((java.lang.Object) r7)     // Catch:{ Exception -> 0x0207 }
        L_0x009c:
            java.lang.String r8 = r2.getKEY_SUPPORTLIST()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r8 = r3.get(r8)     // Catch:{ Exception -> 0x0207 }
            boolean r8 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0207 }
            if (r8 == 0) goto L_0x00b3
            java.lang.String r8 = r2.getKEY_LANGUAGECONFIG()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0207 }
            goto L_0x00bf
        L_0x00b3:
            java.lang.String r8 = r2.getKEY_LANGUAGECONFIG()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ Exception -> 0x0207 }
            java.lang.String r3 = r6.toJson((java.lang.Object) r3)     // Catch:{ Exception -> 0x0207 }
        L_0x00bf:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0207 }
            if (r8 == 0) goto L_0x00cd
            int r8 = r8.length()     // Catch:{ Exception -> 0x0207 }
            if (r8 != 0) goto L_0x00cb
            goto L_0x00cd
        L_0x00cb:
            r8 = 0
            goto L_0x00ce
        L_0x00cd:
            r8 = 1
        L_0x00ce:
            if (r8 == 0) goto L_0x00de
            com.didi.foundation.sdk.utils.LogUtils r10 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = "supportListStr.isNullOrEmpty()"
            r10.print(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageModel r10 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            r10.<init>(r1, r0)     // Catch:{ Exception -> 0x0207 }
            return r10
        L_0x00de:
            r8 = r3
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0207 }
            if (r8 == 0) goto L_0x00ec
            int r8 = r8.length()     // Catch:{ Exception -> 0x0207 }
            if (r8 != 0) goto L_0x00ea
            goto L_0x00ec
        L_0x00ea:
            r8 = 0
            goto L_0x00ed
        L_0x00ec:
            r8 = 1
        L_0x00ed:
            if (r8 == 0) goto L_0x00fc
            com.didi.foundation.sdk.utils.LogUtils r10 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = "languageConfigStr.isNullOrEmpty()"
            r10.print(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageModel r10 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            r10.<init>(r1, r0)     // Catch:{ Exception -> 0x0207 }
            return r10
        L_0x00fc:
            com.didi.soda.customer.mlocale.base.BaseDataLoader$loadLanguageConfig$1$1 r8 = new com.didi.soda.customer.mlocale.base.BaseDataLoader$loadLanguageConfig$1$1     // Catch:{ Exception -> 0x0207 }
            r8.<init>()     // Catch:{ Exception -> 0x0207 }
            java.lang.reflect.Type r8 = r8.getType()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r7 = r6.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r8)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ Exception -> 0x0207 }
            r8 = 0
            if (r7 != 0) goto L_0x0110
            r12 = r8
            goto L_0x0127
        L_0x0110:
            if (r12 == 0) goto L_0x011d
            java.lang.String r12 = r2.getKEY_SUPPORTLIST_GLOBAL()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ Exception -> 0x0207 }
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ Exception -> 0x0207 }
            goto L_0x0127
        L_0x011d:
            java.lang.String r12 = r2.getKEY_SUPPORTLIST_99()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ Exception -> 0x0207 }
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ Exception -> 0x0207 }
        L_0x0127:
            r7 = r12
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ Exception -> 0x0207 }
            if (r7 == 0) goto L_0x0132
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x0207 }
            if (r7 == 0) goto L_0x0133
        L_0x0132:
            r4 = 1
        L_0x0133:
            if (r4 == 0) goto L_0x0143
            com.didi.foundation.sdk.utils.LogUtils r10 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = "supportList.isNullOrEmpty()"
            r10.print(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageModel r10 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            r10.<init>(r1, r0)     // Catch:{ Exception -> 0x0207 }
            return r10
        L_0x0143:
            com.didi.soda.customer.mlocale.base.BaseDataLoader$loadLanguageConfig$1$3 r4 = new com.didi.soda.customer.mlocale.base.BaseDataLoader$loadLanguageConfig$1$3     // Catch:{ Exception -> 0x0207 }
            r4.<init>()     // Catch:{ Exception -> 0x0207 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r3 = r6.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ Exception -> 0x0207 }
            if (r3 != 0) goto L_0x0155
            goto L_0x0166
        L_0x0155:
            java.lang.Object r4 = r3.get(r10)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ Exception -> 0x0207 }
            if (r4 != 0) goto L_0x015e
            goto L_0x0166
        L_0x015e:
            java.lang.Object r11 = r4.get(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageConfigItemModel r11 = (com.didi.soda.customer.mlocale.LanguageConfigItemModel) r11     // Catch:{ Exception -> 0x0207 }
            if (r11 != 0) goto L_0x0168
        L_0x0166:
            r4 = r8
            goto L_0x0175
        L_0x0168:
            com.didi.soda.customer.mlocale.LanguageModel r4 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            java.lang.String r5 = r11.getLang()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = r11.getLocale()     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r5, r11)     // Catch:{ Exception -> 0x0207 }
        L_0x0175:
            if (r4 != 0) goto L_0x019d
            if (r3 != 0) goto L_0x017a
            goto L_0x019d
        L_0x017a:
            java.lang.Object r10 = r3.get(r10)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r10 = (java.util.HashMap) r10     // Catch:{ Exception -> 0x0207 }
            if (r10 != 0) goto L_0x0183
            goto L_0x019d
        L_0x0183:
            java.lang.String r11 = r2.getKEY_DEFAULT()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageConfigItemModel r10 = (com.didi.soda.customer.mlocale.LanguageConfigItemModel) r10     // Catch:{ Exception -> 0x0207 }
            if (r10 != 0) goto L_0x0190
            goto L_0x019d
        L_0x0190:
            com.didi.soda.customer.mlocale.LanguageModel r4 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = r10.getLang()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r10 = r10.getLocale()     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r11, r10)     // Catch:{ Exception -> 0x0207 }
        L_0x019d:
            if (r4 != 0) goto L_0x01c9
            if (r3 != 0) goto L_0x01a2
            goto L_0x01c9
        L_0x01a2:
            java.lang.String r10 = r2.getKEY_DEFAULT()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r10 = r3.get(r10)     // Catch:{ Exception -> 0x0207 }
            java.util.HashMap r10 = (java.util.HashMap) r10     // Catch:{ Exception -> 0x0207 }
            if (r10 != 0) goto L_0x01af
            goto L_0x01c9
        L_0x01af:
            java.lang.String r11 = r2.getKEY_DEFAULT()     // Catch:{ Exception -> 0x0207 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0207 }
            com.didi.soda.customer.mlocale.LanguageConfigItemModel r10 = (com.didi.soda.customer.mlocale.LanguageConfigItemModel) r10     // Catch:{ Exception -> 0x0207 }
            if (r10 != 0) goto L_0x01bc
            goto L_0x01c9
        L_0x01bc:
            com.didi.soda.customer.mlocale.LanguageModel r4 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = r10.getLang()     // Catch:{ Exception -> 0x0207 }
            java.lang.String r10 = r10.getLocale()     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r11, r10)     // Catch:{ Exception -> 0x0207 }
        L_0x01c9:
            if (r12 != 0) goto L_0x01cc
            goto L_0x01f4
        L_0x01cc:
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ Exception -> 0x0207 }
            java.util.Iterator r10 = r12.iterator()     // Catch:{ Exception -> 0x0207 }
        L_0x01d2:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x0207 }
            if (r11 == 0) goto L_0x01f2
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x0207 }
            r12 = r11
            com.global.didi.elvish.language.SupportLanguageItemModel r12 = (com.global.didi.elvish.language.SupportLanguageItemModel) r12     // Catch:{ Exception -> 0x0207 }
            java.lang.String r12 = r12.getLang()     // Catch:{ Exception -> 0x0207 }
            if (r4 != 0) goto L_0x01e7
            r2 = r8
            goto L_0x01eb
        L_0x01e7:
            java.lang.String r2 = r4.getLang()     // Catch:{ Exception -> 0x0207 }
        L_0x01eb:
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0207 }
            if (r12 == 0) goto L_0x01d2
            r8 = r11
        L_0x01f2:
            com.global.didi.elvish.language.SupportLanguageItemModel r8 = (com.global.didi.elvish.language.SupportLanguageItemModel) r8     // Catch:{ Exception -> 0x0207 }
        L_0x01f4:
            if (r8 == 0) goto L_0x0201
            if (r4 == 0) goto L_0x01f9
            goto L_0x0206
        L_0x01f9:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0207 }
            java.lang.String r11 = "null cannot be cast to non-null type com.didi.soda.customer.mlocale.LanguageModel"
            r10.<init>(r11)     // Catch:{ Exception -> 0x0207 }
            throw r10     // Catch:{ Exception -> 0x0207 }
        L_0x0201:
            com.didi.soda.customer.mlocale.LanguageModel r4 = new com.didi.soda.customer.mlocale.LanguageModel     // Catch:{ Exception -> 0x0207 }
            r4.<init>(r1, r0)     // Catch:{ Exception -> 0x0207 }
        L_0x0206:
            return r4
        L_0x0207:
            r10 = move-exception
            com.didi.foundation.sdk.utils.LogUtils r11 = com.didi.foundation.sdk.utils.LogUtils.INSTANCE
            java.lang.String r10 = r10.getLocalizedMessage()
            java.lang.String r12 = ""
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r10)
            r11.print(r10)
            com.didi.soda.customer.mlocale.LanguageModel r10 = new com.didi.soda.customer.mlocale.LanguageModel
            r10.<init>(r1, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.mlocale.base.BaseDataLoader.loadLanguageConfig(android.content.Context, java.util.Locale, boolean):com.didi.soda.customer.mlocale.LanguageModel");
    }
}

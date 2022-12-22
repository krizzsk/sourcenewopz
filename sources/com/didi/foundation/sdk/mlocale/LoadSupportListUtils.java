package com.didi.foundation.sdk.mlocale;

import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.apm.SystemUtils;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/foundation/sdk/mlocale/LoadSupportListUtils;", "", "()V", "Companion", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LoadSupportListUtils.kt */
public final class LoadSupportListUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f21265a = f21265a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f21266b = f21266b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f21267c = "99";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f21268d = "global";

    @JvmStatic
    public static final ArrayList<SupportLanguageItemModel> getSupportList(Map<String, Object> map, Map<String, Object> map2) {
        return Companion.getSupportList(map, map2);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/foundation/sdk/mlocale/LoadSupportListUtils$Companion;", "", "()V", "KEY_SUPPORTLIST", "", "KEY_SUPPORTLIST_99", "KEY_SUPPORTLIST_GLOBAL", "tag", "getTag", "()Ljava/lang/String;", "getSupportList", "Ljava/util/ArrayList;", "Lcom/global/didi/elvish/language/SupportLanguageItemModel;", "loadRemoteLanguageConfData", "", "loadLocalAssetsLanguageConfData", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: LoadSupportListUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTag() {
            return LoadSupportListUtils.f21266b;
        }

        @JvmStatic
        public final ArrayList<SupportLanguageItemModel> getSupportList(Map<String, Object> map, Map<String, Object> map2) {
            ArrayList<SupportLanguageItemModel> arrayList;
            Intrinsics.checkParameterIsNotNull(map, "loadRemoteLanguageConfData");
            Intrinsics.checkParameterIsNotNull(map2, "loadLocalAssetsLanguageConfData");
            if (!map.containsKey(LoadSupportListUtils.f21265a)) {
                SystemUtils.log(3, getTag(), "远程没数据，重新加载本地数据", (Throwable) null, "com.didi.foundation.sdk.mlocale.LoadSupportListUtils$Companion", 34);
                map = map2;
            }
            Gson gson = new Gson();
            String json = gson.toJson(map.get(LoadSupportListUtils.f21265a));
            CharSequence charSequence = json;
            boolean z = false;
            if (charSequence == null || charSequence.length() == 0) {
                SystemUtils.log(3, getTag(), "supportListStr.isNullOrEmpty()", (Throwable) null, "com.didi.foundation.sdk.mlocale.LoadSupportListUtils$Companion", 40);
                return new ArrayList<>();
            }
            HashMap hashMap = null;
            ArrayList<SupportLanguageItemModel> arrayList2 = null;
            HashMap hashMap2 = (HashMap) gson.fromJson(json, new LoadSupportListUtils$Companion$getSupportList$1().getType());
            if (hashMap2 != null) {
                if (LocaleUtils.isGlobal) {
                    arrayList = (ArrayList) hashMap2.get(LoadSupportListUtils.f21268d);
                } else {
                    arrayList = (ArrayList) hashMap2.get(LoadSupportListUtils.f21267c);
                }
                arrayList2 = arrayList;
            }
            Collection collection = arrayList2;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (z) {
                SystemUtils.log(3, getTag(), "supportList isNullOrEmpty", (Throwable) null, "com.didi.foundation.sdk.mlocale.LoadSupportListUtils$Companion", 59);
            }
            return arrayList2 != null ? arrayList2 : new ArrayList<>();
        }
    }
}

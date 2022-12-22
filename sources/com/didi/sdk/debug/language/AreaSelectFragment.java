package com.didi.sdk.debug.language;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/AreaSelectFragment;", "Lcom/didi/sdk/debug/language/BaseLanguageFragment;", "()V", "getData", "Ljava/util/ArrayList;", "Lcom/didi/sdk/debug/language/LanguageModel;", "Lkotlin/collections/ArrayList;", "getTitle", "", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AreaSelectFragment.kt */
public final class AreaSelectFragment extends BaseLanguageFragment {
    public void _$_clearFindViewByIdCache() {
    }

    public String getTitle() {
        return "地区";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.didi.sdk.debug.language.LanguageModel> getData() {
        /*
            r8 = this;
            java.lang.String r0 = "ibt_language_setting"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            goto L_0x001c
        L_0x000a:
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            if (r0 != 0) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            java.lang.String r1 = "config"
            java.lang.String r2 = ""
            java.lang.Object r0 = r0.getParam(r1, r2)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x001c:
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r0 == 0) goto L_0x0028
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L_0x0028:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r1)
            java.lang.String r1 = "area"
            org.json.JSONArray r0 = r0.getJSONArray(r1)
            int r1 = r0.length()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            if (r1 <= 0) goto L_0x0066
        L_0x003f:
            int r4 = r3 + 1
            com.didi.sdk.debug.language.LanguageModel r5 = new com.didi.sdk.debug.language.LanguageModel
            r5.<init>()
            java.lang.String r6 = r0.getString(r3)
            java.lang.String r7 = "area.getString(i)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r5.setTitle(r6)
            com.didi.sdk.debug.language.AreaSelectFragment$getData$1$1 r6 = new com.didi.sdk.debug.language.AreaSelectFragment$getData$1$1
            r6.<init>(r0, r3)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5.setTitleAction(r6)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r2.add(r5)
            if (r4 < r1) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r3 = r4
            goto L_0x003f
        L_0x0066:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.debug.language.AreaSelectFragment.getData():java.util.ArrayList");
    }
}

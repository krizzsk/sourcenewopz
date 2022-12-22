package com.didiglobal.enginecore.cache;

import android.content.Context;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didiglobal.enginecore.XERequest;
import com.didiglobal.enginecore.XEResponse;
import com.didiglobal.enginecore.XEResponseBody;
import com.didiglobal.enginecore.cache.XECacheModel;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J.\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J&\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u000fH\u0002J \u0010&\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u001bH\u0002J \u0010(\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u001bH\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010*\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002J*\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020\u001bJ*\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u001bJ*\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020\u001bJ-\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001002\b\u0010 \u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00101R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheMgr;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "xECache", "Lcom/didiglobal/enginecore/cache/XEngineCache;", "buildComponentCacheData", "", "sceneId", "", "array", "Lcom/google/gson/JsonArray;", "cacheMap", "Ljava/util/HashMap;", "Lcom/google/gson/JsonObject;", "Lkotlin/collections/HashMap;", "buildComponentJsonData", "buildSceneCacheData", "buildSceneJsonData", "dataJson", "cachePageRequest", "cacheCallBack", "Lcom/didiglobal/enginecore/cache/XECacheCallBack;", "cacheSimpleRequest", "componentId", "checkCacheValid", "", "jsonObject", "get", "key", "getCacheData", "data", "getCacheObject", "Lcom/didiglobal/enginecore/cache/XECacheModel;", "getCacheStorageMode", "", "getCacheStrategy", "parseJsonChild", "isDefault", "parseJsonRoot", "parseString2Object", "put", "putDefault", "isPageScene", "putNormal", "putNormal4Simple", "componentIdArray", "", "(Ljava/lang/String;[Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XECacheMgr.kt */
public final class XECacheMgr {

    /* renamed from: a */
    private XEngineCache f50117a;

    public XECacheMgr(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        StringBuilder sb = new StringBuilder();
        File cacheDir = context.getCacheDir();
        Intrinsics.checkExpressionValueIsNotNull(cacheDir, "context.cacheDir");
        File parentFile = cacheDir.getParentFile();
        Intrinsics.checkExpressionValueIsNotNull(parentFile, "context.cacheDir.parentFile");
        sb.append(parentFile.getAbsolutePath());
        sb.append(XECacheConfig.XE_CACHE_DEF_DIR_PATH);
        this.f50117a = new XEngineCache(new File(sb.toString()), XECacheConfig.XE_CACHE_DEF_MAX_SIZE);
    }

    /* renamed from: a */
    private final int m36113a(JsonObject jsonObject) {
        if (!jsonObject.has("extension")) {
            return 2;
        }
        JsonElement jsonElement = jsonObject.get("extension");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "jsonObject.get(\"extension\")");
        if (!jsonElement.isJsonObject()) {
            return 2;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("cache")) {
            return 2;
        }
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("cache");
        if (!asJsonObject2.has("storage_mode")) {
            return 2;
        }
        JsonElement jsonElement2 = asJsonObject2.get("storage_mode");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "cacheData.get(\"storage_mode\")");
        return jsonElement2.getAsInt();
    }

    /* renamed from: b */
    private final int m36120b(JsonObject jsonObject) {
        if (!jsonObject.has("extension")) {
            return 0;
        }
        JsonElement jsonElement = jsonObject.get("extension");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement, "data.get(\"extension\")");
        if (!jsonElement.isJsonObject()) {
            return 0;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("cache")) {
            return 0;
        }
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("cache");
        if (!asJsonObject2.has("cache_strategy")) {
            return 0;
        }
        JsonElement jsonElement2 = asJsonObject2.get("cache_strategy");
        Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "cacheData.get(\"cache_strategy\")");
        return jsonElement2.getAsInt();
    }

    /* renamed from: c */
    private final JsonObject m36124c(JsonObject jsonObject) {
        if (jsonObject != null && jsonObject.has("extension")) {
            JsonElement jsonElement = jsonObject.get("extension");
            Intrinsics.checkExpressionValueIsNotNull(jsonElement, "data.get(\"extension\")");
            if (jsonElement.isJsonObject()) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                if (asJsonObject.has("cache")) {
                    return asJsonObject.getAsJsonObject("cache");
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    private final XECacheModel m36125d(JsonObject jsonObject) {
        JsonObject c;
        if (jsonObject == null || (c = m36124c(jsonObject)) == null) {
            return null;
        }
        return (XECacheModel) new Gson().fromJson((JsonElement) c, XECacheModel.class);
    }

    public final void putNormal(String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        CharSequence charSequence = str3;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (!(str.length() == 0)) {
                JsonObject jsonObject = null;
                try {
                    JsonElement parse = new JsonParser().parse(str3);
                    Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(data)");
                    jsonObject = parse.getAsJsonObject();
                } catch (Exception unused) {
                }
                if (jsonObject != null) {
                    if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
                        CharSequence charSequence2 = str2;
                        if (!(charSequence2 == null || charSequence2.length() == 0)) {
                            String str4 = str + IOUtils.DIR_SEPARATOR_UNIX + str2 + XECacheConfig.XE_CACHE_NORMAL_FILE;
                            if (m36113a(jsonObject) == 1) {
                                m36122b(str4, str3);
                            }
                            m36123b(str, jsonObject, false);
                            return;
                        }
                    }
                    if (z) {
                        String str5 = str + XECacheConfig.XE_CACHE_NORMAL_FILE;
                        if (m36119a(str, jsonObject, false)) {
                            m36122b(str5, str3);
                        }
                    }
                }
            }
        }
    }

    public final void putNormal(String str, String str2, JsonObject jsonObject, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        if (jsonObject != null) {
            if (!(str.length() == 0)) {
                if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
                    CharSequence charSequence = str2;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        String str3 = str + IOUtils.DIR_SEPARATOR_UNIX + str2 + XECacheConfig.XE_CACHE_NORMAL_FILE;
                        if (m36113a(jsonObject) == 1) {
                            String jsonObject2 = jsonObject.toString();
                            Intrinsics.checkExpressionValueIsNotNull(jsonObject2, "data.toString()");
                            m36122b(str3, jsonObject2);
                        }
                        m36123b(str, jsonObject, false);
                        return;
                    }
                }
                if (z) {
                    String str4 = str + XECacheConfig.XE_CACHE_NORMAL_FILE;
                    if (m36119a(str, jsonObject, false)) {
                        String jsonObject3 = jsonObject.toString();
                        Intrinsics.checkExpressionValueIsNotNull(jsonObject3, "data.toString()");
                        m36122b(str4, jsonObject3);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void putNormal4Simple(java.lang.String r8, java.lang.String[] r9, com.google.gson.JsonObject r10) {
        /*
            r7 = this;
            java.lang.String r0 = "sceneId"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            if (r10 == 0) goto L_0x0071
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x0071
            if (r9 == 0) goto L_0x0024
            int r0 = r9.length
            if (r0 != 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            if (r0 == 0) goto L_0x0028
            goto L_0x0071
        L_0x0028:
            int r0 = r9.length
            r3 = 0
        L_0x002a:
            if (r3 >= r0) goto L_0x0071
            r4 = r9[r3]
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x003c
            int r5 = r5.length()
            if (r5 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r5 = 0
            goto L_0x003d
        L_0x003c:
            r5 = 1
        L_0x003d:
            if (r5 == 0) goto L_0x0040
            goto L_0x006e
        L_0x0040:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r8)
            r6 = 47
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = "/normal"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            int r5 = r7.m36113a((com.google.gson.JsonObject) r10)
            if (r5 != r1) goto L_0x006b
            java.lang.String r5 = r10.toString()
            java.lang.String r6 = "data.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            r7.m36122b(r4, r5)
        L_0x006b:
            r7.m36123b(r8, r10, r2)
        L_0x006e:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XECacheMgr.putNormal4Simple(java.lang.String, java.lang.String[], com.google.gson.JsonObject):void");
    }

    public final void putDefault(String str, String str2, String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        CharSequence charSequence = str3;
        boolean z2 = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (!(str.length() == 0)) {
                JsonObject jsonObject = null;
                try {
                    JsonElement parse = new JsonParser().parse(str3);
                    Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(data)");
                    jsonObject = parse.getAsJsonObject();
                } catch (Exception unused) {
                }
                if (jsonObject != null) {
                    if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
                        CharSequence charSequence2 = str2;
                        if (charSequence2 == null || charSequence2.length() == 0) {
                            z2 = true;
                        }
                        if (!z2) {
                            String str4 = str + IOUtils.DIR_SEPARATOR_UNIX + str2 + XECacheConfig.XE_CACHE_DEFAULT_FILE;
                            if (m36113a(jsonObject) == 1) {
                                m36122b(str4, str3);
                            }
                            m36123b(str, jsonObject, true);
                            return;
                        }
                    }
                    if (z) {
                        String str5 = str + XECacheConfig.XE_CACHE_DEFAULT_FILE;
                        if (m36119a(str, jsonObject, true)) {
                            m36122b(str5, str3);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m36117a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0013
            return r3
        L_0x0013:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            r4 = 47
            java.lang.String r5 = "/normal"
            if (r0 != 0) goto L_0x0045
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x002b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r0 = 0
            goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            if (r0 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r4)
            r0.append(r8)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            goto L_0x0054
        L_0x0045:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
        L_0x0054:
            java.lang.String r0 = r6.m36116a((java.lang.String) r0)
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 == 0) goto L_0x00a9
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            java.lang.String r5 = "/default"
            if (r0 != 0) goto L_0x0096
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x007c
            int r0 = r0.length()
            if (r0 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r0 = 0
            goto L_0x007d
        L_0x007c:
            r0 = 1
        L_0x007d:
            if (r0 == 0) goto L_0x0080
            goto L_0x0096
        L_0x0080:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r4)
            r0.append(r8)
            r0.append(r5)
            java.lang.String r7 = r0.toString()
            goto L_0x00a5
        L_0x0096:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r5)
            java.lang.String r7 = r8.toString()
        L_0x00a5:
            java.lang.String r0 = r6.m36116a((java.lang.String) r7)
        L_0x00a9:
            r7 = r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            if (r1 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r3 = r0
        L_0x00b8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XECacheMgr.m36117a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private final String m36116a(String str) {
        XEResponseBody body;
        String str2;
        XEResponse xEResponse = this.f50117a.get(new XERequest.Builder().key(str).build());
        if (xEResponse == null || (body = xEResponse.body()) == null) {
            return "";
        }
        try {
            str2 = body.source().readUtf8();
        } catch (IOException e) {
            e.printStackTrace();
            str2 = "";
        }
        if (str2.length() == 0) {
            return "";
        }
        return str2;
    }

    /* renamed from: b */
    private final void m36122b(String str, String str2) {
        XEResponse build = new XEResponse.Builder().request(new XERequest.Builder().key(str).build()).body(XEResponseBody.Companion.create(str2)).build();
        try {
            XEResponseBody body = this.f50117a.cacheWritingResponse(this.f50117a.put(build), build).body();
            if (body == null) {
                Intrinsics.throwNpe();
            }
            body.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void cacheSimpleRequest(String str, String str2, XECacheCallBack<JsonObject> xECacheCallBack) {
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        Intrinsics.checkParameterIsNotNull(xECacheCallBack, "cacheCallBack");
        String a = m36117a(str, str2);
        if (a.length() == 0) {
            xECacheCallBack.onCacheFailure();
            return;
        }
        try {
            JsonElement parse = new JsonParser().parse(a);
            Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(jsonResult)");
            JsonObject asJsonObject = parse.getAsJsonObject();
            Intrinsics.checkExpressionValueIsNotNull(asJsonObject, "JsonParser().parse(jsonResult).asJsonObject");
            xECacheCallBack.onCacheSuccess(asJsonObject);
        } catch (Exception unused) {
            xECacheCallBack.onCacheFailure();
        }
    }

    public final void cachePageRequest(String str, XECacheCallBack<JsonObject> xECacheCallBack) {
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        Intrinsics.checkParameterIsNotNull(xECacheCallBack, "cacheCallBack");
        String a = m36117a(str, (String) null);
        if (a.length() == 0) {
            xECacheCallBack.onCacheFailure();
            return;
        }
        try {
            JsonElement parse = new JsonParser().parse(a);
            Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(jsonResult)");
            JsonObject asJsonObject = parse.getAsJsonObject();
            Intrinsics.checkExpressionValueIsNotNull(asJsonObject, "JsonParser().parse(jsonResult).asJsonObject");
            JsonObject a2 = m36115a(str, asJsonObject);
            if (a2 != null) {
                xECacheCallBack.onCacheSuccess(a2);
            } else {
                xECacheCallBack.onCacheFailure();
            }
        } catch (Exception unused) {
            xECacheCallBack.onCacheFailure();
        }
    }

    /* renamed from: a */
    private final JsonArray m36114a(String str, JsonArray jsonArray) {
        JsonArray jsonArray2 = new JsonArray();
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement = jsonArray.get(i);
            Intrinsics.checkExpressionValueIsNotNull(jsonElement, "array[i]");
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonObject b = m36121b(m36117a(str, XEParserUtil.getAsString("id", asJsonObject, "")));
            if (b != null) {
                if (m36126e(b)) {
                    jsonArray2.add((JsonElement) b);
                }
                if (asJsonObject.has("list")) {
                    JsonElement jsonElement2 = asJsonObject.get("list");
                    Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "jsonValue.get(XEParseConst.XE_JSON_KEY_LIST)");
                    if (!jsonElement2.isJsonArray()) {
                        asJsonObject.remove("list");
                    } else {
                        JsonArray asJsonArray = jsonElement2.getAsJsonArray();
                        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "array.asJsonArray");
                        JsonArray a = m36114a(str, asJsonArray);
                        if (a != null) {
                            asJsonObject.remove("list");
                            asJsonObject.add("list", a);
                        } else {
                            asJsonObject.remove("list");
                        }
                    }
                }
            }
        }
        if (jsonArray2.size() > 0) {
            return jsonArray2;
        }
        return null;
    }

    /* renamed from: a */
    private final JsonObject m36115a(String str, JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        int size = entrySet.size();
        HashSet hashSet = new HashSet();
        for (Map.Entry next : entrySet) {
            String str2 = (String) next.getKey();
            JsonElement jsonElement = (JsonElement) next.getValue();
            if (!(str2.length() == 0) && jsonElement.isJsonObject()) {
                if (jsonElement != null) {
                    JsonObject jsonObject2 = (JsonObject) jsonElement;
                    if (jsonObject2.has("list")) {
                        JsonElement jsonElement2 = jsonObject2.get("list");
                        if (jsonElement2 == null || !jsonElement2.isJsonArray()) {
                            hashSet.add(str2);
                        } else {
                            JsonArray asJsonArray = jsonElement2.getAsJsonArray();
                            Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "array.asJsonArray");
                            JsonArray a = m36114a(str, asJsonArray);
                            if (a != null) {
                                jsonObject2.remove("list");
                                jsonObject2.add("list", a);
                            } else {
                                hashSet.add(str2);
                            }
                        }
                    } else {
                        JsonObject b = m36121b(m36117a(str, str2));
                        if (b == null) {
                            hashSet.add(str2);
                        } else if (!m36126e(b)) {
                            hashSet.add(str2);
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                }
            }
        }
        Iterator it = hashSet.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "needRemove.iterator()");
        while (it.hasNext()) {
            jsonObject.remove((String) it.next());
        }
        if (size > hashSet.size()) {
            return jsonObject;
        }
        return null;
    }

    /* renamed from: a */
    private final void m36118a(String str, JsonArray jsonArray, HashMap<String, JsonObject> hashMap) {
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement = jsonArray.get(i);
            Intrinsics.checkExpressionValueIsNotNull(jsonElement, "array[i]");
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String asString = XEParserUtil.getAsString("id", asJsonObject, "");
            JsonObject b = m36121b(m36117a(str, asString));
            if (b != null) {
                JsonObject c = m36124c(b);
                if (c != null) {
                    JsonObject put = hashMap.put(asString, c);
                }
                if (asJsonObject.has("list")) {
                    JsonElement jsonElement2 = asJsonObject.get("list");
                    Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "jsonValue.get(XEParseConst.XE_JSON_KEY_LIST)");
                    if (jsonElement2.isJsonArray()) {
                        JsonArray asJsonArray = jsonElement2.getAsJsonArray();
                        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "array.asJsonArray");
                        m36118a(str, asJsonArray, hashMap);
                    }
                }
            }
        }
    }

    public final HashMap<String, JsonObject> buildSceneCacheData(String str) {
        JsonObject c;
        Intrinsics.checkParameterIsNotNull(str, BlocksConst.ACTION_PARAMS_SCENE_ID);
        HashMap<String, JsonObject> hashMap = new HashMap<>();
        String a = m36117a(str, (String) null);
        if (a.length() == 0) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(a);
            Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(jsonResult)");
            JsonObject asJsonObject = parse.getAsJsonObject();
            Intrinsics.checkExpressionValueIsNotNull(asJsonObject, "JsonParser().parse(jsonResult).asJsonObject");
            for (Map.Entry next : asJsonObject.entrySet()) {
                String str2 = (String) next.getKey();
                JsonElement jsonElement = (JsonElement) next.getValue();
                if (!(str2.length() == 0)) {
                    if (jsonElement.isJsonObject()) {
                        if (jsonElement != null) {
                            JsonObject jsonObject = (JsonObject) jsonElement;
                            if (jsonObject.has("list")) {
                                JsonElement jsonElement2 = jsonObject.get("list");
                                if (jsonElement2 != null) {
                                    if (jsonElement2.isJsonArray()) {
                                        JsonArray asJsonArray = jsonElement2.getAsJsonArray();
                                        Intrinsics.checkExpressionValueIsNotNull(asJsonArray, "array.asJsonArray");
                                        m36118a(str, asJsonArray, hashMap);
                                    }
                                }
                            } else {
                                JsonObject b = m36121b(m36117a(str, str2));
                                if (!(b == null || (c = m36124c(b)) == null)) {
                                    c.add(str2, c);
                                }
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                        }
                    }
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private final boolean m36119a(String str, JsonObject jsonObject, boolean z) {
        String str2;
        boolean z2 = false;
        for (Map.Entry next : jsonObject.entrySet()) {
            String str3 = (String) next.getKey();
            JsonElement jsonElement = (JsonElement) next.getValue();
            if (!(str3.length() == 0)) {
                if (z) {
                    str2 = str + IOUtils.DIR_SEPARATOR_UNIX + str3 + XECacheConfig.XE_CACHE_DEFAULT_FILE;
                } else {
                    str2 = str + IOUtils.DIR_SEPARATOR_UNIX + str3 + XECacheConfig.XE_CACHE_NORMAL_FILE;
                }
                if (!jsonElement.isJsonObject()) {
                    continue;
                } else if (jsonElement != null) {
                    JsonObject jsonObject2 = (JsonObject) jsonElement;
                    if (m36113a(jsonObject2) == 1) {
                        String jsonElement2 = jsonElement.toString();
                        Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "value.toString()");
                        m36122b(str2, jsonElement2);
                        z2 = true;
                    }
                    if (m36123b(str, jsonObject2, z)) {
                        z2 = true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                }
            }
        }
        return z2;
    }

    /* renamed from: b */
    private final boolean m36123b(String str, JsonObject jsonObject, boolean z) {
        JsonElement jsonElement;
        String str2;
        if (!jsonObject.has("list") || (jsonElement = jsonObject.get("list")) == null || !jsonElement.isJsonArray()) {
            return false;
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        int size = asJsonArray.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement2 = asJsonArray.get(i);
            Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "objTemp");
            if (jsonElement2.isJsonObject()) {
                JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                if (asJsonObject.has("id")) {
                    JsonElement jsonElement3 = asJsonObject.get("id");
                    Intrinsics.checkExpressionValueIsNotNull(jsonElement3, "obj.get(XEParseConst.XE_JSON_KEY_ID)");
                    String asString = jsonElement3.getAsString();
                    CharSequence charSequence = asString;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        if (z) {
                            str2 = str + IOUtils.DIR_SEPARATOR_UNIX + asString + XECacheConfig.XE_CACHE_DEFAULT_FILE;
                        } else {
                            str2 = str + IOUtils.DIR_SEPARATOR_UNIX + asString + XECacheConfig.XE_CACHE_NORMAL_FILE;
                        }
                        if (asJsonObject != null) {
                            if (m36113a(asJsonObject) == 1) {
                                String jsonObject2 = asJsonObject.toString();
                                Intrinsics.checkExpressionValueIsNotNull(jsonObject2, "obj.toString()");
                                m36122b(str2, jsonObject2);
                                z2 = true;
                            }
                            if (m36123b(str, asJsonObject, z)) {
                                z2 = true;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return z2;
    }

    /* renamed from: b */
    private final JsonObject m36121b(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "JsonParser().parse(data)");
            return parse.getAsJsonObject();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    private final boolean m36126e(JsonObject jsonObject) {
        XECacheModel d;
        if (jsonObject == null || (d = m36125d(jsonObject)) == null) {
            return false;
        }
        int i = d.cacheStrategy;
        boolean z = i == 10000 || i == 10002;
        XECacheModel.ExpiredStrategy expiredStrategy = d.expiredStrategy;
        XECacheModel.Time time = expiredStrategy != null ? expiredStrategy.time : null;
        if (time == null) {
            return z;
        }
        Long l = time.start;
        Long l2 = time.end;
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        if (!z) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(l2, "endTime");
        long longValue = l2.longValue();
        if (l.longValue() <= currentTimeMillis && longValue >= currentTimeMillis) {
            return true;
        }
        return false;
    }
}

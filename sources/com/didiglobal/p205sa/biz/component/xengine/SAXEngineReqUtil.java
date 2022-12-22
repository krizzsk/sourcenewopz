package com.didiglobal.p205sa.biz.component.xengine;

import android.content.Context;
import com.android.didi.bfflib.BffExtra;
import com.didi.xengine.callback.XECallback;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didi.xengine.request.XEngineReqUtil;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.data.model.EngineInnerRequestModel;
import com.didiglobal.enginecore.data.parser.XEEngineParser;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001f\u0010\u0018\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012J-\u0010\u001e\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/SAXEngineReqUtil;", "", "()V", "TAG", "", "util", "Lcom/didi/xengine/request/XEngineReqUtil;", "engineCommit", "", "params", "Lcom/didi/xengine/request/XECommitBizParams;", "engineDispatch", "Lcom/didi/xengine/request/XEDispatchBizParams;", "mockActivityPageResponse", "context", "Landroid/content/Context;", "mockPageResponse", "pageRequest", "Lcom/didi/xengine/request/XEBizParamsImpl;", "scene", "pageRequestCacheOnly", "pageRequestWithCache", "readFile", "name", "setCache", "Lcom/didi/xengine/request/XECacheParamsImpl;", "isDefault", "", "(Lcom/didi/xengine/request/XECacheParamsImpl;Ljava/lang/Boolean;)V", "setDefaultCache", "simpleRequest", "modules", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.SAXEngineReqUtil */
/* compiled from: SAXEngineReqUtil.kt */
public final class SAXEngineReqUtil {
    public static final SAXEngineReqUtil INSTANCE = new SAXEngineReqUtil();

    /* renamed from: a */
    private static final String f51205a;

    /* renamed from: b */
    private static final XEngineReqUtil f51206b = new XEngineReqUtil(SAXEngineConstants.SA_XENGINE_TYPE);

    private SAXEngineReqUtil() {
    }

    static {
        String simpleName = SAXEngineReqUtil.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SAXEngineReqUtil::class.java.simpleName");
        f51205a = simpleName;
    }

    public final void pageRequest(String str) {
        f51206b.pageRequest(str);
    }

    public final void pageRequestWithCache(String str) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        xEBizParamsImpl.requestCache = true;
        pageRequest(xEBizParamsImpl);
    }

    public final void pageRequestCacheOnly(String str) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        xEBizParamsImpl.requestCache = true;
        xEBizParamsImpl.requestCacheOnly = true;
        pageRequest(xEBizParamsImpl);
    }

    public final void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        f51206b.pageRequest(xEBizParamsImpl);
    }

    public final void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        f51206b.simpleRequest(xEBizParamsImpl);
    }

    public final void simpleRequest(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "modules");
        f51206b.simpleRequest(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void engineCommit(XECommitBizParams xECommitBizParams) {
        f51206b.engineCommit(xECommitBizParams);
    }

    public final void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        f51206b.engineDispatch(xEDispatchBizParams);
    }

    public final void setDefaultCache(XECacheParamsImpl xECacheParamsImpl) {
        f51206b.setCache(xECacheParamsImpl, true);
    }

    public final void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        f51206b.setCache(xECacheParamsImpl, bool);
    }

    /* renamed from: a */
    private final void m36671a(Context context) {
        JsonObject asJsonObject = new JsonParser().parse(m36670a(context, "mock_xengineInnerModel.txt")).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "JsonParser().parse(readF….txt\")).getAsJsonObject()");
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel("sa_home", (Map<String, Object>) null, (Map<String, Object>) null, new XECallback("sa_home"));
        XEEngineParser.parse(context, EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(engineInnerRequestModel.scene), asJsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, (BffExtra) null, (XEngineDataHandleCallback) null));
    }

    public final void mockActivityPageResponse(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JsonObject asJsonObject = new JsonParser().parse(m36670a(context, "mock_xengineInnerModel_activity.txt")).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "JsonParser().parse(readF….txt\")).getAsJsonObject()");
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel("sa_activity", (Map<String, Object>) null, (Map<String, Object>) null, new XECallback("sa_activity"));
        XEEngineParser.parse(context, EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(engineInnerRequestModel.scene), asJsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, (BffExtra) null, (XEngineDataHandleCallback) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[SYNTHETIC, Splitter:B:17:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC, Splitter:B:24:0x003b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m36670a(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ IOException -> 0x002c, all -> 0x002a }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ IOException -> 0x002c, all -> 0x002a }
            int r5 = r4.available()     // Catch:{ IOException -> 0x0028 }
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0028 }
            r4.read(r5)     // Catch:{ IOException -> 0x0028 }
            java.lang.String r1 = "utf8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ IOException -> 0x0028 }
            java.lang.String r2 = "forName(\"utf8\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ IOException -> 0x0028 }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x0028 }
            r2.<init>(r5, r1)     // Catch:{ IOException -> 0x0028 }
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r2
        L_0x0028:
            r5 = move-exception
            goto L_0x002e
        L_0x002a:
            r5 = move-exception
            goto L_0x0039
        L_0x002c:
            r5 = move-exception
            r4 = r0
        L_0x002e:
            r5.printStackTrace()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0036
            r4.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return r0
        L_0x0037:
            r5 = move-exception
            r0 = r4
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.xengine.SAXEngineReqUtil.m36670a(android.content.Context, java.lang.String):java.lang.String");
    }
}

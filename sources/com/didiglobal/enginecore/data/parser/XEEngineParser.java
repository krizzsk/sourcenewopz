package com.didiglobal.enginecore.data.parser;

import android.content.Context;
import com.android.didi.bfflib.BffExtra;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.XEParserCallback;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.DataParseException;
import com.didiglobal.enginecore.data.handle.EngineDataHandler;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/parser/XEEngineParser;", "", "()V", "TAG", "", "engineMultiDispatch", "", "context", "Landroid/content/Context;", "callback", "Lcom/didiglobal/enginecore/XEngineCallback;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "xeParserCallback", "Lcom/didiglobal/enginecore/XEParserCallback;", "isCache", "", "innerParse", "model", "Lcom/didiglobal/enginecore/data/parser/model/EngineParseModel;", "parse", "parseAndDispatch", "pushParse", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEEngineParser.kt */
public final class XEEngineParser {
    public static final XEEngineParser INSTANCE = new XEEngineParser();

    /* renamed from: a */
    private static final String f50163a;

    static {
        String simpleName = XEEngineParser.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "XEEngineParser::class.java.simpleName");
        f50163a = simpleName;
    }

    private XEEngineParser() {
    }

    @JvmStatic
    public static final void parse(Context context, EngineParseModel engineParseModel) {
        Intrinsics.checkParameterIsNotNull(engineParseModel, "model");
        INSTANCE.m36145a(context, engineParseModel);
    }

    @JvmStatic
    public static final void pushParse(Context context, EngineParseModel engineParseModel) {
        Intrinsics.checkParameterIsNotNull(engineParseModel, "model");
        INSTANCE.m36145a(context, engineParseModel);
    }

    /* renamed from: a */
    private final void m36145a(Context context, EngineParseModel engineParseModel) {
        JsonObject data = engineParseModel.getData();
        XEngineCallback callback = engineParseModel.getCallback();
        List<String> templateKeyList = engineParseModel.getTemplateKeyList();
        String scene = engineParseModel.getScene();
        Set<String> requireSet = engineParseModel.getRequireSet();
        BffExtra extra = engineParseModel.getExtra();
        XEngineCommitCallback commitCallback = engineParseModel.getCommitCallback();
        XEngineDataHandleCallback dataHandleCallback = engineParseModel.getDataHandleCallback();
        boolean isSimpleRequest = engineParseModel.isSimpleRequest();
        if (data == null) {
            DataParseException dataParseException = new DataParseException("empty bff response data");
            if (commitCallback != null) {
                commitCallback.onFailed(dataParseException);
                return;
            }
            Map hashMap = new HashMap();
            if (!isSimpleRequest) {
                Set<String> registeredRequestKeysSet = TemplateCompRegister.getRegisteredRequestKeysSet(engineParseModel.getScene());
                if (registeredRequestKeysSet != null && (!registeredRequestKeysSet.isEmpty())) {
                    for (String next : registeredRequestKeysSet) {
                        Intrinsics.checkExpressionValueIsNotNull(next, "requestKey");
                        hashMap.put(next, dataParseException);
                    }
                }
            } else if (requireSet != null && (!requireSet.isEmpty())) {
                for (String put : requireSet) {
                    hashMap.put(put, dataParseException);
                }
            }
            if (callback != null) {
                callback.onFailed(hashMap);
                return;
            }
            return;
        }
        JsonObject asObject = XEParserUtil.getAsObject("data", data);
        if (asObject != null) {
            JsonObject dataHandle = EngineDataHandler.INSTANCE.dataHandle(asObject, scene, dataHandleCallback);
            if (dataHandle != null) {
                EngineParseModel createDataHandleModel = EngineParseModel.Companion.createDataHandleModel(scene, dataHandle, templateKeyList, requireSet, callback, commitCallback, extra);
                createDataHandleModel.setSimpleRequest(isSimpleRequest);
                parseAndDispatch(context, createDataHandleModel);
                return;
            }
            return;
        }
        Map hashMap2 = new HashMap();
        DataParseException dataParseException2 = new DataParseException(String.valueOf(XEParserUtil.getAsInt("errno", data, 0)), XEParserUtil.getAsString("errmsg", data, ""));
        if (commitCallback != null) {
            commitCallback.onFailed(dataParseException2);
            return;
        }
        if (!isSimpleRequest) {
            Set<String> registeredRequestKeysSet2 = TemplateCompRegister.getRegisteredRequestKeysSet(engineParseModel.getScene());
            if (registeredRequestKeysSet2 != null && (!registeredRequestKeysSet2.isEmpty())) {
                for (String next2 : registeredRequestKeysSet2) {
                    Intrinsics.checkExpressionValueIsNotNull(next2, "requestKey");
                    hashMap2.put(next2, dataParseException2);
                }
            }
        } else if (requireSet != null && (!requireSet.isEmpty())) {
            for (String put2 : requireSet) {
                hashMap2.put(put2, dataParseException2);
            }
        }
        if (callback != null) {
            callback.onFailed(hashMap2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v2, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v4, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v5, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v6, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v7, resolved type: com.didiglobal.enginecore.data.parser.model.EngineParseModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: com.google.gson.JsonObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r1v13, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x018b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0188  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseAndDispatch(android.content.Context r22, com.didiglobal.enginecore.data.parser.model.EngineParseModel r23) {
        /*
            java.lang.String r1 = "com_type"
            java.lang.String r2 = ""
            java.lang.String r0 = "model"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            com.google.gson.JsonObject r4 = r23.getData()
            java.util.List r0 = r23.getTemplateKeyList()
            java.util.Set r5 = r23.getRequireSet()
            com.didiglobal.enginecore.XEngineCallback r6 = r23.getCallback()
            com.didiglobal.enginecore.XEngineCommitCallback r7 = r23.getCommitCallback()
            com.android.didi.bfflib.BffExtra r8 = r23.getExtra()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.Map r9 = (java.util.Map) r9
            boolean r10 = r23.isCache()
            boolean r11 = r23.isSimpleRequest()
            r12 = 1
            if (r4 == 0) goto L_0x0190
            if (r0 == 0) goto L_0x01eb
            java.util.Iterator r3 = r0.iterator()
        L_0x003b:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x01eb
            java.lang.Object r0 = r3.next()
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11
            com.google.gson.JsonObject r15 = com.didiglobal.enginecore.data.parser.util.XEParserUtil.getAsObject(r11, r4)
            java.lang.String r17 = f50163a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = "parseAndDispatch: "
            r0.append(r13)
            r0.append(r11)
            r13 = 58
            r0.append(r13)
            r0.append(r15)
            java.lang.String r18 = r0.toString()
            r16 = 6
            r19 = 0
            r21 = 130(0x82, float:1.82E-43)
            java.lang.String r20 = "com.didiglobal.enginecore.data.parser.XEEngineParser"
            com.didi.sdk.apm.SystemUtils.log(r16, r17, r18, r19, r20, r21)
            if (r15 != 0) goto L_0x008c
            if (r5 == 0) goto L_0x0086
            boolean r0 = r5.contains(r11)
            if (r0 == 0) goto L_0x0086
            com.didiglobal.enginecore.data.exception.NoMatchException r0 = new com.didiglobal.enginecore.data.exception.NoMatchException
            java.lang.String r13 = "no match required data"
            r0.<init>(r13)
            r9.put(r11, r0)
        L_0x0086:
            r12 = r22
            r20 = r1
            goto L_0x018b
        L_0x008c:
            java.lang.String r0 = "xEngine_commit"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00a0
            com.didiglobal.enginecore.data.model.XEngineData r0 = new com.didiglobal.enginecore.data.model.XEngineData
            r0.<init>(r11, r15)
            r0.isCache = r10
            if (r7 == 0) goto L_0x00a0
            r7.onSuccess(r0)
        L_0x00a0:
            boolean r0 = r15.has(r1)     // Catch:{ Exception -> 0x0161 }
            if (r0 == 0) goto L_0x0130
            r0 = 0
            int r0 = com.didiglobal.enginecore.data.parser.util.XEParserUtil.getAsInt(r1, r15, r0)     // Catch:{ Exception -> 0x0161 }
            if (r0 != r12) goto L_0x00dd
            com.didiglobal.enginecore.data.parser.XEParser r13 = new com.didiglobal.enginecore.data.parser.XEParser     // Catch:{ Exception -> 0x00d4 }
            r13.<init>()     // Catch:{ Exception -> 0x00d4 }
            java.util.List r0 = com.didiglobal.enginecore.TemplateCompRegister.getTemplateList()     // Catch:{ Exception -> 0x00d4 }
            com.didiglobal.enginecore.data.parser.XEEngineParser$parseAndDispatch$1 r14 = new com.didiglobal.enginecore.data.parser.XEEngineParser$parseAndDispatch$1     // Catch:{ Exception -> 0x00d4 }
            r12 = r22
            r14.<init>(r12, r6, r10)     // Catch:{ Exception -> 0x00d2 }
            r18 = r14
            com.didiglobal.enginecore.XEParserCallback r18 = (com.didiglobal.enginecore.XEParserCallback) r18     // Catch:{ Exception -> 0x00d2 }
            r20 = r1
            r1 = 0
            r14 = r22
            r23 = r15
            r15 = r0
            r16 = r11
            r17 = r23
            r13.parse(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x00ff }
            goto L_0x018b
        L_0x00d2:
            r0 = move-exception
            goto L_0x00d7
        L_0x00d4:
            r0 = move-exception
            r12 = r22
        L_0x00d7:
            r20 = r1
            r1 = 0
            r14 = r15
            goto L_0x0168
        L_0x00dd:
            r12 = r22
            r20 = r1
            r23 = r15
            r1 = 0
            r13 = 2
            if (r0 != r13) goto L_0x0104
            com.didiglobal.enginecore.data.model.XEngineData r0 = new com.didiglobal.enginecore.data.model.XEngineData     // Catch:{ Exception -> 0x00ff }
            if (r8 == 0) goto L_0x00f0
            java.lang.String r13 = r8.traceId     // Catch:{ Exception -> 0x00ff }
            r14 = r23
            goto L_0x00f3
        L_0x00f0:
            r14 = r23
            r13 = r2
        L_0x00f3:
            r0.<init>(r11, r14, r13)     // Catch:{ Exception -> 0x015f }
            r0.isCache = r10     // Catch:{ Exception -> 0x015f }
            if (r6 == 0) goto L_0x018b
            r6.onSuccess(r0, r1)     // Catch:{ Exception -> 0x015f }
            goto L_0x018b
        L_0x00ff:
            r0 = move-exception
            r14 = r23
            goto L_0x0168
        L_0x0104:
            r14 = r23
            boolean r0 = com.didiglobal.enginecore.utils.XEngineUtil.isDebugApp(r22)     // Catch:{ Exception -> 0x015f }
            r13 = 1
            r0 = r0 ^ r13
            if (r0 == 0) goto L_0x0122
            com.didiglobal.enginecore.data.model.XEngineData r0 = new com.didiglobal.enginecore.data.model.XEngineData     // Catch:{ Exception -> 0x015f }
            if (r8 == 0) goto L_0x0115
            java.lang.String r13 = r8.traceId     // Catch:{ Exception -> 0x015f }
            goto L_0x0116
        L_0x0115:
            r13 = r2
        L_0x0116:
            r0.<init>(r11, r14, r13)     // Catch:{ Exception -> 0x015f }
            r0.isCache = r10     // Catch:{ Exception -> 0x015f }
            if (r6 == 0) goto L_0x018b
            r6.onSuccess(r0, r1)     // Catch:{ Exception -> 0x015f }
            goto L_0x018b
        L_0x0122:
            java.lang.String r0 = "返回的参数中，必须包含合理的com_type!"
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x015f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x015f }
            r13.<init>(r0)     // Catch:{ Exception -> 0x015f }
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ Exception -> 0x015f }
            throw r13     // Catch:{ Exception -> 0x015f }
        L_0x0130:
            r12 = r22
            r20 = r1
            r14 = r15
            r1 = 0
            boolean r0 = com.didiglobal.enginecore.utils.XEngineUtil.isDebugApp(r22)     // Catch:{ Exception -> 0x015f }
            r13 = 1
            r0 = r0 ^ r13
            if (r0 == 0) goto L_0x0151
            com.didiglobal.enginecore.data.model.XEngineData r0 = new com.didiglobal.enginecore.data.model.XEngineData     // Catch:{ Exception -> 0x015f }
            if (r8 == 0) goto L_0x0145
            java.lang.String r13 = r8.traceId     // Catch:{ Exception -> 0x015f }
            goto L_0x0146
        L_0x0145:
            r13 = r2
        L_0x0146:
            r0.<init>(r11, r14, r13)     // Catch:{ Exception -> 0x015f }
            r0.isCache = r10     // Catch:{ Exception -> 0x015f }
            if (r6 == 0) goto L_0x018b
            r6.onSuccess(r0, r1)     // Catch:{ Exception -> 0x015f }
            goto L_0x018b
        L_0x0151:
            java.lang.String r0 = "返回的参数中，必须包含com_type!"
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x015f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x015f }
            r13.<init>(r0)     // Catch:{ Exception -> 0x015f }
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ Exception -> 0x015f }
            throw r13     // Catch:{ Exception -> 0x015f }
        L_0x015f:
            r0 = move-exception
            goto L_0x0168
        L_0x0161:
            r0 = move-exception
            r12 = r22
            r20 = r1
            r14 = r15
            r1 = 0
        L_0x0168:
            boolean r13 = r0 instanceof com.google.gson.JsonParseException
            if (r13 == 0) goto L_0x016e
            r13 = 1
            goto L_0x016f
        L_0x016e:
            r13 = 5
        L_0x016f:
            java.lang.String r15 = r4.toString()
            com.android.didi.bfflib.utils.TrackUtil.trackError(r13, r2, r0, r15)
            r0.printStackTrace()
            com.didiglobal.enginecore.data.model.XEngineData r0 = new com.didiglobal.enginecore.data.model.XEngineData
            if (r8 == 0) goto L_0x0180
            java.lang.String r13 = r8.traceId
            goto L_0x0181
        L_0x0180:
            r13 = r2
        L_0x0181:
            r0.<init>(r11, r14, r13)
            r0.isCache = r10
            if (r6 == 0) goto L_0x018b
            r6.onSuccess(r0, r1)
        L_0x018b:
            r1 = r20
            r12 = 1
            goto L_0x003b
        L_0x0190:
            com.didiglobal.enginecore.data.exception.DataParseException r0 = new com.didiglobal.enginecore.data.exception.DataParseException
            java.lang.String r1 = "parseAndDispatch thedata null"
            r0.<init>(r1)
            if (r7 == 0) goto L_0x019f
            com.didiglobal.enginecore.data.exception.EngineErrorException r0 = (com.didiglobal.enginecore.data.exception.EngineErrorException) r0
            r7.onFailed(r0)
            goto L_0x01eb
        L_0x019f:
            if (r11 == 0) goto L_0x01c2
            if (r5 == 0) goto L_0x01eb
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x01eb
            java.util.Iterator r1 = r5.iterator()
        L_0x01b2:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01eb
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r9.put(r2, r0)
            goto L_0x01b2
        L_0x01c2:
            java.lang.String r1 = r23.getScene()
            java.util.Set r1 = com.didiglobal.enginecore.TemplateCompRegister.getRegisteredRequestKeysSet(r1)
            if (r1 == 0) goto L_0x01eb
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x01eb
            java.util.Iterator r1 = r1.iterator()
        L_0x01db:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01eb
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r9.put(r2, r0)
            goto L_0x01db
        L_0x01eb:
            boolean r0 = r9.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01f8
            if (r6 == 0) goto L_0x01f8
            r6.onFailed(r9)
        L_0x01f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.data.parser.XEEngineParser.parseAndDispatch(android.content.Context, com.didiglobal.enginecore.data.parser.model.EngineParseModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36144a(Context context, XEngineCallback xEngineCallback, List<? extends XEComponent> list, XEParserCallback xEParserCallback, boolean z) {
        JsonObject asJsonObject;
        if (list != null) {
            for (XEComponent xEComponent : list) {
                if (xEComponent instanceof NativeComponent) {
                    NativeComponent nativeComponent = (NativeComponent) xEComponent;
                    String id = nativeComponent.getId();
                    if (nativeComponent.getData() == null) {
                        XEngineData xEngineData = new XEngineData(id, (JsonObject) null);
                        xEngineData.isCache = false;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(xEComponent);
                        if (xEngineCallback != null) {
                            xEngineCallback.onSuccess(xEngineData, arrayList);
                        }
                    } else {
                        JsonElement parse = new JsonParser().parse(nativeComponent.getData().toString());
                        if (parse != null && (asJsonObject = parse.getAsJsonObject()) != null) {
                            JsonArray asArray = XEParserUtil.getAsArray("list", asJsonObject);
                            if (asArray == null || asArray.size() <= 0) {
                                XEngineData xEngineData2 = new XEngineData(id, asJsonObject);
                                xEngineData2.isCache = z;
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(xEComponent);
                                if (xEngineCallback != null) {
                                    xEngineCallback.onSuccess(xEngineData2, arrayList2);
                                }
                            } else {
                                new XEParser().parse(context, TemplateCompRegister.getTemplateList(), id, asJsonObject, xEParserCallback);
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}

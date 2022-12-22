package com.didiglobal.ddmirror.network;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.p188io.Streams;
import com.didiglobal.ddmirror.network.model.NetConfig;
import com.didiglobal.ddmirror.network.model.NetConfigData;
import com.didiglobal.ddmirror.reporter.MReporter;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didinet.NetEngine;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/NetWorkChecker;", "", "()V", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NetWorkChecker.kt */
public final class NetWorkChecker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, List<NetConfigData>> bffConfigMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Map<String, NetConfigData> configMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static boolean isEnable;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\nJ\u0010\u0010!\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0002J6\u0010%\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/NetWorkChecker$Companion;", "", "()V", "bffConfigMap", "", "", "", "Lcom/didiglobal/ddmirror/network/model/NetConfigData;", "configMap", "isEnable", "", "addStatisticalCallback", "", "checkApi", "urlPath", "context", "Ldidihttp/StatisticalContext;", "checkBff", "getApiPathFromUrlAndConfig", "url", "getBffConfig", "bffKeyPath", "getConfig", "getHostFormUrl", "getPathFromUrl", "getRequestData", "request", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "initConfig", "config", "Lcom/didiglobal/ddmirror/network/model/NetConfig;", "initFromString", "isBFFUrl", "isNeedCheck", "isRequestSuccess", "code", "", "reportHttpError", "msg", "errType", "errNo", "traceId", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: NetWorkChecker.kt */
    public static final class Companion {
        private final boolean isRequestSuccess(int i) {
            return i >= 200 && i < 300;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void initFromString(String str) {
            initConfig(NetConfigUtil.Companion.getConfigFromString(str));
        }

        public final void initConfig(NetConfig netConfig) {
            if (netConfig != null && netConfig.getData() != null && (!netConfig.getData().isEmpty())) {
                for (NetConfigData next : netConfig.getData()) {
                    List<String> urlFlag = next.getUrlFlag();
                    if (urlFlag != null) {
                        if (urlFlag != null && (!urlFlag.isEmpty())) {
                            for (String next2 : urlFlag) {
                                NetWorkChecker.configMap.put(next2, next);
                                if (next.getBffKeyPath() != null) {
                                    List list = (List) NetWorkChecker.bffConfigMap.get(next2);
                                    if (list == null) {
                                        list = new ArrayList();
                                        NetWorkChecker.bffConfigMap.put(next2, list);
                                    }
                                    list.add(next);
                                }
                            }
                        }
                        NetWorkChecker.isEnable = true;
                    }
                }
            }
        }

        public final boolean isNeedCheck() {
            return NetWorkChecker.isEnable;
        }

        public final boolean isNeedCheck(String str) {
            return NetWorkChecker.isEnable && CollectionsKt.contains(NetWorkChecker.configMap.keySet(), str);
        }

        public final NetConfigData getConfig(String str) {
            if (!NetWorkChecker.isEnable || str == null || !NetWorkChecker.configMap.keySet().contains(str)) {
                return null;
            }
            return (NetConfigData) NetWorkChecker.configMap.get(str);
        }

        public final List<NetConfigData> getBffConfig(String str) {
            if (!NetWorkChecker.isEnable || str == null || !NetWorkChecker.bffConfigMap.keySet().contains(str)) {
                return null;
            }
            return (List) NetWorkChecker.bffConfigMap.get(str);
        }

        public final boolean isBFFUrl(String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            CharSequence charSequence = str;
            return StringsKt.contains$default(charSequence, (CharSequence) "/halo/", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "/ability/", false, 2, (Object) null);
        }

        public final void addStatisticalCallback() {
            NetEngine.getInstance().addStatisticalCallback(NetWorkChecker$Companion$addStatisticalCallback$1.INSTANCE);
        }

        public final void checkBff(String str, StatisticalContext statisticalContext) {
            Intrinsics.checkParameterIsNotNull(statisticalContext, "context");
            statisticalContext.currentServerCallData();
            statisticalContext.hasError();
        }

        public final void checkApi(String str, StatisticalContext statisticalContext) {
            Intrinsics.checkParameterIsNotNull(statisticalContext, "context");
            if (getConfig(str) != null && statisticalContext.hasError()) {
                Companion companion = NetWorkChecker.Companion;
                Throwable error = statisticalContext.getError();
                String message = error != null ? error.getMessage() : null;
                ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
                Intrinsics.checkExpressionValueIsNotNull(currentServerCallData, "context.currentServerCallData()");
                int responseCode = currentServerCallData.getResponseCode();
                ServerCallItem currentServerCallData2 = statisticalContext.currentServerCallData();
                Intrinsics.checkExpressionValueIsNotNull(currentServerCallData2, "context.currentServerCallData()");
                companion.reportHttpError(str, message, -1, responseCode, currentServerCallData2.getTraceId());
            }
        }

        private final void reportHttpError(String str, String str2, int i, int i2, String str3) {
            Map hashMap = new HashMap();
            hashMap.put(DDMirrorNetConstants.INSTANCE.getURL_FLAG(), str);
            MReporter.Companion.reportError(DDMirrorNetConstants.INSTANCE.getMIRRPR_HTTP_ERROR(), Integer.valueOf(i), str2, i2, str3, (String) null, hashMap);
        }

        public final String getRequestData(HttpRpcRequest httpRpcRequest) {
            Intrinsics.checkParameterIsNotNull(httpRpcRequest, "request");
            HttpEntity entity = httpRpcRequest.getEntity();
            if (entity == null) {
                return null;
            }
            try {
                if (entity.getContentLength() != 0) {
                    return Streams.readFully((Reader) new InputStreamReader(entity.getContent()));
                }
                return null;
            } catch (Error e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getPathFromUrl(java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "url"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
                r1 = r9
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                r7 = 0
                if (r0 == 0) goto L_0x0010
                return r7
            L_0x0010:
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                java.lang.String r2 = "?"
                int r0 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
                if (r0 < 0) goto L_0x0026
                r1 = 0
                java.lang.String r9 = r9.substring(r1, r0)
                java.lang.String r0 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r0)
            L_0x0026:
                r0 = r9
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.String r9 = "/"
                java.lang.String[] r1 = new java.lang.String[]{r9}
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
                if (r0 == 0) goto L_0x0042
                int r1 = r0.size()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x0043
            L_0x0042:
                r1 = r7
            L_0x0043:
                if (r1 == 0) goto L_0x007f
                int r2 = r1.intValue()
                int r2 = r2 + -2
                if (r2 < 0) goto L_0x007f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                if (r0 == 0) goto L_0x0061
                int r3 = r1.intValue()
                int r3 = r3 + -2
                java.lang.Object r3 = r0.get(r3)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x0062
            L_0x0061:
                r3 = r7
            L_0x0062:
                r2.append(r3)
                r2.append(r9)
                if (r0 == 0) goto L_0x0077
                int r9 = r1.intValue()
                int r9 = r9 + -1
                java.lang.Object r9 = r0.get(r9)
                r7 = r9
                java.lang.String r7 = (java.lang.String) r7
            L_0x0077:
                r2.append(r7)
                java.lang.String r9 = r2.toString()
                return r9
            L_0x007f:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.network.NetWorkChecker.Companion.getPathFromUrl(java.lang.String):java.lang.String");
        }

        public final String getApiPathFromUrlAndConfig(String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence) && !NetWorkChecker.configMap.keySet().isEmpty()) {
                for (String str2 : NetWorkChecker.configMap.keySet()) {
                    if (StringsKt.contains$default(charSequence, (CharSequence) str2, false, 2, (Object) null)) {
                        return str2;
                    }
                }
            }
            return null;
        }

        public final String getHostFormUrl(String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                return parse != null ? parse.getHost() : str;
            } catch (Exception unused) {
                return str;
            }
        }
    }
}

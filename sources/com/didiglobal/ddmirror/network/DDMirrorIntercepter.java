package com.didiglobal.ddmirror.network;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.ddmirror.network.NetWorkChecker;
import com.didiglobal.ddmirror.network.model.NetConfigData;
import com.didiglobal.ddmirror.network.model.NetTrackData;
import com.didiglobal.ddmirror.network.model.Regx;
import com.didiglobal.ddmirror.reporter.MReporter;
import com.didiglobal.ddmirror.utils.DDMirrorDebugger;
import com.didiglobal.ddmirror.utils.RegUtils;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.google.gson.Gson;
import didihttp.internal.trace.IdGenrator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({RpcInterceptor.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J8\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J@\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J>\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002JH\u0010$\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002JV\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0002J!\u0010*\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010,J(\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002JB\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u00101\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0002J$\u00103\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u000e\u0010+\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000304H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0014\u00106\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u00107\u001a\u00020\u00032\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000309H\u0016J\u0019\u0010:\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010;J$\u0010<\u001a\u0004\u0018\u00010\u000b2\u0018\u0010=\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\nH\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J&\u0010?\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/DDMirrorIntercepter;", "Lcom/didichuxing/foundation/rpc/RpcInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "()V", "errorAttrsTL", "Ljava/lang/ThreadLocal;", "", "Lcom/didiglobal/ddmirror/network/model/NetTrackData;", "extraAttrsTL", "", "", "", "addToTrack", "", "errType", "", "urlFlag", "keyPath", "keyValue", "traceID", "checkApi", "request", "response", "traceId", "checkBff", "checkRequestBody", "", "requestData", "requestBodyRegex", "", "Lcom/didiglobal/ddmirror/network/model/Regx;", "bffPath", "checkRequestQuery", "url", "requestQueryRegex", "checkResponse", "responseRegex", "doCheck", "config", "Lcom/didiglobal/ddmirror/network/model/NetConfigData;", "body", "findPathExist", "data", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "findValueByPath", "findValueByPathForList", "rspJson", "pathList", "index", "results", "findValueInDataMapByPath", "", "getBodyFrom", "getXEngineCommitAbilityId", "intercept", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "isXEngineCommit", "(Ljava/lang/String;)Ljava/lang/Boolean;", "toJson", "map", "trackError", "trackRequest", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DDMirrorIntercepter.kt */
public final class DDMirrorIntercepter implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private final ThreadLocal<List<NetTrackData>> errorAttrsTL = new ThreadLocal<>();
    private final ThreadLocal<Map<String, Object>> extraAttrsTL = new ThreadLocal<>();

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        Intrinsics.checkParameterIsNotNull(rpcChain, "chain");
        HttpRpcRequest request = rpcChain.getRequest();
        String header = request.getHeader("didi-header-rid");
        if (TextUtils.isEmpty(header)) {
            HttpRpcRequest.Builder newBuilder = request.newBuilder();
            Intrinsics.checkExpressionValueIsNotNull(newBuilder, "request.newBuilder()");
            header = IdGenrator.generate((InetAddress) null);
            newBuilder.addHeader("didi-header-rid", header);
            request = newBuilder.build();
        }
        HttpRpcResponse proceed = rpcChain.proceed(request);
        if (NetWorkChecker.Companion.isNeedCheck()) {
            NetWorkChecker.Companion companion = NetWorkChecker.Companion;
            Intrinsics.checkExpressionValueIsNotNull(request, "request");
            String url = request.getUrl();
            Intrinsics.checkExpressionValueIsNotNull(url, "request.url");
            if (companion.isBFFUrl(url)) {
                Intrinsics.checkExpressionValueIsNotNull(proceed, "response");
                return checkBff(request, proceed, header);
            }
            Intrinsics.checkExpressionValueIsNotNull(proceed, "response");
            return checkApi(request, proceed, header);
        }
        Intrinsics.checkExpressionValueIsNotNull(proceed, "response");
        return proceed;
    }

    private final String getBodyFrom(HttpRpcResponse httpRpcResponse) {
        HttpEntity entity = httpRpcResponse.getEntity();
        Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
        MimeType contentType = entity.getContentType();
        if (contentType == null || !httpRpcResponse.isSuccessful() || entity.getContentLength() == 0) {
            return null;
        }
        if (!Intrinsics.areEqual((Object) "text", (Object) contentType.getType()) && !Intrinsics.areEqual((Object) "json", (Object) contentType.getSubtype())) {
            return null;
        }
        try {
            return Streams.readFully((Reader) new InputStreamReader(entity.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean checkRequestQuery(String str, List<Regx> list, String str2, String str3, String str4) {
        String str5;
        String str6;
        boolean z;
        Integer useAsExtraAttr;
        String str7;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        if (list == null) {
            return false;
        }
        for (Regx next : list) {
            String keyPath = next.getKeyPath();
            if (keyPath != null) {
                int intValue = (str8 != null ? Integer.valueOf(StringsKt.indexOf$default((CharSequence) str8, keyPath, 0, false, 6, (Object) null)) : null).intValue();
                if (intValue < 0) {
                    if (DDMirrorDebugger.isDebuggable()) {
                        SystemUtils.log(3, "DDMirrorIntercepter", "checkRequestQuery not found urlFlag: " + str9 + " ;keypath: " + next.getKeyPath(), (Throwable) null, "com.didiglobal.ddmirror.network.DDMirrorIntercepter", 102);
                    }
                    if (str10 != null) {
                        if (str10 != null) {
                            String substring = str10.substring(10);
                            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                            if (substring != null) {
                                str5 = substring;
                                addToTrack(4, str5, next.getKeyPath(), (Object) null, str4);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    str5 = str9;
                    addToTrack(4, str5, next.getKeyPath(), (Object) null, str4);
                } else if (str8 != null) {
                    String substring2 = str8.substring(intValue);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) substring2, ParamKeys.SIGN_AND, 0, false, 6, (Object) null);
                    if (indexOf$default >= 0) {
                        int length = keyPath.length() + 1;
                        if (substring2 != null) {
                            str6 = substring2.substring(length, indexOf$default);
                            Intrinsics.checkExpressionValueIsNotNull(str6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        int length2 = keyPath.length() + 1;
                        if (substring2 != null) {
                            str6 = substring2.substring(length2);
                            Intrinsics.checkExpressionValueIsNotNull(str6, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    String str11 = str6;
                    boolean regMatch = RegUtils.Companion.regMatch(str11, next.getRegex());
                    if (regMatch || ((useAsExtraAttr = next.getUseAsExtraAttr()) != null && useAsExtraAttr.intValue() == 1)) {
                        z = regMatch;
                    } else {
                        if (str10 != null) {
                            if (str10 != null) {
                                String substring3 = str10.substring(10);
                                Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.String).substring(startIndex)");
                                if (substring3 != null) {
                                    str7 = substring3;
                                    z = regMatch;
                                    addToTrack(1, str7, next.getKeyPath(), str11, str4);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        str7 = str9;
                        z = regMatch;
                        addToTrack(1, str7, next.getKeyPath(), str11, str4);
                    }
                    Integer useAsExtraAttr2 = next.getUseAsExtraAttr();
                    if (useAsExtraAttr2 != null && useAsExtraAttr2.intValue() == 1) {
                        Map map = this.extraAttrsTL.get();
                        if (map != null) {
                            map.put(keyPath, str11);
                        }
                        this.extraAttrsTL.set(map);
                    }
                    if (DDMirrorDebugger.isDebuggable()) {
                        SystemUtils.log(3, "DDMirrorIntercepter", "checkRequestQuery urlFlag: " + str9 + " ;keypath: " + next.getKeyPath() + " ;value: " + str11 + ";regx.regex: " + next.getRegex() + "; result: " + z, (Throwable) null, "com.didiglobal.ddmirror.network.DDMirrorIntercepter", 99);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
        return false;
    }

    private final boolean checkRequestBody(String str, List<Regx> list, String str2, String str3, String str4) {
        boolean z;
        String str5;
        String str6;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        if (!(str7 == null || list == null)) {
            for (Regx next : list) {
                Object findValueByPath = findValueByPath(next.getKeyPath(), str7, str8);
                if (findValueByPath == null) {
                    Integer useAsExtraAttr = next.getUseAsExtraAttr();
                    if (useAsExtraAttr == null || useAsExtraAttr.intValue() != 1) {
                        if (str9 != null) {
                            if (str9 != null) {
                                String substring = str9.substring(10);
                                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                                if (substring != null) {
                                    str6 = substring;
                                    addToTrack(5, str6, next.getKeyPath(), (Object) null, str4);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        str6 = str8;
                        addToTrack(5, str6, next.getKeyPath(), (Object) null, str4);
                    }
                    z = false;
                } else {
                    z = RegUtils.Companion.regMatch(findValueByPath.toString(), next.getRegex());
                    if (!z) {
                        if (str9 != null) {
                            if (str9 != null) {
                                String substring2 = str9.substring(10);
                                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                                if (substring2 != null) {
                                    str5 = substring2;
                                    addToTrack(2, str5, next.getKeyPath(), findValueByPath.toString(), str4);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        str5 = str8;
                        addToTrack(2, str5, next.getKeyPath(), findValueByPath.toString(), str4);
                    }
                }
                Integer useAsExtraAttr2 = next.getUseAsExtraAttr();
                if (useAsExtraAttr2 != null && useAsExtraAttr2.intValue() == 1) {
                    Map map = this.extraAttrsTL.get();
                    if (map != null) {
                        map.put(next.getKeyPath(), findValueByPath);
                    }
                    this.extraAttrsTL.set(map);
                }
                if (DDMirrorDebugger.isDebuggable()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkRequestBody urlFlag: ");
                    sb.append(str8);
                    sb.append(" ;keypath: ");
                    sb.append(next.getKeyPath());
                    sb.append(" ;value: ");
                    sb.append(findValueByPath != null ? findValueByPath.toString() : null);
                    sb.append(";regx.regex: ");
                    sb.append(next.getRegex());
                    sb.append("; result: ");
                    sb.append(z);
                    SystemUtils.log(3, "DDMirrorIntercepter", sb.toString(), (Throwable) null, "com.didiglobal.ddmirror.network.DDMirrorIntercepter", 132);
                }
            }
        }
        return false;
    }

    private final boolean checkResponse(String str, List<Regx> list, String str2, String str3, String str4, String str5) {
        Object obj;
        String str6;
        int i;
        boolean z;
        boolean z2;
        String str7;
        Object obj2;
        String str8;
        JSONObject jSONObject;
        List<String> list2;
        String str9;
        String str10;
        String str11 = str;
        String str12 = str2;
        String str13 = str3;
        String str14 = str5;
        if (list == null) {
            return false;
        }
        for (Regx next : list) {
            Integer useAsExtraAttr = next.getUseAsExtraAttr();
            if (useAsExtraAttr != null && useAsExtraAttr.intValue() == 2) {
                String keyPath = next.getKeyPath();
                List split$default = keyPath != null ? StringsKt.split$default((CharSequence) keyPath, new String[]{"."}, false, 0, 6, (Object) null) : null;
                if (!(split$default == null || !(!split$default.isEmpty()) || str11 == null)) {
                    try {
                        try {
                            jSONObject = new JSONObject(str11);
                        } catch (JSONException unused) {
                            jSONObject = null;
                        }
                        List arrayList = new ArrayList();
                        findValueByPathForList(jSONObject, split$default, 0, str2, arrayList);
                        List arrayList2 = new ArrayList();
                        for (Object next2 : arrayList) {
                            if (next2 != null) {
                                arrayList2.add(next2.toString());
                            }
                        }
                        if (arrayList2.size() == 0) {
                            if (str13 != null) {
                                if (str13 != null) {
                                    String substring = str13.substring(10);
                                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                                    if (substring != null) {
                                        str10 = substring;
                                        list2 = arrayList2;
                                        addToTrack(7, str10, next.getKeyPath(), "schmeList.size == 0", str4);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            str10 = str12;
                            list2 = arrayList2;
                            addToTrack(7, str10, next.getKeyPath(), "schmeList.size == 0", str4);
                        } else {
                            list2 = arrayList2;
                        }
                        if (list2.size() > 0) {
                            for (String str15 : list2) {
                                if (!RegUtils.Companion.regMatch(str15, next.getRegex())) {
                                    if (str13 != null) {
                                        if (str13 != null) {
                                            String substring2 = str13.substring(10);
                                            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                                            if (substring2 != null) {
                                                str9 = substring2;
                                                addToTrack(7, str9, next.getKeyPath(), str15, str4);
                                            }
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    }
                                    str9 = str12;
                                    addToTrack(7, str9, next.getKeyPath(), str15, str4);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } catch (Exception unused2) {
                        continue;
                    }
                }
            } else {
                Object findValueByPath = findValueByPath(next.getKeyPath(), str11, str12);
                String keyPath2 = next.getKeyPath();
                boolean z3 = keyPath2 != null && StringsKt.endsWith(keyPath2, "errno", true);
                if (findValueByPath == null) {
                    Integer useAsExtraAttr2 = next.getUseAsExtraAttr();
                    if (useAsExtraAttr2 == null || useAsExtraAttr2.intValue() != 1) {
                        if (!Intrinsics.areEqual((Object) isXEngineCommit(str14), (Object) true)) {
                            str6 = null;
                            if (str13 != null) {
                                if (str13 != null) {
                                    String substring3 = str13.substring(10);
                                    Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.String).substring(startIndex)");
                                    if (substring3 != null) {
                                        str8 = substring3;
                                        obj = findValueByPath;
                                        addToTrack(8, str8, next.getKeyPath(), (Object) null, str4);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            str8 = str12;
                            obj = findValueByPath;
                            addToTrack(8, str8, next.getKeyPath(), (Object) null, str4);
                        } else if (str13 != null && StringsKt.contains$default((CharSequence) str13, (CharSequence) XENetConstant.XE_KEY_ENGINE_COMMIT, false, 2, (Object) null)) {
                            String str16 = XENetConstant.XE_KEY_ENGINE_COMMIT + getXEngineCommitAbilityId(str14);
                            str6 = null;
                            obj = findValueByPath;
                            addToTrack(8, str16 != null ? str16 : str12, next.getKeyPath(), (Object) null, str4);
                        }
                        z2 = false;
                        z = true;
                        i = 1;
                    }
                    str6 = null;
                    obj = findValueByPath;
                    z2 = false;
                    z = false;
                    i = 1;
                } else {
                    str6 = null;
                    boolean regMatch = RegUtils.Companion.regMatch(findValueByPath.toString(), next.getRegex());
                    if (!regMatch) {
                        if (!Intrinsics.areEqual((Object) isXEngineCommit(str14), (Object) true) || str13 == null || !StringsKt.contains$default((CharSequence) str13, (CharSequence) XENetConstant.XE_KEY_ENGINE_COMMIT, false, 2, (Object) null)) {
                            i = 1;
                            if (str13 != null) {
                                if (str13 != null) {
                                    String substring4 = str13.substring(10);
                                    Intrinsics.checkExpressionValueIsNotNull(substring4, "(this as java.lang.String).substring(startIndex)");
                                    if (substring4 != null) {
                                        str7 = substring4;
                                        obj2 = findValueByPath;
                                        addToTrack(7, str7, next.getKeyPath(), findValueByPath, str4);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            str7 = str12;
                            obj2 = findValueByPath;
                            addToTrack(7, str7, next.getKeyPath(), findValueByPath, str4);
                        } else {
                            String str17 = XENetConstant.XE_KEY_ENGINE_COMMIT + getXEngineCommitAbilityId(str14);
                            i = 1;
                            obj2 = findValueByPath;
                            addToTrack(7, str17 != null ? str17 : str12, next.getKeyPath(), findValueByPath, str4);
                        }
                        z2 = regMatch;
                        z = true;
                    } else {
                        obj = findValueByPath;
                        i = 1;
                        z2 = regMatch;
                        z = false;
                    }
                }
                Integer useAsExtraAttr3 = next.getUseAsExtraAttr();
                if (useAsExtraAttr3 != null && useAsExtraAttr3.intValue() == i) {
                    Map map = this.extraAttrsTL.get();
                    if (map != null) {
                        map.put(next.getKeyPath(), obj);
                    }
                    this.extraAttrsTL.set(map);
                }
                if (DDMirrorDebugger.isDebuggable()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkResponse  urlFlag: ");
                    sb.append(str12);
                    sb.append(" ;keypath: ");
                    sb.append(next.getKeyPath());
                    sb.append(" ;value: ");
                    sb.append(obj != null ? obj.toString() : str6);
                    sb.append(";regx.regex: ");
                    sb.append(next.getRegex());
                    sb.append("; result: ");
                    sb.append(z2);
                    SystemUtils.log(3, "DDMirrorIntercepter", sb.toString(), (Throwable) null, "com.didiglobal.ddmirror.network.DDMirrorIntercepter", 214);
                }
                if (z3 && z) {
                    return false;
                }
            }
            str11 = str;
        }
        return false;
    }

    private final Boolean isXEngineCommit(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("abilities");
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(XENetConstant.XE_XENGINE_PASSENGER) : null;
            JSONObject optJSONObject3 = optJSONObject2 != null ? optJSONObject2.optJSONObject("common_param") : null;
            String optString = optJSONObject3 != null ? optJSONObject3.optString("action_type") : null;
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            if (optString != null) {
                return Boolean.valueOf(optString.equals(XENetConstant.XE_KEY_ENGINE_COMMIT));
            }
            return null;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String getXEngineCommitAbilityId(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("abilities");
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(XENetConstant.XE_XENGINE_PASSENGER) : null;
            JSONObject optJSONObject3 = optJSONObject2 != null ? optJSONObject2.optJSONObject("biz_param") : null;
            JSONObject optJSONObject4 = optJSONObject3 != null ? optJSONObject3.optJSONObject(XENetConstant.XE_KEY_ENGINE_COMMIT) : null;
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            sb.append(optJSONObject4 != null ? optJSONObject4.optString("ability_id") : null);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private final void findValueByPathForList(Object obj, List<String> list, int i, String str, List<Object> list2) {
        while (i < list.size()) {
            String str2 = list.get(i);
            int i2 = 0;
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.has(str2)) {
                    Object obj2 = Intrinsics.areEqual((Object) str2, (Object) "*") ? jSONObject.get(str) : jSONObject.get(str2);
                    if (obj2 instanceof JSONObject) {
                        obj = obj2;
                    } else if (obj2 instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj2;
                        if (jSONArray.length() > 0) {
                            while (i2 < jSONArray.length()) {
                                findValueByPathForList(jSONArray.get(i2), list, i + 1, str, list2);
                                i2++;
                            }
                        }
                    } else if (obj2 != null) {
                        list2.add(obj2);
                    }
                } else {
                    return;
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() > 0) {
                    while (i2 < jSONArray2.length()) {
                        findValueByPathForList(jSONArray2.get(i2), list, i + 1, str, list2);
                        i2++;
                    }
                }
            } else if (obj != null) {
                list2.add(obj);
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object findValueByPath(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0015
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "."
            java.lang.String[] r2 = new java.lang.String[]{r2}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            goto L_0x0016
        L_0x0015:
            r1 = r0
        L_0x0016:
            if (r1 == 0) goto L_0x00be
            if (r14 == 0) goto L_0x00be
            r2 = r0
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ Exception -> 0x00be }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0024 }
            r3.<init>(r14)     // Catch:{ JSONException -> 0x0024 }
            r2 = r3
            goto L_0x008c
        L_0x0024:
            r4 = r14
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00be }
            java.lang.String r14 = "&"
            java.lang.String[] r5 = new java.lang.String[]{r14}     // Catch:{ Exception -> 0x00be }
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.util.List r14 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00be }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00be }
            r3.<init>()     // Catch:{ Exception -> 0x00be }
            if (r14 == 0) goto L_0x008c
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x00be }
        L_0x0040:
            boolean r4 = r14.hasNext()     // Catch:{ Exception -> 0x00be }
            r5 = 1
            if (r4 == 0) goto L_0x007b
            java.lang.Object r4 = r14.next()     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00be }
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = "="
            java.lang.String[] r7 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x00be }
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            java.util.List r4 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r6, (java.lang.String[]) r7, (boolean) r8, (int) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x00be }
            r6 = r3
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x00be }
            r7 = 0
            java.lang.Object r7 = r4.get(r7)     // Catch:{ Exception -> 0x00be }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x00be }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00be }
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLDecoder.decode(r4, r5)     // Catch:{ Exception -> 0x00be }
            java.lang.String r5 = "URLDecoder.decode(kv[1], \"UTF-8\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ Exception -> 0x00be }
            r6.put(r7, r4)     // Catch:{ Exception -> 0x00be }
            goto L_0x0040
        L_0x007b:
            r14 = r3
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x00be }
            boolean r14 = r14.isEmpty()     // Catch:{ Exception -> 0x00be }
            r14 = r14 ^ r5
            if (r14 == 0) goto L_0x008c
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x00be }
            java.lang.Object r13 = r12.findValueInDataMapByPath(r13, r3)     // Catch:{ Exception -> 0x00be }
            return r13
        L_0x008c:
            java.util.Iterator r13 = r1.iterator()     // Catch:{ Exception -> 0x00be }
            r14 = r0
        L_0x0091:
            boolean r1 = r13.hasNext()     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x00be }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = "*"
            boolean r1 = r14.equals(r1)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x00ac
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r14 = r2.get(r15)     // Catch:{ Exception -> 0x00be }
            goto L_0x00b4
        L_0x00ac:
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r14 = r2.get(r14)     // Catch:{ Exception -> 0x00be }
            goto L_0x00b4
        L_0x00b3:
            r14 = r0
        L_0x00b4:
            boolean r1 = r14 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0091
            r1 = r14
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ Exception -> 0x00be }
            r2 = r1
            goto L_0x0091
        L_0x00bd:
            return r14
        L_0x00be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.network.DDMirrorIntercepter.findValueByPath(java.lang.String, java.lang.String, java.lang.String):java.lang.Object");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Map<?, ?>, code=java.lang.Object, for r9v0, types: [java.util.Map<?, ?>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object findValueInDataMapByPath(java.lang.String r8, java.lang.Object r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0015
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r8 = "."
            java.lang.String[] r2 = new java.lang.String[]{r8}
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.util.List r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            goto L_0x0016
        L_0x0015:
            r8 = r0
        L_0x0016:
            if (r8 == 0) goto L_0x005a
            if (r9 == 0) goto L_0x005a
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x005a }
            r1 = r0
        L_0x001f:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x0059
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005a }
            boolean r2 = r9 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x0032
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ Exception -> 0x005a }
            goto L_0x004e
        L_0x0032:
            boolean r2 = r9 instanceof java.lang.String     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x003f
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x005a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x005a }
        L_0x003d:
            r9 = r2
            goto L_0x004e
        L_0x003f:
            boolean r2 = r9 instanceof java.util.Map     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x004b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x005a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x005a }
            goto L_0x003d
        L_0x004b:
            r9 = r0
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ Exception -> 0x005a }
        L_0x004e:
            if (r9 == 0) goto L_0x0056
            java.lang.Object r9 = r9.get(r1)     // Catch:{ Exception -> 0x005a }
            r1 = r9
            goto L_0x0057
        L_0x0056:
            r1 = r0
        L_0x0057:
            r9 = r1
            goto L_0x001f
        L_0x0059:
            return r1
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.network.DDMirrorIntercepter.findValueInDataMapByPath(java.lang.String, java.util.Map):java.lang.Object");
    }

    private final Boolean findPathExist(String str, String str2) {
        List<String> split$default = str != null ? StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null) : null;
        if (split$default == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            for (String str3 : split$default) {
                Object obj = jSONObject.get(str3);
                if (obj instanceof JSONObject) {
                    jSONObject = (JSONObject) obj;
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private final HttpRpcResponse checkBff(HttpRpcRequest httpRpcRequest, HttpRpcResponse httpRpcResponse, String str) {
        JSONObject optJSONObject;
        HttpRpcResponse httpRpcResponse2 = httpRpcResponse;
        String requestData = NetWorkChecker.Companion.getRequestData(httpRpcRequest);
        if (!(requestData == null || (optJSONObject = new JSONObject(requestData).optJSONObject("abilities")) == null)) {
            String str2 = null;
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                NetConfigData config = NetWorkChecker.Companion.getConfig(next);
                List<NetConfigData> bffConfig = NetWorkChecker.Companion.getBffConfig(next);
                if (bffConfig != null) {
                    for (NetConfigData next2 : bffConfig) {
                        if (Intrinsics.areEqual((Object) findPathExist(next2.getBffKeyPath(), requestData), (Object) true)) {
                            if (str2 == null) {
                                str2 = getBodyFrom(httpRpcResponse2);
                            }
                            String str3 = str2;
                            doCheck(next2, next, next2.getBffKeyPath(), str, httpRpcRequest, httpRpcResponse, requestData, str3);
                            str2 = str3;
                        }
                    }
                } else if (config != null) {
                    if (str2 == null) {
                        str2 = getBodyFrom(httpRpcResponse2);
                    }
                    String str4 = str2;
                    doCheck(config, next, (String) null, str, httpRpcRequest, httpRpcResponse, requestData, str4);
                    str2 = str4;
                }
            }
            if (str2 != null) {
                HttpEntity entity = httpRpcResponse.getEntity();
                Intrinsics.checkExpressionValueIsNotNull(entity, "response.entity");
                HttpRpcResponse build = httpRpcResponse.newBuilder().setEntity((HttpEntity) HttpBody.newInstance(entity.getContentType(), str2)).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "response.newBuilder().setEntity(httpBody).build()");
                return build;
            }
        }
        return httpRpcResponse2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0112, code lost:
        if (r0 != null) goto L_0x011d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void doCheck(com.didiglobal.ddmirror.network.model.NetConfigData r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r20, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r21, java.lang.String r22, java.lang.String r23) {
        /*
            r15 = this;
            r7 = r15
            r8 = r18
            r9 = r19
            r10 = r22
            java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> r0 = r7.extraAttrsTL
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r0.set(r1)
            java.lang.ThreadLocal<java.util.List<com.didiglobal.ddmirror.network.model.NetTrackData>> r0 = r7.errorAttrsTL
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r0.set(r1)
            r11 = 0
            if (r20 == 0) goto L_0x0027
            java.lang.String r0 = r20.getUrl()
            goto L_0x0028
        L_0x0027:
            r0 = r11
        L_0x0028:
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = r20.getUrl()
            com.didiglobal.ddmirror.network.NetWorkChecker$Companion r1 = com.didiglobal.ddmirror.network.NetWorkChecker.Companion
            java.lang.String r2 = "url"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            java.lang.String r0 = r1.getHostFormUrl(r0)
            java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> r1 = r7.extraAttrsTL
            java.lang.Object r1 = r1.get()
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = "host"
            r1.put(r2, r0)
        L_0x0048:
            java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> r0 = r7.extraAttrsTL
            r0.set(r1)
            java.lang.String r1 = r20.getUrl()
            java.lang.String r0 = "request.url"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            java.util.List r2 = r16.getRequestQueryRegex()
            r0 = r15
            r3 = r17
            r4 = r18
            r5 = r19
            r0.checkRequestQuery(r1, r2, r3, r4, r5)
        L_0x0064:
            java.util.List r2 = r16.getRequestBodyRegex()
            r0 = r15
            r1 = r22
            r3 = r17
            r4 = r18
            r5 = r19
            r0.checkRequestBody(r1, r2, r3, r4, r5)
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r13 = "(this as java.lang.String).substring(startIndex)"
            r14 = 10
            if (r21 == 0) goto L_0x00aa
            boolean r0 = r21.isSuccessful()
            if (r0 != 0) goto L_0x00aa
            r1 = 0
            if (r8 == 0) goto L_0x0098
            if (r8 == 0) goto L_0x0092
            java.lang.String r0 = r8.substring(r14)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r13)
            if (r0 == 0) goto L_0x0098
            r2 = r0
            goto L_0x009a
        L_0x0092:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r12)
            throw r0
        L_0x0098:
            r2 = r17
        L_0x009a:
            int r0 = r21.getStatus()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "httpCode"
            r0 = r15
            r5 = r19
            r0.addToTrack(r1, r2, r3, r4, r5)
        L_0x00aa:
            if (r23 == 0) goto L_0x00c6
            if (r21 == 0) goto L_0x00c6
            boolean r0 = r21.isSuccessful()
            if (r0 == 0) goto L_0x00c6
            java.util.List r2 = r16.getResponseRegex()
            r0 = r15
            r1 = r23
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r22
            r0.checkResponse(r1, r2, r3, r4, r5, r6)
        L_0x00c6:
            java.lang.Boolean r0 = r15.isXEngineCommit(r10)
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0107
            if (r8 == 0) goto L_0x0107
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "xEngine_commit"
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 2
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r3, (boolean) r4, (int) r5, (java.lang.Object) r11)
            if (r0 != r1) goto L_0x0107
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r1 = r15.getXEngineCommitAbilityId(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x00fd
            goto L_0x00ff
        L_0x00fd:
            r0 = r17
        L_0x00ff:
            java.lang.String r1 = r16.getBffKeyPath()
            r15.trackRequest(r0, r1, r9)
            goto L_0x0124
        L_0x0107:
            if (r8 == 0) goto L_0x011b
            if (r8 == 0) goto L_0x0115
            java.lang.String r0 = r8.substring(r14)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r13)
            if (r0 == 0) goto L_0x011b
            goto L_0x011d
        L_0x0115:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r12)
            throw r0
        L_0x011b:
            r0 = r17
        L_0x011d:
            java.lang.String r1 = r16.getBffKeyPath()
            r15.trackRequest(r0, r1, r9)
        L_0x0124:
            r15.trackError()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.network.DDMirrorIntercepter.doCheck(com.didiglobal.ddmirror.network.model.NetConfigData, java.lang.String, java.lang.String, java.lang.String, com.didichuxing.foundation.net.rpc.http.HttpRpcRequest, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse, java.lang.String, java.lang.String):void");
    }

    private final HttpRpcResponse checkApi(HttpRpcRequest httpRpcRequest, HttpRpcResponse httpRpcResponse, String str) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        NetWorkChecker.Companion companion = NetWorkChecker.Companion;
        String url = httpRpcRequest.getUrl();
        Intrinsics.checkExpressionValueIsNotNull(url, "request.url");
        String apiPathFromUrlAndConfig = companion.getApiPathFromUrlAndConfig(url);
        objectRef.element = NetWorkChecker.Companion.getConfig(apiPathFromUrlAndConfig);
        if (((NetConfigData) objectRef.element) != null) {
            String bodyFrom = getBodyFrom(httpRpcResponse);
            doCheck((NetConfigData) objectRef.element, apiPathFromUrlAndConfig, (String) null, str, httpRpcRequest, httpRpcResponse, NetWorkChecker.Companion.getRequestData(httpRpcRequest), bodyFrom);
            if (bodyFrom != null) {
                HttpEntity entity = httpRpcResponse.getEntity();
                Intrinsics.checkExpressionValueIsNotNull(entity, "response.entity");
                HttpRpcResponse build = httpRpcResponse.newBuilder().setEntity((HttpEntity) HttpBody.newInstance(entity.getContentType(), bodyFrom)).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "response.newBuilder().setEntity(httpBody).build()");
                return build;
            }
        }
        return httpRpcResponse;
    }

    private final void addToTrack(int i, String str, String str2, Object obj, String str3) {
        NetTrackData netTrackData = new NetTrackData(Integer.valueOf(i), str, str2, obj, str3);
        List list = this.errorAttrsTL.get();
        if (list != null) {
            list.add(netTrackData);
        }
        this.errorAttrsTL.set(list);
    }

    private final void trackError() {
        List<NetTrackData> list = this.errorAttrsTL.get();
        if (list != null) {
            for (NetTrackData netTrackData : list) {
                Map hashMap = new HashMap();
                hashMap.put(DDMirrorNetConstants.INSTANCE.getURL_FLAG(), netTrackData.getUrlFlag());
                hashMap.put(DDMirrorNetConstants.INSTANCE.getKEY_PATH(), netTrackData.getKeyPath());
                hashMap.put(DDMirrorNetConstants.INSTANCE.getKEY_VALUE(), netTrackData.getKeyValue());
                Map map = this.extraAttrsTL.get();
                if (map != null) {
                    hashMap.put(DDMirrorNetConstants.INSTANCE.getKEY_EXT(), toJson(map));
                }
                MReporter.Companion.reportError(DDMirrorNetConstants.INSTANCE.getMIRRPR_HTTP_ERROR(), netTrackData.getErrType(), (String) null, -1, netTrackData.getTraceID(), (String) null, hashMap);
            }
        }
    }

    private final void trackRequest(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put(DDMirrorNetConstants.INSTANCE.getURL_FLAG(), str);
        hashMap.put(DDMirrorNetConstants.INSTANCE.getKEY_PATH(), str2);
        Map map = this.extraAttrsTL.get();
        if (map != null) {
            hashMap.put(DDMirrorNetConstants.INSTANCE.getKEY_EXT(), toJson(map));
        }
        MReporter.Companion.reportError(DDMirrorNetConstants.INSTANCE.getMIRRPR_HTTP_REQUEST(), -1, (String) null, -1, str3, (String) null, hashMap);
    }

    private final String toJson(Map<String, Object> map) {
        try {
            return new Gson().toJson((Object) map);
        } catch (Exception unused) {
            return "{}";
        }
    }
}

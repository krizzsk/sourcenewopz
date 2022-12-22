package com.sdk.poibase;

import com.didi.map.nettransformation.UrlRpcInterceptorV2;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.local.PsnPickupResult;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.recoperation.RpcRecOperation;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.HashMap;
import java.util.Map;

@Path("/mapapi")
@Interception({UrlRpcInterceptorV2.class})
/* renamed from: com.sdk.poibase.b */
/* compiled from: RpcPoiService */
interface C20513b extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/gethomeandcompany")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: a */
    void mo166799a(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcRecSug> callback);

    @Serialization(FormSerializer.class)
    @Path("/poiinfo")
    @Post
    @Deserialization(GsonDeserializer.class)
    /* renamed from: a */
    void mo166800a(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<ReverseStationsInfo> callback);

    @Serialization(GsonSerializer.class)
    @Path("/updatehomeandcompany")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: b */
    void mo166801b(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);

    @Serialization(GsonSerializer.class)
    @Path("/deletehomeandcompany")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: c */
    void mo166802c(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);

    @Serialization(GsonSerializer.class)
    @Path("/recpoioperation")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: d */
    void mo166803d(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcRecOperation> callback);

    @Serialization(GsonSerializer.class)
    @Path("/sendaddresshistory")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: e */
    void mo166804e(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);

    @Serialization(GsonSerializer.class)
    @Path("/recordclickpoi")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: f */
    void mo166805f(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);

    @Serialization(GsonSerializer.class)
    @Path("/personalpickupinfo")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: g */
    void mo166806g(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PsnPickupResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/updateCommon")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: h */
    void mo166807h(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);

    @Serialization(GsonSerializer.class)
    @Path("/deleteCommon")
    @Deserialization(GsonDeserializer.class)
    /* renamed from: i */
    void mo166808i(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<HttpResultBase> callback);
}

package com.didi.safetoolkit.net;

import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface ISfNetService extends RpcService {
    @Path("/other/pEmergencyAssist")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object emergencyAssist(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfEmgInfo> callback);

    @Path("/other/pGetReportingPolice")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object emergencyStatus(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfEmgStatus> callback);

    @Get
    @Path("/other/pSafetyCenterPage")
    @Deserialization(SfGsonDeserializer.class)
    Object safetyCenter(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<?> callback);

    @Path("/other/pShareTripBySMS")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object shareSMS(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfBaseObject> callback);

    @Path("/other/pReportPolice")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object startEmergencyCall(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfBaseObject> callback);

    @Path("/other/pStopReportPolice")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object stopEmergencyCall(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfBaseObject> callback);

    @Path("/other/pSyncContact")
    @Post
    @Deserialization(SfGsonDeserializer.class)
    Object syncContact(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SfBaseObject> callback);
}

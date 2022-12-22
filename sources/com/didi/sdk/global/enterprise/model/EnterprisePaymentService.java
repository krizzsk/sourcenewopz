package com.didi.sdk.global.enterprise.model;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

@Deprecated
@Interception({RequestMonitorInterceptor.class})
public interface EnterprisePaymentService extends RpcService {
    @Path("crius/api/Brazil/getCompanyList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getCompanyList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("crius/api/Brazil/getCostCenterList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getCostCenterList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("crius/api/Brazil/getProjectList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getProjectList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}

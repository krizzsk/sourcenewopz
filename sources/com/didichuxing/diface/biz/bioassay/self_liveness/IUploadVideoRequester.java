package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.data.ResultNothing;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.interceptor.SignerRpcInterceptor;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.io.File;

@Interception({SignerRpcInterceptor.class})
public interface IUploadVideoRequester extends RpcService {
    @Serialization(MultipartSerializer.class)
    @Path("/dd_face_global_uploadVideo")
    @Post(contentType = "multipart/form-data")
    @Deserialization(GsonDeserializer.class)
    void upload(@BodyParameter("sessionId") String str, @BodyParameter("video") File file, @TargetThread(ThreadType.MAIN) AbsRpcCallback<NewBaseResult<ResultNothing>, ResultNothing> absRpcCallback);

    public static class Holder {
        public static IUploadVideoRequester createRequest(Context context) {
            return (IUploadVideoRequester) new RpcServiceFactory(context).newRpcService(IUploadVideoRequester.class, HttpUtils.getHost());
        }
    }
}

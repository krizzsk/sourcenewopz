package com.didi.map.global.rpc.passengerlocation;

import com.didi.map.global.rpc.adapter.deserialization.MapApiDeserializationBytes;
import com.didi.map.global.rpc.adapter.serializer.MapApiSerializerBytes;
import com.didi.map.global.rpc.callback.MapRequestCallback;
import com.didi.map.global.rpc.callback.MapRpcCallback;
import com.didi.map.global.rpc.certificate.MapApiCATransporter;
import com.didi.map.global.rpc.interceptor.MapUrlInterceptor;
import com.didi.map.global.rpc.service.IMapRpcService;
import com.didi.map.sdk.proto.driver_gl.UserLocationReq;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Retry;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.didichuxing.foundation.rpc.annotation.Transportation;

public interface IPassengerLocationApiService {

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    @Transportation({MapApiCATransporter.class})
    @Interception({MapUrlInterceptor.class})
    @Retry(3)
    public interface IPassengerLocationRpcService extends IMapRpcService {
        @Serialization(MapApiSerializerBytes.class)
        @Post(contentType = "application/octet-stream")
        @Deserialization(MapApiDeserializationBytes.class)
        void requestPassengerLocation(@BodyParameter("BYTE_KEY") byte[] bArr, @TargetThread(ThreadType.MAIN) MapRpcCallback<UserLocationResWrapper> mapRpcCallback);
    }

    void requestPassengerLocation(UserLocationReq userLocationReq, MapRequestCallback<UserLocationResWrapper> mapRequestCallback);
}

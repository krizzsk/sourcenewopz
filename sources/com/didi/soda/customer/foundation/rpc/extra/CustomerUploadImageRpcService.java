package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerDataDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.io.File;

public interface CustomerUploadImageRpcService extends RpcService {
    @Serialization(MultipartSerializer.class)
    @Path("/user/updateUserInfo")
    @Post(contentType = "multipart/form-data")
    @Deserialization(CustomerDataDeserializer.class)
    Rpc updateUserInfo(@BodyParameter("imei") String str, @BodyParameter("poiId") String str2, @BodyParameter("poiLat") double d, @BodyParameter("poiLng") double d2, @BodyParameter("timestamp") long j, @BodyParameter("deviceId") String str3, @BodyParameter("suuid") String str4, @BodyParameter("lng") double d3, @BodyParameter("lat") double d4, @BodyParameter("clientType") int i, @BodyParameter("token") String str5, @BodyParameter("appVersion") String str6, @BodyParameter("versionCode") int i2, @BodyParameter("cityId") int i3, @BodyParameter("locale") String str7, @BodyParameter("firstName") String str8, @BodyParameter("lastName") String str9, @BodyParameter("headImg") File file, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<UserInfoEntity> customerRpcCallback);
}

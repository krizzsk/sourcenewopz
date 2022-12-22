package com.didi.sdk.webview.image;

import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import java.util.HashMap;

public interface ImageUploadService extends RpcService {
    @Serialization(MultipartSerializer.class)
    @Post(contentType = "multipart/form-data")
    @Deserialization(StringDeserializer.class)
    void uploadImage(@QueryParameter("") HashMap<String, String> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, RpcService.Callback<String> callback);
}

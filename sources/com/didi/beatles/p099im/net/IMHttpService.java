package com.didi.beatles.p099im.net;

import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

/* renamed from: com.didi.beatles.im.net.IMHttpService */
public interface IMHttpService extends RpcService {
    @Get
    @Serialization(FormSerializer.class)
    @Path("")
    @Deserialization(IMJsonDeserializer.class)
    void commonGet(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Serialization(IMJsonSerializer.class)
    @Path("/broker/")
    @Post(contentType = "application/json")
    @Deserialization(IMJsonDeserializer.class)
    void commonPost(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Get
    @Serialization(FormSerializer.class)
    @Path("")
    @Deserialization(ByteArrayDeserializer.class)
    void downloadFile(@BodyParameter("") String str, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Get
    @Serialization(FormSerializer.class)
    @Path("")
    @Deserialization(IMJsonDeserializer.class)
    void getDownloadFileInfo(@BodyParameter("") String str, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Serialization(IMJsonSerializer.class)
    @Path("/broker/polling/")
    @Post(contentType = "application/json")
    @Deserialization(IMJsonDeserializer.class)
    void pollingMsg(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Serialization(MultipartSerializer.class)
    @Path("/gift/upload_data/resource/im_voice_ns/")
    @Post(contentType = "multipart/form-data")
    @Deserialization(IMJsonDeserializer.class)
    void postFile(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);

    @Serialization(MultipartSerializer.class)
    @Path("/gift/upload_data/resource/im_image_ns/")
    @Post(contentType = "multipart/form-data")
    @Deserialization(IMJsonDeserializer.class)
    void postImage(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<?> callback);
}

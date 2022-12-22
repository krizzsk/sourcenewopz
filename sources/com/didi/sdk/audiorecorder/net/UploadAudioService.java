package com.didi.sdk.audiorecorder.net;

import com.didi.sdk.audiorecorder.model.UploadResponse;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import java.io.File;

public interface UploadAudioService extends RpcService {
    @Serialization(MultipartSerializer.class)
    @Post(contentType = "multipart/form-data")
    @Deserialization(GsonDeserializer.class)
    void driverUpload(@QueryParameter("ticket") String str, @QueryParameter("oids") String str2, @QueryParameter("utc_offset") int i, @BodyParameter("voice_file") File file, @QueryParameter("file_size") long j, @QueryParameter("voice_length") long j2, @QueryParameter("start_timestamp") long j3, @QueryParameter("end_timestamp") long j4, @QueryParameter("start_time") String str3, @QueryParameter("end_time") String str4, @BodyParameter("caller") String str5, @BodyParameter("business_id") String str6, @BodyParameter("extra_info") String str7, @QueryParameter("encrypt_key") String str8, RpcService.Callback<UploadResponse> callback);

    @Serialization(MultipartSerializer.class)
    @Post(contentType = "multipart/form-data")
    @Deserialization(GsonDeserializer.class)
    void passengerUpload(@QueryParameter("token") String str, @QueryParameter("oid") String str2, @QueryParameter("utc_offset") int i, @BodyParameter("voice_file") File file, @QueryParameter("file_size") long j, @QueryParameter("voice_length") long j2, @QueryParameter("start_timestamp") long j3, @QueryParameter("end_timestamp") long j4, @QueryParameter("start_time") String str3, @QueryParameter("end_time") String str4, @QueryParameter("lang") String str5, @BodyParameter("caller") String str6, @BodyParameter("business_id") String str7, @BodyParameter("extra_info") String str8, @QueryParameter("encrypt_key") String str9, RpcService.Callback<UploadResponse> callback);
}

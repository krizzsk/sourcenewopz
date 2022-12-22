package com.didichuxing.publicservice.resourcecontrol.utils;

import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceTrack {
    private static final String FS_RESOURCE_CK = "fs_resource_ck";
    private static final String FS_RESOURCE_CLOSE = "fs_resource_close";
    private static final String FS_RESOURCE_SW = "fs_resource_sw";

    interface ITrackRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("")
        @Deserialization(StringDeserializer.class)
        void requestAdTrack(@BodyParameter("") HashMap<String, Object> hashMap, RpcService.Callback<String> callback);
    }

    public static void trackEventSW(Map<String, Object> map) {
        trackAttr(map, FS_RESOURCE_SW);
    }

    public static void trackEventCK(Map<String, Object> map) {
        trackAttr(map, FS_RESOURCE_CK);
    }

    public static void trackEventClose(Map<String, Object> map) {
        trackAttr(map, FS_RESOURCE_CLOSE);
    }

    private static void trackAttr(Map<String, Object> map, String str) {
        if (map == null || map.size() <= 0) {
            OmegaSDKAdapter.trackEvent(str);
        } else {
            OmegaSDKAdapter.trackEvent(str, map);
        }
    }

    public static void trackURL(List<String> list) {
        if (list != null && list.size() != 0 && ResourceManager.getManager().getWeakRef() != null && ResourceManager.getManager().getWeakRef().get() != null) {
            for (String newRpcService : list) {
                ((ITrackRpcService) new RpcServiceFactory(ResourceManager.getManager().getActivity()).newRpcService(ITrackRpcService.class, newRpcService)).requestAdTrack((HashMap<String, Object>) null, new RpcService.Callback<String>() {
                    public void onFailure(IOException iOException) {
                    }

                    public void onSuccess(String str) {
                    }
                });
            }
        }
    }
}

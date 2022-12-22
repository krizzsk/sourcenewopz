package com.didi.travel.psnger.common.net;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.GsonResponseListener;
import com.didi.travel.psnger.common.net.base.RPCServiceWrapper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.common.net.rpc.IRouteService;
import com.didi.travel.psnger.common.net.rpc.ISpecialService;
import com.didi.travel.psnger.model.response.ActivityResInfo;
import com.didi.travel.psnger.model.response.CommuteConfig;
import com.didi.travel.psnger.model.response.FixedPriceRouteData;
import com.didi.travel.psnger.model.response.MisBannerResponse;
import com.didi.travel.psnger.model.response.NearDrivers;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;

public class SpecialRequest extends BaseRequest {

    /* renamed from: a */
    private static SpecialRequest f44041a;

    /* renamed from: b */
    private Context f44042b;

    /* renamed from: c */
    private ISpecialService f44043c;

    /* renamed from: d */
    private ISpecialService f44044d;

    /* renamed from: e */
    private IRouteService f44045e;

    /* renamed from: f */
    private ISpecialService f44046f;

    private SpecialRequest(Context context) {
        this.f44042b = context;
        RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context);
        this.f44043c = (ISpecialService) RPCServiceWrapper.wrap(this.f44042b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiBizHost()));
        this.f44044d = (ISpecialService) RPCServiceWrapper.wrap(this.f44042b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiCarslidingHost()));
        this.f44046f = (ISpecialService) RPCServiceWrapper.wrap(this.f44042b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiResourcesHost()));
        this.f44045e = (IRouteService) RPCServiceWrapper.wrap(this.f44042b, (IRouteService) rpcServiceFactory.newRpcService(IRouteService.class, HostGroupManager.getInstance().getDiDiRouteTrackHost()));
    }

    public static SpecialRequest getInstance(Context context) {
        if (f44041a == null) {
            synchronized (SpecialRequest.class) {
                if (f44041a == null) {
                    f44041a = new SpecialRequest(context.getApplicationContext());
                }
            }
        }
        return f44041a;
    }

    public void reqRoute(byte[] bArr, RpcService.Callback<byte[]> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(IRouteService.KEY_BYTE_ARRAY, bArr);
        this.f44045e.reqRoute(hashMap, callback);
    }

    public void sendLocationCallNearDrivers(Map map, GsonResponseListener<NearDrivers> gsonResponseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        this.f44044d.sendLocationCallNearDrivers(createBaseParams, getGsonRpcCallback(gsonResponseListener, NearDrivers.class));
    }

    public void sendOnServiceNearDrivers(Map map, GsonResponseListener<NearDrivers> gsonResponseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        this.f44044d.sendOnServiceNearDrivers(createBaseParams, getGsonRpcCallback(gsonResponseListener, NearDrivers.class));
    }

    public void requestDriveRoute(byte[] bArr, RpcService.Callback<byte[]> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(IRouteService.KEY_BYTE_ARRAY, bArr);
        this.f44045e.requestDriveRoute(hashMap, callback);
    }

    public void getActivityMulti(String[] strArr, String[] strArr2, Map map, ResponseListener<MisBannerResponse> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        this.f44046f.getActivityMulti(createBaseParams, getRpcCallback(responseListener, new MisBannerResponse(strArr, strArr2)));
    }

    public void getCommuteConfig(Map map, ResponseListener<CommuteConfig> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        this.f44043c.getCommuteConfig(createBaseParams, getRpcCallback(responseListener, new CommuteConfig()));
    }

    public void getActivityRes(Map map, ResponseListener<ActivityResInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        if (createBaseParams.get("token") == null) {
            createBaseParams.remove("token");
        }
        this.f44046f.getActivityRes(createBaseParams, getRpcCallback(responseListener, new ActivityResInfo()));
    }

    public Object getMapRouteInfo(Map map, ResponseListener<FixedPriceRouteData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f44042b);
        createBaseParams.putAll(map);
        return this.f44043c.getMapRouteInfo(createBaseParams, getRpcCallback(responseListener, new FixedPriceRouteData()));
    }
}

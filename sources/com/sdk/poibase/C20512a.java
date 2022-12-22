package com.sdk.poibase;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.company.select.view.GlobalCompanySelectActivity;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.guideentrance.StreetCheckParam;
import com.sdk.poibase.model.guideentrance.StreetCheckResult;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.recoperation.RpcRecOperation;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.sdk.poibase.util.ApolloUtil;
import com.sdk.poibase.util.BizUtil;
import com.sdk.poibase.util.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.sdk.poibase.a */
/* compiled from: PoiBaseApiImpl */
class C20512a extends BaseModel implements IPoiBaseApi {

    /* renamed from: a */
    private static final String f55994a = "PoiBaseApiImpl";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f55995b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static C20512a f55996c;

    /* renamed from: d */
    private Context f55997d;

    /* renamed from: e */
    private C20513b f55998e;

    /* renamed from: f */
    private String f55999f;

    /* renamed from: g */
    private ConcurrentHashMap<String, HttpRpcRequest> f56000g = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static C20512a m40320a(Context context) {
        if (f55996c == null) {
            synchronized (C20512a.class) {
                if (f55996c == null) {
                    f55996c = new C20512a(context);
                }
            }
        }
        return f55996c;
    }

    private C20512a(Context context) {
        super(context);
        this.f55997d = context;
        this.f55999f = Constant.POI_GLOBAL_URL;
        if (Utils.isCanoeApp(context)) {
            this.f55999f = Constant.POI_CANOE_GLOBAL_URL;
        }
        String apolloDebugUrl = ApolloUtil.getApolloDebugUrl(context);
        if (!TextUtils.isEmpty(apolloDebugUrl)) {
            this.f55999f = apolloDebugUrl;
        }
        this.f55998e = (C20513b) getService(C20513b.class, this.f55999f);
    }

    public void fetchPoiInfo(PoiInfoParam poiInfoParam, IHttpListener<ReverseStationsInfo> iHttpListener) {
        if (poiInfoParam != null) {
            DLog.m7384d(f55994a, "fetchPoiInfo() poiInfoParam: %s", poiInfoParam.toString());
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f55997d).getLastKnownLocation();
            if (poiInfoParam.isNeedNLP) {
                m40321a(lastKnownLocation, poiInfoParam, 1, iHttpListener);
            } else {
                m40321a(lastKnownLocation, poiInfoParam, 0, iHttpListener);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b A[SYNTHETIC, Splitter:B:24:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5 A[SYNTHETIC, Splitter:B:32:0x00d5] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m40321a(com.didichuxing.bigdata.p173dp.locsdk.DIDILocation r9, com.sdk.poibase.model.poi.PoiInfoParam r10, int r11, com.sdk.poibase.model.IHttpListener<com.sdk.poibase.model.poi.ReverseStationsInfo> r12) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f55997d
            java.util.HashMap r11 = r10.getParamMap(r0, r9, r11)
            android.content.Context r0 = r8.f55997d
            java.util.HashMap r9 = r10.getBodyMap(r0, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.f55999f
            r0.append(r1)
            java.lang.String r1 = "/mapapi/poiinfo"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.net.Uri r1 = android.net.Uri.parse(r0)
            java.lang.String r1 = r1.getScheme()
            android.net.Uri r2 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r2 = r2.buildUpon()
            java.util.Set r3 = r11.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0037:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005c
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r11.get(r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = ""
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r2.appendQueryParameter(r4, r5)
            goto L_0x0037
        L_0x005c:
            r11 = 0
            com.didichuxing.foundation.net.rpc.http.FormSerializer r3 = new com.didichuxing.foundation.net.rpc.http.FormSerializer     // Catch:{ IOException -> 0x0084 }
            r3.<init>()     // Catch:{ IOException -> 0x0084 }
            java.io.InputStream r9 = r3.serialize(r9)     // Catch:{ IOException -> 0x0084 }
            int r3 = r9.available()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            byte[] r11 = new byte[r3]     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r9.read(r11)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            if (r9 == 0) goto L_0x0094
            r9.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0094
        L_0x0075:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0094
        L_0x007a:
            r10 = move-exception
            r11 = r9
            goto L_0x00d3
        L_0x007d:
            r3 = move-exception
            r7 = r11
            r11 = r9
            r9 = r7
            goto L_0x0086
        L_0x0082:
            r10 = move-exception
            goto L_0x00d3
        L_0x0084:
            r3 = move-exception
            r9 = r11
        L_0x0086:
            r3.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r11 == 0) goto L_0x0093
            r11.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0093:
            r11 = r9
        L_0x0094:
            android.net.Uri r9 = r2.build()
            java.lang.String r9 = r9.toString()
            com.didichuxing.foundation.rpc.RpcServiceFactory r2 = r8.factory
            com.didichuxing.foundation.rpc.RpcClient r1 = r2.getRpcClient(r1)
            com.didichuxing.foundation.net.rpc.http.HttpRpcClient r1 = (com.didichuxing.foundation.net.rpc.http.HttpRpcClient) r1
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r2 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder
            r2.<init>()
            java.lang.String r3 = "application/x-www-form-urlencoded"
            com.didichuxing.foundation.net.http.HttpBody r11 = com.didichuxing.foundation.net.http.HttpBody.newInstance((java.lang.String) r3, (byte[]) r11)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r9 = r2.post(r9, r11)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r9 = r9.setRpcClient((com.didichuxing.foundation.rpc.RpcClient<? extends com.didichuxing.foundation.rpc.RpcRequest, ? extends com.didichuxing.foundation.rpc.RpcResponse>) r1)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r9 = r9.build()
            r8.m40324a((java.lang.String) r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpc r9 = r1.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r9)
            com.sdk.poibase.PoiBaseApiImpl$1 r11 = new com.sdk.poibase.PoiBaseApiImpl$1
            r11.<init>(r8, r10, r12)
            java.lang.Object r9 = r9.enqueue(r11)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r9 = (com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r9
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.didichuxing.foundation.net.rpc.http.HttpRpcRequest> r10 = r8.f56000g
            r10.put(r0, r9)
            return
        L_0x00d3:
            if (r11 == 0) goto L_0x00dd
            r11.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00dd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.C20512a.m40321a(com.didichuxing.bigdata.dp.locsdk.DIDILocation, com.sdk.poibase.model.poi.PoiInfoParam, int, com.sdk.poibase.model.IHttpListener):void");
    }

    public void getRecommendList(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener) {
        boolean z = true;
        DLog.m7384d(f55994a, "getRecommendList: %s", addressParam.toString());
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "getRecommendList");
        paramMap.put("city_id", Integer.valueOf(addressParam.cityId));
        paramMap.put("place_type", Integer.valueOf(addressParam.addressType));
        paramMap.put("passenger_id", addressParam.uid);
        paramMap.put("departure_time", addressParam.departure_time);
        paramMap.put("channel", SystemUtil.getChannelId());
        paramMap.put(CarServerParam.PARAM_CALL_FROM, Integer.valueOf(addressParam.callFrom));
        paramMap.put("is_need_common", Integer.valueOf(addressParam.isNeedCommon));
        if (addressParam.startAddress != null) {
            LatLng latLng = new LatLng(addressParam.startAddress.latitude, addressParam.startAddress.longitude);
            if (!addressParam.needDiscount || !LatLngUtils.locateCorrect(latLng)) {
                z = false;
            }
            paramMap.put("is_discount", z ? "1" : "0");
            if (z) {
                paramMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, Double.valueOf(latLng.latitude));
                paramMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, Double.valueOf(latLng.longitude));
            }
        }
        HashMap<String, Object> recBodyMap = AddressParam.getRecBodyMap(this.f55997d, addressParam.appVersion);
        String str = this.f55999f + "/mapapi/recommend";
        String scheme = Uri.parse(str).getScheme();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : paramMap.keySet()) {
            buildUpon.appendQueryParameter(next, paramMap.get(next) + "");
        }
        byte[] a = m40325a(recBodyMap);
        String uri = buildUpon.build().toString();
        HttpRpcClient httpRpcClient = (HttpRpcClient) this.factory.getRpcClient(scheme);
        HttpRpcRequest build = new HttpRpcRequest.Builder().post(uri, HttpBody.newInstance("application/x-www-form-urlencoded", a)).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) httpRpcClient).build();
        m40324a(str);
        this.f56000g.put(str, (HttpRpcRequest) httpRpcClient.newRpc(build).enqueue(new PoiBaseApiImpl$2(this, iHttpListener, addressParam)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[SYNTHETIC, Splitter:B:20:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC, Splitter:B:26:0x003d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m40325a(java.util.HashMap<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            r0 = 0
            com.didichuxing.foundation.net.rpc.http.FormSerializer r1 = new com.didichuxing.foundation.net.rpc.http.FormSerializer     // Catch:{ IOException -> 0x002a }
            r1.<init>()     // Catch:{ IOException -> 0x002a }
            java.io.InputStream r4 = r1.serialize(r4)     // Catch:{ IOException -> 0x002a }
            int r1 = r4.available()     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            byte[] r0 = new byte[r1]     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r4.read(r0)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x003a
        L_0x0019:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003a
        L_0x001e:
            r0 = move-exception
            goto L_0x003b
        L_0x0020:
            r1 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x002c
        L_0x0025:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x003b
        L_0x002a:
            r1 = move-exception
            r4 = r0
        L_0x002c:
            r1.printStackTrace()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            r0 = r4
        L_0x003a:
            return r0
        L_0x003b:
            if (r4 == 0) goto L_0x0045
            r4.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0045:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.C20512a.m40325a(java.util.HashMap):byte[]");
    }

    public void getCommonAddress(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "getCommonAddress");
        paramMap.put("place_type", 8);
        this.f55998e.mo166799a(paramMap, new PoiBaseApiImpl$3(this, iHttpListener));
    }

    public void updateCommonAddress(AddressParam addressParam, RpcPoi rpcPoi, IHttpListener<HttpResultBase> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "updateCommonAddress()");
        paramMap.put("common_type", Integer.valueOf(BizUtil.getCommonType(addressParam)));
        paramMap.put("displayname", rpcPoi.base_info.displayname);
        paramMap.put("address", rpcPoi.base_info.address);
        paramMap.put("lng", Double.valueOf(rpcPoi.base_info.lng));
        paramMap.put("lat", Double.valueOf(rpcPoi.base_info.lat));
        paramMap.put("city_id", Integer.valueOf(rpcPoi.base_info.city_id));
        paramMap.put("poi_id", rpcPoi.base_info.poi_id);
        paramMap.put("country_id", Integer.valueOf(rpcPoi.base_info.countryId));
        paramMap.put("country_code", rpcPoi.base_info.countryCode);
        this.f55998e.mo166801b(paramMap, new PoiBaseApiImpl$4(this, iHttpListener));
    }

    public void deleteCommonAddress(AddressParam addressParam, IHttpListener<HttpResultBase> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "deleteCommonAddress()");
        paramMap.put("common_type", Integer.valueOf(BizUtil.getCommonType(addressParam)));
        this.f55998e.mo166802c(paramMap, new PoiBaseApiImpl$5(this, iHttpListener));
    }

    public void getTextSearchList(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "getTextSearchList()");
        paramMap.put("place_type", Integer.valueOf(addressParam.addressType));
        paramMap.put("query", addressParam.query);
        if (!TextUtils.isEmpty(addressParam.order_type)) {
            paramMap.put("order_type", addressParam.order_type);
        }
        if (!TextUtils.isEmpty(addressParam.assist)) {
            paramMap.put("assist", addressParam.assist);
        }
        paramMap.put("mansearch", addressParam.mansearch);
        paramMap.put("is_no_cache", addressParam.is_no_cache);
        if (!TextUtils.isEmpty(addressParam.is_test)) {
            paramMap.put("is_test", addressParam.is_test);
        }
        paramMap.put("channel", SystemUtil.getChannelId());
        if (addressParam.startAddress != null) {
            LatLng latLng = new LatLng(addressParam.startAddress.latitude, addressParam.startAddress.longitude);
            boolean z = addressParam.needDiscount && LatLngUtils.locateCorrect(latLng);
            paramMap.put("is_discount", z ? "1" : "0");
            if (z) {
                paramMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, Double.valueOf(latLng.latitude));
                paramMap.put(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, Double.valueOf(latLng.longitude));
            }
        }
        byte[] a = m40325a(AddressParam.getBodyMap(this.f55997d));
        String str = this.f55999f + "/mapapi/textsearch";
        String scheme = Uri.parse(str).getScheme();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : paramMap.keySet()) {
            buildUpon.appendQueryParameter(next, paramMap.get(next) + "");
        }
        String uri = buildUpon.build().toString();
        HttpRpcClient httpRpcClient = (HttpRpcClient) this.factory.getRpcClient(scheme);
        HttpRpcRequest build = new HttpRpcRequest.Builder().post(uri, HttpBody.newInstance("application/x-www-form-urlencoded", a)).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) httpRpcClient).build();
        m40324a(str);
        this.f56000g.put(str, (HttpRpcRequest) httpRpcClient.newRpc(build).enqueue(new PoiBaseApiImpl$6(this, iHttpListener, addressParam)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40323a(RpcRecSug rpcRecSug) {
        if (rpcRecSug != null) {
            if (rpcRecSug.rec_poi_list != null && rpcRecSug.rec_poi_list.size() > 0) {
                Iterator<RpcPoi> it = rpcRecSug.rec_poi_list.iterator();
                while (it.hasNext()) {
                    RpcPoi next = it.next();
                    if (next.discount_poi != null && next.discount_poi.size() > 0) {
                        Iterator<RpcPoi> it2 = next.discount_poi.iterator();
                        while (it2.hasNext()) {
                            it2.next().isDiscountPoi = true;
                        }
                    }
                }
            }
            if (rpcRecSug.result != null && rpcRecSug.result.size() > 0) {
                Iterator<RpcPoi> it3 = rpcRecSug.result.iterator();
                while (it3.hasNext()) {
                    RpcPoi next2 = it3.next();
                    if (next2.discount_poi != null && next2.discount_poi.size() > 0) {
                        Iterator<RpcPoi> it4 = next2.discount_poi.iterator();
                        while (it4.hasNext()) {
                            it4.next().isDiscountPoi = true;
                        }
                    }
                }
            }
        }
    }

    public void getGeocodeResult(AddressParam addressParam, RpcPoi rpcPoi, IHttpListener<RpcRecSug> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "getGeocodeResult()");
        if (rpcPoi.base_info != null) {
            paramMap.put("poi_id", rpcPoi.base_info.poi_id);
            paramMap.put("displayname", rpcPoi.base_info.displayname);
            paramMap.put("address", rpcPoi.base_info.address);
        }
        String str = this.f55999f + "/mapapi/geocode";
        String scheme = Uri.parse(str).getScheme();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : paramMap.keySet()) {
            buildUpon.appendQueryParameter(next, paramMap.get(next) + "");
        }
        String uri = buildUpon.build().toString();
        HttpRpcClient httpRpcClient = (HttpRpcClient) this.factory.getRpcClient(scheme);
        HttpRpcRequest build = new HttpRpcRequest.Builder().get(uri).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) httpRpcClient).build();
        m40324a(str);
        this.f56000g.put(str, (HttpRpcRequest) httpRpcClient.newRpc(build).enqueue(new PoiBaseApiImpl$7(this, iHttpListener, rpcPoi)));
    }

    /* renamed from: a */
    private void m40324a(String str) {
        HttpRpcClient rpcClient;
        HttpRpcRequest remove = this.f56000g.remove(str);
        if (remove != null && (rpcClient = remove.getRpcClient()) != null) {
            rpcClient.cancel(remove);
        }
    }

    public void recPoiOperation(AddressParam addressParam, IHttpListener<RpcRecOperation> iHttpListener) {
        this.f55998e.mo166803d(AddressParam.getParamMap(this.f55997d, addressParam, "recPoiOperation()"), new PoiBaseApiImpl$8(this, iHttpListener));
    }

    public void recordClickPoi(AddressParam addressParam, RpcPoiBaseInfo rpcPoiBaseInfo, IHttpListener<HttpResultBase> iHttpListener) {
        if (addressParam != null && rpcPoiBaseInfo != null) {
            HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "recordClickPoi()");
            paramMap.put("place_type", Integer.valueOf(addressParam.addressType));
            paramMap.put("poi_displayname", rpcPoiBaseInfo.displayname);
            paramMap.put("poi_address", rpcPoiBaseInfo.address);
            paramMap.put("poi_id", rpcPoiBaseInfo.poi_id);
            paramMap.put("poi_lng", Double.valueOf(rpcPoiBaseInfo.lng));
            paramMap.put("poi_lat", Double.valueOf(rpcPoiBaseInfo.lat));
            paramMap.put(ParamConst.PARAM_POI_ID_CITY, Integer.valueOf(rpcPoiBaseInfo.city_id));
            paramMap.put(Const.CampaignKey.KEY_CLICK_TIME, Long.valueOf(System.currentTimeMillis()));
            paramMap.put("passenger_id", addressParam.uid);
            paramMap.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag == null ? "" : rpcPoiBaseInfo.srctag);
            this.f55998e.mo166805f(paramMap, new PoiBaseApiImpl$9(this, iHttpListener));
        }
    }

    public void reverseGeo(ReverseGeoParam reverseGeoParam, IHttpListener<ReverseGeoResult> iHttpListener) {
        HashMap<String, Object> paramMap = reverseGeoParam.getParamMap(this.f55997d);
        String str = this.f55999f + "/mapapi/reversegeo";
        String scheme = Uri.parse(str).getScheme();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : paramMap.keySet()) {
            buildUpon.appendQueryParameter(next, paramMap.get(next) + "");
        }
        String uri = buildUpon.build().toString();
        HttpRpcClient httpRpcClient = (HttpRpcClient) this.factory.getRpcClient(scheme);
        HttpRpcRequest build = new HttpRpcRequest.Builder().get(uri).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) httpRpcClient).build();
        m40324a(str);
        if (Utils.isNetworkConnect(this.f55997d)) {
            this.f56000g.put(str, (HttpRpcRequest) httpRpcClient.newRpc(build).enqueue(new PoiBaseApiImpl$11(this, iHttpListener, reverseGeoParam)));
        } else if (iHttpListener != null) {
            f55995b.post(new PoiBaseApiImpl$10(this, iHttpListener));
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z, IHttpListener<HttpResultBase> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "updateFavoritePlace()");
        paramMap.put("common_type", Integer.valueOf(BizUtil.getCommonType(addressParam)));
        paramMap.put("displayname", rpcCommonPoi.displayName);
        paramMap.put("address", rpcCommonPoi.address);
        paramMap.put("lng", Double.valueOf(rpcCommonPoi.longitude));
        paramMap.put("lat", Double.valueOf(rpcCommonPoi.latitude));
        paramMap.put("city_id", Integer.valueOf(rpcCommonPoi.cityId));
        paramMap.put("poi_id", rpcCommonPoi.poi_id);
        paramMap.put("country_id", Integer.valueOf(rpcCommonPoi.countryID));
        paramMap.put("country_code", rpcCommonPoi.countryCode);
        paramMap.put("alias_name", rpcCommonPoi.aliasName);
        paramMap.put("primary_id", rpcCommonPoi.primaryId);
        paramMap.put("operation_type", Integer.valueOf(z ? 1 : 2));
        this.f55998e.mo166807h(paramMap, new PoiBaseApiImpl$12(this, iHttpListener));
    }

    public void deleteFavoritePlace(AddressParam addressParam, String str, IHttpListener<HttpResultBase> iHttpListener) {
        HashMap<String, Object> paramMap = AddressParam.getParamMap(this.f55997d, addressParam, "deleteFavoritePlace()");
        paramMap.put("common_type", Integer.valueOf(BizUtil.getCommonType(addressParam)));
        paramMap.put("primary_id", str);
        this.f55998e.mo166808i(paramMap, new PoiBaseApiImpl$13(this, iHttpListener));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[SYNTHETIC, Splitter:B:24:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3 A[SYNTHETIC, Splitter:B:32:0x00d3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getGuideEntrancePriority(com.sdk.poibase.model.guideentrance.GuideEntranceParam r10, com.sdk.poibase.model.IHttpListener<com.sdk.poibase.model.guideentrance.GuideEntranceResult> r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f55997d
            java.util.HashMap r0 = r10.getParamMap(r0)
            java.util.HashMap r10 = r10.getBodyMap()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r9.f55999f
            r1.append(r2)
            java.lang.String r2 = "/mapapi/getwalkguideinfo"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.net.Uri r2 = android.net.Uri.parse(r1)
            java.lang.String r2 = r2.getScheme()
            android.net.Uri r3 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.util.Set r4 = r0.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0035:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.get(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = ""
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r3.appendQueryParameter(r5, r6)
            goto L_0x0035
        L_0x005a:
            r0 = 0
            com.didichuxing.foundation.net.rpc.http.FormSerializer r4 = new com.didichuxing.foundation.net.rpc.http.FormSerializer     // Catch:{ IOException -> 0x0082 }
            r4.<init>()     // Catch:{ IOException -> 0x0082 }
            java.io.InputStream r10 = r4.serialize(r10)     // Catch:{ IOException -> 0x0082 }
            int r4 = r10.available()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            byte[] r0 = new byte[r4]     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r10.read(r0)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            if (r10 == 0) goto L_0x0092
            r10.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0092
        L_0x0073:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x0092
        L_0x0078:
            r11 = move-exception
            r0 = r10
            goto L_0x00d1
        L_0x007b:
            r4 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x0084
        L_0x0080:
            r11 = move-exception
            goto L_0x00d1
        L_0x0082:
            r4 = move-exception
            r10 = r0
        L_0x0084:
            r4.printStackTrace()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0091:
            r0 = r10
        L_0x0092:
            android.net.Uri r10 = r3.build()
            java.lang.String r10 = r10.toString()
            com.didichuxing.foundation.rpc.RpcServiceFactory r3 = r9.factory
            com.didichuxing.foundation.rpc.RpcClient r2 = r3.getRpcClient(r2)
            com.didichuxing.foundation.net.rpc.http.HttpRpcClient r2 = (com.didichuxing.foundation.net.rpc.http.HttpRpcClient) r2
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r3 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder
            r3.<init>()
            java.lang.String r4 = "application/x-www-form-urlencoded"
            com.didichuxing.foundation.net.http.HttpBody r0 = com.didichuxing.foundation.net.http.HttpBody.newInstance((java.lang.String) r4, (byte[]) r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r10 = r3.post(r10, r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r10 = r10.setRpcClient((com.didichuxing.foundation.rpc.RpcClient<? extends com.didichuxing.foundation.rpc.RpcRequest, ? extends com.didichuxing.foundation.rpc.RpcResponse>) r2)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r10 = r10.build()
            r9.m40324a((java.lang.String) r1)
            com.didichuxing.foundation.net.rpc.http.HttpRpc r10 = r2.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r10)
            com.sdk.poibase.PoiBaseApiImpl$14 r0 = new com.sdk.poibase.PoiBaseApiImpl$14
            r0.<init>(r9, r11)
            java.lang.Object r10 = r10.enqueue(r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r10 = (com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r10
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.didichuxing.foundation.net.rpc.http.HttpRpcRequest> r11 = r9.f56000g
            r11.put(r1, r10)
            return
        L_0x00d1:
            if (r0 == 0) goto L_0x00db
            r0.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00db:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.C20512a.getGuideEntrancePriority(com.sdk.poibase.model.guideentrance.GuideEntranceParam, com.sdk.poibase.model.IHttpListener):void");
    }

    public void checkStreetIsValid(StreetCheckParam streetCheckParam, IHttpListener<StreetCheckResult> iHttpListener) {
        HashMap<String, Object> paramMap = streetCheckParam.getParamMap();
        String str = this.f55999f + "/mapapi/streetviewcheck";
        String scheme = Uri.parse(str).getScheme();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : paramMap.keySet()) {
            buildUpon.appendQueryParameter(next, paramMap.get(next) + "");
        }
        String uri = buildUpon.build().toString();
        HttpRpcClient httpRpcClient = (HttpRpcClient) this.factory.getRpcClient(scheme);
        HttpRpcRequest build = new HttpRpcRequest.Builder().get(uri).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) httpRpcClient).build();
        m40324a(str);
        this.f56000g.put(str, (HttpRpcRequest) httpRpcClient.newRpc(build).enqueue(new PoiBaseApiImpl$15(this, iHttpListener)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[SYNTHETIC, Splitter:B:24:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3 A[SYNTHETIC, Splitter:B:32:0x00d3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fetchDestPoiInfo(com.sdk.poibase.model.destpoi.DestPoiInfoParam r10, com.sdk.poibase.model.IHttpListener<com.sdk.poibase.model.destpoi.DestPoiReverseInfo> r11) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f55997d
            java.util.HashMap r0 = r10.getParamMap(r0)
            java.util.HashMap r10 = r10.getBodyMap()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r9.f55999f
            r1.append(r2)
            java.lang.String r2 = "/mapapi/destinfo"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.net.Uri r2 = android.net.Uri.parse(r1)
            java.lang.String r2 = r2.getScheme()
            android.net.Uri r3 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.util.Set r4 = r0.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0035:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.get(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = ""
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r3.appendQueryParameter(r5, r6)
            goto L_0x0035
        L_0x005a:
            r0 = 0
            com.didichuxing.foundation.net.rpc.http.FormSerializer r4 = new com.didichuxing.foundation.net.rpc.http.FormSerializer     // Catch:{ IOException -> 0x0082 }
            r4.<init>()     // Catch:{ IOException -> 0x0082 }
            java.io.InputStream r10 = r4.serialize(r10)     // Catch:{ IOException -> 0x0082 }
            int r4 = r10.available()     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            byte[] r0 = new byte[r4]     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            r10.read(r0)     // Catch:{ IOException -> 0x007b, all -> 0x0078 }
            if (r10 == 0) goto L_0x0092
            r10.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0092
        L_0x0073:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x0092
        L_0x0078:
            r11 = move-exception
            r0 = r10
            goto L_0x00d1
        L_0x007b:
            r4 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x0084
        L_0x0080:
            r11 = move-exception
            goto L_0x00d1
        L_0x0082:
            r4 = move-exception
            r10 = r0
        L_0x0084:
            r4.printStackTrace()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0091:
            r0 = r10
        L_0x0092:
            android.net.Uri r10 = r3.build()
            java.lang.String r10 = r10.toString()
            com.didichuxing.foundation.rpc.RpcServiceFactory r3 = r9.factory
            com.didichuxing.foundation.rpc.RpcClient r2 = r3.getRpcClient(r2)
            com.didichuxing.foundation.net.rpc.http.HttpRpcClient r2 = (com.didichuxing.foundation.net.rpc.http.HttpRpcClient) r2
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r3 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder
            r3.<init>()
            java.lang.String r4 = "application/x-www-form-urlencoded"
            com.didichuxing.foundation.net.http.HttpBody r0 = com.didichuxing.foundation.net.http.HttpBody.newInstance((java.lang.String) r4, (byte[]) r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r10 = r3.post(r10, r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r10 = r10.setRpcClient((com.didichuxing.foundation.rpc.RpcClient<? extends com.didichuxing.foundation.rpc.RpcRequest, ? extends com.didichuxing.foundation.rpc.RpcResponse>) r2)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r10 = r10.build()
            r9.m40324a((java.lang.String) r1)
            com.didichuxing.foundation.net.rpc.http.HttpRpc r10 = r2.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r10)
            com.sdk.poibase.PoiBaseApiImpl$16 r0 = new com.sdk.poibase.PoiBaseApiImpl$16
            r0.<init>(r9, r11)
            java.lang.Object r10 = r10.enqueue(r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r10 = (com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r10
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.didichuxing.foundation.net.rpc.http.HttpRpcRequest> r11 = r9.f56000g
            r11.put(r1, r10)
            return
        L_0x00d1:
            if (r0 == 0) goto L_0x00db
            r0.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00db:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.C20512a.fetchDestPoiInfo(com.sdk.poibase.model.destpoi.DestPoiInfoParam, com.sdk.poibase.model.IHttpListener):void");
    }
}

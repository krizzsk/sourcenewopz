package com.didi.addressold.model;

import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.util.ArrayList;

public interface ISelectAddressModel {
    void cacheStartPoiInfo(Address address);

    void deleteCommonAddress(AddressParam addressParam, ResultCallback<RpcCommon> resultCallback);

    void deleteFavoritePlace(AddressParam addressParam, String str, ResultCallback<RpcCommon> resultCallback);

    void getCommonAddress(AddressParam addressParam, ResultCallback<RpcCommon> resultCallback);

    RpcCommon getCommonAddressCache(String str);

    void getGeocodeResult(AddressParam addressParam, RpcPoi rpcPoi, ResultCallback<RpcRecSug> resultCallback);

    void getRecommendPoiList(AddressParam addressParam, ResultCallback<RpcRecSug> resultCallback);

    ArrayList<RpcPoi> getRecommendPoisCache(int i);

    void getStartPoiInfo(AddressParam addressParam, IHttpListener<ReverseGeoResult> iHttpListener);

    Address getStartPoiInfoFromCache(Address address);

    void getSuggestPoiList(AddressParam addressParam, ResultCallback<RpcRecSug> resultCallback);

    void recordClickPoi(AddressParam addressParam, RpcPoiBaseInfo rpcPoiBaseInfo);

    void setCommonAddress(AddressParam addressParam, RpcPoi rpcPoi, ResultCallback<RpcCommon> resultCallback);

    void setCommonAddressCache(String str, RpcCommon rpcCommon);

    void setRecommendPoiCache(int i, ArrayList<RpcPoi> arrayList);

    void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z, ResultCallback<HttpResultBase> resultCallback);

    void uploadPoi(AddressParam addressParam, ResultCallback<String> resultCallback);
}

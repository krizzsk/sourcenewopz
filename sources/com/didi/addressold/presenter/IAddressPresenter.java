package com.didi.addressold.presenter;

import com.didi.address.model.SugParams;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;

public interface IAddressPresenter {
    void cacheStartPoiInfo(Address address);

    void fetchStartPoiInfo(SugParams sugParams);

    void getGeocodeResult(SugParams sugParams, RpcPoi rpcPoi, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2, int i3);

    void getRecommendPoiList(SugParams sugParams, boolean z, int i);

    Address getStartPoiFromCache(Address address);

    void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i);

    void onLogout(SugParams sugParams);

    void onResume();

    void onStop();

    void recordClickPoi(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo);

    void setCommonAddress(SugParams sugParams, RpcPoi rpcPoi);

    void startRevertGeo(SugParams sugParams);

    void stopFetchStartPoiInfo();

    void stopRevertGeo();

    void uploadPoi(SugParams sugParams, RpcPoi rpcPoi);
}

package com.didi.addressnew.presenter;

import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;

public interface IAddressPresenter {
    void fetchStartPoiInfo(SugParams sugParams);

    void getGeocodeResult(SugParams sugParams, RpcPoi rpcPoi, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2, int i3, GeoCodeReActor geoCodeReActor);

    void getRecommendPoiList(SugParams sugParams, boolean z, int i);

    void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i);

    void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i, boolean z2);

    void onLogout(SugParams sugParams);

    void onResume();

    void onStop();

    void recordClickPoi(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo);

    void setCommonAddress(SugParams sugParams, RpcPoi rpcPoi);

    void startRevertGeo(SugParams sugParams);

    void stopFetchStartPoiInfo();

    void stopRevertGeo();

    void uploadPoi(SugParams sugParams, RpcPoi rpcPoi);

    void verifyStationAddress(SugParams sugParams, RpcPoi rpcPoi);
}

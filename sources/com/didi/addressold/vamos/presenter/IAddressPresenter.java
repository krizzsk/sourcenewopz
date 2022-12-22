package com.didi.addressold.vamos.presenter;

import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;

public interface IAddressPresenter {
    void cacheStartPoiInfo(Address address);

    void getGeocodeResult(AddressParam addressParam, RpcPoi rpcPoi, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2, int i3);

    void getRecommendPoiList(AddressParam addressParam, boolean z, int i);

    Address getStartPoiFromCache(Address address);

    void getSuggestPoiList(AddressParam addressParam, String str, boolean z, int i);

    void onLogout(AddressParam addressParam);

    void onResume();

    void onStop();

    void recordClickPoi(AddressParam addressParam, RpcPoiBaseInfo rpcPoiBaseInfo);

    void setCommonAddress(AddressParam addressParam, RpcPoi rpcPoi);

    void startRevertGeo(AddressParam addressParam);

    void stopRevertGeo();

    void uploadPoi(AddressParam addressParam, RpcPoi rpcPoi);
}

package com.sdk.poibase;

import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.destpoi.DestPoiInfoParam;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import com.sdk.poibase.model.guideentrance.GuideEntranceParam;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import com.sdk.poibase.model.guideentrance.StreetCheckParam;
import com.sdk.poibase.model.guideentrance.StreetCheckResult;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.recoperation.RpcRecOperation;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;

public interface IPoiBaseApi {
    void checkStreetIsValid(StreetCheckParam streetCheckParam, IHttpListener<StreetCheckResult> iHttpListener);

    void deleteCommonAddress(AddressParam addressParam, IHttpListener<HttpResultBase> iHttpListener);

    void deleteFavoritePlace(AddressParam addressParam, String str, IHttpListener<HttpResultBase> iHttpListener);

    void fetchDestPoiInfo(DestPoiInfoParam destPoiInfoParam, IHttpListener<DestPoiReverseInfo> iHttpListener);

    void fetchPoiInfo(PoiInfoParam poiInfoParam, IHttpListener<ReverseStationsInfo> iHttpListener);

    void getCommonAddress(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener);

    void getGeocodeResult(AddressParam addressParam, RpcPoi rpcPoi, IHttpListener<RpcRecSug> iHttpListener);

    void getGuideEntrancePriority(GuideEntranceParam guideEntranceParam, IHttpListener<GuideEntranceResult> iHttpListener);

    void getRecommendList(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener);

    void getTextSearchList(AddressParam addressParam, IHttpListener<RpcRecSug> iHttpListener);

    void recPoiOperation(AddressParam addressParam, IHttpListener<RpcRecOperation> iHttpListener);

    void recordClickPoi(AddressParam addressParam, RpcPoiBaseInfo rpcPoiBaseInfo, IHttpListener<HttpResultBase> iHttpListener);

    void reverseGeo(ReverseGeoParam reverseGeoParam, IHttpListener<ReverseGeoResult> iHttpListener);

    void updateCommonAddress(AddressParam addressParam, RpcPoi rpcPoi, IHttpListener<HttpResultBase> iHttpListener);

    void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z, IHttpListener<HttpResultBase> iHttpListener);
}

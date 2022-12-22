package com.didi.travel.psnger.common.net.rpc;

import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;
import java.util.Map;

public interface IBaseCarRpcSerivice extends RpcService {
    @Path("passenger/pCancelOrder")
    @Post
    @Deserialization(StringDeserializer.class)
    void cancelOrder(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pCancelTrip")
    @Post
    @Deserialization(StringDeserializer.class)
    void cancelTrip(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportShuttle/checkAtAirport")
    @Deserialization(StringDeserializer.class)
    void checkAirportOrder(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pCheckOpenRide")
    @Post
    @Deserialization(StringDeserializer.class)
    void checkOpenRide(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pSubmitQuestionaire")
    @Post
    @Deserialization(StringDeserializer.class)
    void commitEvaluateQuestionData(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pConfirmPinCode")
    @Post
    @Deserialization(StringDeserializer.class)
    void confirmPinCode(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Serialization(FormSerializer.class)
    @Path("passenger/pNewOrder")
    @Post
    @Deserialization(StringDeserializer.class)
    void createOrder(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pSelectItem")
    @Deserialization(StringDeserializer.class)
    Object doBubbleSelect(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pComment")
    @Post
    @Deserialization(StringDeserializer.class)
    void doComment(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportInsureSubmit")
    @Deserialization(StringDeserializer.class)
    void doCommitFlightInsuranceInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pFeeObjection")
    @Deserialization(StringDeserializer.class)
    void doFeeObjection(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/getCityAirport")
    @Deserialization(StringDeserializer.class)
    void doGetAirportByCity(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportShuttle/getCityCarLevel")
    @Deserialization(StringDeserializer.class)
    void doGetAirportCityCarLevel(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetScenesConfig")
    @Deserialization(StringDeserializer.class)
    void doGetAirportConfig(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/getSceneCities")
    @Deserialization(StringDeserializer.class)
    void doGetCities(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/getFlights")
    @Deserialization(StringDeserializer.class)
    void doGetFlightInfoParams(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportAccountHistory")
    @Deserialization(StringDeserializer.class)
    void doGetFlightInsuranceHistoryInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportInsureStatus")
    @Deserialization(StringDeserializer.class)
    void doGetFlightInsuranceInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportShuttle/getOrderFlight")
    @Deserialization(StringDeserializer.class)
    void doGetFlightOrderInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pPrePay")
    @Post
    @Deserialization(StringDeserializer.class)
    void doGetGenPayParams(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pGetTipInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void doGetTipInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportEnter")
    @Deserialization(StringDeserializer.class)
    void doReportLaunchEvent(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/atFence")
    @Deserialization(StringDeserializer.class)
    Object getAtFence(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pGetCancelFeeHistory")
    @Deserialization(StringDeserializer.class)
    void getCancelFeeHistory(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pCarpoolDetail")
    @Deserialization(StringDeserializer.class)
    void getCarPoolDetail(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetComboInfo")
    @Deserialization(StringDeserializer.class)
    void getComboInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pHasCommented")
    @Post
    @Deserialization(StringDeserializer.class)
    void getCommentData(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pGetCommentOnPanel")
    @Post(contentType = "application/x-www-form-urlencoded")
    @Deserialization(StringDeserializer.class)
    void getCommentOnPanel(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pGetCommentTag")
    @Post
    @Deserialization(StringDeserializer.class)
    void getCommentTag(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetConfig")
    @Deserialization(StringDeserializer.class)
    void getConfig(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/custom/getServiceList")
    @Deserialization(StringDeserializer.class)
    void getCustomFeature(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Serialization(FormSerializer.class)
    @Path("other/pGetDeviceinfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void getDeviceInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.WORKER) RpcService.Callback<String> callback);

    @Path("other/pGetShareInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void getEndServiceShareInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetEnsureCoupon")
    @Deserialization(StringDeserializer.class)
    void getEnsureCoupon(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("core/pMultiEstimatePrice")
    @Deserialization(StringDeserializer.class)
    Object getEstimatePrice(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("iapetos/service/pGetQuestionaire")
    @Post
    @Deserialization(StringDeserializer.class)
    void getEvaluateQuestionData(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetFeeDetail")
    @Deserialization(StringDeserializer.class)
    void getFeeDetail(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pGetFeeTips")
    @Deserialization(StringDeserializer.class)
    void getFeeTips(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetFlag")
    @Deserialization(StringDeserializer.class)
    void getFlag(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pQueryAthena/guideInfo")
    @Deserialization(StringDeserializer.class)
    Object getGuideInfo(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetPanelConfig")
    @Deserialization(StringDeserializer.class)
    void getIMOrNOSecurityConfig(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pAirportClaimsEnter")
    @Deserialization(StringDeserializer.class)
    void getInsuranceOrderDetail(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("member/premier/privileges")
    @Deserialization(StringDeserializer.class)
    void getMemberData(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pGetRealTimePrice")
    @Post
    @Deserialization(StringDeserializer.class)
    void getOnServiceRealtimePrice(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pGetActivityInfo")
    @Post(contentType = "application/x-www-form-urlencoded")
    @Deserialization(StringDeserializer.class)
    void getOneKeyXConfig(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("core/pOrderDetail")
    @Deserialization(StringDeserializer.class)
    Object getOrderDetail(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pGetOrderMatchInfo")
    @Deserialization(StringDeserializer.class)
    Object getOrderExtraInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("core/pOrderStatus")
    @Post
    @Deserialization(StringDeserializer.class)
    void getOrderStatus(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pAuthorizedNickname")
    @Post
    @Deserialization(StringDeserializer.class)
    void getPassengerAuthorizedInfob(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("api/Brazil/getCompanyList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getPayEnterpriseCompanyList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("api/Brazil/getCostCenterList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getPayEnterpriseCostCenterList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("api/Brazil/getProjectList")
    @Post
    @Deserialization(StringDeserializer.class)
    void getPayEnterpriseProjectList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pQuestionNaire")
    @Deserialization(StringDeserializer.class)
    void getQuestionNaire(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pGetFenceInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void getQuotaFence(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("recommend")
    @Deserialization(StringDeserializer.class)
    void getRecommendDest(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("horae/v1/passenger/pGetTimeRanges")
    @Deserialization(StringDeserializer.class)
    void getRegionTimeRanges(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetRentedCity")
    @Deserialization(StringDeserializer.class)
    void getRentedCity(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/getSceneCities")
    @Deserialization(StringDeserializer.class)
    void getSceneCities(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pSnsConfig")
    @Deserialization(StringDeserializer.class)
    void getSnsConfig(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pGetCompanyGroup")
    @Post
    @Deserialization(StringDeserializer.class)
    void getTaxiCompanyList(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetWanliuInfo")
    @Deserialization(StringDeserializer.class)
    void getWanliuInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("other/pNotifyDriverOpenRide")
    @Deserialization(StringDeserializer.class)
    void notifyDriverPsgState(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetCarpoolReward")
    @Deserialization(StringDeserializer.class)
    void pGetCarpoolReward(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pAgentRemind")
    @Post(contentType = "application/x-www-form-urlencoded")
    @Deserialization(StringDeserializer.class)
    void paypAgentRemind(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pPrePayTips")
    @Post
    @Deserialization(StringDeserializer.class)
    void prePayTips(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetBookingEstimateInfo")
    @Deserialization(StringDeserializer.class)
    void requestAddressMapRouteForBooking(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pGetStationStatus")
    @Deserialization(StringDeserializer.class)
    Object requestGetStationStatus(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pAuthorizedNickname/update")
    @Post
    @Deserialization(StringDeserializer.class)
    void setPassengerAuthorizedNickName(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pUpdateDestination")
    @Post
    @Deserialization(StringDeserializer.class)
    void updateDestination(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pLogCollection")
    @Deserialization(StringDeserializer.class)
    void updateLocationFlag(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("passenger/pUpdateOrderInfo")
    @Deserialization(StringDeserializer.class)
    void updateOrderInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("passenger/pGetPayInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void updatePayInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pUpdateBoardingPoint")
    @Post
    @Deserialization(StringDeserializer.class)
    void updatePickUp(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("other/pUpdateWayPoints")
    @Post
    @Deserialization(StringDeserializer.class)
    void updateWayPoints(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Serialization(FormSerializer.class)
    @Path("other/pCheckCardNumber")
    @Post
    @Deserialization(StringDeserializer.class)
    void verifyCard(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}

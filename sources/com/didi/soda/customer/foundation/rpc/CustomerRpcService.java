package com.didi.soda.customer.foundation.rpc;

import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.customer.foundation.rpc.entity.AFGroupEntity;
import com.didi.soda.customer.foundation.rpc.entity.AbnormalItemsInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.AnchorInfo;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessFavorResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.CheckActivityResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity;
import com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity;
import com.didi.soda.customer.foundation.rpc.entity.DebtRepayEntity;
import com.didi.soda.customer.foundation.rpc.entity.FavoriteEntity;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.HistoryListEntity;
import com.didi.soda.customer.foundation.rpc.entity.IdentityEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.NumProtectPreCallEntity;
import com.didi.soda.customer.foundation.rpc.entity.OpenScreenEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderCancelEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderChangeAddress;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutListEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderListEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderReminderEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayTipResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.PopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.PreLoadEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchRecommendTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity;
import com.didi.soda.customer.foundation.rpc.entity.SendInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ServerConfigEntity;
import com.didi.soda.customer.foundation.rpc.entity.SideBarEntityV2;
import com.didi.soda.customer.foundation.rpc.entity.TabEntity;
import com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity;
import com.didi.soda.customer.foundation.rpc.entity.UploadPhotoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AbnormalItemOptEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.SearchPoiEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillAddTyingEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillNotifyEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams;
import com.didi.soda.customer.foundation.rpc.entity.bill.CPFInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.CutleryEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderHistoryEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.setting.SettingSwitchItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.setting.SettingSwitchListEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCountryListEntity;
import com.didi.soda.customer.foundation.rpc.interceptor.CustomerParamsInterceptor;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerAsyncDataDeserializer;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerDataDeserializer;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerFormSerializer;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerJsonObjectSerializer;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.home.policy.model.PrivacyContentEntity;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Retry;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.List;

@Interception({CustomerParamsInterceptor.class})
public interface CustomerRpcService extends RpcService {
    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/order/changeAddress")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc addressListCk(@BodyParameter("orderId") String str, @BodyParameter("aid") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderChangeAddress> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/order/addressList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc addressListShow(@BodyParameter("orderId") String str, @BodyParameter("createdAid") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderAddressListEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/bill/alert")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc billAlert(@BodyParameter("shopId") String str, @BodyParameter("cartId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<BillNotifyEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/bill/update")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc billUpdate(@BodyParameter("aid") String str, @BodyParameter("cartId") String str2, @BodyParameter("updateType") int i, @BodyParameter("payChannel") PayChannelEntity payChannelEntity, @BodyParameter("tipFee") TipFeeInfoEntity tipFeeInfoEntity, @BodyParameter("shopCoupon") CouponInfoEntity couponInfoEntity, @BodyParameter("platCoupon") CouponInfoEntity couponInfoEntity2, @BodyParameter("followingInfo") FollowingInfoEntity followingInfoEntity, @BodyParameter("remark") RemarkEntity remarkEntity, @BodyParameter("updateItem") BillUpdateParams billUpdateParams, @BodyParameter("delItem") BillDelItemEntity billDelItemEntity, @BodyParameter("deliveryMethod") DeliveryMethodEntity deliveryMethodEntity, @BodyParameter("abnormalItemOpt") AbnormalItemOptEntity abnormalItemOptEntity, @BodyParameter("rCoupon") CouponInfoEntity couponInfoEntity3, @BodyParameter("selectedAid") String str3, @BodyParameter("isOpenLocation") int i2, @BodyParameter("receivePhone") String str4, @BodyParameter("receiveCallingCode") String str5, @BodyParameter("cutlery") CutleryEntity cutleryEntity, @BodyParameter("addItem") BillAddTyingEntity billAddTyingEntity, @BodyParameter("scene") String str6, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/setAppLang")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc changeLanguage(@BodyParameter("newLocale") String str, @BodyParameter("newLang") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/activity/validate")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc checkActivityValidate(@BodyParameter("actInfo") ActInfoEntity actInfoEntity, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CheckActivityResultEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/common/privacyContent")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc checkPrivacyContent(@BodyParameter("appId") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<PrivacyContentEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/cart/clear")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc clearGlobalCartItem(@BodyParameter("cartId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/common/notifyConfirmation")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc commonNotifyConfirmation(@BodyParameter("status") int i, @BodyParameter("scene") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/address/create")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc createAddress(@BodyParameter("type") int i, @BodyParameter("poi") AddressEntity.PoiEntity poiEntity, @BodyParameter("houseNumber") String str, @BodyParameter("buildingName") String str2, @BodyParameter("userInfo") ContactEntity contactEntity, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/order/createV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc createOrderV2(@BodyParameter("shopId") String str, @BodyParameter("cartId") String str2, @BodyParameter("sn") String str3, @BodyParameter("preOrderId") String str4, @BodyParameter("aid") String str5, @BodyParameter("duplicateOrderConfirm") int i, @BodyParameter("adultConfirmStatus") int i2, @BodyParameter("etaConfirm") int i3, @BodyParameter("userInfo") ContactEntity contactEntity, @BodyParameter("dataAudit") String str6, @BodyParameter("deviceToken") String str7, @BodyParameter("noCapacityConfirm") int i4, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<OrderInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/debt/repay")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc debtRepay(@BodyParameter("orderId") String str, @BodyParameter("debtId") String str2, @BodyParameter("payChannel") PayChannelEntity payChannelEntity, @BodyParameter("deviceToken") String str3, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<DebtRepayEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/delete")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc deleteAddress(@BodyParameter("aid") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/cancel")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc doCancelOrder(@BodyParameter("orderId") String str, @BodyParameter("paymentError") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderCancelEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/confirmMeal")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc doConfirmFinishOrder(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/sendReminder")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc doReminderOrder(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderReminderEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/bill/fastBuy")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fastBuy(@BodyParameter("shopId") String str, @BodyParameter("aid") String str2, @BodyParameter("nodeList") List<ItemNodeEntity> list, @BodyParameter("wineConfirm") int i, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @BodyParameter("selectedAid") String str3, @BodyParameter("isOpenLocation") int i2, @BodyParameter("receivePhone") String str4, @BodyParameter("receiveCallingCode") String str5, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/bill/info")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fetchBillInfo(@BodyParameter("cartId") String str, @BodyParameter("aid") String str2, @BodyParameter("orderId") String str3, @BodyParameter("selectedAid") String str4, @BodyParameter("isOpenLocation") int i, @BodyParameter("sceneType") int i2, @BodyParameter("sceneParams") SceneParamsEntity sceneParamsEntity, @BodyParameter("receivePhone") String str5, @BodyParameter("receiveCallingCode") String str6, @BodyParameter("scene") String str7, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/user/adultValidation")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fetchCPFInfo(@BodyParameter("id_no") String str, @BodyParameter("birthday") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CPFInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/bill/list")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fetchGlobalCartListInfo(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<BillListInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/growth/common/popDialog")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fetchPopDialog(@BodyParameter("position") int i, @BodyParameter("popupExt") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/growth/common/popDialog")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc fetchPopDialog(@BodyParameter("position") int i, @BodyParameter("popupExt") String str, @BodyParameter("promoCode") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/act-api/api/activitypage/getAdGroup")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getAFGroupIdMap(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<AFGroupEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/activity/index")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getActivityList(@BodyParameter("activityId") String str, @BodyParameter("page") int i, @BodyParameter("count") int i2, @BodyParameter("filterList") String str2, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<ActivityInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/address/listPage")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getAddressAndHistoryList(@BodyParameter("lastPoi") AddressEntity.PoiEntity poiEntity, @BodyParameter("lastAid") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressPageListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/getCurrentPoi")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getAddressByLocation(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<HomeAddressEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/address/backToFront")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getBackToFrontAddressTip(@BodyParameter("lastPoi") AddressEntity.PoiEntity poiEntity, @BodyParameter("preLat") double d, @BodyParameter("preLng") double d2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressTipInfo> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/feed/topicIndexV3")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getBlocksTopicList(@BodyParameter("componentId") String str, @BodyParameter("page") int i, @BodyParameter("count") int i2, @BodyParameter("scene") int i3, @BodyParameter("recId") String str2, @BodyParameter("topicTitle") String str3, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @BodyParameter("tabId") String str4, @BodyParameter("reqType") int i4, @BodyParameter("filterList") String str5, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<ActivityInfoEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/shop/index")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getBusinessData(@BodyParameter("shopId") String str, @BodyParameter("biData") String str2, @BodyParameter("searchInfo") String str3, @BodyParameter("anchor") AnchorInfo anchorInfo, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @BodyParameter("redesignAb") int i, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<BusinessEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/cart/info")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCartInfo(@BodyParameter("shopId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CartInfoEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/cart/onceAgainOrder")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCartInfoForOneMoreOrder(@BodyParameter("shopId") String str, @BodyParameter("orderId") String str2, @BodyParameter("wineConfirm") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CartInfoEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/feed/cateIndex")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<HomeEntity> getCateIndex(@BodyParameter("filterList") String str, @BodyParameter("cateId") String str2, @BodyParameter("page") int i, @BodyParameter("count") int i2, @BodyParameter("recId") String str3);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/feed/collaborationRec")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCollaRec(@BodyParameter("currentShop") CoordShopRequestEntity coordShopRequestEntity, @BodyParameter("allShopIdList") List<String> list, @BodyParameter("nearbyShopList") List<CoordShopRequestEntity> list2, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<CoordShopEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerFormSerializer.class)
    @Path("/favor/listV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCollectionFeed(@BodyParameter("poiCityId") int i, @BodyParameter("page") int i2, @BodyParameter("recId") String str, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<FavoriteEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("user/getDataSendingInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getDataSendInfo(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<SendInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/setting/discountNewsInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getDiscountNewsSwitch(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<SettingSwitchListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/evaluation/index")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getEvaluationIndex(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderEvaluationEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/evaluation/evaluationInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getEvaluationInfo(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderEvaluationEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/item/detail")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getGoodsDetail(@BodyParameter("shopId") String str, @BodyParameter("itemId") String str2, @BodyParameter("mduId") String str3, @BodyParameter("cartId") String str4, @BodyParameter("source") int i, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @BodyParameter("itemDetailAb") boolean z, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<GoodsItemEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/preload")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getH5PreLoad(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<PreLoadEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("order/orderList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getHistoryList(@BodyParameter("timeMode") String str, @BodyParameter("pageNum") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<HistoryListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("order/orderListV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getHistoryListV2(@BodyParameter("pageNum") int i, @BodyParameter("needEvaluatePopUp") int i2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderHistoryEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/feed/indexV3")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<HomeEntity> getHomeFeedV3(@BodyParameter("scene") int i, @BodyParameter("lastPoi") AddressEntity.PoiEntity poiEntity, @BodyParameter("lastAid") String str, @BodyParameter("filterList") String str2, @BodyParameter("page") int i2, @BodyParameter("recId") String str3);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/bottomTab")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getHomeTab(@TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<TabEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerFormSerializer.class)
    @Path("/feed/topicIndexV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getHomeTopicFeedV2(@BodyParameter("page") int i, @BodyParameter("componentId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<HomeFeedEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/identity")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    @Retry(3)
    Rpc getIdentity(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<IdentityEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/activity/getOpenScreen")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOpenScreen(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<OpenScreenEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/detailBatch")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderDetailBatch(@BodyParameter("orderIds") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/pageBatch")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderLayoutBatch(@BodyParameter("orderIds") String str, @BodyParameter("needEvaluateSchema") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderLayoutListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/getMapInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderMapInfo(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderLayoutEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/pay/getPayInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getPayInfo(@BodyParameter("price") String str, @BodyParameter("scene") int i, @BodyParameter("aid") String str2, @BodyParameter("cartId") String str3, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<PayMethodListInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/getPersonalizedSettings")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getPersonalizedSwitch(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<SettingSwitchItemEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/popDialog")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getPopDialog(@BodyParameter("position") int i, @BodyParameter("order_id") String str, @BodyParameter("promoCode") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<PopDialogEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/virtualtel/preCall")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getProtectNum(@BodyParameter("orderId") String str, @BodyParameter("phone") String str2, @BodyParameter("callingCode") String str3, @BodyParameter("role") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<NumProtectPreCallEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/getReceiptReceiverInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getReceiptInfo(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderReceiptInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/reversePoi")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getReversePoi(@BodyParameter("selectLat") double d, @BodyParameter("selectLng") double d2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity.PoiEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/reversePoi")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getReversePoi(@BodyParameter("selectLat") double d, @BodyParameter("selectLng") double d2, @BodyParameter("selectCityId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity.PoiEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/feed/recommend")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getSearchRecommendTag(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<SearchRecommendTagEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/feed/searchV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getSearchResult(@BodyParameter("keywords") String str, @BodyParameter("filterList") String str2, @BodyParameter("page") int i, @BodyParameter("pageType") int i2, @BodyParameter("searchFrom") int i3, @BodyParameter("recId") String str3, @BodyParameter("hotWordsRecId") String str4, @BodyParameter("lastShopId") String str5, @BodyParameter("sugRecId") String str6, @BodyParameter("sugCkJson") String str7, @BodyParameter("recCk") String str8, @BodyParameter("lastQuery") String str9, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<SearchResultEntity> cRpcCallBackWithTraceId);

    @Serialization(CustomerFormSerializer.class)
    @Path("feed/searchSuggestion")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<SearchSuggestionEntity> getSearchSuggestion(@BodyParameter("q") String str, @BodyParameter("suggestionId") String str2, @BodyParameter("sugIndex") int i);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/config")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getServerConfig(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<ServerConfigEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/feed/serviceCityList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getServiceCityList(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<HomeServiceCountryListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/shop/search")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<BusinessSearchResultEntity> getShopSearchMenu(@BodyParameter("shopId") String str, @BodyParameter("keywords") String str2, @BodyParameter("wordsSourceType") int i, @BodyParameter("recId") String str3, @BodyParameter("traceCnt") int i2, @BodyParameter("redesignAb") int i3);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/textSearch")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<SearchPoiEntity> getTextSearch(@BodyParameter("query") String str);

    @Serialization(CustomerFormSerializer.class)
    @Path("/common/userCenter")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getUserCenter(@BodyParameter("needEvaluatePopUp") int i, @TargetThread(ThreadType.MAIN) CRpcCallBackWithTraceId<SideBarEntityV2> cRpcCallBackWithTraceId);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/order/abnormalItemsInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc gotoRefund(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AbnormalItemsInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/push/joinpush")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc joinPush(@BodyParameter("phone") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/getPayStatus")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc orderPay(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("policy/notifyMe")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc policyNotifyMe(@BodyParameter("callingCode") String str, @BodyParameter("phone") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/debt/repayFail")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc postDebtRepayFail(@BodyParameter("orderId") String str, @BodyParameter("debtId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/action/tabIn")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc postTabIn(@BodyParameter("pinLat") float f, @BodyParameter("pinLng") float f2, @BodyParameter("pl") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("act-api/growth/report/bannerExposure")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc reportPopDialogExposure(@BodyParameter("activityId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/growth/report/userEvent")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc reportUserEvent(@BodyParameter("eventCode") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/evaluation/evaluate")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc saveEvaluationInfo(@BodyParameter("orderId") String str, @BodyParameter("shop") ShopEvaluationEntity shopEvaluationEntity, @BodyParameter("rider") RiderEvaluationEntity riderEvaluationEntity, @BodyParameter("items") List<OrderEvaluationItemsListEntity> list, @BodyParameter("type") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderEvaluationResultEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/updateReceiptUp")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc saveReceiptInfo(@BodyParameter("receiptUp") String str, @BodyParameter("mail") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("user/sendData")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc sendData(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/order/sendReceiptV2")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc sendReceipt(@BodyParameter("orderIds") String str, @BodyParameter("mailAddress") String str2, @BodyParameter("receiptUp") String str3, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/favor/set")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc setBusinessFavor(@BodyParameter("shopId") String str, @BodyParameter("action") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<BusinessFavorResultEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/setting/setDiscountNews")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc setDiscountNewsSwitch(@BodyParameter("id") int i, @BodyParameter("switch") int i2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/cart/setItem")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc setItem(@BodyParameter("cartId") String str, @BodyParameter("shopId") String str2, @BodyParameter("mduId") String str3, @BodyParameter("nodeList") List<ItemNodeEntity> list, @BodyParameter("wineConfirm") Integer num, @BodyParameter("revision") String str4, @BodyParameter("biData") String str5, @BodyParameter("tyingItemsFlag") Integer num2, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CartInfoEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/cart/setItemsAmount")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc setItemsAmount(@BodyParameter("cartId") String str, @BodyParameter("content") List<SetItemAmountParams.Content> list, @BodyParameter("revision") String str2, @BodyParameter("biData") String str3, @BodyParameter("actInfo") ActInfoEntity actInfoEntity, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CartInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/updatePersonalizedSettings")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc setPersonalizedSwitch(@BodyParameter("recSwitch") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/tips/config")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc tipConfig(@BodyParameter("orderId") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<TipsConfigEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/tips/getPayStatus")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc tipPay(@BodyParameter("orderId") String str, @BodyParameter("tipFeeValue") long j, @BodyParameter("tipFeeType") int i, @BodyParameter("payCard") PayChannelEntity payChannelEntity, @BodyParameter("deviceToken") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<PayTipResultEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/address/update")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc updateAddress(@BodyParameter("type") int i, @BodyParameter("aid") String str, @BodyParameter("houseNumber") String str2, @BodyParameter("buildingName") String str3, @BodyParameter("userInfo") ContactEntity contactEntity, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("address/updateDeliveryMethod")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc updateDeliveryMethod(@BodyParameter("aid") String str, @BodyParameter("poi") AddressEntity.PoiEntity poiEntity, @BodyParameter("type") int i, @BodyParameter("remark") String str2, @BodyParameter("optionType") int i2, @BodyParameter("optionContentIsSelected") int i3, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Timeout(writeTimeout = 30000)
    @Path("/common/uploadbase64")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc updatePhoto(@BodyParameter("file") String str, @BodyParameter("type") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<UploadPhotoEntity> customerRpcCallback);
}

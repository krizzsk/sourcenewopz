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
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.home.policy.model.PrivacyContentEntity;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.List;

/* renamed from: com.didi.soda.customer.foundation.rpc.a */
/* compiled from: CustomerRpcManager */
class C13729a extends BaseRpcManager<CustomerRpcService> implements CustomerRpcService {
    C13729a() {
    }

    public Rpc getCartInfo(String str, CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        return getRpcService().getCartInfo(str, customerRpcCallback);
    }

    public Rpc getCartInfoForOneMoreOrder(String str, String str2, int i, CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        return getRpcService().getCartInfoForOneMoreOrder(str, str2, i, customerRpcCallback);
    }

    public Rpc changeLanguage(String str, String str2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().changeLanguage(str, str2, customerRpcCallback);
    }

    public Rpc createAddress(int i, AddressEntity.PoiEntity poiEntity, String str, String str2, ContactEntity contactEntity, CustomerRpcCallback<AddressEntity> customerRpcCallback) {
        return getRpcService().createAddress(i, poiEntity, str, str2, contactEntity, customerRpcCallback);
    }

    public Rpc createOrderV2(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, ContactEntity contactEntity, String str6, String str7, int i4, CRpcCallBackWithTraceId<OrderInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().createOrderV2(str, str2, str3, str4, str5, i, i2, i3, contactEntity, str6, str7, i4, cRpcCallBackWithTraceId);
    }

    public Rpc deleteAddress(String str, CustomerRpcCallback<AddressEntity> customerRpcCallback) {
        return getRpcService().deleteAddress(str, customerRpcCallback);
    }

    public Rpc doCancelOrder(String str, String str2, CustomerRpcCallback<OrderCancelEntity> customerRpcCallback) {
        return getRpcService().doCancelOrder(str, str2, customerRpcCallback);
    }

    public Rpc doConfirmFinishOrder(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().doConfirmFinishOrder(str, customerRpcCallback);
    }

    public Rpc doReminderOrder(String str, CustomerRpcCallback<OrderReminderEntity> customerRpcCallback) {
        return getRpcService().doReminderOrder(str, customerRpcCallback);
    }

    public Rpc getAddressAndHistoryList(AddressEntity.PoiEntity poiEntity, String str, CustomerRpcCallback<AddressPageListEntity> customerRpcCallback) {
        return getRpcService().getAddressAndHistoryList(poiEntity, str, customerRpcCallback);
    }

    public Rpc getAddressByLocation(CustomerRpcCallback<HomeAddressEntity> customerRpcCallback) {
        return getRpcService().getAddressByLocation(customerRpcCallback);
    }

    public Rpc getBusinessData(String str, String str2, String str3, AnchorInfo anchorInfo, ActInfoEntity actInfoEntity, int i, CRpcCallBackWithTraceId<BusinessEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getBusinessData(str, str2, str3, anchorInfo, actInfoEntity, i, cRpcCallBackWithTraceId);
    }

    public Rpc getGoodsDetail(String str, String str2, String str3, String str4, int i, ActInfoEntity actInfoEntity, boolean z, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
        return getRpcService().getGoodsDetail(str, str2, str3, str4, i, actInfoEntity, z, customerRpcCallback);
    }

    public Rpc getH5PreLoad(CustomerRpcCallback<PreLoadEntity> customerRpcCallback) {
        return getRpcService().getH5PreLoad(customerRpcCallback);
    }

    public Rpc getHistoryList(String str, int i, CustomerRpcCallback<HistoryListEntity> customerRpcCallback) {
        return getRpcService().getHistoryList(str, i, customerRpcCallback);
    }

    public Rpc getHistoryListV2(int i, int i2, CustomerRpcCallback<OrderHistoryEntity> customerRpcCallback) {
        return getRpcService().getHistoryListV2(i, i2, customerRpcCallback);
    }

    public CRpcResult<HomeEntity> getHomeFeedV3(int i, AddressEntity.PoiEntity poiEntity, String str, String str2, int i2, String str3) {
        return getRpcService().getHomeFeedV3(i, poiEntity, str, str2, i2, str3);
    }

    public Rpc getCollaRec(CoordShopRequestEntity coordShopRequestEntity, List<String> list, List<CoordShopRequestEntity> list2, CRpcCallBackWithTraceId<CoordShopEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getCollaRec(coordShopRequestEntity, list, list2, cRpcCallBackWithTraceId);
    }

    public CRpcResult<HomeEntity> getCateIndex(String str, String str2, int i, int i2, String str3) {
        return getRpcService().getCateIndex(str, str2, i, i2, str3);
    }

    public Rpc getHomeTopicFeedV2(int i, String str, CustomerRpcCallback<HomeFeedEntity> customerRpcCallback) {
        return getRpcService().getHomeTopicFeedV2(i, str, customerRpcCallback);
    }

    public Rpc getActivityList(String str, int i, int i2, String str2, CRpcCallBackWithTraceId<ActivityInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getActivityList(str, i, i2, str2, cRpcCallBackWithTraceId);
    }

    public Rpc getBlocksTopicList(String str, int i, int i2, int i3, String str2, String str3, ActInfoEntity actInfoEntity, String str4, int i4, String str5, CRpcCallBackWithTraceId<ActivityInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getBlocksTopicList(str, i, i2, i3, str2, str3, actInfoEntity, str4, i4, str5, cRpcCallBackWithTraceId);
    }

    public Rpc getCollectionFeed(int i, int i2, String str, CRpcCallBackWithTraceId<FavoriteEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getCollectionFeed(i, i2, str, cRpcCallBackWithTraceId);
    }

    public Rpc getIdentity(CustomerRpcCallback<IdentityEntity> customerRpcCallback) {
        return getRpcService().getIdentity(customerRpcCallback);
    }

    public Rpc getOpenScreen(CustomerRpcCallback<OpenScreenEntity> customerRpcCallback) {
        return getRpcService().getOpenScreen(customerRpcCallback);
    }

    public Rpc getOrderDetailBatch(String str, CustomerRpcCallback<OrderListEntity> customerRpcCallback) {
        return getRpcService().getOrderDetailBatch(str, customerRpcCallback);
    }

    public Rpc getOrderLayoutBatch(String str, int i, CustomerRpcCallback<OrderLayoutListEntity> customerRpcCallback) {
        return getRpcService().getOrderLayoutBatch(str, i, customerRpcCallback);
    }

    public Rpc getOrderMapInfo(String str, CustomerRpcCallback<OrderLayoutEntity> customerRpcCallback) {
        return getRpcService().getOrderMapInfo(str, customerRpcCallback);
    }

    public Rpc getPayInfo(String str, int i, String str2, String str3, CustomerRpcCallback<PayMethodListInfoEntity> customerRpcCallback) {
        return getRpcService().getPayInfo(str, i, str2, str3, customerRpcCallback);
    }

    public Rpc debtRepay(String str, String str2, PayChannelEntity payChannelEntity, String str3, CustomerRpcCallback<DebtRepayEntity> customerRpcCallback) {
        return getRpcService().debtRepay(str, str2, payChannelEntity, str3, customerRpcCallback);
    }

    public Rpc postDebtRepayFail(String str, String str2, CustomerRpcCallback<OrderInfoEntity> customerRpcCallback) {
        return getRpcService().postDebtRepayFail(str, str2, customerRpcCallback);
    }

    public Rpc getPopDialog(int i, String str, String str2, CustomerRpcCallback<PopDialogEntity> customerRpcCallback) {
        return getRpcService().getPopDialog(i, str, str2, customerRpcCallback);
    }

    public Rpc reportPopDialogExposure(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().reportPopDialogExposure(str, customerRpcCallback);
    }

    public Rpc clearGlobalCartItem(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().clearGlobalCartItem(str, customerRpcCallback);
    }

    public Rpc fetchGlobalCartListInfo(CustomerRpcCallback<BillListInfoEntity> customerRpcCallback) {
        return getRpcService().fetchGlobalCartListInfo(customerRpcCallback);
    }

    public Rpc getProtectNum(String str, String str2, String str3, int i, CustomerRpcCallback<NumProtectPreCallEntity> customerRpcCallback) {
        return getRpcService().getProtectNum(str, str2, str3, i, customerRpcCallback);
    }

    public Rpc getBackToFrontAddressTip(AddressEntity.PoiEntity poiEntity, double d, double d2, CustomerRpcCallback<AddressTipInfo> customerRpcCallback) {
        return getRpcService().getBackToFrontAddressTip(poiEntity, d, d2, customerRpcCallback);
    }

    public Rpc getSearchRecommendTag(CustomerRpcCallback<SearchRecommendTagEntity> customerRpcCallback) {
        return getRpcService().getSearchRecommendTag(customerRpcCallback);
    }

    public Rpc getSearchResult(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CRpcCallBackWithTraceId<SearchResultEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getSearchResult(str, str2, i, i2, i3, str3, str4, str5, str6, str7, str8, str9, cRpcCallBackWithTraceId);
    }

    public CRpcResult<SearchSuggestionEntity> getSearchSuggestion(String str, String str2, int i) {
        return getRpcService().getSearchSuggestion(str, str2, i);
    }

    public Rpc getServerConfig(CustomerRpcCallback<ServerConfigEntity> customerRpcCallback) {
        return getRpcService().getServerConfig(customerRpcCallback);
    }

    public Rpc getUserCenter(int i, CRpcCallBackWithTraceId<SideBarEntityV2> cRpcCallBackWithTraceId) {
        return getRpcService().getUserCenter(i, cRpcCallBackWithTraceId);
    }

    public Rpc getHomeTab(CRpcCallBackWithTraceId<TabEntity> cRpcCallBackWithTraceId) {
        return getRpcService().getHomeTab(cRpcCallBackWithTraceId);
    }

    public CRpcResult<SearchPoiEntity> getTextSearch(String str) {
        return getRpcService().getTextSearch(str);
    }

    public Rpc joinPush(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().joinPush(str, customerRpcCallback);
    }

    public Rpc orderPay(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().orderPay(str, customerRpcCallback);
    }

    public Rpc postTabIn(float f, float f2, String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().postTabIn(f, f2, str, customerRpcCallback);
    }

    public Rpc reportUserEvent(int i, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().reportUserEvent(i, customerRpcCallback);
    }

    public Rpc fetchPopDialog(int i, String str, String str2, CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback) {
        return getRpcService().fetchPopDialog(i, str, str2, customerRpcCallback);
    }

    public Rpc fetchPopDialog(int i, String str, CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback) {
        return getRpcService().fetchPopDialog(i, str, customerRpcCallback);
    }

    public Rpc updateDeliveryMethod(String str, AddressEntity.PoiEntity poiEntity, int i, String str2, int i2, int i3, CustomerRpcCallback<AddressEntity> customerRpcCallback) {
        return getRpcService().updateDeliveryMethod(str, poiEntity, i, str2, i2, i3, customerRpcCallback);
    }

    public Rpc tipConfig(String str, CustomerRpcCallback<TipsConfigEntity> customerRpcCallback) {
        return getRpcService().tipConfig(str, customerRpcCallback);
    }

    public Rpc tipPay(String str, long j, int i, PayChannelEntity payChannelEntity, String str2, CustomerRpcCallback<PayTipResultEntity> customerRpcCallback) {
        return getRpcService().tipPay(str, j, i, payChannelEntity, str2, customerRpcCallback);
    }

    public Rpc updateAddress(int i, String str, String str2, String str3, ContactEntity contactEntity, CustomerRpcCallback<AddressEntity> customerRpcCallback) {
        return getRpcService().updateAddress(i, str, str2, str3, contactEntity, customerRpcCallback);
    }

    public Rpc sendReceipt(String str, String str2, String str3, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().sendReceipt(str, str2, str3, customerRpcCallback);
    }

    public Rpc getReceiptInfo(CustomerRpcCallback<OrderReceiptInfoEntity> customerRpcCallback) {
        return getRpcService().getReceiptInfo(customerRpcCallback);
    }

    public Rpc saveReceiptInfo(String str, String str2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().saveReceiptInfo(str, str2, customerRpcCallback);
    }

    public Rpc getEvaluationIndex(String str, CustomerRpcCallback<OrderEvaluationEntity> customerRpcCallback) {
        return getRpcService().getEvaluationIndex(str, customerRpcCallback);
    }

    public Rpc saveEvaluationInfo(String str, ShopEvaluationEntity shopEvaluationEntity, RiderEvaluationEntity riderEvaluationEntity, List<OrderEvaluationItemsListEntity> list, int i, CustomerRpcCallback<OrderEvaluationResultEntity> customerRpcCallback) {
        return getRpcService().saveEvaluationInfo(str, shopEvaluationEntity, riderEvaluationEntity, list, i, customerRpcCallback);
    }

    public Rpc getEvaluationInfo(String str, CustomerRpcCallback<OrderEvaluationEntity> customerRpcCallback) {
        return getRpcService().getEvaluationInfo(str, customerRpcCallback);
    }

    public CRpcResult<BusinessSearchResultEntity> getShopSearchMenu(String str, String str2, int i, String str3, int i2, int i3) {
        return getRpcService().getShopSearchMenu(str, str2, i, str3, i2, i3);
    }

    public Rpc setBusinessFavor(String str, int i, CustomerRpcCallback<BusinessFavorResultEntity> customerRpcCallback) {
        return getRpcService().setBusinessFavor(str, i, customerRpcCallback);
    }

    public Rpc getDataSendInfo(CustomerRpcCallback<SendInfoEntity> customerRpcCallback) {
        return getRpcService().getDataSendInfo(customerRpcCallback);
    }

    public Rpc sendData(CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().sendData(customerRpcCallback);
    }

    public Rpc getServiceCityList(CustomerRpcCallback<HomeServiceCountryListEntity> customerRpcCallback) {
        return getRpcService().getServiceCityList(customerRpcCallback);
    }

    public Rpc getReversePoi(double d, double d2, String str, CustomerRpcCallback<AddressEntity.PoiEntity> customerRpcCallback) {
        return getRpcService().getReversePoi(d, d2, str, customerRpcCallback);
    }

    public Rpc getReversePoi(double d, double d2, CustomerRpcCallback<AddressEntity.PoiEntity> customerRpcCallback) {
        return getRpcService().getReversePoi(d, d2, customerRpcCallback);
    }

    public Rpc setDiscountNewsSwitch(int i, int i2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().setDiscountNewsSwitch(i, i2, customerRpcCallback);
    }

    public Rpc getDiscountNewsSwitch(CustomerRpcCallback<SettingSwitchListEntity> customerRpcCallback) {
        return getRpcService().getDiscountNewsSwitch(customerRpcCallback);
    }

    public Rpc setPersonalizedSwitch(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().setPersonalizedSwitch(str, customerRpcCallback);
    }

    public Rpc getPersonalizedSwitch(CustomerRpcCallback<SettingSwitchItemEntity> customerRpcCallback) {
        return getRpcService().getPersonalizedSwitch(customerRpcCallback);
    }

    public Rpc policyNotifyMe(String str, String str2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().policyNotifyMe(str, str2, customerRpcCallback);
    }

    public Rpc commonNotifyConfirmation(int i, String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().commonNotifyConfirmation(i, str, customerRpcCallback);
    }

    public Rpc fetchBillInfo(String str, String str2, String str3, String str4, int i, int i2, SceneParamsEntity sceneParamsEntity, String str5, String str6, String str7, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().fetchBillInfo(str, str2, str3, str4, i, i2, sceneParamsEntity, str5, str6, str7, cRpcCallBackWithTraceId);
    }

    public Rpc fetchCPFInfo(String str, String str2, CustomerRpcCallback<CPFInfoEntity> customerRpcCallback) {
        return getRpcService().fetchCPFInfo(str, str2, customerRpcCallback);
    }

    public Rpc fastBuy(String str, String str2, List<ItemNodeEntity> list, int i, ActInfoEntity actInfoEntity, String str3, int i2, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().fastBuy(str, str2, list, i, actInfoEntity, str3, i2, str4, str5, cRpcCallBackWithTraceId);
    }

    public Rpc billUpdate(String str, String str2, int i, PayChannelEntity payChannelEntity, TipFeeInfoEntity tipFeeInfoEntity, CouponInfoEntity couponInfoEntity, CouponInfoEntity couponInfoEntity2, FollowingInfoEntity followingInfoEntity, RemarkEntity remarkEntity, BillUpdateParams billUpdateParams, BillDelItemEntity billDelItemEntity, DeliveryMethodEntity deliveryMethodEntity, AbnormalItemOptEntity abnormalItemOptEntity, CouponInfoEntity couponInfoEntity3, String str3, int i2, String str4, String str5, CutleryEntity cutleryEntity, BillAddTyingEntity billAddTyingEntity, String str6, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        return getRpcService().billUpdate(str, str2, i, payChannelEntity, tipFeeInfoEntity, couponInfoEntity, couponInfoEntity2, followingInfoEntity, remarkEntity, billUpdateParams, billDelItemEntity, deliveryMethodEntity, abnormalItemOptEntity, couponInfoEntity3, str3, i2, str4, str5, cutleryEntity, billAddTyingEntity, str6, cRpcCallBackWithTraceId);
    }

    public Rpc billAlert(String str, String str2, CustomerRpcCallback<BillNotifyEntity> customerRpcCallback) {
        return getRpcService().billAlert(str, str2, customerRpcCallback);
    }

    public Rpc setItemsAmount(String str, List<SetItemAmountParams.Content> list, String str2, String str3, ActInfoEntity actInfoEntity, CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        return getRpcService().setItemsAmount(str, list, str2, str3, actInfoEntity, customerRpcCallback);
    }

    public Rpc setItem(String str, String str2, String str3, List<ItemNodeEntity> list, Integer num, String str4, String str5, Integer num2, ActInfoEntity actInfoEntity, CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        return getRpcService().setItem(str, str2, str3, list, num, str4, str5, num2, actInfoEntity, customerRpcCallback);
    }

    public Rpc gotoRefund(String str, CustomerRpcCallback<AbnormalItemsInfoEntity> customerRpcCallback) {
        return getRpcService().gotoRefund(str, customerRpcCallback);
    }

    public Rpc getAFGroupIdMap(CustomerRpcCallback<AFGroupEntity> customerRpcCallback) {
        return getRpcService().getAFGroupIdMap(customerRpcCallback);
    }

    public Rpc addressListShow(String str, String str2, CustomerRpcCallback<OrderAddressListEntity> customerRpcCallback) {
        return getRpcService().addressListShow(str, str2, customerRpcCallback);
    }

    public Rpc addressListCk(String str, String str2, CustomerRpcCallback<OrderChangeAddress> customerRpcCallback) {
        return getRpcService().addressListCk(str, str2, customerRpcCallback);
    }

    public Rpc checkPrivacyContent(int i, CustomerRpcCallback<PrivacyContentEntity> customerRpcCallback) {
        return getRpcService().checkPrivacyContent(i, customerRpcCallback);
    }

    public Rpc updatePhoto(String str, int i, CustomerRpcCallback<UploadPhotoEntity> customerRpcCallback) {
        return getRpcService().updatePhoto(str, i, customerRpcCallback);
    }

    public Rpc checkActivityValidate(ActInfoEntity actInfoEntity, CustomerRpcCallback<CheckActivityResultEntity> customerRpcCallback) {
        return getRpcService().checkActivityValidate(actInfoEntity, customerRpcCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomerRpcService getRpcService() {
        return (CustomerRpcService) SFRpcServiceFactory.getRpcService(CustomerRpcService.class, ApiUrlFactory.getCustomerApiDomain());
    }
}

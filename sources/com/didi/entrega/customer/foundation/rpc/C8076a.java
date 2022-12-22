package com.didi.entrega.customer.foundation.rpc;

import com.didi.entrega.address.data.entity.AddressCheckEntity;
import com.didi.entrega.address.list.component.feed.model.AddressPageListEntity;
import com.didi.entrega.address.list.component.search.model.SearchPoiEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.ServerConfigEntity;
import com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactListEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderListEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didi.entrega.foundation.rpc.entity.DebtRepayEntity;
import com.didi.entrega.foundation.rpc.entity.NumProtectPreCallEntity;
import com.didi.entrega.foundation.rpc.entity.OrderCancelEntity;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.foundation.rpc.entity.PayMethodListInfoEntity;
import com.didi.entrega.home.component.city.entity.HomeServiceCountryListEntity;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didichuxing.foundation.rpc.Rpc;

/* renamed from: com.didi.entrega.customer.foundation.rpc.a */
/* compiled from: CustomerRpcManager */
class C8076a extends BaseRpcManager<CustomerRpcService> implements CustomerRpcService {
    C8076a() {
    }

    public Rpc changeLanguage(String str, String str2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().changeLanguage(str, str2, customerRpcCallback);
    }

    public Rpc getServerConfig(CustomerRpcCallback<ServerConfigEntity> customerRpcCallback) {
        return getRpcService().getServerConfig(customerRpcCallback);
    }

    public Rpc billUpdate(String str, int i, AddressEntity addressEntity, AddressEntity addressEntity2, ContactStufEntity contactStufEntity, PayChannel payChannel, TipFeeInfo tipFeeInfo, CouponInfo couponInfo, CustomerRpcCallback<BillEntity> customerRpcCallback) {
        return getRpcService().billUpdate(str, i, addressEntity, addressEntity2, contactStufEntity, payChannel, tipFeeInfo, couponInfo, customerRpcCallback);
    }

    public Rpc billInfo(String str, AddressEntity addressEntity, AddressEntity addressEntity2, ContactStufEntity contactStufEntity, String str2, CustomerRpcCallback<BillEntity> customerRpcCallback) {
        return getRpcService().billInfo(str, addressEntity, addressEntity2, contactStufEntity, str2, customerRpcCallback);
    }

    public Rpc getPayInfo(String str, int i, String str2, CustomerRpcCallback<PayMethodListInfoEntity> customerRpcCallback) {
        return getRpcService().getPayInfo(str, i, str2, customerRpcCallback);
    }

    public CRpcResult<SearchPoiEntity> getAddressSearch(String str) {
        return getRpcService().getAddressSearch(str);
    }

    public Rpc getNearbyAddress(CustomerRpcCallback<AddressPageListEntity> customerRpcCallback) {
        return getRpcService().getNearbyAddress(customerRpcCallback);
    }

    public Rpc getAddressList(CustomerRpcCallback<AddressPageListEntity> customerRpcCallback) {
        return getRpcService().getAddressList(customerRpcCallback);
    }

    public Rpc checkAddress(double d, double d2, double d3, double d4, int i, int i2, CustomerRpcCallback<AddressCheckEntity> customerRpcCallback) {
        return getRpcService().checkAddress(d, d2, d3, d4, i, i2, customerRpcCallback);
    }

    public Rpc getCommonInfo(CustomerRpcCallback<CommonInfoEntity> customerRpcCallback) {
        return getRpcService().getCommonInfo(customerRpcCallback);
    }

    public Rpc getCommonCateInfo(String str, int i, CustomerRpcCallback<CommonInfoEntity> customerRpcCallback) {
        return getRpcService().getCommonCateInfo(str, i, customerRpcCallback);
    }

    public Rpc deleteContact(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().deleteContact(str, customerRpcCallback);
    }

    public Rpc getHistoryContactList(CustomerRpcCallback<ContactListEntity> customerRpcCallback) {
        return getRpcService().getHistoryContactList(customerRpcCallback);
    }

    public Rpc createOrder(String str, String str2, int i, String str3, String str4, CustomerRpcCallback<OrderCreateEntity> customerRpcCallback) {
        return getRpcService().createOrder(str, str2, i, str3, str4, customerRpcCallback);
    }

    public Rpc cancelOrder(String str, int i, CustomerRpcCallback<OrderCancelEntity> customerRpcCallback) {
        return getRpcService().cancelOrder(str, i, customerRpcCallback);
    }

    public CRpcResult<HomeFeedEntity> feedIndex() {
        return getRpcService().feedIndex();
    }

    public Rpc getOrderList(int i, CustomerRpcCallback<HistoryOrderListEntity> customerRpcCallback) {
        return getRpcService().getOrderList(i, customerRpcCallback);
    }

    public Rpc getOrderInfo(String str, int i, CustomerRpcCallback<OrderListItemEntity> customerRpcCallback) {
        return getRpcService().getOrderInfo(str, i, customerRpcCallback);
    }

    public Rpc getProtectNum(String str, String str2, String str3, int i, CustomerRpcCallback<NumProtectPreCallEntity> customerRpcCallback) {
        return getRpcService().getProtectNum(str, str2, str3, i, customerRpcCallback);
    }

    public Rpc debtRepay(String str, String str2, PayChannel payChannel, String str3, CustomerRpcCallback<DebtRepayEntity> customerRpcCallback) {
        return getRpcService().debtRepay(str, str2, payChannel, str3, customerRpcCallback);
    }

    public Rpc postDebtRepayFail(String str, String str2, CustomerRpcCallback<OrderCreateEntity> customerRpcCallback) {
        return getRpcService().postDebtRepayFail(str, str2, customerRpcCallback);
    }

    public Rpc getOrderDetailBatch(String str, CustomerRpcCallback<OrderListEntity> customerRpcCallback) {
        return getRpcService().getOrderDetailBatch(str, customerRpcCallback);
    }

    public Rpc getServiceCityList(CustomerRpcCallback<HomeServiceCountryListEntity> customerRpcCallback) {
        return getRpcService().getServiceCityList(customerRpcCallback);
    }

    public Rpc poiInfo(CustomerRpcCallback<BillEntity> customerRpcCallback) {
        return getRpcService().poiInfo(customerRpcCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomerRpcService getRpcService() {
        return (CustomerRpcService) SFRpcServiceFactory.getRpcService(CustomerRpcService.class, ApiUrlFactory.getCustomerApiDomain());
    }
}

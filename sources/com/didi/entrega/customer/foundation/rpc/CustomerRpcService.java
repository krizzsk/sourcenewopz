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
import com.didi.entrega.customer.foundation.rpc.interceptor.CustomerParamsInterceptor;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.serializer.CustomerAsyncDataDeserializer;
import com.didi.entrega.customer.foundation.rpc.serializer.CustomerDataDeserializer;
import com.didi.entrega.customer.foundation.rpc.serializer.CustomerFormSerializer;
import com.didi.entrega.customer.foundation.rpc.serializer.CustomerJsonObjectSerializer;
import com.didi.entrega.foundation.rpc.entity.DebtRepayEntity;
import com.didi.entrega.foundation.rpc.entity.NumProtectPreCallEntity;
import com.didi.entrega.foundation.rpc.entity.OrderCancelEntity;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.foundation.rpc.entity.PayMethodListInfoEntity;
import com.didi.entrega.home.component.city.entity.HomeServiceCountryListEntity;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;

@Interception({CustomerParamsInterceptor.class})
public interface CustomerRpcService extends RpcService {
    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/billInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc billInfo(@BodyParameter("cartId") String str, @BodyParameter("senderAddress") AddressEntity addressEntity, @BodyParameter("receiverAddress") AddressEntity addressEntity2, @BodyParameter("packageInfo") ContactStufEntity contactStufEntity, @BodyParameter("orderId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<BillEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/updateBill")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc billUpdate(@BodyParameter("cartId") String str, @BodyParameter("updateType") int i, @BodyParameter("senderAddress") AddressEntity addressEntity, @BodyParameter("receiverAddress") AddressEntity addressEntity2, @BodyParameter("packageInfo") ContactStufEntity contactStufEntity, @BodyParameter("payChannel") PayChannel payChannel, @BodyParameter("tipFee") TipFeeInfo tipFeeInfo, @BodyParameter("platCoupon") CouponInfo couponInfo, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<BillEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/orderCancel")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc cancelOrder(@BodyParameter("orderId") String str, @BodyParameter("cancelReasonId") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderCancelEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/user/setAppLang")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc changeLanguage(@BodyParameter("newLocale") String str, @BodyParameter("newLang") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/addressCheck")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc checkAddress(@BodyParameter("senderLat") double d, @BodyParameter("senderLng") double d2, @BodyParameter("receiverLat") double d3, @BodyParameter("receiverLng") double d4, @BodyParameter("fusionChannel") int i, @BodyParameter("sence") int i2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressCheckEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/orderCreate")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc createOrder(@BodyParameter("cartId") String str, @BodyParameter("sn") String str2, @BodyParameter("duplicateOrderConfirm") int i, @BodyParameter("preOrderId") String str3, @BodyParameter("deviceToken") String str4, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderCreateEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/repay")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc debtRepay(@BodyParameter("orderId") String str, @BodyParameter("debtId") String str2, @BodyParameter("payChannel") PayChannel payChannel, @BodyParameter("deviceToken") String str3, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<DebtRepayEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/addressDel")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc deleteContact(@BodyParameter("aid") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/index")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<HomeFeedEntity> feedIndex();

    @Serialization(CustomerFormSerializer.class)
    @Path("entrega/addressList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getAddressList(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressPageListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/address/textSearch")
    @Post
    @Deserialization(CustomerAsyncDataDeserializer.class)
    CRpcResult<SearchPoiEntity> getAddressSearch(@BodyParameter("query") String str);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/getCateInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCommonCateInfo(@BodyParameter("cartId") String str, @BodyParameter("fusionChannel") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<CommonInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/commonInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getCommonInfo(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<CommonInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/contactList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getHistoryContactList(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<ContactListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/addressNearBy")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getNearbyAddress(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<AddressPageListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/orderDetail")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderDetailBatch(@BodyParameter("orderIds") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/getOrderInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderInfo(@BodyParameter("orderId") String str, @BodyParameter("cityId") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderListItemEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/orderList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getOrderList(@BodyParameter("pageNum") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<HistoryOrderListEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/payMethodList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getPayInfo(@BodyParameter("price") String str, @BodyParameter("scene") int i, @BodyParameter("cartId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<PayMethodListInfoEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/virtualTelPreCall")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getProtectNum(@BodyParameter("orderId") String str, @BodyParameter("phone") String str2, @BodyParameter("callingCode") String str3, @BodyParameter("role") int i, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<NumProtectPreCallEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/config")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getServerConfig(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<ServerConfigEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/serviceCityList")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc getServiceCityList(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<HomeServiceCountryListEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/entrega/poiInfo")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc poiInfo(@TargetThread(ThreadType.MAIN) CustomerRpcCallback<BillEntity> customerRpcCallback);

    @Serialization(CustomerJsonObjectSerializer.class)
    @Path("/entrega/repayFail")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc postDebtRepayFail(@BodyParameter("orderId") String str, @BodyParameter("debtId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<OrderCreateEntity> customerRpcCallback);
}

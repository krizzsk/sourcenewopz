package com.didi.soda.bill.manager;

import com.didi.soda.bill.dialog.entity.CommonConfirmationDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RiskControlEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004YZ[\\B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001c\u0010J\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001c\u0010M\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR\u001c\u0010P\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006]"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderState;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "adultConfirmStatus", "", "getAdultConfirmStatus", "()I", "setAdultConfirmStatus", "(I)V", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "cartId", "getCartId", "setCartId", "dataAudit", "getDataAudit", "setDataAudit", "deliveryType", "getDeliveryType", "()Ljava/lang/Integer;", "setDeliveryType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "duplicateOrderConfirm", "getDuplicateOrderConfirm", "setDuplicateOrderConfirm", "errorState", "Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorState;", "getErrorState", "()Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorState;", "setErrorState", "(Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorState;)V", "etaConfirm", "getEtaConfirm", "setEtaConfirm", "isTableWare", "", "()Z", "setTableWare", "(Z)V", "itemDetail", "getItemDetail", "setItemDetail", "noCapacityConfirm", "getNoCapacityConfirm", "setNoCapacityConfirm", "order", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "getOrder", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "setOrder", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;)V", "orderStatus", "getOrderStatus", "setOrderStatus", "payChannelEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannelEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannelEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "poiEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "getPoiEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "setPoiEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;)V", "preOrderId", "getPreOrderId", "setPreOrderId", "shopId", "getShopId", "setShopId", "sn", "getSn", "setSn", "traceId", "getTraceId", "setTraceId", "userInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "getUserInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "setUserInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;)V", "OrderErrorState", "OrderErrorType", "OrderRiskType", "OrderState", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderState.kt */
public final class CreateOrderState implements IEntity {
    private int adultConfirmStatus;
    private String aid = "";
    private String cartId = "";
    private String dataAudit;
    private Integer deliveryType = 0;
    private int duplicateOrderConfirm;
    private OrderErrorState errorState;
    private int etaConfirm;
    private boolean isTableWare;
    private String itemDetail;
    private int noCapacityConfirm;
    private OrderInfoEntity order;
    private String orderStatus = "none";
    private PayChannelEntity payChannelEntity;
    private AddressEntity.PoiEntity poiEntity;
    private String preOrderId = "";
    private String shopId = "";

    /* renamed from: sn */
    private String f39021sn = "";
    private String traceId = "";
    private ContactEntity userInfo;

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderStatus = str;
    }

    public final OrderErrorState getErrorState() {
        return this.errorState;
    }

    public final void setErrorState(OrderErrorState orderErrorState) {
        this.errorState = orderErrorState;
    }

    public final OrderInfoEntity getOrder() {
        return this.order;
    }

    public final void setOrder(OrderInfoEntity orderInfoEntity) {
        this.order = orderInfoEntity;
    }

    public final String getPreOrderId() {
        return this.preOrderId;
    }

    public final void setPreOrderId(String str) {
        this.preOrderId = str;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final void setCartId(String str) {
        this.cartId = str;
    }

    public final String getAid() {
        return this.aid;
    }

    public final void setAid(String str) {
        this.aid = str;
    }

    public final String getSn() {
        return this.f39021sn;
    }

    public final void setSn(String str) {
        this.f39021sn = str;
    }

    public final int getDuplicateOrderConfirm() {
        return this.duplicateOrderConfirm;
    }

    public final void setDuplicateOrderConfirm(int i) {
        this.duplicateOrderConfirm = i;
    }

    public final int getAdultConfirmStatus() {
        return this.adultConfirmStatus;
    }

    public final void setAdultConfirmStatus(int i) {
        this.adultConfirmStatus = i;
    }

    public final int getEtaConfirm() {
        return this.etaConfirm;
    }

    public final void setEtaConfirm(int i) {
        this.etaConfirm = i;
    }

    public final PayChannelEntity getPayChannelEntity() {
        return this.payChannelEntity;
    }

    public final void setPayChannelEntity(PayChannelEntity payChannelEntity2) {
        this.payChannelEntity = payChannelEntity2;
    }

    public final ContactEntity getUserInfo() {
        return this.userInfo;
    }

    public final void setUserInfo(ContactEntity contactEntity) {
        this.userInfo = contactEntity;
    }

    public final String getItemDetail() {
        return this.itemDetail;
    }

    public final void setItemDetail(String str) {
        this.itemDetail = str;
    }

    public final String getDataAudit() {
        return this.dataAudit;
    }

    public final void setDataAudit(String str) {
        this.dataAudit = str;
    }

    public final Integer getDeliveryType() {
        return this.deliveryType;
    }

    public final void setDeliveryType(Integer num) {
        this.deliveryType = num;
    }

    public final int getNoCapacityConfirm() {
        return this.noCapacityConfirm;
    }

    public final void setNoCapacityConfirm(int i) {
        this.noCapacityConfirm = i;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public final AddressEntity.PoiEntity getPoiEntity() {
        return this.poiEntity;
    }

    public final void setPoiEntity(AddressEntity.PoiEntity poiEntity2) {
        this.poiEntity = poiEntity2;
    }

    public final boolean isTableWare() {
        return this.isTableWare;
    }

    public final void setTableWare(boolean z) {
        this.isTableWare = z;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderState$OrderState;", "", "()V", "CREATING", "", "ERROR", "NONE", "SUCCESS", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderState.kt */
    public static final class OrderState {
        public static final String CREATING = "creating";
        public static final String ERROR = "error";
        public static final OrderState INSTANCE = new OrderState();
        public static final String NONE = "none";
        public static final String SUCCESS = "success";

        private OrderState() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorState;", "", "()V", "mDialogEntity", "Lcom/didi/soda/bill/dialog/entity/CommonConfirmationDialogEntity;", "getMDialogEntity", "()Lcom/didi/soda/bill/dialog/entity/CommonConfirmationDialogEntity;", "setMDialogEntity", "(Lcom/didi/soda/bill/dialog/entity/CommonConfirmationDialogEntity;)V", "mErrorCode", "", "getMErrorCode", "()I", "setMErrorCode", "(I)V", "mErrorMessage", "", "getMErrorMessage", "()Ljava/lang/String;", "setMErrorMessage", "(Ljava/lang/String;)V", "mErrorType", "getMErrorType", "setMErrorType", "mRisk", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/RiskControlEntity;", "getMRisk", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/RiskControlEntity;", "setMRisk", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/RiskControlEntity;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderState.kt */
    public static final class OrderErrorState {
        private CommonConfirmationDialogEntity mDialogEntity;
        private int mErrorCode;
        private String mErrorMessage;
        private int mErrorType;
        private RiskControlEntity mRisk;

        public final int getMErrorCode() {
            return this.mErrorCode;
        }

        public final void setMErrorCode(int i) {
            this.mErrorCode = i;
        }

        public final String getMErrorMessage() {
            return this.mErrorMessage;
        }

        public final void setMErrorMessage(String str) {
            this.mErrorMessage = str;
        }

        public final int getMErrorType() {
            return this.mErrorType;
        }

        public final void setMErrorType(int i) {
            this.mErrorType = i;
        }

        public final RiskControlEntity getMRisk() {
            return this.mRisk;
        }

        public final void setMRisk(RiskControlEntity riskControlEntity) {
            this.mRisk = riskControlEntity;
        }

        public final CommonConfirmationDialogEntity getMDialogEntity() {
            return this.mDialogEntity;
        }

        public final void setMDialogEntity(CommonConfirmationDialogEntity commonConfirmationDialogEntity) {
            this.mDialogEntity = commonConfirmationDialogEntity;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderState$OrderErrorType;", "", "()V", "CREATE_ORDDER_CHECK_RISK", "", "CREATE_ORDER_CHECK_CONTINUE_CREATE", "CREATE_ORDER_CHECK_DELIVERY_METHOD", "CREATE_ORDER_CHECK_DUPLICATED_ORDER", "CREATE_ORDER_CHECK_FORCE_QIUT_CART", "CREATE_ORDER_CHECK_MINOR_TIP", "CREATE_ORDER_CHECK_NOT_PAY", "CREATE_ORDER_CHECK_SHOW_ALERT_ONLY", "CREATE_ORDER_CHECK_VALIDATE_CARD", "CREATE_ORDER_CONNECT_ERROR", "CREATE_ORDER_EFO_STATE_ERROR", "CREATE_ORDER_MONEY_LOWER_THAN_PAY_CHANNEL", "CREATE_ORDER_NO_CAPACITY_CONFIRM", "CREATE_ORDER_REGULAR_INVALIDATION", "CREATE_ORDER_TO_EDIT_ADDRESS", "DEFAULT_SHOW_ALERT_FORCE_UPDATE", "LOGIN_ERROR", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderState.kt */
    public static final class OrderErrorType {
        public static final int CREATE_ORDDER_CHECK_RISK = 9;
        public static final int CREATE_ORDER_CHECK_CONTINUE_CREATE = 3;
        public static final int CREATE_ORDER_CHECK_DELIVERY_METHOD = 7;
        public static final int CREATE_ORDER_CHECK_DUPLICATED_ORDER = 6;
        public static final int CREATE_ORDER_CHECK_FORCE_QIUT_CART = 2;
        public static final int CREATE_ORDER_CHECK_MINOR_TIP = 8;
        public static final int CREATE_ORDER_CHECK_NOT_PAY = 4;
        public static final int CREATE_ORDER_CHECK_SHOW_ALERT_ONLY = 1;
        public static final int CREATE_ORDER_CHECK_VALIDATE_CARD = 5;
        public static final int CREATE_ORDER_CONNECT_ERROR = 13;
        public static final int CREATE_ORDER_EFO_STATE_ERROR = 10;
        public static final int CREATE_ORDER_MONEY_LOWER_THAN_PAY_CHANNEL = 14;
        public static final int CREATE_ORDER_NO_CAPACITY_CONFIRM = 11;
        public static final int CREATE_ORDER_REGULAR_INVALIDATION = 12;
        public static final int CREATE_ORDER_TO_EDIT_ADDRESS = 15;
        public static final int DEFAULT_SHOW_ALERT_FORCE_UPDATE = 0;
        public static final OrderErrorType INSTANCE = new OrderErrorType();
        public static final int LOGIN_ERROR = 65536;

        private OrderErrorType() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderState$OrderRiskType;", "", "()V", "RISK_CODE_CHANNEL_UNSED", "", "RISK_ID_CHECK_COUPON", "RISK_NEED_CHECK_ID", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderState.kt */
    public static final class OrderRiskType {
        public static final OrderRiskType INSTANCE = new OrderRiskType();
        public static final int RISK_CODE_CHANNEL_UNSED = 100007;
        public static final int RISK_ID_CHECK_COUPON = 10003;
        public static final int RISK_NEED_CHECK_ID = 100008;

        private OrderRiskType() {
        }
    }
}

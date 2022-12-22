package com.didi.soda.bill.manager;

import android.os.Bundle;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.soda.bill.manager.CreateOrderState;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0003\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderDispatcher;", "", "()V", "callback", "Lcom/didi/soda/bill/manager/CreateOrderCallback;", "createOrderState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "createOrder", "", "orderState", "dispatch", "action", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher$Action;", "Action", "ActionType", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderDispatcher.kt */
public final class CreateOrderDispatcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CreateOrderDispatcher";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CreateOrderState f39006a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreateOrderCallback f39007b;

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderDispatcher$ActionType;", "", "(Ljava/lang/String;I)V", "CREATE_ORDER", "CREATE_ORDER_ETA_CONFIRM", "CREATE_ORDER_DUPLICATE_CONFIRM", "CREATE_ORDER_MINOR", "CREATE_ORDER_LACK_RIDER", "CREATE_ORDER_SUCCESS", "CREATE_ORDER_ERROR", "CREATE_ORDER_VALIDATE_CARD", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderDispatcher.kt */
    public enum ActionType {
        CREATE_ORDER,
        CREATE_ORDER_ETA_CONFIRM,
        CREATE_ORDER_DUPLICATE_CONFIRM,
        CREATE_ORDER_MINOR,
        CREATE_ORDER_LACK_RIDER,
        CREATE_ORDER_SUCCESS,
        CREATE_ORDER_ERROR,
        CREATE_ORDER_VALIDATE_CARD
    }

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderDispatcher.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionType.values().length];
            iArr[ActionType.CREATE_ORDER.ordinal()] = 1;
            iArr[ActionType.CREATE_ORDER_ETA_CONFIRM.ordinal()] = 2;
            iArr[ActionType.CREATE_ORDER_DUPLICATE_CONFIRM.ordinal()] = 3;
            iArr[ActionType.CREATE_ORDER_VALIDATE_CARD.ordinal()] = 4;
            iArr[ActionType.CREATE_ORDER_MINOR.ordinal()] = 5;
            iArr[ActionType.CREATE_ORDER_LACK_RIDER.ordinal()] = 6;
            iArr[ActionType.CREATE_ORDER_SUCCESS.ordinal()] = 7;
            iArr[ActionType.CREATE_ORDER_ERROR.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CreateOrderDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CreateOrderDispatcher() {
    }

    public final void dispatch(Action<?> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        CreateOrderState createOrderState = null;
        switch (WhenMappings.$EnumSwitchMapping$0[action.getType().ordinal()]) {
            case 1:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER");
                CreateOrderState createOrderState2 = (CreateOrderState) action.getPayload();
                if (createOrderState2 != null) {
                    CreateOrderState createOrderState3 = this.f39006a;
                    if (createOrderState3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState3 = null;
                    }
                    createOrderState3.setShopId(createOrderState2.getShopId());
                    CreateOrderState createOrderState4 = this.f39006a;
                    if (createOrderState4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState4 = null;
                    }
                    createOrderState4.setCartId(createOrderState2.getCartId());
                    CreateOrderState createOrderState5 = this.f39006a;
                    if (createOrderState5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState5 = null;
                    }
                    createOrderState5.setSn(createOrderState2.getSn());
                    CreateOrderState createOrderState6 = this.f39006a;
                    if (createOrderState6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState6 = null;
                    }
                    createOrderState6.setAid(createOrderState2.getAid());
                    CreateOrderState createOrderState7 = this.f39006a;
                    if (createOrderState7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState7 = null;
                    }
                    createOrderState7.setPreOrderId(createOrderState2.getPreOrderId());
                    CreateOrderState createOrderState8 = this.f39006a;
                    if (createOrderState8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState8 = null;
                    }
                    createOrderState8.setDuplicateOrderConfirm(0);
                    CreateOrderState createOrderState9 = this.f39006a;
                    if (createOrderState9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState9 = null;
                    }
                    createOrderState9.setAdultConfirmStatus(0);
                    CreateOrderState createOrderState10 = this.f39006a;
                    if (createOrderState10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState10 = null;
                    }
                    createOrderState10.setEtaConfirm(0);
                    CreateOrderState createOrderState11 = this.f39006a;
                    if (createOrderState11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState11 = null;
                    }
                    createOrderState11.setPayChannelEntity(createOrderState2.getPayChannelEntity());
                    CreateOrderState createOrderState12 = this.f39006a;
                    if (createOrderState12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState12 = null;
                    }
                    createOrderState12.setUserInfo(createOrderState2.getUserInfo());
                    CreateOrderState createOrderState13 = this.f39006a;
                    if (createOrderState13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState13 = null;
                    }
                    createOrderState13.setItemDetail(createOrderState2.getItemDetail());
                    CreateOrderState createOrderState14 = this.f39006a;
                    if (createOrderState14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState14 = null;
                    }
                    createOrderState14.setDataAudit(createOrderState2.getDataAudit());
                    CreateOrderState createOrderState15 = this.f39006a;
                    if (createOrderState15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState15 = null;
                    }
                    createOrderState15.setDeliveryType(createOrderState2.getDeliveryType());
                    CreateOrderState createOrderState16 = this.f39006a;
                    if (createOrderState16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState16 = null;
                    }
                    m27695a(createOrderState16);
                    CreateOrderState createOrderState17 = this.f39006a;
                    if (createOrderState17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState17 = null;
                    }
                    createOrderState17.setOrderStatus(CreateOrderState.OrderState.CREATING);
                    CreateOrderCallback createOrderCallback = this.f39007b;
                    if (createOrderCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        createOrderCallback = null;
                    }
                    CreateOrderState createOrderState18 = this.f39006a;
                    if (createOrderState18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    } else {
                        createOrderState = createOrderState18;
                    }
                    createOrderCallback.onCreateOrderIng(createOrderState);
                    return;
                }
                return;
            case 2:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_ETA_CONFIRM");
                CreateOrderState createOrderState19 = this.f39006a;
                if (createOrderState19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState19 = null;
                }
                createOrderState19.setEtaConfirm(1);
                CreateOrderState createOrderState20 = this.f39006a;
                if (createOrderState20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState20 = null;
                }
                m27695a(createOrderState20);
                CreateOrderState createOrderState21 = this.f39006a;
                if (createOrderState21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState21 = null;
                }
                createOrderState21.setOrderStatus(CreateOrderState.OrderState.CREATING);
                CreateOrderCallback createOrderCallback2 = this.f39007b;
                if (createOrderCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    createOrderCallback2 = null;
                }
                CreateOrderState createOrderState22 = this.f39006a;
                if (createOrderState22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                } else {
                    createOrderState = createOrderState22;
                }
                createOrderCallback2.onCreateOrderIng(createOrderState);
                return;
            case 3:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_DUPLICATE_CONFIRM");
                CreateOrderState createOrderState23 = this.f39006a;
                if (createOrderState23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState23 = null;
                }
                createOrderState23.setDuplicateOrderConfirm(1);
                CreateOrderState createOrderState24 = this.f39006a;
                if (createOrderState24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState24 = null;
                }
                m27695a(createOrderState24);
                CreateOrderState createOrderState25 = this.f39006a;
                if (createOrderState25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState25 = null;
                }
                createOrderState25.setOrderStatus(CreateOrderState.OrderState.CREATING);
                CreateOrderCallback createOrderCallback3 = this.f39007b;
                if (createOrderCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    createOrderCallback3 = null;
                }
                CreateOrderState createOrderState26 = this.f39006a;
                if (createOrderState26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                } else {
                    createOrderState = createOrderState26;
                }
                createOrderCallback3.onCreateOrderIng(createOrderState);
                return;
            case 4:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_VALIDATE_CARD");
                CreateOrderState createOrderState27 = this.f39006a;
                if (createOrderState27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState27 = null;
                }
                m27695a(createOrderState27);
                CreateOrderState createOrderState28 = this.f39006a;
                if (createOrderState28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState28 = null;
                }
                createOrderState28.setOrderStatus(CreateOrderState.OrderState.CREATING);
                CreateOrderCallback createOrderCallback4 = this.f39007b;
                if (createOrderCallback4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    createOrderCallback4 = null;
                }
                CreateOrderState createOrderState29 = this.f39006a;
                if (createOrderState29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                } else {
                    createOrderState = createOrderState29;
                }
                createOrderCallback4.onCreateOrderIng(createOrderState);
                return;
            case 5:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_MINOR");
                CreateOrderState createOrderState30 = this.f39006a;
                if (createOrderState30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState30 = null;
                }
                createOrderState30.setAdultConfirmStatus(1);
                CreateOrderState createOrderState31 = this.f39006a;
                if (createOrderState31 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState31 = null;
                }
                m27695a(createOrderState31);
                CreateOrderState createOrderState32 = this.f39006a;
                if (createOrderState32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState32 = null;
                }
                createOrderState32.setOrderStatus(CreateOrderState.OrderState.CREATING);
                CreateOrderCallback createOrderCallback5 = this.f39007b;
                if (createOrderCallback5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    createOrderCallback5 = null;
                }
                CreateOrderState createOrderState33 = this.f39006a;
                if (createOrderState33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                } else {
                    createOrderState = createOrderState33;
                }
                createOrderCallback5.onCreateOrderIng(createOrderState);
                return;
            case 6:
                CreateOrderState createOrderState34 = this.f39006a;
                if (createOrderState34 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState34 = null;
                }
                createOrderState34.setNoCapacityConfirm(1);
                CreateOrderState createOrderState35 = this.f39006a;
                if (createOrderState35 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState35 = null;
                }
                m27695a(createOrderState35);
                CreateOrderState createOrderState36 = this.f39006a;
                if (createOrderState36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    createOrderState36 = null;
                }
                createOrderState36.setOrderStatus(CreateOrderState.OrderState.CREATING);
                CreateOrderCallback createOrderCallback6 = this.f39007b;
                if (createOrderCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    createOrderCallback6 = null;
                }
                CreateOrderState createOrderState37 = this.f39006a;
                if (createOrderState37 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                } else {
                    createOrderState = createOrderState37;
                }
                createOrderCallback6.onCreateOrderIng(createOrderState);
                return;
            case 7:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_SUCCESS");
                Object payload = action.getPayload();
                if (payload != null) {
                    OrderInfoEntity orderInfoEntity = (OrderInfoEntity) payload;
                    CreateOrderState createOrderState38 = this.f39006a;
                    if (createOrderState38 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState38 = null;
                    }
                    createOrderState38.setOrderStatus("success");
                    CreateOrderState createOrderState39 = this.f39006a;
                    if (createOrderState39 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState39 = null;
                    }
                    createOrderState39.setErrorState((CreateOrderState.OrderErrorState) null);
                    CreateOrderState createOrderState40 = this.f39006a;
                    if (createOrderState40 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState40 = null;
                    }
                    createOrderState40.setOrder(orderInfoEntity);
                    CreateOrderCallback createOrderCallback7 = this.f39007b;
                    if (createOrderCallback7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        createOrderCallback7 = null;
                    }
                    CreateOrderState createOrderState41 = this.f39006a;
                    if (createOrderState41 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    } else {
                        createOrderState = createOrderState41;
                    }
                    createOrderCallback7.onCreateOrderSuccess(createOrderState);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity");
            case 8:
                LogUtil.m29104i(TAG, "dispatch -> ActionType.CREATE_ORDER_ERROR");
                Bundle bundle = (Bundle) action.getPayload();
                if (bundle != null) {
                    String string = bundle.getString("preOrderId");
                    CreateOrderState createOrderState42 = this.f39006a;
                    if (createOrderState42 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState42 = null;
                    }
                    createOrderState42.setOrderStatus("error");
                    SFRpcException sFRpcException = (SFRpcException) bundle.getSerializable("exception");
                    CreateOrderState createOrderState43 = this.f39006a;
                    if (createOrderState43 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState43 = null;
                    }
                    createOrderState43.setErrorState(CreateOrderErrorHandler.Companion.classifyError(sFRpcException));
                    if (!(sFRpcException == null || sFRpcException.getResult() == null || !(sFRpcException.getResult().getData() instanceof OrderInfoEntity))) {
                        CreateOrderState createOrderState44 = this.f39006a;
                        if (createOrderState44 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                            createOrderState44 = null;
                        }
                        Object data = sFRpcException.getResult().getData();
                        if (data != null) {
                            createOrderState44.setOrder((OrderInfoEntity) data);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity");
                        }
                    }
                    CreateOrderState createOrderState45 = this.f39006a;
                    if (createOrderState45 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                        createOrderState45 = null;
                    }
                    createOrderState45.setPreOrderId(string);
                    CreateOrderCallback createOrderCallback8 = this.f39007b;
                    if (createOrderCallback8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                        createOrderCallback8 = null;
                    }
                    CreateOrderState createOrderState46 = this.f39006a;
                    if (createOrderState46 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
                    } else {
                        createOrderState = createOrderState46;
                    }
                    createOrderCallback8.onCreateOrderError(createOrderState);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m27695a(CreateOrderState createOrderState) {
        String deviceToken = DeviceTokenWrapper.getInstance().getDeviceToken();
        if (deviceToken == null) {
            deviceToken = "";
        }
        CustomerRpcManagerProxy.get().createOrderV2(createOrderState.getShopId(), createOrderState.getCartId(), createOrderState.getSn(), createOrderState.getPreOrderId(), createOrderState.getAid(), createOrderState.getDuplicateOrderConfirm(), createOrderState.getAdultConfirmStatus(), createOrderState.getEtaConfirm(), createOrderState.getUserInfo(), createOrderState.getDataAudit(), deviceToken, createOrderState.getNoCapacityConfirm(), new CreateOrderDispatcher$createOrder$1(createOrderState, this));
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderDispatcher$Action;", "T", "", "type", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher$ActionType;", "payload", "(Lcom/didi/soda/bill/manager/CreateOrderDispatcher$ActionType;Ljava/lang/Object;)V", "getPayload", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getType", "()Lcom/didi/soda/bill/manager/CreateOrderDispatcher$ActionType;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderDispatcher.kt */
    public static final class Action<T> {
        private final T payload;
        private final ActionType type;

        public Action(ActionType actionType, T t) {
            Intrinsics.checkNotNullParameter(actionType, "type");
            this.type = actionType;
            this.payload = t;
        }

        public final T getPayload() {
            return this.payload;
        }

        public final ActionType getType() {
            return this.type;
        }
    }

    @Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bJ\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\nJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bJ\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\nJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0017\u001a\u00020\u0016J\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderDispatcher$Companion;", "", "()V", "TAG", "", "assemble", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher;", "callback", "Lcom/didi/soda/bill/manager/CreateOrderCallback;", "createOrder", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher$Action;", "Lcom/didi/soda/bill/manager/CreateOrderState;", "param", "createOrderDuplicateConfirm", "createOrderError", "Landroid/os/Bundle;", "ex", "createOrderEtaConfirm", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "createOrderLackRider", "createOrderMinorConfirm", "createOrderSuccess", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "order", "createOrderValidateCard", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderDispatcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOrderDispatcher assemble(CreateOrderCallback createOrderCallback) {
            Intrinsics.checkNotNullParameter(createOrderCallback, "callback");
            CreateOrderDispatcher createOrderDispatcher = new CreateOrderDispatcher((DefaultConstructorMarker) null);
            createOrderDispatcher.f39006a = new CreateOrderState();
            createOrderDispatcher.f39007b = createOrderCallback;
            return createOrderDispatcher;
        }

        public final Action<CreateOrderState> createOrder(CreateOrderState createOrderState) {
            Intrinsics.checkNotNullParameter(createOrderState, "param");
            return new Action<>(ActionType.CREATE_ORDER, createOrderState);
        }

        public final Action<AddressEntity> createOrderEtaConfirm() {
            AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
            ActionType actionType = ActionType.CREATE_ORDER_ETA_CONFIRM;
            Intrinsics.checkNotNullExpressionValue(delieveryAddress, "currentAddress");
            return new Action<>(actionType, delieveryAddress);
        }

        public final Action<?> createOrderDuplicateConfirm() {
            return new Action<>(ActionType.CREATE_ORDER_DUPLICATE_CONFIRM, null);
        }

        public final Action<?> createOrderValidateCard() {
            return new Action<>(ActionType.CREATE_ORDER_VALIDATE_CARD, null);
        }

        public final Action<CreateOrderState> createOrderLackRider(CreateOrderState createOrderState) {
            Intrinsics.checkNotNullParameter(createOrderState, "param");
            return new Action<>(ActionType.CREATE_ORDER_LACK_RIDER, createOrderState);
        }

        public final Action<?> createOrderMinorConfirm() {
            return new Action<>(ActionType.CREATE_ORDER_MINOR, null);
        }

        public final Action<OrderInfoEntity> createOrderSuccess(OrderInfoEntity orderInfoEntity) {
            Intrinsics.checkNotNullParameter(orderInfoEntity, "order");
            return new Action<>(ActionType.CREATE_ORDER_SUCCESS, orderInfoEntity);
        }

        public final Action<Bundle> createOrderError(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "ex");
            return new Action<>(ActionType.CREATE_ORDER_ERROR, bundle);
        }
    }
}

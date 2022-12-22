package com.didi.entrega.bill.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.drouter.api.DRouter;
import com.didi.entrega.bill.model.BillTipModel;
import com.didi.entrega.billmap.BillMapStatusRepo;
import com.didi.entrega.billmap.BillMapView;
import com.didi.entrega.billmap.model.BillMapInfoModel;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.flutter.UniApiObserver;
import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.ReceiverPoi;
import com.didi.entrega.customer.foundation.rpc.entity.RuleDesc;
import com.didi.entrega.customer.foundation.rpc.entity.SenderPoi;
import com.didi.entrega.customer.foundation.rpc.entity.TopMapInfo;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.pay.ValidateCardHelper;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService;
import com.didi.entrega.uni_entrega_business.map.GLEUniMapService;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0015\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016J@\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016J,\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016J\"\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rH\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\"\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0016J\u001c\u0010$\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010(\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0016J&\u0010*\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J,\u0010+\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rH\u0016¨\u0006."}, mo175978d2 = {"Lcom/didi/entrega/bill/plugin/BillServiceImp;", "Lcom/didi/entrega/uni_entrega_business/bill/GLEUniBillNativeModuleService;", "Lcom/didi/entrega/uni_entrega_business/map/GLEUniMapService;", "Lcom/didi/entrega/customer/flutter/UniApiObserver;", "()V", "createdSuccessOrderInsertPool", "", "pageID", "", "orderDataJson", "enterCouponPage", "counponParamsJson", "result", "Lcom/didi/entrega/uni_entrega_business/bill/GLEUniBillNativeModuleService$Result;", "gotoPayMethodPage", "userPayGroupJson", "userPayInfoJson", "fromPage", "gotoTripPage", "orderInfo", "isApplePaySupportedWithNetworks", "supportedNetworks", "", "mapBestRectEdgeBottom", "topViewHeight", "", "bottomViewHeight", "queryPayWithpageID", "removeMapMarker", "routeToVerifyPageWithTypes", "PageID", "subList", "saveBillInfo", "billInfoModelJson", "showBillTippage", "pageParamsJson", "showPriceRulePage", "priceRuleJson", "updateBillMapWithBillAddressInfo", "addressInfoJson", "updateOrderPool", "orderID", "updatePayListWithPreInterface", "verifyRandomPayWithPayment", "paymentJson", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillServiceImp.kt */
public final class BillServiceImp extends UniApiObserver implements GLEUniBillNativeModuleService, GLEUniMapService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GET_PAY_STATUS = "getPayStatus";
    public static final String PAY_METHOD_CALL_BACK = "payMethodCallBack";
    public static final String REMOVE_MARKER = "removeMarker";
    public static final String SHOW_COUPON = "showCoupon";
    public static final String SHOW_TIP_PAGE = "showTipPage";

    public void isApplePaySupportedWithNetworks(String str, GLEUniBillNativeModuleService.Result<Boolean> result) {
    }

    public void updateOrderPool(String str, String str2) {
    }

    public void updatePayListWithPreInterface(String str, String str2, String str3) {
    }

    public void saveBillInfo(String str) {
        String str2;
        try {
            BillEntity billEntity = (BillEntity) GsonUtils.fromJson(str, BillEntity.class);
            ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
            if (billEntity == null) {
                str2 = null;
            } else {
                str2 = billEntity.getCartId();
            }
            iCustomerContactManager.updateCartId(str2);
            Map mapOf = MapsKt.mapOf(TuplesKt.m42317to(16, new BillServiceImp$saveBillInfo$1$addressInfo$1(iCustomerContactManager)), TuplesKt.m42317to(17, new BillServiceImp$saveBillInfo$1$packageInfo$1(iCustomerContactManager)));
            if (billEntity != null) {
                List<BillSectionEntity> sections = billEntity.getSections();
                if (sections != null) {
                    for (BillSectionEntity components : sections) {
                        List<BillComponentEntity> components2 = components.getComponents();
                        if (components2 != null) {
                            for (BillComponentEntity billComponentEntity : components2) {
                                Function1 function1 = (Function1) mapOf.get(Integer.valueOf(billComponentEntity.getType()));
                                if (function1 != null) {
                                    function1.invoke(billComponentEntity);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void queryPayWithpageID(String str, String str2, GLEUniBillNativeModuleService.Result<String> result) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("entity", (OrderCreateEntity) GsonUtils.fromJson(str2, OrderCreateEntity.class));
            notifyAllObserver(GET_PAY_STATUS, hashMap, new BillServiceImp$queryPayWithpageID$1(result));
        } catch (Exception unused) {
        }
    }

    public void createdSuccessOrderInsertPool(String str, String str2) {
        try {
            OrderCreateEntity orderCreateEntity = (OrderCreateEntity) GsonUtils.fromJson(str2, OrderCreateEntity.class);
            if (orderCreateEntity != null) {
                String orderId = orderCreateEntity.getOrderId();
                if (orderId != null) {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(orderId, 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void verifyRandomPayWithPayment(String str, String str2, GLEUniBillNativeModuleService.Result<Boolean> result) {
        try {
            PayChannel payChannel = (PayChannel) GsonUtils.fromJson(str2, PayChannel.class);
            if (payChannel != null) {
                String cardSuffix = payChannel.getCardSuffix();
                String str3 = "";
                if (cardSuffix == null) {
                    cardSuffix = str3;
                }
                String cardIndex = payChannel.getCardIndex();
                if (cardIndex != null) {
                    str3 = cardIndex;
                }
                ValidateCardHelper.validateCard(cardSuffix, str3, 102);
            }
        } catch (Exception unused) {
        }
    }

    public void routeToVerifyPageWithTypes(String str, String str2) {
        if (str2 != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("securitylist", (ArrayList) GsonUtils.fromJson(str2, ArrayList.class));
                DiRouter.request().path("securityPage").putBundle("bundle", bundle).open();
            } catch (Exception unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void showBillTippage(String str, String str2, GLEUniBillNativeModuleService.Result<String> result) {
        Map hashMap = new HashMap();
        try {
            JsonElement parse = new JsonParser().parse(str2);
            if (parse != null && parse.isJsonObject()) {
                Integer num = null;
                if (parse.getAsJsonObject().has("currency")) {
                    JsonPrimitive asJsonPrimitive = parse.getAsJsonObject().getAsJsonPrimitive("currency");
                    hashMap.put("currency", asJsonPrimitive == null ? null : asJsonPrimitive.getAsString());
                }
                if (parse.getAsJsonObject().has(Const.FlutterBundleKey.TIPFEEBASEPRICE)) {
                    JsonPrimitive asJsonPrimitive2 = parse.getAsJsonObject().getAsJsonPrimitive(Const.FlutterBundleKey.TIPFEEBASEPRICE);
                    if (asJsonPrimitive2 != null) {
                        num = Integer.valueOf(asJsonPrimitive2.getAsInt());
                    }
                    hashMap.put(Const.FlutterBundleKey.TIPFEEBASEPRICE, num);
                }
                if (parse.getAsJsonObject().has(Const.FlutterBundleKey.TIPFEEINFO)) {
                    hashMap.put(Const.FlutterBundleKey.TIPFEEINFO, GsonUtil.fromJson((JsonElement) parse.getAsJsonObject().getAsJsonObject(Const.FlutterBundleKey.TIPFEEINFO), (Type) BillTipModel.class));
                }
                UniApiObserver.notifyAllObserver$default(this, SHOW_TIP_PAGE, hashMap, (OnPluginResultListener) null, 4, (Object) null);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    public void showPriceRulePage(String str, String str2) {
        try {
            DiRouter.request().path("priceRuleDescPage").putSerializable("entity", (Serializable) GsonUtil.fromJson(str2, RuleDesc.class)).open();
        } catch (Exception unused) {
        }
    }

    public void enterCouponPage(String str, String str2, GLEUniBillNativeModuleService.Result<String> result) {
        HashMap hashMap = new HashMap();
        try {
            JsonElement parse = new JsonParser().parse(str2);
            if (parse != null && parse.isJsonObject()) {
                String str3 = null;
                if (parse.getAsJsonObject().has(Const.FlutterBundleKey.COUPON_ID)) {
                    JsonPrimitive asJsonPrimitive = parse.getAsJsonObject().getAsJsonPrimitive(Const.FlutterBundleKey.COUPON_ID);
                    String asString = asJsonPrimitive == null ? null : asJsonPrimitive.getAsString();
                    if (!TextUtils.isEmpty(asString)) {
                        hashMap.put("selected", asString);
                    }
                }
                if (parse.getAsJsonObject().has(Const.BundleKey.CART_ID)) {
                    Map map = hashMap;
                    JsonPrimitive asJsonPrimitive2 = parse.getAsJsonObject().getAsJsonPrimitive(Const.BundleKey.CART_ID);
                    if (asJsonPrimitive2 != null) {
                        str3 = asJsonPrimitive2.getAsString();
                    }
                    map.put("cart_id", str3);
                }
                hashMap.put("bill_coupon_type", "0");
                UniApiObserver.notifyAllObserver$default(this, SHOW_COUPON, hashMap, (OnPluginResultListener) null, 4, (Object) null);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public void gotoPayMethodPage(String str, String str2, String str3, String str4, GLEUniBillNativeModuleService.Result<String> result) {
        String encode = URLEncoder.encode(URLEncoder.encode(str3, "UTF-8"), "UTF-8");
        String encode2 = URLEncoder.encode(URLEncoder.encode(str2, "UTF-8"), "UTF-8");
        DRouter.build("GuaranaOneTravel://one/OpenCardList?user_pay_info_string=" + encode + "&user_pay_group_string=" + encode2 + "&noSwitchTab=1").start(GlobalContext.getFragment().getContext());
        Map hashMap = new HashMap();
        hashMap.put("fromPage", str4);
        UniApiObserver.notifyAllObserver$default(this, PAY_METHOD_CALL_BACK, hashMap, (OnPluginResultListener) null, 4, (Object) null);
    }

    public void gotoTripPage(String str, String str2, GLEUniBillNativeModuleService.Result<String> result) {
        Map map = (Map) GsonUtils.fromJson(str2, (Type) Map.class);
        String str3 = (String) map.get("orderId");
        String str4 = "";
        if (str3 == null) {
            str3 = str4;
        }
        String str5 = (String) map.get("productId");
        if (str5 != null) {
            str4 = str5;
        }
        DRouter.build("GuaranaOneTravel://one/EnterFlashOrder?orderid=" + str3 + "&productid=" + str4 + "&noSwitchTab=1&source=601").start();
    }

    public void updateBillMapWithBillAddressInfo(String str, String str2) {
        String str3;
        try {
            TopMapInfo topMapInfo = (TopMapInfo) GsonUtils.fromJson(str, TopMapInfo.class);
            BillMapInfoModel billMapInfoModel = new BillMapInfoModel();
            if (topMapInfo != null) {
                SenderPoi senderPoi = topMapInfo.getSenderPoi();
                if (senderPoi != null) {
                    billMapInfoModel.setSenderLatLng(new LatLng(senderPoi.getLat(), senderPoi.getLng()));
                    billMapInfoModel.setSenderDisplayName(senderPoi.getDisplayName());
                }
            }
            if (topMapInfo != null) {
                ReceiverPoi receiverPoi = topMapInfo.getReceiverPoi();
                if (receiverPoi != null) {
                    billMapInfoModel.setReceiverLatLng(new LatLng(receiverPoi.getLat(), receiverPoi.getLng()));
                    billMapInfoModel.setReceiverDisplayName(receiverPoi.getDisplayName());
                }
            }
            if (topMapInfo == null) {
                str3 = null;
            } else {
                str3 = topMapInfo.getEtaTips();
            }
            billMapInfoModel.setEtaTips(str3);
            ((BillMapStatusRepo) RepoFactory.getRepo(BillMapStatusRepo.class)).setValue(billMapInfoModel);
        } catch (Exception unused) {
        }
    }

    public void removeMapMarker(String str) {
        UniApiObserver.notifyAllObserver$default(this, REMOVE_MARKER, (Map) null, (OnPluginResultListener) null, 6, (Object) null);
    }

    public void mapBestRectEdgeBottom(double d, double d2, String str) {
        BillMapView.Companion.setMMapMarginBottom((float) d2);
        BillMapView.Companion.setMMapMarginTop((int) d);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/bill/plugin/BillServiceImp$Companion;", "", "()V", "GET_PAY_STATUS", "", "PAY_METHOD_CALL_BACK", "REMOVE_MARKER", "SHOW_COUPON", "SHOW_TIP_PAGE", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillServiceImp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

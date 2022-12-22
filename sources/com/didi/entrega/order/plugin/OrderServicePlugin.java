package com.didi.entrega.order.plugin;

import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.flutter.UniApiObserver;
import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.share.ShareHelper;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.order.data.OrderMapStatusRepo;
import com.didi.entrega.order.data.model.OrderMapStatusModel;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderService;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.web.model.ShareToolModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J,\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016J,\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0013H\u0016¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/entrega/order/plugin/OrderServicePlugin;", "Lcom/didi/entrega/customer/flutter/UniApiObserver;", "Lcom/didi/entrega/uni_entrega_business/order/GLEUniOrderService;", "()V", "contactByCall", "", "pageId", "", "phoneNumber", "contactByIm", "orderId", "contactByProtectedCall", "getOrderDataByLocal", "result", "Lcom/didi/entrega/uni_entrega_business/order/GLEUniOrderService$Result;", "onMapReset", "requestOrderDataByService", "shareData", "data", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderService.kt */
public final class OrderServicePlugin extends UniApiObserver implements GLEUniOrderService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIRECT_CONTACT = "directCall";
    public static final String ORDER_CONTACT = "contactIM";
    public static final String UPDATE_ORDER_INFO = "updateOrderInfoById";

    public void onMapReset(String str) {
        OrderMapStatusModel orderMapStatusModel = (OrderMapStatusModel) ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).getValue();
        if (orderMapStatusModel != null) {
            orderMapStatusModel.setManualRefresh(true);
        }
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).setValue(orderMapStatusModel);
    }

    public void getOrderDataByLocal(String str, String str2, GLEUniOrderService.Result<String> result) {
        OrderInfoEntity orderInfoById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderInfoById(str2);
        if (orderInfoById != null) {
            if (result != null) {
                result.success(GsonUtil.toJson(orderInfoById));
            }
        } else if (result != null) {
            result.success(null);
        }
    }

    public void requestOrderDataByService(String str, String str2, GLEUniOrderService.Result<String> result) {
        if (!getListeners().isEmpty()) {
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus("updateOrderInfoById", str), (Map) null, new OrderServicePlugin$requestOrderDataByService$1(result), 2, (Object) null);
        }
    }

    public void contactByCall(String str, String str2) {
        if (!getListeners().isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put(Const.PageParams.PHONE_NUMBER, str2);
            hashMap.put(Const.PageParams.CONTACT_TYPE, 22);
            UniApiObserver.notifyAllObserver$default(this, DIRECT_CONTACT, hashMap, (OnPluginResultListener) null, 4, (Object) null);
        }
    }

    public void contactByProtectedCall(String str, String str2) {
        if (!getListeners().isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put("orderId", str2);
            hashMap.put(Const.PageParams.CONTACT_TYPE, 22);
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus("contactIM", str), hashMap, (OnPluginResultListener) null, 4, (Object) null);
        }
    }

    public void contactByIm(String str, String str2) {
        if (!getListeners().isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put("orderId", str2);
            hashMap.put(Const.PageParams.CONTACT_ROLE, 2);
            hashMap.put(Const.PageParams.CONTACT_TYPE, 11);
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus("contactIM", str), hashMap, (OnPluginResultListener) null, 4, (Object) null);
        }
    }

    public void shareData(String str, Map<String, String> map) {
        String str2;
        String str3;
        ShareToolModel shareToolModel = new ShareToolModel();
        if (map == null) {
            str2 = null;
        } else {
            str2 = map.get("shareURL");
        }
        shareToolModel.url = str2;
        if (map == null) {
            str3 = null;
        } else {
            str3 = map.get("shareContent");
        }
        shareToolModel.content = str3;
        ShareHelper.getInstance().systemShare(GlobalContext.getContext(), shareToolModel, (ICallback.IPlatformShareCallback) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/order/plugin/OrderServicePlugin$Companion;", "", "()V", "DIRECT_CONTACT", "", "ORDER_CONTACT", "UPDATE_ORDER_INFO", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

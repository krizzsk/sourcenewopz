package com.didi.soda.order.flutterpage;

import com.didi.rlab.uni_customer_business.order_service.OrderService;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusRepo;
import com.didi.soda.customer.flutter.UniApiObserver;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.repo.RepoFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J4\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\n2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/order/flutterpage/NewOrderServicePlugin;", "Lcom/didi/rlab/uni_customer_business/order_service/OrderService;", "Lcom/didi/soda/customer/flutter/UniApiObserver;", "()V", "contactByCall", "", "pageId", "", "orderId", "contactRole", "", "contactByIm", "dismissFloatingPage", "goAppStoreRate", "onMapReset", "refreshIMUnreadCount", "sendReceipt", "status", "result", "Lcom/didi/rlab/uni_customer_business/order_service/OrderService$Result;", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NewOrderServicePlugin.kt */
public final class NewOrderServicePlugin extends UniApiObserver implements OrderService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GO_APP_STORE_RATE = "goAppStoreRate";
    public static final String ORDER_CONTACT = "contactIM";
    public static final String REFRESH_IM_UNREAD_COUNT = "refreshIMUnreadCount";

    public void dismissFloatingPage(String str) {
    }

    public void contactByIm(String str, String str2, long j) {
        Collection listeners = getListeners();
        if (!(listeners == null || listeners.isEmpty())) {
            Map hashMap = new HashMap();
            hashMap.put("orderid", str2);
            hashMap.put(Const.PageParams.CONTACT_ROLE, Long.valueOf(j));
            hashMap.put(Const.PageParams.CONTACT_TYPE, 11);
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus("contactIM", str), hashMap, (OnPluginResultListener) null, 4, (Object) null);
        }
    }

    public void onMapReset(String str) {
        OrderMapStatusModel orderMapStatusModel = (OrderMapStatusModel) ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).getValue();
        if (orderMapStatusModel != null) {
            orderMapStatusModel.manualMapRest = true;
        }
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).setValue(orderMapStatusModel);
    }

    public void sendReceipt(String str, String str2, long j, OrderService.Result<Boolean> result) {
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_FLUTTER_TO_RECEIPT_PARAM_ERROR).addErrorMsg("order id is empty").addModuleName("flutter").build().trackError();
            if (result != null) {
                result.success(false);
            }
        }
        CustomerRpcManagerProxy.get().getReceiptInfo(new NewOrderServicePlugin$sendReceipt$1(result, str2));
    }

    public void contactByCall(String str, String str2, long j) {
        Collection listeners = getListeners();
        if (!(listeners == null || listeners.isEmpty())) {
            Map hashMap = new HashMap();
            hashMap.put("orderid", str2);
            hashMap.put(Const.PageParams.CONTACT_ROLE, Long.valueOf(j));
            hashMap.put(Const.PageParams.CONTACT_TYPE, 22);
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus("contactIM", str), hashMap, (OnPluginResultListener) null, 4, (Object) null);
        }
    }

    public void goAppStoreRate(String str) {
        Collection listeners = getListeners();
        if (!(listeners == null || listeners.isEmpty())) {
            UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus(GO_APP_STORE_RATE, str), (Map) null, (OnPluginResultListener) null, 6, (Object) null);
        }
    }

    public void refreshIMUnreadCount(String str) {
        UniApiObserver.notifyAllObserver$default(this, Intrinsics.stringPlus(REFRESH_IM_UNREAD_COUNT, str), (Map) null, (OnPluginResultListener) null, 6, (Object) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/order/flutterpage/NewOrderServicePlugin$Companion;", "", "()V", "GO_APP_STORE_RATE", "", "ORDER_CONTACT", "REFRESH_IM_UNREAD_COUNT", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NewOrderServicePlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

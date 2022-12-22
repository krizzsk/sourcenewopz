package com.didi.soda.manager.base;

import android.app.Activity;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.universal.pay.biz.model.PayStatusModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J0\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager;", "Lcom/didi/soda/manager/base/ICustomerManager;", "getPayStatus", "", "activity", "Landroid/app/Activity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "payParam", "Lcom/didi/soda/manager/base/ICustomerPayManager$PayParamEntity;", "payCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$PayCallback;", "pay", "BillPayCallback", "CartPayButtonCallback", "OrderPayCardSelectCallback", "PayCallback", "PayParamEntity", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICustomerPayManager.kt */
public interface ICustomerPayManager extends ICustomerManager {

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "fail", "", "businessId", "", "hideLoading", "isLoading", "", "loading", "success", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ICustomerPayManager.kt */
    public interface CartPayButtonCallback extends IEntity {
        void fail(String str);

        void hideLoading();

        boolean isLoading();

        void loading();

        void success(String str);
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager$OrderPayCardSelectCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "selectCard", "", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ICustomerPayManager.kt */
    public interface OrderPayCardSelectCallback extends IEntity {
        void selectCard(PayChannelEntity payChannelEntity);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager$PayCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "onThirdPayStart", "", "channelId", "", "payFail", "code", "msg", "", "statusModel", "Lcom/didi/universal/pay/biz/model/PayStatusModel;", "paySucceed", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ICustomerPayManager.kt */
    public interface PayCallback extends IEntity {
        void onThirdPayStart(int i);

        void payFail(int i, String str, PayStatusModel payStatusModel);

        void paySucceed();
    }

    void getPayStatus(Activity activity, ScopeContext scopeContext, PayParamEntity payParamEntity, PayCallback payCallback);

    void pay(ScopeContext scopeContext, Activity activity, PayParamEntity payParamEntity, PayCallback payCallback);

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager$BillPayCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "gotoEditPage", "", "msg", "", "quitBill", "error", "", "recoverBill", "orderId", "sceneType", "sceneParam", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;", "refreshBill", "updateBusinessAndCart", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ICustomerPayManager.kt */
    public interface BillPayCallback extends IEntity {
        void gotoEditPage(String str);

        void quitBill(int i);

        void recoverBill(String str, int i, SceneParamsEntity sceneParamsEntity);

        void refreshBill();

        void updateBusinessAndCart();

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: ICustomerPayManager.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void recoverBill$default(BillPayCallback billPayCallback, String str, int i, SceneParamsEntity sceneParamsEntity, int i2, Object obj) {
                if (obj == null) {
                    if ((i2 & 1) != 0) {
                        str = "";
                    }
                    if ((i2 & 2) != 0) {
                        i = 0;
                    }
                    if ((i2 & 4) != 0) {
                        sceneParamsEntity = null;
                    }
                    billPayCallback.recoverBill(str, i, sceneParamsEntity);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recoverBill");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/manager/base/ICustomerPayManager$PayParamEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "token", "transId", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ICustomerPayManager.kt */
    public static final class PayParamEntity implements IEntity {
        private String orderId;
        public String token;
        public String transId;

        public final String getOrderId() {
            return this.orderId;
        }

        public final void setOrderId(String str) {
            this.orderId = str;
        }
    }
}

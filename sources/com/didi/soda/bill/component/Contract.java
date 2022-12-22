package com.didi.soda.bill.component;

import android.os.Bundle;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.DeliveryRulesModel;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.manager.base.ICustomerPayManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\r\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract;", "", "AbsBillPresenter", "AbsBillView", "AbsCPFCheckPresenter", "AbsCPFCheckView", "AbsCartInfoConfirmPresenter", "AbsCartInfoConfirmView", "AbsDeliveryMethodPresenter", "AbsDeliveryMethodView", "AbsEditRemarkPresenter", "AbsEditRemarkView", "AbsOutOfStockPresenter", "AbsOutOfStockView", "IPayCardErrorListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J7\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u0018H&¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsBillPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsBillView;", "()V", "onClickBack", "", "onCreateOrder", "buttonCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "onHandleBack", "", "onRecAddressClose", "onSetRecAddress", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "style", "", "setCPFVisibleListener", "listener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "startTotalPriceAnim", "newDisplay", "", "setTextBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillPresenter extends CustomerRecyclerPresenter<AbsBillView> {
        public abstract void onClickBack();

        public abstract void onCreateOrder(ICustomerPayManager.CartPayButtonCallback cartPayButtonCallback);

        public abstract boolean onHandleBack();

        public abstract void onRecAddressClose();

        public abstract void onSetRecAddress(AddressEntity addressEntity, int i);

        public abstract void setCPFVisibleListener(CPFCheckVisibleListener cPFCheckVisibleListener);

        public abstract void startTotalPriceAnim(String str, Function1<? super String, Unit> function1);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsCPFCheckPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckView;", "()V", "checkCPF", "", "cpfStr", "", "birthStr", "setCPFVisibleListener", "listener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "skip", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCPFCheckPresenter extends IPresenter<AbsCPFCheckView> {
        public abstract void checkCPF(String str, String str2);

        public abstract void setCPFVisibleListener(CPFCheckVisibleListener cPFCheckVisibleListener);

        public abstract void skip();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsCPFCheckView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckPresenter;", "()V", "refreshInfo", "", "cpfInfo", "", "birthInfo", "showToast", "toast", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCPFCheckView extends IView<AbsCPFCheckPresenter> {
        public abstract void refreshInfo(String str, String str2);

        public abstract void showToast(String str);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmView;", "()V", "onClickBack", "", "onConfirm", "onEditInfo", "onHandleBack", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCartInfoConfirmPresenter extends IPresenter<AbsCartInfoConfirmView> {
        public abstract void onClickBack();

        public abstract void onConfirm();

        public abstract void onEditInfo();

        public abstract void onHandleBack();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmPresenter;", "()V", "setData", "", "payChannelEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsCartInfoConfirmView extends IView<AbsCartInfoConfirmPresenter> {
        public abstract void setData(PayChannelEntity payChannelEntity);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodView;", "()V", "finish", "", "updateDeliveryMethod", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsDeliveryMethodPresenter extends IPresenter<AbsDeliveryMethodView> {
        public abstract void finish();

        public abstract void updateDeliveryMethod(DeliveryMethodEntity deliveryMethodEntity);
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodPresenter;", "()V", "initDeliveryMethod", "", "entity", "", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "deliveryRulesModel", "Lcom/didi/soda/bill/model/datamodel/DeliveryRulesModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsDeliveryMethodView extends IView<AbsDeliveryMethodPresenter> {
        public abstract void initDeliveryMethod(List<? extends DeliveryMethodEntity> list, DeliveryRulesModel deliveryRulesModel);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsEditRemarkPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsEditRemarkView;", "()V", "finish", "", "updateRemark", "remark", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsEditRemarkPresenter extends IPresenter<AbsEditRemarkView> {
        public abstract void finish();

        public abstract void updateRemark(String str);
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsEditRemarkView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/bill/component/Contract$AbsEditRemarkPresenter;", "()V", "initDefaultNote", "", "defaultNote", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsEditRemarkView extends IView<AbsEditRemarkPresenter> {
        public abstract void initDefaultNote(String str);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsOutOfStockPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsOutOfStockView;", "()V", "confirmUpdate", "", "finish", "updateSelected", "type", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsOutOfStockPresenter extends CustomerRecyclerPresenter<AbsOutOfStockView> {
        public abstract void confirmUpdate();

        public abstract void finish();

        public abstract void updateSelected(int i);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsOutOfStockView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/bill/component/Contract$AbsOutOfStockPresenter;", "()V", "initDefaultData", "", "cartId", "", "shopId", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsOutOfStockView extends CustomerRecyclerView<AbsOutOfStockPresenter> {
        public abstract void initDefaultData(String str, String str2);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$IPayCardErrorListener;", "", "onCashPay", "", "onDismiss", "onEditAddress", "onOtherPay", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public interface IPayCardErrorListener {

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Contract.kt */
        public static final class DefaultImpls {
            public static void onCashPay(IPayCardErrorListener iPayCardErrorListener) {
                Intrinsics.checkNotNullParameter(iPayCardErrorListener, "this");
            }

            public static void onEditAddress(IPayCardErrorListener iPayCardErrorListener) {
                Intrinsics.checkNotNullParameter(iPayCardErrorListener, "this");
            }

            public static void onOtherPay(IPayCardErrorListener iPayCardErrorListener) {
                Intrinsics.checkNotNullParameter(iPayCardErrorListener, "this");
            }
        }

        void onCashPay();

        void onDismiss();

        void onEditAddress();

        void onOtherPay();
    }

    @Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0005H&¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/Contract$AbsBillView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/bill/component/Contract$AbsBillPresenter;", "()V", "anchorBeforePosition", "", "reminder", "", "autoClickItem", "model", "Lcom/didi/soda/bill/model/ComponentModel;", "type", "", "data", "Landroid/os/Bundle;", "focusItem", "getPayButtonCallback", "Lcom/didi/soda/manager/base/ICustomerPayManager$CartPayButtonCallback;", "hideAbnormalView", "loadNotify", "shopId", "cartId", "setAddressData", "setPayPrice", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "setTipsContent", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "showAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "showNotice", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillView extends CustomerRecyclerView<AbsBillPresenter> {
        public abstract void anchorBeforePosition(String str);

        public abstract void autoClickItem(ComponentModel componentModel, int i, Bundle bundle);

        public abstract void focusItem(ComponentModel componentModel);

        public abstract ICustomerPayManager.CartPayButtonCallback getPayButtonCallback();

        public abstract void hideAbnormalView();

        public abstract void loadNotify(String str, String str2);

        public abstract void setAddressData(ComponentModel componentModel);

        public abstract void setPayPrice(BillInfoEntity billInfoEntity);

        public abstract void setTipsContent(AddressEntity addressEntity);

        public abstract void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel);

        public abstract void showNotice();

        public static /* synthetic */ void autoClickItem$default(AbsBillView absBillView, ComponentModel componentModel, int i, Bundle bundle, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    bundle = null;
                }
                absBillView.autoClickItem(componentModel, i, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoClickItem");
        }
    }
}

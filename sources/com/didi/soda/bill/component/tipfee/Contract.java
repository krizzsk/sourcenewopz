package com.didi.soda.bill.component.tipfee;

import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/Contract;", "", "AbsTipsFeeEditPresenter", "AbsTipsFeeEditView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditPresenter;", "Lcom/didi/soda/customer/base/ICustomerPresenter;", "Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditView;", "()V", "confirmTipsFeeInput", "", "tipsFeeStr", "", "getBillTipFeeModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsTipsFeeEditPresenter extends ICustomerPresenter<AbsTipsFeeEditView> {
        public abstract void confirmTipsFeeInput(String str);

        public abstract BillTipModel getBillTipFeeModel();
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditView;", "Lcom/didi/soda/customer/base/ICustomerView;", "Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditPresenter;", "()V", "bindTipsFeeData", "", "billTipModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "selectedFee", "", "currency", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsTipsFeeEditView extends ICustomerView<AbsTipsFeeEditPresenter> {
        public abstract void bindTipsFeeData(BillTipModel billTipModel, long j, String str);
    }
}

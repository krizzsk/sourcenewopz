package com.didi.soda.bill.component.outofstock;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.datamodel.OutOfStockModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AbnormalItemOptEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsOutOfStockPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "lastType", "", "mListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "outOfStockModel", "Lcom/didi/soda/bill/model/datamodel/OutOfStockModel;", "confirmUpdate", "", "finish", "initDataManagers", "onCreate", "updateSelected", "type", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockPresenter.kt */
public final class OutOfStockPresenter extends Contract.AbsOutOfStockPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private OutOfStockModel f38946a;

    /* renamed from: b */
    private ChildDataListManager<AbnormalItemDetailEntity> f38947b;

    /* renamed from: c */
    private int f38948c;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void onCreate() {
        Bundle bundle = getScopeContext().getBundle();
        Serializable serializable = bundle.getSerializable("out_of_stock_data");
        if (serializable != null && (serializable instanceof OutOfStockModel)) {
            this.f38946a = (OutOfStockModel) serializable;
        }
        ((Contract.AbsOutOfStockView) getLogicView()).initDefaultData(bundle.getString("cart_id"), bundle.getString("current_shop_id"));
        super.onCreate();
    }

    public void finish() {
        dismiss(getScopeContext());
    }

    public void updateSelected(int i) {
        List<AbnormalItemDetailEntity> options;
        if (this.f38948c != i) {
            this.f38948c = i;
            OutOfStockModel outOfStockModel = this.f38946a;
            if (outOfStockModel != null && (options = outOfStockModel.getOptions()) != null) {
                Iterator it = options.iterator();
                while (true) {
                    int i2 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    AbnormalItemDetailEntity abnormalItemDetailEntity = (AbnormalItemDetailEntity) it.next();
                    if (abnormalItemDetailEntity.getType() == i) {
                        i2 = 1;
                    }
                    abnormalItemDetailEntity.setSelected(i2);
                }
                ChildDataListManager<AbnormalItemDetailEntity> childDataListManager = this.f38947b;
                if (childDataListManager != null) {
                    childDataListManager.onChanged(0, options.size(), (Object) null);
                }
            }
        }
    }

    public void confirmUpdate() {
        AbnormalItemOptEntity abnormalItemOptEntity = new AbnormalItemOptEntity();
        abnormalItemOptEntity.setType(this.f38948c);
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(abnormalItemOptEntity);
        Bundle bundle = getScopeContext().getBundle();
        BillOmegaHelper.Companion.trackOutOfStockConfirmCk(bundle.getString("cart_id"), bundle.getString("current_shop_id"), Integer.valueOf(this.f38948c));
        finish();
    }

    public void initDataManagers() {
        super.initDataManagers();
        OutOfStockModel outOfStockModel = this.f38946a;
        List<AbnormalItemDetailEntity> list = null;
        String subTitle = outOfStockModel == null ? null : outOfStockModel.getSubTitle();
        if (subTitle == null) {
            subTitle = ResourceHelper.getString(R.string.FoodC_demand_When_the_cHns);
        }
        addDataManager(createChildDataItemManager(subTitle));
        ChildDataListManager<AbnormalItemDetailEntity> createChildDataListManager = createChildDataListManager();
        this.f38947b = createChildDataListManager;
        addDataManager(createChildDataListManager);
        ChildDataListManager<AbnormalItemDetailEntity> childDataListManager = this.f38947b;
        if (childDataListManager != null) {
            OutOfStockModel outOfStockModel2 = this.f38946a;
            if (outOfStockModel2 != null) {
                list = outOfStockModel2.getOptions();
            }
            childDataListManager.set(list);
        }
        Bundle bundle = getScopeContext().getBundle();
        BillOmegaHelper.Companion.trackOutOfStockPageSw(bundle.getString("cart_id"), bundle.getString("current_shop_id"));
    }
}

package com.didi.entrega.bill.component.bill;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.BillDialogHelper;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.component.bill.Contract;
import com.didi.entrega.bill.datastore.BillInfoRequest;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.BillUpdateRequest;
import com.didi.entrega.bill.datastore.p110op.BillPriceOperation;
import com.didi.entrega.bill.datastore.p110op.BillSectionsOperation;
import com.didi.entrega.bill.model.PriceModel;
import com.didi.entrega.bill.model.RequestFlowModel;
import com.didi.entrega.bill.model.SectionModel;
import com.didi.entrega.bill.repo.BillConfigRepo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.AlertEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.SingleChildDataListManager;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/BillPresenter;", "Lcom/didi/entrega/bill/component/bill/Contract$AbsBillPresenter;", "()V", "mBillEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "mBillListManager", "Lcom/didi/entrega/customer/widget/SingleChildDataListManager;", "Lcom/didi/entrega/bill/model/SectionModel;", "billInfo", "", "dealFlow", "flow", "Lcom/didi/entrega/bill/model/RequestFlowModel;", "handleBack", "", "initDataManagers", "onCreate", "onHandleBack", "showErrorToast", "entity", "subscribeBillConfig", "subscribeBillData", "subscribeEntityData", "subscribePriceData", "subscribeRequestFlowChanged", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPresenter.kt */
public final class BillPresenter extends Contract.AbsBillPresenter {

    /* renamed from: a */
    private BillEntity f19468a;

    /* renamed from: b */
    private SingleChildDataListManager<SectionModel> f19469b;

    public void onCreate() {
        super.onCreate();
        ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).clear();
        m14585f();
        m14582c();
        m14583d();
        m14581b();
        m14584e();
        m14574a();
    }

    /* renamed from: a */
    private final void m14574a() {
        AddressEntity addressEntity;
        AddressEntity addressEntity2;
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        try {
            addressEntity2 = (AddressEntity) GsonUtils.fromJson(GsonUtils.toJson(bundle.getSerializable(Const.FlutterBundleKey.PICK_UP_ADDRESS)), AddressEntity.class);
            try {
                addressEntity = (AddressEntity) GsonUtils.fromJson(GsonUtils.toJson(bundle.getSerializable(Const.FlutterBundleKey.DROP_OFF_ADDRESS)), AddressEntity.class);
            } catch (Exception unused) {
                addressEntity = null;
                BillRepo.Companion companion = BillRepo.Companion;
                ScopeContext scopeContext = getScopeContext();
                Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
                BillRepo.getBillInfo$default(companion.get(scopeContext), "", addressEntity2, addressEntity, (ContactStufEntity) null, (String) null, false, 48, (Object) null);
            }
        } catch (Exception unused2) {
            addressEntity2 = null;
            addressEntity = null;
            BillRepo.Companion companion2 = BillRepo.Companion;
            ScopeContext scopeContext2 = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
            BillRepo.getBillInfo$default(companion2.get(scopeContext2), "", addressEntity2, addressEntity, (ContactStufEntity) null, (String) null, false, 48, (Object) null);
        }
        BillRepo.Companion companion22 = BillRepo.Companion;
        ScopeContext scopeContext22 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext22, "scopeContext");
        BillRepo.getBillInfo$default(companion22.get(scopeContext22), "", addressEntity2, addressEntity, (ContactStufEntity) null, (String) null, false, 48, (Object) null);
    }

    /* renamed from: b */
    private final void m14581b() {
        BillPresenter$subscribeEntityData$trackOp$1 billPresenter$subscribeEntityData$trackOp$1 = new BillPresenter$subscribeEntityData$trackOp$1();
        BillRepo.Companion companion = BillRepo.Companion;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        companion.get(scopeContext).subscribe(billPresenter$subscribeEntityData$trackOp$1, scopeContext2, new Action1() {
            public final void call(Object obj) {
                BillPresenter.m14577a(BillPresenter.this, (BillEntity) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14577a(BillPresenter billPresenter, BillEntity billEntity) {
        Intrinsics.checkNotNullParameter(billPresenter, "this$0");
        if (billEntity != null) {
            billPresenter.f19468a = billEntity;
            billPresenter.m14580a(billEntity);
        }
    }

    /* renamed from: a */
    private final void m14580a(BillEntity billEntity) {
        if (billEntity.getToast() != null) {
            CharSequence content = billEntity.getToast().getContent();
            if (!(content == null || content.length() == 0)) {
                ToastUtil.showCustomerToast(getScopeContext(), billEntity.getToast().getContent());
            }
        }
    }

    /* renamed from: c */
    private final void m14582c() {
        BillRepo.Companion companion = BillRepo.Companion;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        companion.get(scopeContext).subscribe(new BillSectionsOperation(getScopeContext()), scopeContext2, new Action1() {
            public final void call(Object obj) {
                BillPresenter.m14578a(BillPresenter.this, (List) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14578a(BillPresenter billPresenter, List list) {
        SingleChildDataListManager<SectionModel> singleChildDataListManager;
        Intrinsics.checkNotNullParameter(billPresenter, "this$0");
        if (list != null && (singleChildDataListManager = billPresenter.f19469b) != null) {
            singleChildDataListManager.reset(list);
        }
    }

    /* renamed from: d */
    private final void m14583d() {
        BillRepo.Companion companion = BillRepo.Companion;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        BillRepo billRepo = companion.get(scopeContext);
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        ScopeContext scopeContext3 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext3, "scopeContext");
        billRepo.subscribe(new BillPriceOperation(scopeContext2), scopeContext3, new Action1() {
            public final void call(Object obj) {
                BillPresenter.m14576a(BillPresenter.this, (PriceModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14576a(BillPresenter billPresenter, PriceModel priceModel) {
        Intrinsics.checkNotNullParameter(billPresenter, "this$0");
        if (priceModel != null) {
            ((Contract.AbsBillView) billPresenter.getLogicView()).showPriceLayout(priceModel);
        }
    }

    /* renamed from: e */
    private final void m14584e() {
        ((BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class)).subscribe(getScopeContext(), new BillPresenter$subscribeBillConfig$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m14579a(RequestFlowModel requestFlowModel) {
        AbnormalViewModel abnormalViewModel;
        AbnormalViewModel abnormalViewModel2;
        boolean z = false;
        if (requestFlowModel.getRequest() instanceof BillInfoRequest) {
            if (requestFlowModel.getStatus() == 1) {
                SingleChildDataListManager<SectionModel> singleChildDataListManager = this.f19469b;
                if ((singleChildDataListManager == null ? 0 : singleChildDataListManager.size()) <= 0) {
                    z = true;
                }
                ((Contract.AbsBillView) getLogicView()).showLoadingView(z);
                ((Contract.AbsBillView) getLogicView()).hideAbnormalView();
                return;
            }
            ((Contract.AbsBillView) getLogicView()).hindLoadingView();
            if (requestFlowModel.getEx() != null) {
                $$Lambda$BillPresenter$2PIt_WogMJAG3VcRemUp0KclLuY r0 = new View.OnClickListener() {
                    public final void onClick(View view) {
                        BillPresenter.m14575a(BillPresenter.this, view);
                    }
                };
                if (!NetWorkUtils.isNetworkConnected(getContext())) {
                    abnormalViewModel = AbnormalViewModelFactory.buildNoNetwork(r0);
                } else {
                    String message = requestFlowModel.getEx().getMessage();
                    if (message == null) {
                        abnormalViewModel2 = null;
                    } else {
                        abnormalViewModel2 = AbnormalViewModelFactory.buildNoService(message, r0);
                    }
                    abnormalViewModel = abnormalViewModel2 == null ? AbnormalViewModelFactory.buildNoNetwork(r0) : abnormalViewModel2;
                }
                Intrinsics.checkNotNullExpressionValue(abnormalViewModel, "model");
                ((Contract.AbsBillView) getLogicView()).showAbnormalView(abnormalViewModel);
                BillOmegaHelper.INSTANCE.trackBillInfoError(requestFlowModel.getEx());
                if (((BillInfoRequest) requestFlowModel.getRequest()).getRecover()) {
                    BillOmegaHelper.INSTANCE.trackBillRecover(2);
                }
            } else if (((BillInfoRequest) requestFlowModel.getRequest()).getRecover()) {
                BillOmegaHelper.INSTANCE.trackBillRecover(1);
            }
        } else if (!(requestFlowModel.getRequest() instanceof BillUpdateRequest)) {
        } else {
            if (requestFlowModel.getStatus() == 1) {
                LogUtil.m14761d("TAG", " >>>> bill update 请求开始 显示Loading");
                ((Contract.AbsBillView) getLogicView()).showLoadingView(false);
                return;
            }
            ((Contract.AbsBillView) getLogicView()).hindLoadingView();
            if (requestFlowModel.getEx() != null) {
                BillOmegaHelper.INSTANCE.trackBillUpdateError(requestFlowModel.getEx());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14575a(BillPresenter billPresenter, View view) {
        Intrinsics.checkNotNullParameter(billPresenter, "this$0");
        billPresenter.m14574a();
    }

    /* renamed from: f */
    private final void m14585f() {
        BillRepo.Companion companion = BillRepo.Companion;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        BillRepo billRepo = companion.get(scopeContext);
        ScopeContext scopeContext2 = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext2, "scopeContext");
        billRepo.subscribeRequestFlow(scopeContext2, new BillPresenter$subscribeRequestFlowChanged$1(this));
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f19469b == null) {
            SingleChildDataListManager<SectionModel> singleChildDataListManager = new SingleChildDataListManager<>(((Contract.AbsBillView) getLogicView()).getAdapter());
            this.f19469b = singleChildDataListManager;
            addDataManager(singleChildDataListManager);
        }
    }

    public final boolean onHandleBack() {
        return handleBack();
    }

    public boolean handleBack() {
        AlertEntity alert;
        BillEntity billEntity = this.f19468a;
        if (billEntity == null || (alert = billEntity.getAlert()) == null) {
            getScopeContext().getNavigator().popToRoot();
            ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).clear();
            return false;
        }
        BillDialogHelper.Companion companion = BillDialogHelper.Companion;
        INavigator navigator = getScopeContext().getNavigator();
        Intrinsics.checkNotNullExpressionValue(navigator, "scopeContext.navigator");
        companion.showBillCardDialog(navigator, alert);
        return true;
    }
}

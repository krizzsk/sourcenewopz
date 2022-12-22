package com.didi.entrega.info.component.stuf;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.BillExt;
import com.didi.entrega.bill.repo.BillConfig;
import com.didi.entrega.bill.repo.BillConfigRepo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.component.StuffConstract;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.entrega.info.model.InfoHeaderModel;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.entrega.info.model.StuffTypeModel;
import com.didi.entrega.info.repo.InfoRepo;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJ\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/info/component/stuf/StuffUpdatePresenter;", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "constuffEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getConstuffEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setConstuffEntity", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;)V", "fillConstuffEntity", "", "handleBack", "initStuffModel", "cateInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "initUpdateBottomBtn", "initUpdateView", "onCreate", "onPageResult", "data", "Landroid/os/Bundle;", "readRepoData", "showAbnormal", "msg", "subscrib", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffUpdatePresenter.kt */
public final class StuffUpdatePresenter extends StuffConstract.AbsCommonStuffPresenter {

    /* renamed from: a */
    private final String f20786a = "StuffUpdatePresenter";

    /* renamed from: b */
    private ContactStufEntity f20787b;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15212a(Void voidR) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15213b(Void voidR) {
    }

    public void onPageResult(Bundle bundle) {
    }

    public final String getTAG() {
        return this.f20786a;
    }

    public final ContactStufEntity getConstuffEntity() {
        return this.f20787b;
    }

    public final void setConstuffEntity(ContactStufEntity contactStufEntity) {
        this.f20787b = contactStufEntity;
    }

    public void onCreate() {
        super.onCreate();
        initUpdateView();
        m15209a();
        BillConfigRepo billConfigRepo = (BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class);
        BillConfig value = billConfigRepo.getValue();
        value.setStuffHasShow(true);
        billConfigRepo.setValue(value);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15209a() {
        ((StuffConstract.AbsCommonStuffView) getLogicView()).hideAbnormal();
        ((StuffConstract.AbsCommonStuffView) getLogicView()).loadingAndHideBottomBtn();
        CustomerRpcManagerProxy.get().getCommonCateInfo(((InfoRepo) RepoFactory.getRepo(InfoRepo.class)).getCartId(), getFusionChannel(), new StuffUpdatePresenter$readRepoData$1(this));
    }

    public final void initStuffModel(CommonInfoEntity commonInfoEntity) {
        CommonInfoEntity.CateInfoTag stuffEntityData;
        List<CommonInfoEntity.CateInfosItem> cateInfoItems;
        Intrinsics.checkNotNullParameter(commonInfoEntity, "cateInfo");
        setStuffTypeModel(InfoDataHelper.INSTANCE.parseStuffTypeModel(commonInfoEntity));
        getComponentRepo().setStuffTypeModelValue(getStuffTypeModel());
        StuffTypeModel stuffTypeModel = getStuffTypeModel();
        int i = 0;
        if (!(stuffTypeModel == null || (stuffEntityData = stuffTypeModel.getStuffEntityData()) == null || (cateInfoItems = stuffEntityData.getCateInfoItems()) == null)) {
            i = cateInfoItems.size();
        }
        if (i > 0) {
            getDataListManager().add(getStuffTypeModel());
        }
        setStuffRemarkModel(InfoDataHelper.INSTANCE.parseStuffRemarkModel(commonInfoEntity));
        getDataListManager().add(getStuffRemarkModel());
        setStuffRuleModel(InfoDataHelper.INSTANCE.parseStuffRuleModel(commonInfoEntity));
        getDataListManager().add(getStuffRuleModel());
        InfoOmegaHelper.INSTANCE.trackStufSw(this);
    }

    public final void initUpdateView() {
        initUpdateBottomBtn();
        setDataListManager(createChildDataListManager(getDataList()));
        addDataManager(getDataListManager());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15211a(String str) {
        InfoHeaderModel infoHeaderModel = getInfoHeaderModel();
        if (infoHeaderModel != null && getDataListManager().indexOf(infoHeaderModel) >= 0) {
            getDataListManager().remove(getDataListManager().indexOf(infoHeaderModel));
        }
        ((StuffConstract.AbsCommonStuffView) getLogicView()).showAbnormal(createAbnormalViewModel(str, new StuffUpdatePresenter$showAbnormal$abnormalViewModel$1(this)));
        LogUtil.m14765i(this.f20786a, Intrinsics.stringPlus("异常页面展示：", str));
    }

    public final void initUpdateBottomBtn() {
        ((RFMainButton) ((StuffConstract.AbsCommonStuffView) getLogicView()).getRootView().findViewById(R.id.btn_bottom)).setText(ResourceHelper.getString(R.string.FoodC_info_NEXT_YECx));
        ((RFMainButton) ((StuffConstract.AbsCommonStuffView) getLogicView()).getRootView().findViewById(R.id.btn_bottom)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StuffUpdatePresenter.m15210a(StuffUpdatePresenter.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15210a(StuffUpdatePresenter stuffUpdatePresenter, View view) {
        Intrinsics.checkNotNullParameter(stuffUpdatePresenter, "this$0");
        InfoOmegaHelper.INSTANCE.trackStuffConfirmCk(stuffUpdatePresenter);
        stuffUpdatePresenter.fillConstuffEntity();
        if (stuffUpdatePresenter.getEventSource() == 1) {
            ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).updateStuf(stuffUpdatePresenter.getConstuffEntity());
            BillConfigRepo billConfigRepo = (BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class);
            BillConfig value = billConfigRepo.getValue();
            value.setRequestBill(true);
            billConfigRepo.setValue(value);
            HashMap hashMap = new HashMap();
            String json = GsonUtil.toJson(stuffUpdatePresenter.getConstuffEntity());
            Intrinsics.checkNotNullExpressionValue(json, "toJson(constuffEntity)");
            hashMap.put(Const.BundleKey.INFO_PAGE_BILL_STUFF, json);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap), $$Lambda$StuffUpdatePresenter$nqROWJQcQDTAjvlJPp7_XKKQPuU.INSTANCE);
            BillExt.Companion companion = BillExt.Companion;
            int pageSource = stuffUpdatePresenter.getPageSource();
            int eventSource = stuffUpdatePresenter.getEventSource();
            ScopeContext scopeContext = stuffUpdatePresenter.getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            boolean billNextBtnOpenPage = companion.billNextBtnOpenPage(pageSource, eventSource, scopeContext);
            return;
        }
        HashMap hashMap2 = new HashMap();
        String json2 = GsonUtil.toJson(stuffUpdatePresenter.getConstuffEntity());
        Intrinsics.checkNotNullExpressionValue(json2, "toJson(constuffEntity)");
        hashMap2.put(Const.BundleKey.INFO_PAGE_BILL_STUFF, json2);
        ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap2), $$Lambda$StuffUpdatePresenter$QSVL0rf5dcYqofiE46vZ92RY9Iw.INSTANCE);
        stuffUpdatePresenter.getScopeContext().getNavigator().finish();
    }

    public void handleBack() {
        super.handleBack();
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        getScopeContext().getNavigator().finish();
    }

    public final void subscrib() {
        InfoRepo infoRepo = (InfoRepo) RepoFactory.getRepo(InfoRepo.class);
        infoRepo.subscribe(getScopeContext(), new StuffUpdatePresenter$subscrib$1(this, infoRepo));
    }

    public final void fillConstuffEntity() {
        CommonInfoEntity.Remark stuffEntityData;
        if (this.f20787b == null) {
            this.f20787b = new ContactStufEntity();
        }
        ContactStufEntity contactStufEntity = this.f20787b;
        String str = null;
        if (contactStufEntity != null) {
            CommonInfoEntity.CateInfosItem selectedItem = getComponentRepo().getSelectedItem();
            contactStufEntity.cateId = selectedItem == null ? null : selectedItem.getCateID();
        }
        ContactStufEntity contactStufEntity2 = this.f20787b;
        if (contactStufEntity2 != null) {
            CommonInfoEntity.CateInfosItem selectedItem2 = getComponentRepo().getSelectedItem();
            contactStufEntity2.cateImg = selectedItem2 == null ? null : selectedItem2.getCateImg();
        }
        ContactStufEntity contactStufEntity3 = this.f20787b;
        if (contactStufEntity3 != null) {
            CommonInfoEntity.CateInfosItem selectedItem3 = getComponentRepo().getSelectedItem();
            contactStufEntity3.cateName = selectedItem3 == null ? null : selectedItem3.getCateName();
        }
        ContactStufEntity contactStufEntity4 = this.f20787b;
        if (contactStufEntity4 != null) {
            StuffRemarkModel stuffRemarkModel = getComponentRepo().getStuffRemarkModel();
            if (!(stuffRemarkModel == null || (stuffEntityData = stuffRemarkModel.getStuffEntityData()) == null)) {
                str = stuffEntityData.getContent();
            }
            contactStufEntity4.remark = str;
        }
    }
}

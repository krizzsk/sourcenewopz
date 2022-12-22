package com.didi.entrega.info.component.receive;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.bill.BillExt;
import com.didi.entrega.bill.repo.BillConfig;
import com.didi.entrega.bill.repo.BillConfigRepo;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.foundation.util.locale.LocalizationUtils;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.model.InfoHeaderModel;
import com.didi.entrega.info.repo.InfoRepo;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010'\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006("}, mo175978d2 = {"Lcom/didi/entrega/info/component/receive/ReceiveContactUpdatePresenter;", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "receiveContactEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getReceiveContactEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setReceiveContactEntity", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "handleBack", "", "hideLoadingAbnormal", "infoAutoFill", "item", "Lcom/didi/entrega/info/model/HistoryModel;", "initContactModel", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "initUpdateBottomBtn", "initUpdateView", "onCallingClick", "callingCode", "countryId", "", "onCreate", "onHistoryItemClick", "onPageResult", "data", "Landroid/os/Bundle;", "onPoiClick", "requestHistoryList", "commonInfoEntity", "requestUpdateData", "showAbnormal", "msg", "subscrib", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactUpdatePresenter.kt */
public final class ReceiveContactUpdatePresenter extends ContactConstract.AbsEditContactPresenter {

    /* renamed from: a */
    private final String f20778a = "ReceiveContactUpdatePresenter";

    /* renamed from: b */
    private AddressEntity f20779b = new AddressEntity();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15193a(Void voidR) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15195b(Void voidR) {
    }

    public final String getTAG() {
        return this.f20778a;
    }

    public final AddressEntity getReceiveContactEntity() {
        return this.f20779b;
    }

    public final void setReceiveContactEntity(AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(addressEntity, "<set-?>");
        this.f20779b = addressEntity;
    }

    public void onCreate() {
        super.onCreate();
        initUpdateView();
        m15188a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15188a() {
        Unit unit;
        m15194b();
        ((ContactConstract.AbsEditContactView) getLogicView()).loadingAndHideBottomBtn();
        CommonInfoEntity commonInfoEntity = getComponentRepo().getCommonInfoEntity();
        if (commonInfoEntity == null) {
            unit = null;
        } else {
            m15189a(InfoDataHelper.INSTANCE.addUpdateData(commonInfoEntity));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CustomerRpcManagerProxy.get().getCommonInfo(new ReceiveContactUpdatePresenter$requestUpdateData$2$1(this));
        }
    }

    public final void initContactModel(CommonInfoEntity commonInfoEntity) {
        Intrinsics.checkNotNullParameter(commonInfoEntity, "contact");
        InfoStepConfig currentStepConfig = getCurrentStepConfig();
        if (currentStepConfig != null) {
            setContractModel(InfoDataHelper.INSTANCE.parseContactModel(commonInfoEntity, currentStepConfig.getCurrentStep()));
            getComponentRepo().setReceiverValue(getContractModel());
            ContactModel contractModel = getContractModel();
            if (contractModel != null) {
                getDataListManager().add(contractModel);
            }
            InfoOmegaHelper.INSTANCE.trackContactCommonShow(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15189a(CommonInfoEntity commonInfoEntity) {
        CustomerRpcManagerProxy.get().getHistoryContactList(new ReceiveContactUpdatePresenter$requestHistoryList$1(this, commonInfoEntity));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15194b() {
        ((ContactConstract.AbsEditContactView) getLogicView()).hideAbnormal();
        ((ContactConstract.AbsEditContactView) getLogicView()).hideLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15192a(String str) {
        InfoHeaderModel infoHeaderModel = getInfoHeaderModel();
        if (infoHeaderModel != null && getDataListManager().indexOf(infoHeaderModel) >= 0) {
            getDataListManager().remove(getDataListManager().indexOf(infoHeaderModel));
        }
        ((ContactConstract.AbsEditContactView) getLogicView()).showAbnormal(createAbnormalViewModel(str, new ReceiveContactUpdatePresenter$showAbnormal$abnormalViewModel$1(this)));
        LogUtil.m14765i(this.f20778a, Intrinsics.stringPlus("异常页面展示：", str));
    }

    public final void initUpdateView() {
        initUpdateBottomBtn();
        setDataListManager(createChildDataListManager(getDataList()));
        addDataManager(getDataListManager());
    }

    public final void initUpdateBottomBtn() {
        ((RFMainButton) ((ContactConstract.AbsEditContactView) getLogicView()).getRootView().findViewById(R.id.btn_bottom)).setText(ResourceHelper.getString(R.string.FoodC_info_NEXT_YECx));
        ((RFMainButton) ((ContactConstract.AbsEditContactView) getLogicView()).getRootView().findViewById(R.id.btn_bottom)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReceiveContactUpdatePresenter.m15190a(ReceiveContactUpdatePresenter.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15190a(ReceiveContactUpdatePresenter receiveContactUpdatePresenter, View view) {
        Intrinsics.checkNotNullParameter(receiveContactUpdatePresenter, "this$0");
        receiveContactUpdatePresenter.setReceiveContactEntity(InfoDataHelper.INSTANCE.convertContactModel2AddressEntity(receiveContactUpdatePresenter.getComponentRepo().getReceiver()));
        InfoOmegaHelper.INSTANCE.trackConfirmCk(receiveContactUpdatePresenter);
        if (!LocalizationUtils.isPhoneValida(receiveContactUpdatePresenter.getReceiveContactEntity().phone, receiveContactUpdatePresenter.getReceiveContactEntity().callingCode)) {
            ToastUtil.showCustomerToast(receiveContactUpdatePresenter.getScopeContext(), ResourceHelper.getString(R.string.Entrega_Integration__fMdV));
            ErrorTracker.create(ErrorConst.ErrorName.CONTACT_PHONE_VALID_ERROR).addModuleName("info").addErrorType("2").addParam(ErrorConst.ErrorParam.USER_CALLING_CODE, receiveContactUpdatePresenter.getReceiveContactEntity().callingCode).addParam(ErrorConst.ErrorParam.USER_PHONE, receiveContactUpdatePresenter.getReceiveContactEntity().phone).build().trackError();
        } else if (receiveContactUpdatePresenter.getEventSource() == 1) {
            ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).updateReceiveContact(receiveContactUpdatePresenter.getReceiveContactEntity());
            BillConfigRepo billConfigRepo = (BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class);
            BillConfig value = billConfigRepo.getValue();
            value.setRequestBill(true);
            billConfigRepo.setValue(value);
            HashMap hashMap = new HashMap();
            String json = GsonUtil.toJson(receiveContactUpdatePresenter.getReceiveContactEntity());
            Intrinsics.checkNotNullExpressionValue(json, "toJson(receiveContactEntity)");
            hashMap.put(Const.BundleKey.INFO_PAGE_BILL_RECEIVE, json);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap), C8198x61b792b9.INSTANCE);
            BillExt.Companion companion = BillExt.Companion;
            int pageSource = receiveContactUpdatePresenter.getPageSource();
            int eventSource = receiveContactUpdatePresenter.getEventSource();
            ScopeContext scopeContext = receiveContactUpdatePresenter.getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            boolean billNextBtnOpenPage = companion.billNextBtnOpenPage(pageSource, eventSource, scopeContext);
        } else {
            HashMap hashMap2 = new HashMap();
            String json2 = GsonUtil.toJson(receiveContactUpdatePresenter.getReceiveContactEntity());
            Intrinsics.checkNotNullExpressionValue(json2, "toJson(receiveContactEntity)");
            hashMap2.put(Const.BundleKey.INFO_PAGE_BILL_RECEIVE, json2);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap2), C8195x59e9a1a4.INSTANCE);
            receiveContactUpdatePresenter.getScopeContext().getNavigator().finish();
        }
    }

    public void onCallingClick(String str, int i) {
        CountryListDialog.show(getScopeContext(), (OnCountrySelectListener) new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                ReceiveContactUpdatePresenter.m15191a(ReceiveContactUpdatePresenter.this, str, i);
            }
        }, i, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15191a(ReceiveContactUpdatePresenter receiveContactUpdatePresenter, String str, int i) {
        int indexOf;
        Intrinsics.checkNotNullParameter(receiveContactUpdatePresenter, "this$0");
        ContactModel contractModel = receiveContactUpdatePresenter.getContractModel();
        if (contractModel != null && (indexOf = receiveContactUpdatePresenter.getDataListManager().indexOf(receiveContactUpdatePresenter.getContractModel())) >= 0) {
            CommonInfoEntity.Contact contact = contractModel.getContact();
            CommonInfoEntity.PhoneNumber phoneNumber = contact == null ? null : contact.getPhoneNumber();
            if (phoneNumber != null) {
                phoneNumber.setCallingCode(str);
            }
            receiveContactUpdatePresenter.getComponentRepo().setReceiverValue(contractModel);
            receiveContactUpdatePresenter.getDataListManager().set(indexOf, contractModel);
        }
    }

    public void onHistoryItemClick(HistoryModel historyModel) {
        double d;
        double d2;
        double d3;
        double d4;
        CommonInfoEntity.HistoryContact historyEntity;
        AddressEntity address;
        AddressEntity.PoiEntity poiEntity;
        CommonInfoEntity.HistoryContact historyEntity2;
        AddressEntity address2;
        AddressEntity.PoiEntity poiEntity2;
        HistoryModel historyModel2 = historyModel;
        super.onHistoryItemClick(historyModel);
        ((ContactConstract.AbsEditContactView) getLogicView()).loading();
        if (historyModel2 == null || (historyEntity2 = historyModel.getHistoryEntity()) == null || (address2 = historyEntity2.getAddress()) == null || (poiEntity2 = address2.poi) == null) {
            d = 0.0d;
        } else {
            d = poiEntity2.lat;
        }
        if (historyModel2 == null || (historyEntity = historyModel.getHistoryEntity()) == null || (address = historyEntity.getAddress()) == null || (poiEntity = address.poi) == null) {
            d2 = 0.0d;
        } else {
            d2 = poiEntity.lng;
        }
        AddressEntity sendContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getSendContact();
        if (sendContact == null || !AddressUtil.checkAddressValid(sendContact)) {
            d4 = 0.0d;
            d3 = 0.0d;
        } else {
            d4 = sendContact.poi.lat;
            d3 = sendContact.poi.lng;
        }
        CustomerRpcManagerProxy.get().checkAddress(d4, d3, d, d2, getFusionChannel(), 0, new ReceiveContactUpdatePresenter$onHistoryItemClick$1(this, historyModel2));
    }

    public final void infoAutoFill(HistoryModel historyModel) {
        int indexOf;
        CommonInfoEntity.HistoryContact historyEntity;
        AddressEntity address;
        CommonInfoEntity.HistoryContact historyEntity2;
        AddressEntity address2;
        CommonInfoEntity.HistoryContact historyEntity3;
        AddressEntity address3;
        CommonInfoEntity.HistoryContact historyEntity4;
        AddressEntity address4;
        CommonInfoEntity.HistoryContact historyEntity5;
        AddressEntity address5;
        CommonInfoEntity.HistoryContact historyEntity6;
        AddressEntity address6;
        ContactModel contractModel = getContractModel();
        if (contractModel != null && (indexOf = getDataListManager().indexOf(getContractModel())) >= 0) {
            CommonInfoEntity.Contact contact = contractModel.getContact();
            String str = null;
            AddressEntity address7 = contact == null ? null : contact.getAddress();
            if (address7 != null) {
                address7.poi = (historyModel == null || (historyEntity6 = historyModel.getHistoryEntity()) == null || (address6 = historyEntity6.getAddress()) == null) ? null : address6.poi;
            }
            CommonInfoEntity.Contact contact2 = contractModel.getContact();
            CommonInfoEntity.FirstName firstName = contact2 == null ? null : contact2.getFirstName();
            if (firstName != null) {
                firstName.setFirstName((historyModel == null || (historyEntity5 = historyModel.getHistoryEntity()) == null || (address5 = historyEntity5.getAddress()) == null) ? null : address5.firstName);
            }
            CommonInfoEntity.Contact contact3 = contractModel.getContact();
            CommonInfoEntity.LastName lastName = contact3 == null ? null : contact3.getLastName();
            if (lastName != null) {
                lastName.setLastName((historyModel == null || (historyEntity4 = historyModel.getHistoryEntity()) == null || (address4 = historyEntity4.getAddress()) == null) ? null : address4.lastName);
            }
            CommonInfoEntity.Contact contact4 = contractModel.getContact();
            CommonInfoEntity.PhoneNumber phoneNumber = contact4 == null ? null : contact4.getPhoneNumber();
            if (phoneNumber != null) {
                phoneNumber.setCallingCode((historyModel == null || (historyEntity3 = historyModel.getHistoryEntity()) == null || (address3 = historyEntity3.getAddress()) == null) ? null : address3.callingCode);
            }
            CommonInfoEntity.Contact contact5 = contractModel.getContact();
            CommonInfoEntity.PhoneNumber phoneNumber2 = contact5 == null ? null : contact5.getPhoneNumber();
            if (phoneNumber2 != null) {
                phoneNumber2.setPhoneNumber((historyModel == null || (historyEntity2 = historyModel.getHistoryEntity()) == null || (address2 = historyEntity2.getAddress()) == null) ? null : address2.phone);
            }
            CommonInfoEntity.Contact contact6 = contractModel.getContact();
            CommonInfoEntity.BuildingAddress buildingAddress = contact6 == null ? null : contact6.getBuildingAddress();
            if (buildingAddress != null) {
                if (!(historyModel == null || (historyEntity = historyModel.getHistoryEntity()) == null || (address = historyEntity.getAddress()) == null)) {
                    str = address.houseNumber;
                }
                buildingAddress.setBuildingAddress(str);
            }
            getComponentRepo().setReceiverValue(contractModel);
            getDataListManager().set(indexOf, contractModel);
        }
    }

    public void onPoiClick() {
        super.onPoiClick();
        InfoOmegaHelper.INSTANCE.trackReceiverToAddressListCK(getPageSource(), getEventSource());
        DiRouter.request().path("addressListPage").setFromPage(getScopeContext()).putInt("from", 4).open();
    }

    public void handleBack() {
        super.handleBack();
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        getScopeContext().getNavigator().finish();
    }

    public void onPageResult(Bundle bundle) {
        Unit unit = null;
        AddressEntity addressEntity = (AddressEntity) (bundle == null ? null : bundle.getSerializable("entity"));
        if (addressEntity != null) {
            setDataList(getContractModel(), new ReceiveContactUpdatePresenter$onPageResult$1$1(this, addressEntity));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LogUtil.m14765i(getTAG(), "onPageResult，address为null");
        }
    }

    public final void subscrib() {
        InfoRepo infoRepo = (InfoRepo) RepoFactory.getRepo(InfoRepo.class);
        infoRepo.subscribe(getScopeContext(), new ReceiveContactUpdatePresenter$subscrib$1(infoRepo, this));
        getHistoryListRepo().subscribe(getScopeContext(), new ReceiveContactUpdatePresenter$subscrib$2(this));
    }
}

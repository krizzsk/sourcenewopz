package com.didi.entrega.info.component.send;

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

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u001a\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010'\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006("}, mo175978d2 = {"Lcom/didi/entrega/info/component/send/SendContactUpdatePresenter;", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sendContactEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getSendContactEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setSendContactEntity", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "handleBack", "", "hideLoadingAbnormal", "infoAutoFill", "item", "Lcom/didi/entrega/info/model/HistoryModel;", "initContactModel", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "initUpdateBottomBtn", "initUpdateView", "onCallingClick", "callingCode", "countryId", "", "onCreate", "onHistoryItemClick", "onPageResult", "data", "Landroid/os/Bundle;", "onPoiClick", "requestHistoryList", "commonInfoEntity", "requestUpdateData", "showAbnormal", "msg", "subscrib", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
public final class SendContactUpdatePresenter extends ContactConstract.AbsEditContactPresenter {

    /* renamed from: a */
    private AddressEntity f20782a = new AddressEntity();

    /* renamed from: b */
    private final String f20783b = "SendContactUpdatePresenter";

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15203a(Void voidR) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15206b(Void voidR) {
    }

    public final AddressEntity getSendContactEntity() {
        return this.f20782a;
    }

    public final void setSendContactEntity(AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(addressEntity, "<set-?>");
        this.f20782a = addressEntity;
    }

    public final String getTAG() {
        return this.f20783b;
    }

    public void onCreate() {
        super.onCreate();
        initUpdateView();
        m15198a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15198a() {
        Unit unit;
        m15204b();
        ((ContactConstract.AbsEditContactView) getLogicView()).loadingAndHideBottomBtn();
        CommonInfoEntity commonInfoEntity = getComponentRepo().getCommonInfoEntity();
        if (commonInfoEntity == null) {
            unit = null;
        } else {
            m15199a(InfoDataHelper.INSTANCE.addUpdateData(commonInfoEntity));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CustomerRpcManagerProxy.get().getCommonInfo(new SendContactUpdatePresenter$requestUpdateData$2$1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15199a(CommonInfoEntity commonInfoEntity) {
        CustomerRpcManagerProxy.get().getHistoryContactList(new SendContactUpdatePresenter$requestHistoryList$1(this, commonInfoEntity));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15205b(CommonInfoEntity commonInfoEntity) {
        InfoStepConfig currentStepConfig = getCurrentStepConfig();
        if (currentStepConfig != null) {
            setContractModel(InfoDataHelper.INSTANCE.parseContactModel(commonInfoEntity, currentStepConfig.getCurrentStep()));
            ContactModel contractModel = getContractModel();
            if (contractModel != null) {
                contractModel.setContactType(1);
            }
            getComponentRepo().setSenderValue(getContractModel());
            ContactModel contractModel2 = getContractModel();
            if (contractModel2 != null) {
                getDataListManager().add(contractModel2);
            }
            InfoOmegaHelper.INSTANCE.trackContactCommonShow(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15204b() {
        ((ContactConstract.AbsEditContactView) getLogicView()).hideAbnormal();
        ((ContactConstract.AbsEditContactView) getLogicView()).hideLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15202a(String str) {
        InfoHeaderModel infoHeaderModel = getInfoHeaderModel();
        if (infoHeaderModel != null && getDataListManager().indexOf(infoHeaderModel) >= 0) {
            getDataListManager().remove(getDataListManager().indexOf(infoHeaderModel));
        }
        ((ContactConstract.AbsEditContactView) getLogicView()).showAbnormal(createAbnormalViewModel(str, new SendContactUpdatePresenter$showAbnormal$abnormalViewModel$1(this)));
        LogUtil.m14765i(this.f20783b, Intrinsics.stringPlus("异常页面展示：", str));
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
                SendContactUpdatePresenter.m15200a(SendContactUpdatePresenter.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15200a(SendContactUpdatePresenter sendContactUpdatePresenter, View view) {
        Intrinsics.checkNotNullParameter(sendContactUpdatePresenter, "this$0");
        sendContactUpdatePresenter.setSendContactEntity(InfoDataHelper.INSTANCE.convertContactModel2AddressEntity(sendContactUpdatePresenter.getComponentRepo().getSender()));
        InfoOmegaHelper.INSTANCE.trackConfirmCk(sendContactUpdatePresenter);
        if (!LocalizationUtils.isPhoneValida(sendContactUpdatePresenter.getSendContactEntity().phone, sendContactUpdatePresenter.getSendContactEntity().callingCode)) {
            ToastUtil.showCustomerToast(sendContactUpdatePresenter.getScopeContext(), ResourceHelper.getString(R.string.Entrega_Integration__fMdV));
            ErrorTracker.create(ErrorConst.ErrorName.CONTACT_PHONE_VALID_ERROR).addModuleName("info").addErrorType("1").addParam(ErrorConst.ErrorParam.USER_CALLING_CODE, sendContactUpdatePresenter.getSendContactEntity().callingCode).addParam(ErrorConst.ErrorParam.USER_PHONE, sendContactUpdatePresenter.getSendContactEntity().phone).build().trackError();
        } else if (sendContactUpdatePresenter.getEventSource() == 1) {
            ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).updateSendContact(sendContactUpdatePresenter.getSendContactEntity());
            BillConfigRepo billConfigRepo = (BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class);
            BillConfig value = billConfigRepo.getValue();
            value.setRequestBill(true);
            billConfigRepo.setValue(value);
            HashMap hashMap = new HashMap();
            String json = GsonUtil.toJson(sendContactUpdatePresenter.getSendContactEntity());
            Intrinsics.checkNotNullExpressionValue(json, "toJson(sendContactEntity)");
            hashMap.put(Const.BundleKey.INFO_PAGE_BILL_SEND, json);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap), $$Lambda$SendContactUpdatePresenter$93ZUFipLOrlur_r3M2KfMmaFhg.INSTANCE);
            BillExt.Companion companion = BillExt.Companion;
            int pageSource = sendContactUpdatePresenter.getPageSource();
            int eventSource = sendContactUpdatePresenter.getEventSource();
            ScopeContext scopeContext = sendContactUpdatePresenter.getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            boolean billNextBtnOpenPage = companion.billNextBtnOpenPage(pageSource, eventSource, scopeContext);
        } else {
            HashMap hashMap2 = new HashMap();
            String json2 = GsonUtil.toJson(sendContactUpdatePresenter.getSendContactEntity());
            Intrinsics.checkNotNullExpressionValue(json2, "toJson(sendContactEntity)");
            hashMap2.put(Const.BundleKey.INFO_PAGE_BILL_SEND, json2);
            ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap2), $$Lambda$SendContactUpdatePresenter$Bjmaqb1fdmCSMIA1O0z5EpdlEx0.INSTANCE);
            sendContactUpdatePresenter.getScopeContext().getNavigator().finish();
        }
    }

    public void onCallingClick(String str, int i) {
        CountryListDialog.show(getScopeContext(), (OnCountrySelectListener) new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                SendContactUpdatePresenter.m15201a(SendContactUpdatePresenter.this, str, i);
            }
        }, i, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15201a(SendContactUpdatePresenter sendContactUpdatePresenter, String str, int i) {
        int indexOf;
        Intrinsics.checkNotNullParameter(sendContactUpdatePresenter, "this$0");
        ContactModel contractModel = sendContactUpdatePresenter.getContractModel();
        if (contractModel != null && (indexOf = sendContactUpdatePresenter.getDataListManager().indexOf(sendContactUpdatePresenter.getContractModel())) >= 0) {
            CommonInfoEntity.Contact contact = contractModel.getContact();
            CommonInfoEntity.PhoneNumber phoneNumber = contact == null ? null : contact.getPhoneNumber();
            if (phoneNumber != null) {
                phoneNumber.setCallingCode(str);
            }
            sendContactUpdatePresenter.getComponentRepo().setSenderValue(contractModel);
            sendContactUpdatePresenter.getDataListManager().set(indexOf, contractModel);
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
        AddressEntity receiveContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getReceiveContact();
        if (receiveContact == null || !AddressUtil.checkAddressValid(receiveContact)) {
            d4 = 0.0d;
            d3 = 0.0d;
        } else {
            d4 = receiveContact.poi.lat;
            d3 = receiveContact.poi.lng;
        }
        CustomerRpcManagerProxy.get().checkAddress(d, d2, d4, d3, getFusionChannel(), getPageSource(), new SendContactUpdatePresenter$onHistoryItemClick$1(this, historyModel2));
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
            getComponentRepo().setSenderValue(contractModel);
            getDataListManager().set(indexOf, contractModel);
        }
    }

    public void onPoiClick() {
        super.onPoiClick();
        InfoOmegaHelper.INSTANCE.trackSenderToAddressListCK(getPageSource(), getEventSource());
        DiRouter.request().path("addressListPage").setFromPage(getScopeContext()).putInt("from", 3).open();
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
            setDataList(getContractModel(), new SendContactUpdatePresenter$onPageResult$1$1(this, addressEntity));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LogUtil.m14765i(getTAG(), "onPageResult，address为null");
        }
    }

    public final void subscrib() {
        InfoRepo infoRepo = (InfoRepo) RepoFactory.getRepo(InfoRepo.class);
        infoRepo.subscribe(getScopeContext(), new SendContactUpdatePresenter$subscrib$1(infoRepo, this));
        getHistoryListRepo().subscribe(getScopeContext(), new SendContactUpdatePresenter$subscrib$2(this));
    }
}

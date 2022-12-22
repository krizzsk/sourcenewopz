package com.didi.component.company;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.EstimateUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.view.GlobalCompanySelectActivity;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class NewCompanyPresenter extends AbsCompanyPresenter {

    /* renamed from: b */
    private static final int f12544b = 200;

    /* renamed from: a */
    private final int f12545a = 4097;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<Boolean> f12546c = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                NewCompanyPresenter.this.m8532a((TaxiCompanyListModel.CompanyModel) null);
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Boolean> f12547d = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                NewCompanyPresenter.this.m8536d();
            }
        }
    };

    /* renamed from: e */
    private boolean f12548e = false;

    public NewCompanyPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f12546c);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_CHANGE, this.f12547d);
        m8532a((TaxiCompanyListModel.CompanyModel) null);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f12546c);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_CHANGE, this.f12547d);
        if (this.mView != null) {
            ((ICompanyView) this.mView).clearTips();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8532a(TaxiCompanyListModel.CompanyModel companyModel) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.company != null && newEstimateItem.company.operationData != null) {
            String str = newEstimateItem.company.operationData.operationIcon;
            if (!TextUtils.isEmpty(newEstimateItem.company.iconUrl)) {
                str = newEstimateItem.company.iconUrl;
            }
            GlobalRichInfo globalRichInfo = newEstimateItem.company.operationData.operationText;
            if (newEstimateItem.company.selectedText != null && !TextUtils.isEmpty(newEstimateItem.company.selectedText.getContent())) {
                globalRichInfo = newEstimateItem.company.selectedText;
            }
            if (companyModel != null) {
                if (!TextUtil.isEmpty(companyModel.iconUrl)) {
                    str = companyModel.iconUrl;
                }
                if (!TextUtil.isEmpty(companyModel.name)) {
                    globalRichInfo.updateText(companyModel.name);
                }
                newEstimateItem.company.iconUrl = str;
                newEstimateItem.company.selectedText = globalRichInfo;
            }
            ((ICompanyView) this.mView).setIcon(str);
            ((ICompanyView) this.mView).bindRichInfo(globalRichInfo);
        }
    }

    /* renamed from: b */
    private void m8533b() {
        TaxiCompanyListModel.CompanyModel curCompany = FormStore.getInstance().getCurCompany();
        if (curCompany == null) {
            m8535c();
            return;
        }
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = curCompany.f44227id;
        companyInfo.companyName = curCompany.name;
        companyInfo.companyIconUrl = curCompany.iconUrl;
        companyInfo.companyDesc = curCompany.desc;
        ((ICompanyView) this.mView).setCompany(companyInfo);
    }

    /* renamed from: c */
    private void m8535c() {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = "0";
        companyInfo.companyName = ResourcesHelper.getString(this.mContext, R.string.global_company_name_any);
        ((ICompanyView) this.mView).setCompany(companyInfo);
    }

    public void showCompanySelectPage() {
        Address address;
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
            GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_company_ck", (Map<String, Object>) hashMap);
        }
        TaxiCompanyListModel.CompanyModel curCompany = FormStore.getInstance().getCurCompany();
        String str = curCompany != null ? curCompany.f44227id : null;
        if (FormStore.getInstance().getDepartureAddress() == null) {
            address = FormStore.getInstance().getStartAddress();
        } else {
            address = FormStore.getInstance().getDepartureAddress();
        }
        Intent intent = new Intent(getHost().getContext(), GlobalCompanySelectActivity.class);
        if (!TextUtil.isEmpty(str)) {
            intent.putExtra("company_id", str);
        }
        if (EstimateUtils.isFixedPricingTypeShowing()) {
            intent.putExtra(GlobalCompanySelectActivity.DATA_EXTRA_SHOW_DEFAULT, false);
        }
        if (address != null) {
            intent.putExtra(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, address.getLatitude());
            intent.putExtra(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, address.getLongitude());
        }
        startActivityForResult(intent, 200);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 200 && i2 == -1) {
            Serializable serializableExtra = intent.getSerializableExtra(GlobalCompanySelectActivity.DATA_EXTRA_SELECTED_COMPANY_INFO);
            if (serializableExtra != null && (serializableExtra instanceof TaxiCompanyListModel.CompanyModel)) {
                m8534b((TaxiCompanyListModel.CompanyModel) serializableExtra);
            }
        } else if (i == 200) {
            FormStore.getInstance().setSkipEstimateGet(true);
        }
    }

    /* renamed from: b */
    private void m8534b(TaxiCompanyListModel.CompanyModel companyModel) {
        if (companyModel != null) {
            FormStore.getInstance().setCurCompany(companyModel);
            m8532a(companyModel);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_COMPANY_CHANGED);
            FormStore.getInstance().setSkipEstimateGet(true);
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.company != null) {
                newEstimateItem.company.companyModel = companyModel;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8536d() {
        FormStore.getInstance().setCurCompany((TaxiCompanyListModel.CompanyModel) null);
        m8532a((TaxiCompanyListModel.CompanyModel) null);
    }
}

package com.didi.component.company.select.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.EstimateUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.view.CompanyEmptyPopupWindow;
import com.didi.component.company.select.view.GlobalCompanySelectActivity;
import com.didi.component.company.select.view.ICompanySelectView;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalCompanySelectPresenter implements ICompanySelectPresenter {

    /* renamed from: a */
    Runnable f12555a = new Runnable() {
        public void run() {
            GlobalCompanySelectPresenter.this.f12556b.finish();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FragmentActivity f12556b;

    /* renamed from: c */
    private ICompanySelectView f12557c;

    /* renamed from: d */
    private String f12558d = "0";

    /* renamed from: e */
    private double f12559e;

    /* renamed from: f */
    private double f12560f;

    /* renamed from: g */
    private List<CompanyInfo> f12561g;

    /* renamed from: h */
    private boolean f12562h;

    public GlobalCompanySelectPresenter(FragmentActivity fragmentActivity) {
        this.f12556b = fragmentActivity;
    }

    public void setView(ICompanySelectView iCompanySelectView) {
        this.f12557c = iCompanySelectView;
    }

    public void onAdd(Bundle bundle) {
        init(bundle);
        if ((GlobalSPUtil.getCompChooseTipsDisplayCount(this.f12556b) & 3) > 0) {
            GlobalSPUtil.setCompChooseTipsDisplayCount(this.f12556b, 1);
        }
    }

    public void init(Bundle bundle) {
        if (bundle != null) {
            this.f12558d = bundle.getString("company_id", "0");
            this.f12559e = bundle.getDouble(GlobalCompanySelectActivity.DATA_EXTRA_START_LAT, 0.0d);
            this.f12560f = bundle.getDouble(GlobalCompanySelectActivity.DATA_EXTRA_START_LNG, 0.0d);
            boolean z = bundle.getBoolean(GlobalCompanySelectActivity.DATA_EXTRA_SHOW_DEFAULT, true);
            this.f12562h = z;
            this.f12557c.showDefault(z);
        }
        GlobalOmegaUtils.trackEvent("CompanySelect_Enter");
        m8541a();
    }

    /* renamed from: a */
    private void m8541a() {
        C52491 r5 = new ResponseListener<TaxiCompanyListModel>() {
            public void onFinish(TaxiCompanyListModel taxiCompanyListModel) {
                GlobalCompanySelectPresenter.this.m8543a(taxiCompanyListModel);
            }
        };
        this.f12557c.showLoading();
        CarRequest.getTaxiCompanyListInfo(this.f12556b, this.f12559e, this.f12560f, r5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8543a(TaxiCompanyListModel taxiCompanyListModel) {
        this.f12557c.hideLoading();
        ArrayList<CompanyInfo> arrayList = new ArrayList<>();
        CompanyInfo a = m8538a(taxiCompanyListModel.multiDesc);
        arrayList.add(a);
        CompanyInfo b = m8545b(taxiCompanyListModel);
        if (b != null) {
            arrayList.add(b);
        }
        if (taxiCompanyListModel != null && taxiCompanyListModel.isAvailable()) {
            if (!CollectionUtils.isEmpty((Collection) taxiCompanyListModel.list)) {
                arrayList.addAll(m8540a(taxiCompanyListModel.list));
                if (b != null) {
                    a = b;
                }
                a.extend = taxiCompanyListModel.listDesc;
            } else if (a != null) {
                a.extend = null;
            }
        }
        for (CompanyInfo companyInfo : arrayList) {
            if (m8544a(taxiCompanyListModel, companyInfo.companyId)) {
                companyInfo.isPickupSvrFree = true;
            }
        }
        this.f12561g = arrayList;
        if (taxiCompanyListModel != null && !CollectionUtils.isEmpty((Collection) taxiCompanyListModel.list)) {
            this.f12557c.showCompanys(arrayList, this.f12558d);
        } else if (!this.f12562h) {
            m8546b();
        } else {
            m8547c();
        }
    }

    /* renamed from: a */
    private boolean m8544a(TaxiCompanyListModel taxiCompanyListModel, String str) {
        if (!CollectionUtil.isEmpty((Collection<?>) taxiCompanyListModel.comp4FreePickup)) {
            return taxiCompanyListModel.comp4FreePickup.contains(str);
        }
        return false;
    }

    /* renamed from: a */
    private CompanyInfo m8538a(String str) {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = "0";
        companyInfo.companyName = ResourcesHelper.getString(this.f12556b, R.string.global_company_name_any);
        companyInfo.companyDesc = ResourcesHelper.getString(this.f12556b, R.string.global_company_any_desc);
        if (!TextUtil.isEmpty(str)) {
            companyInfo.extendTop = str;
        }
        return companyInfo;
    }

    /* renamed from: b */
    private CompanyInfo m8545b(TaxiCompanyListModel taxiCompanyListModel) {
        if (taxiCompanyListModel.comp4freeOption == null) {
            return null;
        }
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.companyId = "1";
        companyInfo.companyName = taxiCompanyListModel.comp4freeOption.name;
        companyInfo.companyDesc = taxiCompanyListModel.comp4freeOption.desc;
        companyInfo.companyIconUrl = taxiCompanyListModel.comp4freeOption.logo;
        if (!CollectionUtil.isEmpty((Collection<?>) taxiCompanyListModel.comp4FreePickup)) {
            companyInfo.childCids = new ArrayList();
            companyInfo.childCids.addAll(taxiCompanyListModel.comp4FreePickup);
        }
        return companyInfo;
    }

    /* renamed from: a */
    private List<CompanyInfo> m8540a(List<TaxiCompanyListModel.CompanyModel> list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty((Collection) list)) {
            return arrayList;
        }
        for (TaxiCompanyListModel.CompanyModel next : list) {
            CompanyInfo companyInfo = new CompanyInfo();
            companyInfo.companyId = next.f44227id;
            companyInfo.companyIconUrl = next.iconUrl;
            companyInfo.companyName = next.name;
            companyInfo.companyDesc = !TextUtils.isEmpty(next.desc) ? next.desc : next.extraFeeDesc;
            arrayList.add(companyInfo);
        }
        return arrayList;
    }

    /* renamed from: a */
    private TaxiCompanyListModel.CompanyModel m8539a(CompanyInfo companyInfo) {
        if (companyInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(companyInfo.companyId)) {
            return companyInfo.toCompanyModel();
        }
        int i = 0;
        while (true) {
            if (i >= CollectionUtil.size((Collection<?>) this.f12561g)) {
                break;
            }
            CompanyInfo companyInfo2 = this.f12561g.get(i);
            if (companyInfo.companyId.equalsIgnoreCase(companyInfo2.companyId) && companyInfo2.childCids != null) {
                companyInfo.childCids = companyInfo2.childCids;
                break;
            }
            i++;
        }
        return companyInfo.toCompanyModel();
    }

    public void onCompanySelected(CompanyInfo companyInfo) {
        String str;
        Intent intent = new Intent();
        intent.putExtra(GlobalCompanySelectActivity.DATA_EXTRA_SELECTED_COMPANY_INFO, m8539a(companyInfo));
        this.f12556b.setResult(-1, intent);
        String str2 = companyInfo.companyId;
        this.f12558d = str2;
        this.f12557c.showCompanys(this.f12561g, str2);
        UiThreadHandler.post(this.f12555a);
        if ("0".equals(this.f12558d)) {
            str = "All";
        } else {
            str = "1".equals(this.f12558d) ? "nopickupfeegroup" : this.f12558d;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("CompanyChoice", str);
        hashMap.put(ServerParam.PARAM_ORDER_TYPE, Integer.valueOf(EstimateUtils.isFixedPricingTypeShowing() ? 1 : 0));
        GlobalOmegaUtils.trackEvent("CompanySelect_SelectSomeone", (Map<String, Object>) hashMap);
    }

    public void onRemove() {
        UiThreadHandler.removeCallbacks(this.f12555a);
    }

    /* renamed from: b */
    private void m8546b() {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.f12556b);
        builder.setCancelable(false);
        builder.setIconVisible(true);
        builder.setCloseVisible(false);
        builder.setSupprtMullineTitle(true);
        C52513 r1 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCompanySelectPresenter.this.f12556b.finish();
            }
        };
        builder.setIcon(AlertController.IconType.INFO);
        builder.setMessage(ResourcesHelper.getString(this.f12556b, R.string.global_company_empty_dialog_content));
        builder.setPositiveButton((int) R.string.confirm, (View.OnClickListener) r1);
        builder.setPositiveButtonDefault();
        AlertDialogFragment create = builder.create();
        if (create != null) {
            create.show(this.f12556b.getSupportFragmentManager(), (String) null);
        }
    }

    /* renamed from: c */
    private void m8547c() {
        FragmentActivity fragmentActivity = this.f12556b;
        if (!(fragmentActivity instanceof Activity)) {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            CompanyEmptyPopupWindow companyEmptyPopupWindow = new CompanyEmptyPopupWindow(this.f12556b);
            if (!companyEmptyPopupWindow.isShowing()) {
                companyEmptyPopupWindow.show();
            }
        }
    }
}

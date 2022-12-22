package com.didi.soda.security;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.pay.BindCardHelper;
import com.didi.soda.pay.PayOmegaHelper;
import com.didi.soda.security.Contract;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.facebook.internal.CallbackManagerImpl;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecurityPresenter extends Contract.AbsSecurityPresenter {

    /* renamed from: a */
    private List<SecurityMethodModel> f43813a;

    /* renamed from: b */
    private ChildDataListManager f43814b;

    public void initDataManagers() {
        super.initDataManagers();
        ArrayList<Integer> integerArrayList = (getScopeContext().getBundle() == null || getScopeContext().getBundle().getBundle("bundle") == null) ? null : getScopeContext().getBundle().getBundle("bundle").getIntegerArrayList("securitylist");
        String string = getScopeContext().getBundle() != null ? getScopeContext().getBundle().getString("cart_id") : "";
        this.f43813a = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Integer next : integerArrayList) {
            if (next.intValue() == 41059 || next.intValue() == 41056 || next.intValue() == 41058 || next.intValue() == 41057) {
                SecurityMethodModel securityMethodModel = new SecurityMethodModel();
                securityMethodModel.code = next.intValue();
                securityMethodModel.cid = string;
                securityMethodModel.isEnable = true;
                this.f43813a.add(securityMethodModel);
                hashMap.put(String.valueOf(next), Integer.valueOf(securityMethodModel.isEnable ? 1 : 0));
            }
        }
        BillOmegaHelper.Companion.showSecurityPage(string, GsonUtil.toJson(hashMap));
        ChildDataListManager<T> createChildDataListManager = createChildDataListManager(this.f43813a);
        this.f43814b = createChildDataListManager;
        addDataManager(createChildDataListManager);
    }

    public void onCreate() {
        super.onCreate();
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(getScopeContext(), new Action1<CustomerActivityResultRepo.ActivityResult>() {
            public void call(CustomerActivityResultRepo.ActivityResult activityResult) {
                DialogUtil.hideLoadingDialog();
                if (activityResult != null) {
                    if (activityResult.requestCode == 1 && activityResult.resultCode == -1) {
                        ToastUtil.showCustomerSuccessToast(SecurityPresenter.this.getScopeContext(), SecurityPresenter.this.getContext().getResources().getString(R.string.customer_security_success_title));
                        PayOmegaHelper.bindCardResult(activityResult, ErrorConst.ModuleName.SECURITY);
                        SecurityPresenter.this.getScopeContext().getNavigator().finish();
                        return;
                    }
                    ((Contract.AbsSecurityView) SecurityPresenter.this.getLogicView()).onActivityResult(activityResult.requestCode, activityResult.resultCode, activityResult.data);
                }
            }
        }, 1, CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    }

    /* access modifiers changed from: package-private */
    public boolean hasEnable() {
        for (SecurityMethodModel securityMethodModel : this.f43813a) {
            if (securityMethodModel.isEnable) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void disable(int i) {
        for (SecurityMethodModel next : this.f43813a) {
            if (next.code == i) {
                int indexOf = this.f43814b.indexOf(next);
                next.isEnable = false;
                this.f43814b.set(indexOf, next);
            }
        }
        HashMap hashMap = new HashMap();
        for (SecurityMethodModel next2 : this.f43813a) {
            String str = next2.cid;
            hashMap.put(String.valueOf(next2.code), Integer.valueOf(next2.isEnable ? 1 : 0));
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyCurp() {
        if (!TextUtils.isEmpty("https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2")) {
            WebConfig webConfig = new WebConfig();
            webConfig.url = ParamsHelper.addH5CommonParams("https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2");
            webConfig.url = Uri.parse(webConfig.url).buildUpon().appendQueryParameter("token", LoginUtil.getToken()).appendQueryParameter("appversion", SystemUtil.getVersionName(getContext())).build().toString();
            webConfig.isSupportCache = false;
            webConfig.mCustomerParameters.put("product_id", AppConst.BUSINESS_ID);
            CustomerWebPage customerWebPage = new CustomerWebPage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WebConstant.WEB_MODEL, webConfig);
            bundle.putBoolean("backbuttonshow", true);
            customerWebPage.setArgs(bundle);
            getScopeContext().getNavigator().pushForResult(customerWebPage);
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyCpf() {
        if (!TextUtils.isEmpty("https://food-c-h5.99app.com/${locale}/cart/cpf-check")) {
            WebConfig webConfig = new WebConfig();
            webConfig.url = ParamsHelper.addH5CommonParams("https://food-c-h5.99app.com/${locale}/cart/cpf-check");
            webConfig.isSupportCache = false;
            CustomerWebPage customerWebPage = new CustomerWebPage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WebConstant.WEB_MODEL, webConfig);
            bundle.putBoolean("backbuttonshow", true);
            customerWebPage.setArgs(bundle);
            getScopeContext().getNavigator().pushForResult(customerWebPage);
        }
    }

    /* access modifiers changed from: package-private */
    public void bindCard() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        addCardParam.isShowLoading = false;
        BindCardHelper.bindCard(addCardParam, 1);
    }
}

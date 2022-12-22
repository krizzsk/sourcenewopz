package com.didi.entrega.security;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.p113h5.CustomerWebPage;
import com.didi.entrega.customer.pay.BindCardHelper;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.security.Contract;
import com.didi.entrega.security.model.SecurityMethodModel;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/entrega/security/SecurityPresenter;", "Lcom/didi/entrega/security/Contract$AbsSecurityPresenter;", "()V", "mListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "mSecurityMethodList", "", "bindCard", "", "disable", "id", "", "hasEnable", "", "initDataManagers", "onCreate", "verifyCpf", "verifyCurp", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SecurityPresenter.kt */
public final class SecurityPresenter extends Contract.AbsSecurityPresenter {

    /* renamed from: a */
    private List<SecurityMethodModel> f21046a;

    /* renamed from: b */
    private ChildDataListManager<SecurityMethodModel> f21047b;

    public void initDataManagers() {
        ArrayList<Integer> arrayList;
        super.initDataManagers();
        Bundle bundle = getScopeContext().getBundle();
        Bundle bundle2 = bundle.getBundle("bundle");
        ChildDataListManager<SecurityMethodModel> childDataListManager = null;
        if (bundle2 == null) {
            arrayList = null;
        } else {
            arrayList = bundle2.getIntegerArrayList("securitylist");
        }
        String string = bundle.getString(Const.BundleKey.CART_ID);
        this.f21046a = new ArrayList();
        List<Number> list = arrayList;
        if (list != null) {
            for (Number intValue : list) {
                int intValue2 = intValue.intValue();
                switch (intValue2) {
                    case 41056:
                    case 41057:
                    case 41058:
                    case 41059:
                        SecurityMethodModel securityMethodModel = new SecurityMethodModel();
                        securityMethodModel.setCode(intValue2);
                        securityMethodModel.setCid(string);
                        securityMethodModel.setEnable(true);
                        List<SecurityMethodModel> list2 = this.f21046a;
                        if (list2 != null) {
                            list2.add(securityMethodModel);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        ChildDataListManager<SecurityMethodModel> createChildDataListManager = createChildDataListManager(this.f21046a);
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManag…del>(mSecurityMethodList)");
        this.f21047b = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListManager");
        } else {
            childDataListManager = createChildDataListManager;
        }
        addDataManager(childDataListManager);
    }

    public void onCreate() {
        super.onCreate();
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(getScopeContext(), new SecurityPresenter$onCreate$1(this), 1);
    }

    public boolean hasEnable() {
        List<SecurityMethodModel> list = this.f21046a;
        if (list == null) {
            return false;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (((SecurityMethodModel) next).isEnable()) {
                arrayList.add(next);
            }
        }
        if (!((List) arrayList).isEmpty()) {
            return true;
        }
        return false;
    }

    public void disable(int i) {
        List<SecurityMethodModel> list = this.f21046a;
        if (list != null) {
            for (SecurityMethodModel securityMethodModel : list) {
                if (securityMethodModel.getCode() == i) {
                    ChildDataListManager<SecurityMethodModel> childDataListManager = this.f21047b;
                    ChildDataListManager<SecurityMethodModel> childDataListManager2 = null;
                    if (childDataListManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mListManager");
                        childDataListManager = null;
                    }
                    int indexOf = childDataListManager.indexOf(securityMethodModel);
                    securityMethodModel.setEnable(false);
                    ChildDataListManager<SecurityMethodModel> childDataListManager3 = this.f21047b;
                    if (childDataListManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mListManager");
                    } else {
                        childDataListManager2 = childDataListManager3;
                    }
                    childDataListManager2.set(indexOf, securityMethodModel);
                }
            }
        }
    }

    public void verifyCurp() {
        if (!TextUtils.isEmpty("https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2")) {
            WebConfig webConfig = new WebConfig();
            webConfig.url = ParamsHelper.addH5CommonParams("https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2");
            webConfig.url = Uri.parse(webConfig.url).buildUpon().appendQueryParameter("token", LoginUtil.getToken()).appendQueryParameter("appversion", SystemUtil.getVersionName(getContext())).build().toString();
            webConfig.isSupportCache = false;
            HashMap<String, String> hashMap = webConfig.mCustomerParameters;
            Intrinsics.checkNotNullExpressionValue(hashMap, "webConfig.mCustomerParameters");
            hashMap.put("product_id", AppConst.BUSINESS_ID);
            CustomerWebPage customerWebPage = new CustomerWebPage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WebConstant.WEB_MODEL, webConfig);
            bundle.putBoolean("backbuttonshow", true);
            customerWebPage.setArgs(bundle);
            getScopeContext().getNavigator().pushForResult(customerWebPage);
        }
    }

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

    public void bindCard() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        addCardParam.isShowLoading = false;
        BindCardHelper.bindCard(addCardParam, 1);
    }
}

package com.didi.component.evaluate.presenter.impl;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.common.dialog.LoadingDialogInfo;
import com.didi.component.config.BusinessRegistry;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.sdk.sidebar.history.manager.JPInvoiceManager;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.model.response.CommentOnPanel;
import com.taxis99.R;
import java.util.ArrayList;

public class HomeEvaluatePresenter extends CommonEvaluatePresenter {

    /* renamed from: a */
    private static final int f13319a = 200;

    /* renamed from: b */
    private static final int f13320b = 20049;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f13321c = false;

    /* renamed from: d */
    private String f13322d;

    /* renamed from: e */
    private JPInvoiceManager f13323e;

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<Boolean> f13324f = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE);
            if (bool != null) {
                boolean unused = HomeEvaluatePresenter.this.f13321c = bool.booleanValue();
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getOrderSource() {
        return 2;
    }

    public HomeEvaluatePresenter(ComponentParams componentParams) {
        super(componentParams);
        CommentOnPanel commentOnPanel = (CommentOnPanel) componentParams.getExtra(BaseExtras.Home.EXTRAS_UNEVALUATED_COMMENT_DATA);
        if (commentOnPanel == null || commentOnPanel.orderInfo == null) {
            this.f13322d = componentParams.psid;
        } else {
            this.f13322d = BusinessRegistry.bid2ParentSid(commentOnPanel.orderInfo.productId);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE, this.f13324f);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EndService.EVENT_BACK_TO_HOME_FROM_END_SERVICE, this.f13324f);
    }

    /* access modifiers changed from: protected */
    public boolean isNeedShowThePlayStoreDialog() {
        return this.f13321c;
    }

    /* access modifiers changed from: protected */
    public int getDefaultDriverIconRes() {
        if (GlobalComponentConfig.JAPAN_COMMON.equals(this.f13322d)) {
            return R.drawable.global_evaluate_jpn_default_driver_icon;
        }
        return super.getDefaultDriverIconRes();
    }

    public void onTagSelected(EvaluateTag evaluateTag, boolean z) {
        if (evaluateTag != null && z && evaluateTag.getId() == 20049 && GlobalComponentConfig.JAPAN_COMMON.equals(this.f13322d)) {
            if (this.f13323e == null) {
                this.f13323e = new JPInvoiceManager(this.mContext, new JPInvoiceManager.ICallback() {
                    public void showLoading() {
                        HomeEvaluatePresenter.this.m9124b();
                    }

                    public void onSuccess() {
                        ToastHelper.showShortCompleted(HomeEvaluatePresenter.this.mContext, HomeEvaluatePresenter.this.mContext.getString(R.string.history_email_send_ok));
                    }

                    public void onFail() {
                        ToastHelper.showShortInfo(HomeEvaluatePresenter.this.mContext, HomeEvaluatePresenter.this.mContext.getString(R.string.history_email_send_fail));
                    }

                    public void hideLoading() {
                        HomeEvaluatePresenter.this.m9126c();
                    }
                }, 1);
            }
            InvoiceOrder invoiceOrder = new InvoiceOrder();
            invoiceOrder.orderEncode = this.mEvaluateModel.getOid();
            invoiceOrder.productid = this.mEvaluateModel.getProductId();
            invoiceOrder.countryCode = BusinessUtils.getCountryIsoCode(this.mBusinessContext);
            ArrayList arrayList = new ArrayList();
            arrayList.add(invoiceOrder);
            this.f13323e.sendJPInvoice(getHost().getFragmentManager(), arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9124b() {
        LoadingDialogInfo loadingDialogInfo = new LoadingDialogInfo(200);
        loadingDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.loading));
        loadingDialogInfo.setCancelable(false);
        showDialog(loadingDialogInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9126c() {
        dismissDialog(200);
    }

    public boolean isShowTagInFlow() {
        return GlobalComponentConfig.JAPAN_COMMON.equals(this.f13322d);
    }
}

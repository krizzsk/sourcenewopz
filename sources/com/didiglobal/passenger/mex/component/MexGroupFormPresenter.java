package com.didiglobal.passenger.mex.component;

import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.core.ComponentParams;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.sdk.view.dialog.AlertController;
import com.taxis99.R;

public class MexGroupFormPresenter extends AbsGroupFormPresenter {

    /* renamed from: b */
    private static final int f50301b = 3001;

    /* renamed from: a */
    private boolean f50302a = false;

    public MexGroupFormPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onConfirmPriceIntercept() {
        if (BusinessDataUtil.isPriceValid(FormStore.getInstance().getNewEstimateItem()) || m36230b()) {
            super.onConfirmPriceIntercept();
            return;
        }
        m36231c();
        m36229a(true);
    }

    /* renamed from: b */
    private boolean m36230b() {
        return this.f50302a;
    }

    /* renamed from: a */
    private void m36229a(boolean z) {
        this.f50302a = z;
    }

    /* renamed from: c */
    private void m36231c() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(3001);
        normalDialogInfo.setIcon(AlertController.IconType.INFO);
        normalDialogInfo.setMessage(this.mContext.getResources().getString(R.string.global_estimate_get_price_fail_title));
        normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.global_estimate_get_price_fail_continue));
        normalDialogInfo.setNegativeText(this.mContext.getResources().getString(R.string.global_estimate_get_price_fail_back));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i != 3001) {
            return;
        }
        if (i2 == 1) {
            dismissDialog(3001);
        } else if (i2 == 2) {
            super.onConfirmPriceIntercept();
        }
    }
}

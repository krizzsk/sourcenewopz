package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.app.ActivityStack;
import com.didi.travel.psnger.model.response.CarOrder;

public class EndSafeToolkitPresenter extends AbsSafeToolkitPresenter {

    /* renamed from: a */
    private ActivityStack.OnStackChangedAdapter f15401a = new ActivityStack.OnStackChangedAdapter() {
        public void onAppResume() {
            super.onAppResume();
            if (EndSafeToolkitPresenter.this.refreshVisibility()) {
                EndSafeToolkitPresenter.this.requestSafeToolkitStatus();
            }
        }
    };

    public EndSafeToolkitPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (refreshVisibility()) {
            requestSafeToolkitStatus();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public boolean refreshVisibility() {
        boolean sFIsReportingPolice = GlobalSPUtil.getSFIsReportingPolice(this.mContext);
        GLog.m7971i("refreshVisibility", "isReporting:" + sFIsReportingPolice);
        if (sFIsReportingPolice) {
            ((ISafeToolkitView) this.mView).setVisibility(true);
            return true;
        }
        boolean sFHavePassedOrderRecent = GlobalSPUtil.getSFHavePassedOrderRecent(this.mContext);
        GLog.m7971i("refreshVisibility", " isHavePassedOrder:" + sFHavePassedOrderRecent);
        ((ISafeToolkitView) this.mView).setVisibility(sFHavePassedOrderRecent);
        return sFHavePassedOrderRecent;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        CarOrder order = CarOrderHelper.getOrder();
        SafeToolKit.getIns().startToolkitDialog((FragmentActivity) this.mContext, false, order != null ? order.oid : "", this.mSafeToolkitBean != null ? this.mSafeToolkitBean.sfViewMenuModelList : null);
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
        ActivityStack.addStackChangedListener(this.f15401a);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
        ActivityStack.removeStackChangedListener(this.f15401a);
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }
}

package com.component.android.comp_location.newpresenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.component.android.comp_location.IGlobalLocationView;
import com.component.android.comp_location.presenter.GlobalConfirmLocationPresenter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.taxis99.R;

public class GlobalConfirmLocationNewPresenter extends GlobalConfirmLocationPresenter {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<Boolean> f3291a = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue() && TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str)) {
                GlobalConfirmLocationNewPresenter.this.onResetOverviewState(false);
            } else if (bool.booleanValue() && TextUtils.equals(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, str)) {
                GlobalConfirmLocationNewPresenter.this.onResetOverviewState(false);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getCarpoolNormalIcon() {
        return R.drawable.global_carpool_overview_new_normal;
    }

    public GlobalConfirmLocationNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f3291a);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f3291a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f3291a);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f3291a);
    }

    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            this.mDefaultBottom = i;
            onXPanelScrollChanged(this.mDefaultBottom);
            if (this.isInConfirmPricePage) {
                doBestView();
                return;
            }
            this.mInitBestViewHandler.removeCallbacksAndMessages((Object) null);
            this.mInitBestViewHandler.sendEmptyMessageDelayed(0, 300);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_carpool_overview_btn) {
            if (this.isCarpoolOverviewState) {
                ((IGlobalLocationView) this.mView).setOverviewIcon(getCarpoolNormalIcon());
            } else {
                ((IGlobalLocationView) this.mView).setOverviewIcon(R.drawable.global_carpool_overview_new_light);
            }
            this.isCarpoolOverviewState = !this.isCarpoolOverviewState;
            doPublish(BaseEventKeys.CarPool.EVENT_CAR_POOL_MAPFLOW_OVERVIEW_SWITCH, Boolean.valueOf(this.isCarpoolOverviewState));
            return;
        }
        super.onClick(view);
    }
}
